package com.mediway.hos.srm.business.center.service.paper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperDto;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperMainDto;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperSubmissionExpertAuditDto;

import com.mediway.hos.srm.business.center.model.entity.paper.SrmPaper;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperSubmissionExpertAuditVo;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperVo;

import java.util.List;

/**
 * <p>
 * 论文登记信息表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-08-23
 */
public interface SrmPaperService extends BaseService<SrmPaper> {
    PaperVo getDetail(String rowId);
    Long savePaper(PaperMainDto paperMainDto);

    IPage<PaperVo> listPaper(PaperDto paperDto);

    void deletePaper(BaseDto baseDto);
    void subMit(BaseDto baseDto);

    void audit(BaseDto baseDto);
    IPage<PaperVo> listAuditPaper(PaperDto paperDto);
    List<CombVo> getPaperApply(String userCode);
    IPage<PaperSubmissionExpertAuditVo> listExpertAuditPaper(PaperSubmissionExpertAuditDto paperSubmissionExpertAuditDto);
}
