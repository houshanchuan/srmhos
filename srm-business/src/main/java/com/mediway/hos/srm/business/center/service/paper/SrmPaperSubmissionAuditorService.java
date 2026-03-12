package com.mediway.hos.srm.business.center.service.paper;

import com.mediway.hos.srm.business.center.model.dto.paper.PaperSubmissionAuditorDto;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperSubmissionGradeDto;

import com.mediway.hos.srm.business.center.model.entity.paper.SrmPaperSubmissionAuditor;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperSubmissionAuditorVo;

import java.util.List;

/**
 * <p>
 * 论文投稿评审专家表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPaperSubmissionAuditorService extends BaseService<SrmPaperSubmissionAuditor> {
    List<PaperSubmissionAuditorVo> getNoAllotExpert(PaperSubmissionAuditorDto paperSubmissionAuditorDto);
    List<PaperSubmissionAuditorVo> getAllotExpert(PaperSubmissionAuditorDto paperSubmissionAuditorDto);
    void allotExpert(PaperSubmissionAuditorDto paperSubmissionAuditorDto);
    void deleteExpert(PaperSubmissionGradeDto paperSubmissionGradeDto);

}
