package com.mediway.hos.srm.business.center.mapper.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.SciUnitFormDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.SciUnitFormVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmSciUnitForm;


/**
 * <p>
 * 组织形式(科技统计用) Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmSciUnitFormMapper extends BaseMapper<SrmSciUnitForm> {

    IPage<SciUnitFormVo> listSciUnitForm(@Param("page") Page<SciUnitFormVo> page, @Param("sciUnitFormDto") SciUnitFormDto sciUnitFormDto);
}
