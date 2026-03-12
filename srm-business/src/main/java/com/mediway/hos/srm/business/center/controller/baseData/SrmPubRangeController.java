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

import com.mediway.hos.srm.business.center.service.baseData.SrmPubRangeService;
import com.mediway.hos.srm.business.center.model.dto.baseData.PubRangeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.PubRangeVo;


/**
 * <p>
 * 发表范围
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/pubRange")
@Api(tags = "发表范围")
public class SrmPubRangeController {
    @Autowired
    private SrmPubRangeService srmPubRangeService;

    @PostMapping({"/saveOrUpdatePubRange"})
    public BaseResponse saveOrUpdatePubRange(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmPubRangeService.saveOrUpdatePubRange(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailPubRange(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        PubRangeVo pubRangeVo = srmPubRangeService.getDetailPubRange(RowId);
        return BaseResponse.success(pubRangeVo);
    }

    @PostMapping({"/listPubRange"})
    public BaseResponse listPubRange(@RequestBody PubRangeDto pubRangeDto) {
        IPage<PubRangeVo> list = srmPubRangeService.listPubRange(pubRangeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deletePubRange"})
    public BaseResponse deletePubRange(@RequestBody BaseDto baseDto) {
        srmPubRangeService.deletePubRange(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
