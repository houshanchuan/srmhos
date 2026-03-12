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
import com.mediway.hos.srm.business.center.service.baseData.SrmPaperThesisTypeService;
import com.mediway.hos.srm.business.center.model.dto.baseData.PaperThesisTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.PaperThesisTypeVo;
/**
 * <p>
 * 论文形式类别表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/paperThesisType")
@Api(tags = "论文形式类别表")
public class SrmPaperThesisTypeController {
    @Autowired
    private SrmPaperThesisTypeService srmPaperThesisTypeService;

    @PostMapping({"/saveOrUpdatePaperThesisType"})
    public BaseResponse saveOrUpdatePaperThesisType(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmPaperThesisTypeService.saveOrUpdatePaperThesisType(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetailPaperThesisType"})
    public BaseResponse getDetailPaperThesisType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        PaperThesisTypeVo paperThesisTypeVo = srmPaperThesisTypeService.getDetailPaperThesisType(RowId);
        return BaseResponse.success(paperThesisTypeVo);
    }

    @PostMapping({"/listPaperThesisType"})
    public BaseResponse listPaperThesisType(@RequestBody PaperThesisTypeDto paperThesisTypeDto) {
        IPage<PaperThesisTypeVo> list = srmPaperThesisTypeService.listPaperThesisType(paperThesisTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deletePaperThesisType"})
    public BaseResponse deletePaperThesisType(@RequestBody BaseDto baseDto) {
        srmPaperThesisTypeService.deletePaperThesisType(baseDto);
        return BaseResponse.success("删除成功!");

    }

}
