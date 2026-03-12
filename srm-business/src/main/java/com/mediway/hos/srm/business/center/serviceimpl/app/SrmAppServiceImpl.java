package com.mediway.hos.srm.business.center.serviceimpl.app;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.app.core.util.SecurityUtils;
import com.mediway.hos.base.model.BaseResponse;
import com.mediway.hos.security.core.userdetails.HosUser;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.academic.*;
import com.mediway.hos.srm.business.center.model.dto.app.AppBaseDto;
import com.mediway.hos.srm.business.center.model.dto.app.AppMessageDto;
import com.mediway.hos.srm.business.center.model.dto.approvalProcess.EafRecDto;
import com.mediway.hos.srm.business.center.model.dto.award.*;
import com.mediway.hos.srm.business.center.model.dto.baseData.*;
import com.mediway.hos.srm.business.center.model.dto.monograph.MonographAuthorDto;
import com.mediway.hos.srm.business.center.model.dto.monograph.MonographDetailDto;
import com.mediway.hos.srm.business.center.model.dto.monograph.MonographDto;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperAuthorDto;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperDto;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperMainDto;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperSubmissionApplyDto;
import com.mediway.hos.srm.business.center.model.dto.patent.*;
import com.mediway.hos.srm.business.center.model.dto.project.*;
import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitDto;
import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitMainDto;
import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitMemberDto;
import com.mediway.hos.srm.business.center.model.dto.user.UserDto;
import com.mediway.hos.srm.business.center.model.entity.app.SrmAppMessage;
import com.mediway.hos.srm.business.center.model.entity.award.SrmAchievement;
import com.mediway.hos.srm.business.center.model.entity.award.SrmAwardApply;
import com.mediway.hos.srm.business.center.model.entity.award.SrmAwardApplyAuthor;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPageSpace;
import com.mediway.hos.srm.business.center.model.entity.paper.SrmPaper;
import com.mediway.hos.srm.business.center.model.entity.paper.SrmPaperSubmissionApply;
import com.mediway.hos.srm.business.center.model.vo.academic.*;
import com.mediway.hos.srm.business.center.model.vo.app.AppListVo;
import com.mediway.hos.srm.business.center.model.vo.app.AppMessageVo;
import com.mediway.hos.srm.business.center.model.vo.app.AppResultVo;
import com.mediway.hos.srm.business.center.model.vo.approvalProcess.EafRecVstepNo;
import com.mediway.hos.srm.business.center.model.vo.award.AchievementAuthorVo;
import com.mediway.hos.srm.business.center.model.vo.award.AchievementVo;
import com.mediway.hos.srm.business.center.model.vo.award.AwardApplyAuthorVo;
import com.mediway.hos.srm.business.center.model.vo.award.AwardApplyVo;
import com.mediway.hos.srm.business.center.model.vo.baseData.*;
import com.mediway.hos.srm.business.center.model.vo.monograph.MonographAuthorVo;
import com.mediway.hos.srm.business.center.model.vo.monograph.MonographVo;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperAuthorVo;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperSubmissionApplyVo;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperVo;
import com.mediway.hos.srm.business.center.model.vo.patent.PatentApplyAuthorVo;
import com.mediway.hos.srm.business.center.model.vo.patent.PatentApplyVo;
import com.mediway.hos.srm.business.center.model.vo.patent.PatentInfoAuthorVo;
import com.mediway.hos.srm.business.center.model.vo.patent.PatentInfoVo;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectFinalcheckVo;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectMidcheckVo;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectsInfoMemberVo;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectsInfoVo;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectSolicitMemberVo;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectSolicitVo;
import com.mediway.hos.srm.business.center.model.vo.user.UserVo;
import com.mediway.hos.srm.business.center.service.academic.*;
import com.mediway.hos.srm.business.center.service.app.SrmAppCommonService;
import com.mediway.hos.srm.business.center.service.app.SrmAppMessageService;
import com.mediway.hos.srm.business.center.service.app.SrmAppService;
import com.mediway.hos.srm.business.center.service.approvalProcess.SrmEafRecLogService;
import com.mediway.hos.srm.business.center.service.award.SrmAchievementAuthorService;
import com.mediway.hos.srm.business.center.service.award.SrmAchievementService;
import com.mediway.hos.srm.business.center.service.award.SrmAwardApplyAuthorService;
import com.mediway.hos.srm.business.center.service.award.SrmAwardApplyService;
import com.mediway.hos.srm.business.center.service.baseData.SrmAppxfileTypeService;
import com.mediway.hos.srm.business.center.service.baseData.SrmFieldInputSetupService;
import com.mediway.hos.srm.business.center.service.baseData.SrmUploadInfoService;
import com.mediway.hos.srm.business.center.service.monograph.SrmMonographInfoAuthorService;
import com.mediway.hos.srm.business.center.service.monograph.SrmMonographInfoService;
import com.mediway.hos.srm.business.center.service.paper.SrmPaperAuthorService;
import com.mediway.hos.srm.business.center.service.paper.SrmPaperService;
import com.mediway.hos.srm.business.center.service.paper.SrmPaperSubmissionApplyService;
import com.mediway.hos.srm.business.center.service.patent.SrmPatentApplyAuthorService;
import com.mediway.hos.srm.business.center.service.patent.SrmPatentApplyService;
import com.mediway.hos.srm.business.center.service.patent.SrmPatentInfoAuthorService;
import com.mediway.hos.srm.business.center.service.patent.SrmPatentInfoService;
import com.mediway.hos.srm.business.center.service.project.SrmProjectFinalcheckService;
import com.mediway.hos.srm.business.center.service.project.SrmProjectMidcheckService;
import com.mediway.hos.srm.business.center.service.project.SrmProjectsInfoMemberService;
import com.mediway.hos.srm.business.center.service.project.SrmProjectsInfoService;
import com.mediway.hos.srm.business.center.service.projectapply.SrmProjectSolicitMemberService;
import com.mediway.hos.srm.business.center.service.projectapply.SrmProjectSolicitService;
import com.mediway.hos.srm.business.center.service.user.SrmUserService;
import com.mediway.hos.srm.business.center.utils.AppChange;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class SrmAppServiceImpl implements SrmAppService {
    @Autowired
    private SrmPaperService srmPaperService;
    @Autowired
    private SrmAppCommonService srmAppCommonService;
    @Autowired
    private SrmAppxfileTypeService srmAppxfileTypeService;
    @Autowired
    private SrmUploadInfoService srmUploadInfoService;
    @Autowired
    private SrmPaperAuthorService srmPaperAuthorService;
    @Autowired
    private SrmFieldInputSetupService srmFieldInputSetupService;
    @Autowired
    private SrmAppMessageService srmAppMessageService;
    @Autowired
    private SrmEafRecLogService srmEafRecLogService;
    @Autowired
    private SrmPaperSubmissionApplyService srmPaperSubmissionApplyService;
    @Autowired
    private SrmAcLectureService srmAcLectureService;
    @Autowired
    private SrmUserService srmUserService;
    @Autowired
    private SrmAwardApplyService srmAwardApplyService;
    @Autowired
    private SrmAwardApplyAuthorService srmAwardApplyAuthorService;
    @Autowired
    private SrmAchievementService srmAchievementService;
    @Autowired
    private SrmAchievementAuthorService srmAchievementAuthorService;
    @Autowired
    private SrmAcConferenceHostService srmAcConferenceHostService;
    @Autowired
    private SrmAcMeetingManageService srmAcMeetingManageService;
    @Autowired
    private SrmAcResearchTrainService srmAcResearchTrainService;
    @Autowired
    private SrmAcParttimeApplyService srmAcParttimeApplyService;
    @Autowired
    private SrmAcParttimeInfoService srmAcParttimeInfoService;
    @Autowired
    private SrmMonographInfoService srmMonographInfoService;
    @Autowired
    private SrmMonographInfoAuthorService srmMonographInfoAuthorService;
    @Autowired
    private SrmPatentApplyService srmPatentApplyService;
    @Autowired
    private SrmPatentApplyAuthorService srmPatentApplyAuthorService;
    @Autowired
    private SrmPatentInfoService srmPatentInfoService;
    @Autowired
    private SrmPatentInfoAuthorService srmPatentInfoAuthorService;
    @Autowired
    private SrmProjectSolicitService srmProjectSolicitService;
    @Autowired
    private SrmProjectSolicitMemberService srmProjectSolicitMemberService;
    @Autowired
    private SrmProjectsInfoService srmProjectsInfoService;
    @Autowired
    private SrmProjectsInfoMemberService srmProjectsInfoMemberService;
    @Autowired
    private SrmProjectMidcheckService srmProjectMidcheckService;
    @Autowired
    private SrmProjectFinalcheckService srmProjectFinalcheckService;
    @Override
    public BaseResponse Operate(AppBaseDto appBaseDto) {
        System.out.println(appBaseDto);
        String operateCode= appBaseDto.getOperateCode();
        String appDetail=null;
        BaseDto baseDto=null;
        AppListVo<CombVo> listVo=null;
        Long rowId=null;
        HosUser hosUser = SecurityUtils.getLoginUser();
        String userCode = hosUser.getAccountCode();
        try {
            switch (operateCode){
                case "Test":
                    return BaseResponse.success("ces");
                case "Login-SetInit":
                    appDetail=appBaseDto.getAppDetail();
                    FieldInputSetupDto fieldInputSetupDto= JSONObject.parseObject(appDetail, FieldInputSetupDto.class);
                    return BaseResponse.success(this.getFieldMust(fieldInputSetupDto));
                case "GetAwardLevel":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    listVo=srmAppCommonService.getAwardLevel(baseDto);
                    return BaseResponse.success(listVo);
                case "GetRewardType":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    listVo=srmAppCommonService.getRewardType(baseDto);
                    return BaseResponse.success(listVo);
                case "GetRelyUnit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    listVo=srmAppCommonService.getRelyUnit(baseDto);
                    return BaseResponse.success(listVo);
                case "GetCdProductMode":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    listVo=srmAppCommonService.getProductMode(baseDto);
                    return BaseResponse.success(listVo);
                case "GetYear":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    listVo=srmAppCommonService.getYear(baseDto);
                    return BaseResponse.success(listVo);
                case "GetPaperType":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    listVo=srmAppCommonService.getPaperThesisType(baseDto);
                    return BaseResponse.success(listVo);
                case "GetJournal":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    listVo=srmAppCommonService.getJournal(baseDto);
                    return BaseResponse.success(listVo);
                case "GetJournalType":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    listVo=srmAppCommonService.getJournalType(baseDto);
                    return BaseResponse.success(listVo);
                case "GetClass":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    listVo=srmAppCommonService.getSubjectClass(baseDto);
                    return BaseResponse.success(listVo);
                case "GetDiscipline":
                    appDetail=appBaseDto.getAppDetail();
                    DisciplineDto disciplineDto= JSONObject.parseObject(appDetail, DisciplineDto.class);
                    listVo=srmAppCommonService.getDiscipline(disciplineDto);
                    return BaseResponse.success(listVo);
                case "GetLoc":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    listVo=srmAppCommonService.getDept(baseDto);
                    return BaseResponse.success(listVo);

                case "GetUnitOrder":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    listVo=srmAppCommonService.getUnitOrder(baseDto);
                    return BaseResponse.success(listVo);
                case "GetProject":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    listVo=srmAppCommonService.getProject(baseDto);
                    return BaseResponse.success(listVo);
                case "GetProjectSource":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    listVo=srmAppCommonService.getProjectsource(baseDto);
                    return BaseResponse.success(listVo);
                case "GetUser":
                    appDetail=appBaseDto.getAppDetail();
                    UserDto useDto= JSONObject.parseObject(appDetail, UserDto.class);
                    listVo=srmAppCommonService.getUser(useDto);
                    return BaseResponse.success(listVo);
                case "GetPersonType":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    listVo=srmAppCommonService.getPersonType(baseDto);
                    return BaseResponse.success(listVo);
                case "GetAuthorOrder":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    listVo=srmAppCommonService.getPaperAuthorOrder(baseDto);
                    return BaseResponse.success(listVo);
                case "GetPageSpace":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    listVo=srmAppCommonService.getPageSpace(baseDto);
                    return BaseResponse.success(listVo);
                case "GetPatentType":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    listVo=srmAppCommonService.getPatentType(baseDto);
                    return BaseResponse.success(listVo);
                case "GetAgencyFeeSource":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    listVo=srmAppCommonService.getPatentAgencyFeeSource(baseDto);
                    return BaseResponse.success(listVo);
                case "GetSRMProjType":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    listVo=srmAppCommonService.getProjectType(baseDto);
                    return BaseResponse.success(listVo);

                case "GetApplyBookType":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    listVo=srmAppCommonService.getProjectApplyBookType(baseDto);
                    return BaseResponse.success(listVo);
                case "GetProjLevel":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    listVo=srmAppCommonService.getProjLevel(baseDto);
                    return BaseResponse.success(listVo);
                case "GetProjStatSource":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    listVo=srmAppCommonService.getProjStatSource(baseDto);
                    return BaseResponse.success(listVo);
                case "GetProjCooperateCode":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    listVo=srmAppCommonService.getProjectCooprateForm(baseDto);
                    return BaseResponse.success(listVo);
                case "GetSocioEconomicCode":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    listVo=srmAppCommonService.getSocEconomicObj(baseDto);
                    return BaseResponse.success(listVo);
                case "GetProjOrgFormCode":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    listVo=srmAppCommonService.getProjectOrgForm(baseDto);
                    return BaseResponse.success(listVo);
                case "getNationalEconomyIndustry":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    listVo=srmAppCommonService.getNationalEconomyIndustry(baseDto);
                    return BaseResponse.success(listVo);
                case "GetResearchField":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    listVo=srmAppCommonService.getResearchField(baseDto);
                    return BaseResponse.success(listVo);

                case "Common-GetAuditFlow":
                    appDetail=appBaseDto.getAppDetail();
                    EafRecDto eafRecDto = JSONObject.parseObject(appDetail, EafRecDto.class);
                    List<EafRecVstepNo> eafRecVstepNos= srmEafRecLogService.listAppVStep(eafRecDto);
                    int stepNo=srmEafRecLogService.getCurStep(eafRecDto);
                    return BaseResponse.success(new AppListVo<>(1,9999,stepNo ,eafRecVstepNos));
                case "Common-GetUserInfo":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    UserVo userVo =srmUserService.getUserDetail(String.valueOf(baseDto.getId()),null);
                    AppChange<UserVo> userVoAppChange=new AppChange<>();
                    return BaseResponse.success(userVoAppChange.changeToJson(userVo));

                case "File-FileTypeList":
                    appDetail=appBaseDto.getAppDetail();
                    AppxfileTypeDetailDto appxfileTypeDetailDto= JSONObject.parseObject(appDetail, AppxfileTypeDetailDto.class);
                    //appxfileTypeDetailDto.setRows(appxfileTypeDetailDto.getLimit());
                    IPage<AppxfileTypeVo> appxfileTypeVoIPage=srmAppxfileTypeService.listAppxfileType(appxfileTypeDetailDto);
                    List<AppxfileTypeVo> list=appxfileTypeVoIPage.getRecords();
                    List<CombVo> combVos=new ArrayList<>();
                    for(AppxfileTypeVo appxfileTypeVo:list){
                        CombVo combVo=new CombVo();
                        combVo.setId(appxfileTypeVo.getCode());
                        combVo.setName(appxfileTypeVo.getName());
                        combVos.add(combVo);
                    }
                     return BaseResponse.success(new AppListVo<>(appxfileTypeDetailDto.getPage(),appxfileTypeDetailDto.getLimit(),combVos));
                case "File-FileList":
                    appDetail=appBaseDto.getAppDetail();
                    UploadInfoDto uploadInfoDto= JSONObject.parseObject(appDetail, UploadInfoDto.class);
                    List<UploadInfoVo> uploadInfoVoList = srmUploadInfoService.listUploadInfo(uploadInfoDto);
                    return BaseResponse.success(new AppListVo<>(1,999,uploadInfoVoList.size() ,uploadInfoVoList));
                case "File-DeleFile":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmUploadInfoService.deletFile(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","删除成功",""));
                case "Login-listMessage":
                    appDetail=appBaseDto.getAppDetail();
                    AppMessageDto appMessageDto = JSONObject.parseObject(appDetail, AppMessageDto.class);
                    IPage<AppMessageVo> appMessageVoIPage =srmAppMessageService.listAppMessage(appMessageDto);
                    List<AppMessageVo> appMessageVoList=appMessageVoIPage.getRecords();
                    return BaseResponse.success(new AppListVo<>((int)appMessageVoIPage.getCurrent(),(int)appMessageVoIPage.getSize(),(int)appMessageVoIPage.getTotal() ,appMessageVoList));
                case "Paper-GetApplyPaper":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    listVo=new AppListVo<>(1,9999,srmPaperService.getPaperApply(userCode));
                    return BaseResponse.success(listVo);
                case "ApplyPaper-List":
                    appDetail=appBaseDto.getAppDetail();
                    PaperSubmissionApplyDto paperSubmissionApplyDto = JSONObject.parseObject(appDetail, PaperSubmissionApplyDto.class);
                    IPage<PaperSubmissionApplyVo> listPaperSubmissionApply =srmPaperSubmissionApplyService.listPaperSubmissionApply(paperSubmissionApplyDto);
                    List<PaperSubmissionApplyVo> paperSubmissionApplyVos=listPaperSubmissionApply.getRecords();
                    return BaseResponse.success(new AppListVo<>((int)listPaperSubmissionApply.getCurrent(),(int)listPaperSubmissionApply.getSize(),(int)listPaperSubmissionApply.getTotal() ,paperSubmissionApplyVos));
                case "ApplyPaper-Delete":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmPaperSubmissionApplyService.delete(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","删除成功",""));
                case "ApplyPaper-Save":
                    appDetail=appBaseDto.getAppDetail();
                    PaperSubmissionApplyDto paperSubmissionApplyDto1= JSONObject.parseObject(appDetail, PaperSubmissionApplyDto.class);
                    rowId=srmPaperSubmissionApplyService.savePaperSubmissionApply(paperSubmissionApplyDto1);
                    //AppResultVo appResultVo=new AppResultVo(0,String.valueOf(rowId),"保存成功","");
                    return BaseResponse.success(new AppResultVo(0,String.valueOf(rowId),"保存成功",""));
                case "ApplyPaper-GetDetail":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    PaperSubmissionApplyVo paperSubmissionApplyVo =srmPaperSubmissionApplyService.getDetail(baseDto.getId());
                    AppChange<PaperSubmissionApplyVo> paperSubmissionApplyVoAppChange=new AppChange<>();
                    return BaseResponse.success(paperSubmissionApplyVoAppChange.changeToJson(paperSubmissionApplyVo));
                case "ApplyPaper-Submit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmPaperSubmissionApplyService.subMit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","提交成功",""));
                case "ApplyPaper-Audit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmPaperSubmissionApplyService.audit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","操作成功",""));
                case "Paper-Save":
                    appDetail=appBaseDto.getAppDetail();
                    PaperMainDto paperMainDto= JSONObject.parseObject(appDetail, PaperMainDto.class);
                    rowId=srmPaperService.savePaper(paperMainDto);
                    AppResultVo appResultVo=new AppResultVo(0,String.valueOf(rowId),"保存成功","");
                    return BaseResponse.success(appResultVo);
                case "Paper-GetDetail":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    PaperVo srmPaperVo =srmPaperService.getDetail(String.valueOf(baseDto.getId()));
                    AppChange<PaperVo> appChange=new AppChange<>();
                    return BaseResponse.success(appChange.changeToJson(srmPaperVo));
                case "Paper-List":
                    appDetail=appBaseDto.getAppDetail();
                    PaperDto paperDto = JSONObject.parseObject(appDetail, PaperDto.class);
                    IPage<PaperVo> listPaper =srmPaperService.listPaper(paperDto);
                    List<PaperVo> paperVoList=listPaper.getRecords();
                    AppListVo<PaperVo> appListVo=new AppListVo<>((int)listPaper.getCurrent(),(int)listPaper.getSize(),(int)listPaper.getTotal() ,paperVoList);
                    return BaseResponse.success(appListVo);
                case "Paper-Delete":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmPaperService.deletePaper(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","删除成功",""));
                case "Paper-Submit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmPaperService.subMit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","提交成功",""));
                case "Paper-GetAuthor":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    List<PaperAuthorVo> paperAuthorVos = srmPaperAuthorService.listPaperAuthor(baseDto);
                    return BaseResponse.success(new AppListVo<>(1,999,paperAuthorVos.size() ,paperAuthorVos));
                case "Paper-AddAuthor":
                    appDetail=appBaseDto.getAppDetail();
                    PaperAuthorDto paperAuthorDto= JSONObject.parseObject(appDetail, PaperAuthorDto.class);
                    rowId=srmPaperAuthorService.saveAuthor(paperAuthorDto);
                    return BaseResponse.success(new AppResultVo(0,String.valueOf(rowId),"保存成功",""));
                case "Paper-Audit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmPaperService.audit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","操作成功",""));
                case "Paper-DelAuthor":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmPaperAuthorService.deleteAuthorById(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","删除成功",""));
                case "AwardApply-ListAwardApply":
                    appDetail=appBaseDto.getAppDetail();
                    AwardApplyDto awardApplyDto = JSONObject.parseObject(appDetail, AwardApplyDto.class);
                    IPage<AwardApplyVo> awardApplyVoIPage =srmAwardApplyService.listAwardApply(awardApplyDto);
                    List<AwardApplyVo> awardApplyVos=awardApplyVoIPage.getRecords();
                    return BaseResponse.success(new AppListVo<>((int)awardApplyVoIPage.getCurrent(),(int)awardApplyVoIPage.getSize(),(int)awardApplyVoIPage.getTotal() ,awardApplyVos));
                case "AwardApply-Delete":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmAwardApplyService.deleteAwardApply(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","删除成功",""));
                case "AwardApply-Save":
                    appDetail=appBaseDto.getAppDetail();
                    AwardApplyMainDto awardApplyMainDto= JSONObject.parseObject(appDetail, AwardApplyMainDto.class);
                    rowId=srmAwardApplyService.saveAwardApply(awardApplyMainDto);
                    //AppResultVo appResultVo=new AppResultVo(0,String.valueOf(rowId),"保存成功","");
                    return BaseResponse.success(new AppResultVo(0,String.valueOf(rowId),"保存成功",""));
                case "AwardApply-GetDetail":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    AwardApplyVo awardApplyVo =srmAwardApplyService.getDetail(String.valueOf(baseDto.getId()));
                    AppChange<AwardApplyVo> awardApplyVoAppChange=new AppChange<>();
                    return BaseResponse.success(awardApplyVoAppChange.changeToJson(awardApplyVo));
                case "AwardApply-Submit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmAwardApplyService.subMit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","提交成功",""));
                case "AwardApply-Audit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmAwardApplyService.audit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","操作成功",""));
                case "AwardApply-ListAuthor":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    List<AwardApplyAuthorVo> awardApplyAuthorVos = srmAwardApplyAuthorService.listAwardApplyAuthor(baseDto);
                    return BaseResponse.success(new AppListVo<>(1,999,awardApplyAuthorVos.size() ,awardApplyAuthorVos));
                case "AwardApply-AddAuthor":
                    appDetail=appBaseDto.getAppDetail();
                    AwardApplyAuthorDto awardApplyAuthorDto= JSONObject.parseObject(appDetail, AwardApplyAuthorDto.class);
                    rowId=srmAwardApplyAuthorService.saveAuthor(awardApplyAuthorDto);
                    return BaseResponse.success(new AppResultVo(0,String.valueOf(rowId),"保存成功",""));
                case "AwardApply-DelAuthor":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmAwardApplyAuthorService.deleteAuthorById(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","删除成功",""));

                case "AwardReg-List":
                    appDetail=appBaseDto.getAppDetail();
                    AchievementDto achievementDto = JSONObject.parseObject(appDetail, AchievementDto.class);
                    IPage<AchievementVo> achievementVoIPage =srmAchievementService.listAchievement(achievementDto);
                    List<AchievementVo> achievementVos=achievementVoIPage.getRecords();
                    return BaseResponse.success(new AppListVo<>((int)achievementVoIPage.getCurrent(),(int)achievementVoIPage.getSize(),(int)achievementVoIPage.getTotal() ,achievementVos));
                case "AwardReg-Delete":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmAchievementService.deleteAchievement(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","删除成功",""));
                case "AwardReg-Save":
                    appDetail=appBaseDto.getAppDetail();
                    AchievementMainDto achievementMainDto= JSONObject.parseObject(appDetail, AchievementMainDto.class);
                    rowId=srmAchievementService.saveAchievement(achievementMainDto);
                    //AppResultVo appResultVo=new AppResultVo(0,String.valueOf(rowId),"保存成功","");
                    return BaseResponse.success(new AppResultVo(0,String.valueOf(rowId),"保存成功",""));
                case "AwardReg-GetDetail":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    AchievementVo achievementVo =srmAchievementService.getDetail(String.valueOf(baseDto.getId()));
                    AppChange<AchievementVo> applyVoAppChange=new AppChange<>();
                    return BaseResponse.success(applyVoAppChange.changeToJson(achievementVo));
                case "AwardReg-Submit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmAchievementService.subMit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","提交成功",""));
                case "AwardReg-Audit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmAchievementService.audit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","操作成功",""));
                case "AwardReg-ListAuthor":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    List<AchievementAuthorVo> achievementAuthorVos = srmAchievementAuthorService.listAchievementAuthor(baseDto);
                    return BaseResponse.success(new AppListVo<>(1,999,achievementAuthorVos.size() ,achievementAuthorVos));
                case "AwardReg-AddAuthor":
                    appDetail=appBaseDto.getAppDetail();
                    AchievementAuthorDto achievementAuthorDto= JSONObject.parseObject(appDetail, AchievementAuthorDto.class);
                    rowId=srmAchievementAuthorService.saveAuthor(achievementAuthorDto);
                   return BaseResponse.success(new AppResultVo(0,String.valueOf(rowId),"保存成功",""));
                case "AwardReg-DelAuthor":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmAchievementAuthorService.deleteAuthorById(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","删除成功",""));
                case "Monograph-List":
                    appDetail=appBaseDto.getAppDetail();
                    MonographDetailDto monographDetailDto = JSONObject.parseObject(appDetail, MonographDetailDto.class);
                    IPage<MonographVo> monographVoIPage =srmMonographInfoService.listMonograph(monographDetailDto);
                    List<MonographVo> monographVos=monographVoIPage.getRecords();
                    return BaseResponse.success(new AppListVo<>((int)monographVoIPage.getCurrent(),(int)monographVoIPage.getSize(),(int)monographVoIPage.getTotal() ,monographVos));
                case "Monograph-Delete":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmMonographInfoService.deleteMonograph(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","删除成功",""));
                case "Monograph-Save":
                    appDetail=appBaseDto.getAppDetail();
                    MonographDto monographDto= JSONObject.parseObject(appDetail, MonographDto.class);
                    rowId=srmMonographInfoService.saveOrUpdateMon(monographDto);
                    //AppResultVo appResultVo=new AppResultVo(0,String.valueOf(rowId),"保存成功","");
                    return BaseResponse.success(new AppResultVo(0,String.valueOf(rowId),"保存成功",""));
                case "Monograph-GetDetail":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    MonographVo monographVo =srmMonographInfoService.getDetail(baseDto.getId());
                    AppChange<MonographVo> monographVoAppChange=new AppChange<>();
                    return BaseResponse.success(monographVoAppChange.changeToJson(monographVo));
                case "Monograph-Submit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmMonographInfoService.subMit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","提交成功",""));
                case "Monograph-Audit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmMonographInfoService.audit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","操作成功",""));
                case "Monograph-ListAuthor":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    List<MonographAuthorVo> monographAuthorVos = srmMonographInfoAuthorService.ListMonographAuthor(baseDto.getId());
                    return BaseResponse.success(new AppListVo<>(1,999,monographAuthorVos.size() ,monographAuthorVos));
                case "Monograph-AddAuthor":
                    appDetail=appBaseDto.getAppDetail();
                    MonographAuthorDto monographAuthorDto= JSONObject.parseObject(appDetail, MonographAuthorDto.class);
                    rowId=srmMonographInfoAuthorService.saveAuthor(monographAuthorDto);
                    return BaseResponse.success(new AppResultVo(0,String.valueOf(rowId),"保存成功",""));
                case "Monograph-DelAuthor":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmMonographInfoAuthorService.deleteMonographAuthor(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","删除成功",""));
                case "PatentApply-List":
                    appDetail=appBaseDto.getAppDetail();
                    PatentApplyDto patentApplyDto = JSONObject.parseObject(appDetail, PatentApplyDto.class);
                    IPage<PatentApplyVo> patentApplyVoIPage =srmPatentApplyService.listPatentApply(patentApplyDto);
                    List<PatentApplyVo> patentApplyVos=patentApplyVoIPage.getRecords();
                    return BaseResponse.success(new AppListVo<>((int)patentApplyVoIPage.getCurrent(),(int)patentApplyVoIPage.getSize(),(int)patentApplyVoIPage.getTotal() ,patentApplyVos));
                case "PatentApply-Delete":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmPatentApplyService.deletePatentApply(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","删除成功",""));
                case "PatentApply-Save":
                    appDetail=appBaseDto.getAppDetail();
                    PatentApplyMainDto patentApplyMainDto= JSONObject.parseObject(appDetail, PatentApplyMainDto.class);
                    rowId=srmPatentApplyService.savePatentApply(patentApplyMainDto);
                    //AppResultVo appResultVo=new AppResultVo(0,String.valueOf(rowId),"保存成功","");
                    return BaseResponse.success(new AppResultVo(0,String.valueOf(rowId),"保存成功",""));
                case "PatentApply-GetDetail":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    PatentApplyVo patentApplyVo =srmPatentApplyService.getDetail(String.valueOf(baseDto.getId()));
                    AppChange<PatentApplyVo> patentApplyVoAppChange=new AppChange<>();
                    return BaseResponse.success(patentApplyVoAppChange.changeToJson(patentApplyVo));
                case "PatentApply-Submit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmPatentApplyService.subMit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","提交成功",""));
                case "PatentApply-Audit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmPatentApplyService.audit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","操作成功",""));
                case "PatentApply-ListAuthor":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    List<PatentApplyAuthorVo> patentApplyAuthorVos = srmPatentApplyAuthorService.listPatentApplyAuthor(baseDto);
                    return BaseResponse.success(new AppListVo<>(1,999,patentApplyAuthorVos.size() ,patentApplyAuthorVos));
                case "PatentApply-AddAuthor":
                    appDetail=appBaseDto.getAppDetail();
                    PatentApplyAuthorDto patentApplyAuthorDto= JSONObject.parseObject(appDetail, PatentApplyAuthorDto.class);
                    rowId=srmPatentApplyAuthorService.saveAuthor(patentApplyAuthorDto);
                    return BaseResponse.success(new AppResultVo(0,String.valueOf(rowId),"保存成功",""));
                case "PatentApply-DelAuthor":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmPatentApplyAuthorService.deleteAuthorById(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","删除成功",""));

                case "PatentApply-ListUnitPeron":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    List<UnitPeronVo> unitPeronVos = srmPatentApplyService.listPatentee(baseDto.getId());
                    return BaseResponse.success(new AppListVo<>(1,999,unitPeronVos.size() ,unitPeronVos));
                case "PatentApply-AddUnitPeron":
                    appDetail=appBaseDto.getAppDetail();
                    //PatentApplyAuthorDto patentApplyAuthorDto= JSONObject.parseObject(appDetail, PatentApplyAuthorDto.class);
                    //rowId=srmPatentApplyAuthorService.saveAuthor(patentApplyAuthorDto);
                    //return BaseResponse.success(new AppResultVo(0,String.valueOf(rowId),"保存成功",""));
                case "PatentApply-DelUnitPeron":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmPatentApplyService.deletePatentee(baseDto.getRowStr());
                    return BaseResponse.success(new AppResultVo(0,"","删除成功",""));


                case "Patent-List":
                    appDetail=appBaseDto.getAppDetail();
                    PatentInfoDto patentInfoDto= JSONObject.parseObject(appDetail, PatentInfoDto.class);
                    IPage<PatentInfoVo> patentInfoVoIPage =srmPatentInfoService.listPatentInfo(patentInfoDto);
                    List<PatentInfoVo> patentInfoVos=patentInfoVoIPage.getRecords();
                    return BaseResponse.success(new AppListVo<>((int)patentInfoVoIPage.getCurrent(),(int)patentInfoVoIPage.getSize(),(int)patentInfoVoIPage.getTotal() ,patentInfoVos));
                case "Patent-Delete":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmPatentInfoService.deletePatentInfo(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","删除成功",""));
                case "Patent-Save":
                    appDetail=appBaseDto.getAppDetail();
                    PatentInfoMainDto patentInfoMainDto= JSONObject.parseObject(appDetail, PatentInfoMainDto.class);
                    rowId=srmPatentInfoService.savePatentInfo(patentInfoMainDto);
                    //AppResultVo appResultVo=new AppResultVo(0,String.valueOf(rowId),"保存成功","");
                    return BaseResponse.success(new AppResultVo(0,String.valueOf(rowId),"保存成功",""));
                case "Patent-GetDetail":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    PatentInfoVo patentInfoVo =srmPatentInfoService.getDetail(baseDto.getId());
                    AppChange<PatentInfoVo> patentInfoVoAppChange=new AppChange<>();
                    return BaseResponse.success(patentInfoVoAppChange.changeToJson(patentInfoVo));
                case "Patent-Submit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmPatentInfoService.subMit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","提交成功",""));
                case "Patent-Audit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmPatentInfoService.audit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","操作成功",""));
                case "Patent-GetPatentApply":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    listVo=new AppListVo<>(1,9999,srmPatentInfoService.getPatentApply(userCode));
                    return BaseResponse.success(listVo);
                case "Patent-ListAuthor":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    List<PatentInfoAuthorVo> patentInfoAuthorVos = srmPatentInfoAuthorService.listPatentInfoAuthor(baseDto);
                    return BaseResponse.success(new AppListVo<>(1,999,patentInfoAuthorVos.size() ,patentInfoAuthorVos));
                case "Patent-AddAuthor":
                    appDetail=appBaseDto.getAppDetail();
                    PatentInfoAuthorDto patentInfoAuthorDto= JSONObject.parseObject(appDetail, PatentInfoAuthorDto.class);
                    rowId=srmPatentInfoAuthorService.saveAuthor(patentInfoAuthorDto);
                    return BaseResponse.success(new AppResultVo(0,String.valueOf(rowId),"保存成功",""));
                case "Patent-DelAuthor":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmPatentInfoAuthorService.deleteAuthorById(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","删除成功",""));

                case "Patent-ListUnitPeron":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    //List<UnitPeronVo> unitPeronVos = srmPatentApplyService.listPatentee(baseDto.getId());
                    //return BaseResponse.success(new AppListVo<>(1,999,unitPeronVos.size() ,unitPeronVos));
                case "Patent-AddUnitPeron":
                    appDetail=appBaseDto.getAppDetail();
                    //PatentApplyAuthorDto patentApplyAuthorDto= JSONObject.parseObject(appDetail, PatentApplyAuthorDto.class);
                    //rowId=srmPatentApplyAuthorService.saveAuthor(patentApplyAuthorDto);
                    //return BaseResponse.success(new AppResultVo(0,String.valueOf(rowId),"保存成功",""));
                case "Patent-DelUnitPeron":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmPatentApplyService.deletePatentee(baseDto.getRowStr());
                    return BaseResponse.success(new AppResultVo(0,"","删除成功",""));
                case "HostMeeting-List":
                    IPage<AcConferenceHostVo> listMeeting =null;
                    appDetail=appBaseDto.getAppDetail();
                    AcConferenceHostDto acConferenceHostDto = JSONObject.parseObject(appDetail, AcConferenceHostDto.class);
                    listMeeting =srmAcConferenceHostService.listAcConferenceHost(acConferenceHostDto);
                    List<AcConferenceHostVo> meetingVoList=listMeeting.getRecords();
                    AppListVo<AcConferenceHostVo> meetingListVo=new AppListVo<>((int)listMeeting.getCurrent(),(int)listMeeting.getSize(),(int)listMeeting.getTotal() ,meetingVoList);
                    return BaseResponse.success(meetingListVo);
                case "HostMeeting-Save":
                    appDetail=appBaseDto.getAppDetail();
                    AcConferenceHostDto acConferenceHostSaveDto= JSONObject.parseObject(appDetail, AcConferenceHostDto.class);
                    rowId=srmAcConferenceHostService.saveAcConferenceHost(acConferenceHostSaveDto);
                    return BaseResponse.success(new AppResultVo(0,String.valueOf(rowId),"保存成功",""));
                case "HostMeeting-GetDetail":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    AcConferenceHostVo acConferenceHostVo =srmAcConferenceHostService.getDetail(baseDto.getId());
                    AppChange<AcConferenceHostVo> conferenceChange=new AppChange<>();
                    return BaseResponse.success(conferenceChange.changeToJson(acConferenceHostVo));
                case "HostMeeting-Submit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmAcConferenceHostService.subMit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","提交成功",""));
                case "HostMeeting-Delete":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmAcConferenceHostService.deleteAcConferenceHost(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","删除成功",""));
                case "HostMeeting-Audit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmAcConferenceHostService.audit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","操作成功",""));
                case "GetMeetingType":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    listVo=srmAppCommonService.getConferenceType(baseDto);
                    return BaseResponse.success(listVo);

                case "OutgoingMeeting-Audit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmAcMeetingManageService.audit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","操作成功",""));
                case "OutgoingMeeting-List":
                    IPage<AcMeetingManageVo> listOutMeeting =null;
                    appDetail=appBaseDto.getAppDetail();
                    AcMeetingManageDto acMeetingManageDto = JSONObject.parseObject(appDetail, AcMeetingManageDto.class);
                    acMeetingManageDto.setMeetingName(JSONObject.parseObject(appDetail).getString("desc"));
                    listOutMeeting =srmAcMeetingManageService.listAcMeetingManage(acMeetingManageDto);
                    List<AcMeetingManageVo> meetingVo1List=listOutMeeting.getRecords();
                    AppListVo<AcMeetingManageVo> appMeetingManageVoList=new AppListVo<>((int)listOutMeeting.getCurrent(),(int)listOutMeeting.getSize(),(int)listOutMeeting.getTotal() ,meetingVo1List);
                    return BaseResponse.success(appMeetingManageVoList);
                case "OutgoingMeeting-GetDetail":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    AcMeetingManageVo mmDetailVo =srmAcMeetingManageService.getDetailAcMeetingManage(baseDto.getId());
                    AppChange<AcMeetingManageVo> mmDetailChange=new AppChange<>();
                    return BaseResponse.success(mmDetailChange.changeToJson(mmDetailVo));
                case "OutgoingMeeting-Save":
                    appDetail=appBaseDto.getAppDetail();
                    AcMeetingManageDto acMeetingSaveDto= JSONObject.parseObject(appDetail, AcMeetingManageDto.class);
                    rowId=srmAcMeetingManageService.saveOrUpdateAcMeetingManage(acMeetingSaveDto);
                    return BaseResponse.success(new AppResultVo(0,String.valueOf(rowId),"保存成功",""));
                case "OutgoingMeeting-Submit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmAcMeetingManageService.submitAcMeetingManage(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","提交成功",""));
                case "OutgoingMeeting-Delete":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmAcMeetingManageService.deleteAcMeetingManage(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","删除成功",""));
                case "Lecture-List":
                    IPage<AcLectureVo> listLecture =null;
                    appDetail=appBaseDto.getAppDetail();
                    AcLectureDto acLectureDto = JSONObject.parseObject(appDetail, AcLectureDto.class);
                    listLecture=srmAcLectureService.listAcLecture(acLectureDto);
                    List<AcLectureVo> lectureVoList=listLecture.getRecords();
                    AppListVo<AcLectureVo> appLectureVoList=new AppListVo<>((int)listLecture.getCurrent(),(int)listLecture.getSize(),(int)listLecture.getTotal() ,lectureVoList);
                    return BaseResponse.success(appLectureVoList);
                case "Lecture-GetDetail":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    AcLectureVo acLectureVo =srmAcLectureService.getDetail(baseDto.getId());
                    AppChange<AcLectureVo> lectureDetailChange=new AppChange<>();
                    return BaseResponse.success(lectureDetailChange.changeToJson(acLectureVo));
                case "Lecture-Save":
                    appDetail=appBaseDto.getAppDetail();
                    AcLectureDto acLectureSaveDto= JSONObject.parseObject(appDetail, AcLectureDto.class);
                    rowId=srmAcLectureService.saveAcLecture(acLectureSaveDto);
                    return BaseResponse.success(new AppResultVo(0,String.valueOf(rowId),"保存成功",""));
                case "Lecture-Submit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmAcLectureService.subMit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","提交成功",""));
                case "Lecture-Audit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmAcLectureService.audit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","操作成功",""));
                case "Lecture-Delete":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmAcLectureService.deleteAcLecture(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","删除成功",""));
                case "GetLectureType":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    listVo=srmAppCommonService.getLectureType(baseDto);
                    return BaseResponse.success(listVo);
                case "GetLectureLevel":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    listVo=srmAppCommonService.getLectureLevel(baseDto);
                    return BaseResponse.success(listVo);
                case "GetPersonTitle":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    listVo=srmAppCommonService.getUserTitle(baseDto);
                case "researchTrain-List":
                    IPage<AcResearchTrainVo> listResearchTrain =null;
                    appDetail=appBaseDto.getAppDetail();
                    AcResearchTrainDto acResearchTrainDto = JSONObject.parseObject(appDetail, AcResearchTrainDto.class);
                    listResearchTrain=srmAcResearchTrainService.listAcResearchTrain(acResearchTrainDto);
                    List<AcResearchTrainVo> researchTrainVoList=listResearchTrain.getRecords();
                    AppListVo<AcResearchTrainVo> appResearchTrainVoList=new AppListVo<>((int)listResearchTrain.getCurrent(),(int)listResearchTrain.getSize(),(int)listResearchTrain.getTotal() ,researchTrainVoList);
                    return BaseResponse.success(appResearchTrainVoList);
                case "researchTrain-GetDetail":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    AcResearchTrainVo acResearchTrainVo =srmAcResearchTrainService.getDetail(baseDto.getId());
                    AppChange<AcResearchTrainVo> researchTrainDetailChange=new AppChange<>();
                    return BaseResponse.success(researchTrainDetailChange.changeToJson(acResearchTrainVo));
                case "researchTrain-Save":
                    appDetail=appBaseDto.getAppDetail();
                    AcResearchTrainDto acResearchTrainSaveDto= JSONObject.parseObject(appDetail, AcResearchTrainDto.class);
                    rowId=srmAcResearchTrainService.saveAcResearchTrain(acResearchTrainSaveDto);
                    return BaseResponse.success(new AppResultVo(0,String.valueOf(rowId),"保存成功",""));
                case "researchTrain-Submit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmAcResearchTrainService.subMit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","提交成功",""));
                case "Training-Audit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmAcResearchTrainService.audit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","操作成功",""));
                case "Training-Delete":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmAcResearchTrainService.deleteAcResearchTrain(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","删除成功",""));
                case "PartTimeApply-List":
                    IPage<AcParttimeApplyVo> parttimeApplyList =null;
                    appDetail=appBaseDto.getAppDetail();
                    AcParttimeApplyDto acParttimeApplyDto = JSONObject.parseObject(appDetail, AcParttimeApplyDto.class);
                    parttimeApplyList=srmAcParttimeApplyService.listAcParttimeApply(acParttimeApplyDto);
                    List<AcParttimeApplyVo> parttimeApplyVoList=parttimeApplyList.getRecords();
                    AppListVo<AcParttimeApplyVo> appParttimeApplyVoList=new AppListVo<>((int)parttimeApplyList.getCurrent(),(int)parttimeApplyList.getSize(),(int)parttimeApplyList.getTotal() ,parttimeApplyVoList);
                    return BaseResponse.success(appParttimeApplyVoList);
                case "PartTimeApply-GetDetail":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    AcParttimeApplyVo acParttimeApplyVo =srmAcParttimeApplyService.getDetail(baseDto.getId());
                    AppChange<AcParttimeApplyVo> parttimeApplyDetailChange=new AppChange<>();
                    return BaseResponse.success(parttimeApplyDetailChange.changeToJson(acParttimeApplyVo));
                case "PartTimeApply-Audit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmAcParttimeApplyService.audit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","操作成功",""));
                case "PartTimeApply-Save":
                    appDetail=appBaseDto.getAppDetail();
                    AcParttimeApplyDto AcParttimeApplSaveDto= JSONObject.parseObject(appDetail, AcParttimeApplyDto.class);
                    rowId=srmAcParttimeApplyService.saveAcParttimeApply(AcParttimeApplSaveDto);
                    return BaseResponse.success(new AppResultVo(0,String.valueOf(rowId),"保存成功",""));
                case "PartTimeApply-Submit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmAcParttimeApplyService.subMit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","提交成功",""));
                case "PartTimeApply-Delete":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmAcParttimeApplyService.deleteAcParttimeApply(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","删除成功",""));

                case "GetCommit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    listVo=srmAppCommonService.getCommitteeInfo(baseDto);
                    return BaseResponse.success(listVo);
                case "GetPartTimeJobs":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    listVo=srmAppCommonService.getPartTimeJob(baseDto);
                    return BaseResponse.success(listVo);
                case "GetPartTimeType":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    listVo=srmAppCommonService.getParttimeType(baseDto);
                    return BaseResponse.success(listVo);
                case "PartTimeReg-List":
                    IPage<AcParttimeInfoVo> parttimeInfoList =null;
                    appDetail=appBaseDto.getAppDetail();
                    AcParttimeInfoDto acParttimeInfoDto = JSONObject.parseObject(appDetail, AcParttimeInfoDto.class);
                    parttimeInfoList=srmAcParttimeInfoService.listAcParttimeInfo(acParttimeInfoDto);
                    List<AcParttimeInfoVo> parttimeInfoVoList=parttimeInfoList.getRecords();
                    AppListVo<AcParttimeInfoVo> appParttimeInfoVoList=new AppListVo<>((int)parttimeInfoList.getCurrent(),(int)parttimeInfoList.getSize(),(int)parttimeInfoList.getTotal() ,parttimeInfoVoList);
                    return BaseResponse.success(appParttimeInfoVoList);
                case "PartTimeReg-GetDetail":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    AcParttimeInfoVo acParttimeInfoVo =srmAcParttimeInfoService.getDetail(baseDto.getId());
                    AppChange<AcParttimeInfoVo> parttimeInfoDetailChange=new AppChange<>();
                    return BaseResponse.success(parttimeInfoDetailChange.changeToJson(acParttimeInfoVo));
                case "PartTimeReg-Save":
                    appDetail=appBaseDto.getAppDetail();
                    AcParttimeInfoDto AcParttimeInfoSaveDto= JSONObject.parseObject(appDetail, AcParttimeInfoDto.class);
                    rowId=srmAcParttimeInfoService.saveAcParttimeInfo(AcParttimeInfoSaveDto);
                    return BaseResponse.success(new AppResultVo(0,String.valueOf(rowId),"保存成功",""));
                case "PartTimeReg-Submit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmAcParttimeInfoService.subMit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","提交成功",""));
                case "PartTimeReg-Audit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmAcParttimeInfoService.audit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","操作成功",""));
                case "PartTimeReg-Delete":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmAcParttimeInfoService.deleteAcParttimeInfo(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","删除成功",""));

                case "ProjectApplication-List":
                    appDetail=appBaseDto.getAppDetail();
                    ProjectSolicitDto projectSolicitDto= JSONObject.parseObject(appDetail, ProjectSolicitDto.class);
                    IPage<ProjectSolicitVo> projectSolicitVoIPage =srmProjectSolicitService.listProjectSolicit(projectSolicitDto);
                    List<ProjectSolicitVo> projectSolicitVos=projectSolicitVoIPage.getRecords();
                    return BaseResponse.success(new AppListVo<>((int)projectSolicitVoIPage.getCurrent(),(int)projectSolicitVoIPage.getSize(),(int)projectSolicitVoIPage.getTotal() ,projectSolicitVos));
                case "ProjectApplication-Delete":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmProjectSolicitService.deleteProjectSolicit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","删除成功",""));
                case "ProjectApplication-Save":
                    appDetail=appBaseDto.getAppDetail();
                    ProjectSolicitMainDto projectSolicitMainDto= JSONObject.parseObject(appDetail, ProjectSolicitMainDto.class);
                    rowId=srmProjectSolicitService.saveProjectSolicit(projectSolicitMainDto);
                    //AppResultVo appResultVo=new AppResultVo(0,String.valueOf(rowId),"保存成功","");
                    return BaseResponse.success(new AppResultVo(0,String.valueOf(rowId),"保存成功",""));
                case "ProjectApplication-GetDetail":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    ProjectSolicitVo projectSolicitVo =srmProjectSolicitService.getDetail(String.valueOf(baseDto.getId()));
                    AppChange<ProjectSolicitVo> projectSolicitVoAppChange=new AppChange<>();
                    return BaseResponse.success(projectSolicitVoAppChange.changeToJson(projectSolicitVo));
                case "ProjectApplication-Submit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmProjectSolicitService.subMit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","提交成功",""));
                case "ProjectApplication-HeaderAudit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmProjectSolicitService.headerAudit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","操作成功",""));
                case "ProjectApplication-preAudit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmProjectSolicitService.preAudit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","操作成功",""));
                case "ProjectApplication-finalAudit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmProjectSolicitService.finalAudit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","操作成功",""));
                case "ProjectApplication-getProjectSolicitStatus":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    String resStatus=srmProjectSolicitService.getProjectSolicitStatus(String.valueOf(baseDto.getId()));
                    return BaseResponse.success(new AppResultVo(0,"","操作成功",resStatus));

                case "ProjectApplication-ListAuthor":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    List<ProjectSolicitMemberVo> projectSolicitMemberVos = srmProjectSolicitMemberService.listProjectSolicitMember(baseDto);
                    return BaseResponse.success(new AppListVo<>(1,999,projectSolicitMemberVos.size() ,projectSolicitMemberVos));
                case "ProjectApplication-AddAuthor":
                    appDetail=appBaseDto.getAppDetail();
                    ProjectSolicitMemberDto projectSolicitMemberDto= JSONObject.parseObject(appDetail, ProjectSolicitMemberDto.class);
                    rowId=srmProjectSolicitMemberService.saveAuthor(projectSolicitMemberDto);
                    return BaseResponse.success(new AppResultVo(0,String.valueOf(rowId),"保存成功",""));
                case "ProjectApplication-DelAuthor":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmProjectSolicitMemberService.deleteAuthorById(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","删除成功",""));
                case "ProjectApplication-GetPlan":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    listVo=new AppListVo<>(1,9999,srmProjectSolicitService.getApplyInfo());
                    return BaseResponse.success(listVo);

                case "VerticalProject-Save":
                    appDetail=appBaseDto.getAppDetail();
                    ProjectsInfoVerticalDto projectsInfoVerticalDto= JSONObject.parseObject(appDetail, ProjectsInfoVerticalDto.class);
                    rowId=srmProjectsInfoService.saveVerticalProjectsInfo(projectsInfoVerticalDto);
                    return BaseResponse.success(new AppResultVo(0,String.valueOf(rowId),"保存成功",""));
                case "VerticalProject-GetDetail":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    ProjectsInfoVo projectsInfoVo =srmProjectsInfoService.getVerticalDetail(baseDto.getId());
                    AppChange<ProjectsInfoVo> projectsInfoVoAppChange=new AppChange<>();
                    System.out.println(projectsInfoVoAppChange.changeToJson(projectsInfoVo));
                    return BaseResponse.success(projectsInfoVoAppChange.changeToJson(projectsInfoVo));
                case "VerticalProject-List":
                    appDetail=appBaseDto.getAppDetail();
                    ProjectsInfoDto projectsInfoDto = JSONObject.parseObject(appDetail, ProjectsInfoDto.class);
                    IPage<ProjectsInfoVo> projectsInfoVoIPage =srmProjectsInfoService.listVerticalProject(projectsInfoDto);
                    List<ProjectsInfoVo> projectsInfoVos=projectsInfoVoIPage.getRecords();
                    return BaseResponse.success(new AppListVo<>((int)projectsInfoVoIPage.getCurrent(),(int)projectsInfoVoIPage.getSize(),(int)projectsInfoVoIPage.getTotal() ,projectsInfoVos));
                case "VerticalProject-Delete":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmProjectsInfoService.deleteVerticalProjectsInfo(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","删除成功",""));
                case "VerticalProject-Submit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmProjectsInfoService.subMitVerticalProject(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","提交成功",""));
                case "VerticalProject-Audit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmProjectsInfoService.auditVerticalProject(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","操作成功",""));

                case "ProjectsInfo-GetAuthor":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    List<ProjectsInfoMemberVo> projectsInfoMemberVos = srmProjectsInfoMemberService.listProjectInfoAuthor(baseDto);
                    return BaseResponse.success(new AppListVo<>(1,999,projectsInfoMemberVos.size() ,projectsInfoMemberVos));
                case "ProjectsInfo-AddAuthor":
                    appDetail=appBaseDto.getAppDetail();
                    ProjectsInfoMemberDto projectsInfoMemberDto= JSONObject.parseObject(appDetail, ProjectsInfoMemberDto.class);
                    rowId=srmProjectsInfoMemberService.saveAuthor(projectsInfoMemberDto);
                    return BaseResponse.success(new AppResultVo(0,String.valueOf(rowId),"保存成功",""));
                case "ProjectsInfo-DelAuthor":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmProjectsInfoMemberService.deleteAuthorById(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","删除成功",""));



                case "VerticalProjectCheck-GetDetail":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    ProjectMidcheckVo projectMidcheckVo =srmProjectMidcheckService.getDetail(String.valueOf(baseDto.getId()));
                    AppChange<ProjectMidcheckVo> projectMidcheckVoAppChange=new AppChange<>();

                    return BaseResponse.success(projectMidcheckVoAppChange.changeToJson(projectMidcheckVo));
                case "VerticalProjectCheck-List":
                    appDetail=appBaseDto.getAppDetail();
                    ProjectMidcheckDto projectMidcheckDto = JSONObject.parseObject(appDetail, ProjectMidcheckDto.class);
                    IPage<ProjectMidcheckVo> projectMidcheckVoIPage =srmProjectMidcheckService.listProjectMidcheck(projectMidcheckDto);
                    List<ProjectMidcheckVo> projectMidcheckVos=projectMidcheckVoIPage.getRecords();
                    return BaseResponse.success(new AppListVo<>((int)projectMidcheckVoIPage.getCurrent(),(int)projectMidcheckVoIPage.getSize(),(int)projectMidcheckVoIPage.getTotal() ,projectMidcheckVos));
                case "VerticalProjectCheck-Delete":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmProjectMidcheckService.deleteProjectMidcheck(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","删除成功",""));
                case "VerticalProjectCheck-Submit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmProjectMidcheckService.subMit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","提交成功",""));
                case "VerticalProjectCheck-Audit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmProjectMidcheckService.audit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","操作成功",""));



                case "VerticalProjectFinal-GetDetail":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    ProjectFinalcheckVo projectFinalcheckVo =srmProjectFinalcheckService.getDetail(String.valueOf(baseDto.getId()));
                    AppChange<ProjectFinalcheckVo> projectFinalcheckVoAppChange=new AppChange<>();

                    return BaseResponse.success(projectFinalcheckVoAppChange.changeToJson(projectFinalcheckVo));
                case "VerticalProjectFinal-List":
                    appDetail=appBaseDto.getAppDetail();
                    ProjectFinalcheckDto projectFinalcheckDto = JSONObject.parseObject(appDetail, ProjectFinalcheckDto.class);
                    IPage<ProjectFinalcheckVo> projectFinalcheckVoIPage =srmProjectFinalcheckService.listProjectFinalCheck(projectFinalcheckDto);
                    List<ProjectFinalcheckVo> projectFinalcheckVos=projectFinalcheckVoIPage.getRecords();
                    return BaseResponse.success(new AppListVo<>((int)projectFinalcheckVoIPage.getCurrent(),(int)projectFinalcheckVoIPage.getSize(),(int)projectFinalcheckVoIPage.getTotal() ,projectFinalcheckVos));
                case "VerticalProjectFinal-Delete":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmProjectFinalcheckService.deleteProjectFinalCheck(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","删除成功",""));
                case "VerticalProjectFinal-Submit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmProjectFinalcheckService.subMit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","提交成功",""));
                case "VerticalProjectFinal-Audit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmProjectFinalcheckService.audit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","操作成功",""));




                case "HorizonPrjSetUp-Save":
                    appDetail=appBaseDto.getAppDetail();
                    ProjectsInfoVerticalDto hProjectsInfoVerticalDto= JSONObject.parseObject(appDetail, ProjectsInfoVerticalDto.class);
                    rowId=srmProjectsInfoService.saveHroProjectsInfo(hProjectsInfoVerticalDto);
                    return BaseResponse.success(new AppResultVo(0,String.valueOf(rowId),"保存成功",""));
                case "HorizonPrjSetUp-GetDetail":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    ProjectsInfoVo hProjectsInfoVo =srmProjectsInfoService.getHroProjectDetail(baseDto.getId());
                    AppChange<ProjectsInfoVo> hProjectsInfoVoAppChange=new AppChange<>();
                    return BaseResponse.success(hProjectsInfoVoAppChange.changeToJson(hProjectsInfoVo));
                case "HorizonPrjSetUp-List":
                    appDetail=appBaseDto.getAppDetail();
                    ProjectsInfoDto hprojectsInfoDto = JSONObject.parseObject(appDetail, ProjectsInfoDto.class);
                    IPage<ProjectsInfoVo> hProjectsInfoVoIPage =srmProjectsInfoService.listHroProject(hprojectsInfoDto);
                    List<ProjectsInfoVo> hProjectsInfoVos=hProjectsInfoVoIPage.getRecords();
                    return BaseResponse.success(new AppListVo<>((int)hProjectsInfoVoIPage.getCurrent(),(int)hProjectsInfoVoIPage.getSize(),(int)hProjectsInfoVoIPage.getTotal() ,hProjectsInfoVos));
                case "HorizonPrjSetUp-Delete":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmProjectsInfoService.deleteHroProject(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","删除成功",""));
                case "HorizonPrjSetUp-Submit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmProjectsInfoService.subMitHroProject(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","提交成功",""));
                case "HorizonPrjSetUp-Audit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmProjectsInfoService.auditHroProject(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","操作成功",""));


                case "HorizonProjectCheck-GetDetail":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    ProjectMidcheckVo hProjectMidcheckVo =srmProjectMidcheckService.getDetail(String.valueOf(baseDto.getId()));
                    AppChange<ProjectMidcheckVo> hProjectMidcheckVoAppChange=new AppChange<>();
                    return BaseResponse.success(hProjectMidcheckVoAppChange.changeToJson(hProjectMidcheckVo));
                case "HorizonProjectCheck-List":
                    appDetail=appBaseDto.getAppDetail();
                    ProjectMidcheckDto hProjectMidcheckDto = JSONObject.parseObject(appDetail, ProjectMidcheckDto.class);
                    IPage<ProjectMidcheckVo> hProjectMidcheckVoIPage =srmProjectMidcheckService.listProjectMidcheck(hProjectMidcheckDto);
                    List<ProjectMidcheckVo> hProjectMidcheckVos=hProjectMidcheckVoIPage.getRecords();
                    return BaseResponse.success(new AppListVo<>((int)hProjectMidcheckVoIPage.getCurrent(),(int)hProjectMidcheckVoIPage.getSize(),(int)hProjectMidcheckVoIPage.getTotal() ,hProjectMidcheckVos));
                case "HorizonProjectCheck-Delete":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmProjectMidcheckService.deleteProjectMidcheck(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","删除成功",""));
                case "HorizonProjectCheck-Submit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmProjectMidcheckService.subMit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","提交成功",""));
                case "HorizonProjectCheck-Audit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmProjectMidcheckService.audit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","操作成功",""));

                case "HorizonProjectFinal-GetDetail":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    ProjectFinalcheckVo hProjectFinalcheckVo =srmProjectFinalcheckService.getDetail(String.valueOf(baseDto.getId()));
                    AppChange<ProjectFinalcheckVo> HProjectFinalcheckVoAppChange=new AppChange<>();

                    return BaseResponse.success(HProjectFinalcheckVoAppChange.changeToJson(hProjectFinalcheckVo));
                case "HorizonProjectFinal-List":
                    appDetail=appBaseDto.getAppDetail();
                    ProjectFinalcheckDto hProjectFinalcheckDto = JSONObject.parseObject(appDetail, ProjectFinalcheckDto.class);
                    IPage<ProjectFinalcheckVo> hProjectFinalcheckVoIPage =srmProjectFinalcheckService.listProjectFinalCheck(hProjectFinalcheckDto);
                    List<ProjectFinalcheckVo> hProjectFinalcheckVos=hProjectFinalcheckVoIPage.getRecords();
                    return BaseResponse.success(new AppListVo<>((int)hProjectFinalcheckVoIPage.getCurrent(),(int)hProjectFinalcheckVoIPage.getSize(),(int)hProjectFinalcheckVoIPage.getTotal() ,hProjectFinalcheckVos));
                case "HorizonProjectFinal-Delete":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmProjectFinalcheckService.deleteProjectFinalCheck(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","删除成功",""));
                case "HorizonProjectFinal-Submit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmProjectFinalcheckService.subMit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","提交成功",""));
                case "HorizonProjectFinal-Audit":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmProjectFinalcheckService.audit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","操作成功",""));
                case "Login-CheckUser":
                    appDetail=appBaseDto.getAppDetail();
                    baseDto= JSONObject.parseObject(appDetail, BaseDto.class);
                    srmProjectFinalcheckService.audit(baseDto);
                    return BaseResponse.success(new AppResultVo(0,"","操作成功",""));
                default:
                    return BaseResponse.success(new AppResultVo(-1,"","操作码不存在",""));
            }

        }catch (Exception e){
            log.error("异常错误",e);
            throw new ErrorException("-201",e.getMessage());
        }

    }

    @Override
    public BaseResponse upload(FileDto fileDto) {
        srmUploadInfoService.upload(fileDto);
        return BaseResponse.success("上传成功");
    }
    public String getFieldMust(FieldInputSetupDto fieldInputSetupDto){
        List<FieldInputSetUpVo> setUpVos=srmFieldInputSetupService.getFieldInputSetup(fieldInputSetupDto);
        List<String> triggerList=new ArrayList<>();
        triggerList.add("blur");
        triggerList.add("change");
        StringBuffer appStr=new StringBuffer();
        appStr.append("{");
        int i=0;
        for(FieldInputSetUpVo fieldInputSetUpVo:setUpVos){
            String fieldName=fieldInputSetUpVo.getFieldName();
            String appFieldName=fieldInputSetUpVo.getAppFieldName();
            if(appFieldName==null||appFieldName.isEmpty()){
                appFieldName=fieldName;
            }
            int isRequired=fieldInputSetUpVo.getIsRequired();

            Map<String, Object> appDetailMap = new HashMap<String, Object>();
            appDetailMap.put("type","string");
            appDetailMap.put("required", isRequired == 1);
            appDetailMap.put("message", "不能为空");
            appDetailMap.put("trigger", triggerList);

            if(i==0){
                appStr.append("\"").append(appFieldName).append("\"").append(":").append(JSONObject.toJSONString(appDetailMap));
            }else{
                appStr.append(",").append("\"").append(appFieldName).append("\"").append(":").append(JSONObject.toJSONString(appDetailMap));
            }

            i=i+1;
        }
        appStr.append("}");

        return appStr.toString();
    }
}
