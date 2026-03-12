package com.mediway.hos.srm.business.center.mapper.project;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import com.mediway.hos.srm.business.center.model.dto.project.ProjectMidcheckListInfoDto;
import com.mediway.hos.srm.business.center.model.entity.project.SrmProjectMidcheckListInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectMidcheckListInfoVo;

import java.util.List;

/**
 * <p>
 * 中检批次信息表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectMidcheckListInfoMapper extends BaseMapper<SrmProjectMidcheckListInfo> {
    ProjectMidcheckListInfoVo getDetail(@Param("rowId") String rowId);
    IPage<ProjectMidcheckListInfoVo> listProjectMidCheckListInfo(@Param("page") Page<ProjectMidcheckListInfoVo> page, @Param("projectMidcheckListInfoDto") ProjectMidcheckListInfoDto projectMidcheckListInfoDto);

    List<CombVo> getprojectMidcheckListInfo(@Param("name") String name);
}
