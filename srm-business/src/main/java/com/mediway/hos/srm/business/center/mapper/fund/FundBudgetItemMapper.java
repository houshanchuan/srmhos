package com.mediway.hos.srm.business.center.mapper.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetItemDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetItemVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundBudgetItem;

/**
 * <p>
 * 预算项目(科目)表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundBudgetItemMapper extends BaseMapper<FundBudgetItem> {

    IPage<FundBudgetItemVo> listFundBudgetItem(@Param("page") Page<FundBudgetItemVo> page, @Param("fundBudgetItemDto") FundBudgetItemDto fundBudgetItemDto);

    List<CombVo> getItemCode();

}
