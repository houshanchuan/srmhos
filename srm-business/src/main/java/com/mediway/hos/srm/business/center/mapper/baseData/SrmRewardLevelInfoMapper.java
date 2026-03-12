package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.RewardLevelInfoDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmRewardLevelInfo;
import com.mediway.hos.srm.business.center.model.vo.baseData.RewardLevelInfoVo;


/**
 * <p>
 * 奖励类别及奖项名称对应表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmRewardLevelInfoMapper extends BaseMapper<SrmRewardLevelInfo> {
    IPage<RewardLevelInfoVo> listRewardLevelInfo(@Param("page") Page<RewardLevelInfoVo> page, @Param("rewardLevelInfoDto") RewardLevelInfoDto rewardLevelInfoDto);
}
