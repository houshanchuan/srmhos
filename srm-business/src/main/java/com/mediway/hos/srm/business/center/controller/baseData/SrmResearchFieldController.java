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


import com.mediway.hos.srm.business.center.service.baseData.SrmResearchFieldService;
import com.mediway.hos.srm.business.center.model.dto.baseData.ResearchFieldDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ResearchFieldVo;
/**
 * <p>
 * 研究领域
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/researchField")
@Api(tags = "研究领域")
public class SrmResearchFieldController {
    @Autowired
    private SrmResearchFieldService srmResearchFieldService;

    @PostMapping({"/saveOrUpdateResearchField"})
    public BaseResponse saveOrUpdateResearchField(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmResearchFieldService.saveOrUpdateResearchField(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailResearchField(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ResearchFieldVo researchFieldVo = srmResearchFieldService.getDetailResearchField(RowId);
        return BaseResponse.success(researchFieldVo);
    }

    @PostMapping({"/listResearchField"})
    public BaseResponse listResearchField(@RequestBody ResearchFieldDto researchFieldDto) {
        IPage<ResearchFieldVo> list = srmResearchFieldService.listResearchField(researchFieldDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteResearchField"})
    public BaseResponse deleteResearchField(@RequestBody BaseDto baseDto) {
        srmResearchFieldService.deleteResearchField(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
