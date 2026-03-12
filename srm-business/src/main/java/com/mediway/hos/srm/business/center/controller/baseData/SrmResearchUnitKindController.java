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

import com.mediway.hos.srm.business.center.model.dto.baseData.ResearchUnitKindDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ResearchUnitKindVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmResearchUnitKindService;


/**
 * <p>
 * 科研机构性质
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/researchUnitKind")
@Api(tags = "科研机构性质")
public class SrmResearchUnitKindController {

    @Autowired
    private SrmResearchUnitKindService srmResearchUnitKindService;

    @PostMapping({"/saveOrUpdateResearchUnitKind"})
    public BaseResponse saveOrUpdateResearchUnitKind(@RequestBody BaseDataPlatformDto baseDataPlatformDto) {
        Long RowId = srmResearchUnitKindService.saveOrUpdateResearchUnitKind(baseDataPlatformDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailResearchUnitKind(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ResearchUnitKindVo researchUnitKindVo = srmResearchUnitKindService.getDetailResearchUnitKind(RowId);
        return BaseResponse.success(researchUnitKindVo);
    }

    @PostMapping({"/listResearchUnitKind"})
    public BaseResponse listResearchUnitKind(@RequestBody ResearchUnitKindDto researchUnitKindDto) {
        IPage<ResearchUnitKindVo> list = srmResearchUnitKindService.listResearchUnitKind(researchUnitKindDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteResearchUnitKind"})
    public BaseResponse deleteResearchUnitKind(@RequestBody BaseDto baseDto) {
        srmResearchUnitKindService.deleteResearchUnitKind(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
