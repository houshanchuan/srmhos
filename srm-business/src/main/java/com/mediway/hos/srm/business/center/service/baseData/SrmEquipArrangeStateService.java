package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataPlatformDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.EquipArrangeStateDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.EquipArrangeStateVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmEquipArrangeState;



/**
 * <p>
 * 设备排班状态 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-12-09
 */
public interface SrmEquipArrangeStateService extends BaseService<SrmEquipArrangeState> {

    @Transactional
    Long saveOrUpdateEquipArrangeState(BaseDataPlatformDto baseDataPlatformDto);

    EquipArrangeStateVo getDetailEquipArrangeState(Long RowId);
    IPage<EquipArrangeStateVo> listEquipArrangeState(EquipArrangeStateDto equipArrangeStateDto);

    void deleteEquipArrangeState(BaseDto baseDto);

    Long getIdByName(String name);
}
