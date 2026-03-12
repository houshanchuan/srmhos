package com.mediway.hos.srm.business.center.serviceimpl.award;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.award.AwardApplyInfoDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.entity.award.SrmAwardApplyInfo;
import com.mediway.hos.srm.business.center.mapper.award.SrmAwardApplyInfoMapper;
import com.mediway.hos.srm.business.center.model.vo.award.AwardApplyInfoVo;
import com.mediway.hos.srm.business.center.service.award.SrmAwardApplyInfoService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.mediway.hos.srm.business.center.service.approvalProcess.SrmEafRecService;
import com.mediway.hos.srm.business.center.service.user.SrmUserService;
import com.mediway.hos.srm.business.center.utils.DateTransform;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 获奖申报计划 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmAwardApplyInfoServiceImpl extends BaseServiceImpl<SrmAwardApplyInfoMapper, SrmAwardApplyInfo> implements SrmAwardApplyInfoService {
    @Autowired
    private SrmUserService srmUserService;
    @Autowired
    private SrmEafRecService srmEafRecService;
    @Autowired
    private SrmAwardApplyInfoMapper srmAwardApplyInfoMapper;
    @Override
    @Transactional
    public Long saveAwardApplyInfo(AwardApplyInfoDto awardApplyInfoDto) {
        Long RowId=null;
        try{
            String userCode=awardApplyInfoDto.getUserCode();
            Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
            SrmAwardApplyInfo srmAwardApplyInfo=new SrmAwardApplyInfo();
            srmAwardApplyInfo.setId(awardApplyInfoDto.getRowId());
            srmAwardApplyInfo.setApplyName(awardApplyInfoDto.getApplyName());

            srmAwardApplyInfo.setAwardName(awardApplyInfoDto.getAwardName());
            srmAwardApplyInfo.setAwardLevel(awardApplyInfoDto.getAwardLevel());
            LocalDateTime stateDate=DateTransform.getLocalDateTime(awardApplyInfoDto.getStartDate());
            LocalDateTime endDate=DateTransform.getLocalDateTime(awardApplyInfoDto.getEndDate());
            srmAwardApplyInfo.setStartDate(stateDate);
            srmAwardApplyInfo.setEndDate(endDate);
            srmAwardApplyInfo.setNote(awardApplyInfoDto.getNote());
            srmAwardApplyInfo.setCreatorCode(userCode);
            srmAwardApplyInfo.setCreateTime(LocalDateTime.now());
            srmAwardApplyInfo.setState(awardApplyInfoDto.getState());

            super.saveOrUpdate(srmAwardApplyInfo);
            RowId=srmAwardApplyInfo.getId();

        }catch (Exception exception){
            throw new ErrorException("-200",exception.getMessage());
        }
        return RowId;
    }

    @Override
    public List<AwardApplyInfoVo> listAwardApplyInfo(AwardApplyInfoDto awardApplyInfoDto) {
        //String userCode=awardApplyInfoDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(null);
        awardApplyInfoDto.setUserId(srmUserRowId);
        return srmAwardApplyInfoMapper.listAwardApplyInfo(awardApplyInfoDto);
    }

    @Override
    public AwardApplyInfoVo getDetail(Long rowId) {
        return srmAwardApplyInfoMapper.getDetail(rowId);
    }

    @Override
    @Transactional
    public void deleteAwardApplyInfo(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                SrmAwardApplyInfo srmAwardApplyInfo=srmAwardApplyInfoMapper.selectById(RowId);
                String state=srmAwardApplyInfo.getState();
                System.out.println(state);
                if("1".equals(state)){
                    throw new ErrorException("-200","申报中不允许删除");
                }
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
}
