package com.mediway.hos.srm.business.center.mapper.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjLevelDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjLevelVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjLevel;

/**
 * <p>
 * 项目级别代码 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjLevelMapper extends BaseMapper<SrmProjLevel> {
    IPage<ProjLevelVo> listProjLevel(@Param("page") Page<ProjLevelVo> page, @Param("projLevelDto") ProjLevelDto projLevelDto);

    List<CombVo> getProjLevel();
}
