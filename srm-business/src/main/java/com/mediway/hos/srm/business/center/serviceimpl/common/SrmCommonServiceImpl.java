package com.mediway.hos.srm.business.center.serviceimpl.common;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mediway.hos.app.org.model.organization.entity.HosOrgOrganization;
import com.mediway.hos.i18n.utils.I18nUtil;
import com.mediway.hos.security.core.util.StringUtil;
import com.mediway.hos.srm.business.center.model.dto.baseData.*;
import com.mediway.hos.srm.business.center.model.dto.dept.DeptDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmDeptLevel;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmDeptType;
import com.mediway.hos.srm.business.center.service.baseData.*;
import com.mediway.hos.srm.business.center.service.common.SrmCommonService;
import com.mediway.hos.srm.business.center.service.dept.HosSrmService;
import com.mediway.hos.srm.business.center.service.dept.SrmDeptService;
import com.mediway.hos.srm.business.center.service.paper.SrmPaperReshipService;
import com.mediway.hos.srm.business.center.service.project.SrmProjectsInfoService;
import com.mediway.hos.srm.business.center.service.systemConfig.SrmSystemModuleService;
import com.mediway.hos.srm.business.center.service.user.SrmUserService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mediway.hos.srm.business.center.model.dto.user.UserDto;

import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SrmCommonServiceImpl implements SrmCommonService {
    @Autowired
    private SrmYearService srmYearService;
    @Autowired
    private SrmWorkTypeService srmWorkTypeService;
    @Autowired
    private SrmUserService srmUserService;
    @Autowired
    private SrmDeptService srmDeptService;
    @Autowired
    private SrmClassService srmClassService;
    @Autowired
    private SrmDisciplineService srmDisciplineService;
    @Autowired
    private SrmProductProjectsourceService srmProductProjectsourceService;
    @Autowired
    private SrmPressInfoService srmPressInfoService;
    @Autowired
    private SrmLanguageService srmLanguageService;
    @Autowired
    private SrmPersonTypeService srmPersonTypeService;
    @Autowired
    private SrmPaperAuthorOrderService srmPaperAuthorOrderService;
    @Autowired
    private SrmEditorTypeService srmEditorTypeService;
    @Autowired
    private SrmJournalService srmJournalService;
    @Autowired
    private SrmJournalTypeService srmJournalTypeService;
    @Autowired
    private SrmReimbursementWayService srmReimbursementWayService;
    @Autowired
    private SrmTitleInfoService srmTitleInfoService;
    @Autowired
    private SrmPaperThesisTypeService srmPaperThesisTypeService;
    @Autowired
    private SrmUnitOrderService srmUnitOrderService;
    @Autowired
    private SrmPageSpaceService srmPageSpaceService;
    @Autowired
    private SrmRelyUnitService srmRelyUnitService;
    @Autowired
    private SrmPatentStateService srmPatentStateService;
    @Autowired
    private SrmPatentAgencyFeeSourceService srmPatentAgencyFeeSourceService;
    @Autowired
    private SrmPatentTypeService srmPatentTypeService;
    @Autowired
    private SrmAwardGradeService srmAwardGradeService;
    @Autowired
    private SrmAwardLevelService srmAwardLevelService;
    @Autowired
    private SrmProjectApplyInfoStateService srmProjectApplyInfoStateService;
    @Autowired
    private SrmRewardTypeService srmRewardTypeService;
    @Autowired
    private SrmProductModeService srmProductModeService;
    @Autowired
    private SrmAchievementCatService srmAchievementCatService;
    @Autowired
    private SrmProjLevelService srmProjLevelService;
    @Autowired
    private SrmProjectClassService srmProjectClassService;

    @Autowired
    private SrmGroupAuthConfigService srmGroupAuthConfigService;
    @Autowired
    private SrmSystemModuleService srmSystemModuleService;
    @Autowired
    private SrmEduDegreeService srmEduDegreeService;
    @Autowired
    private SrmEduLevelService srmEduLevelService;
    @Autowired
    private SrmOccupationCategoryService srmOccupationCategoryService;
    @Autowired
    private SrmJobTypeService srmJobTypeService;
    @Autowired
    private SrmParttimeJobService srmParttimeJobService;
    @Autowired
    private SrmHonorTitleService srmHonorTitleService;
    @Autowired
    private SrmPolityService srmPolityService;
    @Autowired
    private SrmTutorTypeService  srmTutorTypeService ;
    @Autowired
    private SrmNationalityService srmNationalityService;
    @Autowired
    private SrmNationService srmNationService;
    @Autowired
    private SrmPersonStateService srmPersonStateService;
    @Autowired
    private SrmJobLevelService srmJobLevelService;
    @Autowired
    private SrmHospitalService srmHospitalService;
    @Autowired
    private SrmProjTypeService  srmProjTypeService;
    @Autowired
    private SrmExpertGroupService srmExpertGroupService;
    @Autowired
    private SrmUnitTypeService srmUnitTypeService;
    @Autowired
    private SrmProjectsInfoService srmProjectsInfoService;
    @Autowired
    private SrmConferenceTypeService srmConferenceTypeService;
    @Autowired
    private SrmMeetingAttendanceStatusService srmMeetingAttendanceStatusService;

    @Autowired
    private SrmAchvTransferTypeService srmAchvTransferTypeService;
    @Autowired
    private SrmAchvTransAgreementTypeService srmAchvTransAgreementTypeService;
    @Autowired
    private SrmPayTypeService srmPayTypeService;
    @Autowired
    private SrmProjectApplyTypeService srmProjectApplyTypeService;
    @Autowired
    private SrmProjectApplyBookTypeService srmProjectApplyBookTypeService;
    @Autowired
    private SrmResearchFieldService srmResearchFieldService;
    @Autowired
    private SrmProjectOrgFormService srmProjectOrgFormService;
    @Autowired
    private SrmProjectCooperationFormService srmProjectCooperationFormService;
    @Autowired
    private SrmSocEconomicObjService srmSocEconomicObjService;
    @Autowired
    private SrmNationalEconomyIndustryService srmNationalEconomyIndustryService;

    @Autowired
    private SrmParttimeTypeService srmParttimeTypeService;
    @Autowired
    private SrmCommitteeInfoService srmCommitteeInfoService;
    @Autowired
    private SrmProjStatSourceService srmProjStatSourceService;
    @Autowired
    private SrmPartnerTypeService srmPartnerTypeService;
    @Autowired
    private SrmContractRoleService srmContractRoleService;
    @Autowired
    private SrmContractTypeService srmContractTypeService;
    @Autowired
    private SrmLectureLevelService srmLectureLevelService;
    @Autowired
    private SrmLectureTypeService srmLectureTypeService;
    @Autowired
    private SrmDeptLevelService srmDeptLevelService;
    @Autowired
    private SrmDeptTypeService srmDeptTypeService;
    @Autowired
    private HosSrmService hosSrmService;
    @Autowired
    private SrmReshipTypeService srmReshipTypeService;
    @Autowired
    private SrmReshipNameService srmReshipNameService;
    @Autowired
    private SrmEmbodyTypeService srmEmbodyTypeService;
    @Autowired
    private SrmCurrencyService srmCurrencyService;
    @Override
    // 年度
    public List<CombVo> getYear(YearDto yearDto) {
        return srmYearService.getYear(yearDto);
    }
    @Override
    // 著作类别
    public List<CombVo> getWorkType(WorkTypeDto workTypeDto) {
        return srmWorkTypeService.getWorkType(workTypeDto);
    }

    @Override
    // 人员
    public List<CombVo> getUser(UserDto userDto) {
        System.out.println(userDto);
        return srmUserService.getUser(userDto);
    }

    @Override
    // 科室部门
    public List<CombVo> getDept(DeptDto deptDto) {
        return srmDeptService.getDept(deptDto);
    }

    @Override
    // 学科门类
    public List<CombVo> getSubjectClass() {
        return srmClassService.getSubjectClass();
    }

    @Override
    // 学科
    public List<CombVo> getDiscipline(String upCode,String classcode) {
        System.out.println(classcode);
        return srmDisciplineService.getDiscipline(upCode,classcode);
    }

    @Override
    public List<CombVo> getDisciplineNew(DisciplineDto disciplineDto) {
        return srmDisciplineService.getDisciplineNew(disciplineDto);
    }

    @Override

    // 成果的项目来源
    public List<CombVo> getProjectsource() {
        return srmProductProjectsourceService.getProjectsource();
    }

    @Override
    // 出版社
    public List<CombVo> getPressInfo() {
        return srmPressInfoService.getPressInfo();
    }

    @Override
    // 语言 语种
    public List<CombVo> getLanguage(LanguageDto languageDto) {
        return srmLanguageService.getLanguage(languageDto);
    }

    @Override
    // 人员类型
    public List<CombVo> getPersonType() {
        return srmPersonTypeService.getPersonType();
    }

    @Override
    // 作者位次
    public List<CombVo> getPaperAuthorOrder() {
        return srmPaperAuthorOrderService.getPaperAuthorOrder();
    }

    @Override
    // 作者身份 （编者, 主编等)
    public List<CombVo> getEditorType() {
        return srmEditorTypeService.getEditorType();
    }

    // 期刊
    @Override
    public List<CombVo> getJournal(JournalDictDto journalDictDto) {
        return srmJournalService.getJournal(journalDictDto);
    }
    // 期刊类型JournalDictDto journalDictDto
    @Override
    public List<CombVo> getJournalType() {
        return srmJournalTypeService.getJournalType();
    }
    // 职称
    @Override
    public List<CombVo> getUserTitle(TitleInfoDto titleInfoDto) {
        return srmTitleInfoService.getUserTitle(titleInfoDto);
    }
    // 报销途径
    @Override
    public List<CombVo> getReimbursementWay() {
        return srmReimbursementWayService.getReimbursementWay();
    }
    @Override
    public List<CombVo> getPaperThesisType() { return srmPaperThesisTypeService.getPaperThesisType();    }
    @Override
    public List<CombVo> getUnitOrder() {
        return srmUnitOrderService.getUnitOrder();
    }

    @Override
    public List<CombVo> getPageSpace(PageSpaceDto pageSpaceDto) {
        return srmPageSpaceService.getPageSpace(pageSpaceDto);
    }
    @Override
    public List<CombVo> getRelyUnit(RelyUnitDto relyUnitDto) {return srmRelyUnitService.getRelyUnit(relyUnitDto);}

    @Override
    public List<CombVo> getPatentAgencyFeeSource(PatentAgencyFeeSourceDto patentAgencyFeeSourceDto) {return srmPatentAgencyFeeSourceService.getPatentAgencyFeeSource(patentAgencyFeeSourceDto);}
    @Override
    public List<CombVo> getPatentState() {return srmPatentStateService.getPatentState();}

    @Override
    public List<CombVo> getPatentType() {
        return srmPatentTypeService.getPatentType();
    }

    @Override
    public List<CombVo> getAwardGrade() {
        return srmAwardGradeService.getAwardGrade();
    }

    @Override
    public List<CombVo> getAwardLevel() {
        return srmAwardLevelService.getAwardLevel();
    }

    @Override
    public List<CombVo> getProjectApplyInfoState() {
        return srmProjectApplyInfoStateService.getProjectApplyInfoState();
    }

    @Override
    public List<CombVo> getRewardType() {
        return srmRewardTypeService.getRewardType();
    }

    @Override
    public List<CombVo> getProductMode() {
        return srmProductModeService.getProductMode();
    }

    @Override
    public List<CombVo> getAchievementCat() {
        return srmAchievementCatService.getAchievementCat();
    }

    @Override
    public List<CombVo>  getProjLevel(){return srmProjLevelService.getProjLevel() ;}
    @Override
    public List<CombVo>  getProjClass(){return srmProjectClassService.getProjClass();}
    @Override
    public List<CombVo>  getGroup(){ return srmGroupAuthConfigService.getGroup();}

    public List<CombVo>  getSystemModule(){ return srmSystemModuleService.getSystemModule();}
    @Override
    public List<CombVo> getEduDegree(EduDegreeDto eduDegreeDto){ return srmEduDegreeService.getEduDegree(eduDegreeDto);}
    @Override
    public List<CombVo> getEduLevel(EduLevelDto eduLevelDto){ return srmEduLevelService.getEduLevel(eduLevelDto);}
    @Override
    public List<CombVo> getOccupationCategory(OccupationCategoryDto occupationCategoryDto){ return srmOccupationCategoryService.getOccupationCategory(occupationCategoryDto);}
    @Override
    public List<CombVo> getJobType(JobTypeDto jobTypeDto){return srmJobTypeService.getJobType(jobTypeDto); }
    @Override
    public List<CombVo> getPartTimeJob(ParttimeJobDto parttimeJobDto){return srmParttimeJobService.getPartTimeJob(parttimeJobDto);}

    @Override
    public List<CombVo> getHonorTitle(){return srmHonorTitleService.getHonorTitle();}
    @Override
    public List<CombVo> getPolity(){return srmPolityService.getPolity();}
    @Override
    public List<CombVo> getTutorType()  {return srmTutorTypeService.getTutorType();}
    @Override
    public List<CombVo> getNationality(NationalityDto nationalityDto)  {return srmNationalityService.getNationality(nationalityDto);}
    @Override
    public List<CombVo> getNation(NationDto nationDto){return srmNationService.getNation(nationDto);}
    @Override
    public List<CombVo> getPersonState()  {return srmPersonStateService.getPersonState();}

    @Override
    public List<CombVo> getJobLevel()  {return srmJobLevelService.getJobLevel();}

    @Override
    public List<CombVo> getDivision()  {return srmDeptService.getDivision();}

    @Override
    public List<CombVo> getHospital()  {return srmHospitalService.getHospital();}

    @Override
    public List<CombVo> getProjectType(ProjTypeDto projTypeDto)  {return srmProjTypeService.getProjectType(projTypeDto);}

    @Override
    public List<CombVo> getExpertGroup()  {return srmExpertGroupService.getExpertGroup();}

    @Override
    public List<CombVo> getUnitType() {return srmUnitTypeService.getUnitType();}

    @Override
    public List<CombVo> getTutor() {return srmUserService.getTutor();}

    @Override
    public List<CombVo> getProject(){return srmProjectsInfoService.getProject(); }

    @Override
    public List<CombVo>  getConferenceType(){
        List<CombVo> comList= srmConferenceTypeService.getConferenceType();
        List<String> idList = comList.stream().map(CombVo::getId).collect(Collectors.toList());

        Map<String, String> nameTransMap = I18nUtil.mapTransValue("ct_srm_conference_type", idList, "name", "hos_i18n_data");

        comList.forEach(CombVo -> {
            String value = nameTransMap.get(CombVo.getId());
            if (StringUtil.isNotBlank(value)) {
                CombVo.setName(value);
            }
        });
        return comList;
    }

     @Override
    public List<CombVo>  getAttendanceStatus(){
        System.out.println("ss");
        return  srmMeetingAttendanceStatusService.getAttendanceStatus();
    }

    @Override
    public List<CombVo> getAchvTransferType() {
        return srmAchvTransferTypeService.getAchvTransferType();
    }

    @Override
    public List<CombVo> getAchvTransAgreementType() {
        return srmAchvTransAgreementTypeService.getAchvTransAgreementType();
    }

    @Override
    public List<CombVo> getPayType() {
        return srmPayTypeService.getPayType();
    }

    @Override
    public List<CombVo> getProjectApplyType() {
        return srmProjectApplyTypeService.getProjectApplyType();
    }

    @Override
    public List<CombVo> getProjectApplyBookType() {
        return srmProjectApplyBookTypeService.getProjectApplyBookType();
    }

    @Override
    public List<CombVo> getResearchField(ResearchFieldDto researchFieldDto) {
        return srmResearchFieldService.getResearchField(researchFieldDto);
    }

    @Override
    public List<CombVo> getProjectCooprateForm(ProjectCooprateFormDto projectCooprateFormDto) {
        return srmProjectCooperationFormService.getProjectCooprateForm(projectCooprateFormDto);
    }

    @Override
    public List<CombVo> getProjectOrgForm(ProjectOrgFormDto projectOrgFormDto) {
        return srmProjectOrgFormService.getProjectOrgForm(projectOrgFormDto);
    }

    @Override
    public List<CombVo> getSocEconomicObj(SocEconomicObjDto socEconomicObjDto) {
        return srmSocEconomicObjService.getSocEconomicObj(socEconomicObjDto);
    }

    @Override
    public List<CombVo> getNationalEconomyIndustry(String upCode) {
        return srmNationalEconomyIndustryService.getNationalEconomyIndustry(upCode);
    }

    @Override
    public List<CombVo> getNationalEconomyIndustryNew(NationalEconomyIndustryDto nationalEconomyIndustryDto) {
        return srmNationalEconomyIndustryService.getNationalEconomyIndustryNew(nationalEconomyIndustryDto);
    }

    @Override
    public List<CombVo> getParttimeType() {
        return srmParttimeTypeService.getParttimeType();
    }

    @Override
    public List<CombVo> getCommitteeInfo() {
        return srmCommitteeInfoService.getCommitteeInfo();
    }
    @Override
    public List<CombVo> getProjStatSource() {
        return srmProjStatSourceService.getProjStatSource();
    }
    @Override
    public List<CombVo> getPartnerType(){
        return srmPartnerTypeService.getPartnerType();
    }

    @Override
    public List<CombVo> getContractRole(){
        return srmContractRoleService.getContractRole();
    }
    @Override
    public List<CombVo> getContractType(){
        return srmContractTypeService.getContractType();
    }

    @Override
    public List<CombVo> getLectureLevel() {
        return srmLectureLevelService.getLectureLevel();
    }

    @Override
    public List<CombVo> getLectureType() {
        return srmLectureTypeService.getLectureType();
    }
    @Override
    public List<CombVo> getDeptLevels () {
        List<SrmDeptLevel> list = srmDeptLevelService.selectAll();
        List<CombVo> combVoList = new ArrayList<>();
        for (SrmDeptLevel level : list) {
            CombVo combVo = new CombVo();
            BeanUtils.copyProperties(level, combVo);
            combVo.setId(level.getCode());
            combVoList.add(combVo);

        }
        return combVoList;
    }

    @Override
    public List<CombVo> getDeptTypes () {
        List<SrmDeptType> list = srmDeptTypeService.selectAll();
        List<CombVo> combVoList = new ArrayList<>();
        for (SrmDeptType type : list) {
            CombVo combVo = new CombVo();
            BeanUtils.copyProperties(type, combVo);
            combVo.setId(type.getCode());
            combVoList.add(combVo);
        }
        return combVoList;
    }

    @Override
    public List<CombVo> getOrgnazition () {

        List<HosOrgOrganization> list = hosSrmService.getHosOrgOrganizationList();
        List<CombVo> combVoList = new ArrayList<>();
        for (HosOrgOrganization org : list) {
            CombVo combVo = new CombVo();
            BeanUtils.copyProperties(org, combVo);
            combVo.setId(org.getCode());
            combVoList.add(combVo);
        }
        return combVoList;
    }

    @Override
    public List<CombVo> getPaperReshipType(PaperReshipTypeDto paperReshipTypeDto) {
        return srmReshipTypeService.getPaperReshipType(paperReshipTypeDto);
    }

    @Override
    public List<CombVo> getPaperReshipName(PaperReshipNameDto paperReshipNameDto) {
        return srmReshipNameService.getPaperReshipName(paperReshipNameDto);
    }

    @Override
    public List<CombVo> getEmbodyType(PaperEmbodyTypeDto paperEmbodyTypeDto) {
        return srmEmbodyTypeService.getEmbodyType(paperEmbodyTypeDto);
    }

    @Override
    public List<CombVo> getCurrency(CurrencyDto currencyDto) {
        return srmCurrencyService.getCurrency(currencyDto);
    }
}
