package com.mediway.hos.srm.business.center.serviceimpl.monograph;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mediway.hos.app.core.util.SecurityUtils;
import com.mediway.hos.security.core.userdetails.HosUser;
import com.mediway.hos.srm.business.center.service.approvalProcess.SrmEafRecService;
import com.mediway.hos.srm.business.center.service.baseData.SrmUploadInfoService;
import com.mediway.hos.srm.business.center.service.monograph.SrmMonographInfoAuthorService;
import com.mediway.hos.srm.business.center.service.monograph.SrmMonographInfoService;
import com.mediway.hos.srm.business.center.service.user.SrmUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.monograph.MonographAuthorDto;
import com.mediway.hos.srm.business.center.model.dto.monograph.MonographDetailDto;
import com.mediway.hos.srm.business.center.model.dto.monograph.MonographDto;
import com.mediway.hos.srm.business.center.model.entity.monograph.SrmMonographInfo;
import com.mediway.hos.srm.business.center.mapper.monograph.SrmMonographInfoMapper;
import com.mediway.hos.srm.business.center.model.entity.monograph.SrmMonographInfoAuthor;
import com.mediway.hos.srm.business.center.model.vo.monograph.MonographAuthorVo;
import com.mediway.hos.srm.business.center.model.vo.monograph.MonographVo;
import com.mediway.hos.srm.business.center.model.vo.user.UserVo;

import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.mediway.hos.srm.business.center.utils.DateTransform;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 著作信息表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-25
 */
@Service
public class SrmMonographInfoServiceImpl extends BaseServiceImpl<SrmMonographInfoMapper, SrmMonographInfo> implements SrmMonographInfoService {
    private final String monographSysNo="P004";
    @Autowired
    private SrmMonographInfoAuthorService srmMonographInfoAuthorService;
    @Autowired
    private SrmMonographInfoMapper srmMonographInfoMapper;
    @Autowired
    private SrmEafRecService srmEafRecService;
    @Autowired
    private SrmUserService srmUserService;
    @Autowired
    private SrmUploadInfoService srmUploadInfoService;
    @Override
    @Transactional
    public Long saveOrUpdateMon(MonographDto monographDto) {
        MonographDetailDto monographDetailDto=monographDto.getMonographDetailDto();
        SrmMonographInfo monographInfo=new SrmMonographInfo();
        monographInfo.setId(monographDetailDto.getRowId());
        monographInfo.setYear(monographDetailDto.getYearField());
        monographInfo.setName(monographDetailDto.getNameField());
        monographInfo.setDeptId(monographDetailDto.getDeptLocField());
        monographInfo.setWorkType(monographDetailDto.getUnittypeField());
        String pubTime=monographDetailDto.getPubTime();
        monographInfo.setSysNo(this.monographSysNo);
        monographInfo.setIsbn(monographDetailDto.getIsbn());
        monographInfo.setClassCode(monographDetailDto.getSubjectCatField());
        monographInfo.setPubAddressType(monographDetailDto.getPubPlaceField());
        monographInfo.setCip(monographDetailDto.getCip());
        monographInfo.setDiscipline(monographDetailDto.getFirstSubjectField());
        monographInfo.setPress(monographDetailDto.getPressField());
        monographInfo.setDisciplineTwo(monographDetailDto.getSecSubjectField());
        monographInfo.setPubLevel(monographDetailDto.getPressLevel());
        monographInfo.setLanguage(monographDetailDto.getLanguageField());
        monographInfo.setDisciplineThree(monographDetailDto.getThirdSubjectField());
        monographInfo.setIsFirstAuthor(monographDetailDto.getCompleteUnit());
        monographInfo.setProjsourceCode(monographDetailDto.getProjectSource());
        monographInfo.setPublishFreq(monographDetailDto.getPublishFreqField());
        monographInfo.setSchoolSign(monographDetailDto.getHospsignature());
        monographInfo.setTotalWordsNum(monographDetailDto.getTotalNum());
        monographInfo.setIsTranslated(monographDetailDto.getTransferFlag());
        monographInfo.setNote(monographDetailDto.getRemarkField());
        monographInfo.setPrintNum(monographDetailDto.getPrintNum());
        String isbn=monographDetailDto.getIsbn();
        if(monographDetailDto.getRowId()==null){

            if(isbn!=null&& !isbn.isEmpty()){
                QueryWrapper<SrmMonographInfo> srmMonographInfoQueryWrapper=new QueryWrapper<>();
                srmMonographInfoQueryWrapper.eq("isbn",isbn);
                List<SrmMonographInfo> srmMonographInfos=srmMonographInfoMapper.selectList(srmMonographInfoQueryWrapper);
                if(!srmMonographInfos.isEmpty()){
                    throw new ErrorException("-200","isbn书号重复");
                }
            }

            String userCode=monographDetailDto.getUserCode();
            Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
            monographInfo.setSubDate(LocalDateTime.now());
            monographInfo.setSubUserId(String.valueOf(srmUserRowId));
        }else{
            if(isbn!=null&& !isbn.isEmpty()){
                QueryWrapper<SrmMonographInfo> srmMonographInfoQueryWrapper=new QueryWrapper<>();
                srmMonographInfoQueryWrapper.eq("isbn",isbn);
                List<SrmMonographInfo> srmMonographInfos=srmMonographInfoMapper.selectList(srmMonographInfoQueryWrapper);

                if(!srmMonographInfos.isEmpty()){
                    for(SrmMonographInfo srmMonographInfo :srmMonographInfos){
                        Long repeatRowId=srmMonographInfo.getId();
                        if(!Objects.equals(repeatRowId, monographDetailDto.getRowId())){
                            throw new ErrorException("-200","isbn书号重复");
                        }
                    }

                }
            }
        }
        monographInfo.setDataStatus(0);
        Long RowId=null;
        //判断名称是否重复

        try{
            String userCode=monographDetailDto.getUserCode();
            Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
            monographInfo.setSubUserId(String.valueOf(srmUserRowId));
            monographInfo.setSubDate(LocalDateTime.now());
            LocalDateTime localPubTime= DateTransform.getLocalDateTime(pubTime);
            monographInfo.setPublishTime(localPubTime);
            super.saveOrUpdate(monographInfo);
            RowId=monographInfo.getId();
            List<MonographAuthorDto> monographAuthorDtos=monographDto.getMonographAuthors();

            List<SrmMonographInfoAuthor> monographInfoAuthorList=new ArrayList<>();
            for (MonographAuthorDto monographAuthorDto :monographAuthorDtos){
                SrmMonographInfoAuthor monographInfoAuthor=new SrmMonographInfoAuthor();
                monographInfoAuthor.setMonographId(RowId);
                monographInfoAuthor.setId(monographAuthorDto.getRowId());
                monographInfoAuthor.setAuthorId(monographAuthorDto.getAuthorrowid());
                UserVo userVo = srmUserService.getUserDetail(monographAuthorDto.getAuthorrowid(),null);
                String userType=userVo.getPersonTypeCode();
                monographInfoAuthor.setAuthorName(monographAuthorDto.getAuthorname());
                monographInfoAuthor.setEditorType(monographAuthorDto.getIsthehosrowid());
                monographInfoAuthor.setTitle(monographAuthorDto.getTitle());
                monographInfoAuthor.setEduLevel(monographAuthorDto.getEduLevel());
                monographInfoAuthor.setEduDegree(monographAuthorDto.getEduDegree());
                monographInfoAuthor.setRanking(monographAuthorDto.getRangerowid());
                monographInfoAuthor.setNote(monographAuthorDto.getRemark2());
                monographInfoAuthor.setAuthorType(userType);
                monographInfoAuthorList.add(monographInfoAuthor);
            }
            srmMonographInfoAuthorService.saveOrUpdateBatch(monographInfoAuthorList);
        }catch (Exception exception){
            throw new ErrorException("-200",exception.getMessage());
        }
        return RowId;
    }
    @Override
    public MonographVo getDetail(Long RowId) {
        return srmMonographInfoMapper.getDetail(RowId);
    }

    @Override
    public IPage<MonographVo> listMonograph(MonographDetailDto monographDetailDto) {
        /*
        List<Long> authorIds=null;
        if(!monographDetailDto.getEditor().isEmpty()){
            authorIds=monographInfoAuthorService.getIdByMon(null);
        }
        */
        String userCode=monographDetailDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        monographDetailDto.setUserId(srmUserRowId);
        System.out.println(monographDetailDto);
        Page<MonographVo> page = new Page<>(monographDetailDto.getPage(), monographDetailDto.getRows());
        IPage<MonographVo> res= srmMonographInfoMapper.listMonographInfo(page, monographDetailDto);
        List<MonographVo> records=res.getRecords();
        List<MonographVo> newRecords=new ArrayList<>();
        for(MonographVo monographVo : records){
            MonographVo newRecord=new MonographVo();
            newRecord=monographVo;
            Long rowId=monographVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc(this.monographSysNo,rowId,null);
            newRecord.setCheckList(checkListName);

            List<MonographAuthorVo> monographAuthorVos= srmMonographInfoAuthorService.ListMonographAuthor(rowId);
            StringBuilder authorNames=new StringBuilder();
            for (MonographAuthorVo monographAuthorVo : monographAuthorVos){
                String authorName=monographAuthorVo.getAuthorname();
                if(authorNames.length() == 0){
                    authorNames = authorNames.append(authorName);
                }else{
                    authorNames.append(",").append(authorName);
                }
            }
            newRecord.setAuthorNameList(authorNames.toString());
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }
    @Override
    @Transactional
    public void deleteMonograph(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                //System.out.println(RowId);
                srmMonographInfoAuthorService.deleteAuthorByMon(RowId);
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
        Boolean allowSumbit=srmUploadInfoService.getFileNessary(String.valueOf(rowId),this.monographSysNo);
        if(!allowSumbit){
            throw new ErrorException("-200","请上传必要的附件！");
        }
        HosUser hosUser = SecurityUtils.getLoginUser();
        String userCode = hosUser.getAccountCode();
        Long userId=srmUserService.getUserIdByAccount(userCode);
        try {
            MonographVo monographVo=this.getDetail(rowId);
            Integer dataStatus=monographVo.getDataStatus();
            if(dataStatus==1){
                throw new ErrorException("-200","已提交");
            }
            this.updateStatus(rowId,1,"1",LocalDate.now(),userId);
            srmEafRecService.generateRec(String.valueOf(rowId),this.monographSysNo,userCode,null);

        }catch (Exception e){
            e.printStackTrace();
            throw new ErrorException("-200",e.getMessage());
        }


    }

    @Override
    public Long getIdByName(String name) {
        return srmMonographInfoMapper.getIdByName(name);
    }
    public void updateStatus(Long rowId, int status, String checkStatus, LocalDate subDate, Long userId){
        srmMonographInfoMapper.updateStatus(rowId,status,null,null,subDate,userId);
    }

    @Override
    public IPage<MonographVo> listAuditMonographInfo(MonographDetailDto monographDetailDto) {
        Page<MonographVo> page = new Page<>(monographDetailDto.getPage(), monographDetailDto.getRows());
        String userCode=monographDetailDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        monographDetailDto.setUserId(srmUserRowId);
        IPage<MonographVo> res= srmMonographInfoMapper.listAuditMonographInfo(page, monographDetailDto);
        List<MonographVo> records=res.getRecords();
        List<MonographVo> newRecords=new ArrayList<>();
        for(MonographVo monographVo : records){
            MonographVo newRecord=new MonographVo();
            newRecord=monographVo;
            Long rowId=monographVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc(this.monographSysNo,rowId,null);
            newRecord.setCheckList(checkListName);
            List<MonographAuthorVo> monographAuthorVos= srmMonographInfoAuthorService.ListMonographAuthor(rowId);
            StringBuilder authorNames=new StringBuilder();
            for (MonographAuthorVo monographAuthorVo : monographAuthorVos){
                String authorName=monographAuthorVo.getAuthorname();
                if(authorNames.length() == 0){
                    authorNames = authorNames.append(authorName);
                }else{
                    authorNames.append(",").append(authorName);
                }
            }
            newRecord.setAuthorNameList(authorNames.toString());
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }

    @Transactional
    @Override
    public void audit(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        Long srmUserRowId= srmUserService.getUserIdByAccount(null);
        String sysNo=this.monographSysNo;
        if(srmUserRowId==null){
            throw new ErrorException("-200","当前登录用户不存在!");
        }
        String view=baseDto.getView();
        try{
            for(Long rowId : idList){
                srmMonographInfoMapper.updateStatus(rowId,null,"2",null,LocalDate.now(),srmUserRowId);
                srmEafRecService.genAudit(rowId,sysNo,srmUserRowId,"2",view,null);
            }
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }

    }

    @Transactional
    @Override
    public void noaudit(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();

        Long srmUserRowId= srmUserService.getUserIdByAccount(null);
        String sysNo=this.monographSysNo;
        if(srmUserRowId==null){
            throw new ErrorException("-200","当前登录用户不存在!");
        }
        String view=baseDto.getView();
        try{
            for(Long rowId : idList){
                // SrmEafDetail srmEafDetail = srmEafRecService.getCheckStatus(sysNo,String.valueOf(rowId));
                // String auditStatus= srmEafDetail.getAuditNopassStatus();
                srmMonographInfoMapper.updateStatus(rowId,null,"3",null,LocalDate.now(),srmUserRowId);
                srmEafRecService.genNoAudit(rowId,sysNo,srmUserRowId,"3",view);
            }
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
    }
}
