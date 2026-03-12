package com.mediway.hos.srm.business.center.service.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataPlatformDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.EquipBookexeStateDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.EquipBookexeStateVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmEquipBookexeState;




/**
 * <p>
 * 设备预约执行状态 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-12-09
 */
public interface SrmEquipBookexeStateService extends BaseService<SrmEquipBookexeState> {

    @Transactional
    Long saveOrUpdateEquipBookexeState(BaseDataPlatformDto baseDataPlatformDto);

    EquipBookexeStateVo getDetailEquipBookexeState(Long RowId);
    IPage<EquipBookexeStateVo> listEquipBookexeState(EquipBookexeStateDto equipBookexeStateDto);

    void deleteEquipBookexeState(BaseDto baseDto);

    Long getIdByName(String name);
}
