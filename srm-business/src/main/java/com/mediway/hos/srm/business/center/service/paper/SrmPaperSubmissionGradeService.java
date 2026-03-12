package com.mediway.hos.srm.business.center.service.paper;

import com.mediway.hos.srm.business.center.model.dto.paper.PaperSubmissionGradeDto;
import com.mediway.hos.srm.business.center.model.entity.paper.SrmPaperSubmissionGrade;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperSubmissionAuditorVo;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperSubmissionGradeVo;

import java.util.List;

/**
 * <p>
 * 论文投稿同行评审表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPaperSubmissionGradeService extends BaseService<SrmPaperSubmissionGrade> {
    void savePaperSubmissionGrade(PaperSubmissionGradeDto paperSubmissionGradeDto);

    Long saveDetail(PaperSubmissionGradeDto paperSubmissionGradeDto);
    List<PaperSubmissionAuditorVo> listPaperSubmissionGrade(PaperSubmissionGradeDto paperSubmissionGradeDto);

    //IPage<PaperSubmissionGradeVo> listAuditPaperSubmissionGrade(ProjectSolicitDto projectSolicitDto);

    void subMit(PaperSubmissionGradeDto paperSubmissionGradeDto);

    PaperSubmissionGradeVo getDetail(String rowId);
}
