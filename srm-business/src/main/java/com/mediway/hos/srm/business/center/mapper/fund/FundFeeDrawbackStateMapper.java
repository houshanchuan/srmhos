package com.mediway.hos.srm.business.center.mapper.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.fund.FundFeeDrawbackStateDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundFeeDrawbackStateVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundFeeDrawbackState;

/**
 * <p>
 * 费用退税状态 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundFeeDrawbackStateMapper extends BaseMapper<FundFeeDrawbackState> {

    IPage<FundFeeDrawbackStateVo> listFundFeeDrawbackState(@Param("page") Page<FundFeeDrawbackStateVo> page, @Param("fundFeeDrawbackStateDto") FundFeeDrawbackStateDto fundFeeDrawbackStateDto);

}
