package com.mediway.hos.srm.business.center.service.project;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.project.ProjectsInfoChangeDto;
import com.mediway.hos.srm.business.center.model.dto.project.ProjectsInfoChangeMainDto;
import com.mediway.hos.srm.business.center.model.entity.project.SrmProjectsInfoChange;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectsInfoChangeVo;

/**
 * <p>
 * 项目变更 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectsInfoChangeService extends BaseService<SrmProjectsInfoChange> {
    ProjectsInfoChangeVo getDetail( Long rowId);
    IPage<ProjectsInfoChangeVo> listProjectsInfoChange(ProjectsInfoChangeDto projectsInfoChangeDto);
    Long saveProjectsInfoChange(ProjectsInfoChangeMainDto projectsInfoChangeMainDto);
    void deleteProjectsInfoChange(BaseDto baseDto);
    void subMitProjectsInfoChange(BaseDto baseDto);
    IPage<ProjectsInfoChangeVo> listAuditProjectsInfoChange(ProjectsInfoChangeDto projectsInfoChangeDto);
    void auditProjectsInfoChange(BaseDto baseDto);
}
