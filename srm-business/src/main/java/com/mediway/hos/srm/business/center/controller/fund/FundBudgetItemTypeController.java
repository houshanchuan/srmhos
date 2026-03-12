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

import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetItemTypeDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetItemTypeVo;
import com.mediway.hos.srm.business.center.service.fund.FundBudgetItemTypeService;
/**
 * <p>
 * 预算项（科目）类别
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@RestController
@RequestMapping("srm/fundBudgetItemType")
@Api(tags = "预算项（科目）类别")
public class FundBudgetItemTypeController {

    @Autowired
    private FundBudgetItemTypeService fundBudgetItemTypeService;

    @PostMapping({"/saveOrUpdateFundBudgetItemType"})
    public BaseResponse saveOrUpdateFundBudgetItemType(@RequestBody BaseDataFundDto baseDataFundDto) {
        Long RowId = fundBudgetItemTypeService.saveOrUpdateFundBudgetItemType(baseDataFundDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailFundBudgetItemType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        FundBudgetItemTypeVo fundBudgetItemTypeVo = fundBudgetItemTypeService.getDetailFundBudgetItemType(RowId);
        return BaseResponse.success(fundBudgetItemTypeVo);
    }

    @PostMapping({"/listFundBudgetItemType"})
    public BaseResponse listFundBudgetItemType(@RequestBody FundBudgetItemTypeDto fundBudgetItemTypeDto) {
        IPage<FundBudgetItemTypeVo> list = fundBudgetItemTypeService.listFundBudgetItemType(fundBudgetItemTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteFundBudgetItemType"})
    public BaseResponse deleteFundBudgetItemType(@RequestBody BaseDto baseDto) {
        fundBudgetItemTypeService.deleteFundBudgetItemType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
