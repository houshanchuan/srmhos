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

import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetItemDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetItemVo;
import com.mediway.hos.srm.business.center.service.fund.FundBudgetItemService;

/**
 * <p>
 * 预算项目(科目)表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@RestController
@RequestMapping("srm/fundBudgetItem")
@Api(tags = "预算项目(科目)表")
public class FundBudgetItemController {

    @Autowired
    private FundBudgetItemService fundBudgetItemService;

    @PostMapping({"/saveOrUpdateFundBudgetItem"})
    public BaseResponse saveOrUpdateFundBudgetItem(@RequestBody BaseDataFundDto baseDataFundDto) {
        Long RowId = fundBudgetItemService.saveOrUpdateFundBudgetItem(baseDataFundDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailFundBudgetItem(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        FundBudgetItemVo fundBudgetItemVo = fundBudgetItemService.getDetailFundBudgetItem(RowId);
        return BaseResponse.success(fundBudgetItemVo);
    }

    @PostMapping({"/listFundBudgetItem"})
    public BaseResponse listFundBudgetItem(@RequestBody FundBudgetItemDto fundBudgetItemDto) {
        IPage<FundBudgetItemVo> list = fundBudgetItemService.listFundBudgetItem(fundBudgetItemDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteFundBudgetItem"})
    public BaseResponse deleteFundBudgetItem(@RequestBody BaseDto baseDto) {
        fundBudgetItemService.deleteFundBudgetItem(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
