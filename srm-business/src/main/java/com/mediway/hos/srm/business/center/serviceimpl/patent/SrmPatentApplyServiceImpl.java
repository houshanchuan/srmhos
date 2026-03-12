package com.mediway.hos.srm.business.center.serviceimpl.patent;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mediway.hos.app.core.util.SecurityUtils;
import com.mediway.hos.security.core.userdetails.HosUser;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.UnitPeronDto;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperSubmissionExpertAuditDto;
import com.mediway.hos.srm.business.center.model.dto.patent.PatentApplyAuthorDto;
import com.mediway.hos.srm.business.center.model.dto.patent.PatentApplyDto;
import com.mediway.hos.srm.business.center.model.dto.patent.PatentApplyMainDto;
import com.mediway.hos.srm.business.center.model.entity.patent.SrmPatentApply;
import com.mediway.hos.srm.business.center.model.entity.patent.SrmPatentApplyAuthor;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmRelyUnit;
import com.mediway.hos.srm.business.center.model.entity.user.SrmUser;
import com.mediway.hos.srm.business.center.service.approvalProcess.SrmEafRecService;
import com.mediway.hos.srm.business.center.service.baseData.SrmUploadInfoService;
import com.mediway.hos.srm.business.center.service.patent.SrmPatentApplyAuthorService;
import com.mediway.hos.srm.business.center.service.patent.SrmPatentApplyService;
import com.mediway.hos.srm.business.center.service.user.SrmUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmRelyUnitMapper;
import com.mediway.hos.srm.business.center.mapper.user.SrmUserMapper;

import com.mediway.hos.srm.business.center.mapper.patent.SrmPatentApplyMapper;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperSubmissionExpertAuditVo;
import com.mediway.hos.srm.business.center.model.vo.patent.PatentApplyVo;
import com.mediway.hos.srm.business.center.model.vo.baseData.UnitPeronVo;

import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.mediway.hos.srm.business.center.utils.DateTransform;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 专利申报 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmPatentApplyServiceImpl extends BaseServiceImpl<SrmPatentApplyMapper, SrmPatentApply> implements SrmPatentApplyService {
    private final String patentApplySysNo="P010";
    @Autowired
    private SrmPatentApplyMapper srmPatentApplyMapper;
    @Autowired
    private SrmPatentApplyAuthorService srmPatentApplyAuthorService;
    @Autowired
    private SrmUserService srmUserService;
    @Autowired
    private SrmUserMapper srmUserMapper;
    @Autowired
    private SrmRelyUnitMapper srmRelyUnitMapper;
    @Autowired
    private SrmEafRecService srmEafRecService;
    @Autowired
    private SrmUploadInfoService srmUploadInfoService;
    @Override
    public PatentApplyVo getDetail(String rowId) {
        return srmPatentApplyMapper.getDetail(rowId);
    }

    @Override
    @Transactional
    public Long savePatentApply(PatentApplyMainDto patentApplyMainDto) {
        PatentApplyDto patentApplyDto=patentApplyMainDto.getPatentApplyDto();
        String userCode=patentApplyDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        System.out.println(patentApplyDto);
        SrmPatentApply srmPatentApply=new SrmPatentApply();
        srmPatentApply.setId(patentApplyDto.getRowId());
        srmPatentApply.setApplyInfoId(patentApplyDto.getApplyInfoId());
        srmPatentApply.setSysNo(this.patentApplySysNo);
        srmPatentApply.setName(patentApplyDto.getName());
        srmPatentApply.setPatentType(patentApplyDto.getPatentType());
        srmPatentApply.setAppDate(DateTransform.getLocalDateTime(patentApplyDto.getAppDate()));
        srmPatentApply.setPhone(patentApplyDto.getPhone());
        srmPatentApply.setEmail(patentApplyDto.getEmail());
        srmPatentApply.setAgencyFeeSource(patentApplyDto.getAgencyFeeSource());
        srmPatentApply.setDigest(patentApplyDto.getDigest());
        srmPatentApply.setNote(patentApplyDto.getNote());
        srmPatentApply.setPhone(patentApplyDto.getPhone());
        srmPatentApply.setEmail(patentApplyDto.getEmail());
        srmPatentApply.setDeptId(patentApplyDto.getDeptId());
        srmPatentApply.setAgencyUnit(patentApplyDto.getAgencyUnit());

        if(patentApplyDto.getRowId()==null){

            srmPatentApply.setCreator(String.valueOf(srmUserRowId));
            srmPatentApply.setCreateTime(LocalDateTime.now());
        }

        Long RowId=null;
        try{
            LocalDateTime appDate= DateTransform.getLocalDateTime(patentApplyDto.getAppDate());
            srmPatentApply.setAppDate(appDate);
            String patentees=this.getPatentees(patentApplyMainDto.getUnitPeronDtoList());
            if(patentees==null){
                patentees="";
            }
            srmPatentApply.setPatentee(patentees);
            super.saveOrUpdate(srmPatentApply);
            RowId=srmPatentApply.getId();
            // 下面处理作者，以及处理主表第一作者等等
            List<PatentApplyAuthorDto> paperAuthorDtos=patentApplyMainDto.getPatentApplyAuthorDtoList();
            List<SrmPatentApplyAuthor> srmPatentApplyAuthors=new ArrayList<>();
            for(PatentApplyAuthorDto patentApplyAuthorDto :paperAuthorDtos){
                SrmPatentApplyAuthor srmPatentApplyAuthor=new SrmPatentApplyAuthor();
                srmPatentApplyAuthor.setAuthorId(patentApplyAuthorDto.getAuthorId());
                srmPatentApplyAuthor.setApplyPatentId(RowId);
                srmPatentApplyAuthor.setId(patentApplyAuthorDto.getRowId());
                srmPatentApplyAuthor.setRanking(patentApplyAuthorDto.getRanking());
                srmPatentApplyAuthor.setTitle(patentApplyAuthorDto.getTitle());
                srmPatentApplyAuthor.setSex(patentApplyAuthorDto.getSex());
                srmPatentApplyAuthor.setNote(patentApplyAuthorDto.getNote());
                srmPatentApplyAuthor.setWorkRatio(patentApplyAuthorDto.getWorkRatio());
                srmPatentApplyAuthor.setEduLevel(patentApplyAuthorDto.getEduLevel());
                srmPatentApplyAuthor.setIsOurHosp(patentApplyAuthorDto.getIsOurHosp());
                srmPatentApplyAuthor.setDegree(patentApplyAuthorDto.getDegree());
                srmPatentApplyAuthors.add(srmPatentApplyAuthor);
            }
            srmPatentApplyAuthorService.saveOrUpdateBatch(srmPatentApplyAuthors);

        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
        return RowId;
    }
    // 保存专利权人、专利权单位
    public String getPatentees(List<UnitPeronDto> unitPeronDtoList){
        StringBuilder patenteesStr= new StringBuilder();
        if(unitPeronDtoList!=null){
            for(UnitPeronDto unitPeronDto :unitPeronDtoList){
                String userId=unitPeronDto.getPersonId();
                String unitId=unitPeronDto.getUnitRowId();
                StringBuilder newPatenteesStr= new StringBuilder();
                if(userId!=null&&!unitPeronDto.getPersonId().isEmpty()){

                    newPatenteesStr = new StringBuilder(userId + "|1");

                }
                if(unitId!=null&&!unitPeronDto.getUnitRowId().isEmpty()){
                    if(newPatenteesStr.length() == 0){
                        newPatenteesStr = new StringBuilder(unitId + "|2");
                    }else{
                        newPatenteesStr.append("#").append(unitId).append("|2");
                    }
                }
                if(patenteesStr.length()==0){
                    patenteesStr=newPatenteesStr;
                }else{
                    patenteesStr=patenteesStr.append(",").append(newPatenteesStr.toString());
                }
            }
        }
        return patenteesStr.toString();
    }
    @Override
    public IPage<PatentApplyVo> listPatentApply(PatentApplyDto patentApplyDto) {
        String userCode=patentApplyDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        patentApplyDto.setUserId(srmUserRowId);
        Page<PatentApplyVo> page = new Page<>(patentApplyDto.getPage(), patentApplyDto.getRows());
        System.out.println(patentApplyDto);
        IPage<PatentApplyVo> res= srmPatentApplyMapper.listPatentApply(page, patentApplyDto);
        List<PatentApplyVo> records=res.getRecords();
        List<PatentApplyVo> newRecords=new ArrayList<>();
        for(PatentApplyVo patentApplyVo : records){
            PatentApplyVo newRecord=new PatentApplyVo();
            newRecord=patentApplyVo;
            Long rowId=patentApplyVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc(this.patentApplySysNo,rowId,null);
            newRecord.setCheckList(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }

    @Override
    @Transactional
    public void deletePatentApply(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                //System.out.println(RowId);
                srmPatentApplyAuthorService.deleteAuthorByApplyId(RowId);
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
        Boolean allowSumbit=srmUploadInfoService.getFileNessary(String.valueOf(rowId),this.patentApplySysNo);
        if(!allowSumbit){
            throw new ErrorException("-200","请上传必要的附件！");
        }
        HosUser hosUser = SecurityUtils.getLoginUser();
        String userCode = hosUser.getAccountCode();
        try {
            Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
            PatentApplyVo patentApplyVo=this.getDetail(String.valueOf(rowId));
            Integer dataStatus=patentApplyVo.getDataStatus();
            if(dataStatus==null||dataStatus==1){
                throw new ErrorException("-200","已提交");
            }
            srmPatentApplyMapper.updateStatus(rowId,1,"1",null,LocalDateTime.now(),String.valueOf(srmUserRowId));
            srmEafRecService.generateRec(String.valueOf(rowId),this.patentApplySysNo,userCode,null);

        }catch (Exception e){
            throw new ErrorException("-200","提交失败");
        }
    }

    @Override
    @Transactional
    public void audit(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        //String userCode=baseDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(null);
        String sysNo=this.patentApplySysNo;
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
                srmPatentApplyMapper.updateStatus(rowId,null,resultId,null,null,null);
                srmEafRecService.genAudit(rowId,sysNo,srmUserRowId,resultId,view,null);
            }
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
    }

    @Override
    public IPage<PatentApplyVo> listAuditPatentApply(PatentApplyDto patentApplyDto) {

        Page<PatentApplyVo> page = new Page<>(patentApplyDto.getPage(), patentApplyDto.getRows());
        String userCode=patentApplyDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        patentApplyDto.setUserId(srmUserRowId);
        IPage<PatentApplyVo> res= srmPatentApplyMapper.listAuditPatentApply(page, patentApplyDto);
        List<PatentApplyVo> records=res.getRecords();
        List<PatentApplyVo> newRecords=new ArrayList<>();
        for(PatentApplyVo patentApplyVo : records){
            PatentApplyVo newRecord=new PatentApplyVo();
            newRecord=patentApplyVo;
            Long rowId=patentApplyVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc(this.patentApplySysNo,rowId,null);
            newRecord.setCheckList(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }
    @Override
    @Transactional
    public void deletePatentee(String rowIdStr) {
        System.out.println(rowIdStr);
        try{
            String[] rowArray=rowIdStr.split(",");
            String parref=rowArray[0];
            String unitPersonStr=rowArray[1];
            QueryWrapper<SrmPatentApply> srmPatentApplyQueryWrapper=new QueryWrapper<>();
            srmPatentApplyQueryWrapper.eq("id",Long.valueOf(parref));
            SrmPatentApply srmPatentApply=srmPatentApplyMapper.selectOne(srmPatentApplyQueryWrapper);
            String patenteeStr=srmPatentApply.getPatentee();
            String[] patenteeArray=patenteeStr.split(",");
            List<String> patenteeList=new ArrayList<>(Arrays.asList(patenteeArray));
            patenteeList.remove(unitPersonStr);
            String newPatenteeStr=String.join(",",patenteeList);
            SrmPatentApply srmPatentApply1=new SrmPatentApply();
            System.out.println(newPatenteeStr);
            System.out.println(parref);
            srmPatentApply1.setId(Long.valueOf(parref));
            srmPatentApply1.setPatentee(newPatenteeStr);
            super.saveOrUpdate(srmPatentApply1);
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }

    }

    @Override
    public List<UnitPeronVo> listPatentee(Long rowId) {
        QueryWrapper<SrmPatentApply> srmPatentApplyQueryWrapper=new QueryWrapper<>();
        srmPatentApplyQueryWrapper.eq("id",rowId);
        SrmPatentApply srmPatentApply=srmPatentApplyMapper.selectOne(srmPatentApplyQueryWrapper);
        String patenteeStr=srmPatentApply.getPatentee();
        List<UnitPeronVo> unitPeronVos=new ArrayList<>();
        if(patenteeStr==null||patenteeStr.isEmpty()){
            return unitPeronVos;
        }else{

            String[] patenteeList=patenteeStr.split(",");
            for (String row :patenteeList){
                String[] lines=row.split("#");

                UnitPeronVo  unitPeronVo=new UnitPeronVo();
                StringBuilder unitPersonRowId= new StringBuilder();

                for (String line :lines){
                    String[] rowList=line.split("\\|");
                    String unitPersonId=rowList[0];
                    String type=rowList[1];
                    //String unitPersonRowId=rowId+"|"+type+"|"+unitPersonId;
                    //unitPeronVo.setRowId(unitPersonRowId);
                    unitPeronVo.setParref(String.valueOf(rowId));
                    if("1".equals(type)){
                        QueryWrapper<SrmUser> srmUserQueryWrapper=new QueryWrapper<>();
                        srmUserQueryWrapper.eq("id",Long.valueOf(unitPersonId));
                        SrmUser srmUser=srmUserMapper.selectOne(srmUserQueryWrapper);
                        unitPeronVo.setPersonId(unitPersonId);
                        unitPeronVo.setPersonName(srmUser.getName());
                        unitPersonRowId.append(unitPersonId).append("|").append(type);
                    }else{
                        QueryWrapper<SrmRelyUnit> srmRelyUnitQueryWrapper=new QueryWrapper<>();
                        srmRelyUnitQueryWrapper.eq("id",Long.valueOf(unitPersonId));
                        SrmRelyUnit srmRelyUnit=srmRelyUnitMapper.selectOne(srmRelyUnitQueryWrapper);
                        unitPeronVo.setUnitRowId(unitPersonId);
                        unitPeronVo.setUnitName(srmRelyUnit.getName());
                        if(unitPersonRowId.length()==0){
                            unitPersonRowId.append(unitPersonId).append("|").append(type);
                        }else{
                            unitPersonRowId.append("#").append(unitPersonId).append("|").append(type);
                        }
                    }
                    //unitPeronVos.add(unitPeronVo);
                }

                StringBuilder newUnitPersonRowId= new StringBuilder();
                newUnitPersonRowId.append(String.valueOf(rowId)).append(",").append(unitPersonRowId);
                unitPeronVo.setRowId(newUnitPersonRowId.toString());
                unitPeronVos.add(unitPeronVo);
            }
            return unitPeronVos;
        }

    }
    @Override
    public IPage<PaperSubmissionExpertAuditVo> listExpertAuditPatentApply(PaperSubmissionExpertAuditDto paperSubmissionExpertAuditDto) {
        Page<PaperSubmissionExpertAuditVo> page = new Page<>(paperSubmissionExpertAuditDto.getPage(), paperSubmissionExpertAuditDto.getRows());
        String userCode=paperSubmissionExpertAuditDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        paperSubmissionExpertAuditDto.setUserId(srmUserRowId);
        paperSubmissionExpertAuditDto.setSysNo(this.patentApplySysNo);
        System.out.println(paperSubmissionExpertAuditDto);
        IPage<PaperSubmissionExpertAuditVo> res= srmPatentApplyMapper.listExpertAuditPatentApply(page, paperSubmissionExpertAuditDto);
        return res;
    }
}
