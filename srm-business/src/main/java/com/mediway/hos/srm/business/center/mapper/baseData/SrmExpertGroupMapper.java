package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.ExpertGroupDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ExpertGroupVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmExpertGroup;

/**
 * <p>
 * 专家组 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmExpertGroupMapper extends BaseMapper<SrmExpertGroup> {

    IPage<ExpertGroupVo> listSrmExpertGroup(@Param("page") Page<ExpertGroupVo> page, @Param("expertGroupDto") ExpertGroupDto expertGroupDto);

    List<CombVo> getExpertGroup();
}
