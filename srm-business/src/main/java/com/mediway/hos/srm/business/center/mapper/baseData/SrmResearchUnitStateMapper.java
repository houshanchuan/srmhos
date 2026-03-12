package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.ResearchUnitStateDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ResearchUnitStateVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmResearchUnitState;


/**
 * <p>
 * 机构状态 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmResearchUnitStateMapper extends BaseMapper<SrmResearchUnitState> {

    IPage<ResearchUnitStateVo> listResearchUnitState(@Param("page") Page<ResearchUnitStateVo> page, @Param("researchUnitStateDto") ResearchUnitStateDto researchUnitStateDto);

}
