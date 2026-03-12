package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.ExpertGroupRelationDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ExpertGroupRelationVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmExpertGroupRelation;


/**
 * <p>
 * 组织关系定义 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmExpertGroupRelationMapper extends BaseMapper<SrmExpertGroupRelation> {

    IPage<ExpertGroupRelationVo> listSrmExpertGroupRelation(@Param("page") Page<ExpertGroupRelationVo> page, @Param("expertGroupRelationDto") ExpertGroupRelationDto expertGroupRelationDto);


}
