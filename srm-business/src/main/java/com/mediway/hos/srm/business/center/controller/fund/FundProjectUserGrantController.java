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

import com.mediway.hos.srm.business.center.model.dto.fund.FundProjectUserGrantDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundProjectUserGrantVo;
import com.mediway.hos.srm.business.center.service.fund.FundProjectUserGrantService;
/**
 * <p>
 * 项目授权分析
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@RestController
@RequestMapping("srm/fundProjectUserGrant")
@Api(tags = "项目授权分析")
public class FundProjectUserGrantController {

    @Autowired
    private FundProjectUserGrantService fundProjectUserGrantService;

    @PostMapping({"/saveOrUpdateFundProjectUserGrant"})
    public BaseResponse saveOrUpdateFundProjectUserGrant(@RequestBody BaseDataFundDto baseDataFundDto) {
        Long RowId = fundProjectUserGrantService.saveOrUpdateFundProjectUserGrant(baseDataFundDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailFundProjectUserGrant(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        FundProjectUserGrantVo fundProjectUserGrantVo = fundProjectUserGrantService.getDetailFundProjectUserGrant(RowId);
        return BaseResponse.success(fundProjectUserGrantVo);
    }

    @PostMapping({"/listFundProjectUserGrant"})
    public BaseResponse listFundProjectUserGrant(@RequestBody FundProjectUserGrantDto fundProjectUserGrantDto) {
        IPage<FundProjectUserGrantVo> list = fundProjectUserGrantService.listFundProjectUserGrant(fundProjectUserGrantDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteFundProjectUserGrant"})
    public BaseResponse deleteFundProjectUserGrant(@RequestBody BaseDto baseDto) {
        fundProjectUserGrantService.deleteFundProjectUserGrant(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
