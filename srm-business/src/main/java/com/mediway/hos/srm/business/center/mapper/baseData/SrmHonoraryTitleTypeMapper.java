package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.dto.baseData.HonoraryTitleTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmHonoraryTitleType;
import com.mediway.hos.srm.business.center.model.vo.baseData.HonoraryTitleTypeVo;

/**
 * <p>
 * 荣誉称号 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmHonoraryTitleTypeMapper extends BaseMapper<SrmHonoraryTitleType> {
    IPage<HonoraryTitleTypeVo> listHonoraryTitleType(@Param("page") Page<HonoraryTitleTypeVo> page, @Param("honoraryTitleTypeDto") HonoraryTitleTypeDto honoraryTitleTypeDto);

}
