package com.mediway.hos.srm.business.center.serviceimpl.paper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mediway.hos.app.core.util.SecurityUtils;
import com.mediway.hos.security.core.userdetails.HosUser;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.paper.*;
import com.mediway.hos.srm.business.center.model.entity.paper.SrmPaper;
import com.mediway.hos.srm.business.center.model.entity.paper.SrmPaperAuthor;
import com.mediway.hos.srm.business.center.model.entity.paper.SrmPaperEmbody;
import com.mediway.hos.srm.business.center.model.entity.paper.SrmPaperReship;
import com.mediway.hos.srm.business.center.model.entity.user.SrmUser;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperSubmissionExpertAuditVo;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperVo;
import com.mediway.hos.srm.business.center.service.approvalProcess.SrmEafRecService;
import com.mediway.hos.srm.business.center.service.baseData.SrmUploadInfoService;
import com.mediway.hos.srm.business.center.service.paper.SrmPaperAuthorService;
import com.mediway.hos.srm.business.center.service.paper.SrmPaperEmbodyService;
import com.mediway.hos.srm.business.center.service.paper.SrmPaperReshipService;
import com.mediway.hos.srm.business.center.service.paper.SrmPaperService;
import com.mediway.hos.srm.business.center.service.user.SrmUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.mapper.user.SrmUserMapper;

import com.mediway.hos.srm.business.center.mapper.paper.SrmPaperMapper;

import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 论文登记信息表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-08-23
 */
@Service
public class SrmPaperServiceImpl extends BaseServiceImpl<SrmPaperMapper, SrmPaper> implements SrmPaperService {
    private final String paperSysNo="P002";
    @Autowired
    private SrmPaperMapper srmPaperMapper;
    @Autowired
    private SrmPaperAuthorService srmPaperAuthorService;
    @Autowired
    private SrmEafRecService srmEafRecService;
    @Autowired
    private SrmUserService srmUserService;
    @Autowired
    private SrmUserMapper srmUserMapper;
    @Autowired
    private SrmUploadInfoService srmUploadInfoService;
    @Autowired
    private SrmPaperEmbodyService srmPaperEmbodyService;
    @Autowired
    private SrmPaperReshipService srmPaperReshipService;
    @Override
    public PaperVo getDetail(String rowId) {
        return srmPaperMapper.getDetail(rowId);
    }

    @Override
    @Transactional
    public Long savePaper(PaperMainDto paperMainDto) {
        PaperDto paperDto=paperMainDto.getPaperDto();
        String userCode=paperDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(null);

        SrmPaper srmPaper=new SrmPaper();
        srmPaper.setId(paperDto.getRowId());
        srmPaper.setSysNo(this.paperSysNo);
        srmPaper.setAppPaperId(paperDto.getAppPaperId());
        String title=paperDto.getTitle();
        if(title==null||title.isEmpty()){
            throw new ErrorException("-200","论文题目不能为空");
        }
        srmPaper.setTitle(title);
        srmPaper.setThesisType(paperDto.getThesisType());
        srmPaper.setPubYear(paperDto.getPubYear());
        srmPaper.setPeriod(paperDto.getPeriod());
        srmPaper.setJournalIf(paperDto.getJournalIf());
        srmPaper.setRoll(paperDto.getRoll());
        srmPaper.setOurUnitRanking(paperDto.getOurUnitRanking());
        srmPaper.setStartPage(paperDto.getStartPage());
        srmPaper.setEndPage(paperDto.getEndPage());
        srmPaper.setClassCode(paperDto.getClassCode());
        srmPaper.setDeptId(paperDto.getDeptId());
        srmPaper.setIsCorrAuthorOur(paperDto.getIsCorrAuthorOur());
        srmPaper.setIsNursing(paperDto.getIsNursing());
        //System.out.println(paperDto.getPublishDate());
        srmPaper.setPublishDate(paperDto.getPublishDate());
        srmPaper.setIsManaging(paperDto.getIsManaging());
        srmPaper.setSubCopies(paperDto.getSubCopies());
        srmPaper.setJournal(paperDto.getJournal());
        srmPaper.setIsReim(paperDto.getIsReim());
        srmPaper.setJournalType(paperDto.getJournalType());
        srmPaper.setPageSpaceType(paperDto.getPageSpaceType());
        srmPaper.setDiscipline(paperDto.getDiscipline());
        srmPaper.setDiscipline2(paperDto.getDiscipline2());
        srmPaper.setCurrency(paperDto.getCurrency());
        srmPaper.setDiscipline3(paperDto.getDiscipline3());
        srmPaper.setProjAuthor(paperDto.getProjAuthor());
        srmPaper.setReimWay(paperDto.getReimWay());
        srmPaper.setProjSourceCode(paperDto.getProjSourceCode());
        srmPaper.setPageCharge(paperDto.getPageCharge());
        srmPaper.setReimFeeAmt(paperDto.getReimFeeAmt());
        srmPaper.setAwardeeType(paperDto.getAwardeeType());
        srmPaper.setAwardeeAccount(paperDto.getAwardeeAccount());
        srmPaper.setAwardeeIdNo(paperDto.getAwardeeIdNo());
        srmPaper.setAwardeeBank(paperDto.getAwardeeBank());
        srmPaper.setAwardeeBankAccount(paperDto.getAwardeeBankAccount());
        srmPaper.setAwardeeTel(paperDto.getAwardeeTel());
        srmPaper.setRewardAmt(paperDto.getRewardAmt());
        QueryWrapper<SrmPaper> srmPaperQueryWrapper=new QueryWrapper<>();
        srmPaperQueryWrapper.eq("title",title);
        List<SrmPaper> srmPapers=srmPaperMapper.selectList(srmPaperQueryWrapper);

        if(paperDto.getRowId()==null){
            if(!srmPapers.isEmpty()){
                throw new ErrorException("-200","论文题目重复");
            }
            Long number=this.getCurrNumber();
            srmPaper.setSerialNo(String.valueOf(number));
            srmPaper.setCreator(String.valueOf(srmUserRowId));
            srmPaper.setCreateTime(LocalDateTime.now());
            //srmPaper.setSubUserId(String.valueOf(srmUserRowId));
            //srmPaper.setSubDate(LocalDateTime.now());
        }else{
            if(!srmPapers.isEmpty()){
                for(SrmPaper srmPaper1 :srmPapers){
                    Long repeatRowId=srmPaper1.getId();
                    if(!Objects.equals(repeatRowId, paperDto.getRowId())){
                        throw new ErrorException("-200","论文题目重复");
                    }
                }

            }
        }
        Long RowId=null;
        try{
            super.saveOrUpdate(srmPaper);
            RowId=srmPaper.getId();
            // 下面处理作者，以及处理主表第一作者等等
            List<PaperAuthorDto> paperAuthorDtos=paperMainDto.getPaperAuthorDtos();
            List<SrmPaperAuthor> srmPaperAuthors=new ArrayList<>();
            for(PaperAuthorDto paperAuthorDto :paperAuthorDtos){
                SrmPaperAuthor srmPaperAuthor=new SrmPaperAuthor();
                String authorId=paperAuthorDto.getAuthor();
                srmPaperAuthor.setAuthor(paperAuthorDto.getAuthor());
                QueryWrapper<SrmUser> srmUserQueryWrapper=new QueryWrapper<>();
                srmUserQueryWrapper.eq("id",Long.valueOf(authorId));
                SrmUser srmUser=srmUserMapper.selectOne(srmUserQueryWrapper);
                srmPaperAuthor.setId(paperAuthorDto.getRowId());
                srmPaperAuthor.setPaperId(RowId);
                srmPaperAuthor.setAuthorName(paperAuthorDto.getAuthorName());
                //srmPaperAuthor.setAuthorAccount("");
                srmPaperAuthor.setSex(paperAuthorDto.getSex());
                srmPaperAuthor.setAuthorDeptId(srmUser.getDept());
                srmPaperAuthor.setAuthorType(paperAuthorDto.getAuthorType());
                srmPaperAuthor.setRanking(paperAuthorDto.getRanking());
                srmPaperAuthor.setTitle(paperAuthorDto.getTitle());
                srmPaperAuthor.setEduDegree(paperAuthorDto.getEduDegree());
                srmPaperAuthor.setIsCorrAuthor(paperAuthorDto.getIsCorrAuthor());
                srmPaperAuthor.setIsTiedCorrAuthor(paperAuthorDto.getIsTiedCorrAuthor());
                srmPaperAuthors.add(srmPaperAuthor);
            }
            srmPaperAuthorService.saveOrUpdateBatch(srmPaperAuthors);
            this.updateAuthor(RowId);

            // 下面保存收录与转载
            List<PaperReshipDto> paperReshipDtos=paperMainDto.getPaperReshipDtos();
            System.out.println(paperReshipDtos);

            if(paperReshipDtos!=null) {
                List<SrmPaperReship> srmPaperReships=new ArrayList<>();
                for (PaperReshipDto paperReshipDto : paperReshipDtos) {
                    SrmPaperReship srmPaperReship = new SrmPaperReship();
                    srmPaperReship.setId(paperReshipDto.getRowId());
                    srmPaperReship.setPaperId(RowId);
                    srmPaperReship.setNote(paperReshipDto.getNote());
                    srmPaperReship.setReshipId(paperReshipDto.getReshipId());
                    srmPaperReship.setReshipType(paperReshipDto.getReshipType());
                    srmPaperReship.setReshipDate(paperReshipDto.getReshipDate());
                    srmPaperReships.add(srmPaperReship);
                }
                srmPaperReshipService.saveOrUpdateBatch(srmPaperReships);
            }
            List<PaperEmbodyDto> paperEmbodyDtos=paperMainDto.getPaperEmbodyDtos();
            if(paperEmbodyDtos!=null&&paperEmbodyDtos.size()>0) {
                System.out.println("paperEmbodyDtos="+paperEmbodyDtos);
                List<SrmPaperEmbody> srmPaperEmbodies = new ArrayList<>();
                for (PaperEmbodyDto paperEmbodyDto : paperEmbodyDtos) {
                    SrmPaperEmbody srmPaperEmbody = new SrmPaperEmbody();
                    srmPaperEmbody.setPaperId(RowId);
                    srmPaperEmbody.setId(paperEmbodyDto.getRowId());
                    srmPaperEmbody.setEmbodyId(paperEmbodyDto.getEmbodyId());
                    srmPaperEmbody.setEmbodyDate(paperEmbodyDto.getEmbodyDate());
                    srmPaperEmbody.setImpactFactor(paperEmbodyDto.getImpactFactor());
                    srmPaperEmbody.setNote(paperEmbodyDto.getNote());
                    srmPaperEmbodies.add(srmPaperEmbody);
                }
                srmPaperEmbodyService.saveOrUpdateBatch(srmPaperEmbodies);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new ErrorException("-200",e.getMessage());
        }
        return RowId;
    }
    private synchronized Long getCurrNumber(){
        QueryWrapper<SrmPaper> srmPaperQueryWrapper=new QueryWrapper<>();
        Long number=srmPaperMapper.selectCount(srmPaperQueryWrapper);
        return number+1L;
    }
    public void updateAuthor(Long rowId){
        SrmUser userVo=srmPaperMapper.getFirstAuthor(String.valueOf(rowId),null);
        SrmUser userVo1=srmPaperMapper.getFirstAuthor(String.valueOf(rowId),"1");
        SrmPaper srmPaper=new SrmPaper();
        srmPaper.setId(rowId);
        if(userVo!=null){
            srmPaper.setFirstAuthorId(String.valueOf(userVo.getId()));
            srmPaper.setFirstAuthorName(userVo.getName());
            srmPaper.setFirstAuthorDeptId(userVo.getDept());
        }
        if(userVo1!=null){
            srmPaper.setCorrAuthorId(String.valueOf(userVo1.getId()));
            srmPaper.setCorrAuthorName(userVo1.getName());
            srmPaper.setCorrAuthorDeptId(userVo1.getDept());
        }

        super.saveOrUpdate(srmPaper);
    }
    @Override
    public IPage<PaperVo> listPaper(PaperDto paperDto) {
        System.out.println(paperDto);
        String userCode=paperDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        paperDto.setUserId(srmUserRowId);
        Page<PaperVo> page = new Page<>(paperDto.getPage(), paperDto.getRows());
        IPage<PaperVo> res= srmPaperMapper.listPaper(page, paperDto);
        List<PaperVo> records=res.getRecords();
        List<PaperVo> newRecords=new ArrayList<>();
        for(PaperVo paperVo : records){
            PaperVo newRecord=new PaperVo();
            newRecord=paperVo;
            Long rowId=paperVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc(this.paperSysNo,rowId,null);
            newRecord.setCheckList(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }

    @Override
    @Transactional
    public void deletePaper(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                //System.out.println(RowId);
                srmPaperAuthorService.deleteAuthorByPaper(RowId);
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
        //提交前先判断是否已经提交
        //提交前判断是否上传必要附件（后置）
        Long rowId=baseDto.getId();
        Boolean allowSumbit=srmUploadInfoService.getFileNessary(String.valueOf(rowId),this.paperSysNo);
        if(!allowSumbit){
            throw new ErrorException("-200","请上传必要的附件！");
        }
        //String userCode=baseDto.getUserCode();
        HosUser hosUser = SecurityUtils.getLoginUser();
        String userCode = hosUser.getAccountCode();
        try {
            Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
            PaperVo paperVo=this.getDetail(String.valueOf(rowId));
            Integer dataStatus=paperVo.getDataStatus();
            if(dataStatus==null||dataStatus==1){
                throw new ErrorException("-200","已提交");
            }
            srmPaperMapper.updateStatus(rowId,1,"1",null,LocalDateTime.now(),String.valueOf(srmUserRowId));
            srmEafRecService.generateRec(String.valueOf(rowId),this.paperSysNo,userCode,null);

        }catch (Exception e){
            throw new ErrorException("-200","提交失败");
        }
    }
    @Transactional
    @Override
    public void audit(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();

        Long srmUserRowId= srmUserService.getUserIdByAccount(null);

        String sysNo=this.paperSysNo;
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
                srmPaperMapper.updateStatus(rowId,null,resultId,null,null,null);
                srmEafRecService.genAudit(rowId,sysNo,srmUserRowId,resultId,view,null);
            }
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }

    }

    @Override
    public IPage<PaperVo> listAuditPaper(PaperDto paperDto) {
        Page<PaperVo> page = new Page<>(paperDto.getPage(), paperDto.getRows());
        String userCode=paperDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        paperDto.setUserId(srmUserRowId);
        System.out.println(paperDto);
        IPage<PaperVo> res= srmPaperMapper.listAuditPaper(page, paperDto);
        List<PaperVo> records=res.getRecords();
        List<PaperVo> newRecords=new ArrayList<>();
        for(PaperVo paperVo : records){
            PaperVo newRecord=new PaperVo();
            newRecord=paperVo;
            Long rowId=paperVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc(this.paperSysNo,rowId,null);
            newRecord.setCheckList(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }

    @Override
    public List<CombVo> getPaperApply(String userCode) {
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        return srmPaperMapper.getPaperApply(String.valueOf(srmUserRowId));
    }

    @Override
    public IPage<PaperSubmissionExpertAuditVo> listExpertAuditPaper(PaperSubmissionExpertAuditDto paperSubmissionExpertAuditDto) {
        Page<PaperSubmissionExpertAuditVo> page = new Page<>(paperSubmissionExpertAuditDto.getPage(), paperSubmissionExpertAuditDto.getRows());
        String userCode=paperSubmissionExpertAuditDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        paperSubmissionExpertAuditDto.setUserId(srmUserRowId);
        paperSubmissionExpertAuditDto.setSysNo(this.paperSysNo);
        IPage<PaperSubmissionExpertAuditVo> res= srmPaperMapper.listExpertAuditPaper(page, paperSubmissionExpertAuditDto);
        return res;
    }
}
