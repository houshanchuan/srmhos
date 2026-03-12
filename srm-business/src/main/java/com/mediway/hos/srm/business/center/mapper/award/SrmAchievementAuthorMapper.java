package com.mediway.hos.srm.business.center.mapper.award;

import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.entity.award.SrmAchievementAuthor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.award.AchievementAuthorVo;

import java.util.List;

/**
 * <p>
 * 获奖成果作者表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmAchievementAuthorMapper extends BaseMapper<SrmAchievementAuthor> {
    List<AchievementAuthorVo> listAchievementAuthor(@Param("parentId") Long parentId);
    void deleteAuthorByParentId(@Param("parentId") Long parentId);
}
