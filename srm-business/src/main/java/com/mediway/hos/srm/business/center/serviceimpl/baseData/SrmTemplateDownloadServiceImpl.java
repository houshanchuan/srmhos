package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataCommonDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.TemplateDownloadDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.TemplateDownloadVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmTemplateDownload;
import com.mediway.hos.srm.business.center.service.baseData.SrmTemplateDownloadService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmTemplateDownloadMapper;

/**
 * <p>
 * 模板下载专区 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmTemplateDownloadServiceImpl extends BaseServiceImpl<SrmTemplateDownloadMapper, SrmTemplateDownload> implements SrmTemplateDownloadService {

    @Autowired
    private SrmTemplateDownloadMapper srmTemplateDownloadMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateTemplateDownload(BaseDataCommonDto baseDataCommonDto) {
        List<TemplateDownloadDto> templateDownloadDtos =baseDataCommonDto.getTemplateDownloads();
        List<SrmTemplateDownload> templateDownloadList=new ArrayList<>();
        for (TemplateDownloadDto templateDownloadDto :templateDownloadDtos) {
            SrmTemplateDownload srmTemplateDownload = new SrmTemplateDownload();
            srmTemplateDownload.setId(templateDownloadDto.getRowId());
            srmTemplateDownload.setYear(templateDownloadDto.getYear());
            srmTemplateDownload.setTitle(templateDownloadDto.getTitle());
            srmTemplateDownload.setTempType(templateDownloadDto.getTempType());
            srmTemplateDownload.setSysNo(templateDownloadDto.getSysNo());
            templateDownloadList.add(srmTemplateDownload);
            Long RowId = srmTemplateDownload.getId();
        }
        super.saveOrUpdateBatch(templateDownloadList);
        return RowId;
    }
    @Override
    public TemplateDownloadVo getDetailTemplateDownload(Long RowId) {
        TemplateDownloadVo templateDownloadVo=srmTemplateDownloadMapper.getDetailTemplateDownload(RowId);
        return templateDownloadVo;
    }

    @Override
    public IPage<TemplateDownloadVo> listTemplateDownload(TemplateDownloadDto templateDownloadDto) {
        Page<TemplateDownloadVo> page = new Page<>(templateDownloadDto.getPage(), templateDownloadDto.getRows());
        IPage<TemplateDownloadVo> res= srmTemplateDownloadMapper.listTemplateDownload(page, templateDownloadDto);
        //List<TemplateDownloadVo> records=res.getRecords();
        //List<TemplateDownloadVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteTemplateDownload(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                //System.out.println(RowId);
                if(StringUtils.isEmpty(idStr)){
                    idStr=String.valueOf(RowId);
                }else{
                    idStr=idStr+","+String.valueOf(RowId);
                }
            }
            super.deleteByIds(idStr);
        }catch (Exception exception){
            throw  new ErrorException("-200",exception.getMessage());
        }
    }

    @Override
    public Long getIdByName(String name) {
        return null;
    }
}
