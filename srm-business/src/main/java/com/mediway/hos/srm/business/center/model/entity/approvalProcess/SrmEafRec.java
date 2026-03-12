package com.mediway.hos.srm.business.center.model.entity.approvalProcess;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.mediway.hos.srm.business.base.model.entity.BasePO;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 审批记录
 * </p>
 *
 * @author 代码生成器
 * @since 2024-08-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="EafRec对象", description="审批记录")
@TableName("cf_srm_eaf_rec")
public class SrmEafRec extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "审批流明细ID")
    @TableField("eaf_detail_id")
    private String eafDetailId;

    @ApiModelProperty(value = "系统模块ID")
    @TableField("sys_no")
    private String sysNo;

    @ApiModelProperty(value = "记录ID")
    @TableField("check_rec_id")
    private String checkRecId;

    @ApiModelProperty(value = "步骤号")
    @TableField("step_no")
    private Integer stepNo;

    @ApiModelProperty(value = "过程描述")
    @TableField("check_proc_desc")
    private String checkProcDesc;

    @ApiModelProperty(value = "审批人")
    @TableField("checker")
    private String checker;

    @ApiModelProperty(value = "科室")
    @TableField("dept")
    private String dept;

    @ApiModelProperty(value = "审批时间")
    @TableField("check_datetime")
    private LocalDateTime checkDatetime;

    @ApiModelProperty(value = "审批结果")
    @TableField("check_result")
    private String checkResult;

    @ApiModelProperty(value = "结果描述")
    @TableField("check_desc")
    private String checkDesc;

    @ApiModelProperty(value = "是否当前步骤")
    @TableField("is_current_step")
    private Integer isCurrentStep;

    @ApiModelProperty(value = "本步骤实际审批人")
    @TableField("check_user")
    private String checkUser;

    @ApiModelProperty(value = "审批用户串(间隔)")
    @TableField("checker_string")
    private String checkerString;


}
