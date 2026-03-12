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

import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetEstablishTypeDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetEstablishTypeVo;
import com.mediway.hos.srm.business.center.service.fund.FundBudgetEstablishTypeService;

/**
 * <p>
 * 预算编制类型
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@RestController
@RequestMapping("srm/fundBudgetEstablishType")
@Api(tags = "预算编制类型")
public class FundBudgetEstablishTypeController {

    @Autowired
    private FundBudgetEstablishTypeService fundBudgetEstablishTypeService;

    @PostMapping({"/saveOrUpdateFundBudgetEstablishType"})
    public BaseResponse saveOrUpdateFundBudgetEstablishType(@RequestBody BaseDataFundDto baseDataFundDto) {
        Long RowId = fundBudgetEstablishTypeService.saveOrUpdateFundBudgetEstablishType(baseDataFundDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailFundBudgetEstablishType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        FundBudgetEstablishTypeVo fundBudgetEstablishTypeVo = fundBudgetEstablishTypeService.getDetailFundBudgetEstablishType(RowId);
        return BaseResponse.success(fundBudgetEstablishTypeVo);
    }

    @PostMapping({"/listFundBudgetEstablishType"})
    public BaseResponse listFundBudgetEstablishType(@RequestBody FundBudgetEstablishTypeDto fundBudgetEstablishTypeDto) {
        IPage<FundBudgetEstablishTypeVo> list = fundBudgetEstablishTypeService.listFundBudgetEstablishType(fundBudgetEstablishTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteFundBudgetEstablishType"})
    public BaseResponse deleteFundBudgetEstablishType(@RequestBody BaseDto baseDto) {
        fundBudgetEstablishTypeService.deleteFundBudgetEstablishType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
