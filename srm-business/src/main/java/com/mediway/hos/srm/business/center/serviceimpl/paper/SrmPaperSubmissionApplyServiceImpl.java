package com.mediway.hos.srm.business.center.serviceimpl.paper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mediway.hos.app.core.util.SecurityUtils;
import com.mediway.hos.security.core.userdetails.HosUser;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperSubmissionApplyVo;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperSubmissionExpertAuditVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperSubmissionApplyDto;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperSubmissionExpertAuditDto;
import com.mediway.hos.srm.business.center.model.entity.approvalProcess.SrmEafDetail;
import com.mediway.hos.srm.business.center.model.entity.paper.SrmPaperSubmissionApply;
import com.mediway.hos.srm.business.center.mapper.paper.SrmPaperSubmissionApplyMapper;

import com.mediway.hos.srm.business.center.service.approvalProcess.SrmEafRecService;
import com.mediway.hos.srm.business.center.service.paper.SrmPaperSubmissionApplyService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.mediway.hos.srm.business.center.service.baseData.SrmUploadInfoService;
import com.mediway.hos.srm.business.center.service.user.SrmUserService;
import com.mediway.hos.srm.business.center.utils.DateTransform;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 论文投稿 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmPaperSubmissionApplyServiceImpl extends BaseServiceImpl<SrmPaperSubmissionApplyMapper, SrmPaperSubmissionApply> implements SrmPaperSubmissionApplyService {
    private final String paperSubmissionApplySysNo="P001";
    @Autowired
    private SrmPaperSubmissionApplyMapper srmPaperSubmissionApplyMapper;
    @Autowired
    private SrmEafRecService srmEafRecService;
    @Autowired
    private SrmUserService srmUserService;
    @Autowired
    private SrmUploadInfoService srmUploadInfoService;
    @Override
    @Transactional
    public Long savePaperSubmissionApply(PaperSubmissionApplyDto paperSubmissionApplyDto) {
        SrmPaperSubmissionApply srmPaperSubmissionApply=new SrmPaperSubmissionApply();
        String userCode=paperSubmissionApplyDto.getUserCode();
         Long srmUserRowId= srmUserService.getUserIdByAccount(null);

        String title=paperSubmissionApplyDto.getTitle();
        if(title==null||title.isEmpty()){
            throw new ErrorException("-200","论文题目不能为空");
        }
        srmPaperSubmissionApply.setId(paperSubmissionApplyDto.getRowId());
        srmPaperSubmissionApply.setTitle(title);
        srmPaperSubmissionApply.setJournal(paperSubmissionApplyDto.getJournal());
        srmPaperSubmissionApply.setRecordType(paperSubmissionApplyDto.getJournalType());
        srmPaperSubmissionApply.setFirstAuthorId(paperSubmissionApplyDto.getFirstAuthor());
        srmPaperSubmissionApply.setFirstAuthorType(paperSubmissionApplyDto.getFirstAuthorType());
        srmPaperSubmissionApply.setFirstAuthorTitle(paperSubmissionApplyDto.getFirstAuthorPosition());
        srmPaperSubmissionApply.setFirstAuthorDeptId(paperSubmissionApplyDto.getFirstAuthorDept());
        srmPaperSubmissionApply.setCorrAuthorId(paperSubmissionApplyDto.getCorrAuthor());
        srmPaperSubmissionApply.setCorrAuthorType(paperSubmissionApplyDto.getCorrAuthorType());
        srmPaperSubmissionApply.setCorrAuthorTitle(paperSubmissionApplyDto.getCorrAuthorPosition());
        srmPaperSubmissionApply.setCorrAuthorDeptId(paperSubmissionApplyDto.getCorrAuthorDept());
        srmPaperSubmissionApply.setLanguage(paperSubmissionApplyDto.getLanguage());
        srmPaperSubmissionApply.setIsReimburse(paperSubmissionApplyDto.getJackFreeFlag());
        srmPaperSubmissionApply.setReimburseWay(paperSubmissionApplyDto.getReimburseWay());
        srmPaperSubmissionApply.setProjectCode(paperSubmissionApplyDto.getProjNo());
        srmPaperSubmissionApply.setNote(paperSubmissionApplyDto.getRemark());
        srmPaperSubmissionApply.setProjAuthor(paperSubmissionApplyDto.getLeadUser());
        srmPaperSubmissionApply.setAwardeeType(paperSubmissionApplyDto.getEncouragetype());
        srmPaperSubmissionApply.setAwardeeAccount(paperSubmissionApplyDto.getPersonCode());
        srmPaperSubmissionApply.setAwardeeBank(paperSubmissionApplyDto.getPersonBankNo());
        srmPaperSubmissionApply.setAwardeeBankAccount(paperSubmissionApplyDto.getPersonBankAccount());
        srmPaperSubmissionApply.setAwardeeIdNo(paperSubmissionApplyDto.getPersonIdentify());
        srmPaperSubmissionApply.setAwardeeContactTel(paperSubmissionApplyDto.getPersonTel());

        QueryWrapper<SrmPaperSubmissionApply> srmPaperSubmissionApplyQueryWrapper=new QueryWrapper<>();
        srmPaperSubmissionApplyQueryWrapper.eq("title",title);
        List<SrmPaperSubmissionApply> srmPaperSubmissionApplies=srmPaperSubmissionApplyMapper.selectList(srmPaperSubmissionApplyQueryWrapper);

        srmPaperSubmissionApply.setSysNo(this.paperSubmissionApplySysNo);
        if(paperSubmissionApplyDto.getRowId()==null){
            // 判断论文是否重复
            if(!srmPaperSubmissionApplies.isEmpty()){
                throw new ErrorException("-200","论文题目重复");
            }
            srmPaperSubmissionApply.setCreateTime(LocalDateTime.now());
            srmPaperSubmissionApply.setCreator(String.valueOf(srmUserRowId));

            Long number=this.getCurrNumber();
            srmPaperSubmissionApply.setSerialNo(String.valueOf(number));
        }else{
            if(!srmPaperSubmissionApplies.isEmpty()){
                for(SrmPaperSubmissionApply srmPaperSubmissionApply1 :srmPaperSubmissionApplies){
                    Long repeatRowId=srmPaperSubmissionApply1.getId();
                    if(!Objects.equals(repeatRowId, paperSubmissionApplyDto.getRowId())){
                        throw new ErrorException("-200","论文题目重复");
                    }
                }

            }
        }
        srmPaperSubmissionApply.setOperateTime(LocalDateTime.now());

        String sendDate=paperSubmissionApplyDto.getSendDate();

        Long rowId=null;
        try{
            LocalDateTime publishTime=DateTransform.getLocalDateTime(sendDate);
            srmPaperSubmissionApply.setContributeDate(publishTime);

            super.saveOrUpdate(srmPaperSubmissionApply);
            rowId=srmPaperSubmissionApply.getId();

        }catch (Exception exception){
            throw new ErrorException("-200",exception.getMessage());
        }
        return rowId;
    }

    private synchronized Long getCurrNumber(){
        QueryWrapper<SrmPaperSubmissionApply> srmPaperSubmissionApplyQueryWrapper=new QueryWrapper<>();
        Long number=srmPaperSubmissionApplyMapper.selectCount(srmPaperSubmissionApplyQueryWrapper);
        return number+1L;
    }

    @Override
    public IPage<PaperSubmissionApplyVo> listPaperSubmissionApply(PaperSubmissionApplyDto paperSubmissionApplyDto) {
        String userCode=paperSubmissionApplyDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        paperSubmissionApplyDto.setUserId(srmUserRowId);
        System.out.println(paperSubmissionApplyDto);
        Page<PaperSubmissionApplyVo> page = new Page<>(paperSubmissionApplyDto.getPage(), paperSubmissionApplyDto.getRows());
        IPage<PaperSubmissionApplyVo> res= srmPaperSubmissionApplyMapper.listPaperSubmissionApply(page, paperSubmissionApplyDto);
        List<PaperSubmissionApplyVo> records=res.getRecords();
        List<PaperSubmissionApplyVo> newRecords=new ArrayList<>();
        for(PaperSubmissionApplyVo paperSubmissionApplyVo : records){
            PaperSubmissionApplyVo newRecord=new PaperSubmissionApplyVo();
            newRecord=paperSubmissionApplyVo;
            Long rowId=paperSubmissionApplyVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc(this.paperSubmissionApplySysNo,rowId,null);
            newRecord.setChkResultlist(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }

    @Override
    public PaperSubmissionApplyVo getDetail(Long rowId) {
        return srmPaperSubmissionApplyMapper.getDetail(rowId);
    }

    @Override
    @Transactional
    public void subMit(BaseDto baseDto) {
        System.out.println(baseDto);
        //提交前先判断是否已经提交
        //提交前判断是否上传必要附件（后置）
        Long rowId=baseDto.getId();
        Boolean allowSumbit=srmUploadInfoService.getFileNessary(String.valueOf(rowId),this.paperSubmissionApplySysNo);
        if(!allowSumbit){
            throw new ErrorException("-200","请上传必要的附件！");
        }

        HosUser hosUser = SecurityUtils.getLoginUser();
        String userCode = hosUser.getAccountCode();

        try {
            Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
            PaperSubmissionApplyVo paperSubmissionApplyVo=this.getDetail(rowId);
            Integer dataStatus=paperSubmissionApplyVo.getDataStatus();
            if(dataStatus==1){
                throw new ErrorException("-200","已提交");
            }
            srmPaperSubmissionApplyMapper.updateStatus(rowId,1,null,null,LocalDateTime.now(),String.valueOf(srmUserRowId));
            //System.out.println(rowId+","+userCode);
            srmEafRecService.generateRec(String.valueOf(rowId),this.paperSubmissionApplySysNo,userCode,null);

        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
    }

    @Override
    @Transactional
    public void delete(BaseDto baseDto) {
        Long rowId=baseDto.getId();
        try{
            PaperSubmissionApplyVo paperSubmissionApplyVo=this.getDetail(rowId);
            Integer dataStatus=paperSubmissionApplyVo.getDataStatus();
            if(dataStatus==1){
                throw new ErrorException("-200","已提交,不允许删除");
            }

            super.deleteById(rowId);
        }catch (Exception exception){
            throw  new ErrorException("-200",exception.getMessage());
        }
    }

    @Override
    public IPage<PaperSubmissionApplyVo> listAuditPaperSubmissionApply(PaperSubmissionApplyDto paperSubmissionApplyDto) {
        Page<PaperSubmissionApplyVo> page = new Page<>(paperSubmissionApplyDto.getPage(), paperSubmissionApplyDto.getRows());
        String userCode=paperSubmissionApplyDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        paperSubmissionApplyDto.setUserId(srmUserRowId);
        System.out.println(paperSubmissionApplyDto);
        IPage<PaperSubmissionApplyVo> res= srmPaperSubmissionApplyMapper.listAuditPaperSubmissionApply(page, paperSubmissionApplyDto);
        List<PaperSubmissionApplyVo> records=res.getRecords();
        List<PaperSubmissionApplyVo> newRecords=new ArrayList<>();
        for(PaperSubmissionApplyVo paperSubmissionApplyVo : records){
            PaperSubmissionApplyVo newRecord=new PaperSubmissionApplyVo();
            newRecord=paperSubmissionApplyVo;
            Long rowId=paperSubmissionApplyVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc(this.paperSubmissionApplySysNo,rowId,null);
            newRecord.setChkResultlist(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;

    }

    @Override
    @Transactional
    public void audit(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();

        Long srmUserRowId= srmUserService.getUserIdByAccount(null);
        String sysNo=this.paperSubmissionApplySysNo;
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
                SrmEafDetail srmEafDetail = srmEafRecService.getCheckStatus(sysNo,String.valueOf(rowId));
                String realAuditStatus= srmEafDetail.getAuditPassStatus();
                srmPaperSubmissionApplyMapper.updateStatus(rowId,null,realAuditStatus,null,null,null);
                srmEafRecService.genAudit(rowId,sysNo,srmUserRowId,resultId,view,null);
            }
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
    }

    @Override
    public IPage<PaperSubmissionExpertAuditVo> listExpertAuditPaperSubmission(PaperSubmissionExpertAuditDto paperSubmissionExpertAuditDto) {
        Page<PaperSubmissionExpertAuditVo> page = new Page<>(paperSubmissionExpertAuditDto.getPage(), paperSubmissionExpertAuditDto.getRows());
        String userCode=paperSubmissionExpertAuditDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        paperSubmissionExpertAuditDto.setUserId(srmUserRowId);
        paperSubmissionExpertAuditDto.setSysNo(this.paperSubmissionApplySysNo);
        IPage<PaperSubmissionExpertAuditVo> res= srmPaperSubmissionApplyMapper.listExpertAuditPaperSubmission(page, paperSubmissionExpertAuditDto);
        return res;
    }
}
