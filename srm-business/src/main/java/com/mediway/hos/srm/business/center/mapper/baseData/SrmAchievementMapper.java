package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.dto.award.AchievementDto;
import com.mediway.hos.srm.business.center.model.entity.award.SrmAchievement;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.award.AchievementVo;

import java.time.LocalDateTime;

/**
 * <p>
 * 成果获奖登记 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmAchievementMapper extends BaseMapper<SrmAchievement> {
    AchievementVo getDetail(@Param("rowId") String rowId);
    IPage<AchievementVo> listAchievement(@Param("page") Page<AchievementVo> page, @Param("achievementDto") AchievementDto achievementDto);
    void updateStatus(@Param("rowId") Long rowId, @Param("status") Integer status, @Param("checkStatus") String checkStatus, @Param("subDate") LocalDateTime subDate, @Param("subUserId") String subUserId);
    IPage<AchievementVo> listAuditAchievement(@Param("page") Page<AchievementVo> page, @Param("achievementDto") AchievementDto achievementDto);
}
