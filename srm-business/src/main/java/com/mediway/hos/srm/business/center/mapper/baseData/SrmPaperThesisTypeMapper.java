package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.PaperThesisTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPaperThesisType;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.vo.baseData.PaperThesisTypeVo;

import java.util.List;

/**
 * <p>
 * 论文形式类别表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPaperThesisTypeMapper extends BaseMapper<SrmPaperThesisType> {
    IPage<PaperThesisTypeVo> listPaperThesisType(@Param("page") Page<PaperThesisTypeVo> page, @Param("paperThesisTypeDto") PaperThesisTypeDto paperThesisTypeDto);
    List<CombVo> getPaperThesisType();
}
