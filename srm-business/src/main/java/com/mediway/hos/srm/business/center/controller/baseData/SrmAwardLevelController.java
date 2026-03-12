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

import com.mediway.hos.srm.business.center.service.baseData.SrmAwardLevelService;
import com.mediway.hos.srm.business.center.model.dto.baseData.AwardLevelDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.AwardLevelVo;

/**
 * <p>
 * 获奖级别
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/awardLevel")
@Api(tags = "获奖级别")
public class SrmAwardLevelController {
    @Autowired
    private SrmAwardLevelService srmAwardLevelService;

    @PostMapping({"/saveOrUpdateAwardLevel"})
    public BaseResponse saveOrUpdateAwardLevel(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmAwardLevelService.saveOrUpdateAwardLevel(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailAwardLevel(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        AwardLevelVo awardLevelVo = srmAwardLevelService.getDetailAwardLevel(RowId);
        return BaseResponse.success(awardLevelVo);
    }

    @PostMapping({"/listAwardLevel"})
    public BaseResponse listAwardLevel(@RequestBody AwardLevelDto awardLevelDto) {
        IPage<AwardLevelVo> list = srmAwardLevelService.listAwardLevel(awardLevelDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteAwardLevel"})
    public BaseResponse deleteAwardLevel(@RequestBody BaseDto baseDto) {
        srmAwardLevelService.deleteAwardLevel(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
