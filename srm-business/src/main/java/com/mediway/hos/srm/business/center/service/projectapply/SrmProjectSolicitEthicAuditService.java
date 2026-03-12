package com.mediway.hos.srm.business.center.service.projectapply;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitDto;
import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitEthicAuditDto;
import com.mediway.hos.srm.business.center.model.entity.projectapply.SrmProjectSolicitEthicAudit;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectSolicitAuditExpertVo;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectSolicitEthicAuditVo;

import java.util.List;

/**
 * <p>
 * 项目征集伦理审批表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectSolicitEthicAuditService extends BaseService<SrmProjectSolicitEthicAudit> {
    void saveProjectSolicitEthicAudit(ProjectSolicitEthicAuditDto projectSolicitEthicAuditDto);
    List<ProjectSolicitAuditExpertVo> listProjectSolicitEthicAudit(ProjectSolicitEthicAuditDto projectSolicitEthicAuditDto);
    void subMit(BaseDto baseDto);
    Long saveDetail(ProjectSolicitEthicAuditDto projectSolicitEthicAuditDto);
    IPage<ProjectSolicitEthicAuditVo> listEthicAuditProjectSolicit(ProjectSolicitDto projectSolicitDto);
    List<ProjectSolicitEthicAuditVo> listEthicAuditProjectSolicitDetail(ProjectSolicitEthicAuditDto projectSolicitEthicAuditDto);
}
