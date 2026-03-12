package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.DegreeTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmDegreeType;
import com.mediway.hos.srm.business.center.model.vo.baseData.DegreeTypeVo;
/**
 * <p>
 * 学位点类型 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmDegreeTypeMapper extends BaseMapper<SrmDegreeType> {
    IPage<DegreeTypeVo> listDegreeType(@Param("page") Page<DegreeTypeVo> page, @Param("degreeTypeDto") DegreeTypeDto degreeTypeDto);

}
