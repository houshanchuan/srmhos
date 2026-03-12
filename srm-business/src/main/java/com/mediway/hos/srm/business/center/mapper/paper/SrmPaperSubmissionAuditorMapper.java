package com.mediway.hos.srm.business.center.mapper.paper;

import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperSubmissionAuditorDto;

import com.mediway.hos.srm.business.center.model.entity.paper.SrmPaperSubmissionAuditor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperSubmissionAuditorVo;


import java.util.List;

/**
 * <p>
 * 论文投稿评审专家表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPaperSubmissionAuditorMapper extends BaseMapper<SrmPaperSubmissionAuditor> {
    String getCurExpertList(@Param("sysNo") String sysNo, @Param("appRowId") Long appRowId);
    List<PaperSubmissionAuditorVo> getNoAllotExpert();
    String getRowId(@Param("paperSubmissionAuditorDto") PaperSubmissionAuditorDto paperSubmissionAuditorDto);
    void updateExpertAudit(@Param("sysNo") String sysNo, @Param("appRowId") String appRowId,@Param("expertList") String expertList);
    PaperSubmissionAuditorVo getMainInfo(@Param("paperSubmissionAuditorDto") PaperSubmissionAuditorDto paperSubmissionAuditorDto);

}
