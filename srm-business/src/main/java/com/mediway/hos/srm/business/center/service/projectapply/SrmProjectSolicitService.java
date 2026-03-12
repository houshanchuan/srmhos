package com.mediway.hos.srm.business.center.service.projectapply;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;

import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitDto;
import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitMainDto;
import com.mediway.hos.srm.business.center.model.entity.projectapply.SrmProjectSolicit;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectSolicitVo;
import com.mediway.hos.srm.business.center.utils.SrmPage;

import java.util.List;

/**
 * <p>
 * 项目征集(申报)信息表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectSolicitService extends BaseService<SrmProjectSolicit> {
    ProjectSolicitVo getDetail(String rowId);
    Long saveProjectSolicit(ProjectSolicitMainDto projectSolicitMainDto);

    IPage<ProjectSolicitVo> listProjectSolicit(ProjectSolicitDto projectSolicitDto);
    void deleteProjectSolicit(BaseDto baseDto);
    void subMit(BaseDto baseDto);

    IPage<ProjectSolicitVo> listHeadAuditProjectSolicit(ProjectSolicitDto projectSolicitDto);
    IPage<ProjectSolicitVo> listAuditProjectSolicit(ProjectSolicitDto projectSolicitDto);
    SrmPage<ProjectSolicitVo> listAuditProjectSolicitNew(ProjectSolicitDto projectSolicitDto);
    void headerAudit(BaseDto baseDto);
    void preAudit(BaseDto baseDto);
    void finalAudit(BaseDto baseDto);
    String getProjectSolicitStatus(String rowId);
    List<CombVo> getApplyInfo();
}
