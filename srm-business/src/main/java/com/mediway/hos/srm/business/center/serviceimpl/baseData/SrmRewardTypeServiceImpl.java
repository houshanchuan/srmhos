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

import com.mediway.hos.srm.business.center.model.dto.baseData.RewardTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmRewardType;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmRewardTypeMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.RewardTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmRewardTypeService;

/**
 * <p>
 * 获奖类型表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmRewardTypeServiceImpl extends BaseServiceImpl<SrmRewardTypeMapper, SrmRewardType> implements SrmRewardTypeService {
    @Autowired
    private SrmRewardTypeMapper srmRewardTypeMapper;
    private Long RowId;
    @Override		 
	public List<CombVo> getRewardType() {
        return srmRewardTypeMapper.getRewardType();	
	}
    @Transactional
    public Long saveOrUpdateRewardType(BaseDataLearningDto baseDataLearningDto) {
        List<RewardTypeDto> rewardTypeDtos =baseDataLearningDto.getRewardTypes();

        List<SrmRewardType> rewardTypeList=new ArrayList<>();
        for (RewardTypeDto rewardTypeDto :rewardTypeDtos) {
            SrmRewardType srmRewardType = new SrmRewardType();
            srmRewardType.setId(rewardTypeDto.getRowId());
            srmRewardType.setCode(rewardTypeDto.getCode());
            srmRewardType.setName(rewardTypeDto.getName());
            srmRewardType.setIsValid(Integer.valueOf(rewardTypeDto.getIsValid()));

            rewardTypeList.add(srmRewardType);
            Long RowId = srmRewardType.getId();
        }
        super.saveOrUpdateBatch(rewardTypeList);
        return RowId;
    }
    @Override
    public RewardTypeVo getDetailRewardType(Long RowId) {
        return null;
    }

    @Override
    public IPage<RewardTypeVo> listRewardType(RewardTypeDto rewardTypeDto) {
        Page<RewardTypeVo> page = new Page<>(rewardTypeDto.getPage(), rewardTypeDto.getRows());
        IPage<RewardTypeVo> res= srmRewardTypeMapper.listRewardType(page, rewardTypeDto);
        //List<RewardTypeVo> records=res.getRecords();
        //List<RewardTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteRewardType(BaseDto baseDto) {
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
