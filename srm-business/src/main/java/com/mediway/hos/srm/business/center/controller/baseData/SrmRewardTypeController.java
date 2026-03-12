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

import com.mediway.hos.srm.business.center.service.baseData.SrmRewardTypeService;
import com.mediway.hos.srm.business.center.model.dto.baseData.RewardTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.RewardTypeVo;


/**
 * <p>
 * 获奖类型表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/rewardType")
@Api(tags = "获奖类型表")
public class SrmRewardTypeController {
    @Autowired
    private SrmRewardTypeService srmRewardTypeService;

    @PostMapping({"/saveOrUpdateRewardType"})
    public BaseResponse saveOrUpdateRewardType(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmRewardTypeService.saveOrUpdateRewardType(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailRewardType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        RewardTypeVo rewardTypeVo = srmRewardTypeService.getDetailRewardType(RowId);
        return BaseResponse.success(rewardTypeVo);
    }

    @PostMapping({"/listRewardType"})
    public BaseResponse listRewardType(@RequestBody RewardTypeDto rewardTypeDto) {
        IPage<RewardTypeVo> list = srmRewardTypeService.listRewardType(rewardTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteRewardType"})
    public BaseResponse deleteRewardType(@RequestBody BaseDto baseDto) {
        srmRewardTypeService.deleteRewardType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
