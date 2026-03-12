package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataPlatformDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.EquipChargeModeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.EquipChargeModeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmEquipChargeMode;



/**
 * <p>
 * 设备收费模式 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmEquipChargeModeService extends BaseService<SrmEquipChargeMode> {

    @Transactional
    Long saveOrUpdateEquipChargeMode(BaseDataPlatformDto baseDataPlatformDto);

    EquipChargeModeVo getDetailEquipChargeMode(Long RowId);
    IPage<EquipChargeModeVo> listEquipChargeMode(EquipChargeModeDto equipChargeModeDto);

    void deleteEquipChargeMode(BaseDto baseDto);

    Long getIdByName(String name);
}
