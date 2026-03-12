package com.mediway.hos.srm.business.center.controller.projectapply;


import com.mediway.hos.base.model.BaseResponse;
import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitAuditDto;
import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitEthicAuditDto;
import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitGradeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectSolicitAuditExpertVo;
import com.mediway.hos.srm.business.center.service.projectapply.SrmProjectSolicitAuditService;

import java.util.List;

/**
 * <p>
 * 项目征集权限表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/srmProjectSolicitAudit")
@Api(tags = "项目征集权限表")
public class SrmProjectSolicitAuditController {
    @Autowired
    private SrmProjectSolicitAuditService srmProjectSolicitAuditService;
    @PostMapping({"/getNoAllotExpert"})
    public BaseResponse getNoAllotExpert(@RequestBody ProjectSolicitAuditDto projectSolicitAuditDto) {
        List<ProjectSolicitAuditExpertVo> list = srmProjectSolicitAuditService.getNoAllotExpert(projectSolicitAuditDto);
        return BaseResponse.success(list);

    }

    @PostMapping({"/getNoEthicAllotExpert"})
    public BaseResponse getNoEthicAllotExpert(@RequestBody ProjectSolicitAuditDto projectSolicitAuditDto) {
        List<ProjectSolicitAuditExpertVo> list = srmProjectSolicitAuditService.getNoEthicAllotExpert(projectSolicitAuditDto);
        return BaseResponse.success(list);

    }

    @PostMapping({"/getAllotExpert"})
    public BaseResponse getAllotExpert(@RequestBody ProjectSolicitAuditDto projectSolicitAuditDto) {
        List<ProjectSolicitAuditExpertVo> list = srmProjectSolicitAuditService.getAllotExpert(projectSolicitAuditDto);
        return BaseResponse.success(list);

    }

    @PostMapping({"/getEthicAllotExpert"})
    public BaseResponse getEthicAllotExpert(@RequestBody ProjectSolicitAuditDto projectSolicitAuditDto) {
        List<ProjectSolicitAuditExpertVo> list = srmProjectSolicitAuditService.getEthicAllotExpert(projectSolicitAuditDto);
        return BaseResponse.success(list);

    }

    @PostMapping({"/deleteExpert"})
    public BaseResponse deleteExpert(@RequestBody ProjectSolicitGradeDto projectSolicitGradeDto) {
        srmProjectSolicitAuditService.deleteExpert(projectSolicitGradeDto);
        return BaseResponse.success("删除成功!");

    }
    @PostMapping({"/deleteEthicExpert"})
    public BaseResponse deleteEthicExpert(@RequestBody ProjectSolicitEthicAuditDto projectSolicitEthicAuditDto) {
        srmProjectSolicitAuditService.deleteEthicExpert(projectSolicitEthicAuditDto);
        return BaseResponse.success("删除成功!");

    }
    @PostMapping({"/allotExpert"})
    public BaseResponse allotExpert(@RequestBody ProjectSolicitAuditDto projectSolicitAuditDto) {

        srmProjectSolicitAuditService.allotExpert(projectSolicitAuditDto);
        return BaseResponse.success("分配成功!");

    }
    @PostMapping({"/allotEthicExpert"})
    public BaseResponse allotEthicExpert(@RequestBody ProjectSolicitAuditDto projectSolicitAuditDto) {

        srmProjectSolicitAuditService.allotEthicExpert(projectSolicitAuditDto);
        return BaseResponse.success("分配成功!");

    }

}
