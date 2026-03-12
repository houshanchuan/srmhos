package com.mediway.hos.srm.business.center.mapper.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.TitleLevelDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmTitleLevel;
import com.mediway.hos.srm.business.center.model.vo.baseData.TitleLevelVo;

/**
 * <p>
 * 职称级别 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmTitleLevelMapper extends BaseMapper<SrmTitleLevel> {
    IPage<TitleLevelVo> listTitleLevel(@Param("page") Page<TitleLevelVo> page, @Param("titleLevelDto") TitleLevelDto titleLevelDto);

}
