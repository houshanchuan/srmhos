package com.mediway.hos.srm.business.center.serviceimpl.approvalProcess;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mediway.hos.srm.business.center.mapper.academic.*;
import com.mediway.hos.srm.business.center.mapper.app.SrmAppMessageMapper;
import com.mediway.hos.srm.business.center.mapper.award.SrmAwardApplyMapper;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmAchievementMapper;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmCommitteeInfoMapper;
import com.mediway.hos.srm.business.center.mapper.monograph.SrmMonographInfoMapper;
import com.mediway.hos.srm.business.center.mapper.paper.SrmPaperMapper;
import com.mediway.hos.srm.business.center.mapper.paper.SrmPaperSubmissionApplyMapper;
import com.mediway.hos.srm.business.center.mapper.patent.SrmPatentApplyMapper;
import com.mediway.hos.srm.business.center.mapper.patent.SrmPatentInfoMapper;
import com.mediway.hos.srm.business.center.mapper.project.SrmProjectFinalcheckMapper;
import com.mediway.hos.srm.business.center.mapper.project.SrmProjectMidcheckMapper;
import com.mediway.hos.srm.business.center.mapper.project.SrmProjectsInfoMapper;
import com.mediway.hos.srm.business.center.mapper.projectapply.SrmProjectSolicitMapper;
import com.mediway.hos.srm.business.center.model.entity.academic.*;
import com.mediway.hos.srm.business.center.model.entity.app.SrmAppMessage;
import com.mediway.hos.srm.business.center.model.entity.award.SrmAchievement;
import com.mediway.hos.srm.business.center.model.entity.award.SrmAwardApply;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmCommitteeInfo;
import com.mediway.hos.srm.business.center.model.entity.monograph.SrmMonographInfo;
import com.mediway.hos.srm.business.center.model.entity.paper.SrmPaper;
import com.mediway.hos.srm.business.center.model.entity.paper.SrmPaperSubmissionApply;
import com.mediway.hos.srm.business.center.model.entity.patent.SrmPatentApply;
import com.mediway.hos.srm.business.center.model.entity.patent.SrmPatentInfo;
import com.mediway.hos.srm.business.center.model.entity.project.SrmProjectFinalcheck;
import com.mediway.hos.srm.business.center.model.entity.project.SrmProjectMidcheck;
import com.mediway.hos.srm.business.center.model.entity.project.SrmProjectsInfo;
import com.mediway.hos.srm.business.center.model.entity.projectapply.SrmProjectSolicit;
import com.mediway.hos.srm.business.center.model.entity.user.SrmUser;
import com.mediway.hos.srm.business.center.model.vo.approvalProcess.EafDetailVo;
import com.mediway.hos.srm.business.center.model.vo.approvalProcess.EafRecVo;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.vo.dept.DeptUserVo;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperVo;
import com.mediway.hos.srm.business.center.model.vo.user.UserVo;
import com.mediway.hos.srm.business.center.service.academic.SrmAcConferenceHostService;
import com.mediway.hos.srm.business.center.service.academic.SrmAcLectureService;
import com.mediway.hos.srm.business.center.service.app.SrmAppMessageService;
import com.mediway.hos.srm.business.center.service.approvalProcess.SrmEafDetailService;
import com.mediway.hos.srm.business.center.service.approvalProcess.SrmEafFlowService;
import com.mediway.hos.srm.business.center.service.approvalProcess.SrmEafRecLogService;
import com.mediway.hos.srm.business.center.service.approvalProcess.SrmEafRecService;
import com.mediway.hos.srm.business.center.service.dept.SrmDeptUserService;
import com.mediway.hos.srm.business.center.service.paper.SrmPaperService;
import com.mediway.hos.srm.business.center.service.project.SrmProjectFinalcheckService;
import com.mediway.hos.srm.business.center.service.project.SrmProjectMidcheckService;
import com.mediway.hos.srm.business.center.service.project.SrmProjectsInfoService;
import com.mediway.hos.srm.business.center.service.projectapply.SrmProjectSolicitService;
import com.mediway.hos.srm.business.center.service.user.SrmUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.approvalProcess.EafRecDto;
import com.mediway.hos.srm.business.center.model.entity.approvalProcess.SrmEafDetail;
import com.mediway.hos.srm.business.center.model.entity.approvalProcess.SrmEafRec;
import com.mediway.hos.srm.business.center.mapper.approvalProcess.SrmEafRecMapper;

import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

/**
 * <p>
 * 审批记录 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-08-21
 */
@Service
public class SrmEafRecServiceImpl extends BaseServiceImpl<SrmEafRecMapper, SrmEafRec> implements SrmEafRecService {
    @Autowired
    private SrmEafRecMapper srmEafRecMapper;
    @Autowired
    private SrmUserService srmUserService;
    @Autowired
    private SrmEafFlowService srmEafFlowService;
    @Autowired
    private SrmPaperService srmPaperService;
    @Autowired
    private SrmEafDetailService srmEafDetailService;
    @Autowired
    private SrmDeptUserService srmDeptUserService;
    @Autowired
    private SrmEafRecLogService srmEafRecLogService;
    @Autowired
    private SrmAppMessageService srmAppMessageService;
    @Autowired
    private SrmAppMessageMapper srmAppMessageMapper;

    @Override
    public void deleteRec(String sysNo, String rowId) {
        srmEafRecMapper.deleteRec(sysNo,rowId);
    }
    /*
        提交时，生成审批流
    **/
    @Override
    public void generateRec(String rowId, String sysNo, String userCode, String defaultDeptDr) {
        String type="1";
        if(userCode==null){
            throw new RuntimeException("人员不存在");
        }
        Long srmUserRowId= srmUserService.getUserIdByAccount(null);
        this.deleteRec(sysNo,rowId);
        srmAppMessageService.updateMessage(sysNo,rowId);
        String flowMainDr= srmEafFlowService.getEafFlow(sysNo,type);
        if (flowMainDr==null||flowMainDr.isEmpty()){
            throw new RuntimeException("审批流程不存在");
        }
        // 广安门特殊流程需要配置，后期补充
        if("IFUSEGAM".equals("1")&&"P001".equals(sysNo)){
            PaperVo paperVo= srmPaperService.getDetail(rowId);
            CombVo reimburseWayComb=paperVo.getReimWay();
            String reimburseWay=reimburseWayComb.getId();
            UserVo userVo= srmUserService.getUserDetail(null,userCode);
            if(userVo.getRowId()==null){
                throw  new RuntimeException("当前用户不存在");
            }
            String userTypeCode=userVo.getPersonTypeAlias();
            if(reimburseWay.equals("2")){
                if(userTypeCode.equals("GradUser")){
                    //学生课题报销
                    flowMainDr="7";
                }else{
                    //职工课题报销
                    flowMainDr="6";
                }
            }else{
                if(userTypeCode.equals("GradUser")){
                    //学生医院报销
                    flowMainDr="5";
                }else{
                    //职工医院报销
                    flowMainDr="3";
                }
            }
        }
        /*组织消息推送的内容
         后面补充
         * */
        Long FirstDetailId=null;
        List<EafDetailVo> eafDetailVos= srmEafDetailService.listDetail(Long.valueOf(flowMainDr));
        for (EafDetailVo eafDetailVo: eafDetailVos){
            Long chkdetailrowid=eafDetailVo.getId();
            Integer stepno=eafDetailVo.getStepNo();
            String procdesc=eafDetailVo.getChkProcdesc();
            String DeptDR=eafDetailVo.getDept();
            Integer isdirect=eafDetailVo.getIsDirector();
            Integer issecretary=eafDetailVo.getIsSecretary();
            Integer IsCorrsAuthor=eafDetailVo.getIsCorrAuthor();
            Integer IsHead=eafDetailVo.getIsHead();
            Integer IsMentor=eafDetailVo.getIsMentor();
            String ChkFstDR=eafDetailVo.getCheckerString();
            if(StringUtils.isEmpty(DeptDR)){
                DeptDR=defaultDeptDr;
            }
            String auditcheckers=null;
            String ChkUserDrStr=null;
            String chk="1"; // 缺省审批状态为 "待审"
            int isCurStep=0;
            String desc1="-审批通过";
            String desc0="-等待审核";
            LocalDateTime chkDate=null;
            String chkUser="";
            String chkDesc=procdesc+desc0;
            if(!ChkFstDR.isEmpty()){
                ChkUserDrStr=ChkFstDR;
            }
            if (stepno==1) {
                chk="2";
                chkDate= LocalDateTime.now();
                chkUser=String.valueOf(srmUserRowId);
                chkDesc=procdesc+desc1;
            }
            if(stepno==2){
                isCurStep=1;
            }
            //科主任审核
            if(isdirect!=null&&isdirect==1){
                if(DeptDR==null||DeptDR.isEmpty()){

                    auditcheckers= srmDeptUserService.getDirectorByUser(String.valueOf(srmUserRowId));
                }else{
                    auditcheckers= srmDeptUserService.getDirectorByDept(DeptDR);
                }
                if(!auditcheckers.isEmpty()){
                    if(ChkUserDrStr==null){
                        ChkUserDrStr=auditcheckers;
                    }else{
                        ChkUserDrStr=ChkUserDrStr+","+auditcheckers;
                    }
                }
            }
            if(IsHead!=null&&IsHead==1){
                if(DeptDR==null||DeptDR.isEmpty()){
                    PaperVo paperVo2= srmPaperService.getDetail(rowId);
                    CombVo auditcheckersComb=paperVo2.getProjAuthor();
                    auditcheckers=auditcheckersComb.getId();
                }else{
                    auditcheckers= srmDeptUserService.getDirectorByDept(DeptDR);
                }
                if(!auditcheckers.isEmpty()){
                    if(ChkUserDrStr==null){
                        ChkUserDrStr=ChkFstDR;
                    }else{
                        ChkUserDrStr=ChkUserDrStr+","+ChkFstDR;
                    }
                }
            }
            if(IsCorrsAuthor!=null&&IsCorrsAuthor==1){
                if(DeptDR==null||DeptDR.isEmpty()){
                    PaperVo paperVo3= srmPaperService.getDetail(rowId);
                    CombVo auditcheckersComb=paperVo3.getCorrAuthorId();
                    auditcheckers=auditcheckersComb.getId();
                }else{
                    auditcheckers= srmDeptUserService.getDirectorByDept(DeptDR);
                }
                if(!auditcheckers.isEmpty()){
                    if(ChkUserDrStr==null){
                        ChkUserDrStr=ChkFstDR;
                    }else{
                        ChkUserDrStr=ChkUserDrStr+","+ChkFstDR;
                    }
                }
            }

            if(issecretary!=null&&issecretary==1){
                if(DeptDR==null||DeptDR.isEmpty()){
                    auditcheckers= srmDeptUserService.getAuditUser(String.valueOf(srmUserRowId),DeptDR,null,"1");
                }else{
                    auditcheckers= srmDeptUserService.getAuditUser(null,DeptDR,null,"1");
                }
                if(!auditcheckers.isEmpty()){
                    if(ChkUserDrStr==null){
                        ChkUserDrStr=ChkFstDR;
                    }else{
                        ChkUserDrStr=ChkUserDrStr+","+ChkFstDR;
                    }
                }
            }
            if(IsMentor!=null&&IsMentor==1){
                DeptUserVo deptUserVo = srmDeptUserService.getTeacher(String.valueOf(srmUserRowId));
                auditcheckers=deptUserVo.getUserId();
                if(!auditcheckers.isEmpty()){
                    if(ChkUserDrStr==null){
                        ChkUserDrStr=ChkFstDR;
                    }else{
                        ChkUserDrStr=ChkUserDrStr+","+ChkFstDR;
                    }
                }
            }
            String checkusers=null;
            if(!StringUtils.isEmpty(ChkUserDrStr)){
                List<String> ChkUserDrStrList = Arrays.asList(ChkUserDrStr.split(","));
                HashSet<String> newChkUserDrStr = new HashSet<>(ChkUserDrStrList);
                checkusers=String.join("|",newChkUserDrStr);
            }
            SrmEafRec eafRec=new SrmEafRec();
            eafRec.setCheckRecId(rowId);
            eafRec.setEafDetailId(String.valueOf(chkdetailrowid));
            eafRec.setSysNo(sysNo);
            eafRec.setStepNo(stepno);
            if(checkusers==null){
                checkusers="";
            }
            eafRec.setCheckerString("|"+checkusers+"|");
            eafRec.setCheckProcDesc(procdesc);
            eafRec.setCheckDesc(chkDesc);
            eafRec.setCheckResult(chk);
            eafRec.setIsCurrentStep(isCurStep);
            eafRec.setCheckDatetime(chkDate);
            eafRec.setDept(DeptDR);
            eafRec.setChecker(chkUser);
            eafRec.setCheckUser(chkUser);
            super.saveOrUpdate(eafRec);
            if(FirstDetailId==null){
                FirstDetailId=eafRec.getId();
            }
            if(stepno==2){
                this.insertAppMessage(rowId,sysNo,"|"+checkusers+"|");
            }
            // 推送审批流信息（后面补充）
        }
        //生成审批日志
        if(FirstDetailId!=null){
            srmEafRecLogService.saveRecLog(String.valueOf(FirstDetailId));
        }
    }
    /*
        保存审批流信息
    **/
    @Override
    @Transactional
    public void saveRec(SrmEafRec eafRec) {
        super.saveOrUpdate(eafRec);
    }

    @Override
    public EafRecVo getEafRecDetail(EafRecDto eafRecDto) {
        return srmEafRecMapper.getEafRecDetail(eafRecDto);
    }

    /*
        业务审核时，更新审批流信息
    **/
    @Override
    public void updateRec(EafRecDto eafRecDto) {
        if(eafRecDto.getId()==null){
            throw new RuntimeException("注意！业务id不存在！");
        }
        srmEafRecMapper.updateRec(eafRecDto);
    }
    /*
        业务审核操作执行
    **/
    @Override
    public void genAudit(Long rowId, String sysNo, Long userId,String resultId,String view, Long ethicFlag) {
       // Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        EafRecDto eafRecDto1=new EafRecDto();
        eafRecDto1.setCheckRecId(String.valueOf(rowId));
        eafRecDto1.setIsCurrentStep(1);
        eafRecDto1.setSysNo(sysNo);
        EafRecVo eafRecVo1=this.getEafRecDetail(eafRecDto1);
        Long recId=eafRecVo1.getId();
        if(recId==null){
            throw new RuntimeException("业务审批流程不存在");
        }
        int curStepNo=eafRecVo1.getStepNo();
        String chkProcDesc=eafRecVo1.getCheckProcDesc();
        String deptDr=null;  //可以取科室用户表的
        String checkDesc=null;
        String defaultView="审批通过";
        if("3".equals(resultId)){
            defaultView="审批不通过";
        }
        if(StringUtils.isEmpty(view)){
            checkDesc=chkProcDesc+"-"+defaultView;
        }else{
            checkDesc=chkProcDesc+"-"+view;
        }
        LocalDateTime nowDateTime=LocalDateTime.now();
        EafRecDto eafRecDto2=new EafRecDto();
        eafRecDto2.setCheckDatetime(nowDateTime);
        eafRecDto2.setCheckUser(String.valueOf(userId));
        eafRecDto2.setDept(deptDr);
        eafRecDto2.setCheckResult(resultId);
        eafRecDto2.setCheckDesc(checkDesc);
        eafRecDto2.setIsCurrentStep(0);
        eafRecDto2.setId(recId);
        this.updateRec(eafRecDto2);
        int maxStepNo=this.getMaxStepNo(sysNo,String.valueOf(rowId));

        int nextStepNo=0;
        if(curStepNo!=maxStepNo){
            nextStepNo=curStepNo+1;

            // 处理项目申报 专家审核处理(后期添加)
            // 处理项目申报 伦理专家审核处理(后期添加)
            EafRecDto eafRecDto4=new EafRecDto();
            eafRecDto4.setSysNo(sysNo);
            eafRecDto4.setStepNo(nextStepNo);
            eafRecDto4.setCheckResult("1");
            eafRecDto4.setCheckRecId(String.valueOf(rowId));
            EafRecVo eafRecVo4=this.getEafRecDetail(eafRecDto4);
            if(eafRecVo4==null){
                throw new RuntimeException("审批流程不存在");
            }
            Long recNextId=eafRecVo4.getId();
            if(recNextId==null){
                throw new RuntimeException("审批流程不存在");
            }
            EafRecDto eafRecDto5=new EafRecDto();
            eafRecDto5.setId(recNextId);
            eafRecDto5.setIsCurrentStep(1);
            this.updateRec(eafRecDto5);

        }

        srmEafRecLogService.saveRecLog(String.valueOf(recId));
        //推送消息后面补充
        this.sendAppMessage(String.valueOf(rowId),sysNo,curStepNo,maxStepNo,String.valueOf(userId),checkDesc);
    }
    /*
        业务审核不通过操作
    **/
    @Override
    public void genNoAudit(Long rowId, String sysNo, Long srmUserRowId,String resultId, String view) {
        //Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        EafRecDto eafRecDto1=new EafRecDto();
        eafRecDto1.setCheckRecId(String.valueOf(rowId));
        eafRecDto1.setIsCurrentStep(1);
        eafRecDto1.setSysNo(sysNo);
        EafRecVo eafRecVo1=this.getEafRecDetail(eafRecDto1);

        //QueryWrapper<SrmEafRec> queryWrapper=new QueryWrapper<>();
        //queryWrapper.eq("sys_no",sysNo).eq("is_current_step",1).eq("check_rec_id",rowId);
        //SrmEafRec srmEafRec=srmEafRecMapper.selectOne(queryWrapper);

        Long recId=eafRecVo1.getId();
        int curStepNo=eafRecVo1.getStepNo();
        if(recId==null){
            throw new RuntimeException("业务审批流程不存在");
        }
        String deptDr=null;
        LocalDateTime nowDateTime=LocalDateTime.now();
        EafRecDto eafRecDto2=new EafRecDto();
        eafRecDto2.setCheckDatetime(nowDateTime);
        eafRecDto2.setCheckUser(String.valueOf(srmUserRowId));
        eafRecDto2.setDept(deptDr);
        eafRecDto2.setCheckResult(resultId);
        eafRecDto2.setCheckDesc(view);
        eafRecDto2.setId(recId);
        this.updateRec(eafRecDto2);
        srmEafRecLogService.saveRecLog(String.valueOf(recId));
    }

    @Override
    public void genNoAuditBackFirst(Long rowId, String sysNo, String userCode, String view) {
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        EafRecDto eafRecDto1=new EafRecDto();
        eafRecDto1.setCheckRecId(String.valueOf(rowId));
        eafRecDto1.setIsCurrentStep(1);
        eafRecDto1.setSysNo(sysNo);
        EafRecVo eafRecVo1=this.getEafRecDetail(eafRecDto1);
        Long recId=eafRecVo1.getId();
        int curStepNo=eafRecVo1.getStepNo();
        if(recId==null){
            throw new RuntimeException("业务审批流程不存在");
        }
        String deptDr=null;
        LocalDateTime nowDateTime=LocalDateTime.now();
        EafRecDto eafRecDto2=new EafRecDto();
        eafRecDto2.setCheckDatetime(nowDateTime);
        eafRecDto2.setCheckUser(String.valueOf(srmUserRowId));
        eafRecDto2.setDept(deptDr);
        eafRecDto2.setCheckResult("3");
        eafRecDto2.setCheckDesc(view);
        eafRecDto2.setId(recId);
        eafRecDto2.setIsCurrentStep(0);
        this.updateRec(eafRecDto2);
        EafRecDto eafRecDto3=new EafRecDto();
        eafRecDto3.setSysNo(sysNo);
        eafRecDto3.setStepNo(1);
        //eafRecDto3.setSysNo("1");
        eafRecDto3.setCheckRecId(String.valueOf(recId));
        EafRecVo eafRecVo2=this.getEafRecDetail(eafRecDto3);
        Long firstRecId=eafRecVo2.getId();
        EafRecDto eafRecDto4=new EafRecDto();
        eafRecDto4.setId(firstRecId);
        eafRecDto4.setIsCurrentStep(1);
        this.updateRec(eafRecDto4);
        srmEafRecLogService.saveRecLog(String.valueOf(recId));
    }

    @Override
    public Boolean getCurStatus(BaseDto baseDto) {
        List<Long> ids=baseDto.getIdList();


        Long srmUserRowId= srmUserService.getUserIdByAccount(null);
        String newUserId="|"+String.valueOf(srmUserRowId)+"|";
        for (Long rowId: ids){
            baseDto.setId(rowId);
            String checkers= srmEafRecMapper.getCurCheckUserStr(baseDto);
            // 不存在当前需要审批的位置
            if(checkers==null){
                return false;
            }
            // 存在审批记录，但是审核人不是他
            if(!checkers.contains(newUserId)&&!checkers.equals("||")){
                return false;
            }
        }
        return true;
    }

    @Override
    public String getCurCheckDesc(String sysNo, Long rowId, String type) {
        EafRecDto eafRecDto=new EafRecDto();
        eafRecDto.setCheckRecId(String.valueOf(rowId));
        eafRecDto.setSysNo(sysNo);
        eafRecDto.setStepNo(1);
        EafRecVo alleafRecVo= srmEafRecMapper.getEafRecDetail(eafRecDto);
        if(alleafRecVo==null){
            return "尚未进入流程";
        }
        EafRecDto eafRecDto2=new EafRecDto();
        eafRecDto2.setCheckRecId(String.valueOf(rowId));
        eafRecDto2.setSysNo(sysNo);
        eafRecDto2.setIsCurrentStep(1);
        EafRecVo eafRecVo= srmEafRecMapper.getEafRecDetail(eafRecDto2);
        if(eafRecVo==null){
            // 获取最后一次审核结果
            String auditResult=srmEafRecMapper.getFinalResult(sysNo,String.valueOf(rowId));
            if("2".equals(auditResult)){
                return "结束-全部通过";
            }else{
                return "结束-审批不通过";
            }
        }
        String checkers=eafRecVo.getCheckerString();
        String resultId=eafRecVo.getCheckResult();
        String stepDesc=eafRecVo.getCheckProcDesc();
        if(checkers==null||checkers.equals("||")){
            return "";
        }
        String[] list = checkers.split("\\|");
        StringBuilder curStepDesc= new StringBuilder();
        for (String checker :list){
            if(checker!=null&&!checker.isEmpty()){
                UserVo userVo= srmUserService.getUserDetail(checker,null);
                String username=userVo.getName();
                if(curStepDesc.length() == 0){
                    curStepDesc = new StringBuilder(username);
                }else{
                    curStepDesc.append(",").append(username);
                }
            }
        }
        return stepDesc+":"+curStepDesc.toString();

    }

    @Override
    public SrmEafRec getAuditStepAndDesc(String sysNo, Long rowId) {
        QueryWrapper<SrmEafRec> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("check_rec_id",rowId).eq("sys_no",sysNo).eq("is_current_step",1);
        return srmEafRecMapper.selectOne(queryWrapper);

    }

    @Override
    public SrmEafDetail getCheckStatus(String sysNo, String rowId) {
        return srmEafRecMapper.getCheckStatus(sysNo, rowId);
    }

    @Override
    public Integer getMaxStepNo(String sysNo, String rowId) {
        return srmEafRecMapper.getMaxStepNo(sysNo,rowId);
    }

    @Override
    public String getFinalResult(BaseDto baseDto) {
        String sysNo=baseDto.getSysNo();
        Long rowId=baseDto.getId();
        return srmEafRecMapper.getFinalResult(sysNo,String.valueOf(rowId));
    }
    // 提交时插入一条消息
    public void insertAppMessage(String ywRowId,String sysNo,String checkerList) {
        SrmAppMessage appMessage=new SrmAppMessage();
        checkerList=checkerList.replace("|",",");
        appMessage.setRecId(ywRowId);
        appMessage.setSysNo(sysNo);
        appMessage.setCreateDate(LocalDateTime.now());
        appMessage.setDataStatus(0);
        appMessage.setStepNo("2");
        appMessage.setUserList(checkerList);
        // 设置类型以及其他
        Map<String,String> info=this.getMessageInfo(sysNo,ywRowId,1);
        String title=info.get("title");
        String content=info.get("content");
        String messageType=info.get("messageType");
        String subUser=info.get("subUser");
        appMessage.setTitle(title);
        appMessage.setContent(content);
        appMessage.setType(messageType);
        appMessage.setSubmitUserId(subUser);
        if(messageType!=null&&!messageType.isEmpty()){
            srmAppMessageService.saveOrUpdate(appMessage);
        }
    }
    // 推送app消息到下一级，并完成当前消息
    public void sendAppMessage(String ywRowId,String sysNo,int stepNo,int maxStepNo,String userId,String view){
        int nextStepNo=stepNo+1;
        QueryWrapper<SrmAppMessage> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("sys_no",sysNo);
        queryWrapper.eq("rec_id",ywRowId);
        queryWrapper.eq("data_status",0);
        queryWrapper.eq("is_delete",0);
        if(stepNo>0){
            queryWrapper.eq("step_no",stepNo);
        }
        SrmAppMessage srmAppMessage=srmAppMessageMapper.selectOne(queryWrapper);
        if(srmAppMessage!=null){
            srmAppMessage.setDataStatus(1);
            srmAppMessage.setAuditUserId(userId);
            srmAppMessage.setAuditDate(LocalDateTime.now());
            srmAppMessage.setAuditAdvice(view);
            srmAppMessage.setCheckStatus(2);
            srmAppMessageMapper.updateById(srmAppMessage);
            if(stepNo!=maxStepNo){
                // 有下一级,推送给下级
                QueryWrapper<SrmEafRec> srmEafRecQueryWrapper=new QueryWrapper<>();
                srmEafRecQueryWrapper.eq("sys_no",sysNo);
                srmEafRecQueryWrapper.eq("check_rec_id",ywRowId);
                srmEafRecQueryWrapper.eq("step_no",nextStepNo);

                SrmEafRec srmEafRec=srmEafRecMapper.selectOne(srmEafRecQueryWrapper);
                String checkerList=srmEafRec.getCheckerString().replace("|",",");
                SrmAppMessage appMessage=new SrmAppMessage();
                appMessage.setRecId(ywRowId);
                appMessage.setSysNo(sysNo);
                appMessage.setDataStatus(0);
                appMessage.setStepNo(String.valueOf(nextStepNo));
                appMessage.setUserList(checkerList);
                appMessage.setCreateDate(LocalDateTime.now());
                // 设置类型以及其他
                Map<String,String> info=this.getMessageInfo(sysNo,ywRowId,1);
                String title=info.get("title");
                String content=info.get("content");
                String messageType=info.get("messageType");
                String subUser=info.get("subUser");
                appMessage.setTitle(title);
                appMessage.setContent(content);
                appMessage.setType(messageType);
                appMessage.setSubmitUserId(subUser);
                if(messageType!=null&&!messageType.isEmpty()){
                    srmAppMessageService.saveOrUpdate(appMessage);
                }

            }
        }
    }

    // 取消app信息
    @Autowired
    private SrmPaperMapper srmPaperMapper;
    @Autowired
    private SrmPaperSubmissionApplyMapper srmPaperSubmissionApplyMapper;
    @Autowired
    private SrmMonographInfoMapper srmMonographInfoMapper;
    @Autowired
    private SrmPatentApplyMapper srmPatentApplyMapper;
    @Autowired
    private SrmPatentInfoMapper srmPatentInfoMapper;
    @Autowired
    private SrmAwardApplyMapper srmAwardApplyMapper;
    @Autowired
    private SrmAchievementMapper srmAchievementMapper;
    @Autowired
    private SrmAcConferenceHostMapper srmAcConferenceHostMapper;
    @Autowired
    private SrmAcLectureMapper srmAcLectureMapper;
    @Autowired
    private SrmAcMeetingManageMapper srmAcMeetingManageMapper;
    @Autowired
    private SrmAcResearchTrainMapper srmAcResearchTrainMapper;
    @Autowired
    private SrmAcParttimeApplyMapper srmAcParttimeApplyMapper;
    @Autowired
    private SrmCommitteeInfoMapper srmCommitteeInfoMapper;
    @Autowired
    private SrmProjectSolicitMapper srmProjectSolicitMapper;
    @Autowired
    private SrmProjectFinalcheckMapper srmProjectFinalcheckMapper;
    @Autowired
    private SrmProjectMidcheckMapper srmProjectMidcheckMapper;
    @Autowired
    private SrmProjectsInfoMapper srmProjectsInfoMapper;
    // 获取消息类型以及主题 ,flag=1 代表通过，0：不通过
    public Map<String, String> getMessageInfo(String sysNo,String ywRowId,int flag) {
        Map<String,String> map=new HashMap<>();
        String title="",subUserName="",subUser="",messageType="";
        switch (sysNo){
            case "P001":
                SrmPaperSubmissionApply srmPaperSubmissionApply=srmPaperSubmissionApplyMapper.selectById(ywRowId);
                title=srmPaperSubmissionApply.getTitle();
                subUser=srmPaperSubmissionApply.getSubUserId();
                subUserName="";
                if(subUser!=null&&!subUser.isEmpty()){
                    SrmUser srmUser=srmUserService.selectById(subUser);
                    subUserName=srmUser.getName();
                }
                messageType="P001-1";  //6
                if(flag==0){
                    messageType="P001-2"; //9
                }
                map.put("title","由"+subUserName+"提出的论文申请");
                map.put("content",title);
                map.put("messageType",messageType);
                map.put("subUser",subUser);
                break;
            case "P002":
                SrmPaper srmPaper=srmPaperMapper.selectById(ywRowId);
                title=srmPaper.getTitle();
                subUser=srmPaper.getSubUserId();
                subUserName="";
                if(subUser!=null&&!subUser.isEmpty()){
                    SrmUser srmUser=srmUserService.selectById(subUser);
                    subUserName=srmUser.getName();
                }
                messageType="P002-1";  //17
                if(flag==0){
                    messageType="P002-2"; //18
                }
                map.put("title","由"+subUserName+"提出的论文登记");
                map.put("content",title);
                map.put("messageType",messageType);
                map.put("subUser",subUser);
                break;
            case "P004":
                SrmMonographInfo srmMonographInfo=srmMonographInfoMapper.selectById(ywRowId);
                title=srmMonographInfo.getName();
                subUser=srmMonographInfo.getSubUserId();
                subUserName="";
                if(subUser!=null&&!subUser.isEmpty()){
                    SrmUser srmUser=srmUserService.selectById(subUser);
                    subUserName=srmUser.getName();
                }
                messageType="P004-1";  //19
                if(flag==0){
                    messageType="P004-2"; //20
                }
                map.put("title","由"+subUserName+"提出的著作登记");
                map.put("content",title);
                map.put("messageType",messageType);
                map.put("subUser",subUser);
                break;
            case "P010":
                SrmPatentApply srmPatentApply=srmPatentApplyMapper.selectById(ywRowId);
                title=srmPatentApply.getName();
                subUser=srmPatentApply.getSubUserId();
                subUserName="";
                if(subUser!=null&&!subUser.isEmpty()){
                    SrmUser srmUser=srmUserService.selectById(subUser);
                    subUserName=srmUser.getName();
                }
                messageType="P010-1";  //21
                if(flag==0){
                    messageType="P010-2"; //22
                }
                map.put("title","由"+subUserName+"提出的专利申请");
                map.put("content",title);
                map.put("messageType",messageType);
                map.put("subUser",subUser);
                break;
            case "P005":
                SrmPatentInfo srmPatentInfo=srmPatentInfoMapper.selectById(ywRowId);
                title=srmPatentInfo.getName();
                subUser=srmPatentInfo.getSubUserId();
                subUserName="";
                if(subUser!=null&&!subUser.isEmpty()){
                    SrmUser srmUser=srmUserService.selectById(subUser);
                    subUserName=srmUser.getName();
                }
                messageType="P005-1";  //24
                if(flag==0){
                    messageType="P005-2"; //25
                }
                map.put("title","由"+subUserName+"提出的专利登记");
                map.put("content",title);
                map.put("messageType",messageType);
                map.put("subUser",subUser);
                break;
            case "P045":
                SrmAwardApply srmAwardApply=srmAwardApplyMapper.selectById(ywRowId);
                title=srmAwardApply.getAwardName();
                subUser=srmAwardApply.getCreatorId();
                subUserName="";
                if(subUser!=null&&!subUser.isEmpty()){
                    SrmUser srmUser=srmUserService.selectById(subUser);
                    subUserName=srmUser.getName();
                }
                messageType="P045-1";  //26
                if(flag==0){
                    messageType="P045-2"; //27
                }
                map.put("title","由"+subUserName+"提出的获奖申请");
                map.put("content",title);
                map.put("messageType",messageType);
                map.put("subUser",subUser);
                break;
            case "P009":
                SrmAchievement srmAchievement=srmAchievementMapper.selectById(ywRowId);
                title=srmAchievement.getAwardName();
                subUser=srmAchievement.getSubUserId();
                subUserName="";
                if(subUser!=null&&!subUser.isEmpty()){
                    SrmUser srmUser=srmUserService.selectById(subUser);
                    subUserName=srmUser.getName();
                }
                messageType="P009-1";  //29
                if(flag==0){
                    messageType="P009-2"; //30
                }
                map.put("title","由"+subUserName+"提出的获奖登记");
                map.put("content",title);
                map.put("messageType",messageType);
                map.put("subUser",subUser);
                break;
            case "P032":
                SrmAcConferenceHost srmAcConferenceHost=srmAcConferenceHostMapper.selectById(ywRowId);
                title=srmAcConferenceHost.getName();
                subUser=srmAcConferenceHost.getSubUserId();
                subUserName="";
                if(subUser!=null&&!subUser.isEmpty()){
                    SrmUser srmUser=srmUserService.selectById(subUser);
                    subUserName=srmUser.getName();
                }
                messageType="P032-1";  //34
                if(flag==0){
                    messageType="P032-2"; //35
                }
                map.put("title","由"+subUserName+"提出的主办会议");
                map.put("content",title);
                map.put("messageType",messageType);
                map.put("subUser",subUser);
                break;
            case "P041":
                SrmAcLecture srmAcLecture=srmAcLectureMapper.selectById(ywRowId);
                title=srmAcLecture.getLecturerTitle();
                subUser=srmAcLecture.getSubUserId();
                subUserName="";
                if(subUser!=null&&!subUser.isEmpty()){
                    SrmUser srmUser=srmUserService.selectById(subUser);
                    subUserName=srmUser.getName();
                }
                messageType="P041-1";  //40
                if(flag==0){
                    messageType="P041-2"; //41
                }
                map.put("title","由"+subUserName+"提出的学术讲座");
                map.put("content",title);
                map.put("messageType",messageType);
                map.put("subUser",subUser);
                break;
            case "P043":
                SrmAcResearchTrain srmAcResearchTrain=srmAcResearchTrainMapper.selectById(ywRowId);
                title=srmAcResearchTrain.getTitle();
                subUser=srmAcResearchTrain.getSubUserId();

                subUserName="";
                if(subUser!=null&&!subUser.isEmpty()){
                    SrmUser srmUser=srmUserService.selectById(subUser);
                    subUserName=srmUser.getName();
                }
                messageType="P043-1";  //42
                if(flag==0){
                    messageType="P043-2"; //43
                }
                map.put("title","由"+subUserName+"提出的外出培训");
                map.put("content",title);
                map.put("messageType",messageType);
                map.put("subUser",subUser);
                break;
            case "P031":
                SrmAcMeetingManage srmAcMeetingManage=srmAcMeetingManageMapper.selectById(ywRowId);
                title=srmAcMeetingManage.getTitle();
                subUser=srmAcMeetingManage.getSubUserId();
                subUserName="";
                if(subUser!=null&&!subUser.isEmpty()){
                    SrmUser srmUser=srmUserService.selectById(subUser);
                    subUserName=srmUser.getName();
                }
                messageType="P031-1";  //36
                if(flag==0){
                    messageType="P031-2"; //37
                }
                map.put("title","由"+subUserName+"提出的外出会议");
                map.put("content",title);
                map.put("messageType",messageType);
                map.put("subUser",subUser);
                break;
            case "P051":
                SrmAcParttimeApply srmAcParttimeApply=srmAcParttimeApplyMapper.selectById(ywRowId);
                String branch=srmAcParttimeApply.getBranch();
                if(!StringUtils.isEmpty(branch)){
                    QueryWrapper<SrmCommitteeInfo> srmCommitteeInfoQueryWrapper=new QueryWrapper<>();
                    srmCommitteeInfoQueryWrapper.eq("code",branch);

                    SrmCommitteeInfo srmCommitteeInfo=srmCommitteeInfoMapper.selectOne(srmCommitteeInfoQueryWrapper);
                    if(srmCommitteeInfo!=null){
                        title=srmCommitteeInfo.getName();
                    }

                }
                subUser=srmAcParttimeApply.getSubUserId();
                subUserName="";
                if(subUser!=null&&!subUser.isEmpty()){
                    SrmUser srmUser=srmUserService.selectById(subUser);
                    subUserName=srmUser.getName();
                }
                messageType="P051-1";  //38
                if(flag==0){
                    messageType="P051-2"; //39
                }
                map.put("title","由"+subUserName+"提出的兼职申请");
                map.put("content",title);
                map.put("messageType",messageType);
                map.put("subUser",subUser);
                break;
            case "P011":
                SrmProjectSolicit srmProjectSolicit=srmProjectSolicitMapper.selectById(ywRowId);
                title=srmProjectSolicit.getTitle();
                subUser=srmProjectSolicit.getSubUserId();
                subUserName="";
                if(subUser!=null&&!subUser.isEmpty()){
                    SrmUser srmUser=srmUserService.selectById(subUser);
                    subUserName=srmUser.getName();
                }
                messageType="P011-1";  //38
                if(flag==0){
                    messageType="P011-2"; //39
                }
                map.put("title","由"+subUserName+"提出的项目申请");
                map.put("content",title);
                map.put("messageType",messageType);
                map.put("subUser",subUser);
                break;
            case "P007":
                SrmProjectsInfo vsrmProjectsInfo=srmProjectsInfoMapper.selectById(ywRowId);
                title=vsrmProjectsInfo.getName();
                subUser=vsrmProjectsInfo.getSubUserId();
                subUserName="";
                if(subUser!=null&&!subUser.isEmpty()){
                    SrmUser srmUser=srmUserService.selectById(subUser);
                    subUserName=srmUser.getName();
                }
                messageType="P007-1";  //38
                if(flag==0){
                    messageType="P007-2"; //39
                }
                map.put("title","由"+subUserName+"提出的纵向项目登记");
                map.put("content",title);
                map.put("messageType",messageType);
                map.put("subUser",subUser);
                break;
            case "C007":
                SrmProjectMidcheck srmProjectMidcheck=srmProjectMidcheckMapper.selectById(ywRowId);
                Long projectId=srmProjectMidcheck.getProjId();
                if(projectId!=null){
                    SrmProjectsInfo csrmProjectsInfo=srmProjectsInfoMapper.selectById(projectId);
                    title=csrmProjectsInfo.getName();
                }
                subUser=srmProjectMidcheck.getApply();
                subUserName="";
                if(subUser!=null&&!subUser.isEmpty()){
                    SrmUser srmUser=srmUserService.selectById(subUser);
                    subUserName=srmUser.getName();
                }
                messageType="C007-1";  //38
                if(flag==0){
                    messageType="C007-2"; //39
                }
                map.put("title","由"+subUserName+"提出的纵向项目中检申请");
                map.put("content",title);
                map.put("messageType",messageType);
                map.put("subUser",subUser);
                break;
            case "P047":
                SrmProjectFinalcheck srmProjectFinalcheck=srmProjectFinalcheckMapper.selectById(ywRowId);
                Long projectRowId=srmProjectFinalcheck.getProjId();
                if(projectRowId!=null){
                    SrmProjectsInfo fsrmProjectsInfo=srmProjectsInfoMapper.selectById(projectRowId);
                    title=fsrmProjectsInfo.getName();
                }
                subUser=srmProjectFinalcheck.getSubUser();
                subUserName="";
                if(subUser!=null&&!subUser.isEmpty()){
                    SrmUser srmUser=srmUserService.selectById(subUser);
                    subUserName=srmUser.getName();
                }
                messageType="P047-1";  //38
                if(flag==0){
                    messageType="P047-2"; //39
                }
                map.put("title","由"+subUserName+"提出的纵向项目验收申请");
                map.put("content",title);
                map.put("messageType",messageType);
                map.put("subUser",subUser);
                break;
            case "P052":
                SrmProjectsInfo hsrmProjectsInfo=srmProjectsInfoMapper.selectById(ywRowId);
                title=hsrmProjectsInfo.getName();
                subUser=hsrmProjectsInfo.getSubUserId();
                subUserName="";
                if(subUser!=null&&!subUser.isEmpty()){
                    SrmUser srmUser=srmUserService.selectById(subUser);
                    subUserName=srmUser.getName();
                }
                messageType="P052-1";  //38
                if(flag==0){
                    messageType="P052-2"; //39
                }
                map.put("title","由"+subUserName+"提出的横向项目登记");
                map.put("content",title);
                map.put("messageType",messageType);
                map.put("subUser",subUser);
                break;


            case "C008":
                SrmProjectMidcheck srmHProjectMidcheck=srmProjectMidcheckMapper.selectById(ywRowId);
                Long hProjectId=srmHProjectMidcheck.getProjId();
                if(hProjectId!=null){
                    SrmProjectsInfo hcsrmProjectsInfo=srmProjectsInfoMapper.selectById(hProjectId);
                    title=hcsrmProjectsInfo.getName();
                }
                subUser=srmHProjectMidcheck.getApply();
                subUserName="";
                if(subUser!=null&&!subUser.isEmpty()){
                    SrmUser srmUser=srmUserService.selectById(subUser);
                    subUserName=srmUser.getName();
                }
                messageType="C008-1";  //38
                if(flag==0){
                    messageType="C008-2"; //39
                }
                map.put("title","由"+subUserName+"提出的横向项目中检申请");
                map.put("content",title);
                map.put("messageType",messageType);
                map.put("subUser",subUser);
                break;
            case "P057":
                SrmProjectFinalcheck srmfProjectFinalcheck=srmProjectFinalcheckMapper.selectById(ywRowId);
                Long fprojectRowId=srmfProjectFinalcheck.getProjId();
                if(fprojectRowId!=null){
                    SrmProjectsInfo fsrmProjectsInfo=srmProjectsInfoMapper.selectById(fprojectRowId);
                    title=fsrmProjectsInfo.getName();
                }
                subUser=srmfProjectFinalcheck.getSubUser();
                subUserName="";
                if(subUser!=null&&!subUser.isEmpty()){
                    SrmUser srmUser=srmUserService.selectById(subUser);
                    subUserName=srmUser.getName();
                }
                messageType="P057-1";  //38
                if(flag==0){
                    messageType="P057-2"; //39
                }
                map.put("title","由"+subUserName+"提出的横向项目验收申请");
                map.put("content",title);
                map.put("messageType",messageType);
                map.put("subUser",subUser);
                break;

            default:
                map.put("title","");
                map.put("content","");
                map.put("messageType","");
                map.put("subUser","");
        }
        return map;
    }
}
