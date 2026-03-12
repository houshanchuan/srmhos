package com.mediway.hos.srm.business.center.mapper.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;


import com.mediway.hos.srm.business.center.model.dto.baseData.PaperReshipNameDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmReshipName;
import com.mediway.hos.srm.business.center.model.vo.baseData.PaperReshipNameVo;

import java.util.List;

/**
 * <p>
 * 转载名称 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmReshipNameMapper extends BaseMapper<SrmReshipName> {
    IPage<PaperReshipNameVo> listPaperReshipName(@Param("page") Page<PaperReshipNameVo> page, @Param("paperReshipNameDto") PaperReshipNameDto paperReshipNameDto);
    List<CombVo> getPaperReshipName(@Param("paperReshipNameDto") PaperReshipNameDto paperReshipNameDto);
}
