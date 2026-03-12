package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.LanguageDegreeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmLanguageDegree;
import com.mediway.hos.srm.business.center.model.vo.baseData.LanguageDegreeVo;


/**
 * <p>
 * 语言等级代码表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmLanguageDegreeMapper extends BaseMapper<SrmLanguageDegree> {
    IPage<LanguageDegreeVo> listLanguageDegree(@Param("page") Page<LanguageDegreeVo> page, @Param("languageDegreeDto") LanguageDegreeDto languageDegreeDto);

}
