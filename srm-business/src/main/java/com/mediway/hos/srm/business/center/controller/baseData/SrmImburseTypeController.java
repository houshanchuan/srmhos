package com.mediway.hos.srm.business.center.controller.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.model.dto.baseData.ImburseTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ImburseTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmImburseTypeService;
/**
 * <p>
 * 资助方式代码表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/imburseType")
@Api(tags = "资助方式代码表")
public class SrmImburseTypeController {

    @Autowired
    private SrmImburseTypeService srmImburseTypeService;

    @PostMapping({"/saveOrUpdateImburseType"})
    public BaseResponse saveOrUpdateImburseType(@RequestBody BaseDataProjDto baseDataProjDto) {
        Long RowId = srmImburseTypeService.saveOrUpdateImburseType(baseDataProjDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailImburseType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ImburseTypeVo imburseTypeVo = srmImburseTypeService.getDetailImburseType(RowId);
        return BaseResponse.success(imburseTypeVo);
    }

    @PostMapping({"/listImburseType"})
    public BaseResponse listImburseType(@RequestBody ImburseTypeDto imburseTypeDto) {
        IPage<ImburseTypeVo> list = srmImburseTypeService.listImburseType(imburseTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteImburseType"})
    public BaseResponse deleteImburseType(@RequestBody BaseDto baseDto) {
        srmImburseTypeService.deleteImburseType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
