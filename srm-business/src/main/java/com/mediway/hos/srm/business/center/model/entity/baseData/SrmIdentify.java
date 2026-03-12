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
 * 科研鉴定表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmIdentify对象", description="科研鉴定表")
@TableName("srm_identify")
public class SrmIdentify extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "年度")
    @TableField("year")
    private String year;

    @ApiModelProperty(value = "名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "参与人员")
    @TableField("participants")
    private String participants;

    @ApiModelProperty(value = "鉴定级别")
    @TableField("identify_level")
    private String identifyLevel;

    @ApiModelProperty(value = "鉴定单位")
    @TableField("identify_unit")
    private String identifyUnit;

    @ApiModelProperty(value = "鉴定时间")
    @TableField("identify_date")
    private LocalDateTime identifyDate;

    @ApiModelProperty(value = "本院单位位次")
    @TableField("our_unit_ranking")
    private String ourUnitRanking;

    @ApiModelProperty(value = "申请人")
    @TableField("sub_user_id")
    private String subUserId;

    @ApiModelProperty(value = "申请日期")
    @TableField("sub_date")
    private LocalDateTime subDate;

    @ApiModelProperty(value = "数据状态")
    @TableField("data_status")
    private Integer dataStatus;

    @ApiModelProperty(value = "审核状态")
    @TableField("res_audit")
    private String resAudit;

    @ApiModelProperty(value = "审核说明")
    @TableField("resdesc")
    private String resdesc;

    @ApiModelProperty(value = "审核人")
    @TableField("audit_user_id")
    private String auditUserId;

    @ApiModelProperty(value = "审核时间")
    @TableField("audit_date")
    private LocalDateTime auditDate;

    @ApiModelProperty(value = "备注")
    @TableField("remark")
    private String remark;

    @ApiModelProperty(value = "模块号")
    @TableField("sys_no")
    private String sysNo;

    @ApiModelProperty(value = "类型")
    @TableField("biz_type")
    private String bizType;


}
