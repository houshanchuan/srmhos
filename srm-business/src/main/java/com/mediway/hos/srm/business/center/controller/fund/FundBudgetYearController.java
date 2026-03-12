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

import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetYearDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetYearVo;
import com.mediway.hos.srm.business.center.service.fund.FundBudgetYearService;

/**
 * <p>
 * 预算年度表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@RestController
@RequestMapping("srm/fundBudgetYear")
@Api(tags = "预算年度表")
public class FundBudgetYearController {

    @Autowired
    private FundBudgetYearService fundBudgetYearService;

    @PostMapping({"/saveOrUpdateFundBudgetYear"})
    public BaseResponse saveOrUpdateFundBudgetYear(@RequestBody BaseDataFundDto baseDataFundDto) {
        Long RowId = fundBudgetYearService.saveOrUpdateFundBudgetYear(baseDataFundDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailFundBudgetYear(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        FundBudgetYearVo fundBudgetYearVo = fundBudgetYearService.getDetailFundBudgetYear(RowId);
        return BaseResponse.success(fundBudgetYearVo);
    }

    @PostMapping({"/listFundBudgetYear"})
    public BaseResponse listFundBudgetYear(@RequestBody FundBudgetYearDto fundBudgetYearDto) {
        IPage<FundBudgetYearVo> list = fundBudgetYearService.listFundBudgetYear(fundBudgetYearDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteFundBudgetYear"})
    public BaseResponse deleteFundBudgetYear(@RequestBody BaseDto baseDto) {
        fundBudgetYearService.deleteFundBudgetYear(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
