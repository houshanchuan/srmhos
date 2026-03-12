package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.PayModeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.PayModeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPayMode;
/**
 * <p>
 * 支付方式 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPayModeService extends BaseService<SrmPayMode> {

    @Transactional
    Long saveOrUpdatePayMode(BaseDataProjDto baseDataProjDto);

    PayModeVo getDetailPayMode(Long RowId);
    IPage<PayModeVo> listPayMode(PayModeDto payModeDto);

    void deletePayMode(BaseDto baseDto);

    Long getIdByName(String name);
}
