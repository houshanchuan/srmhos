package com.mediway.hos.srm.business.center.model.entity.baseData;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.mediway.hos.srm.business.base.model.entity.BasePO;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 临床研究信息补充表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmClResearchProjDetail对象", description="临床研究信息补充表")
@TableName("srm_cl_research_proj_detail")
public class SrmClResearchProjDetail extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ROWID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "项目DR")
    @TableField("proj_id")
    private String projId;

    @ApiModelProperty(value = "研究题目简写")
    @TableField("title_abbre")
    private String titleAbbre;

    @ApiModelProperty(value = "通俗名称")
    @TableField("public_name")
    private String publicName;

    @ApiModelProperty(value = "暴露因素（干预措施）是否以中医理论为指导")
    @TableField("is_guided_by_tcm")
    private Integer isGuidedByTcm;

    @ApiModelProperty(value = "是否为干细胞项目 ")
    @TableField("is_stem_cell_project")
    private Integer isStemCellProject;

    @ApiModelProperty(value = "涉及材料捐献 ")
    @TableField("is_material_donation")
    private Integer isMaterialDonation;

    @ApiModelProperty(value = "数据监察委员会（DSMB） ")
    @TableField("is_dsmb_exists")
    private Integer isDsmbExists;

    @ApiModelProperty(value = "临床研究分中心")
    @TableField("is_subcenter_exists")
    private String isSubcenterExists;

    @ApiModelProperty(value = "主要目的")
    @TableField("major_objective")
    private String majorObjective;

    @ApiModelProperty(value = "研究目的具体描述")
    @TableField("objective_detail_info")
    private String objectiveDetailInfo;

    @ApiModelProperty(value = "研究内容")
    @TableField("research_contents")
    private String researchContents;

    @ApiModelProperty(value = "价值自评价")
    @TableField("self_eval_of_value")
    private String selfEvalOfValue;

    @ApiModelProperty(value = "风险自评价")
    @TableField("self_eval_of_risk")
    private String selfEvalOfRisk;

    @ApiModelProperty(value = "价值风险比较自评价")
    @TableField("self_eval_of_value_risk_comp")
    private String selfEvalOfValueRiskComp;

    @ApiModelProperty(value = "国际疾病分类(ICD)")
    @TableField("icd")
    private String icd;

    @ApiModelProperty(value = "具体疾病或症状")
    @TableField("diseases_or_symptoms")
    private String diseasesOrSymptoms;

    @ApiModelProperty(value = "是否采用额外的检查、检验、诊断措施")
    @TableField("is_take_additional_dealing")
    private Integer isTakeAdditionalDealing;

    @ApiModelProperty(value = "研究阶段 ")
    @TableField("is_resch_phase")
    private Integer isReschPhase;

    @ApiModelProperty(value = "研究设计(分类)")
    @TableField("resch_design_type")
    private String reschDesignType;

    @ApiModelProperty(value = "受试者性别 ")
    @TableField("subject_gender")
    private String subjectGender;

    @ApiModelProperty(value = "受试者年龄最小")
    @TableField("age_min")
    private String ageMin;

    @ApiModelProperty(value = "受试者年龄最大")
    @TableField("age_max")
    private String ageMax;

    @ApiModelProperty(value = "接受健康志愿者 ")
    @TableField("is_accept_healthy")
    private Integer isAcceptHealthy;

    @ApiModelProperty(value = "涉及弱势群体 ")
    @TableField("is_involving_vulnerable_groups")
    private Integer isInvolvingVulnerableGroups;

    @ApiModelProperty(value = "弱势群体类型")
    @TableField("vulnerable_groups_type")
    private String vulnerableGroupsType;

    @ApiModelProperty(value = "纳入标准：")
    @TableField("inclusioncriteria")
    private String inclusioncriteria;

    @ApiModelProperty(value = "排除标准：")
    @TableField("exclusioncriteria")
    private String exclusioncriteria;

    @ApiModelProperty(value = "样本量")
    @TableField("sample_size")
    private String sampleSize;

    @ApiModelProperty(value = "样本量计算依据")
    @TableField("sample_size_calc_basis")
    private String sampleSizeCalcBasis;

    @ApiModelProperty(value = "预期第一例研究对象签署知情同意日期")
    @TableField("expected_date_first_sign")
    private String expectedDateFirstSign;

    @ApiModelProperty(value = "是否随机分组 ")
    @TableField("is_randomly_grouped")
    private Integer isRandomlyGrouped;

    @ApiModelProperty(value = "随机分组方法（RandomlyGroup=Y）")
    @TableField("randomly_group_method")
    private String randomlyGroupMethod;

    @ApiModelProperty(value = "随机过程（RandomlyGroup=Y,由何人用什么方法产生随机数列）")
    @TableField("randomly_process")
    private String randomlyProcess;

    @ApiModelProperty(value = "统计方法描述")
    @TableField("stat_method_desc")
    private String statMethodDesc;

    @ApiModelProperty(value = "涉及生物样本采集")
    @TableField("is_blg_sample_collection")
    private Integer isBlgSampleCollection;

    @ApiModelProperty(value = "NMPA批准日期")
    @TableField("nmpa_date")
    private LocalDateTime nmpaDate;

    @ApiModelProperty(value = "NMPA批准文号")
    @TableField("nmpa_no")
    private String nmpaNo;

    @ApiModelProperty(value = "研究预计开始日期")
    @TableField("start_date")
    private LocalDateTime startDate;

    @ApiModelProperty(value = "研究预计结束日期")
    @TableField("end_date")
    private LocalDateTime endDate;

    @ApiModelProperty(value = "研究分类(一级)")
    @TableField("category_one_level")
    private String categoryOneLevel;

    @ApiModelProperty(value = "研究分类(二级)")
    @TableField("category_two_level")
    private String categoryTwoLevel;

    @ApiModelProperty(value = "研究分类(三级)")
    @TableField("category_three_level")
    private String categoryThreeLevel;

    @ApiModelProperty(value = "研究负责人科室")
    @TableField("research_head_dept_id")
    private String researchHeadDeptId;

    @ApiModelProperty(value = "联系人通讯地址")
    @TableField("email_address")
    private String emailAddress;

    @ApiModelProperty(value = "联系人所在单位")
    @TableField("contact_unit")
    private String contactUnit;

    @ApiModelProperty(value = "盲法类型 ")
    @TableField("blind_method_type")
    private String blindMethodType;

    @ApiModelProperty(value = "揭盲或破盲原则和方法 ")
    @TableField("blind_bprinciple")
    private String blindBprinciple;

    @ApiModelProperty(value = "分配隐藏方法 ")
    @TableField("assign_hidden_method")
    private String assignHiddenMethod;

    @ApiModelProperty(value = "分配隐藏方法描述")
    @TableField("desc_of_hidden_method")
    private String descOfHiddenMethod;

    @ApiModelProperty(value = "招募状态")
    @TableField("recruit_status")
    private String recruitStatus;

    @ApiModelProperty(value = "第一例受试者入组时间")
    @TableField("fr_date")
    private LocalDateTime frDate;

    @ApiModelProperty(value = "后一例受试者出组时间")
    @TableField("lr_date")
    private LocalDateTime lrDate;

    @ApiModelProperty(value = "招募公告开始时间")
    @TableField("rs_date")
    private LocalDateTime rsDate;

    @ApiModelProperty(value = "联系人姓名")
    @TableField("contact_name")
    private String contactName;

    @ApiModelProperty(value = "联系人电话")
    @TableField("contact_phone")
    private String contactPhone;

    @ApiModelProperty(value = "联系人邮箱")
    @TableField("contact_email")
    private String contactEmail;

    @ApiModelProperty(value = "平台信息")
    @TableField("plat_info")
    private String platInfo;

    @ApiModelProperty(value = "研究数据共享声明")
    @TableField("shared_declaration")
    private String sharedDeclaration;

    @ApiModelProperty(value = "数据共享计划")
    @TableField("data_sharing_plan")
    private String dataSharingPlan;

    @ApiModelProperty(value = "共享数据获取条件")
    @TableField("data_sharing_conditions")
    private String dataSharingConditions;

    @ApiModelProperty(value = "网址")
    @TableField("website")
    private String website;

    @ApiModelProperty(value = "开试验完成后统计结果")
    @TableField("statistical_results")
    private String statisticalResults;

    @ApiModelProperty(value = "结果发布方式")
    @TableField("result_pub_method")
    private String resultPubMethod;


}
