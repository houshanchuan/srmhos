package com.mediway.hos.srm.business.center.service.app;

import com.mediway.hos.srm.business.center.model.dto.baseData.*;
import com.mediway.hos.srm.business.center.model.dto.user.UserDto;
import com.mediway.hos.srm.business.center.model.vo.app.AppListVo;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import java.util.List;

public interface SrmAppCommonService {
    // 年度
    AppListVo<CombVo> getYear(BaseDto baseDto);
    // 著作类别
    AppListVo<CombVo> getWorkType(BaseDto baseDto);
    // 人员
    AppListVo<CombVo> getUser(UserDto userDto);
    // 部门科室
    AppListVo<CombVo> getDept(BaseDto baseDto);
    // 学科门类
    AppListVo<CombVo> getSubjectClass(BaseDto baseDto);
    // 学科
    AppListVo<CombVo> getDiscipline(DisciplineDto disciplineDto);
    // 成果的项目来源
    AppListVo<CombVo> getProjectsource(BaseDto baseDto);
    // 出版社
    AppListVo<CombVo> getPressInfo(BaseDto baseDto);
    // 语言语种
    AppListVo<CombVo> getLanguage(BaseDto baseDto);

    // 人员类型
    AppListVo<CombVo> getPersonType(BaseDto baseDto);
    // 人员位次
    AppListVo<CombVo> getPaperAuthorOrder(BaseDto baseDto);
    // 作者身份 （编者, 主编等)
    AppListVo<CombVo> getEditorType(BaseDto baseDto);
    // 期刊
    AppListVo<CombVo> getJournal(BaseDto baseDto);
    // 期刊类型
    AppListVo<CombVo> getJournalType(BaseDto baseDto);
    AppListVo<CombVo> getUserTitle(BaseDto baseDto);
    List<CombVo> getReimbursementWay();
    // 论文类型
    AppListVo<CombVo> getPaperThesisType(BaseDto baseDto);
    // 单位位次
    AppListVo<CombVo> getUnitOrder(BaseDto baseDto);
    // 版面
    AppListVo<CombVo> getPageSpace(BaseDto baseDto);
    AppListVo<CombVo> getRelyUnit(BaseDto baseDto);
    AppListVo<CombVo> getPatentAgencyFeeSource(BaseDto baseDto);
    AppListVo<CombVo> getPatentState(BaseDto baseDto);
    AppListVo<CombVo> getPatentType(BaseDto baseDto);

    AppListVo<CombVo> getAwardGrade(BaseDto baseDto);
    AppListVo<CombVo> getAwardLevel(BaseDto baseDto);
    AppListVo<CombVo> getProjectApplyInfoState(BaseDto baseDto);
    AppListVo<CombVo> getRewardType(BaseDto baseDto);
    AppListVo<CombVo> getProductMode(BaseDto baseDto);
    AppListVo<CombVo> getAchievementCat(BaseDto baseDto);

    AppListVo<CombVo> getProjLevel (BaseDto baseDto);
    List<CombVo> getProjClass ();
    List<CombVo> getGroup ();
    List<CombVo> getSystemModule ();
    List<CombVo> getEduDegree (EduDegreeDto eduDegreeDto);
    List<CombVo> getEduLevel (EduLevelDto eduLevelDto);
    List<CombVo> getOccupationCategory (OccupationCategoryDto occupationCategoryDto);
    List<CombVo> getJobType(JobTypeDto jobTypeDto);
    AppListVo<CombVo> getPartTimeJob(BaseDto baseDto);
    List<CombVo> getHonorTitle();
    List<CombVo> getPolity();
    List<CombVo> getTutorType();
    List<CombVo> getNationality(NationalityDto nationalityDto);
    List<CombVo> getNation(NationDto nationDto);
    List<CombVo> getPersonState();
    List<CombVo> getJobLevel();
    List<CombVo> getDivision();
    List<CombVo> getHospital();
    AppListVo<CombVo> getProjectType(BaseDto baseDto);
    List<CombVo>  getExpertGroup();
    List<CombVo> getUnitType();
    List<CombVo> getTutor();
    // 依托项目
    AppListVo<CombVo>  getProject(BaseDto baseDto);
    AppListVo<CombVo> getConferenceType(BaseDto baseDto);
    List<CombVo>  getAttendanceStatus();
    List<CombVo> getAchvTransferType();
    List<CombVo> getAchvTransAgreementType();
    List<CombVo> getPayType();
    List<CombVo> getProjectApplyType();
    AppListVo<CombVo> getProjectApplyBookType(BaseDto baseDto);
    AppListVo<CombVo> getResearchField(BaseDto baseDto);
    AppListVo<CombVo> getProjectCooprateForm(BaseDto baseDto);
    AppListVo<CombVo> getProjectOrgForm(BaseDto baseDto);
    AppListVo<CombVo> getSocEconomicObj(BaseDto baseDto);
    AppListVo<CombVo> getNationalEconomyIndustry(BaseDto baseDto);

    AppListVo<CombVo> getParttimeType(BaseDto baseDto);

    AppListVo<CombVo> getCommitteeInfo(BaseDto baseDto);
    AppListVo<CombVo> getProjStatSource(BaseDto baseDto);
    AppListVo<CombVo> getPartnerType(BaseDto baseDto);
    AppListVo<CombVo>getContractRole(BaseDto baseDto);
    AppListVo<CombVo> getContractType(BaseDto baseDto);
    AppListVo<CombVo> getLectureLevel(BaseDto baseDto);
    AppListVo<CombVo> getLectureType(BaseDto baseDto);
    //���Ҽ����б�
    List<CombVo> getDeptLevels();
    //���������б�
    List<CombVo> getDeptTypes();
    //�����б�
    List<CombVo> getOrgnazition();
}
