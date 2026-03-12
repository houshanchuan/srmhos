package com.mediway.hos.srm.business.center.mapper.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.fund.FundProjectUserGrantDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundProjectUserGrantVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundProjectUserGrant;

/**
 * <p>
 * 项目授权分析 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundProjectUserGrantMapper extends BaseMapper<FundProjectUserGrant> {

    IPage<FundProjectUserGrantVo> listFundProjectUserGrant(@Param("page") Page<FundProjectUserGrantVo> page, @Param("fundProjectUserGrantDto") FundProjectUserGrantDto fundProjectUserGrantDto);

}
