package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.OccupationCategoryDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmOccupationCategory;
import com.mediway.hos.srm.business.center.model.vo.baseData.OccupationCategoryVo;

/**
 * <p>
 * 职业类别 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmOccupationCategoryMapper extends BaseMapper<SrmOccupationCategory> {
    IPage<OccupationCategoryVo> listOccupationCategory(@Param("page") Page<OccupationCategoryVo> page, @Param("occupationCategoryDto") OccupationCategoryDto occupationCategoryDto);
    List<CombVo> getOccupationCategory(@Param("occupationCategoryDto") OccupationCategoryDto occupationCategoryDto);
}
