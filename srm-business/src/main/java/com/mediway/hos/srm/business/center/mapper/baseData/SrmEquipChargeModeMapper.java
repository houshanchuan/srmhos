package com.mediway.hos.srm.business.center.mapper.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.EquipChargeModeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.EquipChargeModeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmEquipChargeMode;

/**
 * <p>
 * 设备收费模式 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmEquipChargeModeMapper extends BaseMapper<SrmEquipChargeMode> {

    IPage<EquipChargeModeVo> listEquipChargeMode(@Param("page") Page<EquipChargeModeVo> page, @Param("equipChargeModeDto") EquipChargeModeDto equipChargeModeDto);


}
