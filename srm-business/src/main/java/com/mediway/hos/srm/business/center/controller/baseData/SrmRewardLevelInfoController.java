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


import com.mediway.hos.srm.business.center.service.baseData.SrmRewardLevelInfoService;
import com.mediway.hos.srm.business.center.model.dto.baseData.RewardLevelInfoDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.RewardLevelInfoVo;

/**
 * <p>
 * 奖励类别及奖项名称对应表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/rewardLevelInfo")
@Api(tags = "奖励类别及奖项名称对应表")
public class SrmRewardLevelInfoController {
    @Autowired
    private SrmRewardLevelInfoService srmRewardLevelInfoService;

    @PostMapping({"/saveOrUpdateRewardLevelInfo"})
    public BaseResponse saveOrUpdateRewardLevelInfo(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmRewardLevelInfoService.saveOrUpdateRewardLevelInfo(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailRewardLevelInfo(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        RewardLevelInfoVo rewardLevelInfoVo = srmRewardLevelInfoService.getDetailRewardLevelInfo(RowId);
        return BaseResponse.success(rewardLevelInfoVo);
    }

    @PostMapping({"/listRewardLevelInfo"})
    public BaseResponse listRewardLevelInfo(@RequestBody RewardLevelInfoDto rewardLevelInfoDto) {
        IPage<RewardLevelInfoVo> list = srmRewardLevelInfoService.listRewardLevelInfo(rewardLevelInfoDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteRewardLevelInfo"})
    public BaseResponse deleteRewardLevelInfo(@RequestBody BaseDto baseDto) {
        srmRewardLevelInfoService.deleteRewardLevelInfo(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
