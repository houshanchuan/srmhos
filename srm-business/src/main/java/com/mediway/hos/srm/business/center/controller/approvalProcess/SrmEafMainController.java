package com.mediway.hos.srm.business.center.controller.approvalProcess;


import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.approvalProcess.EafMainDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.approvalProcess.EafMainVo;
import com.mediway.hos.srm.business.center.service.approvalProcess.SrmEafMainService;

import java.util.List;

/**
 * <p>
 * 审批流主表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-08-21
 */
@RestController
@RequestMapping("srm/eafMain")
@Api(tags = "审批流主表")
public class SrmEafMainController {
    @Autowired
    private SrmEafMainService srmEafMainService;

    @PostMapping({"/saveEafMain"})
    public BaseResponse saveeafMain(@RequestBody List<EafMainDto> eafMainDtos) {
        srmEafMainService.saveeafMain(eafMainDtos);
        return BaseResponse.success("保存成功!");
    }
    @PostMapping({"/listEafMain"})
    public List<EafMainVo> listEafMain() {
        List<EafMainVo> list= srmEafMainService.listEafMain();
        return  list;
    }
    @PostMapping({"/deleteEafMain"})
    public BaseResponse deleteEafMain(@RequestBody BaseDto baseDto) {
        srmEafMainService.delete(baseDto);
        return BaseResponse.success("删除成功!");
    }
}
