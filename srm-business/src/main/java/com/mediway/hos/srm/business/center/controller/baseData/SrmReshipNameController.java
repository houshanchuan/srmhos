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


import com.mediway.hos.srm.business.center.service.baseData.SrmReshipNameService;
import com.mediway.hos.srm.business.center.model.dto.baseData.PaperReshipNameDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.PaperReshipNameVo;


/**
 * <p>
 * 转载名称
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/reshipName")
@Api(tags = "转载名称")
public class SrmReshipNameController {

    @Autowired
    private SrmReshipNameService srmReshipNameService;

    @PostMapping({"/saveOrUpdatePaperReshipName"})
    public BaseResponse saveOrUpdatePaperReshipName(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmReshipNameService.saveOrUpdatePaperReshipName(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailPaperReshipName(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        PaperReshipNameVo yyyyVo = srmReshipNameService.getDetailPaperReshipName(RowId);
        return BaseResponse.success(yyyyVo);
    }

    @PostMapping({"/listPaperReshipName"})
    public BaseResponse listPaperReshipName(@RequestBody PaperReshipNameDto yyyyDto) {
        IPage<PaperReshipNameVo> list = srmReshipNameService.listPaperReshipName(yyyyDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deletePaperReshipName"})
    public BaseResponse deletePaperReshipName(@RequestBody BaseDto baseDto) {
        srmReshipNameService.deletePaperReshipName(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
