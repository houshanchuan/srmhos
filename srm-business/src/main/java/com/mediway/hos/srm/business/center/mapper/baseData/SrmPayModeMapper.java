package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.PayModeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.PayModeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPayMode;



/**
 * <p>
 * 支付方式 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPayModeMapper extends BaseMapper<SrmPayMode> {
    IPage<PayModeVo> listPayMode(@Param("page") Page<PayModeVo> page, @Param("payModeDto") PayModeDto payModeDto);

}
