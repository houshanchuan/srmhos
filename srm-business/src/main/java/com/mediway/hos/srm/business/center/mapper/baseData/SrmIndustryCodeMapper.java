package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.IndustryCodeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.IndustryCodeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmIndustryCode;


/**
 * <p>
 * 行业代码 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmIndustryCodeMapper extends BaseMapper<SrmIndustryCode> {
    IPage<IndustryCodeVo> listIndustryCode(@Param("page") Page<IndustryCodeVo> page, @Param("industryCodeDto") IndustryCodeDto industryCodeDto);

}
