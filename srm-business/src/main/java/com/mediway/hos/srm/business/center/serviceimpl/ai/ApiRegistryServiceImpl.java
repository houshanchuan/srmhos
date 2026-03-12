package com.mediway.hos.srm.business.center.serviceimpl.ai;

import com.mediway.hos.srm.business.center.model.dto.ai.ApiDefinition;
import com.mediway.hos.srm.business.center.model.dto.baseData.EduDegreeDto;
import com.mediway.hos.srm.business.center.model.dto.dept.DeptDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.service.ai.ApiRegistryService;
import com.mediway.hos.srm.business.center.service.common.SrmCommonService;
import com.mediway.hos.srm.business.center.service.dept.SrmDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

// ApiServiceRegistry.java
@Service
public class ApiRegistryServiceImpl implements ApiRegistryService {

    private final List<ApiDefinition> apis = new ArrayList<>();


    @Autowired
    private SrmDeptService srmDeptService;
    @Autowired
    private SrmCommonService srmCommonService;
    @PostConstruct
    public void init() {
        apis.add(new ApiDefinition("count_staff", "统计本系统注册的员工人数")
                .param("department", "科室")
                .param("degree", "学历")
                .dictParam("department", getDept())
                .dictParam("degree", getEduDegree())
        );
        apis.add(new ApiDefinition("list_award", "统计本系统所有论文情况")
                .param("department", "科室")
        );
    }
    private Map<String,String> getDept(){
        List<CombVo> deptList=srmDeptService.getDept(new DeptDto());
        Map<String, String> deptDict = deptList.stream()
                .collect(Collectors.toMap(
                        CombVo::getName,  // 键生成器：使用 User 的 id 作为 key
                        CombVo -> CombVo.getId()   // 值生成器：直接使用 User 对象作为 value（可简化为 Function.identity()）
                ));

       return deptDict;
    }
    private Map<String,String> getEduDegree(){
        List<CombVo> degreeList=srmCommonService.getEduDegree(new EduDegreeDto());
        Map<String, String> degreeDict = degreeList.stream()
                .collect(Collectors.toMap(
                        CombVo::getName,  // 键生成器：使用 User 的 id 作为 key
                        CombVo -> CombVo.getId()   // 值生成器：直接使用 User 对象作为 value（可简化为 Function.identity()）
                ));
        return degreeDict;
    }
    public List<ApiDefinition> getAllApis() {
        return Collections.unmodifiableList(apis);
    }

    public ApiDefinition getByName(String name) {
        return apis.stream()
                .filter(api -> api.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}