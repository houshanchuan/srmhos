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

import com.mediway.hos.srm.business.center.model.dto.fund.FundTypeDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundTypeVo;
import com.mediway.hos.srm.business.center.service.fund.FundTypeService;
/**
 * <p>
 * 项目资金来源类型表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@RestController
@RequestMapping("srm/fundType")
@Api(tags = "项目资金来源类型表")
public class FundTypeController {

    @Autowired
    private FundTypeService fundTypeService;

    @PostMapping({"/saveOrUpdateFundType"})
    public BaseResponse saveOrUpdateFundType(@RequestBody BaseDataFundDto baseDataFundDto) {
        Long RowId = fundTypeService.saveOrUpdateFundType(baseDataFundDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailFundType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        FundTypeVo fundTypeVo = fundTypeService.getDetailFundType(RowId);
        return BaseResponse.success(fundTypeVo);
    }

    @PostMapping({"/listFundType"})
    public BaseResponse listFundType(@RequestBody FundTypeDto fundTypeDto) {
        IPage<FundTypeVo> list = fundTypeService.listFundType(fundTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteFundType"})
    public BaseResponse deleteFundType(@RequestBody BaseDto baseDto) {
        fundTypeService.deleteFundType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
