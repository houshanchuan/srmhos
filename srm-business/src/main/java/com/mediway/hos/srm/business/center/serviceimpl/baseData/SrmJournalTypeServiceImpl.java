package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import com.mediway.hos.srm.business.center.constants.BusinessConstants;
import com.mediway.hos.srm.business.center.model.dto.baseData.JournalDictDto;
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

import com.mediway.hos.srm.business.center.model.dto.baseData.JournalTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmJournalType;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmJournalTypeMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.JournalTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmJournalTypeService;

import javax.annotation.Resource;

/**
 * <p>
 * 期刊类型表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmJournalTypeServiceImpl extends BaseServiceImpl<SrmJournalTypeMapper, SrmJournalType> implements SrmJournalTypeService {
    @Autowired
    private SrmJournalTypeService  srmJournalTypeService;
    @Autowired
    private SrmJournalTypeMapper srmJournalTypeMapper;
    @Resource
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateJournalType(BaseDataLearningDto baseDataLearningDto) {
        List<JournalTypeDto> journalTypeDtos =baseDataLearningDto.getJournalTypes();

        List<SrmJournalType> journalTypeList=new ArrayList<>();
        for (JournalTypeDto journalTypeDto :journalTypeDtos) {
            SrmJournalType srmJournalType = new SrmJournalType();
            srmJournalType.setId(journalTypeDto.getRowId());
            if(ObjectUtil.isEmpty(journalTypeDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PT_JOURNAL_TYPE, 1, "");
                srmJournalType.setCode(code);
            }else{
                srmJournalType.setCode(journalTypeDto.getCode());
            }
            srmJournalType.setName(journalTypeDto.getName());
            srmJournalType.setIsValid(Integer.valueOf(journalTypeDto.getIsValid()));

            journalTypeList.add(srmJournalType);
            Long RowId = srmJournalType.getId();
        }
        super.saveOrUpdateBatch(journalTypeList);
        return RowId;
    }
    @Override
    public JournalTypeVo getDetailJournalType(Long RowId) {
        return null;
    }

    @Override
    public IPage<JournalTypeVo> listJournalType(JournalTypeDto journalTypeDto) {
        Page<JournalTypeVo> page = new Page<>(journalTypeDto.getPage(), journalTypeDto.getRows());
        IPage<JournalTypeVo> res= srmJournalTypeMapper.listJournalType(page, journalTypeDto);
        //List<JournalTypeVo> records=res.getRecords();
        //List<JournalTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteJournalType(BaseDto baseDto) {
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

    @Override
    public List<CombVo> getJournalType() {
        return srmJournalTypeMapper.getJournalType();
    }
}
