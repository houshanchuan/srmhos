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
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


import com.mediway.hos.srm.business.center.model.dto.baseData.JournalSourceDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmJournalSource;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmJournalSourceMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.JournalSourceVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmJournalSourceService;

import javax.annotation.Resource;

/**
 * <p>
 * 期刊源代码表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmJournalSourceServiceImpl extends BaseServiceImpl<SrmJournalSourceMapper, SrmJournalSource> implements SrmJournalSourceService {
    @Autowired
    private SrmJournalSourceService  srmJournalSourceService;
    @Autowired
    private SrmJournalSourceMapper srmJournalSourceMapper;
    @Resource
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateJournalSource(BaseDataLearningDto baseDataLearningDto) {
        List<JournalSourceDto> journalSourceDtos =baseDataLearningDto.getJournalSources();

        List<SrmJournalSource> journalSourceList = new ArrayList<>();
        for (JournalSourceDto journalSourceDto : journalSourceDtos) {
            SrmJournalSource srmJournalSource = new SrmJournalSource();
            srmJournalSource.setId(journalSourceDto.getRowId());
            if(ObjectUtil.isEmpty(journalSourceDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PT_JOURNAL_SOURCE, 3, "");
                srmJournalSource.setCode(code);
            }else{
                srmJournalSource.setCode(journalSourceDto.getCode());
            }
            srmJournalSource.setName(journalSourceDto.getName());
            srmJournalSource.setIsValid(journalSourceDto.getIsValid());
            srmJournalSource.setStartYear(journalSourceDto.getStartYear());
            srmJournalSource.setEndYear(journalSourceDto.getEndYear());
            srmJournalSource.setNote(journalSourceDto.getNote());
            srmJournalSource.setJournalType(journalSourceDto.getJournalType());
            journalSourceList.add(srmJournalSource);
            Long RowId = srmJournalSource.getId();
        }
        super.saveOrUpdateBatch(journalSourceList);
        return RowId;
    }
    @Override
    public JournalSourceVo getDetailJournalSource(Long RowId) {
        return null;
    }

    @Override
    public IPage<JournalSourceVo> listJournalSource(JournalSourceDto journalSourceDto) {
        Page<JournalSourceVo> page = new Page<>(journalSourceDto.getPage(), journalSourceDto.getRows());
        IPage<JournalSourceVo> res= srmJournalSourceMapper.listJournalSource(page, journalSourceDto);
        //List<JournalSourceVo> records=res.getRecords();
        //List<JournalSourceVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteJournalSource(BaseDto baseDto) {
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
