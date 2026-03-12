package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.CurrencyDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.CurrencyVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmCurrency;

import java.util.List;


/**
 * <p>
 * 币种 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmCurrencyService extends BaseService<SrmCurrency> {

    @Transactional
    Long saveOrUpdateCurrency(BaseDataProjDto baseDataProjDto);

    CurrencyVo getDetailCurrency(Long RowId);
    IPage<CurrencyVo> listCurrency(CurrencyDto currencyDto);

    void deleteCurrency(BaseDto baseDto);

    Long getIdByName(String name);
    List<CombVo> getCurrency(CurrencyDto currencyDto);
}
