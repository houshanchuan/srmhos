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

import com.mediway.hos.srm.business.center.model.dto.baseData.ResearchUnitTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ResearchUnitTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmResearchUnitTypeService;

/**
 * <p>
 * 科研机构类型
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/researchUnitType")
@Api(tags = "科研机构类型")
public class SrmResearchUnitTypeController {

    @Autowired
    private SrmResearchUnitTypeService srmResearchUnitTypeService;

    @PostMapping({"/saveOrUpdateResearchUnitType"})
    public BaseResponse saveOrUpdateResearchUnitType(@RequestBody BaseDataPlatformDto baseDataPlatformDto) {
        Long RowId = srmResearchUnitTypeService.saveOrUpdateResearchUnitType(baseDataPlatformDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailResearchUnitType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ResearchUnitTypeVo researchUnitTypeVo = srmResearchUnitTypeService.getDetailResearchUnitType(RowId);
        return BaseResponse.success(researchUnitTypeVo);
    }

    @PostMapping({"/listResearchUnitType"})
    public BaseResponse listResearchUnitType(@RequestBody ResearchUnitTypeDto researchUnitTypeDto) {
        IPage<ResearchUnitTypeVo> list = srmResearchUnitTypeService.listResearchUnitType(researchUnitTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteResearchUnitType"})
    public BaseResponse deleteResearchUnitType(@RequestBody BaseDto baseDto) {
        srmResearchUnitTypeService.deleteResearchUnitType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
