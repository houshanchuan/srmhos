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
 * 专利申报
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmPatentApply对象", description="专利申报")
@TableName("srm_patent_apply")
public class SrmPatentApply extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "申报批次")
    @TableField("apply_info_id")
    private Long applyInfoId;

    @ApiModelProperty(value = "名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "专利类型")
    @TableField("patent_type")
    private String patentType;

    @ApiModelProperty(value = "所属科室")
    @TableField("dept_id")
    private String deptId;

    @ApiModelProperty(value = "年度")
    @TableField("year")
    private String year;

    @ApiModelProperty(value = "专利权人")
    @TableField("patentee")
    private String patentee;

    @ApiModelProperty(value = "专利申请时间")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="app_date")
    private LocalDateTime appDate;

    @ApiModelProperty(value = "创建日期")
    @TableField("sub_date")
    private LocalDateTime subDate;

    @ApiModelProperty(value = "创建时间")
    @TableField("sub_time")
    private LocalDateTime subTime;

    @ApiModelProperty(value = "数据状态")
    @TableField("data_status")
    private Integer dataStatus;

    @ApiModelProperty(value = "系统模块号")
    @TableField("sys_no")
    private String sysNo;

    @ApiModelProperty(value = "申请人")
    @TableField("sub_user_id")
    private String subUserId;

    @ApiModelProperty(value = "申请人科室")
    @TableField("sub_user_dept_id")
    private String subUserDeptId;

    @ApiModelProperty(value = "联系方式")
    @TableField("phone")
    private String phone;

    @ApiModelProperty(value = "联系方式")
    @TableField("email")
    private String email;

    @ApiModelProperty(value = "是否已获批")
    @TableField("is_approved")
    private Integer isApproved;

    @ApiModelProperty(value = "获批日期")
    @TableField("approved_date")
    private String approvedDate;

    @ApiModelProperty(value = "技术领域")
    @TableField("tech_fields")
    private String techFields;

    @ApiModelProperty(value = "关联项目")
    @TableField("rela_item_name")
    private String relaItemName;

    @ApiModelProperty(value = "背景技术")
    @TableField("tech_based")
    private String techBased;

    @ApiModelProperty(value = "发明目的")
    @TableField("purpose")
    private String purpose;

    @ApiModelProperty(value = "发明内容")
    @TableField("content")
    private String content;

    @ApiModelProperty(value = "发明效果")
    @TableField("effect")
    private String effect;

    @ApiModelProperty(value = "发明摘要")
    @TableField("digest")
    private String digest;

    @ApiModelProperty(value = "已登记")
    @TableField("is_registered")
    private Integer isRegistered;

    @ApiModelProperty(value = "申请号")
    @TableField("apply_code")
    private String applyCode;

    @ApiModelProperty(value = "状态")
    @TableField("patent_state")
    private String patentState;

    @ApiModelProperty(value = "专利ID")
    @TableField("patent_id")
    private String patentId;

    @ApiModelProperty(value = "文件")
    @TableField("file_ids")
    private String fileIds;

    @ApiModelProperty(value = "备注")
    @TableField("note")
    private String note;

    @ApiModelProperty(value = "单位排序")
    @TableField("unit_ranking")
    private String unitRanking;

    @ApiModelProperty(value = "第一作者姓名")
    @TableField("fauthor_name")
    private String fauthorName;

    @ApiModelProperty(value = "第一作者职称")
    @TableField("fauthor_title")
    private String fauthorTitle;

    @ApiModelProperty(value = "第一作者类型")
    @TableField("fauthor_type")
    private String fauthorType;

    @ApiModelProperty(value = "第一作者性别")
    @TableField("fauthor_sex")
    private String fauthorSex;

    @ApiModelProperty(value = "第一作者学历")
    @TableField("fauthor_edu_level")
    private String fauthorEduLevel;

    @ApiModelProperty(value = "第一作者学位")
    @TableField("fauthor_edu_degree")
    private String fauthorEduDegree;

    @ApiModelProperty(value = "第一作者代码")
    @TableField("fauthor_code")
    private String fauthorCode;

    @ApiModelProperty(value = "审核状态")
    @TableField("check_status")
    private String checkStatus;

    @ApiModelProperty(value = "内部第一作者ID")
    @TableField("in_fauthor_code")
    private String inFauthorCode;

    @ApiModelProperty(value = "创建人姓名")
    @TableField("creator_name")
    private String creatorName;

    @ApiModelProperty(value = "操作时间")
    @TableField("operate_time")
    private LocalDateTime operateTime;

    @ApiModelProperty(value = "代理机构")
    @TableField("agency_unit")
    private String agencyUnit;

    @ApiModelProperty(value = "代理费用来源")
    @TableField("agency_fee_source")
    private String agencyFeeSource;
    @ApiModelProperty(value = "创建者ID")
    @TableField("creator")
    private String creator;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

}
