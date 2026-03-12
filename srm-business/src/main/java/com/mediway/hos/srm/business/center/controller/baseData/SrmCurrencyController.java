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
import com.mediway.hos.srm.business.center.model.dto.baseData.CurrencyDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.CurrencyVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmCurrencyService;

/**
 * <p>
 * 币种
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/currency")
@Api(tags = "币种")
public class SrmCurrencyController {

    @Autowired
    private SrmCurrencyService srmCurrencyService;

    @PostMapping({"/saveOrUpdateCurrency"})
    public BaseResponse saveOrUpdateCurrency(@RequestBody BaseDataProjDto baseDataProjDto) {
        Long RowId = srmCurrencyService.saveOrUpdateCurrency(baseDataProjDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailCurrency(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        CurrencyVo currencyVo = srmCurrencyService.getDetailCurrency(RowId);
        return BaseResponse.success(currencyVo);
    }

    @PostMapping({"/listCurrency"})
    public BaseResponse listCurrency(@RequestBody CurrencyDto currencyDto) {
        IPage<CurrencyVo> list = srmCurrencyService.listCurrency(currencyDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteCurrency"})
    public BaseResponse deleteCurrency(@RequestBody BaseDto baseDto) {
        srmCurrencyService.deleteCurrency(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
