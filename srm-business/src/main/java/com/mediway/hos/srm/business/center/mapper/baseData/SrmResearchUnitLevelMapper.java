package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.ResearchUnitLevelDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ResearchUnitLevelVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmResearchUnitLevel;

/**
 * <p>
 * 科研机构级别 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmResearchUnitLevelMapper extends BaseMapper<SrmResearchUnitLevel> {


    IPage<ResearchUnitLevelVo> listResearchUnitLevel(@Param("page") Page<ResearchUnitLevelVo> page, @Param("researchUnitLevelDto") ResearchUnitLevelDto researchUnitLevelDto);


}
