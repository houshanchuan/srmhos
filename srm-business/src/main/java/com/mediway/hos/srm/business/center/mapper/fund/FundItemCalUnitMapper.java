package com.mediway.hos.srm.business.center.mapper.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.fund.FundItemCalUnitDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundItemCalUnitVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundItemCalUnit;

/**
 * <p>
 * 预算项计量单位 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundItemCalUnitMapper extends BaseMapper<FundItemCalUnit> {


    IPage<FundItemCalUnitVo> listFundItemCalUnit(@Param("page") Page<FundItemCalUnitVo> page, @Param("fundItemCalUnitDto") FundItemCalUnitDto fundItemCalUnitDto);


}
