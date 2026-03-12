package com.mediway.hos.srm.business.center.model.dto.baseData;

import com.mediway.hos.srm.business.center.model.dto.systemConfig.SysParameterDto;
import com.mediway.hos.srm.business.center.model.dto.systemConfig.SysParameterTypeDto;
import com.mediway.hos.srm.business.center.model.dto.systemConfig.SystemModuleDto;
import lombok.Data;

import java.util.List;

@Data
public class BaseDataCommonDto {
    private List<YearDto> years; //年度
    private List<SecretTierDto> secretTiers; //涉密级别代码
    private List<SubjectClassDto> classs; //学科门类
    private List<DisciplineDto> disciplines; //学科分类
    private List<ResearchTypeDto> researchTypes; //研究类型
    private List<ResearchFieldDto> researchFields; //研究领域
    private List<SocEconomicObjDto> SocEconomicObjDtos; //社会经济目标
    private List<NationalEconomyIndustryDto> nationalEconomyIndustrys; //国民经济行业
    private List<YearWorkMonthDto> yearWorkMonths; //年工作量（月）
    private List<EafCheckStatusDto> eafCheckStatuss; //审批流审核状态
    private List<CheckStatusDto> checkStatuss; //审核状态
    private List<ProjectStatusDto> projectStatuss; //项目状态
    private List<ProjectApplyStateDto> projectApplyStates; //项目申报状态
    private List<ProjectApprovalStatusDto> projectApprovalStatuss; //项目申报立项状态
    private List<ProjectApplyInfoStateDto> projectApplyInfoStates; //项目申报批次状态
    private List<ProjMidCheckBookStateDto> projMidCheckBookStates; //项目中检状态
    private List<ProjMidCheckListInfoStateDto> projMidCheckListInfoStates; //中检批次状态
    private List<LocationDto> locations; //区域位置表(省市县
    private List<PatentStateDto> patentStates; //专利状态
    private List<ReviewStateDto> ReviewStates; //专家评审状态

    private List<SystemModuleDto> systemModules; //专家评审状态

    private List<FtpInfoConfigDto> ftpInfoConfigs;
    private List<GroupAuthConfigDto> groupAuthConfigs;
    private List<SysParameterTypeDto> sysParameterTypes;
    private List<SysParameterDto> sysParameters;
    private List<TemplateDownloadDto>  templateDownloads;
    private List<HospitalDto> srmHospitals;



}
