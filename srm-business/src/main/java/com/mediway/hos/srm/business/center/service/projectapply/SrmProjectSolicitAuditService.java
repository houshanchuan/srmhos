package com.mediway.hos.srm.business.center.service.projectapply;

import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitAuditDto;
import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitEthicAuditDto;
import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitGradeDto;
import com.mediway.hos.srm.business.center.model.entity.projectapply.SrmProjectSolicitAudit;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectSolicitAuditExpertVo;

import java.util.List;

/**
 * <p>
 * 项目征集权限表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectSolicitAuditService extends BaseService<SrmProjectSolicitAudit> {
    List<ProjectSolicitAuditExpertVo> getNoAllotExpert(ProjectSolicitAuditDto projectSolicitAuditDto);
    List<ProjectSolicitAuditExpertVo> getNoEthicAllotExpert(ProjectSolicitAuditDto projectSolicitAuditDto);

    List<ProjectSolicitAuditExpertVo> getAllotExpert(ProjectSolicitAuditDto projectSolicitAuditDto);
    List<ProjectSolicitAuditExpertVo> getEthicAllotExpert(ProjectSolicitAuditDto projectSolicitAuditDto);

    void allotExpert(ProjectSolicitAuditDto projectSolicitAuditDto);
    void allotEthicExpert(ProjectSolicitAuditDto projectSolicitAuditDto);

    void deleteExpert(ProjectSolicitGradeDto projectSolicitGradeDto);
    void deleteEthicExpert(ProjectSolicitEthicAuditDto projectSolicitEthicAuditDto);

}
