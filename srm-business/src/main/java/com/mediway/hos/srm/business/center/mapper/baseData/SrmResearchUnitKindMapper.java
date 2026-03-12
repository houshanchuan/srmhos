package com.mediway.hos.srm.business.center.mapper.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.ResearchUnitKindDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ResearchUnitKindVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmResearchUnitKind;


/**
 * <p>
 * 科研机构性质 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmResearchUnitKindMapper extends BaseMapper<SrmResearchUnitKind> {

    IPage<ResearchUnitKindVo> listResearchUnitKind(@Param("page") Page<ResearchUnitKindVo> page, @Param("researchUnitKindDto") ResearchUnitKindDto researchUnitKindDto);


}
