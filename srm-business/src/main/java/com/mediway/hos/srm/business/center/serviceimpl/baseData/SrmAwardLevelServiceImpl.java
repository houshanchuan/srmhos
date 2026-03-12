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

import com.mediway.hos.srm.business.center.model.dto.baseData.AwardLevelDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmAwardLevel;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmAwardLevelMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.AwardLevelVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmAwardLevelService;

/**
 * <p>
 * 获奖级别 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmAwardLevelServiceImpl extends BaseServiceImpl<SrmAwardLevelMapper, SrmAwardLevel> implements SrmAwardLevelService {
    @Autowired
    private SrmAwardLevelService  srmAwardLevelService;
    @Autowired
    private SrmAwardLevelMapper srmAwardLevelMapper;
    private Long RowId;		 
    @Override
    public List<CombVo> getAwardLevel() {
        return srmAwardLevelMapper.getAwardLevel();
	}
    @Override
    @Transactional
    public Long saveOrUpdateAwardLevel(BaseDataLearningDto baseDataLearningDto) {
        List<AwardLevelDto> awardLevelDtos =baseDataLearningDto.getAwardLevels();

        List<SrmAwardLevel> awardLevelList=new ArrayList<>();
        for (AwardLevelDto awardLevelDto :awardLevelDtos) {
            SrmAwardLevel srmAwardLevel = new SrmAwardLevel();
            srmAwardLevel.setId(awardLevelDto.getRowId());
            srmAwardLevel.setCode(awardLevelDto.getCode());
            srmAwardLevel.setName(awardLevelDto.getName());
            srmAwardLevel.setIsValid(Integer.valueOf(awardLevelDto.getIsValid()));

            awardLevelList.add(srmAwardLevel);
            Long RowId = srmAwardLevel.getId();
        }
        super.saveOrUpdateBatch(awardLevelList);
        return RowId;
    }
    @Override
    public AwardLevelVo getDetailAwardLevel(Long RowId) {
        return null;
    }

    @Override
    public IPage<AwardLevelVo> listAwardLevel(AwardLevelDto awardLevelDto) {
        Page<AwardLevelVo> page = new Page<>(awardLevelDto.getPage(), awardLevelDto.getRows());
        IPage<AwardLevelVo> res= srmAwardLevelMapper.listAwardLevel(page, awardLevelDto);
        //List<AwardLevelVo> records=res.getRecords();
        //List<AwardLevelVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteAwardLevel(BaseDto baseDto) {
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
