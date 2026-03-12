package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
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


import com.mediway.hos.srm.business.center.model.dto.baseData.PatentAgencyFeeSourceDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPatentAgencyFeeSource;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmPatentAgencyFeeSourceMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.PatentAgencyFeeSourceVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmPatentAgencyFeeSourceService;

/**
 * <p>
 * 专利代理费用来源 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmPatentAgencyFeeSourceServiceImpl extends BaseServiceImpl<SrmPatentAgencyFeeSourceMapper, SrmPatentAgencyFeeSource> implements SrmPatentAgencyFeeSourceService {
    @Autowired
    private SrmPatentAgencyFeeSourceService  srmPatentAgencyFeeSourceService;
    @Autowired
    private SrmPatentAgencyFeeSourceMapper srmPatentAgencyFeeSourceMapper;
    private Long RowId;
    @Override
    public List<CombVo> getPatentAgencyFeeSource(PatentAgencyFeeSourceDto patentAgencyFeeSourceDto) {
        return srmPatentAgencyFeeSourceMapper.getPatentAgencyFeeSource(patentAgencyFeeSourceDto);
	}
    @Override
    @Transactional
    public Long saveOrUpdatePatentAgencyFeeSource(BaseDataLearningDto baseDataLearningDto) {
        List<PatentAgencyFeeSourceDto> patentAgencyFeeSourceDtos =baseDataLearningDto.getPatentAgencyFeeSources();

        List<SrmPatentAgencyFeeSource> patentAgencyFeeSourceList=new ArrayList<>();
        for (PatentAgencyFeeSourceDto patentAgencyFeeSourceDto :patentAgencyFeeSourceDtos) {
            SrmPatentAgencyFeeSource srmPatentAgencyFeeSource = new SrmPatentAgencyFeeSource();
            srmPatentAgencyFeeSource.setId(patentAgencyFeeSourceDto.getRowId());
            srmPatentAgencyFeeSource.setCode(patentAgencyFeeSourceDto.getCode());
            srmPatentAgencyFeeSource.setName(patentAgencyFeeSourceDto.getName());
            srmPatentAgencyFeeSource.setIsValid(Integer.valueOf(patentAgencyFeeSourceDto.getIsValid()));

            patentAgencyFeeSourceList.add(srmPatentAgencyFeeSource);
            Long RowId = srmPatentAgencyFeeSource.getId();
        }
        super.saveOrUpdateBatch(patentAgencyFeeSourceList);
        return RowId;
    }
    @Override
    public PatentAgencyFeeSourceVo getDetailPatentAgencyFeeSource(Long RowId) {
        return null;
    }

    @Override
    public IPage<PatentAgencyFeeSourceVo> listPatentAgencyFeeSource(PatentAgencyFeeSourceDto patentAgencyFeeSourceDto) {
        Page<PatentAgencyFeeSourceVo> page = new Page<>(patentAgencyFeeSourceDto.getPage(), patentAgencyFeeSourceDto.getRows());
        IPage<PatentAgencyFeeSourceVo> res= srmPatentAgencyFeeSourceMapper.listPatentAgencyFeeSource(page, patentAgencyFeeSourceDto);
        //List<PatentAgencyFeeSourceVo> records=res.getRecords();
        //List<PatentAgencyFeeSourceVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deletePatentAgencyFeeSource(BaseDto baseDto) {
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
