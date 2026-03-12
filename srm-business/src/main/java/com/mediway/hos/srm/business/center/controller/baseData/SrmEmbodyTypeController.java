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

import com.mediway.hos.srm.business.center.service.baseData.SrmEmbodyTypeService;
import com.mediway.hos.srm.business.center.model.dto.baseData.PaperEmbodyTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.PaperEmbodyTypeVo;
/**
 * <p>
 * 收录类型
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-01
 */
@RestController
@RequestMapping("srm/embodyType")
@Api(tags = "收录类型")
public class SrmEmbodyTypeController {
    @Autowired
    private SrmEmbodyTypeService srmEmbodyTypeService;

    @PostMapping({"/saveOrUpdatePaperEmbodyType"})
    public BaseResponse saveOrUpdatePaperEmbodyType(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmEmbodyTypeService.saveOrUpdatePaperEmbodyType(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailPaperEmbodyType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        PaperEmbodyTypeVo paperEmbodyTypeVo = srmEmbodyTypeService.getDetailPaperEmbodyType(RowId);
        return BaseResponse.success(paperEmbodyTypeVo);
    }

    @PostMapping({"/listPaperEmbodyType"})
    public BaseResponse listPaperEmbodyType(@RequestBody PaperEmbodyTypeDto paperEmbodyTypeDto) {
        IPage<PaperEmbodyTypeVo> list = srmEmbodyTypeService.listPaperEmbodyType(paperEmbodyTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deletePaperEmbodyType"})
    public BaseResponse deletePaperEmbodyType(@RequestBody BaseDto baseDto) {
        srmEmbodyTypeService.deletePaperEmbodyType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
