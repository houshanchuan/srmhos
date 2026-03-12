package com.mediway.hos.srm.business.center.service.projectapply;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitDto;
import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitGradeDto;
import com.mediway.hos.srm.business.center.model.entity.projectapply.SrmProjectSolicitGrade;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectSolicitAuditExpertVo;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectSolicitGradeVo;

import java.util.List;

/**
 * <p>
 * 项目征集专业评分表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectSolicitGradeService extends BaseService<SrmProjectSolicitGrade> {
    void saveProjectSolictitGrade(ProjectSolicitGradeDto projectSolicitGradeDto);

    Long saveDetail(ProjectSolicitGradeDto projectSolicitGradeDto);
    List<ProjectSolicitAuditExpertVo> listProjectSolicitGrade(ProjectSolicitGradeDto projectSolicitGradeDto);

    IPage<ProjectSolicitGradeVo> listAuditProjectSolicit(ProjectSolicitDto projectSolicitDto);

    void subMit(ProjectSolicitGradeDto projectSolicitGradeDto);

    ProjectSolicitGradeVo getDetail(String rowId);
}
