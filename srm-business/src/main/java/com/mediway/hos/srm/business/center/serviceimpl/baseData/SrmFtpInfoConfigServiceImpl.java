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

import com.mediway.hos.srm.business.center.model.dto.baseData.FtpInfoConfigDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.FtpInfoConfigVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmFtpInfoConfig;
import com.mediway.hos.srm.business.center.service.baseData.SrmFtpInfoConfigService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmFtpInfoConfigMapper;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmFtpInfoConfigServiceImpl extends BaseServiceImpl<SrmFtpInfoConfigMapper, SrmFtpInfoConfig> implements SrmFtpInfoConfigService {

    @Autowired
    private SrmFtpInfoConfigMapper srmFtpInfoConfigMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateFtpInfoConfig(BaseDataCommonDto baseDataProjDto) {
        List<FtpInfoConfigDto> ftpInfoConfigDtos =baseDataProjDto.getFtpInfoConfigs();

        List<SrmFtpInfoConfig> ftpInfoConfigList=new ArrayList<>();
        for (FtpInfoConfigDto ftpInfoConfigDto :ftpInfoConfigDtos) {
            SrmFtpInfoConfig srmFtpInfoConfig = new SrmFtpInfoConfig();
            srmFtpInfoConfig.setId(ftpInfoConfigDto.getRowId());
            srmFtpInfoConfig.setFtpIp(ftpInfoConfigDto.getFtpIp());
            srmFtpInfoConfig.setFtpUser(ftpInfoConfigDto.getFtpUser());
            srmFtpInfoConfig.setFtpPassword(ftpInfoConfigDto.getFtpPassword());
            srmFtpInfoConfig.setFtpDesc(ftpInfoConfigDto.getFtpDesc());
            srmFtpInfoConfig.setFtpSrc(ftpInfoConfigDto.getFtpSrc());
            srmFtpInfoConfig.setFtpSsl(ftpInfoConfigDto.getFtpSsl()) ;
            srmFtpInfoConfig.setKkFileViewFlag(ftpInfoConfigDto.getKkFileViewFlag());

            ftpInfoConfigList.add(srmFtpInfoConfig);
            Long RowId = srmFtpInfoConfig.getId();
        }
        super.saveOrUpdateBatch(ftpInfoConfigList);
        return RowId;
    }
    @Override
    public FtpInfoConfigVo getDetailFtpInfoConfig(Long RowId) {
        return null;
    }

    @Override
    public IPage<FtpInfoConfigVo> listFtpInfoConfig(FtpInfoConfigDto ftpInfoConfigDto) {
        Page<FtpInfoConfigVo> page = new Page<>(ftpInfoConfigDto.getPage(), ftpInfoConfigDto.getRows());
        IPage<FtpInfoConfigVo> res= srmFtpInfoConfigMapper.listFtpInfoConfig(page, ftpInfoConfigDto);
        //List<FtpInfoConfigVo> records=res.getRecords();
        //List<FtpInfoConfigVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteFtpInfoConfig(BaseDto baseDto) {
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
