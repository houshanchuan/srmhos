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

import com.mediway.hos.srm.business.center.service.baseData.SrmProductModeService;
import com.mediway.hos.srm.business.center.model.dto.baseData.ProductModeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProductModeVo;


/**
 * <p>
 * 成果(产品)模式
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/productMode")
@Api(tags = "成果(产品)模式")
public class SrmProductModeController {
    @Autowired
    private SrmProductModeService srmProductModeService;

    @PostMapping({"/saveOrUpdateProductMode"})
    public BaseResponse saveOrUpdateProductMode(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmProductModeService.saveOrUpdateProductMode(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailProductMode(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ProductModeVo productModeVo = srmProductModeService.getDetailProductMode(RowId);
        return BaseResponse.success(productModeVo);
    }

    @PostMapping({"/listProductMode"})
    public BaseResponse listProductMode(@RequestBody ProductModeDto productModeDto) {
        IPage<ProductModeVo> list = srmProductModeService.listProductMode(productModeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteProductMode"})
    public BaseResponse deleteProductMode(@RequestBody BaseDto baseDto) {
        srmProductModeService.deleteProductMode(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
