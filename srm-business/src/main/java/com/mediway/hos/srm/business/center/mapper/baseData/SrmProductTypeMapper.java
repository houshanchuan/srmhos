package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProductTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProductType;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProductTypeVo;
/**
 * <p>
 * 成果类型 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProductTypeMapper extends BaseMapper<SrmProductType> {
    IPage<ProductTypeVo> listProductType(@Param("page") Page<ProductTypeVo> page, @Param("productTypeDto") ProductTypeDto productTypeDto);

}
