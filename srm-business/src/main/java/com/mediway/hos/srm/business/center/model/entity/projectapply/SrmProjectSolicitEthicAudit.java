package com.mediway.hos.srm.business.center.model.entity.projectapply;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.mediway.hos.srm.business.base.model.entity.BasePO;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 项目征集伦理审批表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmProjectSolicitEthicAudit对象", description="项目征集伦理审批表")
@TableName("srm_project_solicit_ethic_audit")
public class SrmProjectSolicitEthicAudit extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "系统模块号")
    @TableField("sys_no")
    private String sysNo;

    @ApiModelProperty(value = "项目ID")
    @TableField("soli_project_id")
    private Long soliProjectId;

    @ApiModelProperty(value = "数据状态")
    @TableField("data_status")
    private Integer dataStatus;

    @ApiModelProperty(value = "伦理审批专家")
    @TableField("ethic_expert")
    private String ethicExpert;

    @ApiModelProperty(value = "伦理审批结果")
    @TableField("ethic_chk_result")
    private String ethicChkResult;

    @ApiModelProperty(value = "伦理审批时间")
    @TableField("ethic_audit_date")
    private String ethicAuditDate;

    @ApiModelProperty(value = "审批说明")
    @TableField("ethic_audit_desc")
    private String ethicAuditDesc;

    @ApiModelProperty(value = "是否已反馈至申请人")
    @TableField("is_feedbacked")
    private Integer isFeedbacked;
    @ApiModelProperty(value = "第几次分配")
    @TableField("ethic_allot_count")
    private String ethicAllotCount;
    @ApiModelProperty(value = "取消标志")
    @TableField("is_cancel")
    private Integer isCancel;

}
