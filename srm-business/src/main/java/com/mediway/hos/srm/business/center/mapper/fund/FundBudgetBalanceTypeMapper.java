package com.mediway.hos.srm.business.center.mapper.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetBalanceTypeDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetBalanceTypeVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundBudgetBalanceType;


/**
 * <p>
 * 预算结余计算方式  Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundBudgetBalanceTypeMapper extends BaseMapper<FundBudgetBalanceType> {

    IPage<FundBudgetBalanceTypeVo> listFundBudgetBalanceType(@Param("page") Page<FundBudgetBalanceTypeVo> page, @Param("fundBudgetBalanceTypeDto") FundBudgetBalanceTypeDto fundBudgetBalanceTypeDto);

}
