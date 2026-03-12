package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.ResearchTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmResearchType;
import com.mediway.hos.srm.business.center.model.vo.baseData.ResearchTypeVo;


/**
 * <p>
 * 研究类型表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmResearchTypeMapper extends BaseMapper<SrmResearchType> {
    IPage<ResearchTypeVo> listResearchType(@Param("page") Page<ResearchTypeVo> page, @Param("researchTypeDto") ResearchTypeDto researchTypeDto);
}
