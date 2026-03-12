package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.CurrencyDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.CurrencyVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmCurrency;

import java.util.List;

/**
 * <p>
 * 币种 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmCurrencyMapper extends BaseMapper<SrmCurrency> {
    IPage<CurrencyVo> listCurrency(@Param("page") Page<CurrencyVo> page, @Param("currencyDto") CurrencyDto currencyDto);
    List<CombVo> getCurrency(@Param("currencyDto") CurrencyDto currencyDto);
}
