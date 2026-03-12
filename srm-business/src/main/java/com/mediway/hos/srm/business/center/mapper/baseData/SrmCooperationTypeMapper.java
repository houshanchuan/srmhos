package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.CooperationTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.CooperationTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmCooperationType;

/**
 * <p>
 * 合作类型 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmCooperationTypeMapper extends BaseMapper<SrmCooperationType> {
    IPage<CooperationTypeVo> listCooperationType(@Param("page") Page<CooperationTypeVo> page, @Param("cooperationTypeDto") CooperationTypeDto cooperationTypeDto);
}
