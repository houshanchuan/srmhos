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

import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetDeptGrantDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetDeptGrantVo;
import com.mediway.hos.srm.business.center.service.fund.FundBudgetDeptGrantService;


/**
 * <p>
 * 预算科室访问权限
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@RestController
@RequestMapping("srm/fundBudgetDeptGrant")
@Api(tags = "预算科室访问权限")
public class FundBudgetDeptGrantController {

    @Autowired
    private FundBudgetDeptGrantService fundBudgetDeptGrantService;

    @PostMapping({"/saveOrUpdateFundBudgetDeptGrant"})
    public BaseResponse saveOrUpdateFundBudgetDeptGrant(@RequestBody BaseDataFundDto baseDataFundDto) {
        Long RowId = fundBudgetDeptGrantService.saveOrUpdateFundBudgetDeptGrant(baseDataFundDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailFundBudgetDeptGrant(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        FundBudgetDeptGrantVo fundBudgetDeptGrantVo = fundBudgetDeptGrantService.getDetailFundBudgetDeptGrant(RowId);
        return BaseResponse.success(fundBudgetDeptGrantVo);
    }

    @PostMapping({"/listFundBudgetDeptGrant"})
    public BaseResponse listFundBudgetDeptGrant(@RequestBody FundBudgetDeptGrantDto fundBudgetDeptGrantDto) {
        IPage<FundBudgetDeptGrantVo> list = fundBudgetDeptGrantService.listFundBudgetDeptGrant(fundBudgetDeptGrantDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteFundBudgetDeptGrant"})
    public BaseResponse deleteFundBudgetDeptGrant(@RequestBody BaseDto baseDto) {
        fundBudgetDeptGrantService.deleteFundBudgetDeptGrant(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
