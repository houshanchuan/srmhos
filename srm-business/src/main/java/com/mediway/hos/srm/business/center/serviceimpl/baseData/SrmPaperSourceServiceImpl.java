package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import com.mediway.hos.srm.business.center.constants.BusinessConstants;
import com.mediway.hos.srm.business.center.service.baseData.SrmBusinessnoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;

import com.mediway.hos.srm.business.center.model.dto.baseData.PaperSourceDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPaperSource;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmPaperSourceMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.PaperSourceVo;

import com.mediway.hos.srm.business.center.service.baseData.SrmPaperSourceService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 论文来源途径 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmPaperSourceServiceImpl extends BaseServiceImpl<SrmPaperSourceMapper, SrmPaperSource> implements SrmPaperSourceService {
    @Autowired
    private SrmPaperSourceService  srmPaperSourceService;
    @Autowired
    private SrmPaperSourceMapper srmPaperSourceMapper;
    @Resource
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdatePaperSource(BaseDataLearningDto baseDataLearningDto) {
        List<PaperSourceDto> paperSourceDtos =baseDataLearningDto.getPaperSources();

        List<SrmPaperSource> paperSourceList=new ArrayList<>();
        for (PaperSourceDto paperSourceDto :paperSourceDtos) {
            SrmPaperSource srmPaperSource = new SrmPaperSource();
            srmPaperSource.setId(paperSourceDto.getRowId());
            if(ObjectUtil.isEmpty(paperSourceDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PT_SOURCE, 3, "");
                srmPaperSource.setCode(code);
            }else{
                srmPaperSource.setCode(paperSourceDto.getCode());
            }
            srmPaperSource.setName(paperSourceDto.getName());
            srmPaperSource.setIsValid(paperSourceDto.getIsValid());

            paperSourceList.add(srmPaperSource);
            Long RowId = srmPaperSource.getId();
        }
        super.saveOrUpdateBatch(paperSourceList);
        return RowId;
    }
    @Override
    public PaperSourceVo getDetailPaperSource(Long RowId) {
        return null;
    }

    @Override
    public IPage<PaperSourceVo> listPaperSource(PaperSourceDto paperSourceDto) {
        Page<PaperSourceVo> page = new Page<>(paperSourceDto.getPage(), paperSourceDto.getRows());
        IPage<PaperSourceVo> res= srmPaperSourceMapper.listPaperSource(page, paperSourceDto);
        //List<PaperSourceVo> records=res.getRecords();
        //List<PaperSourceVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deletePaperSource(BaseDto baseDto) {
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