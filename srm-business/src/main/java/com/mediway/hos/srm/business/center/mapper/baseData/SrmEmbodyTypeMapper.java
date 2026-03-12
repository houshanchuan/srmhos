package com.mediway.hos.srm.business.center.mapper.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.PaperEmbodyTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmEmbodyType;
import com.mediway.hos.srm.business.center.model.vo.baseData.PaperEmbodyTypeVo;

import java.util.List;

/**
 * <p>
 * 收录类型 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-01
 */
public interface SrmEmbodyTypeMapper extends BaseMapper<SrmEmbodyType> {
    IPage<PaperEmbodyTypeVo> listPaperEmbodyType(@Param("page") Page<PaperEmbodyTypeVo> page, @Param("paperEmbodyTypeDto") PaperEmbodyTypeDto paperEmbodyTypeDto);
    List<CombVo> getEmbodyType(@Param("paperEmbodyTypeDto") PaperEmbodyTypeDto paperEmbodyTypeDto);
}
