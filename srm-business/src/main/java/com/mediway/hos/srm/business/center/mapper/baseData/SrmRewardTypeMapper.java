package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.RewardTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmRewardType;
import com.mediway.hos.srm.business.center.model.vo.baseData.RewardTypeVo;


/**
 * <p>
 * 获奖类型表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmRewardTypeMapper extends BaseMapper<SrmRewardType> {	   
    List<CombVo> getRewardType();
    IPage<RewardTypeVo> listRewardType(@Param("page") Page<RewardTypeVo> page, @Param("rewardTypeDto") RewardTypeDto rewardTypeDto);
}
