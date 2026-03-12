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

import com.mediway.hos.srm.business.center.model.dto.fund.FundTravelVehicleDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundTravelVehicleVo;
import com.mediway.hos.srm.business.center.service.fund.FundTravelVehicleService;

/**
 * <p>
 * 交通工具
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@RestController
@RequestMapping("srm/fundTravelVehicle")
@Api(tags = "交通工具")
public class FundTravelVehicleController {

    @Autowired
    private FundTravelVehicleService fundTravelVehicleService;

    @PostMapping({"/saveOrUpdateFundTravelVehicle"})
    public BaseResponse saveOrUpdateFundTravelVehicle(@RequestBody BaseDataFundDto baseDataFundDto) {
        Long RowId = fundTravelVehicleService.saveOrUpdateFundTravelVehicle(baseDataFundDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailFundTravelVehicle(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        FundTravelVehicleVo fundTravelVehicleVo = fundTravelVehicleService.getDetailFundTravelVehicle(RowId);
        return BaseResponse.success(fundTravelVehicleVo);
    }

    @PostMapping({"/listFundTravelVehicle"})
    public BaseResponse listFundTravelVehicle(@RequestBody FundTravelVehicleDto fundTravelVehicleDto) {
        IPage<FundTravelVehicleVo> list = fundTravelVehicleService.listFundTravelVehicle(fundTravelVehicleDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteFundTravelVehicle"})
    public BaseResponse deleteFundTravelVehicle(@RequestBody BaseDto baseDto) {
        fundTravelVehicleService.deleteFundTravelVehicle(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
