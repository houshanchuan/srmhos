package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataCommonDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.TemplateDownloadDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.TemplateDownloadVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmTemplateDownload;
/**
 * <p>
 * 模板下载专区 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmTemplateDownloadService extends BaseService<SrmTemplateDownload> {
    @Transactional
    Long saveOrUpdateTemplateDownload(BaseDataCommonDto baseDataCommonDto);

    TemplateDownloadVo getDetailTemplateDownload(Long RowId);
    IPage<TemplateDownloadVo> listTemplateDownload(TemplateDownloadDto templateDownloadDto);

    void deleteTemplateDownload(BaseDto baseDto);

    Long getIdByName(String name);
}
