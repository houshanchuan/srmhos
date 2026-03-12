package com.mediway.hos.srm.business.center.mapper.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.ScopeTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmScopeType;
import com.mediway.hos.srm.business.center.model.vo.baseData.ScopeTypeVo;


/**
 * <p>
 * 范围类型 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmScopeTypeMapper extends BaseMapper<SrmScopeType> {
    IPage<ScopeTypeVo> listScopeType(@Param("page") Page<ScopeTypeVo> page, @Param("scopeTypeDto") ScopeTypeDto scopeTypeDto);

}
