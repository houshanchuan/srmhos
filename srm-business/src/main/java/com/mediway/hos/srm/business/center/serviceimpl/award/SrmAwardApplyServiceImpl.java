package com.mediway.hos.srm.business.center.serviceimpl.award;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mediway.hos.app.core.util.SecurityUtils;
import com.mediway.hos.security.core.userdetails.HosUser;
import com.mediway.hos.srm.business.center.model.dto.award.AwardApplyAuthorDto;
import com.mediway.hos.srm.business.center.model.dto.award.AwardApplyDto;
import com.mediway.hos.srm.business.center.model.dto.award.AwardApplyMainDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperSubmissionExpertAuditDto;
import com.mediway.hos.srm.business.center.service.approvalProcess.SrmEafRecService;
import com.mediway.hos.srm.business.center.service.award.SrmAwardApplyAuthorService;
import com.mediway.hos.srm.business.center.service.award.SrmAwardApplyService;
import com.mediway.hos.srm.business.center.service.baseData.SrmUploadInfoService;
import com.mediway.hos.srm.business.center.service.user.SrmUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;

import com.mediway.hos.srm.business.center.model.entity.award.SrmAwardApply;
import com.mediway.hos.srm.business.center.mapper.award.SrmAwardApplyMapper;
import com.mediway.hos.srm.business.center.model.entity.award.SrmAwardApplyAuthor;
import com.mediway.hos.srm.business.center.model.vo.award.AwardApplyVo;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperSubmissionExpertAuditVo;

import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.mediway.hos.srm.business.center.utils.DateTransform;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 获奖申报 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmAwardApplyServiceImpl extends BaseServiceImpl<SrmAwardApplyMapper, SrmAwardApply> implements SrmAwardApplyService {
    private final String awardApplySysNo="P045";
    @Autowired
    private SrmAwardApplyMapper srmAwardApplyMapper;
    @Autowired
    private SrmUserService srmUserService;
    @Autowired
    private SrmEafRecService srmEafRecService;
    @Autowired
    private SrmUploadInfoService srmUploadInfoService;
    @Autowired
    private SrmAwardApplyAuthorService srmAwardApplyAuthorService;
    @Override
    public AwardApplyVo getDetail(String rowId) {
        return srmAwardApplyMapper.getDetail(rowId);
    }

    @Override
    @Transactional
    public Long saveAwardApply(AwardApplyMainDto awardApplyMainDto) {
        AwardApplyDto awardApplyDto=awardApplyMainDto.getAwardApplyDto();
        SrmAwardApply srmAwardApply=new SrmAwardApply();
        String userCode=awardApplyDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        srmAwardApply.setId(awardApplyDto.getRowId());
        srmAwardApply.setApplyInfoId(awardApplyDto.getApplyInfoId());
        srmAwardApply.setAwardName(awardApplyDto.getAwardName());
        srmAwardApply.setProductMode(awardApplyDto.getProductMode());
        srmAwardApply.setProductName(awardApplyDto.getProductName());
        srmAwardApply.setDeptId(awardApplyDto.getDeptId());
        srmAwardApply.setApplyDate(DateTransform.getLocalDateTime(awardApplyDto.getApplyDate()));
        srmAwardApply.setMainCompleterId(awardApplyDto.getMainCompleterId());
        srmAwardApply.setNote(awardApplyDto.getNote());
        srmAwardApply.setClassCode(awardApplyDto.getClassCode());
        srmAwardApply.setDiscipline(awardApplyDto.getDiscipline());
        srmAwardApply.setRewardType(awardApplyDto.getRewardType());
        srmAwardApply.setAwardLevel(awardApplyDto.getAwardLevel());
        srmAwardApply.setYear(awardApplyDto.getYear());
        if(awardApplyDto.getRowId()==null){
            srmAwardApply.setCreateTime(LocalDateTime.now());
            srmAwardApply.setCreatorCode(userCode);
            srmAwardApply.setCreatorId(String.valueOf(srmUserRowId));
        }

        Long RowId=null;
        try{
            super.saveOrUpdate(srmAwardApply);
            RowId=srmAwardApply.getId();
            // 下面处理作者，以及处理主表第一作者等等
            List<AwardApplyAuthorDto> awardApplyAuthorDtoList=awardApplyMainDto.getAwardApplyAuthorDtoList();
            List<SrmAwardApplyAuthor> srmAwardApplyAuthors=new ArrayList<>();
            for(AwardApplyAuthorDto awardApplyAuthorDto :awardApplyAuthorDtoList){
                SrmAwardApplyAuthor srmAwardApplyAuthor=new SrmAwardApplyAuthor();
                srmAwardApplyAuthor.setAwardApplyId(RowId);
                srmAwardApplyAuthor.setId(awardApplyAuthorDto.getRowId());
                srmAwardApplyAuthor.setAuthorId(awardApplyAuthorDto.getAuthorId());
                srmAwardApplyAuthor.setAuthorType(awardApplyAuthorDto.getAuthorType());
                srmAwardApplyAuthor.setTitle(awardApplyAuthorDto.getTitle());
                srmAwardApplyAuthor.setEduDegree(awardApplyAuthorDto.getEduDegree());
                srmAwardApplyAuthor.setEduLevel(awardApplyAuthorDto.getEduLevel());
                srmAwardApplyAuthor.setNote(awardApplyAuthorDto.getNote());
                srmAwardApplyAuthor.setWorkRatio(awardApplyAuthorDto.getWorkRatio());
                srmAwardApplyAuthor.setAuthorRanking(awardApplyAuthorDto.getAuthorRanking());
                srmAwardApplyAuthor.setSex(awardApplyAuthorDto.getSex());
                srmAwardApplyAuthors.add(srmAwardApplyAuthor);

            }
            srmAwardApplyAuthorService.saveOrUpdateBatch(srmAwardApplyAuthors);

        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
        return RowId;
    }

    @Override
    public IPage<AwardApplyVo> listAwardApply(AwardApplyDto awardApplyDto) {
        String userCode=awardApplyDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        awardApplyDto.setUserId(srmUserRowId);
        Page<AwardApplyVo> page = new Page<>(awardApplyDto.getPage(), awardApplyDto.getRows());
        IPage<AwardApplyVo> res= srmAwardApplyMapper.listAwardApply(page, awardApplyDto);
        List<AwardApplyVo> records=res.getRecords();
        List<AwardApplyVo> newRecords=new ArrayList<>();
        for(AwardApplyVo awardApplyVo : records){
            AwardApplyVo newRecord=new AwardApplyVo();
            newRecord=awardApplyVo;
            Long rowId=awardApplyVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc(this.awardApplySysNo,rowId,null);
            newRecord.setCheckList(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }

    @Override
    @Transactional
    public void deleteAwardApply(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                //System.out.println(RowId);
                srmAwardApplyAuthorService.deleteAuthorByApplyId(RowId);
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
        Boolean allowSumbit=srmUploadInfoService.getFileNessary(String.valueOf(rowId),this.awardApplySysNo);
        if(!allowSumbit){
            throw new ErrorException("-200","请上传必要的附件！");
        }
        HosUser hosUser = SecurityUtils.getLoginUser();
        String userCode = hosUser.getAccountCode();
        try {
            Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
            AwardApplyVo awardApplyVo=this.getDetail(String.valueOf(rowId));
            Integer dataStatus=awardApplyVo.getDataStatus();
            if(dataStatus==null||dataStatus==1){
                throw new ErrorException("-200","已提交");
            }
            srmAwardApplyMapper.updateStatus(rowId,1,"1",null,LocalDateTime.now(),String.valueOf(srmUserRowId));
            srmEafRecService.generateRec(String.valueOf(rowId),this.awardApplySysNo,userCode,null);

        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
    }

    @Override
    @Transactional
    public void audit(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        Long srmUserRowId= srmUserService.getUserIdByAccount(null);
        String sysNo=this.awardApplySysNo;
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
                srmAwardApplyMapper.updateStatus(rowId,null,resultId,null,null,null);
                srmEafRecService.genAudit(rowId,sysNo,srmUserRowId,resultId,view,null);
            }
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
    }

    @Override
    public IPage<AwardApplyVo> listAuditAwardApply(AwardApplyDto awardApplyDto) {
        Page<AwardApplyVo> page = new Page<>(awardApplyDto.getPage(), awardApplyDto.getRows());
        String userCode=awardApplyDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        awardApplyDto.setUserId(srmUserRowId);
        IPage<AwardApplyVo> res= srmAwardApplyMapper.listAuditAwardApply(page, awardApplyDto);
        List<AwardApplyVo> records=res.getRecords();
        List<AwardApplyVo> newRecords=new ArrayList<>();
        for(AwardApplyVo awardApplyVo : records){
            AwardApplyVo newRecord=new AwardApplyVo();
            newRecord=awardApplyVo;
            Long rowId=awardApplyVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc(this.awardApplySysNo,rowId,null);
            newRecord.setCheckList(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }

    @Override
    public IPage<PaperSubmissionExpertAuditVo> listExpertAuditAwardApply(PaperSubmissionExpertAuditDto paperSubmissionExpertAuditDto) {
        Page<PaperSubmissionExpertAuditVo> page = new Page<>(paperSubmissionExpertAuditDto.getPage(), paperSubmissionExpertAuditDto.getRows());
        String userCode=paperSubmissionExpertAuditDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        paperSubmissionExpertAuditDto.setUserId(srmUserRowId);
        paperSubmissionExpertAuditDto.setSysNo(this.awardApplySysNo);
        System.out.println(paperSubmissionExpertAuditDto);
        IPage<PaperSubmissionExpertAuditVo> res= srmAwardApplyMapper.listExpertAuditAwardApply(page, paperSubmissionExpertAuditDto);
        return res;
    }
}
