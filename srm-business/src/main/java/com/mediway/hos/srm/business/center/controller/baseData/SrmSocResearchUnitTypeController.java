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

import com.mediway.hos.srm.business.center.model.dto.baseData.SocResearchUnitTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.SocResearchUnitTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmSocResearchUnitTypeService;

/**
 * <p>
 * 机构类型（社科统计）
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/socResearchUnitType")
@Api(tags = "机构类型（社科统计）")
public class SrmSocResearchUnitTypeController {

    @Autowired
    private SrmSocResearchUnitTypeService srmSocResearchUnitTypeService;

    @PostMapping({"/saveOrUpdateSocResearchUnitType"})
    public BaseResponse saveOrUpdateSocResearchUnitType(@RequestBody BaseDataPlatformDto baseDataPlatformDto) {
        Long RowId = srmSocResearchUnitTypeService.saveOrUpdateSocResearchUnitType(baseDataPlatformDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailSocResearchUnitType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        SocResearchUnitTypeVo socResearchUnitTypeVo = srmSocResearchUnitTypeService.getDetailSocResearchUnitType(RowId);
        return BaseResponse.success(socResearchUnitTypeVo);
    }

    @PostMapping({"/listSocResearchUnitType"})
    public BaseResponse listSocResearchUnitType(@RequestBody SocResearchUnitTypeDto socResearchUnitTypeDto) {
        IPage<SocResearchUnitTypeVo> list = srmSocResearchUnitTypeService.listSocResearchUnitType(socResearchUnitTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteSocResearchUnitType"})
    public BaseResponse deleteSocResearchUnitType(@RequestBody BaseDto baseDto) {
        srmSocResearchUnitTypeService.deleteSocResearchUnitType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
