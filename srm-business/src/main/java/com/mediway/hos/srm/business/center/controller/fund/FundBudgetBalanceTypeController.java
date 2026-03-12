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

import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetBalanceTypeDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetBalanceTypeVo;
import com.mediway.hos.srm.business.center.service.fund.FundBudgetBalanceTypeService;

/**
 * <p>
 * 预算结余计算方式 
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@RestController
@RequestMapping("srm/fundBudgetBalanceType")
@Api(tags = "预算结余计算方式 ")
public class FundBudgetBalanceTypeController {

    @Autowired
    private FundBudgetBalanceTypeService fundBudgetBalanceTypeService;

    @PostMapping({"/saveOrUpdateFundBudgetBalanceType"})
    public BaseResponse saveOrUpdateFundBudgetBalanceType(@RequestBody BaseDataFundDto baseDataFundDto) {
        Long RowId = fundBudgetBalanceTypeService.saveOrUpdateFundBudgetBalanceType(baseDataFundDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailFundBudgetBalanceType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        FundBudgetBalanceTypeVo fundBudgetBalanceTypeVo = fundBudgetBalanceTypeService.getDetailFundBudgetBalanceType(RowId);
        return BaseResponse.success(fundBudgetBalanceTypeVo);
    }

    @PostMapping({"/listFundBudgetBalanceType"})
    public BaseResponse listFundBudgetBalanceType(@RequestBody FundBudgetBalanceTypeDto fundBudgetBalanceTypeDto) {
        IPage<FundBudgetBalanceTypeVo> list = fundBudgetBalanceTypeService.listFundBudgetBalanceType(fundBudgetBalanceTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteFundBudgetBalanceType"})
    public BaseResponse deleteFundBudgetBalanceType(@RequestBody BaseDto baseDto) {
        fundBudgetBalanceTypeService.deleteFundBudgetBalanceType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
