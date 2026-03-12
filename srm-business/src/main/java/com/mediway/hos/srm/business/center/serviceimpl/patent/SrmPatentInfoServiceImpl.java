package com.mediway.hos.srm.business.center.serviceimpl.patent;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mediway.hos.app.core.util.SecurityUtils;
import com.mediway.hos.security.core.userdetails.HosUser;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.UnitPeronDto;
import com.mediway.hos.srm.business.center.model.dto.patent.PatentInfoAuthorDto;
import com.mediway.hos.srm.business.center.model.dto.patent.PatentInfoDto;
import com.mediway.hos.srm.business.center.model.dto.patent.PatentInfoMainDto;
import com.mediway.hos.srm.business.center.model.entity.patent.SrmPatentInfo;
import com.mediway.hos.srm.business.center.model.entity.patent.SrmPatentInfoAuthor;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmRelyUnit;
import com.mediway.hos.srm.business.center.model.entity.user.SrmUser;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.vo.patent.PatentInfoVo;
import com.mediway.hos.srm.business.center.model.vo.baseData.UnitPeronVo;
import com.mediway.hos.srm.business.center.service.approvalProcess.SrmEafRecService;
import com.mediway.hos.srm.business.center.service.baseData.SrmUploadInfoService;
import com.mediway.hos.srm.business.center.service.patent.SrmPatentInfoAuthorService;
import com.mediway.hos.srm.business.center.service.patent.SrmPatentInfoService;
import com.mediway.hos.srm.business.center.service.user.SrmUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmRelyUnitMapper;
import com.mediway.hos.srm.business.center.mapper.user.SrmUserMapper;

import com.mediway.hos.srm.business.center.mapper.patent.SrmPatentInfoMapper;

import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.mediway.hos.srm.business.center.utils.DateTransform;

import java.time.LocalDateTime;
import java.util.*;

/**
 * <p>
 * 专利信息表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmPatentInfoServiceImpl extends BaseServiceImpl<SrmPatentInfoMapper, SrmPatentInfo> implements SrmPatentInfoService {
    private final String patentSysNo="P005";
    @Autowired
    private SrmPatentInfoMapper srmPatentInfoMapper;
    @Autowired
    private SrmUserService srmUserService;
    @Autowired
    private SrmUserMapper srmUserMapper;
    @Autowired
    private SrmPatentInfoAuthorService srmPatentInfoAuthorService;
    @Autowired
    private SrmEafRecService srmEafRecService;
    @Autowired
    private SrmRelyUnitMapper srmRelyUnitMapper;
    @Autowired
    private SrmUploadInfoService srmUploadInfoService;
    @Override
    @Transactional
    public Long savePatentInfo(PatentInfoMainDto patentInfoMainDto) {
        System.out.println(patentInfoMainDto);
        PatentInfoDto patentInfoDto=patentInfoMainDto.getPatentInfoDto();
        SrmPatentInfo srmPatentInfo=new SrmPatentInfo();
        srmPatentInfo.setId(patentInfoDto.getRowId());
        srmPatentInfo.setApplyInfo(patentInfoDto.getApplyInfo());
        srmPatentInfo.setApplyId(patentInfoDto.getApplyId());
        srmPatentInfo.setSysNo(this.patentSysNo);

        String patentName=patentInfoDto.getName();
        if(patentName==null||patentName.isEmpty()){
            throw new ErrorException("-200","专利名称不能为空");
        }
        srmPatentInfo.setName(patentName);
        srmPatentInfo.setPatentNo(patentInfoDto.getPatentNo());
        srmPatentInfo.setDeptId(patentInfoDto.getDeptId());
        srmPatentInfo.setOurUnitRanking(patentInfoDto.getOurUnitRanking());
        srmPatentInfo.setAnnDate(DateTransform.getLocalDateTime(patentInfoDto.getAnnDate()));
        srmPatentInfo.setAnnNo(patentInfoDto.getAnnNo());
        srmPatentInfo.setCertificateNo(patentInfoDto.getCertificateNo());
        srmPatentInfo.setPatentType(patentInfoDto.getPatentType());
        srmPatentInfo.setYear(patentInfoDto.getYear());
        srmPatentInfo.setState(patentInfoDto.getState());
        srmPatentInfo.setIsPct(patentInfoDto.getIsPct());
        srmPatentInfo.setPctCode(patentInfoDto.getPctCode());
        srmPatentInfo.setPctName(patentInfoDto.getPctName());
        srmPatentInfo.setPctDate(DateTransform.getLocalDateTime(patentInfoDto.getPctDate()));
        srmPatentInfo.setPctPriorityDate(patentInfoDto.getPctPriorityDate());
        srmPatentInfo.setApplyDate(DateTransform.getLocalDateTime(patentInfoDto.getApplyDate()));
        srmPatentInfo.setApplyNo(patentInfoDto.getApplyNo());
        srmPatentInfo.setCooperationType(patentInfoDto.getCooperationType());
        srmPatentInfo.setIsValid(patentInfoDto.getIsValid());
        srmPatentInfo.setPatentCountry(patentInfoDto.getPatentCountry());

        srmPatentInfo.setNote(patentInfoDto.getNote());
        Long RowId=null;
        try{
            String userCode=patentInfoDto.getUserCode();
            srmPatentInfo.setPatentee(this.getPatentees(patentInfoMainDto.getUnitPeronDtoList()));
            QueryWrapper<SrmPatentInfo> srmPatentInfoQueryWrapper=new QueryWrapper<>();
            srmPatentInfoQueryWrapper.eq("name",patentName);
            List<SrmPatentInfo> srmPatentInfos=srmPatentInfoMapper.selectList(srmPatentInfoQueryWrapper);

            if(patentInfoDto.getRowId()==null){
                if(!srmPatentInfos.isEmpty()){
                    throw new ErrorException("-200","专利名称重复");
                }
                Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);

                srmPatentInfo.setCreator(String.valueOf(srmUserRowId));
                srmPatentInfo.setCreateTime(LocalDateTime.now());
            }else{
                if(!srmPatentInfos.isEmpty()){
                    for(SrmPatentInfo srmPatentInfo1 :srmPatentInfos){
                        Long repeatRowId=srmPatentInfo1.getId();
                        if(!Objects.equals(repeatRowId, patentInfoDto.getRowId())){
                            throw new ErrorException("-200","专利名称重复");
                        }
                    }

                }
            }
    
            super.saveOrUpdate(srmPatentInfo);
            RowId=srmPatentInfo.getId();
            // 下面处理作者，以及处理主表第一作者等等
            List<PatentInfoAuthorDto> patentInfoAuthorDtoList=patentInfoMainDto.getPatentInfoAuthorDtoList();
            List<SrmPatentInfoAuthor> srmPatentInfoAuthorList=new ArrayList<>();
            for(PatentInfoAuthorDto patentInfoAuthorDto :patentInfoAuthorDtoList){
                SrmPatentInfoAuthor srmPatentInfoAuthor=new SrmPatentInfoAuthor();
                srmPatentInfoAuthor.setAuthor(patentInfoAuthorDto.getAuthor());
                srmPatentInfoAuthor.setPatentId(RowId);
                srmPatentInfoAuthor.setId(patentInfoAuthorDto.getRowId());
                srmPatentInfoAuthor.setAuthorRanking(patentInfoAuthorDto.getAuthorRanking());
                srmPatentInfoAuthor.setSex(patentInfoAuthorDto.getSex());
                srmPatentInfoAuthor.setNote(patentInfoAuthorDto.getNote());
                srmPatentInfoAuthor.setTitle(patentInfoAuthorDto.getTitle());
                srmPatentInfoAuthor.setEduDegree(patentInfoAuthorDto.getEduDegree());
                srmPatentInfoAuthor.setEduLevel(patentInfoAuthorDto.getEduLevel());
                srmPatentInfoAuthor.setWorkRatio(patentInfoAuthorDto.getWorkRatio());
                srmPatentInfoAuthorList.add(srmPatentInfoAuthor);
            }
            srmPatentInfoAuthorService.saveOrUpdateBatch(srmPatentInfoAuthorList);

        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
        return RowId;
    }
    // 保存专利权人、专利权单位
    public String getPatentees(List<UnitPeronDto> unitPeronDtoList){
        System.out.println(unitPeronDtoList);
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
        System.out.println(patenteesStr);
        return patenteesStr.toString();
    }
    @Override
    public PatentInfoVo getDetail(Long rowId) {
        return srmPatentInfoMapper.getDetail(rowId);
    }

    @Override
    public IPage<PatentInfoVo> listPatentInfo(PatentInfoDto patentInfoDto) {
        String userCode=patentInfoDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        patentInfoDto.setUserId(srmUserRowId);
        Page<PatentInfoVo> page = new Page<>(patentInfoDto.getPage(), patentInfoDto.getRows());
        IPage<PatentInfoVo> res= srmPatentInfoMapper.listPatentInfo(page, patentInfoDto);
        List<PatentInfoVo> records=res.getRecords();
        List<PatentInfoVo> newRecords=new ArrayList<>();
        for(PatentInfoVo patentInfoVo : records){
            PatentInfoVo newRecord=new PatentInfoVo();
            newRecord=patentInfoVo;
            Long rowId=patentInfoVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc(this.patentSysNo,rowId,null);
            newRecord.setCheckList(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }

    @Override
    @Transactional
    public void deletePatentInfo(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                //System.out.println(RowId);
                srmPatentInfoAuthorService.deleteAuthorByParent(RowId);
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
        Boolean allowSumbit=srmUploadInfoService.getFileNessary(String.valueOf(rowId),this.patentSysNo);
        if(!allowSumbit){
            throw new ErrorException("-200","请上传必要的附件！");
        }
        HosUser hosUser = SecurityUtils.getLoginUser();
        String userCode = hosUser.getAccountCode();
        try {
            Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
            PatentInfoVo patentInfoVo=this.getDetail(rowId);
            Integer dataStatus=patentInfoVo.getDataStatus();
            if(dataStatus==null||dataStatus==1){
                throw new ErrorException("-200","已提交");
            }
            srmPatentInfoMapper.updateStatus(rowId,1,"1",null,LocalDateTime.now(),String.valueOf(srmUserRowId));
            srmEafRecService.generateRec(String.valueOf(rowId),this.patentSysNo,userCode,null);

        }catch (Exception e){
            throw new ErrorException("-200","提交失败");
        }
    }

    @Override
    @Transactional
    public void audit(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        HosUser hosUser = SecurityUtils.getLoginUser();
        String userCode = hosUser.getAccountCode();

        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        String sysNo=this.patentSysNo;
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
                srmPatentInfoMapper.updateStatus(rowId,null,resultId,null,null,null);
                srmEafRecService.genAudit(rowId,sysNo,srmUserRowId,resultId,view,null);
            }
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
    }

    @Override
    public IPage<PatentInfoVo> listAuditPatentInfo(PatentInfoDto patentInfoDto) {
        Page<PatentInfoVo> page = new Page<>(patentInfoDto.getPage(), patentInfoDto.getRows());
        String userCode=patentInfoDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        patentInfoDto.setUserId(srmUserRowId);
        Long aa=patentInfoDto.getUserId();
        IPage<PatentInfoVo> res= srmPatentInfoMapper.listAuditPatentInfo(page, patentInfoDto);
        List<PatentInfoVo> records=res.getRecords();
        List<PatentInfoVo> newRecords=new ArrayList<>();
        for(PatentInfoVo patentInfoVo : records){
            PatentInfoVo newRecord=new PatentInfoVo();
            newRecord=patentInfoVo;
            Long rowId=patentInfoVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc(this.patentSysNo,rowId,null);
            newRecord.setCheckList(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }

    @Override
    public List<CombVo> getPatentApply(String userCode) {
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        return srmPatentInfoMapper.getPatentApply(String.valueOf(srmUserRowId));
    }
    @Override
    public List<UnitPeronVo> listPatentee(Long rowId) {
        QueryWrapper<SrmPatentInfo> srmPatentInfoQueryWrapper=new QueryWrapper<>();
        srmPatentInfoQueryWrapper.eq("id",rowId);
        SrmPatentInfo srmPatentInfo=srmPatentInfoMapper.selectOne(srmPatentInfoQueryWrapper);
        String patenteeStr=srmPatentInfo.getPatentee();
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
    @Transactional
    public void deletePatentee(String rowIdStr) {
        System.out.println(rowIdStr);
        try{
            String[] rowArray=rowIdStr.split(",");
            String parref=rowArray[0];
            String unitPersonStr=rowArray[1];
            QueryWrapper<SrmPatentInfo> srmPatentInfoQueryWrapper=new QueryWrapper<>();
            srmPatentInfoQueryWrapper.eq("id",Long.valueOf(parref));
            SrmPatentInfo srmPatentInfo=srmPatentInfoMapper.selectOne(srmPatentInfoQueryWrapper);
            String patenteeStr=srmPatentInfo.getPatentee();
            String[] patenteeArray=patenteeStr.split(",");
            List<String> patenteeList=new ArrayList<>(Arrays.asList(patenteeArray));
            patenteeList.remove(unitPersonStr);
            String newPatenteeStr=String.join(",",patenteeList);
            SrmPatentInfo srmPatentInfo1=new SrmPatentInfo();
            System.out.println(newPatenteeStr);
            System.out.println(parref);
            srmPatentInfo1.setId(Long.valueOf(parref));
            srmPatentInfo1.setPatentee(newPatenteeStr);
            super.saveOrUpdate(srmPatentInfo1);
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }

    }

    @Override
    public List<CombVo> getPatentInfo(String userCode) {
        //Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        return srmPatentInfoMapper.getPatentInfo(null);
    }
}
