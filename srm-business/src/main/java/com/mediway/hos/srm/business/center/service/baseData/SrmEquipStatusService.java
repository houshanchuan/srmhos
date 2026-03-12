package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataPlatformDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.EquipStatusDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.EquipStatusVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmEquipStatus;
/**
 * <p>
 * 机构设备状态 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmEquipStatusService extends BaseService<SrmEquipStatus> {

    @Transactional
    Long saveOrUpdateEquipStatus(BaseDataPlatformDto baseDataPlatformDto);

    EquipStatusVo getDetailEquipStatus(Long RowId);
    IPage<EquipStatusVo> listEquipStatus(EquipStatusDto equipStatusDto);

    void deleteEquipStatus(BaseDto baseDto);

    Long getIdByName(String name);
}
