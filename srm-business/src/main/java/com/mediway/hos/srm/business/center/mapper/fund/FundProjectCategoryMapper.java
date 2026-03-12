package com.mediway.hos.srm.business.center.mapper.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.fund.FundProjectCategoryDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundProjectCategoryVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundProjectCategory;
/**
 * <p>
 * 项目属性 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundProjectCategoryMapper extends BaseMapper<FundProjectCategory> {

    IPage<FundProjectCategoryVo> listFundProjectCategory(@Param("page") Page<FundProjectCategoryVo> page, @Param("fundProjectCategoryDto") FundProjectCategoryDto fundProjectCategoryDto);


}
