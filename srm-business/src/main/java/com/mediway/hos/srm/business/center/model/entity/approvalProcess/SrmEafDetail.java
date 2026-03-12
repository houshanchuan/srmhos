package com.mediway.hos.srm.business.center.model.entity.approvalProcess;

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
 * 审批流明细表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-08-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="EafDetail对象", description="审批流明细表")
@TableName("cf_srm_eaf_detail")
public class SrmEafDetail extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "主RowID")
    @TableField("eaf_main")
    private Long eafMain;

    @ApiModelProperty(value = "步骤号")
    @TableField("step_no")
    private Integer stepNo;

    @ApiModelProperty(value = "审批过程描述")
    @TableField("chk_procdesc")
    private String chkProcdesc;

    @ApiModelProperty(value = "审批授权人")
    @TableField("checker_string")
    private String checkerString;

    @ApiModelProperty(value = "科室")
    @TableField("dept")
    private String dept;

    @ApiModelProperty(value = "是否主任")
    @TableField("is_director")
    private Integer isDirector;

    @ApiModelProperty(value = "是否秘书")
    @TableField("is_secretary")
    private Integer isSecretary;

    @ApiModelProperty(value = "是否通讯作者")
    @TableField("is_corr_author")
    private Integer isCorrAuthor;

    @ApiModelProperty(value = "审核通过对应状态")
    @TableField("audit_pass_status")
    private String auditPassStatus;

    @ApiModelProperty(value = "审核不通过对应状态")
    @TableField("audit_nopass_status")
    private String auditNopassStatus;

    @ApiModelProperty(value = "是否负责人")
    @TableField("is_head")
    private Integer isHead;

    @ApiModelProperty(value = "是否导师")
    @TableField("is_mentor")
    private Integer isMentor;


}
