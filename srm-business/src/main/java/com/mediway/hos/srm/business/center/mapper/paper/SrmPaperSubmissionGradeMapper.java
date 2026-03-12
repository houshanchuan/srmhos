package com.mediway.hos.srm.business.center.mapper.paper;

import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperSubmissionGradeDto;
import com.mediway.hos.srm.business.center.model.entity.paper.SrmPaperSubmissionGrade;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperSubmissionAuditorVo;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperSubmissionGradeVo;

import java.util.List;

/**
 * <p>
 * 论文投稿同行评审表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPaperSubmissionGradeMapper extends BaseMapper<SrmPaperSubmissionGrade> {
    PaperSubmissionGradeVo getDetail(@Param("rowId") String rowId);
    void updateGradeState(@Param("paperSubmissionGradeDto") PaperSubmissionGradeDto paperSubmissionGradeDto);
    List<PaperSubmissionAuditorVo> listPaperSubmissionGrade(@Param("paperSubmissionGradeDto") PaperSubmissionGradeDto paperSubmissionGradeDto);

}
