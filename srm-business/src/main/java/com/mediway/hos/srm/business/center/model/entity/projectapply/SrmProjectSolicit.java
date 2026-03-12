package com.mediway.hos.srm.business.center.model.entity.projectapply;

import com.baomidou.mybatisplus.annotation.*;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;
import com.mediway.hos.srm.business.base.model.entity.BasePO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 项目征集(申报)信息表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmProjectSolicit对象", description="项目征集(申报)信息表")
@TableName("srm_project_solicit")
public class SrmProjectSolicit extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "年度")
    @TableField("year")
    private String year;

    @ApiModelProperty(value = "项目分类")
    @TableField("proj_type")
    private String projType;

    @ApiModelProperty(value = "项目名称")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "是否伦理审批")
    @TableField("is_ethic")
    private Integer isEthic;

    @ApiModelProperty(value = "专业审批专家")
    @TableField("expert_list")
    private String expertList;

    @ApiModelProperty(value = "伦理审批专家")
    @TableField("ethic_expert_list")
    private String ethicExpertList;

    @ApiModelProperty(value = "提交人")
    @TableField("sub_user_id")
    private String subUserId;

    @ApiModelProperty(value = "提交时间")
    @TableField("sub_date")
    private LocalDateTime subDate;

    @ApiModelProperty(value = "数据状态")
    @TableField("data_status")
    private Integer dataStatus;

    @ApiModelProperty(value = "审批状态")
    @TableField("audit_status")
    private String auditStatus;
    @ApiModelProperty(value = "科主任审批状态")
    @TableField("header_audit_status")
    private String headerAuditStatus;
    @ApiModelProperty(value = "审批结果")
    @TableField("check_result")
    private String checkResult;

    @ApiModelProperty(value = "审批时间")
    @TableField("audit_date")
    private String auditDate;

    @ApiModelProperty(value = "审批说明")
    @TableField("check_desc")
    private String checkDesc;

    @ApiModelProperty(value = "系统号")
    @TableField("sys_no")
    private String sysNo;

    @ApiModelProperty(value = "院外专业评审结果")
    @TableField("out_expert_result")
    private String outExpertResult;

    @ApiModelProperty(value = "伦理委员会结果")
    @TableField("ethic_result")
    private String ethicResult;

    @ApiModelProperty(value = "预审审核人")
    @TableField("pre_auditor")
    private String preAuditor;

    @ApiModelProperty(value = "预审审核结果")
    @TableField("pre_audit_state")
    private String preAuditState;

    @ApiModelProperty(value = "预审审核说明")
    @TableField("pre_audit_desc")
    private String preAuditDesc;

    @ApiModelProperty(value = "预审审核时间")
    @TableField("pre_audit_date")
    private LocalDateTime preAuditDate;

    @ApiModelProperty(value = "申请人电话")
    @TableField("phone")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty(value = "人类遗传资源标志")
    @TableField("is_human_genetic_res_required")
    private Integer isHumanGeneticResRequired;

    @ApiModelProperty(value = "负责人")
    @TableField("head")
    private String head;

    @ApiModelProperty(value = "联系人")
    @TableField("contacts")
    private String contacts;

    @ApiModelProperty(value = "研究类别")
    @TableField("resch_category")
    private String reschCategory;

    @ApiModelProperty(value = "适应症")
    @TableField("indic_range")
    private String indicRange;

    @ApiModelProperty(value = "性质")
    @TableField("participation_type")
    private String participationType;

    @ApiModelProperty(value = "申办方")
    @TableField("sub_dept")
    private String subDept;

    @ApiModelProperty(value = "组长单位")
    @TableField("leader_dept")
    private String leaderDept;

    @ApiModelProperty(value = "参与单位")
    @TableField("involved_dept")
    private String involvedDept;

    @ApiModelProperty(value = "经费")
    @TableField("funds")
    private String funds;

    @ApiModelProperty(value = "学科")
    @TableField("discipline")
    private String discipline;

    @ApiModelProperty(value = "领域")
    @TableField("research_field")
    private String researchField;

    @ApiModelProperty(value = "财务审核结果")
    @TableField("fina_chk_result")
    private String finaChkResult;

    @ApiModelProperty(value = "财务审核意见")
    @TableField("fina_chk_desc")
    private String finaChkDesc;

    @ApiModelProperty(value = "财务审核人")
    @TableField("fina_chk_user_id")
    private String finaChkUserId;

    @ApiModelProperty(value = "财务审核时间")
    @TableField("fina_chk_date_time")
    private LocalDateTime finaChkDateTime;

    @ApiModelProperty(value = "申报批次编号　")
    @TableField("project_apply_info")
    private String projectApplyInfo;

    @ApiModelProperty(value = "所属教研室编号")
    @TableField("division")
    private String division;

    @ApiModelProperty(value = "项目性质编号　")
    @TableField("project_class")
    private String projectClass;

    @ApiModelProperty(value = "创建者姓名")
    @TableField("creator_name")
    private String creatorName;

    @ApiModelProperty(value = "申请人学历代码")
    @TableField("applier_edu_level")
    private String applierEduLevel;

    @ApiModelProperty(value = "申请人职称代码")
    @TableField("applier_title")
    private String applierTitle;

    @ApiModelProperty(value = "计划完成日期")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="planed_end_date")
    private LocalDateTime planedEndDate;

    @ApiModelProperty(value = "前期研究情况")
    @TableField("early_research_info")
    private String earlyResearchInfo;

    @ApiModelProperty(value = "立项状态")
    @TableField("approval_status")
    private String approvalStatus;

    @ApiModelProperty(value = "项目来源单位")
    @TableField("project_source_unit")
    private String projectSourceUnit;

    @ApiModelProperty(value = "关键词")
    @TableField("project_keyword")
    private String projectKeyword;

    @ApiModelProperty(value = "申报类型")
    @TableField("project_apply_type")
    private String projectApplyType;

    @ApiModelProperty(value = "第一申请部门类型")
    @TableField("first_unit_type")
    private String firstUnitType;

    @ApiModelProperty(value = "文件IDS")
    @TableField("file_ids")
    private String fileIds;

    @ApiModelProperty(value = "平均")
    @TableField("avg_score")
    private BigDecimal avgScore;

    @ApiModelProperty(value = "赞成数")
    @TableField("agree_count")
    private BigDecimal agreeCount;

    @ApiModelProperty(value = "平均2")
    @TableField("avg_score2")
    private BigDecimal avgScore2;

    @ApiModelProperty(value = "赞成数2")
    @TableField("agree_count2")
    private BigDecimal agreeCount2;

    @ApiModelProperty(value = "申报项目类别")
    @TableField("apply_book_type")
    private String applyBookType;

    @ApiModelProperty(value = "学科门类")
    @TableField("classCode")
    private String classCode;

    @ApiModelProperty(value = "申请人姓名")
    @TableField("subuser_name")
    private String subuserName;

    @ApiModelProperty(value = "创建者编号")
    @TableField("creator")
    private String creator;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "申报ID")
    @TableField("apply_id")
    private Long applyId;

    @ApiModelProperty(value = "备注")
    @TableField("note")
    private String note;

    @ApiModelProperty(value = "项目组")
    @TableField("progrp")
    private String progrp;

    @ApiModelProperty(value = "排序")
    @TableField("ranking")
    private String ranking;

    @ApiModelProperty(value = "类型")
    @TableField("_type")
    private String type;


}
