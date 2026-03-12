package com.mediway.hos.srm.business.center.model.entity.baseData;

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
 * 绩效字段系数表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmScoreFieldCoefficient对象", description="绩效字段系数表")
@TableName("srm_score_field_coefficient")
public class SrmScoreFieldCoefficient extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "系统模块号")
    @TableField("sys_no")
    private String sysNo;

    @ApiModelProperty(value = "字段系数获取方法")
    @TableField("calc_method")
    private String calcMethod;

    @ApiModelProperty(value = "指向字段表")
    @TableField("field_id")
    private String fieldId;

    @ApiModelProperty(value = "系数类型")
    @TableField("coefficient_type")
    private String coefficientType;

    @ApiModelProperty(value = "默认系数或值")
    @TableField("default_value")
    private String defaultValue;

    @ApiModelProperty(value = "公式描述")
    @TableField("fourmula_desc")
    private String fourmulaDesc;

    @ApiModelProperty(value = "字段对应值")
    @TableField("field_value")
    private String fieldValue;

    @ApiModelProperty(value = "字段最小值")
    @TableField("field_min_value")
    private String fieldMinValue;

    @ApiModelProperty(value = "字段最大值")
    @TableField("field_max_value")
    private String fieldMaxValue;

    @ApiModelProperty(value = "等比步长")
    @TableField("step_size")
    private String stepSize;

    @ApiModelProperty(value = "字段区间系数")
    @TableField("interval_coefficient")
    private String intervalCoefficient;

    @ApiModelProperty(value = "字段大于值")
    @TableField("min_value")
    private String minValue;

    @ApiModelProperty(value = "字段小于值")
    @TableField("max_value")
    private String maxValue;

    @ApiModelProperty(value = "字段系数或值")
    @TableField("coefficient")
    private String coefficient;

    @ApiModelProperty(value = "字段系数描述")
    @TableField("coefficient_desc")
    private String coefficientDesc;

    @ApiModelProperty(value = "年度")
    @TableField("year")
    private String year;


}
