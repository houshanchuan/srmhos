package com.mediway.hos.srm.business.center.model.entity.baseData;

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
 * 人类遗传资源备案信息表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmProjHumanGeneResRecord对象", description="人类遗传资源备案信息表")
@TableName("srm_proj_human_gene_res_record")
public class SrmProjHumanGeneResRecord extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ROWID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "备案号")
    @TableField("record_no")
    private String recordNo;

    @ApiModelProperty(value = "申报申请DR")
    @TableField("res_req_id")
    private String resReqId;

    @ApiModelProperty(value = "备案人")
    @TableField("rec_user_id")
    private String recUserId;

    @ApiModelProperty(value = "备案日期")
    @TableField("rec_date")
    private LocalDateTime recDate;

    @ApiModelProperty(value = "备案时间")
    @TableField("rec_time")
    private LocalDateTime recTime;

    @ApiModelProperty(value = "提交状态")
    @TableField("data_status")
    private Integer dataStatus;

    @ApiModelProperty(value = "审核状态")
    @TableField("chk_status")
    private String chkStatus;

    @ApiModelProperty(value = "审核人")
    @TableField("chk_user_id")
    private String chkUserId;

    @ApiModelProperty(value = "审核日期")
    @TableField("chk_date")
    private LocalDateTime chkDate;

    @ApiModelProperty(value = "审核时间")
    @TableField("chk_time")
    private LocalDateTime chkTime;

    @ApiModelProperty(value = "备注")
    @TableField("remark")
    private String remark;

    @ApiModelProperty(value = "上报标志")
    @TableField("report_up_needed")
    private String reportUpNeeded;

    @ApiModelProperty(value = "系统号DR")
    @TableField("sys_no")
    private String sysNo;

    @ApiModelProperty(value = "提交人")
    @TableField("sub_user_id")
    private String subUserId;

    @ApiModelProperty(value = "提交日期")
    @TableField("sub_date")
    private LocalDateTime subDate;

    @ApiModelProperty(value = "提交时间")
    @TableField("sub_time")
    private LocalDateTime subTime;


}
