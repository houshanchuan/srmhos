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

import com.mediway.hos.srm.business.center.model.dto.fund.FundProjectCategoryDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundProjectCategoryVo;
import com.mediway.hos.srm.business.center.service.fund.FundProjectCategoryService;


/**
 * <p>
 * 项目属性
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@RestController
@RequestMapping("srm/fundProjectCategory")
@Api(tags = "项目属性")
public class FundProjectCategoryController {

    @Autowired
    private FundProjectCategoryService fundProjectCategoryService;

    @PostMapping({"/saveOrUpdateFundProjectCategory"})
    public BaseResponse saveOrUpdateFundProjectCategory(@RequestBody BaseDataFundDto baseDataFundDto) {
        Long RowId = fundProjectCategoryService.saveOrUpdateFundProjectCategory(baseDataFundDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailFundProjectCategory(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        FundProjectCategoryVo fundProjectCategoryVo = fundProjectCategoryService.getDetailFundProjectCategory(RowId);
        return BaseResponse.success(fundProjectCategoryVo);
    }

    @PostMapping({"/listFundProjectCategory"})
    public BaseResponse listFundProjectCategory(@RequestBody FundProjectCategoryDto fundProjectCategoryDto) {
        IPage<FundProjectCategoryVo> list = fundProjectCategoryService.listFundProjectCategory(fundProjectCategoryDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteFundProjectCategory"})
    public BaseResponse deleteFundProjectCategory(@RequestBody BaseDto baseDto) {
        fundProjectCategoryService.deleteFundProjectCategory(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
