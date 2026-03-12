package com.mediway.hos.srm.business.center.serviceimpl.contract;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mediway.hos.app.core.util.SecurityUtils;
import com.mediway.hos.security.core.userdetails.HosUser;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.contract.ContractInfoDto;
import com.mediway.hos.srm.business.center.model.dto.contract.ContractInfoMainDto;
import com.mediway.hos.srm.business.center.model.dto.contract.ContractInfoMemberDto;
import com.mediway.hos.srm.business.center.model.entity.approvalProcess.SrmEafRec;
import com.mediway.hos.srm.business.center.service.approvalProcess.SrmEafRecService;
import com.mediway.hos.srm.business.center.service.baseData.SrmBusinessnoService;
import com.mediway.hos.srm.business.center.service.baseData.SrmUploadInfoService;
import com.mediway.hos.srm.business.center.service.contract.SrmContractInfoMemberService;
import com.mediway.hos.srm.business.center.service.contract.SrmContractInfoService;
import com.mediway.hos.srm.business.center.service.user.SrmUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;

import com.mediway.hos.srm.business.center.model.entity.contract.SrmContractInfo;
import com.mediway.hos.srm.business.center.mapper.contract.SrmContractInfoMapper;
import com.mediway.hos.srm.business.center.model.entity.contract.SrmContractInfoMember;
import com.mediway.hos.srm.business.center.model.vo.contract.ContractInfoVo;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectSolicitGradeVo;

import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.mediway.hos.srm.business.center.utils.DateTransform;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 合同(项目) 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2025-02-25
 */
@Service
public class SrmContractInfoServiceImpl extends BaseServiceImpl<SrmContractInfoMapper, SrmContractInfo> implements SrmContractInfoService {
    private final String sysNo="P055";
    @Autowired
    private SrmContractInfoMapper srmContractInfoMapper;
    @Autowired
    private SrmUserService srmUserService;
    @Autowired
    private SrmContractInfoMemberService srmContractInfoMemberService;
    @Autowired
    private SrmUploadInfoService srmUploadInfoService;
    @Autowired
    private SrmEafRecService srmEafRecService;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    @Override
    @Transactional
    public Long saveContractInfo(ContractInfoMainDto contractInfoMainDto) {
        System.out.println(contractInfoMainDto);
        ContractInfoDto contractInfoDto=contractInfoMainDto.getContractInfoDto();
        SrmContractInfo srmContractInfo=new SrmContractInfo();
        srmContractInfo.setId(contractInfoDto.getRowId());
        srmContractInfo.setSysNo(this.sysNo);
        srmContractInfo.setName(contractInfoDto.getName());
        srmContractInfo.setContractTypeCode(contractInfoDto.getContractTypeCode());
        srmContractInfo.setContractCategory(contractInfoDto.getContractCategory());
        srmContractInfo.setIsPatentContract(contractInfoDto.getIsPatentContract());
        srmContractInfo.setAuthorizeFeeAmt(contractInfoDto.getAuthorizeFeeAmt());
        srmContractInfo.setAppraisalDate(DateTransform.getLocalDateTime(contractInfoDto.getAppraisalDate()));
        srmContractInfo.setStartDate(DateTransform.getLocalDateTime(contractInfoDto.getStartDate()));
        srmContractInfo.setEndDate(DateTransform.getLocalDateTime(contractInfoDto.getEndDate()));
        srmContractInfo.setContractRole(contractInfoDto.getContractRole());
        srmContractInfo.setIsEthicalApproval(contractInfoDto.getIsEthicalApproval());
        srmContractInfo.setIsTransformContract(contractInfoDto.getIsTransformContract());
        srmContractInfo.setPatentId(contractInfoDto.getPatentId());
        srmContractInfo.setRemark(contractInfoDto.getRemark());
        srmContractInfo.setPartnerName(contractInfoDto.getPartnerName());
        srmContractInfo.setPartnerTypeCode(contractInfoDto.getPartnerTypeCode());
        srmContractInfo.setPartnerAddress(contractInfoDto.getPartnerAddress());
        srmContractInfo.setPartnerArea(contractInfoDto.getPartnerArea());
        srmContractInfo.setPartnerTel(contractInfoDto.getPartnerTel());
        srmContractInfo.setPartnerRepresentative(contractInfoDto.getPartnerRepresentative());
        srmContractInfo.setProjectId(contractInfoDto.getProjectId());
        srmContractInfo.setClassCode(contractInfoDto.getClassCode());
        srmContractInfo.setYear(contractInfoDto.getYear());
        srmContractInfo.setHead(contractInfoDto.getHead());
        srmContractInfo.setHeadTypeCode(contractInfoDto.getHeadTypeCode());
        srmContractInfo.setDeptId(contractInfoDto.getDeptId());
        srmContractInfo.setProjLevel(contractInfoDto.getProjLevel());
        srmContractInfo.setProjectAccount(contractInfoDto.getProjectAccount());
        srmContractInfo.setFileNumber(contractInfoDto.getFileNumber());
        //srmContractInfo.setProjectId(contractInfoDto.getProjectId());
        srmContractInfo.setDataStatus(0);
        srmContractInfo.setNationalEconomyIndustry(contractInfoDto.getNationalEconomyIndustry());
        srmContractInfo.setProjCooperateCode(contractInfoDto.getProjCooperateCode());
        srmContractInfo.setNationalEconomyIndustryMiddle(contractInfoDto.getNationalEconomyIndustryMiddle());
        srmContractInfo.setSocioEconomicObjCode(contractInfoDto.getSocioEconomicObjCode());
        srmContractInfo.setNationalEconomyIndustrySmall(contractInfoDto.getNationalEconomyIndustrySmall());
        srmContractInfo.setProjOrgformCode(contractInfoDto.getProjOrgformCode());

        Long RowId=null;
        try{
            String userCode=contractInfoDto.getUserCode();
            Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
            if(contractInfoDto.getRowId()==null){
                String subNo=srmBusinessnoService.getBusinessNo(this.sysNo,7,"C");
                srmContractInfo.setSubNo(subNo);
                //srmContractInfo.setSubUserId(String.valueOf(srmUserRowId));
                srmContractInfo.setCreator(String.valueOf(srmUserRowId));
                srmContractInfo.setCreateTime(LocalDateTime.now());
                //srmContractInfo.setSubDate(LocalDateTime.now());
            }

            super.saveOrUpdate(srmContractInfo);
            RowId=srmContractInfo.getId();
            // 下面处理作者，以及处理主表第一作者等等
            List<ContractInfoMemberDto> contractInfoMemberDtos=contractInfoMainDto.getContractInfoMemberDtos();
            List<SrmContractInfoMember> srmContractInfoMembers=new ArrayList<>();
            for(ContractInfoMemberDto contractInfoMemberDto :contractInfoMemberDtos){
                SrmContractInfoMember srmContractInfoMember=new SrmContractInfoMember();
                srmContractInfoMember.setMember(contractInfoMemberDto.getMember());
                srmContractInfoMember.setContractId(RowId);
                srmContractInfoMember.setId(contractInfoMemberDto.getRowId());
                srmContractInfoMember.setRanking(contractInfoMemberDto.getRanking());
                srmContractInfoMember.setAuthorTypeCode(srmContractInfoMember.getAuthorTypeCode());
                srmContractInfoMember.setTitleCode(srmContractInfoMember.getTitleCode());
                srmContractInfoMember.setWorkRatio(srmContractInfoMember.getWorkRatio());
                srmContractInfoMember.setNote(srmContractInfoMember.getNote());
                srmContractInfoMembers.add(srmContractInfoMember);
            }
            srmContractInfoMemberService.saveOrUpdateBatch(srmContractInfoMembers);

        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
        return RowId;
    }

    @Override
    public ContractInfoVo getContractInfoDetail(Long rowId) {
        ContractInfoVo contractInfoVo=srmContractInfoMapper.getDetail(rowId);

        SrmEafRec srmEafRec=srmEafRecService.getAuditStepAndDesc(this.sysNo,rowId);
        if(srmEafRec!=null){
            contractInfoVo.setAuditStepNo(String.valueOf(srmEafRec.getStepNo()));
            contractInfoVo.setAuditStepDesc(srmEafRec.getCheckProcDesc());
        }

        return contractInfoVo;
    }

    @Override
    public IPage<ContractInfoVo> listContractInfo(ContractInfoDto contractInfoDto) {
        System.out.println(contractInfoDto);
        String userCode=contractInfoDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        contractInfoDto.setUserId(srmUserRowId);
        Page<ContractInfoVo> page = new Page<>(contractInfoDto.getPage(), contractInfoDto.getRows());
        IPage<ContractInfoVo> res= srmContractInfoMapper.listContractInfo(page, contractInfoDto);
        System.out.println(res);
        List<ContractInfoVo> records=res.getRecords();
        List<ContractInfoVo> newRecords=new ArrayList<>();
        for(ContractInfoVo InfoVo : records){
            ContractInfoVo newRecord=new ContractInfoVo();
            newRecord=InfoVo;
            Long rowId=InfoVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc(this.sysNo,rowId,null);
            newRecord.setChkResultList(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }

    @Override
    @Transactional
    public void deleteContractInfo(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                //System.out.println(RowId);
                srmContractInfoMemberService.deleteAuthorByParent(RowId);
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
    public void subMitContractInfo(BaseDto baseDto) {
        //提交前先判断是否已经提交
        //提交前判断是否上传必要附件（后置）
        Long rowId=baseDto.getId();
        Boolean allowSumbit=srmUploadInfoService.getFileNessary(String.valueOf(rowId),this.sysNo);
        if(!allowSumbit){
            throw new ErrorException("-200","请上传必要的附件！");
        }
        HosUser hosUser = SecurityUtils.getLoginUser();
        String userCode = hosUser.getAccountCode();
        try {

            SrmContractInfo srmContractInfo=this.selectById(rowId);
            Integer dataStatus=srmContractInfo.getDataStatus();
            if(dataStatus==null||dataStatus==1){
                throw new ErrorException("-200","已提交");
            }
            srmContractInfoMapper.updateStatus(rowId,1,null);
            srmEafRecService.generateRec(String.valueOf(rowId),this.sysNo,userCode,null);

        }catch (Exception e){
            throw new ErrorException("-200","提交失败");
        }
    }

    @Override
    @Transactional
    public void auditContractInfo(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        Long srmUserRowId= srmUserService.getUserIdByAccount(null);
        String sysNo=this.sysNo;
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
                //srmContractInfoMapper.updateStatus(rowId,null,resultId);
                srmEafRecService.genAudit(rowId,sysNo,srmUserRowId,resultId,view,null);
            }
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
    }

    @Override
    public IPage<ContractInfoVo> listAuditContractInfo(ContractInfoDto contractInfoDto) {
        System.out.println(contractInfoDto);
        String userCode=contractInfoDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        contractInfoDto.setUserId(srmUserRowId);
        Page<ContractInfoVo> page = new Page<>(contractInfoDto.getPage(), contractInfoDto.getRows());
        IPage<ContractInfoVo> res= srmContractInfoMapper.listAuditContractInfo(page, contractInfoDto);
        List<ContractInfoVo> records=res.getRecords();
        List<ContractInfoVo> newRecords=new ArrayList<>();
        for(ContractInfoVo InfoVo : records){
            ContractInfoVo newRecord=new ContractInfoVo();
            newRecord=InfoVo;
            Long rowId=InfoVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc(this.sysNo,rowId,null);
            newRecord.setChkResultList(checkListName);
            SrmEafRec srmEafRec=srmEafRecService.getAuditStepAndDesc(this.sysNo,rowId);
            if(srmEafRec!=null){
                newRecord.setAuditStepNo(String.valueOf(srmEafRec.getStepNo()));
                newRecord.setAuditStepDesc(srmEafRec.getCheckProcDesc());
            }
            BaseDto baseDto=new BaseDto();
            List<Long> idList=new ArrayList<>();
            idList.add(rowId);
            baseDto.setIdList(idList);
            //baseDto.setUserCode(userCode);
            baseDto.setSysNo(this.sysNo);
            boolean curAuditStatus=srmEafRecService.getCurStatus(baseDto);
            if(curAuditStatus){
                newRecord.setCurAuditStatus("1");
            }else{
                newRecord.setCurAuditStatus("0");
            }


            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }
    @Override
    public IPage<ProjectSolicitGradeVo> listExpertAudit(ContractInfoDto contractInfoDto) {
        String userCode=contractInfoDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        contractInfoDto.setUserId(srmUserRowId);
        Page<ProjectSolicitGradeVo> page = new Page<>(contractInfoDto.getPage(), contractInfoDto.getRows());
        IPage<ProjectSolicitGradeVo> res= srmContractInfoMapper.listExpertAudit(page, contractInfoDto);
        return res;
    }
}
