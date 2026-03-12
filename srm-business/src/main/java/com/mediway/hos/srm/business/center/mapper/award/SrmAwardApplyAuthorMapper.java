package com.mediway.hos.srm.business.center.mapper.award;

import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.entity.award.SrmAwardApplyAuthor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.award.AwardApplyAuthorVo;

import java.util.List;

/**
 * <p>
 * 成果获奖申报作者 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmAwardApplyAuthorMapper extends BaseMapper<SrmAwardApplyAuthor> {
    List<AwardApplyAuthorVo> listAwardApplyAuthor(@Param("awardApplyId") Long awardApplyId);
    void deleteAuthorByApplyId(@Param("awardApplyId") Long awardApplyId);
}
