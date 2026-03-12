package com.mediway.hos.srm.business.center.model.entity.project;

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
 * 项目验收信息表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-12-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmProjectFinalcheck对象", description="项目验收信息表")
@TableName("srm_project_finalcheck")
public class SrmProjectFinalcheck extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "课题项目id")
    @TableField("proj_id")
    private Long projId;

    @ApiModelProperty(value = "系统号")
    @TableField("sys_no")
    private String sysNo;

    @ApiModelProperty(value = "申请人")
    @TableField("sub_user")
    private String subUser;

    @ApiModelProperty(value = "申请日期")
    //@TableField(value = "sub_date",update = "false")
    @TableField(value = "sub_date")
    private LocalDateTime subDate;

    @ApiModelProperty(value = "审批状态")
    @TableField("audit_status")
    private String auditStatus;

    @ApiModelProperty(value = "数据状态")
    @TableField("data_status")
    private Integer dataStatus;

    @ApiModelProperty(value = "结果1")
    @TableField("situation1")
    private String situation1;

    @ApiModelProperty(value = "结果2")
    @TableField("situation2")
    private String situation2;

    @ApiModelProperty(value = "结果3")
    @TableField(value = "situation3")
    private String situation3;

    @ApiModelProperty(value = "结果4")
    @TableField("situation4")
    private String situation4;

    @ApiModelProperty(value = "结果5")
    @TableField("situation5")
    private String situation5;

    @ApiModelProperty(value = "结果6")
    @TableField("situation6")
    private String situation6;

    @ApiModelProperty(value = "结果7")
    @TableField("situation7")
    private String situation7;

    @ApiModelProperty(value = "结果8")
    @TableField("situation8")
    private String situation8;

    @ApiModelProperty(value = "结果9")
    @TableField("situation9")
    private String situation9;

    @ApiModelProperty(value = "结果10")
    @TableField("situation10")
    private String situation10;

    @ApiModelProperty(value = "结果11")
    @TableField("situation11")
    private String situation11;

    @ApiModelProperty(value = "结果12")
    @TableField("situation12")
    private String situation12;

    @ApiModelProperty(value = "结果13")
    @TableField("situation13")
    private String situation13;

    @ApiModelProperty(value = "结果14")
    @TableField("situation14")
    private String situation14;

    @ApiModelProperty(value = "结果15")
    @TableField("situation15")
    private String situation15;


}
