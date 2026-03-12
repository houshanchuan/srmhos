package com.mediway.hos.srm.business.center.mapper.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.EquipBookexeStateDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.EquipBookexeStateVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmEquipBookexeState;

/**
 * <p>
 * 设备预约执行状态 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-12-09
 */
public interface SrmEquipBookexeStateMapper extends BaseMapper<SrmEquipBookexeState> {

    IPage<EquipBookexeStateVo> listEquipBookexeState(@Param("page") Page<EquipBookexeStateVo> page, @Param("equipBookexeStateDto") EquipBookexeStateDto equipBookexeStateDto);


}
