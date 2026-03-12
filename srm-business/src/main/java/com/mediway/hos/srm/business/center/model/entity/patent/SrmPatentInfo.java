package com.mediway.hos.srm.business.center.model.entity.patent;

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
 * 专利信息表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmPatentInfo对象", description="专利信息表")
@TableName("srm_patent_info")
public class SrmPatentInfo extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "系统模块号")
    @TableField("sys_no")
    private String sysNo;

    @ApiModelProperty(value = "业务类型")
    @TableField("biz_type")
    private String bizType;

    @ApiModelProperty(value = "名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "专利类别")
    @TableField("patent_type")
    private String patentType;
    @ApiModelProperty(value = "专利权人")
    @TableField("patentee")
    private String patentee;
    @ApiModelProperty(value = "科室")
    @TableField("dept_id")
    private String deptId;

    @ApiModelProperty(value = "年度")
    @TableField("year")
    private String year;

    @ApiModelProperty(value = "专利号")
    @TableField("patent_no")
    private String patentNo;

    @ApiModelProperty(value = "证书号")
    @TableField("certificate_no")
    private String certificateNo;

    @ApiModelProperty(value = "专利申请日期")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="apply_date")
    private LocalDateTime applyDate;

    @ApiModelProperty(value = "申请号")
    @TableField("apply_no")
    private String applyNo;

    @ApiModelProperty(value = "公布日期")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="ann_date")
    private LocalDateTime annDate;

    @ApiModelProperty(value = "授权公告号")
    @TableField("ann_no")
    private String annNo;

    @ApiModelProperty(value = "提交人")
    @TableField("sub_user_id")
    private String subUserId;

    @ApiModelProperty(value = "提交日期")
    @TableField("sub_date")
    private LocalDateTime subDate;

    @ApiModelProperty(value = "提交状态")
    @TableField("data_status")
    private Integer dataStatus;

    @ApiModelProperty(value = "登记日期")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="register_date")
    private LocalDateTime registerDate;

    @ApiModelProperty(value = "公布单位")
    @TableField("ann_organization")
    private String annOrganization;

    @ApiModelProperty(value = "计算得分")
    @TableField("score")
    private Integer score;

    @ApiModelProperty(value = "本院为第几完成单位")
    @TableField("our_unit_ranking")
    private String ourUnitRanking;

    @ApiModelProperty(value = "领域")
    @TableField("research_field")
    private String researchField;

    @ApiModelProperty(value = "关键词")
    @TableField("key_words")
    private String keyWords;

    @ApiModelProperty(value = "专利所在国")
    @TableField("patent_country")
    private String patentCountry;

    @ApiModelProperty(value = "教研室")
    @TableField("division")
    private String division;

    @ApiModelProperty(value = "有效范围")
    @TableField("scope")
    private String scope;

    @ApiModelProperty(value = "专利状态编号")
    @TableField("state")
    private String state;

    @ApiModelProperty(value = "审核状态")
    @TableField("check_status")
    private String checkStatus;

    @ApiModelProperty(value = "备注")
    @TableField("note")
    private String note;

    @ApiModelProperty(value = "作者人数")
    @TableField("author_numbers")
    private Integer authorNumbers;

    @ApiModelProperty(value = "是否为职务专利")
    @TableField("is_duty")
    private Integer isDuty;

    @ApiModelProperty(value = "医院署名")
    @TableField("sign_type")
    private String signType;

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

    @ApiModelProperty(value = "院内第一作者")
    @TableField("in_first_author_id")
    private String inFirstAuthorId;

    @ApiModelProperty(value = "院内第一作者编号")
    @TableField("in_first_author_code")
    private String inFirstAuthorCode;

    @ApiModelProperty(value = "院内第一作者最后学历")
    @TableField("in_first_author_edu_level")
    private String inFirstAuthorEduLevel;

    @ApiModelProperty(value = "院内第一作者最后学位")
    @TableField("in_first_author_edu_degree")
    private String inFirstAuthorEduDegree;

    @ApiModelProperty(value = "操作时间")
    @TableField("operate_time")
    private String operateTime;

    @ApiModelProperty(value = "附件文件ID")
    @TableField("file_ids")
    private String fileIds;

    @ApiModelProperty(value = "PCT专利标志")
    @TableField("is_pct")
    private Integer isPct;

    @ApiModelProperty(value = "PCT专利申请号")
    @TableField("pct_code")
    private String pctCode;

    @ApiModelProperty(value = "PCT专利名称")
    @TableField("pct_name")
    private String pctName;

    @ApiModelProperty(value = "PCT专利申请日期")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="pct_date")
    private LocalDateTime pctDate;

    @ApiModelProperty(value = "PCT专利优先权日期")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="pct_priority_date")
    private String pctPriorityDate;

    @ApiModelProperty(value = "PCT专利进入国")
    @TableField("pct_enter_country")
    private String pctEnterCountry;

    @ApiModelProperty(value = "申请信息")
    @TableField("apply_info")
    private String applyInfo;

    @ApiModelProperty(value = "合作类型")
    @TableField("cooperation_type")
    private String cooperationType;

    @ApiModelProperty(value = "有效性标志")
    @TableField("is_valid")
    private Integer isValid;

    @ApiModelProperty(value = "结束原因")
    @TableField("end_reason")
    private String endReason;

    @ApiModelProperty(value = "专利申报ID")
    @TableField("apply_id")
    private String applyId;

    @ApiModelProperty(value = "序列号")
    @TableField("serial_no")
    private String serialNo;
    @ApiModelProperty(value = "创建者ID")
    @TableField("creator")
    private String creator;
    @ApiModelProperty(value = "创建人编号")
    @TableField("creator_code")
    private String creatorCode;

    @ApiModelProperty(value = "创建人姓名")
    @TableField("creator_name")
    private String creatorName;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;


}
