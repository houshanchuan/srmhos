package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectApplyUnitTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectApplyUnitTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjectApplyUnitType;

/**
 * <p>
 * 项目申报部门类型 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectApplyUnitTypeMapper extends BaseMapper<SrmProjectApplyUnitType> {
    IPage<ProjectApplyUnitTypeVo> listProjectApplyUnitType(@Param("page") Page<ProjectApplyUnitTypeVo> page, @Param("projectApplyUnitTypeDto") ProjectApplyUnitTypeDto projectApplyUnitTypeDto);

}
