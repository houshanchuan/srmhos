package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.dto.baseData.AchvAuthorTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmAchvAuthorType;
import com.mediway.hos.srm.business.center.model.vo.baseData.AchvAuthorTypeVo;

/**
 * <p>
 * 科研成果作者类型 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmAchvAuthorTypeMapper extends BaseMapper<SrmAchvAuthorType> {
    IPage<AchvAuthorTypeVo> listAchvAuthorType(@Param("page") Page<AchvAuthorTypeVo> page, @Param("achvAuthorTypeDto") AchvAuthorTypeDto achvAuthorTypeDto);

}
