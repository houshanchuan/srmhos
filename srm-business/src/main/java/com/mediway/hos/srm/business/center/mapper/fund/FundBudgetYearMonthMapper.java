package com.mediway.hos.srm.business.center.mapper.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetYearMonthDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetYearMonthVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundBudgetYearMonth;
/**
 * <p>
 * 预算年月定义表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundBudgetYearMonthMapper extends BaseMapper<FundBudgetYearMonth> {

    IPage<FundBudgetYearMonthVo> listFundBudgetYearMonth(@Param("page") Page<FundBudgetYearMonthVo> page, @Param("fundBudgetYearMonthDto") FundBudgetYearMonthDto fundBudgetYearMonthDto);

}
