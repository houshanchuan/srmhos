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

import com.mediway.hos.srm.business.center.model.dto.baseData.JournalLevelDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmJournalLevel;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmJournalLevelMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.JournalLevelVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmJournalLevelService;

import javax.annotation.Resource;

/**
 * <p>
 * 期刊级别 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmJournalLevelServiceImpl extends BaseServiceImpl<SrmJournalLevelMapper, SrmJournalLevel> implements SrmJournalLevelService {
    @Autowired
    private SrmJournalLevelService  srmJournalLevelService;
    @Autowired
    private SrmJournalLevelMapper srmJournalLevelMapper;
    @Resource
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateJournalLevel(BaseDataLearningDto baseDataLearningDto) {
        List<JournalLevelDto> journalLevelDtos =baseDataLearningDto.getJournalLevels();

        List<SrmJournalLevel> journalLevelList=new ArrayList<>();
        for (JournalLevelDto journalLevelDto :journalLevelDtos) {
            SrmJournalLevel srmJournalLevel = new SrmJournalLevel();
            srmJournalLevel.setId(journalLevelDto.getRowId());
            if(ObjectUtil.isEmpty(journalLevelDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PT_JOURNAL_LEVEL, 2, "");
                srmJournalLevel.setCode(code);
            }else{
                srmJournalLevel.setCode(journalLevelDto.getCode());
            }
            srmJournalLevel.setName(journalLevelDto.getName());
            srmJournalLevel.setIsValid(Integer.valueOf(journalLevelDto.getIsValid()));

            journalLevelList.add(srmJournalLevel);
            Long RowId = srmJournalLevel.getId();
        }
        super.saveOrUpdateBatch(journalLevelList);
        return RowId;
    }
    @Override
    public JournalLevelVo getDetailJournalLevel(Long RowId) {
        return null;
    }

    @Override
    public IPage<JournalLevelVo> listJournalLevel(JournalLevelDto journalLevelDto) {
        Page<JournalLevelVo> page = new Page<>(journalLevelDto.getPage(), journalLevelDto.getRows());
        IPage<JournalLevelVo> res= srmJournalLevelMapper.listJournalLevel(page, journalLevelDto);
        //List<JournalLevelVo> records=res.getRecords();
        //List<JournalLevelVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteJournalLevel(BaseDto baseDto) {
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
