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

import com.mediway.hos.srm.business.center.model.dto.baseData.ResearchUnitLevelDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ResearchUnitLevelVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmResearchUnitLevelService;

/**
 * <p>
 * 科研机构级别
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/researchUnitLevel")
@Api(tags = "科研机构级别")
public class SrmResearchUnitLevelController {

    @Autowired
    private SrmResearchUnitLevelService srmResearchUnitLevelService;

    @PostMapping({"/saveOrUpdateResearchUnitLevel"})
    public BaseResponse saveOrUpdateResearchUnitLevel(@RequestBody BaseDataPlatformDto baseDataPlatformDto) {
        Long RowId = srmResearchUnitLevelService.saveOrUpdateResearchUnitLevel(baseDataPlatformDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailResearchUnitLevel(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ResearchUnitLevelVo researchUnitLevelVo = srmResearchUnitLevelService.getDetailResearchUnitLevel(RowId);
        return BaseResponse.success(researchUnitLevelVo);
    }

    @PostMapping({"/listResearchUnitLevel"})
    public BaseResponse listResearchUnitLevel(@RequestBody ResearchUnitLevelDto researchUnitLevelDto) {
        IPage<ResearchUnitLevelVo> list = srmResearchUnitLevelService.listResearchUnitLevel(researchUnitLevelDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteResearchUnitLevel"})
    public BaseResponse deleteResearchUnitLevel(@RequestBody BaseDto baseDto) {
        srmResearchUnitLevelService.deleteResearchUnitLevel(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
