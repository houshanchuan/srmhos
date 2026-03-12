package com.mediway.hos.srm.business.center.service.project;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.project.ProjectFinalcheckDto;
import com.mediway.hos.srm.business.center.model.dto.project.ProjectsInfoDto;


import com.mediway.hos.srm.business.center.model.entity.project.SrmProjectFinalcheck;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectFinalcheckVo;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectSolicitGradeVo;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectsInfoVo;
import com.mediway.hos.srm.business.center.utils.SrmPage;

/**
 * <p>
 * 项目验收信息表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-12-09
 */
public interface SrmProjectFinalcheckService extends BaseService<SrmProjectFinalcheck> {
    SrmPage<ProjectsInfoVo> listVerticalAuditFinalProject(ProjectsInfoDto projectsInfoDto);
    SrmPage<ProjectsInfoVo> listFinalProject(ProjectsInfoDto projectsInfoDto);
    ProjectFinalcheckVo getDetail(String rowId);
    Long saveProjectFinalcheck(ProjectFinalcheckDto projectFinalcheckDto);

    IPage<ProjectFinalcheckVo> listProjectFinalCheck(ProjectFinalcheckDto projectFinalcheckDto);

    void deleteProjectFinalCheck(BaseDto baseDto);
    void subMit(BaseDto baseDto);

    void audit(BaseDto baseDto);
    IPage<ProjectsInfoVo> listAuditProjectFinalCheck(ProjectFinalcheckDto projectFinalcheckDto);

    IPage<ProjectSolicitGradeVo> listExpertAuditFinalProject(ProjectsInfoDto projectsInfoDto);
}
