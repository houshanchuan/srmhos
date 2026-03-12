package com.mediway.hos.srm.business.center.mapper.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetItemDetailDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetItemDetailVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundBudgetItemDetail;


/**
 * <p>
 * 预算科目明细项 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundBudgetItemDetailMapper extends BaseMapper<FundBudgetItemDetail> {


    IPage<FundBudgetItemDetailVo> listFundBudgetItemDetail(@Param("page") Page<FundBudgetItemDetailVo> page, @Param("fundBudgetItemDetailDto") FundBudgetItemDetailDto fundBudgetItemDetailDto);


}
