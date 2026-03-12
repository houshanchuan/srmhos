package com.mediway.hos.srm.business.center.model.entity.paper;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import com.mediway.hos.srm.business.base.model.entity.BasePO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 论文投稿
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmPaperSubmissionApply对象", description="论文投稿")
@TableName("srm_paper_submission_apply")
public class SrmPaperSubmissionApply extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "系统号")
    @TableField("sys_no")
    private String sysNo;

    @ApiModelProperty(value = "类型")
    @TableField("biz_type")
    private String bizType;

    @ApiModelProperty(value = "论文名称")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "归属科室")
    @TableField("dept_id")
    private String deptId;

    @ApiModelProperty(value = "期刊类型")
    @TableField("record_type")
    private String recordType;

    @ApiModelProperty(value = "期刊")
    @TableField("journal")
    private String journal;

    @ApiModelProperty(value = "期刊名称")
    @TableField("journal_name")
    private String journalName;

    @ApiModelProperty(value = "类型")
    @TableField("scope_type")
    private String scopeType;

    @ApiModelProperty(value = "创建人id")
    @TableField("sub_user_id")
    private String subUserId;

    @ApiModelProperty(value = "创建人code")
    @TableField("sub_user_code")
    private String subUserCode;

    @ApiModelProperty(value = "创建人姓名")
    @TableField("sub_user_name")
    private String subUserName;

    @ApiModelProperty(value = "申请日期")
    @TableField("sub_date")
    private LocalDateTime subDate;

    @ApiModelProperty(value = "申请时间")
    @TableField("sub_time")
    private LocalDateTime subTime;

    @ApiModelProperty(value = "提交状态")
    @TableField("data_status")
    private Integer dataStatus;

    @ApiModelProperty(value = "审核状态")
    @TableField("check_status")
    private String checkStatus;

    @ApiModelProperty(value = "最后操作时间")
    @TableField("operate_time")
    private LocalDateTime operateTime;

    @ApiModelProperty(value = "内容")
    @TableField("content")
    private String content;

    @ApiModelProperty(value = "是否一稿多投")
    @TableField("is_multi_contribution")
    private Integer isMultiContribution;

    @ApiModelProperty(value = "是否保密")
    @TableField("is_keep_secret")
    private Integer isKeepSecret;

    @ApiModelProperty(value = "论文依附的项目")
    @TableField("proj_id")
    private String projId;

    @ApiModelProperty(value = "出版社ID")
    @TableField("press")
    private String press;

    @ApiModelProperty(value = "投稿涵序列号")
    @TableField("serial_no")
    private String serialNo;

    @ApiModelProperty(value = "论文类别")
    @TableField("thesis_type")
    private String thesisType;

    @ApiModelProperty(value = "语言")
    @TableField("language")
    private String language;

    @ApiModelProperty(value = "投稿日期")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="contribute_date")
    private LocalDateTime contributeDate;

    @ApiModelProperty(value = "学科门类")
    @TableField("classCode")
    private String classCode;

    @ApiModelProperty(value = "学科")
    @TableField("discipline")
    private String discipline;

    @ApiModelProperty(value = "研究领域")
    @TableField("research_field")
    private String researchField;

    @ApiModelProperty(value = "发表单位")
    @TableField("pub_unit_name")
    private String pubUnitName;

    @ApiModelProperty(value = "论文年度序号")
    @TableField("all_code")
    private String allCode;

    @ApiModelProperty(value = "第一作者")
    @TableField("first_author_id")
    private String firstAuthorId;

    @ApiModelProperty(value = "第一作者姓名")
    @TableField("first_author_name")
    private String firstAuthorName;

    @ApiModelProperty(value = "第一作者编号")
    @TableField("first_author_code")
    private String firstAuthorCode;

    @ApiModelProperty(value = "第一作者科室")
    @TableField("first_author_dept_id")
    private String firstAuthorDeptId;

    @ApiModelProperty(value = "第一作者类型")
    @TableField("first_author_type")
    private String firstAuthorType;

    @ApiModelProperty(value = "第一作者职称")
    @TableField("first_author_title")
    private String firstAuthorTitle;

    @ApiModelProperty(value = "个人投稿序号")
    @TableField("person_serialno")
    private String personSerialno;

    @ApiModelProperty(value = "是否毕业论文")
    @TableField("is_graduate")
    private Integer isGraduate;

    @ApiModelProperty(value = "导师1")
    @TableField("mentor1")
    private String mentor1;

    @ApiModelProperty(value = "两年内")
    @TableField("is_in_two_years")
    private Integer isInTwoYears;

    @ApiModelProperty(value = "导师2")
    @TableField("mentor2")
    private String mentor2;

    @ApiModelProperty(value = "并列第一作者")
    @TableField("tfauthor")
    private String tfauthor;

    @ApiModelProperty(value = "并列第一作者科室")
    @TableField("tfauthor_dept_id")
    private String tfauthorDeptId;

    @ApiModelProperty(value = "通讯作者")
    @TableField("corr_author_id")
    private String corrAuthorId;

    @ApiModelProperty(value = "通讯作者姓名")
    @TableField("corr_author_name")
    private String corrAuthorName;

    @ApiModelProperty(value = "通讯作者ID")
    @TableField("corr_author_code")
    private String corrAuthorCode;

    @ApiModelProperty(value = "通讯作者类型")
    @TableField("corr_author_type")
    private String corrAuthorType;

    @ApiModelProperty(value = "通讯作者职称ID")
    @TableField("corr_author_title")
    private String corrAuthorTitle;

    @ApiModelProperty(value = "通讯作者科室")
    @TableField("corr_author_dept_id")
    private String corrAuthorDeptId;

    @ApiModelProperty(value = "并列通讯作者")
    @TableField("tcauthor")
    private String tcauthor;

    @ApiModelProperty(value = "并列通讯作者科室")
    @TableField("tcauthor_dept_id")
    private String tcauthorDeptId;

    @ApiModelProperty(value = "转论文库标志")
    @TableField("is_contributed")
    private Integer isContributed;

    @ApiModelProperty(value = "正式论文ID")
    @TableField("reg_paper_id")
    private String regPaperId;

    @ApiModelProperty(value = "是否报销费用")
    @TableField("is_reimburse")
    private Integer isReimburse;

    @ApiModelProperty(value = "报销途径")
    @TableField("reimburse_way")
    private String reimburseWay;

    @ApiModelProperty(value = "项目代码")
    @TableField("project_code")
    private String projectCode;

    @ApiModelProperty(value = "奖励作者类型")
    @TableField("awardee_type")
    private String awardeeType;

    @ApiModelProperty(value = "工号")
    @TableField("awardee_account")
    private String awardeeAccount;

    @ApiModelProperty(value = "身份证号")
    @TableField("awardee_id_no")
    private String awardeeIdNo;

    @ApiModelProperty(value = "银行名称")
    @TableField("awardee_bank")
    private String awardeeBank;

    @ApiModelProperty(value = "银行账号")
    @TableField("awardee_bank_account")
    private String awardeeBankAccount;

    @ApiModelProperty(value = "联系电话")
    @TableField("awardee_contact_tel")
    private String awardeeContactTel;

    @ApiModelProperty(value = "附件文件ID")
    @TableField("file_ids")
    private String fileIds;

    @ApiModelProperty(value = "备注")
    @TableField("note")
    private String note;

    @ApiModelProperty(value = "课题组长")
    @TableField("proj_author")
    private String projAuthor;

    @ApiModelProperty(value = "创建者Id")
    @TableField("creator")
    private String creator;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;
}
