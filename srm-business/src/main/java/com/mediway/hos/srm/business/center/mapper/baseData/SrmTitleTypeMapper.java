package com.mediway.hos.srm.business.center.mapper.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.TitleTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmTitleType;
import com.mediway.hos.srm.business.center.model.vo.baseData.TitleTypeVo;

/**
 * <p>
 * 职称类型 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmTitleTypeMapper extends BaseMapper<SrmTitleType> {
    IPage<TitleTypeVo> listTitleType(@Param("page") Page<TitleTypeVo> page, @Param("titleTypeDto") TitleTypeDto titleTypeDto);

}
