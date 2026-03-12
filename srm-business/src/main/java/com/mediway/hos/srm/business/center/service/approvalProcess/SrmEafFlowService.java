package com.mediway.hos.srm.business.center.service.approvalProcess;

import com.mediway.hos.srm.business.center.model.dto.approvalProcess.EafFlowDto;
import com.mediway.hos.srm.business.center.model.entity.approvalProcess.SrmEafFlow;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.approvalProcess.EafFlowVo;

import java.util.List;

/**
 * <p>
 * 各业务审批流定义 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-08-21
 */
public interface SrmEafFlowService extends BaseService<SrmEafFlow> {
    List<EafFlowVo> listEafFlow();
    void saveEafFlow(List<EafFlowDto> eafFlowDtos);
    String getEafFlow(String sysNo,String typeId);
}
