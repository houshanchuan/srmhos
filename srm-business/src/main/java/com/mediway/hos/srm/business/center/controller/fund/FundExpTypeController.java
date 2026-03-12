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

import com.mediway.hos.srm.business.center.model.dto.fund.FundExpTypeDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundExpTypeVo;
import com.mediway.hos.srm.business.center.service.fund.FundExpTypeService;


/**
 * <p>
 * 支出业务类型
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@RestController
@RequestMapping("srm/fundExpType")
@Api(tags = "支出业务类型")
public class FundExpTypeController {

    @Autowired
    private FundExpTypeService fundExpTypeService;

    @PostMapping({"/saveOrUpdateFundExpType"})
    public BaseResponse saveOrUpdateFundExpType(@RequestBody BaseDataFundDto baseDataFundDto) {
        Long RowId = fundExpTypeService.saveOrUpdateFundExpType(baseDataFundDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailFundExpType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        FundExpTypeVo fundExpTypeVo = fundExpTypeService.getDetailFundExpType(RowId);
        return BaseResponse.success(fundExpTypeVo);
    }

    @PostMapping({"/listFundExpType"})
    public BaseResponse listFundExpType(@RequestBody FundExpTypeDto fundExpTypeDto) {
        IPage<FundExpTypeVo> list = fundExpTypeService.listFundExpType(fundExpTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteFundExpType"})
    public BaseResponse deleteFundExpType(@RequestBody BaseDto baseDto) {
        fundExpTypeService.deleteFundExpType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
