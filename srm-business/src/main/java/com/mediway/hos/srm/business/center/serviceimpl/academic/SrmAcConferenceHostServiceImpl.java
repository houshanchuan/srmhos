package com.mediway.hos.srm.business.center.serviceimpl.academic;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mediway.hos.app.core.util.SecurityUtils;
import com.mediway.hos.security.core.userdetails.HosUser;
import com.mediway.hos.srm.business.center.aspect.DataChangeLog;
import com.mediway.hos.srm.business.center.service.baseData.SrmBusinessnoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.mapper.user.SrmUserMapper;
import com.mediway.hos.srm.business.center.model.dto.academic.AcConferenceHostDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.entity.academic.SrmAcConferenceHost;
import com.mediway.hos.srm.business.center.mapper.academic.SrmAcConferenceHostMapper;
import com.mediway.hos.srm.business.center.model.entity.approvalProcess.SrmEafDetail;
import com.mediway.hos.srm.business.center.model.vo.academic.AcConferenceHostVo;
import com.mediway.hos.srm.business.center.service.academic.SrmAcConferenceHostService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.mediway.hos.srm.business.center.service.approvalProcess.SrmEafRecService;
import com.mediway.hos.srm.business.center.service.user.SrmUserService;
import com.mediway.hos.srm.business.center.utils.DateTransform;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 学术会议表(主办) 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmAcConferenceHostServiceImpl extends BaseServiceImpl<SrmAcConferenceHostMapper, SrmAcConferenceHost> implements SrmAcConferenceHostService {
    private final String sysNo="P032";
    private final String tableName="srm_ac_conference_host";
    private final String logTitle="主办会议";
    @Resource
    private SrmAcConferenceHostMapper srmAcConferenceHostMapper;
    @Autowired
    private SrmUserService srmUserService;
    @Resource
    private SrmUserMapper srmUserMapper;
    @Autowired
    private SrmEafRecService srmEafRecService;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    @Override
    @DataChangeLog(sysNo=sysNo,title = logTitle, tableName=tableName)
    public Long saveAcConferenceHost(AcConferenceHostDto acConferenceHostDto) {
        SrmAcConferenceHost srmAcConferenceHost=new SrmAcConferenceHost();
        srmAcConferenceHost.setId(acConferenceHostDto.getRowId());
        srmAcConferenceHost.setOperateTime(LocalDateTime.now());
        srmAcConferenceHost.setName(acConferenceHostDto.getName());
        srmAcConferenceHost.setConferenceType(acConferenceHostDto.getConferenceType());
        srmAcConferenceHost.setYear(acConferenceHostDto.getYear());
        srmAcConferenceHost.setSubject(acConferenceHostDto.getSubject());
        srmAcConferenceHost.setDirection(acConferenceHostDto.getDirection());
        srmAcConferenceHost.setConferenceHead(acConferenceHostDto.getConferenceHead());
        srmAcConferenceHost.setCity(acConferenceHostDto.getCity());
        srmAcConferenceHost.setOutnumOfPeople(acConferenceHostDto.getOutnumOfPeople());
        srmAcConferenceHost.setConferencePhone(acConferenceHostDto.getConferencePhone());
        srmAcConferenceHost.setContactAddress(acConferenceHostDto.getContactAddress());
        srmAcConferenceHost.setNumberOfPeople(acConferenceHostDto.getNumberOfPeople());
        srmAcConferenceHost.setOpenDate(DateTransform.getLocalDateTime(acConferenceHostDto.getOpenDate()));
        srmAcConferenceHost.setCloseDate(DateTransform.getLocalDateTime(acConferenceHostDto.getCloseDate()));
        srmAcConferenceHost.setTravelFlag(acConferenceHostDto.getTravelFlag());
        srmAcConferenceHost.setFapiaoSupplied(acConferenceHostDto.getFapiaoSupplied());
        srmAcConferenceHost.setRemark(acConferenceHostDto.getRemark());
        srmAcConferenceHost.setIntro(acConferenceHostDto.getIntro());
        srmAcConferenceHost.setDeptCode(acConferenceHostDto.getDeptCode());
        srmAcConferenceHost.setHostUnit(acConferenceHostDto.getHostUnit());
        srmAcConferenceHost.setAssistUnit(acConferenceHostDto.getAssistUnit());
        srmAcConferenceHost.setDivisionCode(acConferenceHostDto.getDivisionCode());
        srmAcConferenceHost.setDisciplineClass(acConferenceHostDto.getDisciplineClass());
        srmAcConferenceHost.setDisciplineCode(acConferenceHostDto.getDisciplineCode());
        srmAcConferenceHost.setFundSource(acConferenceHostDto.getFundSource());
        srmAcConferenceHost.setRegisterFeeAmt(acConferenceHostDto.getRegisterFeeAmt());
        srmAcConferenceHost.setBudgetFundsAmt(acConferenceHostDto.getBudgetFundsAmt());
        srmAcConferenceHost.setPaperNum(acConferenceHostDto.getPaperNum());
        srmAcConferenceHost.setRegisterStartDate(DateTransform.getLocalDateTime(acConferenceHostDto.getRegisterStartDate()));
        srmAcConferenceHost.setRegisterEndDate(DateTransform.getLocalDateTime(acConferenceHostDto.getRegisterEndDate()));

        Long rowId=null;
        try{
            if(acConferenceHostDto.getRowId()==null){
                String no=srmBusinessnoService.getBusinessNo(this.sysNo,7,"H");
                srmAcConferenceHost.setNo(no);
                Long srmUserRowId= srmUserService.getUserIdByAccount(null);
                srmAcConferenceHost.setCreateTime(LocalDateTime.now());
                srmAcConferenceHost.setCreatorId(srmUserRowId);
            }
            super.saveOrUpdate(srmAcConferenceHost);
            rowId=srmAcConferenceHost.getId();

        }catch (Exception exception){
            throw new ErrorException("-200",exception.getMessage());
        }
        return rowId;
    }

    @Override
    public AcConferenceHostVo getDetail(Long rowId) {
        return srmAcConferenceHostMapper.getDetail(rowId);
    }

    @Override
    public IPage<AcConferenceHostVo> listAcConferenceHost(AcConferenceHostDto acConferenceHostDto) {
        Long srmUserRowId= srmUserService.getUserIdByAccount(null);
        acConferenceHostDto.setUserId(srmUserRowId);

        Page<AcConferenceHostVo> page = new Page<>(acConferenceHostDto.getPage(), acConferenceHostDto.getRows());
        IPage<AcConferenceHostVo> res= srmAcConferenceHostMapper.listAcConferenceHost(page, acConferenceHostDto);
        List<AcConferenceHostVo> records=res.getRecords();
        List<AcConferenceHostVo> newRecords=new ArrayList<>();
        for(AcConferenceHostVo acConferenceHostVo : records){
            AcConferenceHostVo newRecord=new AcConferenceHostVo();
            newRecord=acConferenceHostVo;
            Long rowId=acConferenceHostVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc("P032",rowId,null);
            newRecord.setChkResultlist(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }

    @Override
    @Transactional
    @DataChangeLog(sysNo=sysNo,title = logTitle, tableName=tableName)
    public void deleteAcConferenceHost(BaseDto baseDto) {
        System.out.println(baseDto);
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                //System.out.println(RowId);
                QueryWrapper<SrmAcConferenceHost> srmAcConferenceHostQueryWrapper=new QueryWrapper<>();
                srmAcConferenceHostQueryWrapper.eq("id",RowId);
                SrmAcConferenceHost srmAcConferenceHost=srmAcConferenceHostMapper.selectOne(srmAcConferenceHostQueryWrapper);
                Integer status=srmAcConferenceHost.getDataStatus();
                if(status==1){
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
            exception.printStackTrace();
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
        String userCode=hosUser.getAccountCode();
        try {
            AcConferenceHostVo acConferenceHostVo=this.getDetail(rowId);
            Integer dataStatus=acConferenceHostVo.getDataStatus();
            if(dataStatus==1){
                throw new ErrorException("-200","已提交");
            }
            srmAcConferenceHostMapper.updateStatus(rowId,1,null);
            //System.out.println(rowId+","+userCode);
            srmEafRecService.generateRec(String.valueOf(rowId),"P032",userCode,null);

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
        Long userId= srmUserMapper.getUserIdByAccount(null);
        String sysNo="P032";
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
                System.out.println(rowId);
                SrmEafDetail srmEafDetail = srmEafRecService.getCheckStatus(sysNo,String.valueOf(rowId));
                String realAuditStatus= srmEafDetail.getAuditPassStatus();
                srmAcConferenceHostMapper.updateStatus(rowId,null,realAuditStatus);
                srmEafRecService.genAudit(rowId,sysNo,userId,resultId,view,null);
            }
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
    }

    @Override
    public IPage<AcConferenceHostVo> listAuditAcConferenceHost(AcConferenceHostDto acConferenceHostDto) {
        String userCode=acConferenceHostDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        acConferenceHostDto.setUserId(srmUserRowId);
        System.out.println(acConferenceHostDto);
        Page<AcConferenceHostVo> page = new Page<>(acConferenceHostDto.getPage(), acConferenceHostDto.getRows());
        IPage<AcConferenceHostVo> res= srmAcConferenceHostMapper.listAuditAcConferenceHost(page, acConferenceHostDto);
        List<AcConferenceHostVo> records=res.getRecords();
        List<AcConferenceHostVo> newRecords=new ArrayList<>();
        for(AcConferenceHostVo acConferenceHostVo : records){
            AcConferenceHostVo newRecord=new AcConferenceHostVo();
            newRecord=acConferenceHostVo;
            Long rowId=acConferenceHostVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc("P032",rowId,null);
            newRecord.setChkResultlist(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }

}
