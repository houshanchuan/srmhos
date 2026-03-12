package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectOrgFormDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectOrgFormVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjectOrgForm;

/**
 * <p>
 * 项目组织形式 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectOrgFormMapper extends BaseMapper<SrmProjectOrgForm> {
    IPage<ProjectOrgFormVo> listProjectOrgForm(@Param("page") Page<ProjectOrgFormVo> page, @Param("projectOrgFormDto") ProjectOrgFormDto projectOrgFormDto);
    List<CombVo> getProjectOrgForm(@Param("projectOrgFormDto") ProjectOrgFormDto projectOrgFormDto);
}
