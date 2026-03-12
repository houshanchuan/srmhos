package com.mediway.hos.srm.business.center.controller.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataCommonDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.model.dto.baseData.EafCheckStatusDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.EafCheckStatusVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmEafCheckStatusService;

/**
 * <p>
 * 审批流审核结果代码
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/eafCheckStatus")
@Api(tags = "审批流审核结果代码")
public class SrmEafCheckStatusController {

    @Autowired
    private SrmEafCheckStatusService srmEafCheckStatusService;

    @PostMapping({"/saveOrUpdateEafCheckStatus"})
    public BaseResponse saveOrUpdateEafCheckStatus(@RequestBody BaseDataCommonDto baseDataProjDto) {
        Long RowId = srmEafCheckStatusService.saveOrUpdateEafCheckStatus(baseDataProjDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailEafCheckStatus(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        EafCheckStatusVo eafCheckStatusVo = srmEafCheckStatusService.getDetailEafCheckStatus(RowId);
        return BaseResponse.success(eafCheckStatusVo);
    }

    @PostMapping({"/listEafCheckStatus"})
    public BaseResponse listEafCheckStatus(@RequestBody EafCheckStatusDto eafCheckStatusDto) {
        IPage<EafCheckStatusVo> list = srmEafCheckStatusService.listEafCheckStatus(eafCheckStatusDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteEafCheckStatus"})
    public BaseResponse deleteEafCheckStatus(@RequestBody BaseDto baseDto) {
        srmEafCheckStatusService.deleteEafCheckStatus(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
