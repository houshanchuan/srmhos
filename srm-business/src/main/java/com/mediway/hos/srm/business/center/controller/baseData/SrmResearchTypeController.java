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


import com.mediway.hos.srm.business.center.service.baseData.SrmResearchTypeService;
import com.mediway.hos.srm.business.center.model.dto.baseData.ResearchTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ResearchTypeVo;

/**
 * <p>
 * 研究类型表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/researchType")
@Api(tags = "研究类型表")
public class SrmResearchTypeController {
    @Autowired
    private SrmResearchTypeService srmResearchTypeService;

    @PostMapping({"/saveOrUpdateResearchType"})
    public BaseResponse saveOrUpdateResearchType(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmResearchTypeService.saveOrUpdateResearchType(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailResearchType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ResearchTypeVo researchTypeVo = srmResearchTypeService.getDetailResearchType(RowId);
        return BaseResponse.success(researchTypeVo);
    }

    @PostMapping({"/listResearchType"})
    public BaseResponse listResearchType(@RequestBody ResearchTypeDto researchTypeDto) {
        IPage<ResearchTypeVo> list = srmResearchTypeService.listResearchType(researchTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteResearchType"})
    public BaseResponse deleteResearchType(@RequestBody BaseDto baseDto) {
        srmResearchTypeService.deleteResearchType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
