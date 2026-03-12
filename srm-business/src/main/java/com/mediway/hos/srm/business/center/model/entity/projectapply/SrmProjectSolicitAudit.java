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
 * 项目征集权限表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmProjectSolicitAudit对象", description="项目征集权限表")
@TableName("srm_project_solicit_audit")
public class SrmProjectSolicitAudit extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "系统号")
    @TableField("sys_no")
    private String sysNo;

    @ApiModelProperty(value = "项目ID")
    @TableField("soli_project_id")
    private Long soliProjectId;

    @ApiModelProperty(value = "专业审批专家")
    @TableField("expert_list")
    private String expertList;

    @ApiModelProperty(value = "伦理审批专家")
    @TableField("ethic_expert_list")
    private String ethicExpertList;

    @ApiModelProperty(value = "项目类型")
    @TableField("proj_type")
    private String projType;

    @ApiModelProperty(value = "分配类型类型")
    @TableField("type")
    private String type;

    @ApiModelProperty(value = "第几次分配")
    @TableField("allot_count")
    private String allotCount;

    @ApiModelProperty(value = "取消标志")
    @TableField("is_cancel")
    private Integer isCancel;
}
