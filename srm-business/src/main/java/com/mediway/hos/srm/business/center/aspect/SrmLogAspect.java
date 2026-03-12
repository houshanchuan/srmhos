package com.mediway.hos.srm.business.center.aspect;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mediway.hos.app.core.util.SecurityUtils;
import com.mediway.hos.common.util.StringUtil;
import com.mediway.hos.security.core.userdetails.HosUser;
import com.mediway.hos.srm.business.center.model.entity.log.SrmLog;
import com.mediway.hos.srm.business.center.service.log.SrmLogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Aspect
@Component
@Slf4j
public class SrmLogAspect {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private SrmLogService srmLogService;
    private final ThreadLocal<Object> originalDataThreadLocal = new ThreadLocal<>();

    // 前置通知：在方法执行前查询原始数据
    @Before("@annotation(dataChangeLog)")
    public void before(JoinPoint joinPoint,DataChangeLog dataChangeLog) {
        try {
            HashMap map=new HashMap();
            Object[] args = joinPoint.getArgs();
            if (args == null || args.length == 0) {
                return;
            }
            String params=JSONObject.toJSONString(args[0]);
            JSONObject paramJson=JSONObject.parseObject(params);
            String rowId=paramJson.getString("rowId");
            if(StringUtil.isBlank(rowId)){
                JSONArray array =paramJson.getJSONArray("idList");
                if(array!=null){
                    rowId=array.getString(0);
                    map.put("type","delete");
                    map.put("id",rowId);
                    Object originalData = queryOriginalData(rowId, dataChangeLog);
                    map.put("originalData",originalData);
                }else{
                    map.put("type","insert");
                    map.put("originalData",args[0]);
                }
            }else{
                map.put("type","update");
                map.put("id",rowId);
                Object originalData = queryOriginalData(rowId, dataChangeLog);
                map.put("originalData",originalData);
            }
            originalDataThreadLocal.set(map);
        } catch (Exception e) {
            log.error("获取原始数据失败", e);
            originalDataThreadLocal.remove();
        }
    }
    // 异常通知：清除ThreadLocal
    @AfterThrowing(pointcut = "@annotation(dataChangeLog)", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, DataChangeLog dataChangeLog, Exception ex) {
        originalDataThreadLocal.remove();
        log.error("方法执行异常: {}", ex.getMessage());
    }
    // 返回通知：在方法执行后记录数据变更
    @AfterReturning(pointcut = "@annotation(dataChangeLog)", returning = "result")
    public void afterReturning(JoinPoint joinPoint, DataChangeLog dataChangeLog, Object result) {
        String operType="update";
        String deviceType="";
        try {
            String clientIp ="";
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (attributes != null) {
                HttpServletRequest request = attributes.getRequest();
                clientIp = getClientIp(request);
                deviceType = getDeviceType(request);
            }
            // 获取原始数据
            Object oriObject=originalDataThreadLocal.get();
            Map<String,Object> originalMap=(Map<String, Object>) oriObject;
            Object originalData = null;
            if(originalMap.get("originalData")!=null)
                originalData=originalMap.get("originalData");
            operType=originalMap.get("type").toString();
            originalDataThreadLocal.remove(); // 清除ThreadLocal


            String id=null;
            if(originalMap.get("id")!=null){
                id=originalMap.get("id").toString();
            }

            Object updatedData = this.queryOriginalData(id,dataChangeLog);
            List<FieldChange> changes = compareObjects(originalData, updatedData);
            if (operType.equals("update")&&changes.isEmpty()) {
                return;
            }
            HosUser hosUser = SecurityUtils.getLoginUser();
            SrmLog srmLog=new SrmLog();
            srmLog.setIp(clientIp);
            srmLog.setType(operType);
            srmLog.setCreateTime(LocalDateTime.now());
            srmLog.setCreateBy(hosUser.getAccountCode());
            srmLog.setMethodName(joinPoint.getSignature().getName());
            srmLog.setEntityCode(joinPoint.getTarget().getClass().getName());

            srmLog.setTableName(dataChangeLog.tableName());
            srmLog.setDeviceType(deviceType);
            srmLog.setBussinessId(dataChangeLog.sysNo());
            String difData=null;
            if(operType.equals("insert")){
                difData=JSONObject.toJSONString(originalData);
            }else if(operType.equals("delete")){
                difData=JSONObject.toJSONString(originalData);
            }else{
                difData = changes.stream()
                        .map(change -> change.getFieldName() + ": " + change.getOldValue() + " → " + change.getNewValue())
                        .collect(Collectors.joining("; "));

            }
            srmLog.setTitle(dataChangeLog.title());
            srmLog.setDifData(difData);
            srmLogService.save(srmLog);
            log.info("记录数据变更: {}", changes);
        } catch (Exception e) {
            log.error("记录数据变更失败", e);
        }
    }



    // 查询原始数据
    private Map<String,Object> queryOriginalData(Object id, DataChangeLog dataChangeLog) {
        String tableName = dataChangeLog.tableName();
        String idField = "id";
        try {
            String sql = "SELECT * FROM " + tableName + " WHERE id = ?";
            return jdbcTemplate.queryForMap(sql, id);
        } catch (EmptyResultDataAccessException e) {
            log.warn("未找到原始数据: {}", id);
            return null;
        }
    }


    // 对比两个对象的差异
    private List<FieldChange> compareObjects(Object original1,Object updated1) {
        List<FieldChange> changes = new ArrayList<>();
        if (original1 == null || updated1 == null) {
            return changes;
        }
        Map<String,Object> original=(Map<String,Object>)original1;
        Map<String,Object> updated=(Map<String,Object>)updated1;
        Set<String> keySet = original.keySet();
        for (String key : keySet) {
            try {
                Object oldValue = original.get(key);
                Object newValue = updated.get(key);
                if (!Objects.equals(oldValue, newValue)) {
                    changes.add(new FieldChange(
                            key,
                            oldValue != null ? oldValue.toString() : null,
                            newValue != null ? newValue.toString() : null
                    ));
                }
            } catch (Exception e) {
                log.error("对比字段失败: {}", key, e);
            }
        }

        return changes;
    }

    public static String getClientIp(HttpServletRequest request) {
        // 优先从请求头中获取
        List<String> IP_HEADER_NAMES = Arrays.asList(
                "X-Forwarded-For",
                "Proxy-Client-IP",
                "WL-Proxy-Client-IP",
                "HTTP_CLIENT_IP",
                "HTTP_X_FORWARDED_FOR"
        );
        for (String headerName : IP_HEADER_NAMES) {
            String ipList = request.getHeader(headerName);
            if (ipList != null && ipList.length() != 0 && !"unknown".equalsIgnoreCase(ipList)) {
                // 多个IP时取第一个（真实客户端IP）
                return ipList.split(",")[0].trim();
            }
        }

        // 若请求头中没有，则获取RemoteAddr
        return request.getRemoteAddr();
    }


    public static String getDeviceType(HttpServletRequest request) {
        Pattern MOBILE_PATTERN = Pattern.compile(
                "Android|webOS|iPhone|iPad|iPod|BlackBerry|Windows Phone|Opera Mini|Mobile",
                Pattern.CASE_INSENSITIVE
        );
        String userAgent = request.getHeader("User-Agent");
        if (userAgent == null) {
            return "PC";
        }
        if(MOBILE_PATTERN.matcher(userAgent).find()) {
            return userAgent;
        }else {
            return "PC";
        }

    }
}