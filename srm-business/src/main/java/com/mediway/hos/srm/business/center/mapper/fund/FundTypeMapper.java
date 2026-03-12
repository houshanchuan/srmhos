package com.mediway.hos.srm.business.center.mapper.fund;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.fund.FundTypeDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundTypeVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundType;

/**
 * <p>
 * 项目资金来源类型表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundTypeMapper extends BaseMapper<FundType> {

    IPage<FundTypeVo> listFundType(@Param("page") Page<FundTypeVo> page, @Param("fundTypeDto") FundTypeDto fundTypeDto);


}
