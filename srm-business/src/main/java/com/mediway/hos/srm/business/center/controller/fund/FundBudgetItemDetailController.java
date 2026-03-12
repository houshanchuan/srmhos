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

import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetItemDetailDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetItemDetailVo;
import com.mediway.hos.srm.business.center.service.fund.FundBudgetItemDetailService;
/**
 * <p>
 * 预算科目明细项
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@RestController
@RequestMapping("srm/fundBudgetItemDetail")
@Api(tags = "预算科目明细项")
public class FundBudgetItemDetailController {

    @Autowired
    private FundBudgetItemDetailService fundBudgetItemDetailService;

    @PostMapping({"/saveOrUpdateFundBudgetItemDetail"})
    public BaseResponse saveOrUpdateFundBudgetItemDetail(@RequestBody BaseDataFundDto baseDataFundDto) {
        Long RowId = fundBudgetItemDetailService.saveOrUpdateFundBudgetItemDetail(baseDataFundDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailFundBudgetItemDetail(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        FundBudgetItemDetailVo fundBudgetItemDetailVo = fundBudgetItemDetailService.getDetailFundBudgetItemDetail(RowId);
        return BaseResponse.success(fundBudgetItemDetailVo);
    }

    @PostMapping({"/listFundBudgetItemDetail"})
    public BaseResponse listFundBudgetItemDetail(@RequestBody FundBudgetItemDetailDto fundBudgetItemDetailDto) {
        IPage<FundBudgetItemDetailVo> list = fundBudgetItemDetailService.listFundBudgetItemDetail(fundBudgetItemDetailDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteFundBudgetItemDetail"})
    public BaseResponse deleteFundBudgetItemDetail(@RequestBody BaseDto baseDto) {
        fundBudgetItemDetailService.deleteFundBudgetItemDetail(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
