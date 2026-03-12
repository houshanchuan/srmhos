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

import com.mediway.hos.srm.business.center.model.dto.baseData.RewardLevelInfoDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmRewardLevelInfo;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmRewardLevelInfoMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.RewardLevelInfoVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmRewardLevelInfoService;

/**
 * <p>
 * 奖励类别及奖项名称对应表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmRewardLevelInfoServiceImpl extends BaseServiceImpl<SrmRewardLevelInfoMapper, SrmRewardLevelInfo> implements SrmRewardLevelInfoService {
    @Autowired
    private SrmRewardLevelInfoService  srmRewardLevelInfoService;
    @Autowired
    private SrmRewardLevelInfoMapper srmRewardLevelInfoMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateRewardLevelInfo(BaseDataLearningDto baseDataLearningDto) {
        List<RewardLevelInfoDto> rewardLevelInfoDtos =baseDataLearningDto.getRewardLevelInfos();

        List<SrmRewardLevelInfo> rewardLevelInfoList=new ArrayList<>();
        for (RewardLevelInfoDto rewardLevelInfoDto :rewardLevelInfoDtos) {
            SrmRewardLevelInfo srmRewardLevelInfo = new SrmRewardLevelInfo();
            srmRewardLevelInfo.setId(rewardLevelInfoDto.getRowId());
            srmRewardLevelInfo.setCode(rewardLevelInfoDto.getCode());
            srmRewardLevelInfo.setName(rewardLevelInfoDto.getName());
            srmRewardLevelInfo.setIsValid(Integer.valueOf(rewardLevelInfoDto.getIsValid()));

            rewardLevelInfoList.add(srmRewardLevelInfo);
            Long RowId = srmRewardLevelInfo.getId();
        }
        super.saveOrUpdateBatch(rewardLevelInfoList);
        return RowId;
    }
    @Override
    public RewardLevelInfoVo getDetailRewardLevelInfo(Long RowId) {
        return null;
    }

    @Override
    public IPage<RewardLevelInfoVo> listRewardLevelInfo(RewardLevelInfoDto rewardLevelInfoDto) {
        Page<RewardLevelInfoVo> page = new Page<>(rewardLevelInfoDto.getPage(), rewardLevelInfoDto.getRows());
        IPage<RewardLevelInfoVo> res= srmRewardLevelInfoMapper.listRewardLevelInfo(page, rewardLevelInfoDto);
        //List<RewardLevelInfoVo> records=res.getRecords();
        //List<RewardLevelInfoVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteRewardLevelInfo(BaseDto baseDto) {
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
