package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;


import com.mediway.hos.srm.business.center.model.dto.baseData.UnitOrderDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.UnitOrderVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmUnitOrder;

/**
 * <p>
 * 单位排序 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmUnitOrderService extends BaseService<SrmUnitOrder> {
    List<CombVo> getUnitOrder();

    @Transactional
    Long saveOrUpdateUnitOrder(BaseDataProjDto baseDataProjDto);

    UnitOrderVo getDetailUnitOrder(Long RowId);
    IPage<UnitOrderVo> listUnitOrder(UnitOrderDto unitOrderDto);

    void deleteUnitOrder(BaseDto baseDto);

    Long getIdByName(String name);
}
