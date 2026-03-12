package com.mediway.hos.srm.business.center.controller.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.model.dto.baseData.UnitTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.UnitTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmUnitTypeService;

/**
 * <p>
 * 单位类型代码表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/unitType")
@Api(tags = "单位类型代码表")
public class SrmUnitTypeController {

    @Autowired
    private SrmUnitTypeService srmUnitTypeService;

    @PostMapping({"/saveOrUpdateUnitType"})
    public BaseResponse saveOrUpdateUnitType(@RequestBody BaseDataUserDto baseDataUserDto) {
        Long RowId = srmUnitTypeService.saveOrUpdateUnitType(baseDataUserDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailUnitType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        UnitTypeVo unitTypeVo = srmUnitTypeService.getDetailUnitType(RowId);
        return BaseResponse.success(unitTypeVo);
    }

    @PostMapping({"/listUnitType"})
    public BaseResponse listUnitType(@RequestBody UnitTypeDto unitTypeDto) {
        IPage<UnitTypeVo> list = srmUnitTypeService.listUnitType(unitTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteUnitType"})
    public BaseResponse deleteUnitType(@RequestBody BaseDto baseDto) {
        srmUnitTypeService.deleteUnitType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
