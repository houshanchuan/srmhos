package com.mediway.hos.srm.business.center.service.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.RewardDictDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmRewardDict;
import com.mediway.hos.srm.business.center.model.vo.baseData.RewardDictVo;

/**
 * <p>
 * 奖励字典 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmRewardDictService extends BaseService<SrmRewardDict> {
    @Transactional
    Long saveOrUpdateRewardDict(BaseDataLearningDto baseDataLearningDto);

    RewardDictVo getDetailRewardDict(Long RowId);
    IPage<RewardDictVo> listRewardDict(RewardDictDto rewardDictDto);

    void deleteRewardDict(BaseDto baseDto);

    Long getIdByName(String name);
}
