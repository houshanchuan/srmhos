package com.mediway.hos.srm.business.center.controller.approvalProcess;


import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.approvalProcess.EafFlowDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.approvalProcess.EafFlowVo;
import com.mediway.hos.srm.business.center.service.approvalProcess.SrmEafFlowService;

import java.util.List;

/**
 * <p>
 * 各业务审批流定义
 * </p>
 *
 * @author 代码生成器
 * @since 2024-08-21
 */
@RestController
@RequestMapping("srm/eafFlow")
@Api(tags = "各业务审批流定义")
public class SrmEafFlowController {
    @Autowired
    private SrmEafFlowService srmEafFlowService;

    @PostMapping({"/saveEafFlow"})
    public BaseResponse saveEafFlow(@RequestBody List<EafFlowDto> eafFlowDtos) {

        srmEafFlowService.saveEafFlow(eafFlowDtos);
        return BaseResponse.success("保存成功!");
    }
    @PostMapping({"/listEafFlow"})
    public List<EafFlowVo> listEafFlow() {
        List<EafFlowVo> list= srmEafFlowService.listEafFlow();
        return  list;
    }
}
