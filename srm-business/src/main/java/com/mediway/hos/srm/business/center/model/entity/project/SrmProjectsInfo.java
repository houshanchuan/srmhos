package com.mediway.hos.srm.business.center.model.entity.project;

import com.baomidou.mybatisplus.annotation.*;

import java.math.BigDecimal;

import java.time.LocalDateTime;
import com.mediway.hos.srm.business.base.model.entity.BasePO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 课题信息表(项目)
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="ProjectsInfo对象", description="课题信息表(项目)")
@TableName("srm_projects_info")
public class SrmProjectsInfo extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "科室")
    @TableField("dept_id")
    private String deptId;

    @ApiModelProperty(value = "负责人")
    @TableField("head")
    private String head;

    @ApiModelProperty(value = "项目来源")
    @TableField("sub_source")
    private String subSource;

    @ApiModelProperty(value = "项目编号")
    @TableField("sub_no")
    private String subNo;

    @ApiModelProperty(value = "申请经费")
    @TableField("app_funds_amt")
    private BigDecimal appFundsAmt;

    @ApiModelProperty(value = "批准经费")
    @TableField("gra_funds_amt")
    private BigDecimal graFundsAmt;

    @ApiModelProperty(value = "起始日期")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="start_date")
    private LocalDateTime startDate;

    @ApiModelProperty(value = "截止日期")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="end_date")
    private LocalDateTime endDate;

    @ApiModelProperty(value = "验收申请日期")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="con_date")
    private LocalDateTime conDate;

    @ApiModelProperty(value = "合作单位")
    @TableField("rely_unit")
    private String relyUnit;

    @ApiModelProperty(value = "申请人")
    @TableField("sub_user_id")
    private String subUserId;

    @ApiModelProperty(value = "填表日期或登记日期")
    @TableField("sub_date")
    private LocalDateTime subDate;

    @ApiModelProperty(value = "数据状态")
    @TableField("data_status")
    private Integer dataStatus;

    @ApiModelProperty(value = "审核结果")
    @TableField("res_audit")
    private String resAudit;

    @ApiModelProperty(value = "审核结果描述")
    @TableField("res_desc")
    private String resDesc;

    @ApiModelProperty(value = "审核人")
    @TableField("audit_user_id")
    private String auditUserId;

    @ApiModelProperty(value = "审核日期")
    @TableField("audit_date")
    private LocalDateTime auditDate;

    @ApiModelProperty(value = "状态")
    @TableField("proj_status")
    private String projStatus;

    @ApiModelProperty(value = "备注")
    @TableField("remark")
    private String remark;

    @ApiModelProperty(value = "系统号")
    @TableField("sys_no")
    private String sysNo;

    @ApiModelProperty(value = "立项日期")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="issued_date")
    private LocalDateTime issuedDate;

    @ApiModelProperty(value = "项目(课题)性质")
    @TableField("proj_class")
    private String projClass;

    @ApiModelProperty(value = "年度")
    @TableField("year")
    private String year;

    @ApiModelProperty(value = "上级拨款")
    @TableField("proj_fund_gov")
    private BigDecimal projFundGov;

    @ApiModelProperty(value = "医院配套")
    @TableField("proj_fund_own")
    private BigDecimal projFundOwn;

    @ApiModelProperty(value = "已到位或已匹配经费")
    @TableField("prj_fund_matched")
    private BigDecimal prjFundMatched;

    @ApiModelProperty(value = "是否政府项目")
    @TableField("is_govbuy")
    private Integer isGovbuy;

    @ApiModelProperty(value = "警戒线")
    @TableField("alert_percent")
    private Integer alertPercent;

    @ApiModelProperty(value = "出版专著")
    @TableField("monograph_num")
    private Integer monographNum;

    @ApiModelProperty(value = "发表论文")
    @TableField("paper_num")
    private Integer paperNum;

    @ApiModelProperty(value = "专利")
    @TableField("patent_num")
    private Integer patentNum;

    @ApiModelProperty(value = "参与定制技术标准")
    @TableField("invin_custom_stan_num")
    private Integer invinCustomStanNum;

    @ApiModelProperty(value = "培养人才")
    @TableField("train_num")
    private Integer trainNum;

    @ApiModelProperty(value = "举办培训班")
    @TableField("hold_train_num")
    private Integer holdTrainNum;

    @ApiModelProperty(value = "参与培训班")
    @TableField("in_training_num")
    private Integer inTrainingNum;

    @ApiModelProperty(value = "是否伦理审查")
    @TableField("is_ethical_approval")
    private Integer isEthicalApproval;

    @ApiModelProperty(value = "伦理审批结果")
    @TableField("ethical_audit_state")
    private String ethicalAuditState;

    @ApiModelProperty(value = "是否延期 ")
    @TableField("is_delay")
    private Integer isDelay;

    @ApiModelProperty(value = "延期至")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="delay_date")
    private LocalDateTime delayDate;

    @ApiModelProperty(value = "延期申请提交  ")
    @TableField("delay_data_state")
    private String delayDataState;

    @ApiModelProperty(value = "延期申请审批  ")
    @TableField("delay_audit_state")
    private String delayAuditState;

    @ApiModelProperty(value = "第几完成单位")
    @TableField("our_unit_ranking")
    private String ourUnitRanking;

    @ApiModelProperty(value = "类型")
    @TableField("biz_type")
    private String bizType;

    @ApiModelProperty(value = "大写")
    @TableField("capital_name")
    private String capitalName;

    @ApiModelProperty(value = "立项部门 ")
    @TableField("department")
    private String department;

    @ApiModelProperty(value = "院外人员")
    @TableField("out_person")
    private String outPerson;

    @ApiModelProperty(value = "年限字段")
    @TableField("prj_lifes")
    private String prjLifes;

    @ApiModelProperty(value = "预算总额")
    @TableField("budg_total_amt")
    private BigDecimal budgTotalAmt;

    @ApiModelProperty(value = "累计在途报销金额")
    @TableField("act_pay_wait_amt")
    private BigDecimal actPayWaitAmt;

    @ApiModelProperty(value = "累计已执行报销金额")
    @TableField("act_pay_amt")
    private BigDecimal actPayAmt;

    @ApiModelProperty(value = "财务编号")
    @TableField("fina_no")
    private String finaNo;

    @ApiModelProperty(value = "财务审核人 ")
    @TableField("fina_audit_user_id")
    private String finaAuditUserId;

    @ApiModelProperty(value = "财务审核日期")
    @TableField("fina_audit_date")
    private LocalDateTime finaAuditDate;

    @ApiModelProperty(value = "财务审核时间")
    @TableField("fina_audit_time")
    private LocalDateTime finaAuditTime;

    @ApiModelProperty(value = "项目得分")
    @TableField("score")
    private Integer score;

    @ApiModelProperty(value = "科室")
    @TableField("au_dept_id")
    private String auDeptId;

    @ApiModelProperty(value = "参与人")
    @TableField("partistr")
    private String partistr;

    @ApiModelProperty(value = "创建于**征集项目")
    @TableField("from_soli_proj")
    private String fromSoliProj;

    @ApiModelProperty(value = "学科")
    @TableField("discipline")
    private String discipline;

    @ApiModelProperty(value = "项目类型（研究类型）")
    @TableField("research_type")
    private String researchType;

    @ApiModelProperty(value = "领域")
    @TableField("research_field")
    private String researchField;

    @ApiModelProperty(value = "英语名称")
    @TableField("english_name")
    private String englishName;

    @ApiModelProperty(value = "级别")
    @TableField("proj_level")
    private String projLevel;

    @ApiModelProperty(value = "人遗标志")
    @TableField("is_human_genetic_res_required")
    private Integer isHumanGeneticResRequired;

    @ApiModelProperty(value = "变更标志")
    @TableField("is_changed")
    private Integer isChanged;

    @ApiModelProperty(value = "教研室编号－对应代码表　S_UNIT")
    @TableField("division_code")
    private String divisionCode;

    @ApiModelProperty(value = "负责人编号　S_PERSON")
    @TableField("head_code")
    private String headCode;

    @ApiModelProperty(value = "负责人姓名")
    @TableField("head_name")
    private String headName;

    @ApiModelProperty(value = "负责人类型")
    @TableField("head_type_code")
    private String headTypeCode;

    @ApiModelProperty(value = "项目子类")
    @TableField("proj_sub_type")
    private String projSubType;

    @ApiModelProperty(value = "学科类别代码")
    @TableField("classCode")
    private String classCode;

    @ApiModelProperty(value = "项目来源单位")
    @TableField("source_unit_name")
    private String sourceUnitName;

    @ApiModelProperty(value = "批准时间")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="authorize_date")
    private LocalDateTime authorizeDate;

    @ApiModelProperty(value = "批准号")
    @TableField("authorize_sn")
    private String authorizeSn;

    @ApiModelProperty(value = "成果形式代码")
    @TableField("product_mode_code")
    private String productModeCode;

    @ApiModelProperty(value = "所属行业编号")
    @TableField("industry_code")
    private String industryCode;

    @ApiModelProperty(value = "合作形式编号")
    @TableField("proj_cooperate_code")
    private String projCooperateCode;

    @ApiModelProperty(value = "项目组织形式编号")
    @TableField("proj_orgform_code")
    private String projOrgformCode;

    @ApiModelProperty(value = "创建人编号")
    @TableField("creator_code")
    private String creatorCode;

    @ApiModelProperty(value = "是否为子课题代码")
    @TableField("proj_dependence_type_code")
    private String projDependenceTypeCode;

    @ApiModelProperty(value = "合同类型编号")
    @TableField("contract_type_code")
    private String contractTypeCode;

    @ApiModelProperty(value = "项目密级编号")
    @TableField("proj_secrect_level_code")
    private String projSecrectLevelCode;

    @ApiModelProperty(value = "合作单位")
    @TableField("proj_orgnize_unit")
    private String projOrgnizeUnit;

    @ApiModelProperty(value = "项目来源")
    @TableField("proj_stat_source_code")
    private String projStatSourceCode;

    @ApiModelProperty(value = "合同经费")
    @TableField("authorize_fee_amt")
    private BigDecimal authorizeFeeAmt;

    @ApiModelProperty(value = "记录操作时间")
    @TableField("operate_time")
    private String operateTime;

    @ApiModelProperty(value = "电话")
    @TableField("tel")
    private String tel;

    @ApiModelProperty(value = "买方名称")
    @TableField("partner_name")
    private String partnerName;

    @ApiModelProperty(value = "买方类别编号")
    @TableField("partner_type_code")
    private String partnerTypeCode;

    @ApiModelProperty(value = "买方地址")
    @TableField("partner_address")
    private String partnerAddress;

    @ApiModelProperty(value = "买方地区")
    @TableField("partner_area")
    private String partnerArea;

    @ApiModelProperty(value = "买方邮编")
    @TableField("partner_zip_code")
    private String partnerZipCode;

    @ApiModelProperty(value = "买方电话")
    @TableField("partner_tel")
    private String partnerTel;

    @ApiModelProperty(value = "买方代表人")
    @TableField("partner_representative")
    private String partnerRepresentative;

    @ApiModelProperty(value = "支付方式编号")
    @TableField("pay_type_code")
    private String payTypeCode;

    @ApiModelProperty(value = "结项说明")
    @TableField("finish_note")
    private String finishNote;

    @ApiModelProperty(value = "自筹经费")
    @TableField("self_raised_funds")
    private BigDecimal selfRaisedFunds;

    @ApiModelProperty(value = "企业经费")
    @TableField("enterprise_funds")
    private BigDecimal enterpriseFunds;

    @ApiModelProperty(value = "档案编号")
    @TableField("file_number")
    private String fileNumber;

    @ApiModelProperty(value = "批准文号")
    @TableField("approval_number")
    private String approvalNumber;

    @ApiModelProperty(value = "验收日期  ")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="acceptance_date")
    private LocalDateTime acceptanceDate;

    @ApiModelProperty(value = "鉴定日期  ")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="appraisal_date")
    private LocalDateTime appraisalDate;

    @ApiModelProperty(value = "课题账号")
    @TableField("project_account")
    private String projectAccount;

    @ApiModelProperty(value = "专项经费")
    @TableField("special_funds")
    private String specialFunds;

    @ApiModelProperty(value = "社会经济目标")
    @TableField("socio_economic_obj_code")
    private String socioEconomicObjCode;

    @ApiModelProperty(value = "国民经济行业")
    @TableField("national_economy_industry")
    private String nationalEconomyIndustry;

    @ApiModelProperty(value = "项目分类")
    @TableField("proj_type")
    private String projType;

    @ApiModelProperty(value = "合同角色 ")
    @TableField("contract_role")
    private String contractRole;

    @ApiModelProperty(value = "验收财务审核人")
    @TableField("check_fina_audit_user_id")
    private String checkFinaAuditUserId;

    @ApiModelProperty(value = "验收财务审核日期")
    @TableField("check_fina_audit_date")
    private LocalDateTime checkFinaAuditDate;

    @ApiModelProperty(value = "验收财务审核时间")
    @TableField("check_fina_audit_time")
    private LocalDateTime checkFinaAuditTime;

    @ApiModelProperty(value = "验收财务审核状态")
    @TableField("check_fina_audit_status")
    private String checkFinaAuditStatus;

    @ApiModelProperty(value = "验收财务审核意见")
    @TableField("check_fina_auditnote")
    private String checkFinaAuditnote;

    @ApiModelProperty(value = "联系人")
    @TableField("contacts")
    private String contacts;

    @ApiModelProperty(value = "中标年度(纵向)")
    @TableField("winbid_year")
    private String winbidYear;

    @ApiModelProperty(value = "是否为转化合同（横向）")
    @TableField("is_transform_contract")
    private Integer isTransformContract;

    @ApiModelProperty(value = "第三方ID")
    @TableField("project_id")
    private String projectId;
    @ApiModelProperty(value = "首席专家")
    @TableField("is_chief_scientist")
    private Integer isChiefScientist;
    @ApiModelProperty(value = "匹配经费账号")
    @TableField("fund_account")
    private String fundAccount;
    @ApiModelProperty(value = "自筹经费账号")
    @TableField("self_financing_account")
    private String selfFinancingAccount;
    @ApiModelProperty(value = "结余经费账号")
    @TableField("surplus_account")
    private String surplusAccount;
    @ApiModelProperty(value = "国民经济行业(中类)")
    @TableField("national_economyIndustry_middle")
    private String nationalEconomyIndustryMiddle;
    @ApiModelProperty(value = "国民经济行业(小类)")
    @TableField("national_economyIndustry_small")
    private String nationalEconomyIndustrySmall;
    @ApiModelProperty(value = "课题类型")
    @TableField("topic_type")
    private String topicType;
    @ApiModelProperty(value = "企业经费账号")
    @TableField("enterprise_account")
    private String enterpriseAccount;

    @ApiModelProperty(value = "创建者编号")
    @TableField("creator")
    private String creator;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;


}
