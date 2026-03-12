package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.fund.FundSourceTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmFundSourceType;
import com.mediway.hos.srm.business.center.model.vo.fund.FundSourceTypeVo;
/**
 * <p>
 * 费用来源类型 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmFundSourceTypeMapper extends BaseMapper<SrmFundSourceType> {
    IPage<FundSourceTypeVo> listFundSourceType(@Param("page") Page<FundSourceTypeVo> page, @Param("fundSourceTypeDto") FundSourceTypeDto fundSourceTypeDto);

}
