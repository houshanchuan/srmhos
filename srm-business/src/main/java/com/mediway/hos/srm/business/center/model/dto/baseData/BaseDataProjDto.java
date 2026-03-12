package com.mediway.hos.srm.business.center.model.dto.baseData;

import lombok.Data;

import java.util.List;

@Data
public class BaseDataProjDto {
    private String mainId;
    private List<ProjectOrgFormDto> projectOrgForms; //项目组织形式
    private List<YearDto> years; //年度
    private List<ClinicalStudyFileTypeDto> clinicalStudyFileTypes; //临床研究申请文件类型
    private List<ProjLevelDto> projLevels; //项目级别
    private List<ProjStatSourceDto> projStatSources; //项目来源
    private List<ProjectCooprateFormDto> projectCooprateForms; //项目合作形式
    private List<SocEconomicObjDto> socEconomicObjs; //社会经济目标
    private List<NationalEconomyIndustryDto> nationalEconomyIndustrys; //国民经济行业
    private List<ContractTypeDto> contractTypes; //合同类型
    private List<IndustryCodeDto> industryCodes; //行业代码
    private List<ProjectClassDto> projectClasss; //项目性质
    private List<PayModeDto> payModes; //支付方式
    private List<ProgramCategoryDto> programCategorys; //计划类别
    private List<ImburseTypeDto> imburseTypes; //资助方式
    private List<CurrencyDto> currencys; //币种
    private List<FinishFormalDto> finishFormals; //完成形式
    private List<ProjectApplyBookTypeDto> projectApplyBookTypes; //申报类别
    private List<ProjTypeDto> projTypes; //项目分类
    private List<ProjTypeSubDto> projTypeSubs; //项目子类
    private List<ProjDependenceTypeDto> projDependenceTypes; //项目依赖类型
    private List<ProjSecretLevelDto> projSecretLevels; //项目密级
    private List<PartnerTypeDto> partnerTypes; //对方类型
    private List<PayTypeDto> payTypes; //付款类型
    private List<ProjectApplyUnitTypeDto> projectApplyUnitTypes; //项目申报部门类型
    private List<ProjectApplyTypeDto> projectApplyTypes; //项目申报类型
    private List<MemberRoleDto> memberRoles; //成员角色
    private List<UnitOrderDto> unitOrders; //单位排序
    private List<IdentifyResultDto> identifyResults; //鉴定结果（结论）
    private List<ContractRoleDto> contractRoles; //合同角色
    private List<LocationDto> locations; //区域位置表（省市县）
    private List<ProductProjectSourceDto> productProjectSources; //成果项目来源（统计）
    private List<CooperateUnitTypeDto> cooperateUnitTypes;  //合作单位类型
    private List<CooperationTypeDto>  cooperationTypes ; //合作类型



}
