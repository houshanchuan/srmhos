package com.mediway.hos.srm.business.center.mapper.fund;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetItemDeptGrantDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetItemDeptGrantVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundBudgetItemDeptGrant;


/**
 * <p>
 * 科目归口科室设置 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundBudgetItemDeptGrantMapper extends BaseMapper<FundBudgetItemDeptGrant> {

    IPage<FundBudgetItemDeptGrantVo> listFundBudgetItemDeptGrant(@Param("page") Page<FundBudgetItemDeptGrantVo> page, @Param("fundBudgetItemDeptGrantDto") FundBudgetItemDeptGrantDto fundBudgetItemDeptGrantDto);

}
