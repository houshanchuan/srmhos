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
 * 研究机构表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmPlatResearchUnit对象", description="研究机构表")
@TableName("srm_plat_research_unit")
public class SrmPlatResearchUnit extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ROWID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "研究机构编号")
    @TableField("code")
    private String code;

    @ApiModelProperty(value = "机构名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "挂靠单位编号")
    @TableField("dept_code")
    private String deptCode;

    @ApiModelProperty(value = "负责人 ")
    @TableField("charger_code")
    private String chargerCode;

    @ApiModelProperty(value = "学科门类编号")
    @TableField("classCode")
    private String classCode;

    @ApiModelProperty(value = "学科编号 ")
    @TableField("discipline")
    private String discipline;

    @ApiModelProperty(value = "机构类别编号 ")
    @TableField("res_unit_type")
    private String resUnitType;

    @ApiModelProperty(value = "机构级别编号 ")
    @TableField("res_unit_level")
    private String resUnitLevel;

    @ApiModelProperty(value = "是否统计　1为是")
    @TableField("is_stat")
    private Integer isStat;

    @ApiModelProperty(value = "科研秘书")
    @TableField("secretary")
    private String secretary;

    @ApiModelProperty(value = "电话号")
    @TableField("tel")
    private String tel;

    @ApiModelProperty(value = "传真")
    @TableField("fax")
    private String fax;

    @ApiModelProperty(value = "地址")
    @TableField("addr")
    private String addr;

    @ApiModelProperty(value = "邮编")
    @TableField("postcode")
    private String postcode;

    @ApiModelProperty(value = "Email")
    @TableField("email")
    private String email;

    @ApiModelProperty(value = "网站地址")
    @TableField("website")
    private String website;

    @ApiModelProperty(value = "简介")
    @TableField("intro")
    private String intro;

    @ApiModelProperty(value = "机构性质编号 ")
    @TableField("kind")
    private String kind;

    @ApiModelProperty(value = "组织形式（科技统计字段）")
    @TableField("form")
    private String form;

    @ApiModelProperty(value = "是否实体机构")
    @TableField("is_entity")
    private Integer isEntity;

    @ApiModelProperty(value = "附件编号　")
    @TableField("file_ids")
    private String fileIds;

    @ApiModelProperty(value = "机构类型（社科统计） ")
    @TableField("soc_resch_unit_type")
    private String socReschUnitType;

    @ApiModelProperty(value = "操作时间")
    @TableField("operate_time")
    private LocalDateTime operateTime;

    @ApiModelProperty(value = "组成类型 ")
    @TableField("org_form")
    private String orgForm;

    @ApiModelProperty(value = "国民经济行业")
    @TableField("na_ec_industry")
    private String naEcIndustry;

    @ApiModelProperty(value = "国民经济行业（中类）")
    @TableField("na_ec_industry_mid")
    private String naEcIndustryMid;

    @ApiModelProperty(value = "二级学科")
    @TableField("discipline_two")
    private String disciplineTwo;

    @ApiModelProperty(value = "创建人Id")
    @TableField("creator")
    private String creator;

    @ApiModelProperty(value = "创建人姓名")
    @TableField("creator_name")
    private String creatorName;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_date")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "赞助单位 ")
    @TableField("sponsor_unit")
    private String sponsorUnit;

    @ApiModelProperty(value = "批文号")
    @TableField("approval_no")
    private String approvalNo;

    @ApiModelProperty(value = "批准单位 ")
    @TableField("approval_unit")
    private String approvalUnit;

    @ApiModelProperty(value = "批准人姓名")
    @TableField("approver_name")
    private String approverName;

    @ApiModelProperty(value = "批准日期")
    @TableField("approval_date")
    private LocalDateTime approvalDate;

    @ApiModelProperty(value = "平台状态")
    @TableField("_status")
    private String status;

    @ApiModelProperty(value = "资金来源")
    @TableField("fund_source")
    private String fundSource;

    @ApiModelProperty(value = "绩效申报日")
    @TableField("kpi_date")
    private String kpiDate;

    @ApiModelProperty(value = "绩效期间（月）")
    @TableField("kpi_period")
    private String kpiPeriod;


}
