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
 * 兼职申请表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmAcParttimeApply对象", description="兼职申请表")
@TableName("srm_ac_parttime_apply")
public class SrmAcParttimeApply extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ROWID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "人员RowID")
    @TableField("user_id")
    private String userId;

    @ApiModelProperty(value = "科室RowID")
    @TableField("dept_id")
    private String deptId;

    @ApiModelProperty(value = "学会")
    @TableField("committee")
    private String committee;

    @ApiModelProperty(value = "兼职职位")
    @TableField("position")
    private String position;

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

    @ApiModelProperty(value = "兼职分会名称 ")
    @TableField("branch")
    private String branch;

    @ApiModelProperty(value = "审核状态")
    @TableField("audit_status")
    private String auditStatus;

    @ApiModelProperty(value = "审核说明")
    @TableField("audit_desc")
    private String auditDesc;

    @ApiModelProperty(value = "审核人")
    @TableField("audit_user_id")
    private String auditUserId;

    @ApiModelProperty(value = "审核时间")
    @TableField("audit_date")
    private LocalDateTime auditDate;

    @ApiModelProperty(value = "学会分会")
    @TableField("committee_branch")
    private Integer committeeBranch;

    @ApiModelProperty(value = "兼职类型")
    @TableField("part_time_type")
    private String partTimeType;

    @ApiModelProperty(value = "年度")
    @TableField("year")
    private String year;

    @ApiModelProperty(value = "创建人")
    @TableField("create_user_id")
    private String createUserId;

    @ApiModelProperty(value = "创建日期")
    @TableField("create_date")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "提交时间")
    @TableField("submit_time")
    private LocalDateTime submitTime;


}
