package com.mediway.hos.srm.business.center.controller.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.service.baseData.SrmFundSourceTypeService;
import com.mediway.hos.srm.business.center.model.dto.fund.FundSourceTypeDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundSourceTypeVo;

/**
 * <p>
 * 费用来源类型
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/fundSourceType")
@Api(tags = "费用来源类型")
public class SrmFundSourceTypeController {
    @Autowired
    private SrmFundSourceTypeService srmFundSourceTypeService;

    @PostMapping({"/saveOrUpdateFundSourceType"})
    public BaseResponse saveOrUpdateFundSourceType(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmFundSourceTypeService.saveOrUpdateFundSourceType(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailFundSourceType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        FundSourceTypeVo fundSourceTypeVo = srmFundSourceTypeService.getDetailFundSourceType(RowId);
        return BaseResponse.success(fundSourceTypeVo);
    }

    @PostMapping({"/listFundSourceType"})
    public BaseResponse listFundSourceType(@RequestBody FundSourceTypeDto fundSourceTypeDto) {
        IPage<FundSourceTypeVo> list = srmFundSourceTypeService.listFundSourceType(fundSourceTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteFundSourceType"})
    public BaseResponse deleteFundSourceType(@RequestBody BaseDto baseDto) {
        srmFundSourceTypeService.deleteFundSourceType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
