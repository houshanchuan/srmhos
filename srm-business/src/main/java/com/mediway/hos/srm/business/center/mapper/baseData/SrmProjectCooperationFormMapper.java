package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectCooprateFormDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectCooprateFormVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjectCooperationForm;

/**
 * <p>
 * 项目合作形式 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectCooperationFormMapper extends BaseMapper<SrmProjectCooperationForm> {
    IPage<ProjectCooprateFormVo> listProjectCooprateForm(@Param("page") Page<ProjectCooprateFormVo> page, @Param("projectCooprateFormDto") ProjectCooprateFormDto projectCooprateFormDto);
    List<CombVo> getProjectCooprateForm(@Param("projectCooprateFormDto") ProjectCooprateFormDto projectCooprateFormDto);
}
