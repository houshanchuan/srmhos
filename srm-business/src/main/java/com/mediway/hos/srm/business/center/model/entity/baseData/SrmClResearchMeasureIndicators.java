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
 * 测量指标
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmClResearchMeasureIndicators对象", description="测量指标")
@TableName("srm_cl_research_measure_indicators")
public class SrmClResearchMeasureIndicators extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ROWID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "项目DR")
    @TableField("soli_proj_id")
    private String soliProjId;

    @ApiModelProperty(value = "指标名称")
    @TableField("indicator_name")
    private String indicatorName;

    @ApiModelProperty(value = "类型")
    @TableField("indicator_type")
    private String indicatorType;

    @ApiModelProperty(value = "测量时间点")
    @TableField("time_point")
    private String timePoint;

    @ApiModelProperty(value = "测量方法")
    @TableField("method")
    private String method;

    @ApiModelProperty(value = "描述")
    @TableField("description")
    private String description;


}
