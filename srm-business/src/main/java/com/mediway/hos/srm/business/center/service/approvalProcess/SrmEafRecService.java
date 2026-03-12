package com.mediway.hos.srm.business.center.service.approvalProcess;

import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.approvalProcess.EafRecDto;
import com.mediway.hos.srm.business.center.model.entity.approvalProcess.SrmEafDetail;
import com.mediway.hos.srm.business.center.model.entity.approvalProcess.SrmEafRec;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.approvalProcess.EafRecVo;

/**
 * <p>
 * 审批记录 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-08-21
 */
public interface SrmEafRecService extends BaseService<SrmEafRec> {
    void deleteRec(String sysNo,String rowId);
    public void generateRec(String rowId,String sysNo,String userCode,String deptDr);
    void saveRec(SrmEafRec eafRec);
    EafRecVo getEafRecDetail(EafRecDto eafRecDto);

    void updateRec(EafRecDto eafRecDto);
    void genAudit(Long rowId,String sysNo,Long userId,String resultId,String view,Long ethicFlag);
    void genNoAudit(Long rowId,String sysNo,Long userId,String resultId,String view);

    void genNoAuditBackFirst(Long rowId,String sysNo,String userCode,String view);

    Boolean getCurStatus(BaseDto baseDto);

    SrmEafDetail getCheckStatus(String sysNo, String rowId);

    Integer getMaxStepNo(String sysNo,String rowId);


    String getCurCheckDesc(String sysNo,Long rowId,String type);
    String getFinalResult(BaseDto baseDto);

    SrmEafRec getAuditStepAndDesc(String sysNo,Long rowId);
}
