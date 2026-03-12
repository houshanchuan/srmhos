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

import com.mediway.hos.srm.business.center.model.dto.fund.FundBillCheckStateDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBillCheckStateVo;
import com.mediway.hos.srm.business.center.service.fund.FundBillCheckStateService;
/**
 * <p>
 * 单据审核状态
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@RestController
@RequestMapping("srm/fundBillCheckState")
@Api(tags = "单据审核状态")
public class FundBillCheckStateController {

    @Autowired
    private FundBillCheckStateService fundBillCheckStateService;

    @PostMapping({"/saveOrUpdateFundBillCheckState"})
    public BaseResponse saveOrUpdateFundBillCheckState(@RequestBody BaseDataFundDto baseDataFundDto) {
        Long RowId = fundBillCheckStateService.saveOrUpdateFundBillCheckState(baseDataFundDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailFundBillCheckState(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        FundBillCheckStateVo fundBillCheckStateVo = fundBillCheckStateService.getDetailFundBillCheckState(RowId);
        return BaseResponse.success(fundBillCheckStateVo);
    }

    @PostMapping({"/listFundBillCheckState"})
    public BaseResponse listFundBillCheckState(@RequestBody FundBillCheckStateDto fundBillCheckStateDto) {
        IPage<FundBillCheckStateVo> list = fundBillCheckStateService.listFundBillCheckState(fundBillCheckStateDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteFundBillCheckState"})
    public BaseResponse deleteFundBillCheckState(@RequestBody BaseDto baseDto) {
        fundBillCheckStateService.deleteFundBillCheckState(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
