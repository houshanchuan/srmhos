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

import com.mediway.hos.srm.business.center.model.dto.baseData.CooperateUnitTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.CooperateUnitTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmCooperateUnitTypeService;


/**
 * <p>
 * 合作单位类型
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/cooperateUnitType")
@Api(tags = "合作单位类型")
public class SrmCooperateUnitTypeController {

    @Autowired
    private SrmCooperateUnitTypeService srmCooperateUnitTypeService;

    @PostMapping({"/saveOrUpdateCooperateUnitType"})
    public BaseResponse saveOrUpdateCooperateUnitType(@RequestBody BaseDataProjDto baseDataProjDto) {
        Long RowId = srmCooperateUnitTypeService.saveOrUpdateCooperateUnitType(baseDataProjDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailCooperateUnitType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        CooperateUnitTypeVo cooperateUnitTypeVo = srmCooperateUnitTypeService.getDetailCooperateUnitType(RowId);
        return BaseResponse.success(cooperateUnitTypeVo);
    }

    @PostMapping({"/listCooperateUnitType"})
    public BaseResponse listCooperateUnitType(@RequestBody CooperateUnitTypeDto cooperateUnitTypeDto) {
        IPage<CooperateUnitTypeVo> list = srmCooperateUnitTypeService.listCooperateUnitType(cooperateUnitTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteCooperateUnitType"})
    public BaseResponse deleteCooperateUnitType(@RequestBody BaseDto baseDto) {
        srmCooperateUnitTypeService.deleteCooperateUnitType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
