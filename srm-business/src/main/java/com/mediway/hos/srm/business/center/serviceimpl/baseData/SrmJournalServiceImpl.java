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
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.JournalDictDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmJournal;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmJournalMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.JournalDictVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmJournalService;

import javax.annotation.Resource;

/**
 * <p>
 * 期刊表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmJournalServiceImpl extends BaseServiceImpl<SrmJournalMapper, SrmJournal> implements SrmJournalService {
    @Autowired
    private SrmJournalMapper srmJournalMapper;
    @Override
    public List<CombVo> getJournal(JournalDictDto journalDictDto) {
        return srmJournalMapper.getJournal(journalDictDto);
    }
    @Autowired
    private SrmJournalService  srmJournalService;
    @Resource
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateJournalDict(BaseDataLearningDto baseDataLearningDto) {
        List<JournalDictDto> journalDictDtos =baseDataLearningDto.getJournalDicts();

        List<SrmJournal> journalDictList=new ArrayList<>();
        for (JournalDictDto journalDictDto :journalDictDtos) {
            SrmJournal srmJournalDict = new SrmJournal();
            srmJournalDict.setId(journalDictDto.getRowId());
            if(ObjectUtil.isEmpty(journalDictDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PT_JOURNAL_DICT, 3, "");
                srmJournalDict.setCode(code);
            }else{
                srmJournalDict.setCode(journalDictDto.getCode());
            }
            srmJournalDict.setName(journalDictDto.getName());
            srmJournalDict.setIsValid(journalDictDto.getIsValid());
            srmJournalDict.setIssnCode(journalDictDto.getIssnCode());
            srmJournalDict.setCnCode(journalDictDto.getCnCode());
            srmJournalDict.setFactor(journalDictDto.getFactor());
            srmJournalDict.setJcr(journalDictDto.getJcr());
            srmJournalDict.setResponsibleUnitName(journalDictDto.getResponsibleUnitName());
            srmJournalDict.setEissnCode(journalDictDto.getEissnCode());
            srmJournalDict.setPublishCycle(journalDictDto.getPublishCycle());
            srmJournalDict.setMailingCode(journalDictDto.getMailingCode());
            srmJournalDict.setAlias(journalDictDto.getAlias());

            journalDictList.add(srmJournalDict);
            Long RowId = srmJournalDict.getId();
        }
        super.saveOrUpdateBatch(journalDictList);
        return RowId;
    }
    @Override
    public JournalDictVo getDetailJournalDict(Long RowId) {
        return null;
    }

    @Override
    public IPage<JournalDictVo> listJournalDict(JournalDictDto journalDictDto) {
        Page<JournalDictVo> page = new Page<>(journalDictDto.getPage(), journalDictDto.getRows());
        IPage<JournalDictVo> res= srmJournalMapper.listJournalDict(page, journalDictDto);
        //List<JournalDictVo> records=res.getRecords();
        //List<JournalDictVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteJournalDict(BaseDto baseDto) {
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
