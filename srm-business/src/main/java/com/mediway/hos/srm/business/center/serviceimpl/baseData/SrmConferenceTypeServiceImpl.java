package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import com.mediway.hos.common.util.StringUtil;
import com.mediway.hos.i18n.utils.I18nUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;


import com.mediway.hos.srm.business.center.model.dto.baseData.ConferenceTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmConferenceType;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmConferenceTypeMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.ConferenceTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmConferenceTypeService;

/**
 * <p>
 * 会议类型 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmConferenceTypeServiceImpl extends BaseServiceImpl<SrmConferenceTypeMapper, SrmConferenceType> implements SrmConferenceTypeService {
    @Autowired
    private SrmConferenceTypeService  srmConferenceTypeService;
    @Autowired
    private SrmConferenceTypeMapper srmConferenceTypeMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateConferenceType(BaseDataLearningDto baseDataLearningDto) {
        List<ConferenceTypeDto> conferenceTypeDtos =baseDataLearningDto.getConferenceTypes();

        List<SrmConferenceType> conferenceTypeList=new ArrayList<>();
        for (ConferenceTypeDto conferenceTypeDto :conferenceTypeDtos) {
            SrmConferenceType srmConferenceType = new SrmConferenceType();
            srmConferenceType.setId(conferenceTypeDto.getRowId());
            srmConferenceType.setCode(conferenceTypeDto.getCode());
            srmConferenceType.setName(conferenceTypeDto.getName());
            srmConferenceType.setIsValid(Integer.valueOf(conferenceTypeDto.getIsValid()));

            conferenceTypeList.add(srmConferenceType);
            Long RowId = srmConferenceType.getId();
        }
        super.saveOrUpdateBatch(conferenceTypeList);
        return RowId;
    }
    @Override
    public ConferenceTypeVo getDetailConferenceType(Long RowId) {
        return null;
    }

    @Override
    public IPage<ConferenceTypeVo> listConferenceType(ConferenceTypeDto conferenceTypeDto) {
        Page<ConferenceTypeVo> page = new Page<>(conferenceTypeDto.getPage(), conferenceTypeDto.getRows());
        IPage<ConferenceTypeVo> res= srmConferenceTypeMapper.listConferenceType(page, conferenceTypeDto);
        //List<ConferenceTypeVo> records=res.getRecords();
        //List<ConferenceTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteConferenceType(BaseDto baseDto) {
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
    public List<CombVo> getConferenceType(){
        List<CombVo> comList= srmConferenceTypeMapper.getConferenceType();
        List<String> idList = comList.stream().map(CombVo::getId).collect(Collectors.toList());

        Map<String, String> nameTransMap = I18nUtil.mapTransValue("ct_srm_conference_type", idList, "name", "hos_i18n_data");

        comList.forEach(CombVo -> {
            String value = nameTransMap.get(CombVo.getId());
            if (StringUtil.isNotBlank(value)) {
                CombVo.setName(value);
            }
        });
        return comList;
    }
}
