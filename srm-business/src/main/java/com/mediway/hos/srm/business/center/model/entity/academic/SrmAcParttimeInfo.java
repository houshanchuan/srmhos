package com.mediway.hos.srm.business.center.model.entity.academic;

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
 * 兼职信息表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmAcParttimeInfo对象", description="兼职信息表")
@TableName("srm_ac_parttime_info")
public class SrmAcParttimeInfo extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "人员RowID  ")
    @TableField("user_id")
    private String userId;

    @ApiModelProperty(value = "科室RowID")
    @TableField("dept_id")
    private String deptId;

    @ApiModelProperty(value = "学会  ")
    @TableField("committee")
    private String committee;

    @ApiModelProperty(value = "兼职职位")
    @TableField("position")
    private String position;

    @ApiModelProperty(value = "年度")
    @TableField("year")
    private String year;

    @ApiModelProperty(value = "兼职起始日期")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="start_date")
    private LocalDateTime startDate;

    @ApiModelProperty(value = "兼职结束日期")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="end_date")
    private LocalDateTime endDate;

    @ApiModelProperty(value = "提交人")
    @TableField("sub_user_id")
    private String subUserId;

    @ApiModelProperty(value = "提交日期")
    @TableField("sub_date")
    private LocalDateTime subDate;

    @ApiModelProperty(value = "提交标志")
    @TableField("data_status")
    private Integer dataStatus;

    @ApiModelProperty(value = "系统模块号")
    @TableField("sys_no")
    private String sysNo;

    @ApiModelProperty(value = "兼职分会名称")
    @TableField("branch")
    private String branch;

    @ApiModelProperty(value = "审核状态")
    @TableField("res_audit")
    private String resAudit;

    @ApiModelProperty(value = "审核说明")
    @TableField("res_desc")
    private String resDesc;

    @ApiModelProperty(value = "审核人")
    @TableField("audit_user_id")
    private String auditUserId;

    @ApiModelProperty(value = "审核时间")
    @TableField("audit_date")
    private LocalDateTime auditDate;

    @ApiModelProperty(value = "兼职级别")
    @TableField("committee_type")
    private String committeeType;

    @ApiModelProperty(value = "类型")
    @TableField("biz_type")
    private String bizType;

    @ApiModelProperty(value = "学会分会（专业委员会）")
    @TableField("committee_branch")
    private String committeeBranch;

    @ApiModelProperty(value = "学组 ")
    @TableField("committee_sub_branch")
    private String committeeSubBranch;

    @ApiModelProperty(value = "兼职类型")
    @TableField("parttime_type")
    private String parttimeType;

    @ApiModelProperty(value = "兼职状态")
    @TableField("state")
    private String state;

    @ApiModelProperty(value = "兼职申请表ID")
    @TableField("parttime_apply")
    private String parttimeApply;

    @ApiModelProperty(value = "创建人ID")
    @TableField("creator_id")
    private Long creatorId;
    @ApiModelProperty(value = "创建时间")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="create_time")
    private LocalDateTime createTime;

}
