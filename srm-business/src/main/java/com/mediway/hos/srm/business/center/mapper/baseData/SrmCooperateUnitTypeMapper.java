package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.CooperateUnitTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.CooperateUnitTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmCooperateUnitType;


/**
 * <p>
 * 合作单位类型 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmCooperateUnitTypeMapper extends BaseMapper<SrmCooperateUnitType> {

    IPage<CooperateUnitTypeVo> listCooperateUnitType(@Param("page") Page<CooperateUnitTypeVo> page, @Param("cooperateUnitTypeDto") CooperateUnitTypeDto cooperateUnitTypeDto);


}
