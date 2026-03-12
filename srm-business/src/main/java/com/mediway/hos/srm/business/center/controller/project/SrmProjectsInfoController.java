package com.mediway.hos.srm.business.center.controller.project;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.project.ProjectsInfoDto;
import com.mediway.hos.srm.business.center.model.dto.project.ProjectsInfoVerticalDto;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectsInfoVo;
import com.mediway.hos.srm.business.center.service.project.SrmProjectsInfoService;

import java.util.List;

/**
 * <p>
 * 课题信息表(项目)
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-23
 */
@RestController
@RequestMapping("srm/projectsInfo")
@Api(tags = "课题信息表(项目)")
public class SrmProjectsInfoController {
    @Autowired
    private SrmProjectsInfoService srmProjectsInfoService;

    @PostMapping({"/getProjectsInfo"})
    public List<CombVo> getProjectsInfo(@RequestBody(required = false) ProjectsInfoDto projectsInfoDto) {
        System.out.println(projectsInfoDto);
        return srmProjectsInfoService.getProjectsInfo(projectsInfoDto);
    }
    @PostMapping({"/saveVerticalProjectsInfo"})
    public BaseResponse saveVerticalProjectsInfo(@RequestBody ProjectsInfoVerticalDto projectsInfoVerticalDto) {
        Long RowId= srmProjectsInfoService.saveVerticalProjectsInfo(projectsInfoVerticalDto);
        return BaseResponse.success(RowId);
    }
    @PostMapping({"/getVerticalDetail"})
    public BaseResponse getVerticalDetail(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ProjectsInfoVo projectsInfoVo = srmProjectsInfoService.getVerticalDetail(RowId);
        return BaseResponse.success(projectsInfoVo);
    }

    @PostMapping({"/listVerticalProject"})
    public BaseResponse listVerticalProject(@RequestBody ProjectsInfoDto projectsInfoDto) {
        IPage<ProjectsInfoVo> list = srmProjectsInfoService.listVerticalProject(projectsInfoDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteVerticalProjectsInfo"})
    public BaseResponse deleteVerticalProjectsInfo(@RequestBody BaseDto baseDto) {
        srmProjectsInfoService.deleteVerticalProjectsInfo(baseDto);
        return BaseResponse.success("删除成功!");

    }
    @PostMapping({"/subMitVerticalProject"})
    public BaseResponse subMitVerticalProject(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto.toString());
        srmProjectsInfoService.subMitVerticalProject(baseDto);
        return BaseResponse.success("提交成功!");

    }
    @PostMapping({"/listAuditVerticalProject"})
    public BaseResponse listAuditVerticalProject(@RequestBody ProjectsInfoDto projectsInfoDto) {

        IPage<ProjectsInfoVo> list = srmProjectsInfoService.listAuditVerticalProject(projectsInfoDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/auditVerticalProject"})
    public BaseResponse auditVerticalProject(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto.toString());
        srmProjectsInfoService.auditVerticalProject(baseDto);
        return BaseResponse.success("审批成功!");

    }

    // 下面是横向项目
    @PostMapping({"/saveHroProjectsInfo"})
    public BaseResponse saveHroProjectsInfo(@RequestBody ProjectsInfoVerticalDto projectsInfoVerticalDto) {
        Long RowId= srmProjectsInfoService.saveHroProjectsInfo(projectsInfoVerticalDto);
        return BaseResponse.success(RowId);
    }
    @PostMapping({"/getHroProjectDetail"})
    public BaseResponse getHroProjectDetail(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ProjectsInfoVo projectsInfoVo = srmProjectsInfoService.getHroProjectDetail(RowId);
        return BaseResponse.success(projectsInfoVo);
    }

    @PostMapping({"/listHroProject"})
    public BaseResponse listHroProject(@RequestBody ProjectsInfoDto projectsInfoDto) {
        IPage<ProjectsInfoVo> list = srmProjectsInfoService.listHroProject(projectsInfoDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteHroProject"})
    public BaseResponse deleteHroProject(@RequestBody BaseDto baseDto) {
        srmProjectsInfoService.deleteHroProject(baseDto);
        return BaseResponse.success("删除成功!");

    }
    @PostMapping({"/subMitHroProject"})
    public BaseResponse subMitHroProject(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto.toString());
        srmProjectsInfoService.subMitHroProject(baseDto);
        return BaseResponse.success("提交成功!");

    }
    @PostMapping({"/listAuditHroProject"})
    public BaseResponse listAuditHroProject(@RequestBody ProjectsInfoDto projectsInfoDto) {

        IPage<ProjectsInfoVo> list = srmProjectsInfoService.listAuditHroProject(projectsInfoDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/auditHroProject"})
    public BaseResponse auditHroProject(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto.toString());
        srmProjectsInfoService.auditHroProject(baseDto);
        return BaseResponse.success("审批成功!");

    }
    // 下面是合同项目
    @PostMapping({"/saveContractProjectsInfo"})
    public BaseResponse saveContractProjectsInfo(@RequestBody ProjectsInfoVerticalDto projectsInfoVerticalDto) {
        Long RowId= srmProjectsInfoService.saveContractProjectsInfo(projectsInfoVerticalDto);
        return BaseResponse.success(RowId);
    }
    @PostMapping({"/getContractProjectDetail"})
    public BaseResponse getContractProjectDetail(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ProjectsInfoVo projectsInfoVo = srmProjectsInfoService.getContractProjectDetail(RowId);
        return BaseResponse.success(projectsInfoVo);
    }

    @PostMapping({"/listContractProject"})
    public BaseResponse listContractProject(@RequestBody ProjectsInfoDto projectsInfoDto) {
        System.out.println(projectsInfoDto);
        IPage<ProjectsInfoVo> list = srmProjectsInfoService.listContractProject(projectsInfoDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteContractProject"})
    public BaseResponse deleteContractProject(@RequestBody BaseDto baseDto) {
        srmProjectsInfoService.deleteContractProject(baseDto);
        return BaseResponse.success("删除成功!");

    }
    @PostMapping({"/subMitContractProject"})
    public BaseResponse subMitContractProject(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto.toString());
        srmProjectsInfoService.subMitContractProject(baseDto);
        return BaseResponse.success("提交成功!");

    }
    @PostMapping({"/listAuditContractProject"})
    public BaseResponse listAuditContractProject(@RequestBody ProjectsInfoDto projectsInfoDto) {

        IPage<ProjectsInfoVo> list = srmProjectsInfoService.listAuditContractProject(projectsInfoDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/auditContractProject"})
    public BaseResponse auditContractProject(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto.toString());
        srmProjectsInfoService.auditContractProject(baseDto);
        return BaseResponse.success("审批成功!");

    }
    @PostMapping({"/getProjectSolicit"})
    public List<CombVo> getProjectSolicit(@RequestParam String userCode) {
        return srmProjectsInfoService.getProjectSolicit(userCode);
    }
}
