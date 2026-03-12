package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.UnitOrderDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.UnitOrderVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmUnitOrder;
/**
 * <p>
 * 单位排序 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmUnitOrderMapper extends BaseMapper<SrmUnitOrder> {
    public List<CombVo> getUnitOrder();
    IPage<UnitOrderVo> listUnitOrder(@Param("page") Page<UnitOrderVo> page, @Param("unitOrderDto") UnitOrderDto unitOrderDto);

}
