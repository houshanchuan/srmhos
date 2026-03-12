package com.mediway.hos.srm.business.center.service.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.dto.baseData.RewardLevelInfoDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmRewardLevelInfo;
import com.mediway.hos.srm.business.center.model.vo.baseData.RewardLevelInfoVo;


/**
 * <p>
 * 奖励类别及奖项名称对应表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmRewardLevelInfoService extends BaseService<SrmRewardLevelInfo> {
    @Transactional
    Long saveOrUpdateRewardLevelInfo(BaseDataLearningDto baseDataLearningDto);

    RewardLevelInfoVo getDetailRewardLevelInfo(Long RowId);
    IPage<RewardLevelInfoVo> listRewardLevelInfo(RewardLevelInfoDto rewardLevelInfoDto);

    void deleteRewardLevelInfo(BaseDto baseDto);

    Long getIdByName(String name);
}
