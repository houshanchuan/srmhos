package com.mediway.hos.srm.business.center.serviceimpl.academic;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mediway.hos.app.core.util.SecurityUtils;
import com.mediway.hos.security.core.userdetails.HosUser;
import com.mediway.hos.srm.business.center.aspect.DataChangeLog;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmBusinessno;
import com.mediway.hos.srm.business.center.service.baseData.SrmBusinessnoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.mapper.user.SrmUserMapper;
import com.mediway.hos.srm.business.center.model.dto.academic.AcResearchTrainDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.entity.academic.SrmAcResearchTrain;
import com.mediway.hos.srm.business.center.mapper.academic.SrmAcResearchTrainMapper;
import com.mediway.hos.srm.business.center.model.entity.approvalProcess.SrmEafDetail;
import com.mediway.hos.srm.business.center.model.vo.academic.AcResearchTrainVo;
import com.mediway.hos.srm.business.center.service.academic.SrmAcResearchTrainService;
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
 * 科研培训表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmAcResearchTrainServiceImpl extends BaseServiceImpl<SrmAcResearchTrainMapper, SrmAcResearchTrain> implements SrmAcResearchTrainService {
    private final String sysNo="P043";
    private final String tableName="srm_ac_research_train";
    private final String logTitle="院外培训";
    @Autowired
    private SrmAcResearchTrainMapper srmAcResearchTrainMapper;
    @Autowired
    private SrmUserService srmUserService;
    @Autowired
    private SrmUserMapper srmUserMapper;
    @Autowired
    private SrmEafRecService srmEafRecService;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    @Override
    @DataChangeLog(sysNo=sysNo,title = logTitle, tableName=tableName)
    public Long saveAcResearchTrain(AcResearchTrainDto acResearchTrainDto) {
        SrmAcResearchTrain srmAcResearchTrain=new SrmAcResearchTrain();
        srmAcResearchTrain.setId(acResearchTrainDto.getRowId());
        srmAcResearchTrain.setName(acResearchTrainDto.getName());
        srmAcResearchTrain.setTitle(acResearchTrainDto.getTitle());
        srmAcResearchTrain.setTrainCode(acResearchTrainDto.getTrainCode());
        srmAcResearchTrain.setAddress(acResearchTrainDto.getAddress());
        srmAcResearchTrain.setStartDate(DateTransform.getLocalDateTime(acResearchTrainDto.getStartDate()));
        srmAcResearchTrain.setEndDate(DateTransform.getLocalDateTime(acResearchTrainDto.getEndDate()));
        srmAcResearchTrain.setSponsorUnit(acResearchTrainDto.getSponsorUnit());
        srmAcResearchTrain.setParterId(acResearchTrainDto.getParterId());
        srmAcResearchTrain.setParterDuty(acResearchTrainDto.getParterDuty());
        srmAcResearchTrain.setParterTitle(acResearchTrainDto.getParterTitle());
        srmAcResearchTrain.setParterAccount(acResearchTrainDto.getParterAccount());
        srmAcResearchTrain.setParterDeptId(acResearchTrainDto.getParterDeptId());
        srmAcResearchTrain.setNote(acResearchTrainDto.getNote());
        srmAcResearchTrain.setExpectedStartDate(DateTransform.getLocalDateTime(acResearchTrainDto.getExpectedStartDate()));
        srmAcResearchTrain.setExpectedEndDate(DateTransform.getLocalDateTime(acResearchTrainDto.getExpectedEndDate()));
        srmAcResearchTrain.setTrainNumber(acResearchTrainDto.getTrainNumber());
        srmAcResearchTrain.setTrafficFeeAmt(acResearchTrainDto.getTrafficFeeAmt());
        srmAcResearchTrain.setHotelFeeAmt(acResearchTrainDto.getHotelFeeAmt());
        srmAcResearchTrain.setMaterialFeeAmt(acResearchTrainDto.getMaterialFeeAmt());
        srmAcResearchTrain.setMeetingFeeAmt(acResearchTrainDto.getMeetingFeeAmt());
        srmAcResearchTrain.setOtherFeeAmt(acResearchTrainDto.getOtherFeeAmt());
        srmAcResearchTrain.setFundsAccount(acResearchTrainDto.getFundsAccount());

        srmAcResearchTrain.setSubFlag("0");
        Long rowId=null;
        try{
            if(acResearchTrainDto.getRowId()==null){
                String userCode=acResearchTrainDto.getUserCode();
                Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
                srmAcResearchTrain.setCreateTime(LocalDateTime.now());
                srmAcResearchTrain.setCreator(String.valueOf(srmUserRowId));
                String no=srmBusinessnoService.getBusinessNo(this.sysNo,7,"T");
                srmAcResearchTrain.setTrainCode(no);

            }
            super.saveOrUpdate(srmAcResearchTrain);
            rowId=srmAcResearchTrain.getId();

        }catch (Exception exception){
            throw new ErrorException("-200",exception.getMessage());
        }
        return rowId;
    }

    @Override
    public AcResearchTrainVo getDetail(Long rowId) {
        return srmAcResearchTrainMapper.getDetail(rowId);
    }

    @Override
    public IPage<AcResearchTrainVo> listAcResearchTrain(AcResearchTrainDto acResearchTrainDto) {
        String userCode=acResearchTrainDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        acResearchTrainDto.setUserId(srmUserRowId);
        System.out.println(acResearchTrainDto);
        Page<AcResearchTrainVo> page = new Page<>(acResearchTrainDto.getPage(), acResearchTrainDto.getRows());
        IPage<AcResearchTrainVo> res= srmAcResearchTrainMapper.listAcResearchTrain(page, acResearchTrainDto);
        List<AcResearchTrainVo> records=res.getRecords();
        List<AcResearchTrainVo> newRecords=new ArrayList<>();
        for(AcResearchTrainVo acResearchTrainVo : records){
            AcResearchTrainVo newRecord=new AcResearchTrainVo();
            newRecord=acResearchTrainVo;
            Long rowId=acResearchTrainVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc("P043",rowId,null);
            newRecord.setChkResultlist(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }

    @Override
    @Transactional
    @DataChangeLog(sysNo=sysNo,title = logTitle, tableName=tableName)
    public void deleteAcResearchTrain(BaseDto baseDto) {
        System.out.println(baseDto);
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                //System.out.println(RowId);
                QueryWrapper<SrmAcResearchTrain> srmAcResearchTrainQueryWrapper=new QueryWrapper<>();
                srmAcResearchTrainQueryWrapper.eq("id",RowId);
                SrmAcResearchTrain srmAcResearchTrain=srmAcResearchTrainMapper.selectOne(srmAcResearchTrainQueryWrapper);
                String dataStatus=srmAcResearchTrain.getSubFlag();
                if("1".equals(dataStatus)){
                    throw new ErrorException("-200","已提交不允许删除");
                }
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
        System.out.println(baseDto);
        //提交前先判断是否已经提交
        //提交前判断是否上传必要附件（后置）
        Long rowId=baseDto.getId();
        HosUser hosUser = SecurityUtils.getLoginUser();
        String userCode = hosUser.getAccountCode();
        try {
            System.out.println(rowId);
            AcResearchTrainVo acResearchTrainVo=this.getDetail(rowId);
            System.out.println(acResearchTrainVo);
            String dataStatus=acResearchTrainVo.getSubFlag();
            if("1".equals(dataStatus)){
                throw new ErrorException("-200","已提交");
            }
            srmAcResearchTrainMapper.updateStatus(rowId,1);
            SrmAcResearchTrain acResearchTrain=new SrmAcResearchTrain();
            acResearchTrain.setId(acResearchTrainVo.getRowId());
            Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
            acResearchTrain.setSubFlag("1");
            acResearchTrain.setSubUserId(srmUserRowId.toString());
            acResearchTrain.setSubDate(LocalDateTime.now());
            srmAcResearchTrainMapper.updateById(acResearchTrain);
            //System.out.println(rowId+","+userCode);
            srmEafRecService.generateRec(String.valueOf(rowId),"P043",userCode,null);

        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
    }

    @Override
    @Transactional
    public void audit(BaseDto baseDto) {
        System.out.println(baseDto);
        List<Long> idList=baseDto.getIdList();
        System.out.println(idList);
        Long srmUserRowId= srmUserService.getUserIdByAccount(null);
        String sysNo="P043";
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
                System.out.println(rowId);
                SrmEafDetail srmEafDetail = srmEafRecService.getCheckStatus(sysNo,String.valueOf(rowId));
                String realAuditStatus= srmEafDetail.getAuditPassStatus();
                srmEafRecService.genAudit(rowId,sysNo,srmUserRowId,resultId,view,null);
            }
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
    }

    @Override
    public IPage<AcResearchTrainVo> listAuditAcResearchTrain(AcResearchTrainDto acResearchTrainDto) {
        String userCode=acResearchTrainDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        acResearchTrainDto.setUserId(srmUserRowId);
        System.out.println(acResearchTrainDto);
        Page<AcResearchTrainVo> page = new Page<>(acResearchTrainDto.getPage(), acResearchTrainDto.getRows());
        IPage<AcResearchTrainVo> res= srmAcResearchTrainMapper.listAuditAcResearchTrain(page, acResearchTrainDto);
        List<AcResearchTrainVo> records=res.getRecords();
        List<AcResearchTrainVo> newRecords=new ArrayList<>();
        for(AcResearchTrainVo acResearchTrainVo : records){
            AcResearchTrainVo newRecord=new AcResearchTrainVo();
            newRecord=acResearchTrainVo;
            Long rowId=acResearchTrainVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc("P043",rowId,null);
            newRecord.setChkResultlist(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }
}
