package com.mediway.hos.srm.business.center.controller.common;

import com.mediway.hos.srm.business.center.model.dto.baseData.*;
import com.mediway.hos.srm.business.center.model.dto.dept.DeptDto;
import com.mediway.hos.srm.business.center.model.dto.project.ProjectsInfoDto;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectsInfoVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mediway.hos.srm.business.center.model.dto.user.UserDto;

import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.service.common.SrmCommonService;

import java.util.List;

@RestController
@RequestMapping("srm/srmCommon")
@Api(tags = "公共combos")
public class SrmCommonController {
    @Autowired
    private SrmCommonService srmCommonService;

    // 年度
    @PostMapping({"/getYear"})
    public List<CombVo> getYear(@RequestBody(required = false) YearDto yearDto) {
        return srmCommonService.getYear(yearDto);
    }

    // 著作类别
    @PostMapping({"/getWorkType"})
    public List<CombVo> getWorkType(@RequestBody(required = false) WorkTypeDto workTypeDto) {
        return srmCommonService.getWorkType(workTypeDto);
    }

    // 人员，作者
    @PostMapping({"/getUser"})
    public List<CombVo> getUser(@RequestBody(required = false)  UserDto userDto) {
        return srmCommonService.getUser(userDto);
    }

    // 科室 部门
    @PostMapping({"/getDept"})
    public List<CombVo> getDept(@RequestBody(required = false) DeptDto deptDto) {
        return srmCommonService.getDept(deptDto);
    }

    // 学科门类
    @PostMapping({"/getSubjectClass"})
    public List<CombVo> getSubjectClass() {
        return srmCommonService.getSubjectClass();
    }

    // 学科
    @PostMapping({"/getDiscipline"})
    public List<CombVo> getDiscipline(@RequestParam String upCode, @RequestParam String classcode) {
        System.out.println(upCode+","+classcode);
        return srmCommonService.getDiscipline(upCode, classcode);
    }

    // 学科
    @PostMapping({"/getDisciplineNew"})
    public List<CombVo> getDisciplineNew(@RequestBody(required = false) DisciplineDto disciplineDto) {
        return srmCommonService.getDisciplineNew(disciplineDto);
    }

    // 成果的项目来源
    @PostMapping({"/getProjectsource"})
    public List<CombVo> getProjectsource() {
        return srmCommonService.getProjectsource();
    }

    // 出版社
    @PostMapping({"/getPressInfo"})
    public List<CombVo> getPressInfo(@RequestBody(required = false) PressInfoDto pressInfoDto) {
        return srmCommonService.getPressInfo();
    }

    // 语言 语种
    @PostMapping({"/getLanguage"})
    public List<CombVo> getLanguage(@RequestBody(required = false) LanguageDto languageDto) {
        return srmCommonService.getLanguage(languageDto);
    }

    // 人员类型
    @PostMapping({"/getPersonType"})
    public List<CombVo> getPersonType() {
        return srmCommonService.getPersonType();
    }

    // 作者位次
    @PostMapping({"/getPaperAuthorOrder"})
    public List<CombVo> getPaperAuthorOrder() {
        return srmCommonService.getPaperAuthorOrder();
    }

    // 作者身份 （编者, 主编等)
    @PostMapping({"/getEditorType"})
    public List<CombVo> getEditorType() {
        return srmCommonService.getEditorType();
    }

    // 期刊
    @PostMapping({"/getJournal"})
    public List<CombVo> getJournal(@RequestBody(required = false) JournalDictDto journalDictDto) {
        return srmCommonService.getJournal(journalDictDto);
    }

    // 期刊类型
    @PostMapping({"/getJournalType"})
    public List<CombVo> getJournalType() {
        return srmCommonService.getJournalType();
    }

    // 职称
    @PostMapping({"/getUserTitle"})
    public List<CombVo> getUserTitle(@RequestBody(required = false) TitleInfoDto titleInfoDto) {
        return srmCommonService.getUserTitle(titleInfoDto);
    }

    // 报销途径
    @PostMapping({"/getReimbursementWay"})
    public List<CombVo> getReimbursementWay() {
        return srmCommonService.getReimbursementWay();
    }

    // 论文类型
    @PostMapping({"/getPaperThesisType"})
    public List<CombVo> getPaperThesisType() {
        return srmCommonService.getPaperThesisType();
    }

    // 我院单位位次
    @PostMapping({"/getUnitOrder"})
    public List<CombVo> getUnitOrder() {
        return srmCommonService.getUnitOrder();
    }

    // 版面
    @PostMapping({"/getPageSpace"})
    public List<CombVo> getPageSpace(@RequestBody(required = false) PageSpaceDto pageSpaceDto) {
        return srmCommonService.getPageSpace(pageSpaceDto);
    }

    // 代理费出处
    @PostMapping({"/getPatentAgencyFeeSource"})
    public List<CombVo> getPatentAgencyFeeSource(@RequestBody(required = false) PatentAgencyFeeSourceDto patentAgencyFeeSourceDto) {
        return srmCommonService.getPatentAgencyFeeSource(patentAgencyFeeSourceDto);
    }

    // 单位
    @PostMapping({"/getRelyUnit"})
    public List<CombVo> getRelyUnit(@RequestBody(required = false) RelyUnitDto relyUnitDto) {
        return srmCommonService.getRelyUnit(relyUnitDto);
    }

    // 专利状态
    @PostMapping({"/getPatentState"})
    public List<CombVo> getPatentState() {
        return srmCommonService.getPatentState();
    }

    // 专利类型
    @PostMapping({"/getPatentType"})
    public List<CombVo> getPatentType() {
        return srmCommonService.getPatentType();
    }

    // 获奖级别
    @PostMapping({"/getAwardGrade"})
    public List<CombVo> getAwardGrade() {
        return srmCommonService.getAwardGrade();
    }

    // 获奖等次
    @PostMapping({"/getAwardLevel"})
    public List<CombVo> getAwardLevel() {
        return srmCommonService.getAwardLevel();
    }

    // 申请批次状态
    @PostMapping({"/getProjectApplyInfoState"})
    public List<CombVo> getProjectApplyInfoState() {
        return srmCommonService.getProjectApplyInfoState();
    }

    // 获奖奖励类型
    @PostMapping({"/getRewardType"})
    public List<CombVo> getRewardType() {
        return srmCommonService.getRewardType();
    }

    // 成果形式。
    @PostMapping({"/getProductMode"})
    public List<CombVo> getProductMode() {
        return srmCommonService.getProductMode();
    }

    // 成果分类。
    @PostMapping({"/getAchievementCat"})
    public List<CombVo> getAchievementCat() {
        return srmCommonService.getAchievementCat();
    }

    // 项目级别
    @PostMapping({"/getProjLevel"})
    public List<CombVo> getProjLevel() {
        return srmCommonService.getProjLevel();
    }

    // 项目级别
    @PostMapping({"/getProjClass"})
    public List<CombVo> getProjClass() {
        return srmCommonService.getProjClass();
    }

    // 安全组
    @PostMapping({"/getGroup"})
    public List<CombVo> getGroup() {
        return srmCommonService.getGroup();
    }

    // 系统模块
    @PostMapping({"/getSystemModule"})
    public List<CombVo> getSystemModule() {
        return srmCommonService.getSystemModule();
    }

    // 学位
    @PostMapping({"/getEduDegree"})
    public List<CombVo> getEduDegree(@RequestBody(required = false) EduDegreeDto eduDegreeDto) {
        return srmCommonService.getEduDegree(eduDegreeDto);
    }

    // 学历
    @PostMapping({"/getEduLevel"})
    public List<CombVo> getEduLevel(@RequestBody(required = false) EduLevelDto eduLevelDto) {
        return srmCommonService.getEduLevel(eduLevelDto);
    }

    // 职业类别
    @PostMapping({"/getOccupationCategory"})
    public List<CombVo> getOccupationCategory(@RequestBody(required = false) OccupationCategoryDto occupationCategoryDto) {
        return srmCommonService.getOccupationCategory(occupationCategoryDto);
    }

    // 岗位类型
    @PostMapping({"/getJobType"})
    public List<CombVo> getJobType(@RequestBody(required = false) JobTypeDto jobTypeDto) {
        return srmCommonService.getJobType(jobTypeDto);
    }

    // 职位
    @PostMapping({"/getPartTimeJob"})
    public List<CombVo> getPartTimeJob(@RequestBody(required = false) ParttimeJobDto parttimeJobDto) {
        return srmCommonService.getPartTimeJob(parttimeJobDto);
    }

    // 荣誉称号
    @PostMapping({"/getHonorTitle"})
    public List<CombVo> getHonorTitle(@RequestBody(required = false) HonorTitleDto honorTitleDto) {
        return srmCommonService.getHonorTitle();
    }

    // 政治面貌
    @PostMapping({"/getPolity"})
    public List<CombVo> getPolity(@RequestBody(required = false) PolityDto polityDto) {
        return srmCommonService.getPolity();
    }

    // 导师类型
    @PostMapping({"/getTutorType"})
    public List<CombVo> getTutorType(@RequestBody(required = false) TutorTypeDto tutorTypeDto) {
        return srmCommonService.getTutorType();
    }

    //国籍
    @PostMapping({"/getNationality"})
    public List<CombVo> getNationality(@RequestBody(required = false) NationalityDto nationalityDto) {
        return srmCommonService.getNationality(nationalityDto);
    }

    //民族
    @PostMapping({"/getNation"})
    public List<CombVo> getNation(@RequestBody(required = false) NationDto nationDto) {
        return srmCommonService.getNation(nationDto);
    }

    // 人员在职状态
    @PostMapping({"/getPersonState"})
    public List<CombVo> getPersonState() {
        return srmCommonService.getPersonState();
    }

    // 岗位级别
    @PostMapping({"/getJobLevel"})
    public List<CombVo> getJobLevel(@RequestBody(required = false) JobLevelDto jobLevelDto) {
        return srmCommonService.getJobLevel();
    }

    // 教研室
    @PostMapping({"/getDivision"})
    public List<CombVo> getDivision() {
        return srmCommonService.getDivision();
    }

    // 医院
    @PostMapping({"/getHospital"})
    public List<CombVo> getHospital() {
        return srmCommonService.getHospital();
    }

    // 项目分类
    @PostMapping({"/getProjectType"})
    public List<CombVo> getProjectType(@RequestBody(required = false) ProjTypeDto projTypeDto) {
        return srmCommonService.getProjectType(projTypeDto);
    }

    // 专家组
    @PostMapping({"/getExpertGroup"})
    public List<CombVo> getExpertGroup() {
        return srmCommonService.getExpertGroup();
    }

    // 单位类型
    @PostMapping({"/getUnitType"})
    public List<CombVo> getUnitType() {
        return srmCommonService.getUnitType();
    }

    // 导师
    @PostMapping({"/getTutor"})
    public List<CombVo> getTutor() {
        return srmCommonService.getTutor();
    }

    @PostMapping({"/getProject"})
    public List<CombVo> getProject(@RequestBody(required = false) ProjectsInfoDto projectsInfoDto) {
        return srmCommonService.getProject();
    }

    @PostMapping({"/getConferenceType"})
    public List<CombVo> getConferenceType() {
        return srmCommonService.getConferenceType();
    }

    @PostMapping({"/getAttendanceStatus"})
    public List<CombVo> getAttendanceStatus() {
        return srmCommonService.getAttendanceStatus();
    }

    // 成果转化类型
    @PostMapping({"/getAchvTransferType"})
    public List<CombVo> getAchvTransferType() {
        return srmCommonService.getAchvTransferType();
    }

    // 协议类型
    @PostMapping({"/getAchvTransAgreementType"})
    public List<CombVo> getAchvTransAgreementType() {
        return srmCommonService.getAchvTransAgreementType();
    }
    // 付款类型

    @PostMapping({"/getPayType"})
    public List<CombVo> getPayType() {
        return srmCommonService.getPayType();
    }
    // 项目申报分类
    @PostMapping({"/getProjectApplyType"})
    public List<CombVo> getProjectApplyType() {
        return srmCommonService.getProjectApplyType();
    }
    // 项目申报类别
    @PostMapping({"/getProjectApplyBookType"})
    public List<CombVo> getProjectApplyBookType() {
        return srmCommonService.getProjectApplyBookType();
    }
    // 研究领域
    @PostMapping({"/getResearchField"})
    public List<CombVo> getResearchField(@RequestBody(required = false) ResearchFieldDto researchFieldDto) {
        return srmCommonService.getResearchField(researchFieldDto);
    }

    // 合作形式
    @PostMapping({"/getProjectCooprateForm"})
    public List<CombVo> getProjectCooprateForm(@RequestBody(required = false) ProjectCooprateFormDto projectCooprateFormDto) {
        return srmCommonService.getProjectCooprateForm(projectCooprateFormDto);
    }
    // 组织形式
    @PostMapping({"/getProjectOrgForm"})
    public List<CombVo> getProjectOrgForm(@RequestBody(required = false) ProjectOrgFormDto projectOrgFormDto) {
        return srmCommonService.getProjectOrgForm(projectOrgFormDto);
    }
    // 国民经济行业
    @PostMapping({"/getNationalEconomyIndustry"})
    public List<CombVo> getNationalEconomyIndustry(@RequestParam String upCode) {
        return srmCommonService.getNationalEconomyIndustry(upCode);
    }
    // 国民经济行业
    @PostMapping({"/getNationalEconomyIndustryNew"})
    public List<CombVo> getNationalEconomyIndustryNew(@RequestBody(required = false) NationalEconomyIndustryDto nationalEconomyIndustryDto) {
        return srmCommonService.getNationalEconomyIndustryNew(nationalEconomyIndustryDto);
    }
    // 国民经济目标
    @PostMapping({"/getSocEconomicObj"})
    public List<CombVo> getSocEconomicObj(@RequestBody(required = false) SocEconomicObjDto socEconomicObjDto) {
        return srmCommonService.getSocEconomicObj(socEconomicObjDto);
    }

    // 兼职类型
    @PostMapping({"/getParttimeType"})
    public List<CombVo> getParttimeType() {
        return srmCommonService.getParttimeType();
    }
    // 学会
    @PostMapping({"/getCommitteeInfo"})
    public List<CombVo> getCommitteeInfo() {
        return srmCommonService.getCommitteeInfo();
    }
    // 项目来源
    @PostMapping({"/getProjStatSource"})
    public List<CombVo> getProjStatSource() {
        return srmCommonService.getProjStatSource();
    }

    // 对方类别 List<CombVo> getPartnerType()
    @PostMapping({"/getPartnerType"})
    public List<CombVo> getPartnerType() {
        return srmCommonService.getPartnerType();
    }

    // 合同类别
    @PostMapping({"/getContractType"})
    public List<CombVo> getContractType() {
        return srmCommonService.getContractType();
    }

    // 角色
    @PostMapping({"/getContractRole"})
    public List<CombVo> getContractRole() {
        return srmCommonService.getContractRole();
    }

    // 讲座级别
    @PostMapping({"/getLectureLevel"})
    public List<CombVo> getLectureLevel() {
        return srmCommonService.getLectureLevel();}
    // 讲座类型
    @PostMapping({"/getLectureType"})
    public List<CombVo> getLectureType() {
        return srmCommonService.getLectureType();
    }
    /**
     *
     * @description 获取科室级别列表
     * @method getDeptLevels
     * @return List<CombVo>
     * @author baiyingjie
     * @version 1.0
     * @company 东华医为科技有限公司
     * @date 2025-03-24 18:39     */
    @PostMapping({"/getDeptLevels"})
    public List<CombVo> getDeptLevels(){
        return srmCommonService.getDeptLevels();
    }

    @PostMapping({"/getDeptTypes"})
    public List<CombVo> getDeptTypes(){
        return srmCommonService.getDeptTypes();
    }

    @PostMapping({"/getOrgnazition"})
    public List<CombVo> getOrgnazition(){
        return srmCommonService.getOrgnazition();
    }
    // 转载类型
    @PostMapping({"/getPaperReshipType"})
    public List<CombVo> getPaperReshipType(@RequestBody(required = false) PaperReshipTypeDto paperReshipTypeDto){
        return srmCommonService.getPaperReshipType(paperReshipTypeDto);
    }
    // 转载名称
    @PostMapping({"/getPaperReshipName"})
    public List<CombVo> getPaperReshipName(@RequestBody(required = false) PaperReshipNameDto paperReshipNameDto){
        return srmCommonService.getPaperReshipName(paperReshipNameDto);
    }
    // 收录类型
    @PostMapping({"/getEmbodyType"})
    public List<CombVo> getEmbodyType(@RequestBody(required = false) PaperEmbodyTypeDto paperEmbodyTypeDto){
        return srmCommonService.getEmbodyType(paperEmbodyTypeDto);
    }
    // 币种
    @PostMapping({"/getCurrency"})
    public List<CombVo> getCurrency(@RequestBody(required = false) CurrencyDto currencyDto){
        return srmCommonService.getCurrency(currencyDto);
    }
}
