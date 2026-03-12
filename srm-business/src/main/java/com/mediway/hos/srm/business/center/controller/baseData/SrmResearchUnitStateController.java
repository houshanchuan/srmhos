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

import com.mediway.hos.srm.business.center.model.dto.baseData.ResearchUnitStateDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ResearchUnitStateVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmResearchUnitStateService;

/**
 * <p>
 * 机构状态
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/researchUnitState")
@Api(tags = "机构状态")
public class SrmResearchUnitStateController {

    @Autowired
    private SrmResearchUnitStateService srmResearchUnitStateService;

    @PostMapping({"/saveOrUpdateResearchUnitState"})
    public BaseResponse saveOrUpdateResearchUnitState(@RequestBody BaseDataPlatformDto baseDataPlatformDto) {
        Long RowId = srmResearchUnitStateService.saveOrUpdateResearchUnitState(baseDataPlatformDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailResearchUnitState(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ResearchUnitStateVo researchUnitStateVo = srmResearchUnitStateService.getDetailResearchUnitState(RowId);
        return BaseResponse.success(researchUnitStateVo);
    }

    @PostMapping({"/listResearchUnitState"})
    public BaseResponse listResearchUnitState(@RequestBody ResearchUnitStateDto researchUnitStateDto) {
        IPage<ResearchUnitStateVo> list = srmResearchUnitStateService.listResearchUnitState(researchUnitStateDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteResearchUnitState"})
    public BaseResponse deleteResearchUnitState(@RequestBody BaseDto baseDto) {
        srmResearchUnitStateService.deleteResearchUnitState(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
