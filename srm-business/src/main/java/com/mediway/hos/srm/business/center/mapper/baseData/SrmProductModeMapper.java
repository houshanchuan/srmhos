package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProductModeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProductMode;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProductModeVo;

/**
 * <p>
 * 成果(产品)模式 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProductModeMapper extends BaseMapper<SrmProductMode> {	  
   List<CombVo> getProductMode();
    IPage<ProductModeVo> listProductMode(@Param("page") Page<ProductModeVo> page, @Param("productModeDto") ProductModeDto productModeDto);

}
