package com.mediway.hos.srm.business.center.mapper.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetFeeTypeDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetFeeTypeVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundBudgetFeeType;
/**
 * <p>
 * 预算资金类型 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundBudgetFeeTypeMapper extends BaseMapper<FundBudgetFeeType> {

    IPage<FundBudgetFeeTypeVo> listFundBudgetFeeType(@Param("page") Page<FundBudgetFeeTypeVo> page, @Param("fundBudgetFeeTypeDto") FundBudgetFeeTypeDto fundBudgetFeeTypeDto);

}
