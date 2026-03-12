package com.mediway.hos.srm.business.center.service.patent;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperSubmissionExpertAuditDto;
import com.mediway.hos.srm.business.center.model.dto.patent.PatentApplyDto;
import com.mediway.hos.srm.business.center.model.dto.patent.PatentApplyMainDto;

import com.mediway.hos.srm.business.center.model.entity.patent.SrmPatentApply;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperSubmissionExpertAuditVo;
import com.mediway.hos.srm.business.center.model.vo.patent.PatentApplyVo;
import com.mediway.hos.srm.business.center.model.vo.baseData.UnitPeronVo;

import java.util.List;

/**
 * <p>
 * 专利申报 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPatentApplyService extends BaseService<SrmPatentApply> {
    PatentApplyVo getDetail(String rowId);
    Long savePatentApply(PatentApplyMainDto patentApplyMainDto);

    IPage<PatentApplyVo> listPatentApply(PatentApplyDto patentApplyDto);

    void deletePatentApply(BaseDto baseDto);
    void subMit(BaseDto baseDto);

    void audit(BaseDto baseDto);
    IPage<PatentApplyVo> listAuditPatentApply(PatentApplyDto patentApplyDto);
    void deletePatentee(String rowIdStr);
    List<UnitPeronVo> listPatentee(Long rowId);
    IPage<PaperSubmissionExpertAuditVo> listExpertAuditPatentApply(PaperSubmissionExpertAuditDto paperSubmissionExpertAuditDto);
}
