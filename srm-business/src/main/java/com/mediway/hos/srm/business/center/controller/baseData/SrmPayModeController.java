package com.mediway.hos.srm.business.center.controller.baseData;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.model.dto.baseData.PayModeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.PayModeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmPayModeService;
/**
 * <p>
 * 支付方式
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/payMode")
@Api(tags = "支付方式")
public class SrmPayModeController {

    @Autowired
    private SrmPayModeService srmPayModeService;

    @PostMapping({"/saveOrUpdatePayMode"})
    public BaseResponse saveOrUpdatePayMode(@RequestBody BaseDataProjDto baseDataProjDto) {
        Long RowId = srmPayModeService.saveOrUpdatePayMode(baseDataProjDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailPayMode(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        PayModeVo payModeVo = srmPayModeService.getDetailPayMode(RowId);
        return BaseResponse.success(payModeVo);
    }

    @PostMapping({"/listPayMode"})
    public BaseResponse listPayMode(@RequestBody PayModeDto payModeDto) {
        IPage<PayModeVo> list = srmPayModeService.listPayMode(payModeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deletePayMode"})
    public BaseResponse deletePayMode(@RequestBody BaseDto baseDto) {
        srmPayModeService.deletePayMode(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
