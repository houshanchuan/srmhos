package com.mediway.hos.srm.business.center.mapper.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.EquipArrangeStateDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.EquipArrangeStateVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmEquipArrangeState;


/**
 * <p>
 * 设备排班状态 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-12-09
 */
public interface SrmEquipArrangeStateMapper extends BaseMapper<SrmEquipArrangeState> {

    IPage<EquipArrangeStateVo> listEquipArrangeState(@Param("page") Page<EquipArrangeStateVo> page, @Param("equipArrangeStateDto") EquipArrangeStateDto equipArrangeStateDto);


}
