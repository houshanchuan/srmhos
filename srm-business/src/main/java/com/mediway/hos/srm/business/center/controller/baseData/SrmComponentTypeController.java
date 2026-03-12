package com.mediway.hos.srm.business.center.controller.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataPlatformDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.model.dto.baseData.ComponentTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ComponentTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmComponentTypeService;

/**
 * <p>
 * 机构组成类型
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/componentType")
@Api(tags = "机构组成类型")
public class SrmComponentTypeController {


    @Autowired
    private SrmComponentTypeService srmComponentTypeService;

    @PostMapping({"/saveOrUpdateComponentType"})
    public BaseResponse saveOrUpdateComponentType(@RequestBody BaseDataPlatformDto baseDataPlatformDto) {
        Long RowId = srmComponentTypeService.saveOrUpdateComponentType(baseDataPlatformDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailComponentType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ComponentTypeVo componentTypeVo = srmComponentTypeService.getDetailComponentType(RowId);
        return BaseResponse.success(componentTypeVo);
    }

    @PostMapping({"/listComponentType"})
    public BaseResponse listComponentType(@RequestBody ComponentTypeDto componentTypeDto) {
        IPage<ComponentTypeVo> list = srmComponentTypeService.listComponentType(componentTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteComponentType"})
    public BaseResponse deleteComponentType(@RequestBody BaseDto baseDto) {
        srmComponentTypeService.deleteComponentType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
