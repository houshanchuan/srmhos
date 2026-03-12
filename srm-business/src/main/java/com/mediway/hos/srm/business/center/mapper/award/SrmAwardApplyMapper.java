package com.mediway.hos.srm.business.center.mapper.award;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.dto.award.AwardApplyDto;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperSubmissionExpertAuditDto;
import com.mediway.hos.srm.business.center.model.entity.award.SrmAwardApply;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.award.AwardApplyVo;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperSubmissionExpertAuditVo;

import java.time.LocalDateTime;

/**
 * <p>
 * 获奖申报 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmAwardApplyMapper extends BaseMapper<SrmAwardApply> {
    AwardApplyVo getDetail(@Param("rowId") String rowId);
    IPage<AwardApplyVo> listAwardApply(@Param("page") Page<AwardApplyVo> page, @Param("awardApplyDto") AwardApplyDto awardApplyDto);
    void updateStatus(@Param("rowId") Long rowId, @Param("status") Integer status, @Param("checkStatus") String checkStatus, @Param("serialNo") String serialNo, @Param("subDate") LocalDateTime subDate, @Param("subUserId") String subUserId);
    IPage<AwardApplyVo> listAuditAwardApply(@Param("page") Page<AwardApplyVo> page,@Param("awardApplyDto") AwardApplyDto awardApplyDto);
    IPage<PaperSubmissionExpertAuditVo> listExpertAuditAwardApply(@Param("page") Page<PaperSubmissionExpertAuditVo> page, @Param("paperSubmissionExpertAuditDto") PaperSubmissionExpertAuditDto paperSubmissionExpertAuditDto);

}
