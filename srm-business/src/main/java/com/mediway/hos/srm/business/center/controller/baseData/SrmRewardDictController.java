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

import com.mediway.hos.srm.business.center.service.baseData.SrmRewardDictService;
import com.mediway.hos.srm.business.center.model.dto.baseData.RewardDictDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.RewardDictVo;


/**
 * <p>
 * 奖励字典
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/rewardDict")
@Api(tags = "奖励字典")
public class SrmRewardDictController {
    @Autowired
    private SrmRewardDictService srmRewardDictService;

    @PostMapping({"/saveOrUpdateRewardDict"})
    public BaseResponse saveOrUpdateRewardDict(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmRewardDictService.saveOrUpdateRewardDict(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailRewardDict(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        RewardDictVo rewardDictVo = srmRewardDictService.getDetailRewardDict(RowId);
        return BaseResponse.success(rewardDictVo);
    }

    @PostMapping({"/listRewardDict"})
    public BaseResponse listRewardDict(@RequestBody RewardDictDto rewardDictDto) {
        IPage<RewardDictVo> list = srmRewardDictService.listRewardDict(rewardDictDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteRewardDict"})
    public BaseResponse deleteRewardDict(@RequestBody BaseDto baseDto) {
        srmRewardDictService.deleteRewardDict(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
