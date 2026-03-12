package com.mediway.hos.srm.business.center.mapper.projectapply;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitDto;
import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitGradeDto;
import com.mediway.hos.srm.business.center.model.entity.projectapply.SrmProjectSolicitGrade;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectSolicitAuditExpertVo;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectSolicitGradeVo;

import java.util.List;

/**
 * <p>
 * 项目征集专业评分表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectSolicitGradeMapper extends BaseMapper<SrmProjectSolicitGrade> {
    List<ProjectSolicitAuditExpertVo> listProjectSolicitGrade(@Param("projectSolicitGradeDto") ProjectSolicitGradeDto projectSolicitGradeDto);

    IPage<ProjectSolicitGradeVo> listAuditProjectSolicit(@Param("page") Page<ProjectSolicitGradeVo> page, @Param("projectSolicitDto") ProjectSolicitDto projectSolicitDto);
    ProjectSolicitGradeVo getDetail(@Param("rowId") String rowId);
    void updateGradeState(@Param("projectSolicitGradeDto") ProjectSolicitGradeDto projectSolicitGradeDto);
    void updateCancel(@Param("sysNo") String sysNo, @Param("ywRowId") String ywRowId);
}
