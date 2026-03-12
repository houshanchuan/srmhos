package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProductProjectSourceDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProductProjectSourceVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProductProjectsource;

/**
 * <p>
 * 成果的项目来源表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-24
 */
public interface SrmProductProjectsourceMapper extends BaseMapper<SrmProductProjectsource> {
    List<CombVo> getProjectsource();
    IPage<ProductProjectSourceVo> listProductProjectSource(@Param("page") Page<ProductProjectSourceVo> page, @Param("productProjectSourceDto") ProductProjectSourceDto productProjectSourceDto);

}
