package com.mediway.hos.srm.business.center.mapper.project;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import com.mediway.hos.srm.business.center.model.dto.project.ProjectMidcheckDto;
import com.mediway.hos.srm.business.center.model.entity.project.SrmProjectMidcheck;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.vo.project.ProjectMidcheckVo;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectsInfoVo;

import java.util.List;

/**
 * <p>
 * 中检信息表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectMidcheckMapper extends BaseMapper<SrmProjectMidcheck> {
    List<Long> getCheckRowIds(@Param("projId") Long projId);
    ProjectMidcheckVo getDetail(@Param("rowId") String rowId);
    IPage<ProjectMidcheckVo> listProjectMidcheck(@Param("page") Page<ProjectMidcheckVo> page, @Param("projectMidcheckDto") ProjectMidcheckDto projectMidcheckDto);
    void updateStatus(@Param("rowId") Long rowId,@Param("status") String status,@Param("checkStatus") String checkStatus);
    IPage<ProjectsInfoVo> listAuditProjectMidcheck(@Param("page") Page<ProjectsInfoVo> page, @Param("projectMidcheckDto") ProjectMidcheckDto projectMidcheckDto);
}
