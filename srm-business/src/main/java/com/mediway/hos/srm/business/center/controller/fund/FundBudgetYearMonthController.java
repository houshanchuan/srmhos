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

import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetYearMonthDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetYearMonthVo;
import com.mediway.hos.srm.business.center.service.fund.FundBudgetYearMonthService;
/**
 * <p>
 * 预算年月定义表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@RestController
@RequestMapping("srm/fundBudgetYearMonth")
@Api(tags = "预算年月定义表")
public class FundBudgetYearMonthController {

    @Autowired
    private FundBudgetYearMonthService fundBudgetYearMonthService;

    @PostMapping({"/saveOrUpdateFundBudgetYearMonth"})
    public BaseResponse saveOrUpdateFundBudgetYearMonth(@RequestBody BaseDataFundDto baseDataFundDto) {
        Long RowId = fundBudgetYearMonthService.saveOrUpdateFundBudgetYearMonth(baseDataFundDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailFundBudgetYearMonth(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        FundBudgetYearMonthVo fundBudgetYearMonthVo = fundBudgetYearMonthService.getDetailFundBudgetYearMonth(RowId);
        return BaseResponse.success(fundBudgetYearMonthVo);
    }

    @PostMapping({"/listFundBudgetYearMonth"})
    public BaseResponse listFundBudgetYearMonth(@RequestBody FundBudgetYearMonthDto fundBudgetYearMonthDto) {
        IPage<FundBudgetYearMonthVo> list = fundBudgetYearMonthService.listFundBudgetYearMonth(fundBudgetYearMonthDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteFundBudgetYearMonth"})
    public BaseResponse deleteFundBudgetYearMonth(@RequestBody BaseDto baseDto) {
        fundBudgetYearMonthService.deleteFundBudgetYearMonth(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
