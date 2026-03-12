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

import com.mediway.hos.srm.business.center.model.dto.fund.FundProjectInfoDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundProjectInfoVo;
import com.mediway.hos.srm.business.center.service.fund.FundProjectInfoService;
/**
 * <p>
 * 项目字典表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-25
 */
@RestController
@RequestMapping("fundProjectInfo")
@Api(tags = "项目字典表")
public class FundProjectInfoController {

    @Autowired
    private FundProjectInfoService fundProjectInfoService;

    @PostMapping({"/saveOrUpdateFundProjectInfo"})
    public BaseResponse saveOrUpdateFundProjectInfo(@RequestBody BaseDataFundDto baseDataFundDto) {
        Long RowId = fundProjectInfoService.saveOrUpdateFundProjectInfo(baseDataFundDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailFundProjectInfo(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        FundProjectInfoVo fundProjectInfoVo = fundProjectInfoService.getDetailFundProjectInfo(RowId);
        return BaseResponse.success(fundProjectInfoVo);
    }

    @PostMapping({"/listFundProjectInfo"})
    public BaseResponse listFundProjectInfo(@RequestBody FundProjectInfoDto fundProjectInfoDto) {
        IPage<FundProjectInfoVo> list = fundProjectInfoService.listFundProjectInfo(fundProjectInfoDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteFundProjectInfo"})
    public BaseResponse deleteFundProjectInfo(@RequestBody BaseDto baseDto) {
        fundProjectInfoService.deleteFundProjectInfo(baseDto);
        return BaseResponse.success("删除成功!");

    }
    @PostMapping({"/getProject"})
    public BaseResponse getProject(@RequestBody FundProjectInfoDto fundProjectInfoDto) {
        fundProjectInfoService.getProject();
        return BaseResponse.success("删除成功!");

    }

}
