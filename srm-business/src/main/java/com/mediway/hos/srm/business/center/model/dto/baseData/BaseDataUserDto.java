package com.mediway.hos.srm.business.center.model.dto.baseData;

import lombok.Data;

import java.util.List;

@Data
public class BaseDataUserDto {
    private String mainId;
    private List<ParttimeJobDto> parttimeJobs; //兼职职位
    private List<JobTypeDto> jobTypes; //岗位性质
    private List<JobLevelDto> jobLevels; //岗位级别
    private List<UnitTypeDto> unitTypes; //单位类别
    private List<RelyUnitDto> relyUnits; //单位
    private List<PolityDto> politys; //政治面貌
    private List<TitleInfoDto> titleInfos; //职称
    private List<EduLevelDto> eduLevels; //学历
    private List<EduDegreeDto> eduDegrees; //学位
    private List<TitleLevelDto> titleLevels; //职称级别
    private List<TitleTypeDto> titleTypes; //职称类别
    private List<PersonTypeDto> personTypes; //人员类别
    private List<TutorTypeDto> tutorTypes; //导师类型
    private List<NationalityDto> nationalitys; //国籍
    private List<NationDto> nations; //民族
    private List<PersonStateDto> personStates; //人员在职情况
    private List<LanguageDto> languages; //语种
    private List<LanguageDegreeDto> languageDegrees; //语种掌握程度
    private List<DegreeTypeDto> degreeTypes; //学位类别
    private List<OccupationCategoryDto> occupationCategorys; //职业类别
    private List<DeptTypeDto> deptTypes; //部门类型
    private List<HonoraryTitleTypeDto> honoraryTitleTypes; //荣誉称号类型
    private List<AcademicTitleTypeDto> academicTitleTypes; //学术称号类型
    private List<AcademicTitleDto> academicTitles; //学术称号
    private List<CommitteeInfoDto> committeeInfos; //学会信息

    private List<ExpertGroupDto> expertGroups;  //专家组
    private List<ExpertGroupRelationDto> expertGroupRelations;  //专家组
    private List<TeacherTypeDto> teacherTypes;
    private List<CommitteeTypeDto> committeeTypes;
    private List<DeptLevelDto> deptLevels;
    private List<HonorTitleDto> honorTitles;



}
