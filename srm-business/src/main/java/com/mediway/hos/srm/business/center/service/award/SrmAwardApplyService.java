package com.mediway.hos.srm.business.center.service.award;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.srm.business.center.model.dto.award.AwardApplyDto;
import com.mediway.hos.srm.business.center.model.dto.award.AwardApplyMainDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperSubmissionExpertAuditDto;

import com.mediway.hos.srm.business.center.model.entity.award.SrmAwardApply;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.award.AwardApplyVo;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperSubmissionExpertAuditVo;

/**
 * <p>
 * 获奖申报 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmAwardApplyService extends BaseService<SrmAwardApply> {
    AwardApplyVo getDetail(String rowId);
    Long saveAwardApply(AwardApplyMainDto awardApplyMainDto);

    IPage<AwardApplyVo> listAwardApply(AwardApplyDto awardApplyDto);

    void deleteAwardApply(BaseDto baseDto);
    void subMit(BaseDto baseDto);

    void audit(BaseDto baseDto);
    IPage<AwardApplyVo> listAuditAwardApply(AwardApplyDto awardApplyDto);
    IPage<PaperSubmissionExpertAuditVo> listExpertAuditAwardApply(PaperSubmissionExpertAuditDto paperSubmissionExpertAuditDto);
}
