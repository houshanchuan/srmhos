package com.mediway.hos.srm.business.center.mapper.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.fund.FundProjBudgetModeDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundProjBudgetModeVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundProjBudgetMode;


/**
 * <p>
 * 项目预算编制模式 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundProjBudgetModeMapper extends BaseMapper<FundProjBudgetMode> {

    IPage<FundProjBudgetModeVo> listFundProjBudgetMode(@Param("page") Page<FundProjBudgetModeVo> page, @Param("fundProjBudgetModeDto") FundProjBudgetModeDto fundProjBudgetModeDto);

}
