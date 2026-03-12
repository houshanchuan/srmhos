package com.mediway.hos.srm.business.center.mapper.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.fund.FundFeeBelongDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundFeeBelongVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundFeeBelong;

/**
 * <p>
 * 经费归属 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundFeeBelongMapper extends BaseMapper<FundFeeBelong> {

    IPage<FundFeeBelongVo> listFundFeeBelong(@Param("page") Page<FundFeeBelongVo> page, @Param("fundFeeBelongDto") FundFeeBelongDto fundFeeBelongDto);

}
