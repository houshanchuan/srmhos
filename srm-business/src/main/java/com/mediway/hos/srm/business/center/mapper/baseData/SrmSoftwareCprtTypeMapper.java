package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.SoftwareCpRtTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmSoftwareCprtType;
import com.mediway.hos.srm.business.center.model.vo.baseData.SoftwareCpRtTypeVo;
/**
 * <p>
 * 软著类型 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmSoftwareCprtTypeMapper extends BaseMapper<SrmSoftwareCprtType> {
    IPage<SoftwareCpRtTypeVo> listSoftwareCprtType(@Param("page") Page<SoftwareCpRtTypeVo> page, @Param("softwareCpRtTypeDto") SoftwareCpRtTypeDto softwareCpRtTypeDto);

}
