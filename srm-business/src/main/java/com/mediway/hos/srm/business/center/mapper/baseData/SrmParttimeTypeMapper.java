package com.mediway.hos.srm.business.center.mapper.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.ParttimeTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ParttimeTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmParttimeType;

/**
 * <p>
 * 兼职类型 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmParttimeTypeMapper extends BaseMapper<SrmParttimeType> {
    IPage<ParttimeTypeVo> listParttimeType(@Param("page") Page<ParttimeTypeVo> page, @Param("parttimeTypeDto") ParttimeTypeDto parttimeTypeDto);
    List<CombVo> getParttimeType();
}
