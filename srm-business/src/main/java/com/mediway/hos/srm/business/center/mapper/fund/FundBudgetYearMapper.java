package com.mediway.hos.srm.business.center.mapper.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetYearDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetYearVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundBudgetYear;

/**
 * <p>
 * 预算年度表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundBudgetYearMapper extends BaseMapper<FundBudgetYear> {

    IPage<FundBudgetYearVo> listFundBudgetYear(@Param("page") Page<FundBudgetYearVo> page, @Param("fundBudgetYearDto") FundBudgetYearDto fundBudgetYearDto);


}
