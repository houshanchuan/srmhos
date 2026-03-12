package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.PayTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.PayTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPayType;

/**
 * <p>
 * 付款类型 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPayTypeMapper extends BaseMapper<SrmPayType> {
    IPage<PayTypeVo> listPayType(@Param("page") Page<PayTypeVo> page, @Param("payTypeDto") PayTypeDto payTypeDto);
    List<CombVo> getPayType();
}
