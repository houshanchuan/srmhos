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

import com.mediway.hos.srm.business.center.model.dto.fund.FundBillStateDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBillStateVo;
import com.mediway.hos.srm.business.center.service.fund.FundBillStateService;

/**
 * <p>
 * 经费单据状态
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@RestController
@RequestMapping("srm/fundBillState")
@Api(tags = "经费单据状态")
public class FundBillStateController {

    @Autowired
    private FundBillStateService fundBillStateService;

    @PostMapping({"/saveOrUpdateFundBillState"})
    public BaseResponse saveOrUpdateFundBillState(@RequestBody BaseDataFundDto baseDataFundDto) {
        Long RowId = fundBillStateService.saveOrUpdateFundBillState(baseDataFundDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailFundBillState(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        FundBillStateVo fundBillStateVo = fundBillStateService.getDetailFundBillState(RowId);
        return BaseResponse.success(fundBillStateVo);
    }

    @PostMapping({"/listFundBillState"})
    public BaseResponse listFundBillState(@RequestBody FundBillStateDto fundBillStateDto) {
        IPage<FundBillStateVo> list = fundBillStateService.listFundBillState(fundBillStateDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteFundBillState"})
    public BaseResponse deleteFundBillState(@RequestBody BaseDto baseDto) {
        fundBillStateService.deleteFundBillState(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
