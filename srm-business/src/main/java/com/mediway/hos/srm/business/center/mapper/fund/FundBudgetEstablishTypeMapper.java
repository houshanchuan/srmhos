package com.mediway.hos.srm.business.center.mapper.fund;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetEstablishTypeDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetEstablishTypeVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundBudgetEstablishType;

/**
 * <p>
 * 预算编制类型 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundBudgetEstablishTypeMapper extends BaseMapper<FundBudgetEstablishType> {

    IPage<FundBudgetEstablishTypeVo> listFundBudgetEstablishType(@Param("page") Page<FundBudgetEstablishTypeVo> page, @Param("fundBudgetEstablishTypeDto") FundBudgetEstablishTypeDto fundBudgetEstablishTypeDto);

}
