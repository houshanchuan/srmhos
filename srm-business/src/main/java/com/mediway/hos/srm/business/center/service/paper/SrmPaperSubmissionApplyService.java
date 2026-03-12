package com.mediway.hos.srm.business.center.service.paper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperSubmissionApplyDto;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperSubmissionExpertAuditDto;
import com.mediway.hos.srm.business.center.model.entity.paper.SrmPaperSubmissionApply;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperSubmissionApplyVo;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperSubmissionExpertAuditVo;

/**
 * <p>
 * 论文投稿 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPaperSubmissionApplyService extends BaseService<SrmPaperSubmissionApply> {
    public Long savePaperSubmissionApply(PaperSubmissionApplyDto paperSubmissionApplyDto);
    IPage<PaperSubmissionApplyVo> listPaperSubmissionApply(PaperSubmissionApplyDto paperSubmissionApplyDto);

    public PaperSubmissionApplyVo getDetail(Long RowId);
    void subMit(BaseDto baseDto);
    void delete(BaseDto baseDto);
    IPage<PaperSubmissionApplyVo> listAuditPaperSubmissionApply(PaperSubmissionApplyDto paperSubmissionApplyDto);
    void audit(BaseDto baseDto);
    IPage<PaperSubmissionExpertAuditVo> listExpertAuditPaperSubmission(PaperSubmissionExpertAuditDto paperSubmissionExpertAuditDto);
}
