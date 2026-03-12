package com.mediway.hos.srm.business.center.mapper.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.fund.FundProjBudgetStandardDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundProjBudgetStandardVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundProjBudgetStandard;

/**
 * <p>
 * 项目分类预算标准 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundProjBudgetStandardMapper extends BaseMapper<FundProjBudgetStandard> {

    IPage<FundProjBudgetStandardVo> listFundProjBudgetStandard(@Param("page") Page<FundProjBudgetStandardVo> page, @Param("fundProjBudgetStandardDto") FundProjBudgetStandardDto fundProjBudgetStandardDto);


}
