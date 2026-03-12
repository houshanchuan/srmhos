package com.mediway.hos.srm.business.center.service.approvalProcess;

import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.approvalProcess.EafRecDto;
import com.mediway.hos.srm.business.center.model.entity.approvalProcess.SrmEafRecLog;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.approvalProcess.EafRecLogVo;
import com.mediway.hos.srm.business.center.model.vo.approvalProcess.EafRecVstepNo;

import java.util.List;

/**
 * <p>
 * 审批记录日志 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-08-23
 */
public interface SrmEafRecLogService extends BaseService<SrmEafRecLog> {
    void saveRecLog(String id);
    List<EafRecLogVo> listCheckLog(BaseDto baseDto);
    int getCurStep(EafRecDto eafRecDto);
    List <EafRecVstepNo> listVStep(EafRecDto eafRecDto);
    List <EafRecVstepNo> listAppVStep(EafRecDto eafRecDto);
}
