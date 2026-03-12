package com.mediway.hos.srm.business.center.controller.project;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.project.ProjectMidcheckDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectMidcheckVo;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectsInfoVo;
import com.mediway.hos.srm.business.center.service.project.SrmProjectMidcheckService;

/**
 * <p>
 * 中检信息表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/srmProjectMidcheck")
@Api(tags = "中检信息表")
public class SrmProjectMidcheckController {
    @Autowired
    private SrmProjectMidcheckService srmProjectMidcheckService;
    @PostMapping({"/saveProjectMidcheck"})
    public BaseResponse saveProjectMidcheck(@RequestBody ProjectMidcheckDto projectMidcheckDto) {
        Long RowId= srmProjectMidcheckService.saveProjectMidcheck(projectMidcheckDto);
        return BaseResponse.success(RowId);
    }
    @PostMapping({"/getDetail"})
    public BaseResponse getDetail(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ProjectMidcheckVo res = srmProjectMidcheckService.getDetail(String.valueOf(RowId));
        return BaseResponse.success(res);
    }

    @PostMapping({"/listProjectMidcheck"})
    public BaseResponse listProjectMidcheck(@RequestBody ProjectMidcheckDto projectMidcheckDto) {
        IPage<ProjectMidcheckVo> list = srmProjectMidcheckService.listProjectMidcheck(projectMidcheckDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteProjectMidcheck"})
    public BaseResponse deleteProjectMidcheck(@RequestBody BaseDto baseDto) {
        srmProjectMidcheckService.deleteProjectMidcheck(baseDto);
        return BaseResponse.success("删除成功!");

    }
    @PostMapping({"/subMit"})
    public BaseResponse subMit(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto.toString());
        srmProjectMidcheckService.subMit(baseDto);
        return BaseResponse.success("提交成功!");

    }
    @PostMapping({"/listAuditProjectMidcheck"})
    public BaseResponse listAuditProjectMidcheck(@RequestBody ProjectMidcheckDto projectMidcheckDto) {
        IPage<ProjectsInfoVo> list = srmProjectMidcheckService.listAuditProjectMidcheck(projectMidcheckDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/audit"})
    public BaseResponse audit(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto.toString());
        srmProjectMidcheckService.audit(baseDto);
        return BaseResponse.success("审批成功!");

    }
    /*
    @PostMapping({"/listExpertAuditMiddleProject"})
    public BaseResponse listExpertAuditMiddleProject(@RequestBody ProjectsInfoDto projectsInfoDto) {
        IPage<ProjectSolicitGradeVo> list = srmProjectMidcheckService.listExpertAuditMiddleProject(projectsInfoDto);
        return BaseResponse.success(list);

    }
    */

}
