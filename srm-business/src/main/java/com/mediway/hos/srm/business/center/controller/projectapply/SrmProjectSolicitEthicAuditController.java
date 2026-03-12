package com.mediway.hos.srm.business.center.controller.projectapply;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitDto;
import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitEthicAuditDto;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectSolicitEthicAuditVo;
import com.mediway.hos.srm.business.center.service.projectapply.SrmProjectSolicitEthicAuditService;

import java.util.List;


/**
 * <p>
 * 项目征集伦理审批表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/srmProjectSolicitEthicAudit")
@Api(tags = "项目征集伦理审批表")
public class SrmProjectSolicitEthicAuditController {
    @Autowired
    private SrmProjectSolicitEthicAuditService srmProjectSolicitEthicAuditService;
    @PostMapping({"/saveDetail"})
    public BaseResponse saveDetail(@RequestBody ProjectSolicitEthicAuditDto projectSolicitEthicAuditDto) {
        Long RowId= srmProjectSolicitEthicAuditService.saveDetail(projectSolicitEthicAuditDto);
        return BaseResponse.success(RowId);
    }
    @PostMapping({"/subMit"})
    public BaseResponse subMit(@RequestBody BaseDto baseDto) {
       srmProjectSolicitEthicAuditService.subMit(baseDto);
        return BaseResponse.success("提交成功!");
    }

    @PostMapping({"/listEthicAuditProjectSolicit"})
    public BaseResponse listEthicAuditProjectSolicit(@RequestBody ProjectSolicitDto projectSolicitDto) {
        IPage<ProjectSolicitEthicAuditVo> list = srmProjectSolicitEthicAuditService.listEthicAuditProjectSolicit(projectSolicitDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/listEthicAuditProjectSolicitDetail"})
    public BaseResponse listEthicAuditProjectSolicitDetail(@RequestBody ProjectSolicitEthicAuditDto projectSolicitEthicAuditDto) {
        List<ProjectSolicitEthicAuditVo> list = srmProjectSolicitEthicAuditService.listEthicAuditProjectSolicitDetail(projectSolicitEthicAuditDto);
        return BaseResponse.success(list);

    }

}
