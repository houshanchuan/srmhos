package com.mediway.hos.srm.business.center.serviceimpl.achvTransformation;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mediway.hos.app.core.util.SecurityUtils;
import com.mediway.hos.security.core.userdetails.HosUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.achvTransformation.AchvTransformationDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.entity.achvTransformation.SrmAchvTransformation;
import com.mediway.hos.srm.business.center.mapper.achvTransformation.SrmAchvTransformationMapper;
import com.mediway.hos.srm.business.center.model.vo.achvTransformation.AchvTransformationVo;
import com.mediway.hos.srm.business.center.service.achvTransformation.SrmAchvTransformationService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.mediway.hos.srm.business.center.service.approvalProcess.SrmEafRecService;
import com.mediway.hos.srm.business.center.service.user.SrmUserService;
import com.mediway.hos.srm.business.center.utils.DateTransform;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 成果转化申请表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmAchvTransformationServiceImpl extends BaseServiceImpl<SrmAchvTransformationMapper, SrmAchvTransformation> implements SrmAchvTransformationService {
    private final String SysNo="P037";
    @Autowired
    private SrmAchvTransformationMapper srmAchvTransformationMapper;
    @Autowired
    private SrmEafRecService srmEafRecService;
    @Autowired
    private SrmUserService srmUserService;
    @Override
    public AchvTransformationVo getDetail(String rowId) {
        return srmAchvTransformationMapper.getDetail(rowId);
    }

    @Override
    @Transactional
    public Long saveAchvTransformation(AchvTransformationDto achvTransformationDto) {
        Long RowId=null;
        SrmAchvTransformation srmAchvTransformation=new SrmAchvTransformation();
        srmAchvTransformation.setSysNo(this.SysNo);
        srmAchvTransformation.setId(achvTransformationDto.getRowId());
        srmAchvTransformation.setTransformDesc(achvTransformationDto.getTransformDesc());
        srmAchvTransformation.setDataStatus(0);
        String userCode=achvTransformationDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        srmAchvTransformation.setAchvHead(achvTransformationDto.getAchvHead());
        srmAchvTransformation.setDeptId(achvTransformationDto.getDeptId());
        srmAchvTransformation.setAchvHeadtel(achvTransformationDto.getAchvHeadtel());
        srmAchvTransformation.setTransformType(achvTransformationDto.getTransformType());
        srmAchvTransformation.setTransformants(achvTransformationDto.getTransformants());
        srmAchvTransformation.setYear(achvTransformationDto.getYear());
        srmAchvTransformation.setSourcePatent(achvTransformationDto.getSourcePatent());
        srmAchvTransformation.setSourceProj(achvTransformationDto.getSourceProj());
        srmAchvTransformation.setRemark(achvTransformationDto.getRemark());
        if(achvTransformationDto.getRowId()==null){
            srmAchvTransformation.setCreateDate(LocalDateTime.now());
            srmAchvTransformation.setCreateUserId(String.valueOf(srmUserRowId));
        }
        srmAchvTransformation.setAgrType(achvTransformationDto.getAgrType());
        srmAchvTransformation.setAgrNo(achvTransformationDto.getAgrNo());
        srmAchvTransformation.setFeeAmt(achvTransformationDto.getFeeAmt());
        srmAchvTransformation.setPayMode(achvTransformationDto.getPayMode());
        srmAchvTransformation.setPartnerUnitProp(achvTransformationDto.getPartnerUnitProp());
        srmAchvTransformation.setAchvUnitProp(achvTransformationDto.getAchvUnitProp());
        srmAchvTransformation.setAgrDate(DateTransform.getLocalDateTime(achvTransformationDto.getAgrDate()));
        srmAchvTransformation.setAgrEndDate(DateTransform.getLocalDateTime(achvTransformationDto.getAgrEndDate()));
        srmAchvTransformation.setPartnerUnit(achvTransformationDto.getPartnerUnit());
        srmAchvTransformation.setPartnerUnitAddr(achvTransformationDto.getPartnerUnitAddr());
        srmAchvTransformation.setPartnerUnitPostcode(achvTransformationDto.getPartnerUnitPostcode());
        srmAchvTransformation.setPartnerUnitTel(achvTransformationDto.getPartnerUnitTel());

        try{
            super.saveOrUpdate(srmAchvTransformation);
            RowId=srmAchvTransformation.getId();


        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
        return RowId;
    }

    @Override
    public IPage<AchvTransformationVo> listAchvTransformation(AchvTransformationDto achvTransformationDto) {
        String userCode=achvTransformationDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        achvTransformationDto.setUserId(srmUserRowId);
        Page<AchvTransformationVo> page = new Page<>(achvTransformationDto.getPage(), achvTransformationDto.getRows());
        IPage<AchvTransformationVo> res= srmAchvTransformationMapper.listAchvTransformation(page, achvTransformationDto);
        List<AchvTransformationVo> records=res.getRecords();
        List<AchvTransformationVo> newRecords=new ArrayList<>();
        for(AchvTransformationVo achvTransformationVo : records){
            AchvTransformationVo newRecord=new AchvTransformationVo();
            newRecord=achvTransformationVo;
            Long rowId=achvTransformationVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc(this.SysNo,rowId,null);
            newRecord.setCheckList(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }

    @Override
    @Transactional
    public void deleteAchvTransformation(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                //System.out.println(RowId);
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
        HosUser hosUser = SecurityUtils.getLoginUser();
        String userCode = hosUser.getAccountCode();
        try {
            AchvTransformationVo achvTransformationVo=this.getDetail(String.valueOf(rowId));
            Integer dataStatus=achvTransformationVo.getDataStatus();
            if(dataStatus==null||dataStatus==1){
                throw new ErrorException("-200","已提交");
            }
            srmAchvTransformationMapper.updateStatus(rowId,1,null);
            srmEafRecService.generateRec(String.valueOf(rowId),this.SysNo,userCode,null);

        }catch (Exception e){
            throw new ErrorException("-200","提交失败");
        }
    }

    @Override
    @Transactional
    public void audit(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();

        Long userId=srmUserService.getUserIdByAccount(null);
        String sysNo=this.SysNo;
        if(userId==null){
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
                //srmPaperMapper.updateStatus(rowId,null,resultId,null);
                srmEafRecService.genAudit(rowId,sysNo,userId,resultId,view,null);
            }
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
    }

    @Override
    public IPage<AchvTransformationVo> listAuditAchvTransformation(AchvTransformationDto achvTransformationDto) {
        Page<AchvTransformationVo> page = new Page<>(achvTransformationDto.getPage(), achvTransformationDto.getRows());
        String userCode=achvTransformationDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        achvTransformationDto.setUserId(srmUserRowId);
        System.out.println(achvTransformationDto);
        IPage<AchvTransformationVo> res= srmAchvTransformationMapper.listAuditAchvTransformation(page, achvTransformationDto);
        List<AchvTransformationVo> records=res.getRecords();
        List<AchvTransformationVo> newRecords=new ArrayList<>();
        for(AchvTransformationVo achvTransformationVo : records){
            AchvTransformationVo newRecord=new AchvTransformationVo();
            newRecord=achvTransformationVo;
            Long rowId=achvTransformationVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc(this.SysNo,rowId,null);
            newRecord.setCheckList(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }
}
