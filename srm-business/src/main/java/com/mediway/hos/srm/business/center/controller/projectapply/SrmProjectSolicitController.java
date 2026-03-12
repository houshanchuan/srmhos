package com.mediway.hos.srm.business.center.controller.projectapply;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitDto;
import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitMainDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectSolicitVo;
import com.mediway.hos.srm.business.center.service.projectapply.SrmProjectSolicitService;
import com.mediway.hos.srm.business.center.utils.SrmPage;

/**
 * <p>
 * 项目征集(申报)信息表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/srmProjectSolicit")
@Api(tags = "项目征集(申报)信息表")
public class SrmProjectSolicitController {
    @Autowired
    private SrmProjectSolicitService srmProjectSolicitService;

    @PostMapping({"/saveProjectSolicit"})
    public BaseResponse saveProjectSolicit(@RequestBody ProjectSolicitMainDto projectSolicitMainDto) {
        Long RowId= srmProjectSolicitService.saveProjectSolicit(projectSolicitMainDto);
        return BaseResponse.success(RowId);
    }
    @PostMapping({"/getDetail"})
    public BaseResponse getDetail(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ProjectSolicitVo projectSolicitVo = srmProjectSolicitService.getDetail(String.valueOf(RowId));
        return BaseResponse.success(projectSolicitVo);
    }

    @PostMapping({"/listProjectSolicit"})
    public BaseResponse listProjectSolicit(@RequestBody ProjectSolicitDto projectSolicitDto) {
        IPage<ProjectSolicitVo> list = srmProjectSolicitService.listProjectSolicit(projectSolicitDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteProjectSolicit"})
    public BaseResponse deleteProjectSolicit(@RequestBody BaseDto baseDto) {
        srmProjectSolicitService.deleteProjectSolicit(baseDto);
        return BaseResponse.success("删除成功!");

    }
    @PostMapping({"/subMit"})
    public BaseResponse subMit(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto.toString());
        srmProjectSolicitService.subMit(baseDto);
        return BaseResponse.success("提交成功!");

    }
    @PostMapping({"/listHeadAuditProjectSolicit"})
    public BaseResponse listHeadAuditProjectSolicit(@RequestBody ProjectSolicitDto projectSolicitDto) {
        IPage<ProjectSolicitVo> list = srmProjectSolicitService.listHeadAuditProjectSolicit(projectSolicitDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/headerAudit"})
    public BaseResponse headerAudit(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto.toString());
        srmProjectSolicitService.headerAudit(baseDto);
        return BaseResponse.success("审批成功!");

    }

    @PostMapping({"/listAuditProjectSolicit"})
    public BaseResponse listAuditProjectSolicit(@RequestBody ProjectSolicitDto projectSolicitDto) {
        //IPage<ProjectSolicitVo> list = srmProjectSolicitService.listAuditProjectSolicit(projectSolicitDto);
        SrmPage<ProjectSolicitVo> list = srmProjectSolicitService.listAuditProjectSolicitNew(projectSolicitDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/preAudit"})
    public BaseResponse preAudit(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto.toString());
        srmProjectSolicitService.preAudit(baseDto);
        return BaseResponse.success("审批成功!");

    }
    @PostMapping({"/finalAudit"})
    public BaseResponse finalAudit(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto.toString());
        srmProjectSolicitService.finalAudit(baseDto);
        return BaseResponse.success("审批成功!");

    }
}
