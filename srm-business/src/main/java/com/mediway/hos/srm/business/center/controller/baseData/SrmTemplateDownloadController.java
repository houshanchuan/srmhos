package com.mediway.hos.srm.business.center.controller.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataCommonDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.model.dto.baseData.TemplateDownloadDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.TemplateDownloadVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmTemplateDownloadService;

/**
 * <p>
 * 模板下载专区
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/templateDownload")
@Api(tags = "模板下载专区")
public class SrmTemplateDownloadController {

    @Autowired
    private SrmTemplateDownloadService srmTemplateDownloadService;

    @PostMapping({"/saveOrUpdateTemplateDownload"})
    public BaseResponse saveOrUpdateTemplateDownload(@RequestBody BaseDataCommonDto baseDataCommonDto) {
        Long RowId = srmTemplateDownloadService.saveOrUpdateTemplateDownload(baseDataCommonDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailTemplateDownload(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        TemplateDownloadVo templateDownloadVo = srmTemplateDownloadService.getDetailTemplateDownload(RowId);
        return BaseResponse.success(templateDownloadVo);
    }

    @PostMapping({"/listTemplateDownload"})
    public BaseResponse listTemplateDownload(@RequestBody TemplateDownloadDto templateDownloadDto) {
        IPage<TemplateDownloadVo> list = srmTemplateDownloadService.listTemplateDownload(templateDownloadDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteTemplateDownload"})
    public BaseResponse deleteTemplateDownload(@RequestBody BaseDto baseDto) {
        srmTemplateDownloadService.deleteTemplateDownload(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
