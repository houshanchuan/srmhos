package com.mediway.hos.srm.business.center.mapper.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetDeptGrantDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetDeptGrantVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundBudgetDeptGrant;


/**
 * <p>
 * 预算科室访问权限 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundBudgetDeptGrantMapper extends BaseMapper<FundBudgetDeptGrant> {

    IPage<FundBudgetDeptGrantVo> listFundBudgetDeptGrant(@Param("page") Page<FundBudgetDeptGrantVo> page, @Param("fundBudgetDeptGrantDto") FundBudgetDeptGrantDto fundBudgetDeptGrantDto);

}
