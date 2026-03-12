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

import com.mediway.hos.srm.business.center.model.dto.fund.FundCheckIdentityDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundCheckIdentityVo;
import com.mediway.hos.srm.business.center.service.fund.FundCheckIdentityService;


/**
 * <p>
 * 审批流角色身份标识名称表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@RestController
@RequestMapping("srm/fundCheckIdentity")
@Api(tags = "审批流角色身份标识名称表")
public class FundCheckIdentityController {

    @Autowired
    private FundCheckIdentityService fundCheckIdentityService;

    @PostMapping({"/saveOrUpdateFundCheckIdentity"})
    public BaseResponse saveOrUpdateFundCheckIdentity(@RequestBody BaseDataFundDto baseDataFundDto) {
        Long RowId = fundCheckIdentityService.saveOrUpdateFundCheckIdentity(baseDataFundDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailFundCheckIdentity(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        FundCheckIdentityVo fundCheckIdentityVo = fundCheckIdentityService.getDetailFundCheckIdentity(RowId);
        return BaseResponse.success(fundCheckIdentityVo);
    }

    @PostMapping({"/listFundCheckIdentity"})
    public BaseResponse listFundCheckIdentity(@RequestBody FundCheckIdentityDto fundCheckIdentityDto) {
        IPage<FundCheckIdentityVo> list = fundCheckIdentityService.listFundCheckIdentity(fundCheckIdentityDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteFundCheckIdentity"})
    public BaseResponse deleteFundCheckIdentity(@RequestBody BaseDto baseDto) {
        fundCheckIdentityService.deleteFundCheckIdentity(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
