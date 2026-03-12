package com.mediway.hos.srm.business.center.mapper.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.fund.FundProjectUserAuthDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundProjectUserAuthVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundProjectUserAuth;

/**
 * <p>
 * 预算项目授权 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundProjectUserAuthMapper extends BaseMapper<FundProjectUserAuth> {

    IPage<FundProjectUserAuthVo> listFundProjectUserAuth(@Param("page") Page<FundProjectUserAuthVo> page, @Param("fundProjectUserAuthDto") FundProjectUserAuthDto fundProjectUserAuthDto);

}
