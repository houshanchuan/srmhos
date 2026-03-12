package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.TemplateDownloadDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.TemplateDownloadVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmTemplateDownload;

/**
 * <p>
 * 模板下载专区 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmTemplateDownloadMapper extends BaseMapper<SrmTemplateDownload> {

    IPage<TemplateDownloadVo> listTemplateDownload(@Param("page") Page<TemplateDownloadVo> page, @Param("templateDownloadDto") TemplateDownloadDto templateDownloadDto);

    TemplateDownloadVo getDetailTemplateDownload(@Param("RowId") Long RowId);

}
