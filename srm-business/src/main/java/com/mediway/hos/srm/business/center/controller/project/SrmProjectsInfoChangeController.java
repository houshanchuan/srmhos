package com.mediway.hos.srm.business.center.controller.project;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.project.ProjectsInfoChangeDto;
import com.mediway.hos.srm.business.center.model.dto.project.ProjectsInfoChangeMainDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectsInfoChangeVo;
import com.mediway.hos.srm.business.center.service.project.SrmProjectsInfoChangeService;

/**
 * <p>
 * 项目变更
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/srmProjectsInfoChange")
@Api(tags = "项目变更")
public class SrmProjectsInfoChangeController {
    @Autowired
    private SrmProjectsInfoChangeService srmProjectsInfoChangeService;


    @PostMapping({"/getDetail"})
    public BaseResponse getDetail(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ProjectsInfoChangeVo vo = srmProjectsInfoChangeService.getDetail(RowId);
        return BaseResponse.success(vo);
    }
    @PostMapping({"/saveProjectsInfoChange"})
    public BaseResponse saveProjectsInfoChange(@RequestBody ProjectsInfoChangeMainDto projectsInfoChangeMainDto) {
        Long RowId= srmProjectsInfoChangeService.saveProjectsInfoChange(projectsInfoChangeMainDto);
        return BaseResponse.success(RowId);
    }
    @PostMapping({"/listProjectsInfoChange"})
    public BaseResponse listProjectsInfoChange(@RequestBody ProjectsInfoChangeDto projectsInfoChangeDto) {
        IPage<ProjectsInfoChangeVo> list = srmProjectsInfoChangeService.listProjectsInfoChange(projectsInfoChangeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteProjectsInfoChange"})
    public BaseResponse deleteProjectsInfoChange(@RequestBody BaseDto baseDto) {
        srmProjectsInfoChangeService.deleteProjectsInfoChange(baseDto);
        return BaseResponse.success("删除成功!");

    }
    @PostMapping({"/subMitProjectsInfoChange"})
    public BaseResponse subMitProjectsInfoChange(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto.toString());
        srmProjectsInfoChangeService.subMitProjectsInfoChange(baseDto);
        return BaseResponse.success("提交成功!");

    }
    @PostMapping({"/listAuditProjectsInfoChange"})
    public BaseResponse listAuditProjectsInfoChange(@RequestBody ProjectsInfoChangeDto projectsInfoChangeDto) {

        IPage<ProjectsInfoChangeVo> list = srmProjectsInfoChangeService.listAuditProjectsInfoChange(projectsInfoChangeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/auditProjectsInfoChange"})
    public BaseResponse auditProjectsInfoChange(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto.toString());
        srmProjectsInfoChangeService.auditProjectsInfoChange(baseDto);
        return BaseResponse.success("审批成功!");

    }
}
