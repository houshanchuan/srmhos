package com.mediway.hos.srm.business.center.mapper.fund;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetItemTypeDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetItemTypeVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundBudgetItemType;

/**
 * <p>
 * 预算项（科目）类别 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundBudgetItemTypeMapper extends BaseMapper<FundBudgetItemType> {

    IPage<FundBudgetItemTypeVo> listFundBudgetItemType(@Param("page") Page<FundBudgetItemTypeVo> page, @Param("fundBudgetItemTypeDto") FundBudgetItemTypeDto fundBudgetItemTypeDto);


}
