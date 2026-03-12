package com.mediway.hos.srm.business.center.controller.fund;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataFundDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetFeeTypeDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetFeeTypeVo;
import com.mediway.hos.srm.business.center.service.fund.FundBudgetFeeTypeService;

/**
 * <p>
 * 预算资金类型
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@RestController
@RequestMapping("srm/fundBudgetFeeType")
@Api(tags = "预算资金类型")
public class FundBudgetFeeTypeController {

    @Autowired
    private FundBudgetFeeTypeService fundBudgetFeeTypeService;

    @PostMapping({"/saveOrUpdateFundBudgetFeeType"})
    public BaseResponse saveOrUpdateFundBudgetFeeType(@RequestBody BaseDataFundDto baseDataFundDto) {
        Long RowId = fundBudgetFeeTypeService.saveOrUpdateFundBudgetFeeType(baseDataFundDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailFundBudgetFeeType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        FundBudgetFeeTypeVo fundBudgetFeeTypeVo = fundBudgetFeeTypeService.getDetailFundBudgetFeeType(RowId);
        return BaseResponse.success(fundBudgetFeeTypeVo);
    }

    @PostMapping({"/listFundBudgetFeeType"})
    public BaseResponse listFundBudgetFeeType(@RequestBody FundBudgetFeeTypeDto fundBudgetFeeTypeDto) {
        IPage<FundBudgetFeeTypeVo> list = fundBudgetFeeTypeService.listFundBudgetFeeType(fundBudgetFeeTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteFundBudgetFeeType"})
    public BaseResponse deleteFundBudgetFeeType(@RequestBody BaseDto baseDto) {
        fundBudgetFeeTypeService.deleteFundBudgetFeeType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
