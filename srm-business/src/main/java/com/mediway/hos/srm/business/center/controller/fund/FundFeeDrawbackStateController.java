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

import com.mediway.hos.srm.business.center.model.dto.fund.FundFeeDrawbackStateDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundFeeDrawbackStateVo;
import com.mediway.hos.srm.business.center.service.fund.FundFeeDrawbackStateService;


/**
 * <p>
 * 费用退税状态
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@RestController
@RequestMapping("srm/fundFeeDrawbackState")
@Api(tags = "费用退税状态")
public class FundFeeDrawbackStateController {


    @Autowired
    private FundFeeDrawbackStateService fundFeeDrawbackStateService;

    @PostMapping({"/saveOrUpdateFundFeeDrawbackState"})
    public BaseResponse saveOrUpdateFundFeeDrawbackState(@RequestBody BaseDataFundDto baseDataFundDto) {
        Long RowId = fundFeeDrawbackStateService.saveOrUpdateFundFeeDrawbackState(baseDataFundDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailFundFeeDrawbackState(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        FundFeeDrawbackStateVo fundFeeDrawbackStateVo = fundFeeDrawbackStateService.getDetailFundFeeDrawbackState(RowId);
        return BaseResponse.success(fundFeeDrawbackStateVo);
    }

    @PostMapping({"/listFundFeeDrawbackState"})
    public BaseResponse listFundFeeDrawbackState(@RequestBody FundFeeDrawbackStateDto fundFeeDrawbackStateDto) {
        IPage<FundFeeDrawbackStateVo> list = fundFeeDrawbackStateService.listFundFeeDrawbackState(fundFeeDrawbackStateDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteFundFeeDrawbackState"})
    public BaseResponse deleteFundFeeDrawbackState(@RequestBody BaseDto baseDto) {
        fundFeeDrawbackStateService.deleteFundFeeDrawbackState(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
