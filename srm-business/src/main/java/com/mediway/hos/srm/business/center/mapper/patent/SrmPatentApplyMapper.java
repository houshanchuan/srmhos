package com.mediway.hos.srm.business.center.mapper.patent;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperSubmissionExpertAuditDto;
import com.mediway.hos.srm.business.center.model.dto.patent.PatentApplyDto;
import com.mediway.hos.srm.business.center.model.entity.patent.SrmPatentApply;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperSubmissionExpertAuditVo;
import com.mediway.hos.srm.business.center.model.vo.patent.PatentApplyVo;

import java.time.LocalDateTime;

/**
 * <p>
 * 专利申报 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPatentApplyMapper extends BaseMapper<SrmPatentApply> {
    PatentApplyVo getDetail(@Param("rowId") String rowId);
    IPage<PatentApplyVo> listPatentApply(@Param("page") Page<PatentApplyVo> page, @Param("patentApplyDto") PatentApplyDto patentApplyDto);
    void updateStatus(@Param("rowId") Long rowId, @Param("status") Integer status, @Param("checkStatus") String checkStatus, @Param("serialNo") String serialNo, @Param("subDate") LocalDateTime subDate, @Param("subUserId") String subUserId);
    IPage<PatentApplyVo> listAuditPatentApply(@Param("page") Page<PatentApplyVo> page, @Param("patentApplyDto") PatentApplyDto patentApplyDto);
    IPage<PaperSubmissionExpertAuditVo> listExpertAuditPatentApply(@Param("page") Page<PaperSubmissionExpertAuditVo> page, @Param("paperSubmissionExpertAuditDto") PaperSubmissionExpertAuditDto paperSubmissionExpertAuditDto);

}
