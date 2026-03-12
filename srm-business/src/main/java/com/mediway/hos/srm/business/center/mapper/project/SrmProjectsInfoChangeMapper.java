package com.mediway.hos.srm.business.center.mapper.project;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.dto.project.ProjectsInfoChangeDto;
import com.mediway.hos.srm.business.center.model.entity.project.SrmProjectsInfoChange;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectsInfoChangeVo;

/**
 * <p>
 * 项目变更 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectsInfoChangeMapper extends BaseMapper<SrmProjectsInfoChange> {
    ProjectsInfoChangeVo getDetail(@Param("rowId") Long rowId);
    IPage<ProjectsInfoChangeVo> listProjectsInfoChange(@Param("page") Page<ProjectsInfoChangeVo> page, @Param("projectsInfoChangeDto") ProjectsInfoChangeDto projectsInfoChangeDto);
    void updateStatus(@Param("rowId") Long rowId,@Param("dataStatus") Integer status,@Param("auditStatus") String auditStatus);
    IPage<ProjectsInfoChangeVo> listAuditProjectsInfoChange(@Param("page") Page<ProjectsInfoChangeVo> page, @Param("projectsInfoChangeDto") ProjectsInfoChangeDto projectsInfoChangeDto);


}
