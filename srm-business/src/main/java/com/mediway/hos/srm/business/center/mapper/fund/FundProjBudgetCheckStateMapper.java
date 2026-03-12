package com.mediway.hos.srm.business.center.mapper.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.fund.FundProjBudgetCheckStateDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundProjBudgetCheckStateVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundProjBudgetCheckState;

/**
 * <p>
 * 项目预算审核状态 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundProjBudgetCheckStateMapper extends BaseMapper<FundProjBudgetCheckState> {
    IPage<FundProjBudgetCheckStateVo> listFundProjBudgetCheckState(@Param("page") Page<FundProjBudgetCheckStateVo> page, @Param("fundProjBudgetCheckStateDto") FundProjBudgetCheckStateDto fundProjBudgetCheckStateDto);
}
