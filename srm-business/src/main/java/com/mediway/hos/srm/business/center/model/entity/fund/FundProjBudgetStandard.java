package com.mediway.hos.srm.business.center.model.entity.fund;

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
 * 项目分类预算标准
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="FundProjBudgetStandard对象", description="项目分类预算标准")
@TableName("ct_fund_proj_budget_standard")
public class FundProjBudgetStandard extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "代码")
    @TableField("code")
    private String code;

    @ApiModelProperty(value = "描述")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "是否有效")
    @TableField("is_valid")
    private Integer isValid;

    @ApiModelProperty(value = "项目分类")
    @TableField("proj_type")
    private String projType;

    @ApiModelProperty(value = "起始年度")
    @TableField("start_year")
    private String startYear;

    @ApiModelProperty(value = "终止年度")
    @TableField("end_year")
    private String endYear;


}
