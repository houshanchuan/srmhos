package com.mediway.hos.srm.business.center.mapper.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.ContentRealDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmContentReal;
import com.mediway.hos.srm.business.center.model.vo.baseData.ContentRealVo;


/**
 * <p>
 * 内容真实性代码 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmContentRealMapper extends BaseMapper<SrmContentReal> {
    IPage<ContentRealVo> listContentReal(@Param("page") Page<ContentRealVo> page, @Param("contentRealDto") ContentRealDto contentRealDto);
}
