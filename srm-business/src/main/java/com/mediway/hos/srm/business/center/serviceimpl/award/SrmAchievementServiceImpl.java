package com.mediway.hos.srm.business.center.serviceimpl.award;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mediway.hos.app.core.util.SecurityUtils;
import com.mediway.hos.security.core.userdetails.HosUser;
import com.mediway.hos.srm.business.center.model.dto.award.AchievementAuthorDto;
import com.mediway.hos.srm.business.center.model.dto.award.AchievementDto;
import com.mediway.hos.srm.business.center.model.dto.award.AchievementMainDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.service.approvalProcess.SrmEafRecService;
import com.mediway.hos.srm.business.center.service.award.SrmAchievementAuthorService;
import com.mediway.hos.srm.business.center.service.award.SrmAchievementService;
import com.mediway.hos.srm.business.center.service.baseData.SrmUploadInfoService;
import com.mediway.hos.srm.business.center.service.user.SrmUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;

import com.mediway.hos.srm.business.center.model.entity.award.SrmAchievement;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmAchievementMapper;
import com.mediway.hos.srm.business.center.model.entity.award.SrmAchievementAuthor;
import com.mediway.hos.srm.business.center.model.vo.award.AchievementVo;

import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 成果获奖登记 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmAchievementServiceImpl extends BaseServiceImpl<SrmAchievementMapper, SrmAchievement> implements SrmAchievementService {
    private final String achievementSysNo="P009";
    @Autowired
    private SrmAchievementMapper srmAchievementMapper;
    @Autowired
    private SrmUserService srmUserService;
    @Autowired
    private SrmEafRecService srmEafRecService;
    @Autowired
    private SrmUploadInfoService srmUploadInfoService;
    @Autowired
    private SrmAchievementAuthorService srmAchievementAuthorService;
    @Override
    public AchievementVo getDetail(String rowId) {
        return srmAchievementMapper.getDetail(rowId);
    }

    @Override
    @Transactional
    public Long saveAchievement(AchievementMainDto achievementMainDto) {
        AchievementDto achievementDto=achievementMainDto.getAchievementDto();
        SrmAchievement srmAchievement=new SrmAchievement();
        srmAchievement.setSysNo(this.achievementSysNo);
        String name=achievementDto.getName();
        srmAchievement.setName(name);

        if(name==null||name.isEmpty()){
            throw new ErrorException("-200","奖励名称不能为空");
        }

        srmAchievement.setAwardName(achievementDto.getAwardName());
        srmAchievement.setAchvCat(achievementDto.getAchvCat());
        srmAchievement.setId(achievementDto.getRowId());
        srmAchievement.setYear(achievementDto.getYear());
        srmAchievement.setRewardUnit(achievementDto.getRewardUnit());
        srmAchievement.setMainCompleter(achievementDto.getMainCompleter());
        srmAchievement.setOurUnitRanking(achievementDto.getOurUnitRanking());
        srmAchievement.setUnitsum(achievementDto.getUnitsum());
        srmAchievement.setRewardLevel(achievementDto.getRewardLevel());
        srmAchievement.setRewardType(achievementDto.getRewardType());
        srmAchievement.setRewardGrade(achievementDto.getRewardGrade());
        srmAchievement.setCertificateNo(achievementDto.getCertificateNo());
        srmAchievement.setAwardApplyId(achievementDto.getAwardApplyId());
        srmAchievement.setDeptId(achievementDto.getDeptId());
        srmAchievement.setClassCode(achievementDto.getClassCode());
        srmAchievement.setDiscipline(achievementDto.getDiscipline());
        srmAchievement.setDisciplineTwo(achievementDto.getDisciplineTwo());
        srmAchievement.setDisciplineThree(achievementDto.getDisciplineThree());
        srmAchievement.setNote(achievementDto.getNote());
        srmAchievement.setSource(achievementDto.getSource());
        srmAchievement.setSchoolSign(achievementDto.getSchoolSign());

        srmAchievement.setRewardDate(achievementDto.getRewardDate());
        Long RowId=null;
        try{
            //srmAchievement.setRewardDate(DateTransform.getLocalDateTime(achievementDto.getRewardDate()));
            String userCode=achievementDto.getUserCode();
            Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
            if(achievementDto.getRowId()==null){
                srmAchievement.setCreateTime(LocalDateTime.now());
                srmAchievement.setCreatorId(String.valueOf(srmUserRowId));
            }

            super.saveOrUpdate(srmAchievement);
            RowId=srmAchievement.getId();

            List<AchievementAuthorDto> achievementAuthorDtos=achievementMainDto.getAchievementAuthorDtos();
            List<SrmAchievementAuthor> srmAchievementAuthors=new ArrayList<>();
            for(AchievementAuthorDto achievementAuthorDto :achievementAuthorDtos){
                SrmAchievementAuthor srmAchievementAuthor=new SrmAchievementAuthor();
                srmAchievementAuthor.setAchievementId(RowId);
                srmAchievementAuthor.setId(achievementAuthorDto.getRowId());
                srmAchievementAuthor.setAuthorId(achievementAuthorDto.getAuthorId());
                srmAchievementAuthor.setAuthorType(achievementAuthorDto.getAuthorType());
                srmAchievementAuthor.setTitle(achievementAuthorDto.getTitle());
                srmAchievementAuthor.setEduDegree(achievementAuthorDto.getEduDegree());
                srmAchievementAuthor.setEduLevel(achievementAuthorDto.getEduLevel());
                srmAchievementAuthor.setNote(achievementAuthorDto.getNote());
                srmAchievementAuthor.setWorkRatio(achievementAuthorDto.getWorkRatio());
                srmAchievementAuthor.setAuthorRanking(achievementAuthorDto.getAuthorRanking());
                srmAchievementAuthor.setSex(achievementAuthorDto.getSex());
                srmAchievementAuthors.add(srmAchievementAuthor);

            }
            srmAchievementAuthorService.saveOrUpdateBatch(srmAchievementAuthors);
            // 更新作者总数



        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
        return RowId;

    }

    @Override
    public IPage<AchievementVo> listAchievement(AchievementDto achievementDto) {
        String userCode=achievementDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        achievementDto.setUserId(srmUserRowId);
        Page<AchievementVo> page = new Page<>(achievementDto.getPage(), achievementDto.getRows());
        IPage<AchievementVo> res= srmAchievementMapper.listAchievement(page, achievementDto);
        List<AchievementVo> records=res.getRecords();
        List<AchievementVo> newRecords=new ArrayList<>();
        for(AchievementVo achievementVo : records){
            AchievementVo newRecord=new AchievementVo();
            newRecord=achievementVo;
            Long rowId=achievementVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc(this.achievementSysNo,rowId,null);
            newRecord.setCheckList(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }

    @Override
    @Transactional
    public void deleteAchievement(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                //System.out.println(RowId);
                srmAchievementAuthorService.deleteAuthorByParentId(RowId);
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
    @Transactional
    public void subMit(BaseDto baseDto) {
        Long rowId=baseDto.getId();
        Boolean allowSumbit=srmUploadInfoService.getFileNessary(String.valueOf(rowId),this.achievementSysNo);
        if(!allowSumbit){
            throw new ErrorException("-200","请上传必要的附件！");
        }
        HosUser hosUser = SecurityUtils.getLoginUser();
        String userCode = hosUser.getAccountCode();
        try {
            Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
            AchievementVo achievementVo=this.getDetail(String.valueOf(rowId));
            Integer dataStatus=achievementVo.getDataStatus();
            if(dataStatus==null||dataStatus==1){
                throw new ErrorException("-200","已提交");
            }
            srmAchievementMapper.updateStatus(rowId,1,"1",LocalDateTime.now(),String.valueOf(srmUserRowId));
            srmEafRecService.generateRec(String.valueOf(rowId),this.achievementSysNo,userCode,null);

        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
    }

    @Override
    @Transactional
    public void audit(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        Long srmUserRowId= srmUserService.getUserIdByAccount(null);
        String sysNo=this.achievementSysNo;
        if(srmUserRowId==null){
            throw new ErrorException("-200","当前登录用户不存在!");
        }
        String view=baseDto.getView();
        String auditStatus=baseDto.getAuditStatus();
        String resultId="";
        if(auditStatus.equals("1")){
            resultId="2";
        }
        if(auditStatus.equals("2")){
            resultId="3";
        }
        try{
            for(Long rowId : idList){
                //SrmEafDetail srmEafDetail = srmEafRecService.getCheckStatus(sysNo,String.valueOf(rowId));
                //String auditStatus= srmEafDetail.getAuditPassStatus();
                srmAchievementMapper.updateStatus(rowId,null,resultId,null,null);
                srmEafRecService.genAudit(rowId,sysNo,srmUserRowId,resultId,view,null);
            }
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
    }

    @Override
    public IPage<AchievementVo> listAuditAchievement(AchievementDto achievementDto) {
        String userCode=achievementDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        achievementDto.setUserId(srmUserRowId);
        Page<AchievementVo> page = new Page<>(achievementDto.getPage(), achievementDto.getRows());
        IPage<AchievementVo> res= srmAchievementMapper.listAuditAchievement(page, achievementDto);
        List<AchievementVo> records=res.getRecords();
        List<AchievementVo> newRecords=new ArrayList<>();
        for(AchievementVo achievementVo : records){
            AchievementVo newRecord=new AchievementVo();
            newRecord=achievementVo;
            Long rowId=achievementVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc(this.achievementSysNo,rowId,null);
            newRecord.setCheckList(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }
}
