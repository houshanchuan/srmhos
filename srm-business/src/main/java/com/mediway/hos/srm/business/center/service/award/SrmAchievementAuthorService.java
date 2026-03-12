package com.mediway.hos.srm.business.center.service.award;

import com.mediway.hos.srm.business.center.model.dto.award.AchievementAuthorDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.entity.award.SrmAchievementAuthor;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.award.AchievementAuthorVo;

import java.util.List;

/**
 * <p>
 * 获奖成果作者表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmAchievementAuthorService extends BaseService<SrmAchievementAuthor> {
    List<AchievementAuthorVo> listAchievementAuthor(BaseDto baseDto);
    void deleteAuthorByParentId(Long parentId);
    void deleteAuthorById(BaseDto baseDto);
    Long saveAuthor(AchievementAuthorDto achievementAuthorDto);
}
