package com.mediway.hos.srm.business.center.mapper.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.fund.FundExpTypeDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundExpTypeVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundExpType;

/**
 * <p>
 * 支出业务类型 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundExpTypeMapper extends BaseMapper<FundExpType> {

    IPage<FundExpTypeVo> listFundExpType(@Param("page") Page<FundExpTypeVo> page, @Param("fundExpTypeDto") FundExpTypeDto fundExpTypeDto);


}
