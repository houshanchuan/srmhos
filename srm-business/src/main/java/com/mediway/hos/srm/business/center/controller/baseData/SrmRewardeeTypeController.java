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

import com.mediway.hos.srm.business.center.service.baseData.SrmRewardeeTypeService;
import com.mediway.hos.srm.business.center.model.dto.baseData.PaperRewardeeTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.PaperRewardeeTypeVo;


/**
 * <p>
 * 论文奖励作者类型
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/rewardeeType")
@Api(tags = "论文奖励作者类型")
public class SrmRewardeeTypeController {

    @Autowired
    private SrmRewardeeTypeService srmPaperRewardeeTypeService;

    @PostMapping({"/saveOrUpdatePaperRewardeeType"})
    public BaseResponse saveOrUpdatePaperRewardeeType(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmPaperRewardeeTypeService.saveOrUpdatePaperRewardeeType(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailPaperRewardeeType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        PaperRewardeeTypeVo paperRewardeeTypeVo = srmPaperRewardeeTypeService.getDetailPaperRewardeeType(RowId);
        return BaseResponse.success(paperRewardeeTypeVo);
    }

    @PostMapping({"/listPaperRewardeeType"})
    public BaseResponse listPaperRewardeeType(@RequestBody PaperRewardeeTypeDto paperRewardeeTypeDto) {
        IPage<PaperRewardeeTypeVo> list = srmPaperRewardeeTypeService.listPaperRewardeeType(paperRewardeeTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deletePaperRewardeeType"})
    public BaseResponse deletePaperRewardeeType(@RequestBody BaseDto baseDto) {
        srmPaperRewardeeTypeService.deletePaperRewardeeType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
