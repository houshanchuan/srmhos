package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.ImburseTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ImburseTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmImburseType;
/**
 * <p>
 * 资助方式代码表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmImburseTypeMapper extends BaseMapper<SrmImburseType> {
    IPage<ImburseTypeVo> listImburseType(@Param("page") Page<ImburseTypeVo> page, @Param("imburseTypeDto") ImburseTypeDto imburseTypeDto);

}
