package com.mediway.hos.srm.business.center.mapper.fund;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.fund.FundCheckIdentityDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundCheckIdentityVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundCheckIdentity;

/**
 * <p>
 * 审批流角色身份标识名称表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundCheckIdentityMapper extends BaseMapper<FundCheckIdentity> {

    IPage<FundCheckIdentityVo> listFundCheckIdentity(@Param("page") Page<FundCheckIdentityVo> page, @Param("fundCheckIdentityDto") FundCheckIdentityDto fundCheckIdentityDto);

}
