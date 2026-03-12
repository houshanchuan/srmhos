package com.mediway.hos.srm.business.center.service.common;

import com.mediway.hos.srm.business.center.model.dto.baseData.*;
import com.mediway.hos.srm.business.center.model.dto.dept.DeptDto;
import com.mediway.hos.srm.business.center.model.dto.user.UserDto;

import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface SrmCommonService {

    List<CombVo> getYear(YearDto yearDto);
    List<CombVo> getWorkType(WorkTypeDto workTypeDto);
    List<CombVo> getUser(UserDto userDto);
    List<CombVo> getDept(DeptDto deptDto);
    List<CombVo> getSubjectClass();
    List<CombVo> getDiscipline(String upCode,String classcode);
    List<CombVo> getDisciplineNew(DisciplineDto disciplineDto);
    List<CombVo> getProjectsource();
    List<CombVo> getPressInfo();
    List<CombVo> getLanguage(LanguageDto languageDto);
    List<CombVo> getPersonType();
    List<CombVo> getPaperAuthorOrder();
    List<CombVo> getEditorType();

    List<CombVo> getJournal(JournalDictDto journalDictDto);
    List<CombVo> getJournalType();
    List<CombVo> getUserTitle(TitleInfoDto titleInfoDto);
    List<CombVo> getReimbursementWay();
    List<CombVo> getPaperThesisType();
    List<CombVo> getUnitOrder();
    List<CombVo> getPageSpace(PageSpaceDto pageSpaceDto);
	List<CombVo> getRelyUnit(RelyUnitDto relyUnitDto);
    List<CombVo> getPatentAgencyFeeSource(PatentAgencyFeeSourceDto patentAgencyFeeSourceDto);
    List<CombVo> getPatentState();
    List<CombVo> getPatentType();

    List<CombVo> getAwardGrade();
    List<CombVo> getAwardLevel();
    List<CombVo> getProjectApplyInfoState();
    public List<CombVo> getRewardType();
    List<CombVo> getProductMode();
    List<CombVo> getAchievementCat();  

    List<CombVo> getProjLevel ();
    List<CombVo> getProjClass ();
    List<CombVo> getGroup ();
    List<CombVo> getSystemModule ();
    List<CombVo> getEduDegree (EduDegreeDto eduDegreeDto);
    List<CombVo> getEduLevel (EduLevelDto eduLevelDto);
    List<CombVo> getOccupationCategory (OccupationCategoryDto occupationCategoryDto);
    List<CombVo> getJobType(JobTypeDto jobTypeDto);
    List<CombVo> getPartTimeJob(ParttimeJobDto parttimeJobDto);
    List<CombVo> getHonorTitle();
    List<CombVo> getPolity();
    List<CombVo> getTutorType();
    List<CombVo> getNationality(NationalityDto nationalityDto);
    List<CombVo> getNation(NationDto nationDto);
    List<CombVo> getPersonState();
    List<CombVo> getJobLevel();
    List<CombVo> getDivision();
    List<CombVo> getHospital();
    List<CombVo> getProjectType(ProjTypeDto projTypeDto);
    List<CombVo>  getExpertGroup();
    List<CombVo> getUnitType();
    List<CombVo> getTutor();
    List<CombVo>  getProject();
    List<CombVo> getConferenceType();
    List<CombVo>  getAttendanceStatus();
    List<CombVo> getAchvTransferType();
    List<CombVo> getAchvTransAgreementType();
    List<CombVo> getPayType();
    List<CombVo> getProjectApplyType();
    List<CombVo>getProjectApplyBookType();
    List<CombVo> getResearchField(ResearchFieldDto researchFieldDto);
    List<CombVo> getProjectCooprateForm(ProjectCooprateFormDto projectCooprateFormDto);
    List<CombVo> getProjectOrgForm(ProjectOrgFormDto projectOrgFormDto);
    List<CombVo> getSocEconomicObj(SocEconomicObjDto socEconomicObjDto);
    List<CombVo> getNationalEconomyIndustry(String upCode);
    List<CombVo> getNationalEconomyIndustryNew(NationalEconomyIndustryDto nationalEconomyIndustryDto);

    List<CombVo> getParttimeType();

    List<CombVo> getCommitteeInfo();
    List<CombVo> getProjStatSource();
    List<CombVo> getPartnerType();
    List<CombVo> getContractRole();
    List<CombVo> getContractType();
    List<CombVo> getLectureLevel();
    List<CombVo> getLectureType();
    List<CombVo> getDeptLevels();
    List<CombVo> getDeptTypes();
    List<CombVo> getOrgnazition();
    List<CombVo> getPaperReshipType(PaperReshipTypeDto paperReshipTypeDto);
    List<CombVo> getPaperReshipName(PaperReshipNameDto paperReshipNameDto);
    List<CombVo> getEmbodyType(PaperEmbodyTypeDto paperEmbodyTypeDto);
    List<CombVo> getCurrency(CurrencyDto currencyDto);
}
