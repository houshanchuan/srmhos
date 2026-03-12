package com.mediway.hos.srm.business.center.serviceimpl.project;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mediway.hos.app.core.util.SecurityUtils;
import com.mediway.hos.security.core.userdetails.HosUser;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectCooperativesDto;
import com.mediway.hos.srm.business.center.model.dto.project.ProjectsInfoDto;
import com.mediway.hos.srm.business.center.model.dto.project.ProjectsInfoMemberDto;
import com.mediway.hos.srm.business.center.model.dto.project.ProjectsInfoVerticalDto;
import com.mediway.hos.srm.business.center.model.entity.approvalProcess.SrmEafRec;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjectCooperatives;
import com.mediway.hos.srm.business.center.service.approvalProcess.SrmEafRecService;
import com.mediway.hos.srm.business.center.service.baseData.SrmBusinessnoService;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjectCooperativesService;
import com.mediway.hos.srm.business.center.service.baseData.SrmUploadInfoService;
import com.mediway.hos.srm.business.center.service.project.SrmProjectsInfoMemberService;
import com.mediway.hos.srm.business.center.service.project.SrmProjectsInfoService;
import com.mediway.hos.srm.business.center.service.user.SrmUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;


import com.mediway.hos.srm.business.center.model.entity.project.SrmProjectsInfo;
import com.mediway.hos.srm.business.center.mapper.project.SrmProjectsInfoMapper;

import com.mediway.hos.srm.business.center.model.entity.project.SrmProjectsInfoMember;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectsInfoVo;


import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.mediway.hos.srm.business.center.utils.DateTransform;
import com.mediway.hos.srm.business.center.utils.LockUtil;
import com.mediway.hos.srm.business.center.utils.LockUtilFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课题信息表(项目) 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-23
 */
@Service
public class SrmProjectsInfoServiceImpl extends BaseServiceImpl<SrmProjectsInfoMapper, SrmProjectsInfo> implements SrmProjectsInfoService {
    private final String verticalProjectSysNo="P007";
    private final String hroProjectSysNo="P052";
    private final String contractProjectSysNo="P055";
    @Autowired
    private SrmProjectsInfoMapper srmProjectsInfoMapper;
    @Autowired
    private SrmUserService srmUserService;
    @Autowired
    private SrmProjectsInfoMemberService srmProjectsInfoMemberService;
    @Autowired
    private SrmUploadInfoService srmUploadInfoService;
    @Autowired
    private SrmEafRecService srmEafRecService;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    @Autowired
    private SrmProjectCooperativesService srmProjectCooperativesService;
    private final LockUtil lockUtil= LockUtilFactory.getLockUtil("Project", 1000L, 24 * 60 * 60 * 1000L);

    @Override
    @Transactional
    public Long saveVerticalProjectsInfo(ProjectsInfoVerticalDto projectsInfoVerticalDto) {
        ProjectsInfoDto projectsInfoDto=projectsInfoVerticalDto.getProjectsInfoDto();

        SrmProjectsInfo srmProjectsInfo=new SrmProjectsInfo();
        srmProjectsInfo.setId(projectsInfoDto.getRowId());
        srmProjectsInfo.setSysNo(this.verticalProjectSysNo);
        srmProjectsInfo.setName(projectsInfoDto.getName());

        srmProjectsInfo.setClassCode(projectsInfoDto.getClassCode());
        srmProjectsInfo.setProjClass(projectsInfoDto.getProjClass());
        srmProjectsInfo.setProjLevel(projectsInfoDto.getProjLevel());
        srmProjectsInfo.setYear(projectsInfoDto.getYear());
        srmProjectsInfo.setHead(projectsInfoDto.getHead());
        srmProjectsInfo.setHeadTypeCode(projectsInfoDto.getHeadTypeCode());
        srmProjectsInfo.setProjType(projectsInfoDto.getProjType());
        System.out.println(projectsInfoDto.getProjStatSourceCode());
        srmProjectsInfo.setProjStatSourceCode(projectsInfoDto.getProjStatSourceCode());
        srmProjectsInfo.setDeptId(projectsInfoDto.getDeptId());
        srmProjectsInfo.setSubSource(projectsInfoDto.getSubSource());
        srmProjectsInfo.setFileNumber(projectsInfoDto.getFileNumber());
        srmProjectsInfo.setStartDate(DateTransform.getLocalDateTime(projectsInfoDto.getStartDate()));
        srmProjectsInfo.setEndDate(DateTransform.getLocalDateTime(projectsInfoDto.getEndDate()));
        srmProjectsInfo.setAcceptanceDate(DateTransform.getLocalDateTime(projectsInfoDto.getAcceptanceDate()));
        srmProjectsInfo.setIssuedDate(DateTransform.getLocalDateTime(projectsInfoDto.getIssuedDate()));
        srmProjectsInfo.setAppraisalDate(DateTransform.getLocalDateTime(projectsInfoDto.getAppraisalDate()));
        srmProjectsInfo.setSpecialFunds(projectsInfoDto.getSpecialFunds());
        srmProjectsInfo.setProjectAccount(projectsInfoDto.getProjectAccount());
        srmProjectsInfo.setIsChiefScientist(projectsInfoDto.getIsChiefScientist());
        srmProjectsInfo.setTopicType(projectsInfoDto.getTopicType());
        srmProjectsInfo.setPrjFundMatched(projectsInfoDto.getPrjFundMatched());
        srmProjectsInfo.setFundAccount(projectsInfoDto.getFundAccount());
        srmProjectsInfo.setResearchType(projectsInfoDto.getResearchType());
        srmProjectsInfo.setSelfRaisedFunds(projectsInfoDto.getSelfRaisedFunds());
        srmProjectsInfo.setSelfFinancingAccount(projectsInfoDto.getSelfFinancingAccount());
        srmProjectsInfo.setDiscipline(projectsInfoDto.getDiscipline());
        srmProjectsInfo.setEnterpriseFunds(projectsInfoDto.getEnterpriseFunds());
        srmProjectsInfo.setEnterpriseAccount(projectsInfoDto.getEnterpriseAccount());
        srmProjectsInfo.setApprovalNumber(projectsInfoDto.getApprovalNumber());
        srmProjectsInfo.setProjOrgnizeUnit(projectsInfoDto.getProjOrgnizeUnit());
        srmProjectsInfo.setSurplusAccount(projectsInfoDto.getSurplusAccount());
        srmProjectsInfo.setRemark(projectsInfoDto.getRemark());
        srmProjectsInfo.setNationalEconomyIndustry(projectsInfoDto.getNationalEconomyIndustry());
        srmProjectsInfo.setProjCooperateCode(projectsInfoDto.getProjCooperateCode());
        srmProjectsInfo.setNationalEconomyIndustryMiddle(projectsInfoDto.getNationalEconomyIndustryMiddle());
        srmProjectsInfo.setSocioEconomicObjCode(projectsInfoDto.getSocioEconomicObjCode());
        srmProjectsInfo.setNationalEconomyIndustrySmall(projectsInfoDto.getNationalEconomyIndustrySmall());
        srmProjectsInfo.setProjOrgformCode(projectsInfoDto.getProjOrgformCode());
        srmProjectsInfo.setProjStatus(projectsInfoDto.getProjStatus());
        //srmProjectsInfo.setProjOrgFormCode(projectsInfoDto.g);


        srmProjectsInfo.setDataStatus(0);
        Long RowId=null;
        try{
            String userCode=projectsInfoDto.getUserCode();
            Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
            if(projectsInfoDto.getRowId()==null){
                String subNo=srmBusinessnoService.getBusinessNo(this.verticalProjectSysNo,7,"V");
                srmProjectsInfo.setSubNo(subNo);
                srmProjectsInfo.setCreator(String.valueOf(srmUserRowId));
                srmProjectsInfo.setCreateTime(LocalDateTime.now());

                //srmProjectsInfo.setSubUserId(String.valueOf(srmUserRowId));
                //srmProjectsInfo.setSubDate(LocalDateTime.now());

            }

            super.saveOrUpdate(srmProjectsInfo);
            RowId=srmProjectsInfo.getId();
            // 下面处理作者，以及处理主表第一作者等等
            List<ProjectsInfoMemberDto> projectsInfoMemberDtoList=projectsInfoVerticalDto.getProjectsInfoMemberDtoList();
            List<SrmProjectsInfoMember> srmProjectsInfoMembers=new ArrayList<>();
            for(ProjectsInfoMemberDto projectsInfoMemberDto :projectsInfoMemberDtoList){
                SrmProjectsInfoMember srmProjectsInfoMember=new SrmProjectsInfoMember();
                srmProjectsInfoMember.setMember(projectsInfoMemberDto.getMember());
                srmProjectsInfoMember.setProjId(RowId);
                srmProjectsInfoMember.setAuthorTypeCode(projectsInfoMemberDto.getAuthorTypeCode());
                srmProjectsInfoMember.setId(projectsInfoMemberDto.getRowId());
                srmProjectsInfoMember.setRanking(projectsInfoMemberDto.getRanking());
                srmProjectsInfoMember.setTitleCode(projectsInfoMemberDto.getTitleCode());
                srmProjectsInfoMember.setWorkRatio(projectsInfoMemberDto.getWorkRatio());
                srmProjectsInfoMember.setNote(projectsInfoMemberDto.getNote());
                srmProjectsInfoMember.setWorkTime(projectsInfoMemberDto.getWorkTime());
                srmProjectsInfoMembers.add(srmProjectsInfoMember);
            }
            srmProjectsInfoMemberService.saveOrUpdateBatch(srmProjectsInfoMembers);

            // 下面保存合作单位
            List<ProjectCooperativesDto> projectCooperativesDtoList=projectsInfoVerticalDto.getProjectCooperativesDtoList();
            System.out.println(projectCooperativesDtoList);
            List<SrmProjectCooperatives> srmProjectCooperativesList=new ArrayList<>();
            //srmProjectCooperativesService
            for(ProjectCooperativesDto projectCooperativesDto :projectCooperativesDtoList){
                SrmProjectCooperatives srmProjectCooperatives=new SrmProjectCooperatives();
                srmProjectCooperatives.setId(projectCooperativesDto.getRowId());
                srmProjectCooperatives.setProjId(RowId);
                srmProjectCooperatives.setCompId(projectCooperativesDto.getCompId());
                System.out.println(projectCooperativesDto.getContactName());
                srmProjectCooperatives.setContactName(projectCooperativesDto.getContactName());

                srmProjectCooperativesList.add(srmProjectCooperatives);
            }
            srmProjectCooperativesService.saveOrUpdateBatch(srmProjectCooperativesList);

        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
        return RowId;

    }

    @Override
    public ProjectsInfoVo getVerticalDetail(Long rowId) {
        return srmProjectsInfoMapper.getVerticalDetail(rowId);
    }

    @Override
    public IPage<ProjectsInfoVo> listVerticalProject(ProjectsInfoDto projectsInfoDto) {
        //System.out.println(projectsInfoDto);
        projectsInfoDto.setSysNo(this.verticalProjectSysNo);
        String userCode=projectsInfoDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        projectsInfoDto.setUserId(srmUserRowId);
        Page<ProjectsInfoVo> page = new Page<>(projectsInfoDto.getPage(), projectsInfoDto.getRows());
        IPage<ProjectsInfoVo> res= srmProjectsInfoMapper.listVerticalProject(page, projectsInfoDto);
        List<ProjectsInfoVo> records=res.getRecords();
        List<ProjectsInfoVo> newRecords=new ArrayList<>();
        for(ProjectsInfoVo InfoVo : records){
            ProjectsInfoVo newRecord=new ProjectsInfoVo();
            newRecord=InfoVo;
            Long rowId=InfoVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc(this.verticalProjectSysNo,rowId,null);
            newRecord.setChkResultList(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }

    @Override
    @Transactional
    public void deleteVerticalProjectsInfo(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                //System.out.println(RowId);
                srmProjectsInfoMemberService.deleteAuthorByParent(RowId);
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
    public void subMitVerticalProject(BaseDto baseDto) {

        //提交前先判断是否已经提交
        //提交前判断是否上传必要附件（后置）
        Long rowId=baseDto.getId();
        //lockUtil.lock(String.valueOf(rowId));
        Boolean allowSumbit=srmUploadInfoService.getFileNessary(String.valueOf(rowId),this.verticalProjectSysNo);
        if(!allowSumbit){
            throw new ErrorException("-200","请上传必要的附件！");
        }
        HosUser hosUser = SecurityUtils.getLoginUser();
        String userCode = hosUser.getAccountCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        try {
            ProjectsInfoVo detail=this.getVerticalDetail(rowId);
            Integer dataStatus=detail.getDataStatus();
            if(dataStatus==null||dataStatus==1){
                throw new ErrorException("-200","已提交");
            }
            srmProjectsInfoMapper.updateStatus(rowId,1,null,String.valueOf(srmUserRowId),LocalDateTime.now());
            srmEafRecService.generateRec(String.valueOf(rowId),this.verticalProjectSysNo,userCode,null);

        }catch (Exception e){
            throw new ErrorException("-200","提交失败");
        }finally {
            //lockUtil.unLock(String.valueOf(rowId));
        }
    }

    @Override
    @Transactional
    public void auditVerticalProject(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
       // String userCode=baseDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(null);
        String sysNo=this.verticalProjectSysNo;
        if(srmUserRowId==null){
            throw new ErrorException("-200","当前登录用户不存在!");
        }
        String view=baseDto.getView();
        String auditStatus=baseDto.getAuditStatus();
        String resultId="";

        try{
            for(Long rowId : idList){
                //SrmEafDetail srmEafDetail = srmEafRecService.getCheckStatus(sysNo,String.valueOf(rowId));
                //String auditStatus= srmEafDetail.getAuditPassStatus();
                if(auditStatus.equals("1")){
                    resultId="2";
                    srmProjectsInfoMapper.updateStatus(rowId,null,resultId,null,null);
                    srmEafRecService.genAudit(rowId,sysNo,srmUserRowId,resultId,view,null);
                }
                if(auditStatus.equals("2")){
                    resultId="3";
                    srmProjectsInfoMapper.updateStatus(rowId,0,resultId,null,null);
                    srmEafRecService.genAudit(rowId,sysNo,srmUserRowId,resultId,view,null);
                }

            }
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
    }

    @Override
    public IPage<ProjectsInfoVo> listAuditVerticalProject(ProjectsInfoDto projectsInfoDto) {
        System.out.println(projectsInfoDto);
        Page<ProjectsInfoVo> page = new Page<>(projectsInfoDto.getPage(), projectsInfoDto.getRows());
        String userCode=projectsInfoDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        projectsInfoDto.setUserId(srmUserRowId);
        IPage<ProjectsInfoVo> res= srmProjectsInfoMapper.listAuditVerticalProject(page, projectsInfoDto);
        List<ProjectsInfoVo> records=res.getRecords();
        List<ProjectsInfoVo> newRecords=new ArrayList<>();
        for(ProjectsInfoVo InfoVo : records){
            ProjectsInfoVo newRecord=new ProjectsInfoVo();
            newRecord=InfoVo;
            Long rowId=InfoVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc(this.verticalProjectSysNo,rowId,null);
            newRecord.setChkResultList(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }

    // 下面是横向项目
    @Override
    @Transactional
    public Long saveHroProjectsInfo(ProjectsInfoVerticalDto projectsInfoVerticalDto) {

        ProjectsInfoDto projectsInfoDto=projectsInfoVerticalDto.getProjectsInfoDto();
        SrmProjectsInfo srmProjectsInfo=new SrmProjectsInfo();
        srmProjectsInfo.setId(projectsInfoDto.getRowId());
        srmProjectsInfo.setSysNo(this.hroProjectSysNo);
        srmProjectsInfo.setName(projectsInfoDto.getName());
        srmProjectsInfo.setClassCode(projectsInfoDto.getClassCode());
        srmProjectsInfo.setProjClass(projectsInfoDto.getProjClass());
        srmProjectsInfo.setProjLevel(projectsInfoDto.getProjLevel());
        srmProjectsInfo.setYear(projectsInfoDto.getYear());
        srmProjectsInfo.setHead(projectsInfoDto.getHead());
        srmProjectsInfo.setHeadTypeCode(projectsInfoDto.getHeadTypeCode());
        srmProjectsInfo.setProjType(projectsInfoDto.getProjType());
        System.out.println(projectsInfoDto.getProjStatSourceCode());
        srmProjectsInfo.setContractTypeCode(projectsInfoDto.getContractTypeCode());
        srmProjectsInfo.setAuthorizeFeeAmt(projectsInfoDto.getAuthorizeFeeAmt());
        srmProjectsInfo.setContractRole(projectsInfoDto.getContractRole());
        srmProjectsInfo.setIsTransformContract(projectsInfoDto.getIsTransformContract());
        
        srmProjectsInfo.setProjStatSourceCode(projectsInfoDto.getProjStatSourceCode());
        srmProjectsInfo.setDeptId(projectsInfoDto.getDeptId());
        srmProjectsInfo.setSubSource(projectsInfoDto.getSubSource());
        srmProjectsInfo.setFileNumber(projectsInfoDto.getFileNumber());
        srmProjectsInfo.setStartDate(DateTransform.getLocalDateTime(projectsInfoDto.getStartDate()));
        srmProjectsInfo.setEndDate(DateTransform.getLocalDateTime(projectsInfoDto.getEndDate()));
        srmProjectsInfo.setAcceptanceDate(DateTransform.getLocalDateTime(projectsInfoDto.getAcceptanceDate()));
        srmProjectsInfo.setIssuedDate(DateTransform.getLocalDateTime(projectsInfoDto.getIssuedDate()));
        srmProjectsInfo.setAppraisalDate(DateTransform.getLocalDateTime(projectsInfoDto.getAppraisalDate()));
        srmProjectsInfo.setSpecialFunds(projectsInfoDto.getSpecialFunds());
        srmProjectsInfo.setProjectAccount(projectsInfoDto.getProjectAccount());
        srmProjectsInfo.setIsChiefScientist(projectsInfoDto.getIsChiefScientist());
        srmProjectsInfo.setTopicType(projectsInfoDto.getTopicType());
        srmProjectsInfo.setPrjFundMatched(projectsInfoDto.getPrjFundMatched());
        srmProjectsInfo.setFundAccount(projectsInfoDto.getFundAccount());
        srmProjectsInfo.setResearchType(projectsInfoDto.getResearchType());
        srmProjectsInfo.setSelfRaisedFunds(projectsInfoDto.getSelfRaisedFunds());
        srmProjectsInfo.setSelfFinancingAccount(projectsInfoDto.getSelfFinancingAccount());
        srmProjectsInfo.setDiscipline(projectsInfoDto.getDiscipline());
        srmProjectsInfo.setEnterpriseFunds(projectsInfoDto.getEnterpriseFunds());
        srmProjectsInfo.setEnterpriseAccount(projectsInfoDto.getEnterpriseAccount());
        srmProjectsInfo.setApprovalNumber(projectsInfoDto.getApprovalNumber());
        srmProjectsInfo.setProjOrgnizeUnit(projectsInfoDto.getProjOrgnizeUnit());
        srmProjectsInfo.setSurplusAccount(projectsInfoDto.getSurplusAccount());
        srmProjectsInfo.setRemark(projectsInfoDto.getRemark());
        srmProjectsInfo.setTel(projectsInfoDto.getTel());
        srmProjectsInfo.setPartnerName(projectsInfoDto.getPartnerName());
        srmProjectsInfo.setPartnerTypeCode(projectsInfoDto.getPartnerTypeCode());
        srmProjectsInfo.setPartnerAddress(projectsInfoDto.getPartnerAddress());
        srmProjectsInfo.setPartnerArea(projectsInfoDto.getPartnerArea());
        srmProjectsInfo.setPartnerTel(projectsInfoDto.getPartnerTel());
        srmProjectsInfo.setPartnerRepresentative(projectsInfoDto.getPartnerRepresentative());
        srmProjectsInfo.setNationalEconomyIndustry(projectsInfoDto.getNationalEconomyIndustry());
        srmProjectsInfo.setProjCooperateCode(projectsInfoDto.getProjCooperateCode());
        srmProjectsInfo.setNationalEconomyIndustryMiddle(projectsInfoDto.getNationalEconomyIndustryMiddle());
        srmProjectsInfo.setSocioEconomicObjCode(projectsInfoDto.getSocioEconomicObjCode());
        srmProjectsInfo.setNationalEconomyIndustrySmall(projectsInfoDto.getNationalEconomyIndustrySmall());
        srmProjectsInfo.setProjOrgformCode(projectsInfoDto.getProjOrgformCode());
        //srmProjectsInfo.setProjOrgFormCode(projectsInfoDto.g);
        srmProjectsInfo.setDataStatus(0);
        Long RowId=null;
        try{
            if(projectsInfoDto.getRowId()==null){
                String userCode=projectsInfoDto.getUserCode();
                Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
                String subNo=srmBusinessnoService.getBusinessNo(this.hroProjectSysNo,7,"H");
                srmProjectsInfo.setSubNo(subNo);
                srmProjectsInfo.setCreator(String.valueOf(srmUserRowId));
                srmProjectsInfo.setCreateTime(LocalDateTime.now());

            }

            super.saveOrUpdate(srmProjectsInfo);
            RowId=srmProjectsInfo.getId();
            // 下面处理作者，以及处理主表第一作者等等
            List<ProjectsInfoMemberDto> projectsInfoMemberDtoList=projectsInfoVerticalDto.getProjectsInfoMemberDtoList();
            List<SrmProjectsInfoMember> srmProjectsInfoMembers=new ArrayList<>();
            for(ProjectsInfoMemberDto projectsInfoMemberDto :projectsInfoMemberDtoList){
                SrmProjectsInfoMember srmProjectsInfoMember=new SrmProjectsInfoMember();
                
                srmProjectsInfoMember.setMember(projectsInfoMemberDto.getMember());
                srmProjectsInfoMember.setProjId(RowId);
                srmProjectsInfoMember.setId(projectsInfoMemberDto.getRowId());
                srmProjectsInfoMember.setRanking(projectsInfoMemberDto.getRanking());
                srmProjectsInfoMember.setAuthorTypeCode(projectsInfoMemberDto.getAuthorTypeCode());

                srmProjectsInfoMembers.add(srmProjectsInfoMember);
            }
            srmProjectsInfoMemberService.saveOrUpdateBatch(srmProjectsInfoMembers);

        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
        return RowId;

    }

    @Override
    public ProjectsInfoVo getHroProjectDetail(Long rowId) {
        return srmProjectsInfoMapper.getHroProjectDetail(rowId);
    }

    @Override
    public IPage<ProjectsInfoVo> listHroProject(ProjectsInfoDto projectsInfoDto) {
        String userCode=projectsInfoDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        projectsInfoDto.setUserId(srmUserRowId);
        Page<ProjectsInfoVo> page = new Page<>(projectsInfoDto.getPage(), projectsInfoDto.getRows());
        IPage<ProjectsInfoVo> res= srmProjectsInfoMapper.listHroProject(page, projectsInfoDto);
        List<ProjectsInfoVo> records=res.getRecords();
        List<ProjectsInfoVo> newRecords=new ArrayList<>();
        for(ProjectsInfoVo InfoVo : records){
            ProjectsInfoVo newRecord=new ProjectsInfoVo();
            newRecord=InfoVo;
            Long rowId=InfoVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc(this.hroProjectSysNo,rowId,null);
            newRecord.setChkResultList(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }

    @Override
    @Transactional
    public void deleteHroProject(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                //System.out.println(RowId);
                srmProjectsInfoMemberService.deleteAuthorByParent(RowId);
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
    public void subMitHroProject(BaseDto baseDto) {
        //提交前先判断是否已经提交
        //提交前判断是否上传必要附件（后置）
        Long rowId=baseDto.getId();
        Boolean allowSumbit=srmUploadInfoService.getFileNessary(String.valueOf(rowId),this.hroProjectSysNo);
        if(!allowSumbit){
            throw new ErrorException("-200","请上传必要的附件！");
        }
        HosUser hosUser = SecurityUtils.getLoginUser();
        String userCode = hosUser.getAccountCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        try {
            ProjectsInfoVo detail=this.getVerticalDetail(rowId);
            Integer dataStatus=detail.getDataStatus();
            if(dataStatus==null||dataStatus==1){
                throw new ErrorException("-200","已提交");
            }
            srmProjectsInfoMapper.updateStatus(rowId,1,null,String.valueOf(srmUserRowId),LocalDateTime.now());
            srmEafRecService.generateRec(String.valueOf(rowId),this.hroProjectSysNo,userCode,null);

        }catch (Exception e){
            throw new ErrorException("-200","提交失败");
        }
    }

    @Override
    @Transactional
    public void auditHroProject(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        //String userCode=baseDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(null);
        String sysNo=this.hroProjectSysNo;
        if(srmUserRowId==null){
            throw new ErrorException("-200","当前登录用户不存在!");
        }
        String view=baseDto.getView();
        String auditStatus=baseDto.getAuditStatus();
        String resultId="";

        try{
            for(Long rowId : idList){
                if(auditStatus.equals("1")){
                    resultId="2";
                    srmProjectsInfoMapper.updateStatus(rowId,null,resultId,null,null);
                    srmEafRecService.genAudit(rowId,sysNo,srmUserRowId,resultId,view,null);
                }
                if(auditStatus.equals("2")){
                    resultId="3";
                    srmProjectsInfoMapper.updateStatus(rowId,0,resultId,null,null);
                    srmEafRecService.genAudit(rowId,sysNo,srmUserRowId,resultId,view,null);
                }
            }
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
    }

    @Override
    public IPage<ProjectsInfoVo> listAuditHroProject(ProjectsInfoDto projectsInfoDto) {
        Page<ProjectsInfoVo> page = new Page<>(projectsInfoDto.getPage(), projectsInfoDto.getRows());
        String userCode=projectsInfoDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        projectsInfoDto.setUserId(srmUserRowId);
        IPage<ProjectsInfoVo> res= srmProjectsInfoMapper.listAuditHroProject(page, projectsInfoDto);
        List<ProjectsInfoVo> records=res.getRecords();
        List<ProjectsInfoVo> newRecords=new ArrayList<>();
        for(ProjectsInfoVo InfoVo : records){
            ProjectsInfoVo newRecord=new ProjectsInfoVo();
            newRecord=InfoVo;
            Long rowId=InfoVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc(this.hroProjectSysNo,rowId,null);
            newRecord.setChkResultList(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }

    // 下面是合同项目
    @Override
    @Transactional
    public Long saveContractProjectsInfo(ProjectsInfoVerticalDto projectsInfoVerticalDto) {
        ProjectsInfoDto projectsInfoDto=projectsInfoVerticalDto.getProjectsInfoDto();
        SrmProjectsInfo srmProjectsInfo=new SrmProjectsInfo();
        srmProjectsInfo.setId(projectsInfoDto.getRowId());
        srmProjectsInfo.setSysNo(this.contractProjectSysNo);
        srmProjectsInfo.setName(projectsInfoDto.getName());
        srmProjectsInfo.setYear(projectsInfoDto.getYear());
        srmProjectsInfo.setHead(projectsInfoDto.getHead());
        srmProjectsInfo.setHeadTypeCode(projectsInfoDto.getHeadTypeCode());
        srmProjectsInfo.setDeptId(projectsInfoDto.getDeptId());
        srmProjectsInfo.setDataStatus(0);
        Long RowId=null;
        try{
            String userCode=projectsInfoDto.getUserCode();
            Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
            srmProjectsInfo.setSubUserId(String.valueOf(srmUserRowId));
            srmProjectsInfo.setSubDate(LocalDateTime.now());
            super.saveOrUpdate(srmProjectsInfo);
            RowId=srmProjectsInfo.getId();
            // 下面处理作者，以及处理主表第一作者等等
            List<ProjectsInfoMemberDto> projectsInfoMemberDtoList=projectsInfoVerticalDto.getProjectsInfoMemberDtoList();
            List<SrmProjectsInfoMember> srmProjectsInfoMembers=new ArrayList<>();
            for(ProjectsInfoMemberDto projectsInfoMemberDto :projectsInfoMemberDtoList){
                SrmProjectsInfoMember srmProjectsInfoMember=new SrmProjectsInfoMember();
                srmProjectsInfoMember.setMember(projectsInfoMemberDto.getMember());
                srmProjectsInfoMember.setProjId(RowId);
                srmProjectsInfoMember.setId(projectsInfoMemberDto.getRowId());
                srmProjectsInfoMember.setRanking(projectsInfoMemberDto.getRanking());
                srmProjectsInfoMember.setAuthorTypeCode(projectsInfoMemberDto.getAuthorTypeCode());
                srmProjectsInfoMembers.add(srmProjectsInfoMember);
            }
            srmProjectsInfoMemberService.saveOrUpdateBatch(srmProjectsInfoMembers);

        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
        return RowId;

    }

    @Override
    public ProjectsInfoVo getContractProjectDetail(Long rowId) {
        return srmProjectsInfoMapper.getVerticalDetail(rowId);
    }

    @Override
    public IPage<ProjectsInfoVo> listContractProject(ProjectsInfoDto projectsInfoDto) {
        System.out.println(projectsInfoDto);
        Page<ProjectsInfoVo> page = new Page<>(projectsInfoDto.getPage(), projectsInfoDto.getRows());
        IPage<ProjectsInfoVo> res= srmProjectsInfoMapper.listHroProject(page, projectsInfoDto);
        List<ProjectsInfoVo> records=res.getRecords();
        List<ProjectsInfoVo> newRecords=new ArrayList<>();
        for(ProjectsInfoVo InfoVo : records){
            ProjectsInfoVo newRecord=new ProjectsInfoVo();
            newRecord=InfoVo;
            Long rowId=InfoVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc(this.contractProjectSysNo,rowId,null);
            newRecord.setChkResultList(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }

    @Override
    @Transactional
    public void deleteContractProject(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                //System.out.println(RowId);
                srmProjectsInfoMemberService.deleteAuthorByParent(RowId);
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
    public void subMitContractProject(BaseDto baseDto) {
        //提交前先判断是否已经提交
        //提交前判断是否上传必要附件（后置）
        Long rowId=baseDto.getId();
        HosUser hosUser = SecurityUtils.getLoginUser();
        String userCode = hosUser.getAccountCode();
        try {
            ProjectsInfoVo detail=this.getVerticalDetail(rowId);
            Integer dataStatus=detail.getDataStatus();
            if(dataStatus==null||dataStatus==1){
                throw new ErrorException("-200","已提交");
            }
            srmProjectsInfoMapper.updateStatus(rowId,1,null,null,null);
            srmEafRecService.generateRec(String.valueOf(rowId),this.contractProjectSysNo,userCode,null);

        }catch (Exception e){
            throw new ErrorException("-200","提交失败");
        }
    }

    @Override
    @Transactional
    public void auditContractProject(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        //String userCode=baseDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(null);
        String sysNo=this.contractProjectSysNo;
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
                srmProjectsInfoMapper.updateStatus(rowId,null,resultId,null,null);
                srmEafRecService.genAudit(rowId,sysNo,srmUserRowId,resultId,view,null);
            }
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
    }

    @Override
    public IPage<ProjectsInfoVo> listAuditContractProject(ProjectsInfoDto projectsInfoDto) {
        Page<ProjectsInfoVo> page = new Page<>(projectsInfoDto.getPage(), projectsInfoDto.getRows());
        String userCode=projectsInfoDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        projectsInfoDto.setUserId(srmUserRowId);
        IPage<ProjectsInfoVo> res= srmProjectsInfoMapper.listAuditHroProject(page, projectsInfoDto);
        List<ProjectsInfoVo> records=res.getRecords();
        List<ProjectsInfoVo> newRecords=new ArrayList<>();
        for(ProjectsInfoVo InfoVo : records){
            ProjectsInfoVo newRecord=new ProjectsInfoVo();
            newRecord=InfoVo;
            Long rowId=InfoVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc(this.contractProjectSysNo,rowId,null);
            SrmEafRec srmEafRec=srmEafRecService.getAuditStepAndDesc(this.contractProjectSysNo,rowId);
            newRecord.setAuditStepNo(String.valueOf(srmEafRec.getStepNo()));
            newRecord.setAuditStepDesc(srmEafRec.getCheckProcDesc());
            newRecord.setChkResultList(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }

    @Override
    public List<CombVo> getProjectsInfo(ProjectsInfoDto projectsInfoDto) {
        return srmProjectsInfoMapper.getProjectsInfo(projectsInfoDto);
    }

    @Override
    public List<CombVo>getProject(){
        return srmProjectsInfoMapper.getProject();
    }

    @Override
    public List<CombVo> getProjectSolicit(String userCode) {
        Long srmUserRowId=null;
        if(!userCode.isEmpty()){
            srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        }
        return srmProjectsInfoMapper.getProjectSolicit(String.valueOf(srmUserRowId));
    }
}
