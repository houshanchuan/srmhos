package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.ResearchUnitTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ResearchUnitTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmResearchUnitType;

/**
 * <p>
 * 科研机构类型 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmResearchUnitTypeMapper extends BaseMapper<SrmResearchUnitType> {
    IPage<ResearchUnitTypeVo> listResearchUnitType(@Param("page") Page<ResearchUnitTypeVo> page, @Param("researchUnitTypeDto") ResearchUnitTypeDto researchUnitTypeDto);
}
