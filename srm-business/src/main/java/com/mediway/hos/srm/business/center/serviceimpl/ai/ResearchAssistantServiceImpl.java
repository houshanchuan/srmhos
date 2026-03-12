package com.mediway.hos.srm.business.center.serviceimpl.ai;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.srm.business.center.model.dto.ai.APIChatSession;
import com.mediway.hos.srm.business.center.model.dto.ai.ApiDefinition;
import com.mediway.hos.srm.business.center.model.dto.ai.TyChatSession;
import com.mediway.hos.srm.business.center.model.dto.baseData.EduDegreeDto;
import com.mediway.hos.srm.business.center.model.dto.dept.DeptDto;
import com.mediway.hos.srm.business.center.model.dto.user.UserDto;
import com.mediway.hos.srm.business.center.model.entity.user.SrmUser;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.vo.user.UserVo;
import com.mediway.hos.srm.business.center.service.ai.ApiRegistryService;
import com.mediway.hos.srm.business.center.service.ai.ResearchAssistantService;
import com.mediway.hos.srm.business.center.service.common.SrmCommonService;
import com.mediway.hos.srm.business.center.service.dept.SrmDeptService;
import com.mediway.hos.srm.business.center.service.user.SrmUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class ResearchAssistantServiceImpl implements ResearchAssistantService {

    @Autowired
    private SrmUserService srmUserService;
    @Autowired
    private SrmDeptService srmDeptService;
    @Autowired
    private SrmCommonService srmCommonService;
    @Autowired
    private ApiRegistryService apiRegistryService;

    @Autowired
    private QwenHttpClient qwenHttpClient;
    public static final Map<String, APIChatSession> apiSessions = new ConcurrentHashMap<>();
    public static final Map<String, TyChatSession> tySessions = new ConcurrentHashMap<>();

    private static final String apiModel="qwen-max";
    private static final String tyModel="qwen-max";

    private JSONObject parseJson(String text) {
        try {
            return JSONObject.parseObject(text);
        } catch (Exception e) {
            return null;
        }
    }
    public APIChatSession getOrCreateSession(String sessionId) {
        return apiSessions.computeIfAbsent(
                sessionId,
                id -> {
                    String systemPrompt =buildApiPrompt();
                    if (systemPrompt == null || systemPrompt.trim().isEmpty()) {
                        systemPrompt = "你是一个专业、友好的AI医学科研助手，回答要简洁准确。";
                    }
                    return new APIChatSession(id, systemPrompt);
                }
        );
    }

    @Override
    public String answerQuestion(String userQuestion,String sessionId) {
        apiSessions.clear();
        APIChatSession apiSession = getOrCreateSession(sessionId);
        TyChatSession tySession = tySessions.computeIfAbsent(sessionId, TyChatSession::new);
        try {
            apiSession.addUserMessage(userQuestion);
            String response = qwenHttpClient.askQwen(apiModel,apiSession.getMessages(),sessionId);

            JSONObject result = parseJson(response);
            String apiName = result.getString("api");
            JSONObject params = result.getJSONObject("params");
            JSONArray invalidParms = result.getJSONArray("other");
            String describer=result.getString("describer");
            if(invalidParms!=null&&invalidParms.size()>0){
                String sr="不支持的API请求参数: 【";
                for(int i=0;i<invalidParms.size();i++) {
                    sr += invalidParms.getString(i)+",";
                }
                sr+="】";
                return sr;
            }
            ApiDefinition apiDef = apiRegistryService.getByName(apiName);
            if (apiDef == null) {
                tySession.addUserMessage(userQuestion);
                apiSession.removeLastMessage();
                String s=qwenHttpClient.askQwen(tyModel,tySession.getMessages(),sessionId);
                tySession.addAssistantMessage(s);
                return s;
            }
            apiSession.addAssistantMessage(response);

            if ("count_staff".equals(apiName)) {
                QueryWrapper<SrmUser> queryWrap=new QueryWrapper<>();
                UserDto userDto=new UserDto();
                userDto.setPage(1);
                userDto.setRows(10);

                if(params.getString("degree")!=null){
                    String paramValue=params.getString("degree");
                    userDto.setEduDegree(params.getString("degree"));
                }
                if(params.getString("department")!=null){
                    userDto.setDept(params.getString("department"));
                }
                IPage<UserVo> userPage=srmUserService.listUser(userDto);
                List<UserVo> list=userPage.getRecords();
                String names = list.stream()
                        .map(UserVo::getName)
                        .collect(Collectors.joining("\n"));

                return describer+": "+userPage.getTotal() +" 人 \n"+names+" 等";
            }else if ("list_managers".equals(apiName)) {
                QueryWrapper<SrmUser> queryWrap=new QueryWrapper<>();
                List<SrmUser> list = srmUserService.list(queryWrap);
                return "该部门论文有：" + list;
            }else{
                return qwenHttpClient.askTYQwen(userQuestion.trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "系统内部错误："+e.getMessage();
        }
    }


    private String formatDict(Map<String, String> dict) {
        return dict.entrySet().stream()
                .map(e -> e.getKey() + "→" + e.getValue())
                .collect(Collectors.joining("， "));
    }
    private String buildApiPrompt() {
        List<ApiDefinition> apis = apiRegistryService.getAllApis();
        StringBuilder prompt = new StringBuilder();
        prompt.append("你是一个API参数提取器，请严格按以下要求执行：\n");
        prompt.append("1. 只有当问题明确提到【本系统】、【系统】、【某科室】或未说明范围时，才使用系统API\n");
        prompt.append("2. 如果提到【学校】、【公司】、【医院】等具体组织，不属于本系统，不能调用系统API\n");
        prompt.append("3. 不要推测或泛化范围，必须严格匹配\n\n");
        prompt.append("4. 分析用户问题，提取参数\n");
        prompt.append("5. 将字典值转换为对应的编码,所有参数的值都是字符串格式，不是数字\n");
        prompt.append("6. 将字典值转换为对应的编码或ID识别的参数放到params中，没有对应的参数中文名称则输出到other中\n");
        prompt.append("7. 只输出纯JSON，不要任何解释、不要markdown、不要前后包络符\n");
        prompt.append("8. 输出必须是合法JSON对象，不能是字符串\n\n"); // 👈 关键！

        // 添加字典映射
        Set<String> dictParams = apis.stream()
                .flatMap(api -> api.dictParams.keySet().stream())
                .collect(Collectors.toSet());

        List<CombVo> deptList=srmDeptService.getDept(new DeptDto());
        Map<String, String> deptDict = deptList.stream()
                .collect(Collectors.toMap(
                        CombVo::getName,  // 键生成器：使用 User 的 id 作为 key
                        CombVo -> CombVo.getId()   // 值生成器：直接使用 User 对象作为 value（可简化为 Function.identity()）
                ));
        List<CombVo> degreeList=srmCommonService.getEduDegree(new EduDegreeDto());
        Map<String, String> degreeDict = degreeList.stream()
                .collect(Collectors.toMap(
                        CombVo::getName,  // 键生成器：使用 User 的 id 作为 key
                        CombVo -> CombVo.getId()   // 值生成器：直接使用 User 对象作为 value（可简化为 Function.identity()）
                ));

        if (dictParams.contains("department")) {
            prompt.append("【科室】").append(formatDict(deptDict)).append("\n");
        }
        if (dictParams.contains("degree")) {
            prompt.append("【学历】").append(formatDict(degreeDict)).append("\n");
        }
        prompt.append("【可用API】\n");
        for (ApiDefinition api : apis) {
            prompt.append(api.toPromptString()).append("\n");
        }

        prompt.append("输出格式：{ \"describer\":\"问题核心\",\"api\": \"方法名\", \"params\": { \"参数名\": 值 },\"other\": [ \"参数名[值]\"]  }\n");
       // prompt.append("参数不存在则省略。\n");
        prompt.append("不要任何其他内容，只返回JSON。\n"); // 👈 再次强调
        prompt.append("输出必须是JSON对象，不是字符串，不是markdown。\n\n");
        prompt.append("输出（只返回JSON）：\n");
        return prompt.toString();
    }

}
