package com.mediway.hos.srm.business.center.service.award;

import com.mediway.hos.srm.business.center.model.dto.award.AwardApplyAuthorDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.entity.award.SrmAwardApplyAuthor;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.award.AwardApplyAuthorVo;

import java.util.List;

/**
 * <p>
 * 成果获奖申报作者 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmAwardApplyAuthorService extends BaseService<SrmAwardApplyAuthor> {
    void deleteAuthorByApplyId(Long awardApplyId);
    public List<AwardApplyAuthorVo> listAwardApplyAuthor(BaseDto baseDto);
    void deleteAuthorById(BaseDto baseDto);
    Long saveAuthor(AwardApplyAuthorDto awardApplyAuthorDto);
}
