package com.mediway.hos.srm.business.center.mapper.project;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.dto.project.ProjectFinalcheckDto;
import com.mediway.hos.srm.business.center.model.dto.project.ProjectsInfoDto;
import com.mediway.hos.srm.business.center.model.entity.project.SrmProjectFinalcheck;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectFinalcheckVo;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectSolicitGradeVo;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectsInfoVo;

import java.util.List;

/**
 * <p>
 * 项目验收信息表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-12-09
 */
public interface SrmProjectFinalcheckMapper extends BaseMapper<SrmProjectFinalcheck> {
    List<ProjectsInfoVo> listFinalAuditProject(@Param("projectsInfoDto") ProjectsInfoDto projectsInfoDto);
    ProjectFinalcheckVo getDetail(@Param("rowId") String rowId);
    //listProjectFinalcheck
    IPage<ProjectFinalcheckVo> listProjectFinalcheck(@Param("page") Page<ProjectFinalcheckVo> page, @Param("projectFinalcheckDto") ProjectFinalcheckDto projectFinalcheckDto);
    void updateStatus(@Param("rowId") Long rowId,@Param("status") String status,@Param("checkStatus") String checkStatus);
    IPage<ProjectsInfoVo> listAuditProjectFinalcheck(@Param("page") Page<ProjectsInfoVo> page, @Param("projectFinalcheckDto") ProjectFinalcheckDto projectFinalcheckDto);

    IPage<ProjectSolicitGradeVo> listExpertAuditFinalProject(@Param("page") Page<ProjectSolicitGradeVo> page, @Param("projectsInfoDto") ProjectsInfoDto projectsInfoDto);

}
