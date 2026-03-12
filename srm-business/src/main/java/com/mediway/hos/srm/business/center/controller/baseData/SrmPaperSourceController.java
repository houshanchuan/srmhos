package com.mediway.hos.srm.business.center.controller.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.PaperSourceDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.baseData.PaperSourceVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmPaperSourceService;

/**
 * <p>
 * 论文来源途径
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/paperSource")
@Api(tags = "论文来源途径")
public class SrmPaperSourceController {
    @Autowired
    private SrmPaperSourceService srmPaperSourceService;

    @PostMapping({"/saveOrUpdatePaperSource"})
    public BaseResponse saveOrUpdatePaperSource(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmPaperSourceService.saveOrUpdatePaperSource(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailPaperSource(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        PaperSourceVo paperSourceVo = srmPaperSourceService.getDetailPaperSource(RowId);
        return BaseResponse.success(paperSourceVo);
    }

    @PostMapping({"/listPaperSource"})
    public BaseResponse listPaperSource(@RequestBody PaperSourceDto paperSourceDto) {
        IPage<PaperSourceVo> list = srmPaperSourceService.listPaperSource(paperSourceDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deletePaperSource"})
    public BaseResponse deletePaperSource(@RequestBody BaseDto baseDto) {
        srmPaperSourceService.deletePaperSource(baseDto);
        return BaseResponse.success("删除成功!");

    }

}
