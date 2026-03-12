package com.mediway.hos.srm.business.center.serviceimpl.approvalProcess;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.mediway.hos.srm.business.center.mapper.approvalProcess.SrmEafRecMapper;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.approvalProcess.EafRecDto;
import com.mediway.hos.srm.business.center.model.entity.approvalProcess.SrmEafRec;
import com.mediway.hos.srm.business.center.model.entity.approvalProcess.SrmEafRecLog;
import com.mediway.hos.srm.business.center.mapper.approvalProcess.SrmEafRecLogMapper;
import com.mediway.hos.srm.business.center.model.entity.user.SrmUser;
import com.mediway.hos.srm.business.center.model.vo.approvalProcess.EafRecLogVo;
import com.mediway.hos.srm.business.center.model.vo.approvalProcess.EafRecVo;
import com.mediway.hos.srm.business.center.model.vo.approvalProcess.EafRecVstepNo;
import com.mediway.hos.srm.business.center.service.approvalProcess.SrmEafRecLogService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.mediway.hos.srm.business.center.service.approvalProcess.SrmEafRecService;
import com.mediway.hos.srm.business.center.service.user.SrmUserService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 审批记录日志 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-08-23
 */
@Service
public class SrmEafRecLogServiceImpl extends BaseServiceImpl<SrmEafRecLogMapper, SrmEafRecLog> implements SrmEafRecLogService {
    @Autowired
    private SrmEafRecService srmEafRecService;
    @Autowired
    private SrmEafRecMapper srmEafRecMapper;
    @Autowired
    private SrmEafRecLogMapper eafRecLogMapper;
    @Autowired
    private SrmUserService srmUserService;
    @Override
    public void saveRecLog(String id) {
        EafRecDto eafRecDto=new EafRecDto();
        eafRecDto.setId(Long.valueOf(id));
        EafRecVo eafRecVo= srmEafRecService.getEafRecDetail(eafRecDto);
        String ChkRecDr=eafRecVo.getCheckRecId();
        String SysNoDr=eafRecVo.getSysNo();
        String DeptDR=eafRecVo.getDept();
        String Desc=eafRecVo.getCheckDesc();
        LocalDateTime OpDate=eafRecVo.getCheckDatetime();
        String CheckUser=eafRecVo.getCheckUser();
        String ChkResult=eafRecVo.getCheckResult();
        String checkProcDesc=eafRecVo.getCheckProcDesc();
        int StepNO=eafRecVo.getStepNo();
        if(StepNO==1){
            Desc="提交";
        }
        SrmEafRecLog eafRecLog=new SrmEafRecLog();
        eafRecLog.setEafRecId(id);
        eafRecLog.setCheckRecId(Long.valueOf(ChkRecDr));
        eafRecLog.setSysModuleId(SysNoDr);
        eafRecLog.setDept(DeptDR);
        eafRecLog.setCheckDesc(Desc);
        eafRecLog.setCheckResult(ChkResult);
        eafRecLog.setCheckUser(CheckUser);
        eafRecLog.setCheckTime(OpDate);
        eafRecLog.setCheckProcDesc(checkProcDesc);
        super.saveOrUpdate(eafRecLog);
    }

    @Override
    public List<EafRecLogVo> listCheckLog(BaseDto baseDto) {
        String sysNo=baseDto.getSysNo();
        Long rowId=baseDto.getId();
        List<EafRecLogVo> logVos=eafRecLogMapper.listCheckLog(sysNo,String.valueOf(rowId));
        List<EafRecLogVo> logVoList=new ArrayList<>();
        for (EafRecLogVo eafRecLogVo :logVos){
            EafRecLogVo neweafRecLogVo =new EafRecLogVo();
            neweafRecLogVo=eafRecLogVo;
            logVoList.add(neweafRecLogVo);
        }
        return logVoList;
    }

    @Override
    public int getCurStep(EafRecDto eafRecDto) {
        String recId=eafRecDto.getCheckRecId();
        String sysNo=eafRecDto.getSysNo();
        QueryWrapper<SrmEafRecLog> srmEafRecLogQueryWrapper=new QueryWrapper<>();
        srmEafRecLogQueryWrapper.eq("check_rec_id",recId);
        srmEafRecLogQueryWrapper.eq("sys_module_id",sysNo);
        List<SrmEafRecLog> srmEafRecLogs=eafRecLogMapper.selectList(srmEafRecLogQueryWrapper);
        if(srmEafRecLogs.isEmpty()) return 0;
        return srmEafRecLogs.size();
    }

    @Override
    public List<EafRecVstepNo> listVStep(EafRecDto eafRecDto) {
        String recId=eafRecDto.getCheckRecId();
        String sysNo=eafRecDto.getSysNo();
        QueryWrapper<SrmEafRecLog> srmEafRecLogQueryWrapper=new QueryWrapper<>();
        srmEafRecLogQueryWrapper.eq("check_rec_id",recId);
        srmEafRecLogQueryWrapper.eq("sys_module_id",sysNo);
        List<SrmEafRecLog> srmEafRecLogs=eafRecLogMapper.selectList(srmEafRecLogQueryWrapper);
        if(srmEafRecLogs.isEmpty()) return null;
        String curFlowId="0";
        List<EafRecVstepNo> eafRecVstepNos=new ArrayList<>();
        for(SrmEafRecLog srmEafRecLog1 :srmEafRecLogs ){
            String flowDesc=srmEafRecLog1.getCheckProcDesc();
            String userId=srmEafRecLog1.getCheckUser();
            curFlowId=srmEafRecLog1.getEafRecId();
            String auditDate="";
            LocalDateTime auditDateLd=srmEafRecLog1.getCheckTime();
            DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            if(auditDateLd!=null){
                auditDate=dateTimeFormatter.format(auditDateLd);
            }
            String userName="";
            SrmUser srmUser=srmUserService.selectById(Long.valueOf(userId));
            if (srmUser!=null){
                userName=srmUser.getName();
            }
            String auditDesc=srmEafRecLog1.getCheckDesc();
            String result=srmEafRecLog1.getCheckResult();
            String advice="";
            String stepDesc="";
            if("2".equals(result)){
                stepDesc="通过";
            }
            if("3".equals(result)){
                stepDesc="不通过";
            }

            if(auditDesc==null||auditDesc.isEmpty()){
                advice="";
            }else if(auditDesc.contains("-")){
                String[] arr=auditDesc.split("-");
                advice=arr[1];
            }else{
                advice=auditDesc;
            }
            String confirmStr="";
            if(flowDesc.equals("提交")){
                confirmStr="<div><p style='font-size:16px;right:50px;width:350px;'>"+userName+"&nbsp;&nbsp;&nbsp;&nbsp;"+auditDate+"</p></div>";
            }else{
                confirmStr="<div>"+userName+"&nbsp;&nbsp;&nbsp;&nbsp;"+auditDate+"<br>"+stepDesc+"<br>"+advice+"</div>";
            }
            EafRecVstepNo eafRecVstepNo=new EafRecVstepNo();
            eafRecVstepNo.setTitle(flowDesc);
            eafRecVstepNo.setContext(confirmStr);
            eafRecVstepNos.add(eafRecVstepNo);
        }
        // 补充剩余的审批流程 curFlowId  -- 获取比他大的流程
        QueryWrapper<SrmEafRec> srmEafRecQueryWrapper=new QueryWrapper<>();
        srmEafRecQueryWrapper.eq("check_rec_id",recId);
        srmEafRecQueryWrapper.eq("sys_no",sysNo);
        List<SrmEafRec> srmEafRecs=srmEafRecMapper.selectList(srmEafRecQueryWrapper);
        if(!srmEafRecs.isEmpty()){
            for(SrmEafRec srmEafRec:srmEafRecs){
                Long tmpId=srmEafRec.getId();
                if(Long.parseLong(curFlowId)>=tmpId) continue;
                System.out.println(curFlowId+","+tmpId);
                String flowDesc=srmEafRec.getCheckProcDesc();
                String confirmStr="<div><p style='font-size:16px;right:50px;width:350px;'></p></div>";
                EafRecVstepNo eafRecVstepNo=new EafRecVstepNo();
                eafRecVstepNo.setTitle(flowDesc);
                eafRecVstepNo.setContext(confirmStr);
                eafRecVstepNos.add(eafRecVstepNo);
            }
        }
        return eafRecVstepNos;
    }

    @Override
    public List<EafRecVstepNo> listAppVStep(EafRecDto eafRecDto) {
        String recId=eafRecDto.getCheckRecId();
        String sysNo=eafRecDto.getSysNo();
        QueryWrapper<SrmEafRecLog> srmEafRecLogQueryWrapper=new QueryWrapper<>();
        srmEafRecLogQueryWrapper.eq("check_rec_id",recId);
        srmEafRecLogQueryWrapper.eq("sys_module_id",sysNo);
        List<SrmEafRecLog> srmEafRecLogs=eafRecLogMapper.selectList(srmEafRecLogQueryWrapper);
        if(srmEafRecLogs.isEmpty()) return null;
        String curFlowId="0";
        List<EafRecVstepNo> eafRecVstepNos=new ArrayList<>();
        for(SrmEafRecLog srmEafRecLog1 :srmEafRecLogs ){
            String flowDesc=srmEafRecLog1.getCheckProcDesc();
            String userId=srmEafRecLog1.getCheckUser();
            curFlowId=srmEafRecLog1.getEafRecId();
            String auditDate="";
            LocalDateTime auditDateLd=srmEafRecLog1.getCheckTime();
            DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            if(auditDateLd!=null){
                auditDate=dateTimeFormatter.format(auditDateLd);
            }
            String userName="";
            SrmUser srmUser=srmUserService.selectById(Long.valueOf(userId));
            if (srmUser!=null){
                userName=srmUser.getName();
            }
            String auditDesc=srmEafRecLog1.getCheckDesc();
            String result=srmEafRecLog1.getCheckResult();
            String advice="";
            String stepDesc="";
            if("2".equals(result)){
                stepDesc="通过";
            }
            if("3".equals(result)){
                stepDesc="不通过";
            }

            if(auditDesc==null||auditDesc.isEmpty()){
                advice="";
            }else if(auditDesc.contains("-")){
                String[] arr=auditDesc.split("-");
                advice=arr[1];
            }else{
                advice=auditDesc;
            }
            String confirmStr="";
            if(flowDesc.equals("提交")){
                confirmStr="<div><p style='font-size:16px;right:50px;width:350px;'>"+userName+"</p></div>";
            }else{
                confirmStr="<div>"+userName+"&nbsp;&nbsp;&nbsp;&nbsp;"+auditDate+"<br>"+stepDesc+"<br>"+advice+"</div>";
            }
            EafRecVstepNo eafRecVstepNo=new EafRecVstepNo();
            eafRecVstepNo.setTitle(flowDesc);
            eafRecVstepNo.setContext(confirmStr);
            eafRecVstepNo.setRowId(String.valueOf(srmEafRecLog1.getId()));
            eafRecVstepNo.setOperateDate(auditDate);
            eafRecVstepNo.setOperateName(userName);
            eafRecVstepNo.setAdvice(srmEafRecLog1.getCheckDesc());
            eafRecVstepNo.setAuditResult(stepDesc);
            eafRecVstepNos.add(eafRecVstepNo);
        }
        // 补充剩余的审批流程 curFlowId  -- 获取比他大的流程
        QueryWrapper<SrmEafRec> srmEafRecQueryWrapper=new QueryWrapper<>();
        srmEafRecQueryWrapper.eq("check_rec_id",recId);
        srmEafRecQueryWrapper.eq("sys_no",sysNo);
        List<SrmEafRec> srmEafRecs=srmEafRecMapper.selectList(srmEafRecQueryWrapper);
        if(!srmEafRecs.isEmpty()){
            for(SrmEafRec srmEafRec:srmEafRecs){
                Long tmpId=srmEafRec.getId();
                if(Long.parseLong(curFlowId)>=tmpId) continue;
                System.out.println(curFlowId+","+tmpId);
                String flowDesc=srmEafRec.getCheckProcDesc();
                String confirmStr="<div><p style='font-size:16px;right:50px;width:350px;'></p></div>";
                EafRecVstepNo eafRecVstepNo=new EafRecVstepNo();
                eafRecVstepNo.setTitle(flowDesc);
                eafRecVstepNo.setContext(confirmStr);
                eafRecVstepNos.add(eafRecVstepNo);
            }
        }
        return eafRecVstepNos;
    }
}
