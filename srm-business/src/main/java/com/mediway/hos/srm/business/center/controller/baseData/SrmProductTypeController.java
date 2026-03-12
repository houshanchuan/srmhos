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

import com.mediway.hos.srm.business.center.service.baseData.SrmProductTypeService;
import com.mediway.hos.srm.business.center.model.dto.baseData.ProductTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProductTypeVo;


/**
 * <p>
 * 成果类型
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/productType")
@Api(tags = "成果类型")
public class SrmProductTypeController {
    @Autowired
    private SrmProductTypeService srmProductTypeService;

    @PostMapping({"/saveOrUpdateProductType"})
    public BaseResponse saveOrUpdateProductType(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmProductTypeService.saveOrUpdateProductType(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailProductType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ProductTypeVo productTypeVo = srmProductTypeService.getDetailProductType(RowId);
        return BaseResponse.success(productTypeVo);
    }

    @PostMapping({"/listProductType"})
    public BaseResponse listProductType(@RequestBody ProductTypeDto productTypeDto) {
        IPage<ProductTypeVo> list = srmProductTypeService.listProductType(productTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteProductType"})
    public BaseResponse deleteProductType(@RequestBody BaseDto baseDto) {
        srmProductTypeService.deleteProductType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
