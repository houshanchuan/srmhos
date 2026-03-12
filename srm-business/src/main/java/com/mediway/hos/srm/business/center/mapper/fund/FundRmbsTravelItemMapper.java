package com.mediway.hos.srm.business.center.mapper.fund;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.fund.FundRmbsTravelItemDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundRmbsTravelItemVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundRmbsTravelItem;

/**
 * <p>
 * 差旅报销项目 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundRmbsTravelItemMapper extends BaseMapper<FundRmbsTravelItem> {

    IPage<FundRmbsTravelItemVo> listFundRmbsTravelItem(@Param("page") Page<FundRmbsTravelItemVo> page, @Param("fundRmbsTravelItemDto") FundRmbsTravelItemDto fundRmbsTravelItemDto);


}
