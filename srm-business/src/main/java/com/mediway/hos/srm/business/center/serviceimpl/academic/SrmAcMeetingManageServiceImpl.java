package com.mediway.hos.srm.business.center.serviceimpl.academic;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import com.mediway.hos.app.core.util.SecurityUtils;
import com.mediway.hos.security.core.userdetails.HosUser;
import com.mediway.hos.srm.business.center.aspect.DataChangeLog;
import com.mediway.hos.srm.business.center.mapper.user.SrmUserMapper;
import com.mediway.hos.srm.business.center.model.entity.approvalProcess.SrmEafDetail;
import com.mediway.hos.srm.business.center.model.vo.academic.AcLectureVo;
import com.mediway.hos.srm.business.center.service.approvalProcess.SrmEafRecService;
import com.mediway.hos.srm.business.center.service.user.SrmUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.academic.AcMeetingManageDto;
import com.mediway.hos.srm.business.center.model.vo.academic.AcMeetingManageVo;
import com.mediway.hos.srm.business.center.model.entity.academic.SrmAcMeetingManage;
import com.mediway.hos.srm.business.center.service.academic.SrmAcMeetingManageService;
import com.mediway.hos.srm.business.center.mapper.academic.SrmAcMeetingManageMapper;
import com.mediway.hos.srm.business.center.model.dto.baseData.AcBaseDto;
import com.mediway.hos.srm.business.center.utils.DateTransform;

/**
 * <p>
 * 参加会议信息表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmAcMeetingManageServiceImpl extends BaseServiceImpl<SrmAcMeetingManageMapper, SrmAcMeetingManage> implements SrmAcMeetingManageService {
    private final String sysNo="P031";
    private final String tableName="srm_ac_meeting_manage";
    private final String logTitle="外出会议";
    @Autowired
    private SrmAcMeetingManageMapper srmAcMeetingManageMapper;
    @Autowired
    private SrmUserService srmUserService;
    @Autowired
    private SrmUserMapper srmUserMapper;
    @Autowired
    private SrmEafRecService srmEafRecService;

    @Override
    @Transactional
    @DataChangeLog(sysNo=sysNo,title = logTitle, tableName=tableName)
    public Long saveOrUpdateAcMeetingManage(AcMeetingManageDto acMeetingManageDto) {
        SrmAcMeetingManage srmAcMeetingManage = new SrmAcMeetingManage();
        srmAcMeetingManage.setId(acMeetingManageDto.getRowId());
        srmAcMeetingManage.setSysNo(this.sysNo);
        srmAcMeetingManage.setMeetingCode(acMeetingManageDto.getMeetingCode() );//会议编号
        srmAcMeetingManage.setMeetingName(acMeetingManageDto.getMeetingName()); //会议名称
        srmAcMeetingManage.setMeetingDate(DateTransform.getLocalDateTime(acMeetingManageDto.getMeetingDate()));   //会议时间
        srmAcMeetingManage.setMeetingPlace(acMeetingManageDto.getMeetingPlace() );   //会议地点
        srmAcMeetingManage.setParticipants(acMeetingManageDto.getParticipants() );   //参与人员
        srmAcMeetingManage.setIsSpeech(acMeetingManageDto.getIsSpeech() );  //是否大会发言
        srmAcMeetingManage.setMeetingPosition(acMeetingManageDto.getMeetingPosition());
        srmAcMeetingManage.setMeetingPhone(acMeetingManageDto.getMeetingPhone() );  //联系电话
        srmAcMeetingManage.setMeetingEmail(acMeetingManageDto.getMeetingEmail() );   // 联系邮箱
        srmAcMeetingManage.setDeptId(acMeetingManageDto.getDeptId() ); //科室
        srmAcMeetingManage.setNote(acMeetingManageDto.getNote() ); //备注
        srmAcMeetingManage.setProjId(acMeetingManageDto.getProjId() );   //依托项目(acMeetingManageDto.get );
        srmAcMeetingManage.setSubUserId(acMeetingManageDto.getSubUserId() );  //提交人
        srmAcMeetingManage.setSubDate(DateTransform.getLocalDateTime(acMeetingManageDto.getSubDate()));
        srmAcMeetingManage.setDataStatus(acMeetingManageDto.getDataStatus() );  //提交结果
        srmAcMeetingManage.setChkResult(acMeetingManageDto.getChkResult());   //审核结果;
        srmAcMeetingManage.setChkUserId(acMeetingManageDto.getChkUserId() );  // 审核人
        //srmAcMeetingManage.setChkDate(getLocalDateTime(acMeetingManageDto.getChkDate())); //审核日期
        //srmAcMeetingManage.setChkTime(acMeetingManageDto.getChkTime() ); //审核时间
        //srmAcMeetingManage.setChkView(acMeetingManageDto.getChkView() ); //审核意见
        srmAcMeetingManage.setSpeechTopic(acMeetingManageDto.getSpeechTopic() );  //发言题目
        srmAcMeetingManage.setReasonForNoSpeech(acMeetingManageDto.getReasonForNoSpeech() );  //未发言原因
        srmAcMeetingManage.setOfficeRecLeave(acMeetingManageDto.getOfficeRecLeave() );   //院办中层备案
        srmAcMeetingManage.setHrAuditLeave(acMeetingManageDto.getHrAuditLeave() ); //人事审批
        srmAcMeetingManage.setIsOfficTicket(acMeetingManageDto.getIsOfficTicket() );   //是否购买公务机票

        srmAcMeetingManage.setMeetingEndDate(DateTransform.getLocalDateTime(acMeetingManageDto.getMeetingEndDate()));  //会议结束日期
        srmAcMeetingManage.setRelyUnit(acMeetingManageDto.getRelyUnit() ); //主办单位
        srmAcMeetingManage.setMeetingType(acMeetingManageDto.getMeetingType() ); //会议类型
        srmAcMeetingManage.setCreateUserId(acMeetingManageDto.getCreateUserId() );//创建人
        if (acMeetingManageDto.getRowId()==null) {
            Long srmUserRowId= srmUserService.getUserIdByAccount(null);
            srmAcMeetingManage.setCreateUserId(String.valueOf(srmUserRowId));
            srmAcMeetingManage.setCreateDate(LocalDateTime.now()); //创建日期
        }
        srmAcMeetingManage.setDivisionCode(acMeetingManageDto.getDivisionCode() ); //教研室编号
        srmAcMeetingManage.setClassCode(acMeetingManageDto.getClassCode() ); //学科门类
        srmAcMeetingManage.setPaperName(acMeetingManageDto.getPaperName() );  //论文题目
        srmAcMeetingManage.setReportName(acMeetingManageDto.getReportName() );//报告题目
        srmAcMeetingManage.setIntro(acMeetingManageDto.getIntro() );   //介绍
        srmAcMeetingManage.setOperateTime(LocalDateTime.now());  //操作时间
        srmAcMeetingManage.setFileIds(acMeetingManageDto.getFileIds() ); //附件ID
        srmAcMeetingManage.setTimesThisYear(acMeetingManageDto.getTimesThisYear() );  // 会议次数
        srmAcMeetingManage.setAccountCode(acMeetingManageDto.getAccountCode() );  // 工号
        srmAcMeetingManage.setTitle(acMeetingManageDto.getTitle() ); //职称
        srmAcMeetingManage.setDutyDesc(acMeetingManageDto.getDutyDesc() ); //职务名称
        srmAcMeetingManage.setParttimeDesc(acMeetingManageDto.getParttimeDesc() );// 兼职职务名称

        srmAcMeetingManage.setExpectedBeginDate(DateTransform.getLocalDateTime(acMeetingManageDto.getExpectedBeginDate()));  //预计起始日期
        srmAcMeetingManage.setExpectedEndDate(DateTransform.getLocalDateTime(acMeetingManageDto.getExpectedEndDate()));// 预计结束日期
        srmAcMeetingManage.setTrvlBeginDate(DateTransform.getLocalDateTime(acMeetingManageDto.getTrvlBeginDate()));  // 差旅起始日期
        srmAcMeetingManage.setTrvlEndDate(DateTransform.getLocalDateTime(acMeetingManageDto.getTrvlEndDate())); // 差旅结束日期
        srmAcMeetingManage.setOtherPositionDesc(acMeetingManageDto.getOtherPositionDesc() ); // 其他参会身份
        srmAcMeetingManage.setMeetingFeeAmt(acMeetingManageDto.getMeetingFeeAmt() ); // 会务费
        srmAcMeetingManage.setMaterialsFeeAmt(acMeetingManageDto.getMaterialsFeeAmt() );  // 资料费
        srmAcMeetingManage.setHotelFeeAmt(acMeetingManageDto.getHotelFeeAmt() );//  住宿费
        srmAcMeetingManage.setTrafficFeeAmt(acMeetingManageDto.getTrafficFeeAmt() );  //交通费
        srmAcMeetingManage.setOtherFeeAmt(acMeetingManageDto.getOtherFeeAmt() );  //其他费用
        srmAcMeetingManage.setFundAccount(acMeetingManageDto.getFundAccount() );// 资助经费账号
        srmAcMeetingManage.setCreatorName(acMeetingManageDto.getCreatorName() );//创建人姓名
        //srmAcMeetingManage.setCheckStatus(acMeetingManageDto.getCheckStatus() );   //审核状态
        srmAcMeetingManage.setRelyUnitName(acMeetingManageDto.getRelyUnitName() ); //主办单位名称
        super.saveOrUpdate(srmAcMeetingManage);
        return srmAcMeetingManage.getId();
    }
    @Override
    public AcMeetingManageVo getDetailAcMeetingManage(Long RowId) {
         return srmAcMeetingManageMapper.getDetailAcMeetingManage(RowId);
    }

    @Override
    public IPage<AcMeetingManageVo> listAcMeetingManage(AcMeetingManageDto acMeetingManageDto) {

       // String userCode=acMeetingManageDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(null);
        acMeetingManageDto.setUserId(String.valueOf(srmUserRowId));

        Page<AcMeetingManageVo> page = new Page<>(acMeetingManageDto.getPage(), acMeetingManageDto.getRows());
        IPage<AcMeetingManageVo> res= srmAcMeetingManageMapper.listAcMeetingManage(page, acMeetingManageDto);
        List<AcMeetingManageVo> records=res.getRecords();
        List<AcMeetingManageVo> newRecords=new ArrayList<>();
        for(AcMeetingManageVo acMeetingManageVo : records){
            AcMeetingManageVo newRecord=new AcMeetingManageVo();
            newRecord=acMeetingManageVo;
            Long rowId=acMeetingManageVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc(this.sysNo,rowId,null);
            newRecord.setChkResultlist(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }

    @Override
    @DataChangeLog(sysNo=sysNo,title = logTitle, tableName=tableName)
    public void deleteAcMeetingManage(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                //System.out.println(RowId);
                if(StringUtils.isEmpty(idStr)){
                    idStr=String.valueOf(RowId);
                }else{
                    idStr=idStr+""+String.valueOf(RowId);
                }
            }
            super.deleteByIds(idStr);
        }catch (Exception exception){
            throw  new ErrorException("-200",exception.getMessage());
        }
    }

    @Override
    @Transactional
    public void submitAcMeetingManage(BaseDto baseDto){
        Long rowId=baseDto.getId();
        HosUser hosUser = SecurityUtils.getLoginUser();
        String userCode = hosUser.getAccountCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(null);
        try {
            SrmAcMeetingManage srmAcMeetingManage=this.selectById(rowId);

            int dataStatus=srmAcMeetingManage.getDataStatus();
            if(dataStatus==1){
                throw new ErrorException("-200","已提交");
            }
            srmAcMeetingManage.setSubUserId(srmUserRowId.toString());
            srmAcMeetingManage.setSubDate(LocalDateTime.now());
            srmAcMeetingManage.setDataStatus(1);
            srmAcMeetingManageMapper.updateById(srmAcMeetingManage);
            //srmAcMeetingManageMapper.updateStatus(rowId,1,srmUserRowId,null);
            //System.out.println(rowId+","+userCode);
            srmEafRecService.generateRec(String.valueOf(rowId),this.sysNo,userCode,null);

        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
    }


    @Override
    public void audit(BaseDto baseDto)   {
        System.out.println(baseDto);
        System.out.println(11111);
        List<Long> idList=baseDto.getIdList();
        System.out.println(idList);
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
                System.out.println(rowId);
                SrmEafDetail srmEafDetail = srmEafRecService.getCheckStatus(sysNo,String.valueOf(rowId));
                System.out.println(33333);
                String realAuditStatus= srmEafDetail.getAuditPassStatus();
                srmAcMeetingManageMapper.updateStatus(rowId,null,realAuditStatus);
                srmEafRecService.genAudit(rowId,sysNo,srmUserRowId,resultId,view,null);
            }
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
    };

    @Override
    public IPage<AcMeetingManageVo> listAcMeetingManageForAudit(AcMeetingManageDto acMeetingManageDto) {

        //String userCode=acMeetingManageDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(null);
        acMeetingManageDto.setUserId(String.valueOf(srmUserRowId));
        System.out.println(acMeetingManageDto);
        Page<AcMeetingManageVo> page = new Page<>(acMeetingManageDto.getPage(), acMeetingManageDto.getRows());
        IPage<AcMeetingManageVo> res= srmAcMeetingManageMapper.listAcMeetingManageForAudit(page, acMeetingManageDto);
        List<AcMeetingManageVo> records=res.getRecords();
        List<AcMeetingManageVo> newRecords=new ArrayList<>();
        for(AcMeetingManageVo acMeetingManageVo : records){
            AcMeetingManageVo newRecord=new AcMeetingManageVo();
            newRecord=acMeetingManageVo;
            Long rowId=acMeetingManageVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc(this.sysNo,rowId,null);
            newRecord.setChkResultlist(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }


}
