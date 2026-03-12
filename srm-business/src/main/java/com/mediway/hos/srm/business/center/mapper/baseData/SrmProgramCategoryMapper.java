package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProgramCategoryDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProgramCategoryVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProgramCategory;
/**
 * <p>
 * 计划类别 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProgramCategoryMapper extends BaseMapper<SrmProgramCategory> {
    IPage<ProgramCategoryVo> listProgramCategory(@Param("page") Page<ProgramCategoryVo> page, @Param("programCategoryDto") ProgramCategoryDto programCategoryDto);

}
