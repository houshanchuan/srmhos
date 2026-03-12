package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.ComponentTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ComponentTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmComponentType;

/**
 * <p>
 * 机构组成类型 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmComponentTypeMapper extends BaseMapper<SrmComponentType> {

    IPage<ComponentTypeVo> listComponentType(@Param("page") Page<ComponentTypeVo> page, @Param("componentTypeDto") ComponentTypeDto componentTypeDto);


}
