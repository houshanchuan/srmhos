package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.PatentScopeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPatentScope;
import com.mediway.hos.srm.business.center.model.vo.baseData.PatentScopeVo;

/**
 * <p>
 * 专利范围 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPatentScopeMapper extends BaseMapper<SrmPatentScope> {
    IPage<PatentScopeVo> listPatentScope(@Param("page") Page<PatentScopeVo> page, @Param("patentScopeDto") PatentScopeDto patentScopeDto);

}
