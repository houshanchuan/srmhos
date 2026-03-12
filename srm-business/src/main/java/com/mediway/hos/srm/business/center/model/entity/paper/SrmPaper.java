package com.mediway.hos.srm.business.center.model.entity.paper;

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
 * 论文登记信息表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-08-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Paper对象", description="论文登记信息表")
@TableName("srm_paper")
public class SrmPaper extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "论文名称")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "英文名")
    @TableField("en_name")
    private String enName;

    @ApiModelProperty(value = "科室")
    @TableField("dept_id")
    private String deptId;

    @ApiModelProperty(value = "教研室")
    @TableField("division")
    private String division;

    @ApiModelProperty(value = "类型")
    @TableField("biz_type")
    private String bizType;

    @ApiModelProperty(value = "系统号")
    @TableField("sys_no")
    private String sysNo;

    @ApiModelProperty(value = "序号")
    @TableField("serial_no")
    private String serialNo;

    @ApiModelProperty(value = "编号")
    @TableField("paper_reg_no")
    private String paperRegNo;

    @ApiModelProperty(value = "论文类别")
    @TableField("thesis_type")
    private String thesisType;

    @ApiModelProperty(value = "语言")
    @TableField("language")
    private String language;

    @ApiModelProperty(value = "论文来源")
    @TableField("paper_source")
    private String paperSource;

    @ApiModelProperty(value = "期刊")
    @TableField("journal")
    private String journal;

    @ApiModelProperty(value = "期刊名称")
    @TableField("journal_name")
    private String journalName;

    @ApiModelProperty(value = "期刊类型")
    @TableField("journal_type")
    private String journalType;

    @ApiModelProperty(value = "期刊级别")
    @TableField("journal_level")
    private String journalLevel;

    @ApiModelProperty(value = "出版年度")
    @TableField("pub_year")
    private String pubYear;

    @ApiModelProperty(value = "出版日期")
    @TableField("publish_date")
    private String publishDate;

    @ApiModelProperty(value = "卷")
    @TableField("roll")
    private String roll;

    @ApiModelProperty(value = "期")
    @TableField("period")
    private String period;

    @ApiModelProperty(value = "起始页号")
    @TableField("start_page")
    private String startPage;

    @ApiModelProperty(value = "结束页号")
    @TableField("end_page")
    private String endPage;

    @ApiModelProperty(value = "ISSN")
    @TableField("issn")
    private String issn;

    @ApiModelProperty(value = "CN")
    @TableField("cn_no")
    private String cnNo;

    @ApiModelProperty(value = "WOS入藏号")
    @TableField("wos_accession_no")
    private String wosAccessionNo;

    @ApiModelProperty(value = "DOI")
    @TableField("doi")
    private String doi;

    @ApiModelProperty(value = "全文链接")
    @TableField("link_url")
    private String linkUrl;

    @ApiModelProperty(value = "论文期卷信息")
    @TableField("volume_info")
    private String volumeInfo;

    @ApiModelProperty(value = "文档类型")
    @TableField("doc_type")
    private String docType;

    @ApiModelProperty(value = "字数")
    @TableField("words_num")
    private BigDecimal wordsNum;

    @ApiModelProperty(value = "影响因子")
    @TableField("journal_if")
    private String journalIf;

    @ApiModelProperty(value = "影响因子5年")
    @TableField("five_year_if")
    private BigDecimal fiveYearIf;

    @ApiModelProperty(value = "是否ESI高被引")
    @TableField("is_esi_cited")
    private Integer isEsiCited;

    @ApiModelProperty(value = "版面类型")
    @TableField("page_space_type")
    private String pageSpaceType;

    @ApiModelProperty(value = "是否为译文")
    @TableField("is_translation")
    private Integer isTranslation;

    @ApiModelProperty(value = "是否管理类论文")
    @TableField("is_managing")
    private Integer isManaging;

    @ApiModelProperty(value = "是否护理类论文")
    @TableField("is_nursing")
    private Integer isNursing;

    @ApiModelProperty(value = "医院署名")
    @TableField("school_sign")
    private String schoolSign;

    @ApiModelProperty(value = "引用次数")
    @TableField("times_cited")
    private BigDecimal timesCited;

    @ApiModelProperty(value = "关键词")
    @TableField("key_words")
    private String keyWords;

    @ApiModelProperty(value = "SCI分区 (JCR)")
    @TableField("sci_partition")
    private String sciPartition;

    @ApiModelProperty(value = "中科院分区 (CAS)")
    @TableField("cas_partition")
    private String casPartition;

    @ApiModelProperty(value = "基金标注")
    @TableField("fund_label")
    private String fundLabel;

    @ApiModelProperty(value = "项目来源代码")
    @TableField("proj_source_code")
    private String projSourceCode;

    @ApiModelProperty(value = "本院为第几完成单位")
    @TableField("our_unit_ranking")
    private String ourUnitRanking;

    @ApiModelProperty(value = "作者人数")
    @TableField("number_of_authors")
    private Integer numberOfAuthors;

    @ApiModelProperty(value = "发表范围代码")
    @TableField("pub_range_code")
    private String pubRangeCode;

    @ApiModelProperty(value = "摘要")
    @TableField("digest")
    private String digest;

    @ApiModelProperty(value = "论文集出版单位")
    @TableField("pub_unit")
    private String pubUnit;

    @ApiModelProperty(value = "会议名称")
    @TableField("conf_name")
    private String confName;

    @ApiModelProperty(value = "会议地点")
    @TableField("conf_address")
    private String confAddress;

    @ApiModelProperty(value = "会议简介")
    @TableField("conf_intro")
    private String confIntro;

    @ApiModelProperty(value = "ApplyPaper DR")
    @TableField("app_paper_id")
    private String appPaperId;

    @ApiModelProperty(value = "提交人")
    @TableField("sub_user_id")
    private String subUserId;

    @ApiModelProperty(value = "提交日期")
    @TableField("sub_date")
    private LocalDateTime subDate;

    @ApiModelProperty(value = "提交时间")
    @TableField("sub_time")
    private LocalDateTime subTime;

    @ApiModelProperty(value = "提交状态")
    @TableField("data_status")
    private Integer dataStatus;

    @ApiModelProperty(value = "状态代码 ")
    @TableField("check_status")
    private String checkStatus;

    @ApiModelProperty(value = "备注")
    @TableField("remark")
    private String remark;

    @ApiModelProperty(value = "工作量计数")
    @TableField("work_count")
    private BigDecimal workCount;

    @ApiModelProperty(value = "不计数原因")
    @TableField("not_count_reason")
    private String notCountReason;

    @ApiModelProperty(value = "版面费")
    @TableField("page_charge")
    private BigDecimal pageCharge;

    @ApiModelProperty(value = "第一作者")
    @TableField("first_author_id")
    private String firstAuthorId;

    @ApiModelProperty(value = "第一作者姓名")
    @TableField("first_author_name")
    private String firstAuthorName;

    @ApiModelProperty(value = "第一作者职称")
    @TableField("first_author_title")
    private String firstAuthorTitle;

    @ApiModelProperty(value = "第一作者性别")
    @TableField("first_author_sex")
    private String firstAuthorSex;

    @ApiModelProperty(value = "第一作者类型")
    @TableField("first_author_type")
    private String firstAuthorType;

    @ApiModelProperty(value = "第一作者单位")
    @TableField("first_author_unit_id")
    private String firstAuthorUnitId;

    @ApiModelProperty(value = "第一作者科室")
    @TableField("first_author_dept_id")
    private String firstAuthorDeptId;

    @ApiModelProperty(value = "第一作者备注")
    @TableField("first_author_remark")
    private String firstAuthorRemark;

    @ApiModelProperty(value = "院内第一作者")
    @TableField("in_first_author_id")
    private String inFirstAuthorId;

    @ApiModelProperty(value = "院内第一作者排名")
    @TableField("in_first_author_ranking")
    private String inFirstAuthorRanking;

    @ApiModelProperty(value = "院内第一作者最后学历")
    @TableField("in_first_author_edu_level")
    private String inFirstAuthorEduLevel;

    @ApiModelProperty(value = "院内第一作者最后学位")
    @TableField("in_first_author_edu_degree")
    private String inFirstAuthorEduDegree;

    @ApiModelProperty(value = "并列第一作者")
    @TableField("tf_author_id")
    private String tfAuthorId;

    @ApiModelProperty(value = "并列第一作者")
    @TableField("tf_author_name")
    private String tfAuthorName;

    @ApiModelProperty(value = "并列第一作者科室")
    @TableField("tf_author_dept_id")
    private String tfAuthorDeptId;

    @ApiModelProperty(value = "并列第一作者单位")
    @TableField("tf_author_unit_id")
    private String tfAuthorUnitId;

    @ApiModelProperty(value = "通讯作者")
    @TableField("corr_author_id")
    private String corrAuthorId;

    @ApiModelProperty(value = "通讯作者姓名")
    @TableField("corr_author_name")
    private String corrAuthorName;

    @ApiModelProperty(value = "通讯作者排名")
    @TableField("corr_author_ranking")
    private String corrAuthorRanking;

    @ApiModelProperty(value = "通讯作者科室")
    @TableField("corr_author_dept_id")
    private String corrAuthorDeptId;

    @ApiModelProperty(value = "通讯作者单位")
    @TableField("corr_author_unit_id")
    private String corrAuthorUnitId;

    @ApiModelProperty(value = "通讯作者备注")
    @TableField("corr_author_remark")
    private String corrAuthorRemark;

    @ApiModelProperty(value = "通讯作者是否本院")
    @TableField("is_corr_author_our")
    private Integer isCorrAuthorOur;

    @ApiModelProperty(value = "并列通讯作者")
    @TableField("tcorr_author_id")
    private String tcorrAuthorId;

    @ApiModelProperty(value = "并列通讯作者姓名")
    @TableField("tcorr_author_name")
    private String tcorrAuthorName;

    @ApiModelProperty(value = "并列通讯作者科室")
    @TableField("tcorr_author_dept_id")
    private String tcorrAuthorDeptId;

    @ApiModelProperty(value = "并列通讯作者科室")
    @TableField("tcorr_author_unit_id")
    private String tcorrAuthorUnitId;

    @ApiModelProperty(value = "是否在读研究生")
    @TableField("is_graduate")
    private Integer isGraduate;

    @ApiModelProperty(value = "导师1")
    @TableField("mentor1")
    private String mentor1;

    @ApiModelProperty(value = "是否毕业两年内研究生")
    @TableField("is_graduated_two_years")
    private Integer isGraduatedTwoYears;

    @ApiModelProperty(value = "导师2")
    @TableField("mentor2")
    private String mentor2;

    @ApiModelProperty(value = "退稿标志")
    @TableField("is_rejection")
    private Integer isRejection;

    @ApiModelProperty(value = "改投标志")
    @TableField("is_submission_changed")
    private Integer isSubmissionChanged;

    @ApiModelProperty(value = "改投1")
    @TableField("change_to_journa1")
    private String changeToJourna1;

    @ApiModelProperty(value = "改投2")
    @TableField("change_to_journa2")
    private String changeToJourna2;

    @ApiModelProperty(value = "复印件提交标志")
    @TableField("sub_copies")
    private String subCopies;

    @ApiModelProperty(value = "电子版提交标志")
    @TableField("sub_elec_edition")
    private String subElecEdition;

    @ApiModelProperty(value = "学分登记标志")
    @TableField("is_credits_registered")
    private Integer isCreditsRegistered;

    @ApiModelProperty(value = "学科类别代码")
    @TableField("classCode")
    private String classCode;

    @ApiModelProperty(value = "学科")
    @TableField("discipline")
    private String discipline;

    @ApiModelProperty(value = "二级学科 ")
    @TableField("discipline2")
    private String discipline2;

    @ApiModelProperty(value = "三级学科 ")
    @TableField("discipline3")
    private String discipline3;

    @ApiModelProperty(value = "领域")
    @TableField("research_field")
    private String researchField;

    @ApiModelProperty(value = "操作时间")
    @TableField("operate_time")
    private LocalDateTime operateTime;

    @ApiModelProperty(value = "项目经费账号")
    @TableField("fina_no")
    private String finaNo;

    @ApiModelProperty(value = "是否报销")
    @TableField("is_reim")
    private Integer isReim;

    @ApiModelProperty(value = "报销途径")
    @TableField("reim_way")
    private String reimWay;

    @ApiModelProperty(value = "报销费用")
    @TableField("reim_fee_amt")
    private BigDecimal reimFeeAmt;

    @ApiModelProperty(value = "最终报销费用")
    @TableField("reim_fee_actual_amt")
    private BigDecimal reimFeeActualAmt;

    @ApiModelProperty(value = "版面费发票")
    @TableField("page_charge_inv_no")
    private String pageChargeInvNo;

    @ApiModelProperty(value = "被奖励人类型")
    @TableField("awardee_type")
    private String awardeeType;

    @ApiModelProperty(value = "被奖励人工号")
    @TableField("awardee_account")
    private String awardeeAccount;

    @ApiModelProperty(value = "被奖励人身份证号")
    @TableField("awardee_id_no")
    private String awardeeIdNo;

    @ApiModelProperty(value = "被奖励人银行")
    @TableField("awardee_bank")
    private String awardeeBank;

    @ApiModelProperty(value = "被奖励人银行账号")
    @TableField("awardee_bank_account")
    private String awardeeBankAccount;

    @ApiModelProperty(value = "被奖励人联系电话")
    @TableField("awardee_tel")
    private String awardeeTel;

    @ApiModelProperty(value = "奖励金额")
    @TableField("reward_amt")
    private BigDecimal rewardAmt;

    @ApiModelProperty(value = "课题组长")
    @TableField("proj_author")
    private String projAuthor;

    @ApiModelProperty(value = "币种")
    @TableField("currency")
    private String currency;


    @ApiModelProperty(value = "创建者编号")
    @TableField("creator")
    private String creator;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

}
