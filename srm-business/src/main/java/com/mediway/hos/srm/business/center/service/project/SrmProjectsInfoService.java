package com.mediway.hos.srm.business.center.service.project;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.project.ProjectsInfoDto;
import com.mediway.hos.srm.business.center.model.dto.project.ProjectsInfoVerticalDto;

import com.mediway.hos.srm.business.center.model.entity.project.SrmProjectsInfo;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectsInfoVo;


import java.util.List;

/**
 * <p>
 * 课题信息表(项目) 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-23
 */
public interface SrmProjectsInfoService extends BaseService<SrmProjectsInfo> {
    // 纵向项目
    Long saveVerticalProjectsInfo(ProjectsInfoVerticalDto projectsInfoVerticalDto);
    ProjectsInfoVo getVerticalDetail(Long rowId);
    IPage<ProjectsInfoVo> listVerticalProject(ProjectsInfoDto projectsInfoDto);

    void deleteVerticalProjectsInfo(BaseDto baseDto);
    void subMitVerticalProject(BaseDto baseDto);

    void auditVerticalProject(BaseDto baseDto);
    IPage<ProjectsInfoVo> listAuditVerticalProject(ProjectsInfoDto projectsInfoDto);
    // 横向项目
    Long saveHroProjectsInfo(ProjectsInfoVerticalDto projectsInfoVerticalDto);
    ProjectsInfoVo getHroProjectDetail(Long rowId);
    IPage<ProjectsInfoVo> listHroProject(ProjectsInfoDto projectsInfoDto);

    void deleteHroProject(BaseDto baseDto);
    void subMitHroProject(BaseDto baseDto);

    void auditHroProject(BaseDto baseDto);
    IPage<ProjectsInfoVo> listAuditHroProject(ProjectsInfoDto projectsInfoDto);

    // 合同项目
    Long saveContractProjectsInfo(ProjectsInfoVerticalDto projectsInfoVerticalDto);
    ProjectsInfoVo getContractProjectDetail(Long rowId);
    IPage<ProjectsInfoVo> listContractProject(ProjectsInfoDto projectsInfoDto);

    void deleteContractProject(BaseDto baseDto);
    void subMitContractProject(BaseDto baseDto);

    void auditContractProject(BaseDto baseDto);
    IPage<ProjectsInfoVo> listAuditContractProject(ProjectsInfoDto projectsInfoDto);
    List<CombVo> getProjectsInfo(ProjectsInfoDto projectsInfoDto);

    List<CombVo> getProject();
    List<CombVo> getProjectSolicit(String userCode);
}
