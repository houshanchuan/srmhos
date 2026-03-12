package com.mediway.hos.srm.business.center.service.award;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.srm.business.center.model.dto.award.AchievementDto;
import com.mediway.hos.srm.business.center.model.dto.award.AchievementMainDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;

import com.mediway.hos.srm.business.center.model.entity.award.SrmAchievement;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.award.AchievementVo;

/**
 * <p>
 * 成果获奖登记 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmAchievementService extends BaseService<SrmAchievement> {
    AchievementVo getDetail(String rowId);
    Long saveAchievement(AchievementMainDto achievementMainDto);

    IPage<AchievementVo> listAchievement(AchievementDto achievementDto);

    void deleteAchievement(BaseDto baseDto);
    void subMit(BaseDto baseDto);

    void audit(BaseDto baseDto);
    IPage<AchievementVo> listAuditAchievement(AchievementDto achievementDto);
}
