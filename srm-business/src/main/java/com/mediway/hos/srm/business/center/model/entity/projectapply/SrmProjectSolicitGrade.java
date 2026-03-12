package com.mediway.hos.srm.business.center.model.entity.projectapply;

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
 * 项目征集专业评分表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmProjectSolicitGrade对象", description="项目征集专业评分表")
@TableName("srm_project_solicit_grade")
public class SrmProjectSolicitGrade extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "系统号")
    @TableField("sys_no")
    private String sysNo;

    @ApiModelProperty(value = "项目ID ")
    @TableField("project_id")
    private String projectId;

    @ApiModelProperty(value = "数据状态")
    @TableField("data_status")
    private Integer dataStatus;

    @ApiModelProperty(value = "评审时间")
    @TableField("audit_date")
    private LocalDateTime auditDate;

    @ApiModelProperty(value = "指标1")
    @TableField("index1")
    private String index1;

    @ApiModelProperty(value = "指标1分数")
    @TableField("index1score")
    private String index1score;

    @ApiModelProperty(value = "指标2")
    @TableField("index2")
    private String index2;

    @ApiModelProperty(value = "指标2分数")
    @TableField("index2score")
    private String index2score;

    @ApiModelProperty(value = "指标3")
    @TableField("index3")
    private String index3;

    @ApiModelProperty(value = "指标3分数")
    @TableField("index3score")
    private String index3score;

    @ApiModelProperty(value = "指标4")
    @TableField("index4")
    private String index4;

    @ApiModelProperty(value = "指标4分数")
    @TableField("index4score")
    private String index4score;

    @ApiModelProperty(value = "指标5")
    @TableField("index5")
    private String index5;

    @ApiModelProperty(value = "指标5分数")
    @TableField("index5score")
    private String index5score;

    @ApiModelProperty(value = "指标6")
    @TableField("index6")
    private String index6;

    @ApiModelProperty(value = "指标6分数")
    @TableField("index6score")
    private String index6score;

    @ApiModelProperty(value = "指标7")
    @TableField("index7")
    private String index7;

    @ApiModelProperty(value = "指标7分数")
    @TableField("index7score")
    private String index7score;

    @ApiModelProperty(value = "指标8")
    @TableField("index8")
    private String index8;

    @ApiModelProperty(value = "指标8分数")
    @TableField("index8score")
    private String index8score;

    @ApiModelProperty(value = "指标9")
    @TableField("index9")
    private String index9;

    @ApiModelProperty(value = "指标9分数")
    @TableField("index9score")
    private String index9score;

    @ApiModelProperty(value = "指标10")
    @TableField("index10")
    private String index10;

    @ApiModelProperty(value = "指标10分数")
    @TableField("index10score")
    private String index10score;

    @ApiModelProperty(value = "指标11")
    @TableField("index11")
    private String index11;

    @ApiModelProperty(value = "指标11分数")
    @TableField("index11score")
    private String index11score;

    @ApiModelProperty(value = "指标12")
    @TableField("index12")
    private String index12;

    @ApiModelProperty(value = "指标12分数")
    @TableField("index12score")
    private String index12score;

    @ApiModelProperty(value = "专家评审")
    @TableField("expert")
    private String expert;

    @ApiModelProperty(value = "审核状态")
    @TableField("audit_status")
    private String auditStatus;

    @ApiModelProperty(value = "建议")
    @TableField("note")
    private String note;

    @ApiModelProperty(value = "项目类型")
    @TableField("prj_type")
    private String prjType;

    @ApiModelProperty(value = "修改次数")
    @TableField("mod_number")
    private String modNumber;
    @ApiModelProperty(value = "第几次分配")
    @TableField("allot_count")
    private String allotCount;

    @ApiModelProperty(value = "取消标志")
    @TableField("is_cancel")
    private Integer isCancel;

}
