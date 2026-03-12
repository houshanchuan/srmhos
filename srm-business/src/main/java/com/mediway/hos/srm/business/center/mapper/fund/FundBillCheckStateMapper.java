package com.mediway.hos.srm.business.center.mapper.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.fund.FundBillCheckStateDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBillCheckStateVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundBillCheckState;

/**
 * <p>
 * 单据审核状态 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundBillCheckStateMapper extends BaseMapper<FundBillCheckState> {

    IPage<FundBillCheckStateVo> listFundBillCheckState(@Param("page") Page<FundBillCheckStateVo> page, @Param("fundBillCheckStateDto") FundBillCheckStateDto fundBillCheckStateDto);


}
