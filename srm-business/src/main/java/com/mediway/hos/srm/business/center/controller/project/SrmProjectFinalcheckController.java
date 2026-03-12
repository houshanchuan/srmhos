package com.mediway.hos.srm.business.center.controller.project;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.project.ProjectFinalcheckDto;
import com.mediway.hos.srm.business.center.model.dto.project.ProjectsInfoDto;
import com.mediway.hos.srm.business.center.utils.SrmPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectFinalcheckVo;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectSolicitGradeVo;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectsInfoVo;
import com.mediway.hos.srm.business.center.service.project.SrmProjectFinalcheckService;

/**
 * <p>
 * 项目验收信息表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-12-09
 */
@RestController
@RequestMapping("srm/srmProjectFinalcheck")
@Api(tags = "项目验收信息表")
public class SrmProjectFinalcheckController {
    @Autowired
    private SrmProjectFinalcheckService srmProjectFinalcheckService;

    @PostMapping({"/listFinalProject"})
    public BaseResponse listFinalProject(@RequestBody ProjectsInfoDto projectsInfoDto) {
        SrmPage<ProjectsInfoVo> list = srmProjectFinalcheckService.listFinalProject(projectsInfoDto);
        return BaseResponse.success(list);

    }

    @PostMapping({"/saveProjectFinalcheck"})
    public BaseResponse saveProjectFinalcheck(@RequestBody ProjectFinalcheckDto projectFinalcheckDto) {
        Long RowId= srmProjectFinalcheckService.saveProjectFinalcheck(projectFinalcheckDto);
        return BaseResponse.success(RowId);
    }
    @PostMapping({"/getDetail"})
    public BaseResponse getDetail(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ProjectFinalcheckVo res = srmProjectFinalcheckService.getDetail(String.valueOf(RowId));
        return BaseResponse.success(res);
    }

    @PostMapping({"/listProjectFinalCheck"})
    public BaseResponse listProjectFinalCheck(@RequestBody ProjectFinalcheckDto projectFinalcheckDto) {
        IPage<ProjectFinalcheckVo> list = srmProjectFinalcheckService.listProjectFinalCheck(projectFinalcheckDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteProjectFinalCheck"})
    public BaseResponse deleteProjectFinalCheck(@RequestBody BaseDto baseDto) {
        srmProjectFinalcheckService.deleteProjectFinalCheck(baseDto);
        return BaseResponse.success("删除成功!");

    }
    @PostMapping({"/subMit"})
    public BaseResponse subMit(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto.toString());
        srmProjectFinalcheckService.subMit(baseDto);
        return BaseResponse.success("提交成功!");

    }
    @PostMapping({"/listAuditProjectFinalCheck"})
    public BaseResponse listAuditProjectFinalCheck(@RequestBody ProjectFinalcheckDto projectFinalcheckDto) {
        IPage<ProjectsInfoVo> list = srmProjectFinalcheckService.listAuditProjectFinalCheck(projectFinalcheckDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/audit"})
    public BaseResponse audit(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto.toString());
        srmProjectFinalcheckService.audit(baseDto);
        return BaseResponse.success("审批成功!");

    }

    @PostMapping({"/listExpertAuditFinalProject"})
    public BaseResponse listExpertAuditFinalProject(@RequestBody ProjectsInfoDto projectsInfoDto) {
        IPage<ProjectSolicitGradeVo> list = srmProjectFinalcheckService.listExpertAuditFinalProject(projectsInfoDto);
        return BaseResponse.success(list);

    }

}
