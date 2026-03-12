package com.mediway.hos.srm.business.center.mapper.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.fund.FundBillStateDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBillStateVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundBillState;
/**
 * <p>
 * 经费单据状态 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundBillStateMapper extends BaseMapper<FundBillState> {

    IPage<FundBillStateVo> listFundBillState(@Param("page") Page<FundBillStateVo> page, @Param("fundBillStateDto") FundBillStateDto fundBillStateDto);


}
