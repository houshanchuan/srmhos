package com.mediway.hos.srm.business.center.mapper.paper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperSubmissionApplyDto;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperSubmissionExpertAuditDto;
import com.mediway.hos.srm.business.center.model.entity.paper.SrmPaperSubmissionApply;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperSubmissionApplyVo;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperSubmissionExpertAuditVo;

import java.time.LocalDateTime;

/**
 * <p>
 * 论文投稿 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPaperSubmissionApplyMapper extends BaseMapper<SrmPaperSubmissionApply> {
    IPage<PaperSubmissionApplyVo> listPaperSubmissionApply(@Param("page") Page<PaperSubmissionApplyVo> page, @Param("paperSubmissionApplyDto") PaperSubmissionApplyDto paperSubmissionApplyDto);
    PaperSubmissionApplyVo getDetail(@Param("rowId") Long rowId);
    void updateStatus(@Param("rowId") Long rowId, @Param("status") Integer status, @Param("checkStatus") String checkStatus, @Param("serialNo") String serialNo, @Param("subDate") LocalDateTime subDate, @Param("subUserId") String subUserId);
    IPage<PaperSubmissionApplyVo> listAuditPaperSubmissionApply(@Param("page") Page<PaperSubmissionApplyVo> page, @Param("paperSubmissionApplyDto") PaperSubmissionApplyDto paperSubmissionApplyDto);

    IPage<PaperSubmissionExpertAuditVo> listExpertAuditPaperSubmission(@Param("page") Page<PaperSubmissionExpertAuditVo> page, @Param("paperSubmissionExpertAuditDto") PaperSubmissionExpertAuditDto paperSubmissionExpertAuditDto);

}
