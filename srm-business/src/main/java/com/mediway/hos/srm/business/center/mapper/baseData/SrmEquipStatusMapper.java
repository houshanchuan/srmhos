package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.EquipStatusDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.EquipStatusVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmEquipStatus;

/**
 * <p>
 * 机构设备状态 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmEquipStatusMapper extends BaseMapper<SrmEquipStatus> {

    IPage<EquipStatusVo> listEquipStatus(@Param("page") Page<EquipStatusVo> page, @Param("equipStatusDto") EquipStatusDto equipStatusDto);


}
