package com.mediway.hos.srm.business.center.mapper.paper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperSubmissionExpertAuditVo;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperVo;
import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperDto;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperSubmissionExpertAuditDto;
import com.mediway.hos.srm.business.center.model.entity.paper.SrmPaper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.entity.user.SrmUser;


import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 论文登记信息表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-08-23
 */
public interface SrmPaperMapper extends BaseMapper<SrmPaper> {
    PaperVo getDetail(@Param("rowId") String rowId);
    IPage<PaperVo> listPaper(@Param("page") Page<PaperVo> page, @Param("paperDto") PaperDto paperDto);
    void updateStatus(@Param("rowId") Long rowId, @Param("status") Integer status, @Param("checkStatus") String checkStatus, @Param("serialNo") String serialNo, @Param("subDate")LocalDateTime subDate,@Param("subUserId") String subUserId);
     IPage<PaperVo> listAuditPaper(@Param("page") Page<PaperVo> page, @Param("paperDto") PaperDto paperDto);
    SrmUser getFirstAuthor(@Param("parentId") String parentId, @Param("isCorrFlag") String isCorrFlag);
    List<CombVo> getPaperApply(@Param("userId") String userId);
    IPage<PaperSubmissionExpertAuditVo> listExpertAuditPaper(@Param("page") Page<PaperSubmissionExpertAuditVo> page, @Param("paperSubmissionExpertAuditDto") PaperSubmissionExpertAuditDto paperSubmissionExpertAuditDto);

}
