package com.mediway.hos.srm.business.center.serviceimpl.app;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.mediway.hos.srm.business.center.model.dto.baseData.*;
import com.mediway.hos.srm.business.center.model.dto.user.UserDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.*;
import com.mediway.hos.srm.business.center.model.entity.dept.SrmDept;
import com.mediway.hos.srm.business.center.model.entity.project.SrmProjectsInfo;
import com.mediway.hos.srm.business.center.model.entity.projectapply.SrmProjectApplyInfo;
import com.mediway.hos.srm.business.center.model.entity.user.SrmUser;
import com.mediway.hos.srm.business.center.model.vo.app.AppListVo;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectsInfoVo;
import com.mediway.hos.srm.business.center.service.app.SrmAppCommonService;
import com.mediway.hos.srm.business.center.service.baseData.*;
import com.mediway.hos.srm.business.center.service.dept.SrmDeptService;
import com.mediway.hos.srm.business.center.service.project.SrmProjectsInfoService;
import com.mediway.hos.srm.business.center.service.systemConfig.SrmSystemModuleService;
import com.mediway.hos.srm.business.center.service.user.SrmUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SrmAppCommonServiceImpl implements SrmAppCommonService {
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

    @Override
    // 年度
    public AppListVo<CombVo> getYear(BaseDto baseDto) {
        String str=baseDto.getQueryName();
        List<SrmYear> list=null;
        QueryWrapper<SrmYear> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("is_valid",1);
        if(StringUtils.isNotEmpty(str)){
            queryWrapper.eq("name",str).or().eq("code",str);
        }
        queryWrapper.orderByDesc("name");
        list=srmYearService.list(queryWrapper);
        List<CombVo> combVos=new ArrayList<>();
        for(SrmYear year:list){
            CombVo combVo=new CombVo();
            combVo.setId(year.getCode());
            combVo.setName(year.getName());
            combVos.add(combVo);
        }
        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),combVos);
    }
    @Override
    // 著作类别
    public AppListVo<CombVo> getWorkType(BaseDto baseDto) {
        String str=baseDto.getQueryName();
        List<SrmWorkType> list=null;
        if(str==null||str.isEmpty()){
            list=srmWorkTypeService.selectAll();
        }else{
            QueryWrapper<SrmWorkType> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("name",str).or().eq("code",str);
            list=srmWorkTypeService.list(queryWrapper);
        }

        List<CombVo> combVos=new ArrayList<>();
        for(SrmWorkType srmWorkType:list){
            CombVo combVo=new CombVo();
            combVo.setId(srmWorkType.getCode());
            combVo.setName(srmWorkType.getName());
            combVos.add(combVo);
        }
        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),combVos);
    }

    @Override
    // 人员
    public AppListVo<CombVo> getUser(UserDto userDto) {

        String str=userDto.getQueryName();
        String personType=userDto.getPersonType();
        QueryWrapper<SrmUser> queryWrapper=new QueryWrapper<>();
        if(personType!=null&&!personType.isEmpty()){

            queryWrapper.eq("person_type",personType);
        }

        if(str!=null&&!str.isEmpty()){

            queryWrapper.eq("name",str).or().eq("code",str).or().eq("account",str).or().like("alias",str);

        }
        List<SrmUser> list=srmUserService.list(queryWrapper);
        List<CombVo> combVos=new ArrayList<>();
        for(SrmUser srmUser:list){
            CombVo combVo=new CombVo();
            combVo.setId(String.valueOf(srmUser.getId()));
            combVo.setName(srmUser.getName());
            combVos.add(combVo);
        }
        return new AppListVo<>(userDto.getPage(),userDto.getLimit(),combVos);
    }

    @Override
    // 科室部门
    public AppListVo<CombVo> getDept(BaseDto baseDto) {
        String str=baseDto.getQueryName();
        List<SrmDept> list=null;
        if(str==null||str.isEmpty()){
            list=srmDeptService.selectAll();
        }else{
            QueryWrapper<SrmDept> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("name",str).or().eq("code",str);
            list=srmDeptService.list(queryWrapper);
        }

        List<CombVo> combVos=new ArrayList<>();
        for(SrmDept srmDept:list){
            CombVo combVo=new CombVo();
            combVo.setId(String.valueOf(srmDept.getId()));
            combVo.setName(srmDept.getName());
            combVos.add(combVo);
        }
        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),combVos);
    }

    @Override
    // 学科门类
    public AppListVo<CombVo> getSubjectClass(BaseDto baseDto) {

        String str=baseDto.getQueryName();
        List<SrmClass> list=null;
        if(str==null||str.isEmpty()){
            list=srmClassService.selectAll();
        }else{
            QueryWrapper<SrmClass> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("name",str).or().eq("code",str);
            list=srmClassService.list(queryWrapper);
        }

        List<CombVo> combVos=new ArrayList<>();
        for(SrmClass srmClass:list){
            CombVo combVo=new CombVo();
            combVo.setId(srmClass.getCode());
            combVo.setName(srmClass.getName());
            combVos.add(combVo);
        }
        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),combVos);
    }


    // 学科
    @Override
    public AppListVo<CombVo> getDiscipline(DisciplineDto disciplineDto) {


        String str=disciplineDto.getQueryName();
        List<SrmDiscipline> list=null;
        if(str==null||str.isEmpty()){
            list=srmDisciplineService.selectAll();
        }else{
            QueryWrapper<SrmDiscipline> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("name",str).or().eq("code",str);
            list=srmDisciplineService.list(queryWrapper);
        }

        List<CombVo> combVos=new ArrayList<>();
        for(SrmDiscipline srmDiscipline:list){
            CombVo combVo=new CombVo();
            combVo.setId(srmDiscipline.getCode());
            combVo.setName(srmDiscipline.getName());
            combVos.add(combVo);
        }
        return new AppListVo<>(disciplineDto.getPage(),disciplineDto.getLimit(),combVos);
    }

    @Override

    // 成果的项目来源
    public AppListVo<CombVo> getProjectsource(BaseDto baseDto) {
        String str=baseDto.getQueryName();
        List<SrmProductProjectsource> list=null;
        if(str==null||str.isEmpty()){
            list=srmProductProjectsourceService.selectAll();
        }else{
            QueryWrapper<SrmProductProjectsource> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("name",str).or().eq("code",str);
            list=srmProductProjectsourceService.list(queryWrapper);
        }

        List<CombVo> combVos=new ArrayList<>();
        for(SrmProductProjectsource srmProductProjectsource:list){
            CombVo combVo=new CombVo();
            combVo.setId(srmProductProjectsource.getCode());
            combVo.setName(srmProductProjectsource.getName());
            combVos.add(combVo);
        }
        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),combVos);

    }

    @Override
    // 出版社
    public AppListVo<CombVo> getPressInfo(BaseDto baseDto) {
        String str=baseDto.getQueryName();
        List<SrmPressInfo> list=null;
        if(str==null||str.isEmpty()){
            list=srmPressInfoService.selectAll();
        }else{
            QueryWrapper<SrmPressInfo> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("name",str).or().eq("code",str);
            list=srmPressInfoService.list(queryWrapper);
        }

        List<CombVo> combVos=new ArrayList<>();
        for(SrmPressInfo srmPressInfo:list){
            CombVo combVo=new CombVo();
            combVo.setId(srmPressInfo.getCode());
            combVo.setName(srmPressInfo.getName());
            combVos.add(combVo);
        }
        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),combVos);
    }

    @Override
    // 语言 语种
    public AppListVo<CombVo> getLanguage(BaseDto baseDto) {
        String str=baseDto.getQueryName();
        List<SrmLanguage> list=null;
        if(str==null||str.isEmpty()){
            list=srmLanguageService.selectAll();
        }else{
            QueryWrapper<SrmLanguage> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("name",str).or().eq("code",str);
            list=srmLanguageService.list(queryWrapper);
        }

        List<CombVo> combVos=new ArrayList<>();
        for(SrmLanguage srmLanguage:list){
            CombVo combVo=new CombVo();
            combVo.setId(srmLanguage.getCode());
            combVo.setName(srmLanguage.getName());
            combVos.add(combVo);
        }
        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),combVos);
    }

    @Override
    // 人员类型
    public AppListVo<CombVo> getPersonType(BaseDto baseDto) {

        String str=baseDto.getQueryName();
        List<SrmPersonType> list=null;
        if(str==null||str.isEmpty()){
            list=srmPersonTypeService.selectAll();
        }else{
            QueryWrapper<SrmPersonType> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("name",str).or().eq("code",str);
            list=srmPersonTypeService.list(queryWrapper);
        }

        List<CombVo> combVos=new ArrayList<>();
        for(SrmPersonType srmPersonType:list){
            CombVo combVo=new CombVo();
            combVo.setId(srmPersonType.getCode());
            combVo.setName(srmPersonType.getName());
            combVos.add(combVo);
        }
        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),combVos);
    }

    @Override
    // 作者位次
    public AppListVo<CombVo> getPaperAuthorOrder(BaseDto baseDto) {

        String str=baseDto.getQueryName();
        List<SrmPaperAuthorOrder> list=null;
        if(str==null||str.isEmpty()){
            list=srmPaperAuthorOrderService.selectAll();
        }else{
            QueryWrapper<SrmPaperAuthorOrder> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("name",str).or().eq("code",str);
            list=srmPaperAuthorOrderService.list(queryWrapper);
        }

        List<CombVo> combVos=new ArrayList<>();
        for(SrmPaperAuthorOrder srmPaperAuthorOrder:list){
            CombVo combVo=new CombVo();
            combVo.setId(srmPaperAuthorOrder.getCode());
            combVo.setName(srmPaperAuthorOrder.getName());
            combVos.add(combVo);
        }
        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),combVos);
    }

    @Override
    // 作者身份 （编者, 主编等)
    public AppListVo<CombVo> getEditorType(BaseDto baseDto) {
        String str=baseDto.getQueryName();
        List<SrmEditorType> list=null;
        if(str==null||str.isEmpty()){
            list=srmEditorTypeService.selectAll();
        }else{
            QueryWrapper<SrmEditorType> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("name",str).or().eq("code",str);
            list=srmEditorTypeService.list(queryWrapper);
        }

        List<CombVo> combVos=new ArrayList<>();
        for(SrmEditorType srmEditorType:list){
            CombVo combVo=new CombVo();
            combVo.setId(srmEditorType.getCode());
            combVo.setName(srmEditorType.getName());
            combVos.add(combVo);
        }
        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),combVos);
    }

    // 期刊
    @Override
    public AppListVo<CombVo> getJournal(BaseDto baseDto) {

        String str=baseDto.getQueryName();
        List<SrmJournal> list=null;
        if(str==null||str.isEmpty()){
            list=srmJournalService.selectAll();
        }else{
            QueryWrapper<SrmJournal> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("name",str).or().eq("code",str);
            list=srmJournalService.list(queryWrapper);
        }

        List<CombVo> combVos=new ArrayList<>();
        for(SrmJournal srmJournal:list){
            CombVo combVo=new CombVo();
            combVo.setId(srmJournal.getCode());
            combVo.setName(srmJournal.getName());
            combVos.add(combVo);
        }
        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),combVos);
    }
    // 期刊类型
    @Override
    public AppListVo<CombVo> getJournalType(BaseDto baseDto) {

        String str=baseDto.getQueryName();
        List<SrmJournalType> list=null;
        if(str==null||str.isEmpty()){
            list=srmJournalTypeService.selectAll();
        }else{
            QueryWrapper<SrmJournalType> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("name",str).or().eq("code",str);
            list=srmJournalTypeService.list(queryWrapper);
        }

        List<CombVo> combVos=new ArrayList<>();
        for(SrmJournalType srmJournalType:list){
            CombVo combVo=new CombVo();
            combVo.setId(srmJournalType.getCode());
            combVo.setName(srmJournalType.getName());
            combVos.add(combVo);
        }
        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),combVos);
    }
    // 职称
    @Override
    public AppListVo<CombVo> getUserTitle(BaseDto baseDto) {
        List<CombVo> list= srmTitleInfoService.getUserTitle(new TitleInfoDto());
        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),list);
    }
    // 报销途径
    @Override
    public List<CombVo> getReimbursementWay() {
        return srmReimbursementWayService.getReimbursementWay();
    }
    // 论文类型
    @Override
    public AppListVo<CombVo> getPaperThesisType(BaseDto baseDto) {
        String str=baseDto.getQueryName();
        List<SrmPaperThesisType> list=null;
        if(str==null||str.isEmpty()){
            list=srmPaperThesisTypeService.selectAll();
        }else{
            QueryWrapper<SrmPaperThesisType> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("name",str).or().eq("code",str);
            list=srmPaperThesisTypeService.list(queryWrapper);
        }

        List<CombVo> combVos=new ArrayList<>();
        for(SrmPaperThesisType srmPaperThesisType:list){
            CombVo combVo=new CombVo();
            combVo.setId(srmPaperThesisType.getCode());
            combVo.setName(srmPaperThesisType.getName());
            combVos.add(combVo);
        }
        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),combVos);
    }
    // 单位位次
    @Override
    public AppListVo<CombVo> getUnitOrder(BaseDto baseDto) {
        String str=baseDto.getQueryName();
        List<SrmUnitOrder> list=null;
        if(str==null||str.isEmpty()){
            list=srmUnitOrderService.selectAll();
        }else{
            QueryWrapper<SrmUnitOrder> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("name",str).or().eq("code",str);
            list=srmUnitOrderService.list(queryWrapper);
        }
        List<CombVo> combVos=new ArrayList<>();
        for(SrmUnitOrder srmUnitOrder:list){
            CombVo combVo=new CombVo();
            combVo.setId(srmUnitOrder.getCode());
            combVo.setName(srmUnitOrder.getName());
            combVos.add(combVo);
        }
        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),combVos);

    }
    // 版面
    @Override
    public AppListVo<CombVo> getPageSpace(BaseDto baseDto) {

        String str=baseDto.getQueryName();
        List<SrmPageSpace> list=null;
        if(str==null||str.isEmpty()){
            list=srmPageSpaceService.selectAll();
        }else{
            QueryWrapper<SrmPageSpace> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("name",str).or().eq("code",str);
            list=srmPageSpaceService.list(queryWrapper);
        }
        List<CombVo> combVos=new ArrayList<>();
        for(SrmPageSpace srmPageSpace:list){
            CombVo combVo=new CombVo();
            combVo.setId(srmPageSpace.getCode());
            combVo.setName(srmPageSpace.getName());
            combVos.add(combVo);
        }
        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),combVos);
    }
    // 依托单位
    @Override
    public AppListVo<CombVo> getRelyUnit(BaseDto baseDto) {
        String str=baseDto.getQueryName();
        List<SrmRelyUnit> list=null;
        if(str==null||str.isEmpty()){
            list=srmRelyUnitService.selectAll();
        }else{
            QueryWrapper<SrmRelyUnit> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("name",str).or().eq("code",str);
            list=srmRelyUnitService.list(queryWrapper);
        }
        List<CombVo> combVos=new ArrayList<>();
        for(SrmRelyUnit srmRelyUnit:list){
            CombVo combVo=new CombVo();
            combVo.setId(srmRelyUnit.getCode());
            combVo.setName(srmRelyUnit.getName());
            combVos.add(combVo);
        }
        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),combVos);
    }
    // 专利费来源
    @Override
    public AppListVo<CombVo> getPatentAgencyFeeSource(BaseDto baseDto) {
        String str=baseDto.getQueryName();
        List<SrmPatentAgencyFeeSource> list=null;
        if(str==null||str.isEmpty()){
            list=srmPatentAgencyFeeSourceService.selectAll();
        }else{
            QueryWrapper<SrmPatentAgencyFeeSource> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("name",str).or().eq("code",str);
            list=srmPatentAgencyFeeSourceService.list(queryWrapper);
        }
        List<CombVo> combVos=new ArrayList<>();
        for(SrmPatentAgencyFeeSource srmPatentAgencyFeeSource:list){
            CombVo combVo=new CombVo();
            combVo.setId(srmPatentAgencyFeeSource.getCode());
            combVo.setName(srmPatentAgencyFeeSource.getName());
            combVos.add(combVo);
        }
        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),combVos);
    }
    // 专利状态
    @Override
    public AppListVo<CombVo> getPatentState(BaseDto baseDto) {
        String str=baseDto.getQueryName();
        List<SrmPatentState> list=null;
        if(str==null||str.isEmpty()){
            list=srmPatentStateService.selectAll();
        }else{
            QueryWrapper<SrmPatentState> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("name",str).or().eq("code",str);
            list=srmPatentStateService.list(queryWrapper);
        }
        List<CombVo> combVos=new ArrayList<>();
        for(SrmPatentState srmPatentState:list){
            CombVo combVo=new CombVo();
            combVo.setId(srmPatentState.getCode());
            combVo.setName(srmPatentState.getName());
            combVos.add(combVo);
        }
        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),combVos);
    }
    // 专利类型
    @Override
    public AppListVo<CombVo> getPatentType(BaseDto baseDto) {
        String str=baseDto.getQueryName();
        List<SrmPatentType> list=null;
        if(str==null||str.isEmpty()){
            list=srmPatentTypeService.selectAll();
        }else{
            QueryWrapper<SrmPatentType> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("name",str).or().eq("code",str);
            list=srmPatentTypeService.list(queryWrapper);
        }
        List<CombVo> combVos=new ArrayList<>();
        for(SrmPatentType srmPatentType:list){
            CombVo combVo=new CombVo();
            combVo.setId(srmPatentType.getCode());
            combVo.setName(srmPatentType.getName());
            combVos.add(combVo);
        }
        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),combVos);
    }
    // 获奖等次
    @Override
    public AppListVo<CombVo> getAwardGrade(BaseDto baseDto) {
        String str=baseDto.getQueryName();
        List<SrmAwardGrade> list=null;
        if(str==null||str.isEmpty()){
            list=srmAwardGradeService.selectAll();
        }else{
            QueryWrapper<SrmAwardGrade> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("name",str).or().eq("code",str);
            list=srmAwardGradeService.list(queryWrapper);
        }
        List<CombVo> combVos=new ArrayList<>();
        for(SrmAwardGrade srmAwardGrade:list){
            CombVo combVo=new CombVo();
            combVo.setId(srmAwardGrade.getCode());
            combVo.setName(srmAwardGrade.getName());
            combVos.add(combVo);
        }
        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),combVos);
    }
    // 获奖级别
    @Override
    public AppListVo<CombVo> getAwardLevel(BaseDto baseDto) {
        String str=baseDto.getQueryName();
        List<SrmAwardLevel> list=null;
        if(str==null||str.isEmpty()){
            list=srmAwardLevelService.selectAll();
        }else{
            QueryWrapper<SrmAwardLevel> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("name",str).or().eq("code",str);
            list=srmAwardLevelService.list(queryWrapper);
        }
        List<CombVo> combVos=new ArrayList<>();
        for(SrmAwardLevel srmAwardLevel:list){
            CombVo combVo=new CombVo();
            combVo.setId(srmAwardLevel.getCode());
            combVo.setName(srmAwardLevel.getName());
            combVos.add(combVo);
        }
        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),combVos);
    }
    // 项目申请状态
    @Override
    public AppListVo<CombVo> getProjectApplyInfoState(BaseDto baseDto) {
        String str=baseDto.getQueryName();
        List<SrmProjectApplyInfoState> list=null;
        if(str==null||str.isEmpty()){
            list=srmProjectApplyInfoStateService.selectAll();
        }else{
            QueryWrapper<SrmProjectApplyInfoState> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("name",str).or().eq("code",str);
            list=srmProjectApplyInfoStateService.list(queryWrapper);
        }
        List<CombVo> combVos=new ArrayList<>();
        for(SrmProjectApplyInfoState srmProjectApplyInfoState:list){
            CombVo combVo=new CombVo();
            combVo.setId(srmProjectApplyInfoState.getCode());
            combVo.setName(srmProjectApplyInfoState.getName());
            combVos.add(combVo);
        }
        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),combVos);
    }
    // 获奖类型
    @Override
    public AppListVo<CombVo> getRewardType(BaseDto baseDto) {
        String str=baseDto.getQueryName();
        List<SrmRewardType> list=null;
        if(str==null||str.isEmpty()){
            list=srmRewardTypeService.selectAll();
        }else{
            QueryWrapper<SrmRewardType> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("name",str).or().eq("code",str);
            list=srmRewardTypeService.list(queryWrapper);
        }
        List<CombVo> combVos=new ArrayList<>();
        for(SrmRewardType srmRewardType:list){
            CombVo combVo=new CombVo();
            combVo.setId(srmRewardType.getCode());
            combVo.setName(srmRewardType.getName());
            combVos.add(combVo);
        }
        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),combVos);
    }
    // 成果形式
    @Override
    public AppListVo<CombVo> getProductMode(BaseDto baseDto) {
        String str=baseDto.getQueryName();
        List<SrmProductMode> list=null;
        if(str==null||str.isEmpty()){
            list=srmProductModeService.selectAll();
        }else{
            QueryWrapper<SrmProductMode> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("name",str).or().eq("code",str);
            list=srmProductModeService.list(queryWrapper);
        }
        List<CombVo> combVos=new ArrayList<>();
        for(SrmProductMode srmProductMode:list){
            CombVo combVo=new CombVo();
            combVo.setId(srmProductMode.getCode());
            combVo.setName(srmProductMode.getName());
            combVos.add(combVo);
        }
        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),combVos);
    }
    // 获奖分类
    @Override
    public AppListVo<CombVo> getAchievementCat(BaseDto baseDto) {
        String str=baseDto.getQueryName();
        List<SrmAchievementCat> list=null;
        if(str==null||str.isEmpty()){
            list=srmAchievementCatService.selectAll();
        }else{
            QueryWrapper<SrmAchievementCat> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("name",str).or().eq("code",str);
            list=srmAchievementCatService.list(queryWrapper);
        }
        List<CombVo> combVos=new ArrayList<>();
        for(SrmAchievementCat srmAchievementCat:list){
            CombVo combVo=new CombVo();
            combVo.setId(srmAchievementCat.getCode());
            combVo.setName(srmAchievementCat.getName());
            combVos.add(combVo);
        }
        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),combVos);
    }

    @Override
    public AppListVo<CombVo>  getProjLevel(BaseDto baseDto) {
        String str = baseDto.getQueryName();
        List<SrmProjLevel> list = null;
        if (str == null || str.isEmpty()) {
            list = srmProjLevelService.selectAll();
        } else {
            QueryWrapper<SrmProjLevel> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("name", str).or().eq("code", str);
            list = srmProjLevelService.list(queryWrapper);
        }
        List<CombVo> combVos = new ArrayList<>();
        for (SrmProjLevel srmProjLevel : list) {
            CombVo combVo = new CombVo();
            combVo.setId(srmProjLevel.getCode());
            combVo.setName(srmProjLevel.getName());
            combVos.add(combVo);
        }
        return new AppListVo<>(baseDto.getPage(), baseDto.getLimit(), combVos);
    }
    @Override
    public List<CombVo>  getProjClass(){return srmProjectClassService.getProjClass();}
    @Override
    public List<CombVo>  getGroup(){ return srmGroupAuthConfigService.getGroup();}

    public List<CombVo>  getSystemModule(){ return srmSystemModuleService.getSystemModule();}
    @Override
    public List<CombVo> getEduDegree(@RequestBody(required = false) EduDegreeDto eduDegreeDto){ return srmEduDegreeService.getEduDegree(eduDegreeDto);}
    @Override
    public List<CombVo> getEduLevel(@RequestBody(required = false) EduLevelDto eduLevelDto){ return srmEduLevelService.getEduLevel(eduLevelDto);}
    @Override
    public List<CombVo> getOccupationCategory(OccupationCategoryDto occupationCategoryDto){ return srmOccupationCategoryService.getOccupationCategory(occupationCategoryDto);}
    @Override
    public List<CombVo> getJobType(JobTypeDto jobTypeDto){return srmJobTypeService.getJobType(jobTypeDto); }
    @Override
    public AppListVo<CombVo> getPartTimeJob(BaseDto baseDto){
        List<CombVo> list= srmParttimeJobService.getPartTimeJob(new ParttimeJobDto());
        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),list);
    }

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
    public AppListVo<CombVo> getProjectType(BaseDto baseDto)  {
        String str=baseDto.getQueryName();
        List<SrmProjType> list=null;
        if(str==null||str.isEmpty()){
            list=srmProjTypeService.selectAll();
        }else{
            QueryWrapper<SrmProjType> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("name",str).or().eq("code",str);
            list=srmProjTypeService.list(queryWrapper);
        }

        List<CombVo> combVos=new ArrayList<>();
        for(SrmProjType srmProjType:list){
            CombVo combVo=new CombVo();
            combVo.setId(srmProjType.getCode());
            combVo.setName(srmProjType.getName());
            combVos.add(combVo);
        }

        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),combVos);


    }

    @Override
    public List<CombVo> getExpertGroup()  {return srmExpertGroupService.getExpertGroup();}

    @Override
    public List<CombVo> getUnitType() {return srmUnitTypeService.getUnitType();}

    @Override
    public List<CombVo> getTutor() {return srmUserService.getTutor();}
    // 依托项目
    @Override
    public AppListVo<CombVo> getProject(BaseDto baseDto){
        String str=baseDto.getQueryName();
        List<SrmProjectsInfo> list=null;
        if(str==null||str.isEmpty()){
            QueryWrapper<SrmProjectsInfo> queryWrapper=new QueryWrapper<>();
            //queryWrapper.in("proj_status", Arrays.asList('2','3','7'));
            list=srmProjectsInfoService.list(queryWrapper);
        }else{
            QueryWrapper<SrmProjectsInfo> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("name",str);
            //queryWrapper.in("proj_status", Arrays.asList('2','3','7'));
            list=srmProjectsInfoService.list(queryWrapper);
        }
        List<CombVo> combVos=new ArrayList<>();
        for(SrmProjectsInfo srmProjectsInfo:list){
            CombVo combVo=new CombVo();
            combVo.setId(String.valueOf(srmProjectsInfo.getId()));
            combVo.setName(srmProjectsInfo.getName());
            combVos.add(combVo);
        }
        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),combVos);

    }

    @Override
    public AppListVo<CombVo>  getConferenceType(BaseDto baseDto){
        List<CombVo> combVos=new ArrayList<>();
        List<CombVo> list=srmConferenceTypeService.getConferenceType();

//        for(SrmProjectsInfo srmProjectsInfo:list){
//            CombVo combVo=new CombVo();
//            combVo.setId(String.valueOf(srmProjectsInfo.getId()));
//            combVo.setName(srmProjectsInfo.getName());
//            combVos.add(combVo);
//        }
        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),list);
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
    public AppListVo<CombVo>  getProjectApplyBookType(BaseDto baseDto) {
        String str=baseDto.getQueryName();
        List<SrmProjectApplyBookType> list=null;
        if(str==null||str.isEmpty()){
            list=srmProjectApplyBookTypeService.selectAll();
        }else{
            QueryWrapper<SrmProjectApplyBookType> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("name",str).or().eq("code",str);
            list=srmProjectApplyBookTypeService.list(queryWrapper);
        }

        List<CombVo> combVos=new ArrayList<>();
        for(SrmProjectApplyBookType srmProjectApplyBookType:list){
            CombVo combVo=new CombVo();
            combVo.setId(srmProjectApplyBookType.getCode());
            combVo.setName(srmProjectApplyBookType.getName());
            combVos.add(combVo);
        }

        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),combVos);

    }

    @Override
    public AppListVo<CombVo>  getResearchField(BaseDto baseDto) {
        String str=baseDto.getQueryName();
        List<SrmResearchField> list=null;
        if(str==null||str.isEmpty()){
            list=srmResearchFieldService.selectAll();
        }else{
            QueryWrapper<SrmResearchField> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("name",str).or().eq("code",str);
            list=srmResearchFieldService.list(queryWrapper);
        }

        List<CombVo> combVos=new ArrayList<>();
        for(SrmResearchField srmProjectApplyBookType:list){
            CombVo combVo=new CombVo();
            combVo.setId(srmProjectApplyBookType.getCode());
            combVo.setName(srmProjectApplyBookType.getName());
            combVos.add(combVo);
        }

        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),combVos);

    }

    @Override
    public AppListVo<CombVo> getProjectCooprateForm(BaseDto baseDto) {
        String str=baseDto.getQueryName();
        List<SrmProjectCooperationForm> list=null;
        if(str==null||str.isEmpty()){
            list=srmProjectCooperationFormService.selectAll();
        }else{
            QueryWrapper<SrmProjectCooperationForm> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("name",str).or().eq("code",str);
            list=srmProjectCooperationFormService.list(queryWrapper);
        }

        List<CombVo> combVos=new ArrayList<>();
        for(SrmProjectCooperationForm srmProjectCooperationForm:list){
            CombVo combVo=new CombVo();
            combVo.setId(srmProjectCooperationForm.getCode());
            combVo.setName(srmProjectCooperationForm.getName());
            combVos.add(combVo);
        }

        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),combVos);

    }

    @Override
    public AppListVo<CombVo> getProjectOrgForm(BaseDto baseDto) {
        String str=baseDto.getQueryName();
        List<SrmProjectOrgForm> list=null;
        if(str==null||str.isEmpty()){
            list=srmProjectOrgFormService.selectAll();
        }else{
            QueryWrapper<SrmProjectOrgForm> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("name",str).or().eq("code",str);
            list=srmProjectOrgFormService.list(queryWrapper);
        }

        List<CombVo> combVos=new ArrayList<>();
        for(SrmProjectOrgForm srmProjectOrgForm:list){
            CombVo combVo=new CombVo();
            combVo.setId(srmProjectOrgForm.getCode());
            combVo.setName(srmProjectOrgForm.getName());
            combVos.add(combVo);
        }

        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),combVos);

    }

    @Override
    public AppListVo<CombVo> getSocEconomicObj(BaseDto baseDto) {
        String str=baseDto.getQueryName();
        List<SrmSocEconomicObj> list=null;
        if(str==null||str.isEmpty()){
            list=srmSocEconomicObjService.selectAll();
        }else{
            QueryWrapper<SrmSocEconomicObj> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("name",str).or().eq("code",str);
            list=srmSocEconomicObjService.list(queryWrapper);
        }

        List<CombVo> combVos=new ArrayList<>();
        for(SrmSocEconomicObj srmSocEconomicObj:list){
            CombVo combVo=new CombVo();
            combVo.setId(srmSocEconomicObj.getCode());
            combVo.setName(srmSocEconomicObj.getName());
            combVos.add(combVo);
        }

        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),combVos);

    }

    @Override
    public AppListVo<CombVo> getNationalEconomyIndustry(BaseDto baseDto) {
        String str=baseDto.getQueryName();
        String upCode=baseDto.getUpCode();
        List<SrmNationalEconomyIndustry> list=null;
        QueryWrapper<SrmNationalEconomyIndustry> queryWrapper=new QueryWrapper<>();
        //up_code
        if(str!=null&&!str.isEmpty()){
            queryWrapper.eq("name",str).or().eq("code",str);
        }
        if(upCode!=null&&!upCode.isEmpty()){

            queryWrapper.eq("up_code",upCode);

        }
        list=srmNationalEconomyIndustryService.list(queryWrapper);
        List<CombVo> combVos=new ArrayList<>();
        for(SrmNationalEconomyIndustry srmNationalEconomyIndustry:list){
            CombVo combVo=new CombVo();
            combVo.setId(srmNationalEconomyIndustry.getCode());
            combVo.setName(srmNationalEconomyIndustry.getName());
            combVos.add(combVo);
        }

        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),combVos);

    }

    @Override
    public AppListVo<CombVo> getParttimeType(BaseDto baseDto) {
        List<CombVo> list =  srmParttimeTypeService.getParttimeType();
        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),list);
    }

    @Override
    public AppListVo<CombVo> getCommitteeInfo(BaseDto baseDto) {
        List<CombVo> list = srmCommitteeInfoService.getCommitteeInfo();
        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),list);
    }
    @Override
    public AppListVo<CombVo> getProjStatSource(BaseDto baseDto) {
        String str=baseDto.getQueryName();
        List<SrmProjStatSource> list=null;
        if(str==null||str.isEmpty()){
            list=srmProjStatSourceService.selectAll();
        }else{
            QueryWrapper<SrmProjStatSource> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("name",str).or().eq("code",str);
            list=srmProjStatSourceService.list(queryWrapper);
        }

        List<CombVo> combVos=new ArrayList<>();
        for(SrmProjStatSource srmProjStatSource:list){
            CombVo combVo=new CombVo();
            combVo.setId(srmProjStatSource.getCode());
            combVo.setName(srmProjStatSource.getName());
            combVos.add(combVo);
        }

        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),combVos);

    }
    @Override
    public AppListVo<CombVo> getPartnerType(BaseDto baseDto){

        String str=baseDto.getQueryName();
        List<SrmPartnerType> list=null;
        if(str==null||str.isEmpty()){
            list=srmPartnerTypeService.selectAll();
        }else{
            QueryWrapper<SrmPartnerType> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("name",str).or().eq("code",str);
            list=srmPartnerTypeService.list(queryWrapper);
        }

        List<CombVo> combVos=new ArrayList<>();
        for(SrmPartnerType srmPartnerType:list){
            CombVo combVo=new CombVo();
            combVo.setId(srmPartnerType.getCode());
            combVo.setName(srmPartnerType.getName());
            combVos.add(combVo);
        }

        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),combVos);

    }

    @Override
    public AppListVo<CombVo> getContractRole(BaseDto baseDto){
        String str=baseDto.getQueryName();
        List<SrmContractRole> list=null;
        if(str==null||str.isEmpty()){
            list=srmContractRoleService.selectAll();
        }else{
            QueryWrapper<SrmContractRole> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("name",str).or().eq("code",str);
            list=srmContractRoleService.list(queryWrapper);
        }

        List<CombVo> combVos=new ArrayList<>();
        for(SrmContractRole srmContractRole:list){
            CombVo combVo=new CombVo();
            combVo.setId(srmContractRole.getCode());
            combVo.setName(srmContractRole.getName());
            combVos.add(combVo);
        }

        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),combVos);

    }
    @Override
    public AppListVo<CombVo> getContractType(BaseDto baseDto){

        String str=baseDto.getQueryName();
        List<SrmContractType> list=null;
        if(str==null||str.isEmpty()){
            list=srmContractTypeService.selectAll();
        }else{
            QueryWrapper<SrmContractType> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("name",str).or().eq("code",str);
            list=srmContractTypeService.list(queryWrapper);
        }

        List<CombVo> combVos=new ArrayList<>();
        for(SrmContractType srmContractType:list){
            CombVo combVo=new CombVo();
            combVo.setId(srmContractType.getCode());
            combVo.setName(srmContractType.getName());
            combVos.add(combVo);
        }

        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),combVos);

    }

    @Override
    public AppListVo<CombVo> getLectureLevel(BaseDto baseDto) {
        List<CombVo> list = srmLectureLevelService.getLectureLevel();
        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),list);
    }

    @Override
    public AppListVo<CombVo> getLectureType(BaseDto baseDto) {
        List<CombVo> list = srmLectureTypeService.getLectureType();
        return new AppListVo<>(baseDto.getPage(),baseDto.getLimit(),list);
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
        /*
        List<HosOrgOrganization> list = hosSrmService.getHosOrgOrganizationList();
        List<CombVo> combVoList = new ArrayList<>();
        for (HosOrgOrganization org : list) {
            CombVo combVo = new CombVo();
            BeanUtils.copyProperties(org, combVo);
            combVo.setId(org.getCode());
            combVoList.add(combVo);
        }
        return combVoList;
        */

        return null;
    }
}
