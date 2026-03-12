package com.mediway.hos.srm.business.center.mapper.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.SocResearchUnitTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.SocResearchUnitTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmSocResearchUnitType;

/**
 * <p>
 * 机构类型（社科统计） Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmSocResearchUnitTypeMapper extends BaseMapper<SrmSocResearchUnitType> {

    IPage<SocResearchUnitTypeVo> listSocResearchUnitType(@Param("page") Page<SocResearchUnitTypeVo> page, @Param("socResearchUnitTypeDto") SocResearchUnitTypeDto socResearchUnitTypeDto);


}
