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

import com.mediway.hos.srm.business.center.model.dto.baseData.PayTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.PayTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmPayTypeService;

/**
 * <p>
 * 付款类型
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/payType")
@Api(tags = "付款类型")
public class SrmPayTypeController {

    @Autowired
    private SrmPayTypeService srmPayTypeService;

    @PostMapping({"/saveOrUpdatePayType"})
    public BaseResponse saveOrUpdatePayType(@RequestBody BaseDataProjDto baseDataProjDto) {
        Long RowId = srmPayTypeService.saveOrUpdatePayType(baseDataProjDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailPayType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        PayTypeVo payTypeVo = srmPayTypeService.getDetailPayType(RowId);
        return BaseResponse.success(payTypeVo);
    }

    @PostMapping({"/listPayType"})
    public BaseResponse listPayType(@RequestBody PayTypeDto payTypeDto) {
        IPage<PayTypeVo> list = srmPayTypeService.listPayType(payTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deletePayType"})
    public BaseResponse deletePayType(@RequestBody BaseDto baseDto) {
        srmPayTypeService.deletePayType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
