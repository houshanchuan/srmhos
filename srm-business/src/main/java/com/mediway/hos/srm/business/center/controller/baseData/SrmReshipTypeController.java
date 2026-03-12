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

import com.mediway.hos.srm.business.center.service.baseData.SrmReshipTypeService;
import com.mediway.hos.srm.business.center.model.dto.baseData.PaperReshipTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.PaperReshipTypeVo;

/**
 * <p>
 * 转载类型
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/reshipType")
@Api(tags = "转载类型")
public class SrmReshipTypeController {
    @Autowired
    private SrmReshipTypeService srmReshipTypeService;

    @PostMapping({"/saveOrUpdatePaperReshipType"})
    public BaseResponse saveOrUpdatePaperReshipType(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmReshipTypeService.saveOrUpdatePaperReshipType(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailPaperReshipType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        PaperReshipTypeVo paperReshipTypeVo = srmReshipTypeService.getDetailPaperReshipType(RowId);
        return BaseResponse.success(paperReshipTypeVo);
    }

    @PostMapping({"/listPaperReshipType"})
    public BaseResponse listPaperReshipType(@RequestBody PaperReshipTypeDto paperReshipTypeDto) {
        IPage<PaperReshipTypeVo> list = srmReshipTypeService.listPaperReshipType(paperReshipTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deletePaperReshipType"})
    public BaseResponse deletePaperReshipType(@RequestBody BaseDto baseDto) {
        srmReshipTypeService.deletePaperReshipType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
