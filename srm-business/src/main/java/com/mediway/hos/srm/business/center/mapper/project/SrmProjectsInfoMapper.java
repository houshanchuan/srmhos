package com.mediway.hos.srm.business.center.mapper.project;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import com.mediway.hos.srm.business.center.model.dto.project.ProjectsInfoDto;
import com.mediway.hos.srm.business.center.model.entity.project.SrmProjectsInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectsInfoVo;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 课题信息表(项目) Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-23
 */
public interface SrmProjectsInfoMapper extends BaseMapper<SrmProjectsInfo> {
    ProjectsInfoVo getVerticalDetail(@Param("rowId") Long rowId);
    IPage<ProjectsInfoVo> listVerticalProject(@Param("page") Page<ProjectsInfoVo> page, @Param("projectsInfoDto") ProjectsInfoDto projectsInfoDto);
    void updateStatus(@Param("rowId") Long rowId, @Param("status") Integer status, @Param("resStatus") String resStatus, @Param("subUserId") String subUserId, @Param("subDate")LocalDateTime subDate);
    IPage<ProjectsInfoVo> listAuditVerticalProject(@Param("page") Page<ProjectsInfoVo> page, @Param("projectsInfoDto") ProjectsInfoDto projectsInfoDto);

    ProjectsInfoVo getHroProjectDetail(@Param("rowId") Long rowId);
    IPage<ProjectsInfoVo> listHroProject(@Param("page") Page<ProjectsInfoVo> page, @Param("projectsInfoDto") ProjectsInfoDto projectsInfoDto);
    IPage<ProjectsInfoVo> listAuditHroProject(@Param("page") Page<ProjectsInfoVo> page, @Param("projectsInfoDto") ProjectsInfoDto projectsInfoDto);
    List<CombVo> getProjectsInfo(@Param("projectsInfoDto") ProjectsInfoDto projectsInfoDto);
    List<CombVo> getProject();
    List<CombVo> getProjectSolicit(@Param("userId") String userId);
}
