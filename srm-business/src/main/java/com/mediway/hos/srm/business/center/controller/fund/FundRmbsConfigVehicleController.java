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

import com.mediway.hos.srm.business.center.model.dto.fund.FundRmbsConfigVehicleDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundRmbsConfigVehicleVo;
import com.mediway.hos.srm.business.center.service.fund.FundRmbsConfigVehicleService;
/**
 * <p>
 * 交通工具费用报销标准配置表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@RestController
@RequestMapping("srm/fundRmbsConfigVehicle")
@Api(tags = "交通工具费用报销标准配置表")
public class FundRmbsConfigVehicleController {

    @Autowired
    private FundRmbsConfigVehicleService fundRmbsConfigVehicleService;

    @PostMapping({"/saveOrUpdateFundRmbsConfigVehicle"})
    public BaseResponse saveOrUpdateFundRmbsConfigVehicle(@RequestBody BaseDataFundDto baseDataFundDto) {
        Long RowId = fundRmbsConfigVehicleService.saveOrUpdateFundRmbsConfigVehicle(baseDataFundDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailFundRmbsConfigVehicle(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        FundRmbsConfigVehicleVo fundRmbsConfigVehicleVo = fundRmbsConfigVehicleService.getDetailFundRmbsConfigVehicle(RowId);
        return BaseResponse.success(fundRmbsConfigVehicleVo);
    }

    @PostMapping({"/listFundRmbsConfigVehicle"})
    public BaseResponse listFundRmbsConfigVehicle(@RequestBody FundRmbsConfigVehicleDto fundRmbsConfigVehicleDto) {
        IPage<FundRmbsConfigVehicleVo> list = fundRmbsConfigVehicleService.listFundRmbsConfigVehicle(fundRmbsConfigVehicleDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteFundRmbsConfigVehicle"})
    public BaseResponse deleteFundRmbsConfigVehicle(@RequestBody BaseDto baseDto) {
        fundRmbsConfigVehicleService.deleteFundRmbsConfigVehicle(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
