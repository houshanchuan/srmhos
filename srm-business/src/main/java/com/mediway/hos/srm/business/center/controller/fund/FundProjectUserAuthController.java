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

import com.mediway.hos.srm.business.center.model.dto.fund.FundProjectUserAuthDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundProjectUserAuthVo;
import com.mediway.hos.srm.business.center.service.fund.FundProjectUserAuthService;

/**
 * <p>
 * 预算项目授权
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@RestController
@RequestMapping("srm/fundProjectUserAuth")
@Api(tags = "预算项目授权")
public class FundProjectUserAuthController {

    @Autowired
    private FundProjectUserAuthService fundProjectUserAuthService;

    @PostMapping({"/saveOrUpdateFundProjectUserAuth"})
    public BaseResponse saveOrUpdateFundProjectUserAuth(@RequestBody BaseDataFundDto baseDataFundDto) {
        Long RowId = fundProjectUserAuthService.saveOrUpdateFundProjectUserAuth(baseDataFundDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailFundProjectUserAuth(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        FundProjectUserAuthVo fundProjectUserAuthVo = fundProjectUserAuthService.getDetailFundProjectUserAuth(RowId);
        return BaseResponse.success(fundProjectUserAuthVo);
    }

    @PostMapping({"/listFundProjectUserAuth"})
    public BaseResponse listFundProjectUserAuth(@RequestBody FundProjectUserAuthDto fundProjectUserAuthDto) {
        IPage<FundProjectUserAuthVo> list = fundProjectUserAuthService.listFundProjectUserAuth(fundProjectUserAuthDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteFundProjectUserAuth"})
    public BaseResponse deleteFundProjectUserAuth(@RequestBody BaseDto baseDto) {
        fundProjectUserAuthService.deleteFundProjectUserAuth(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
