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
 * 预算年度表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="FundBudgetYear对象", description="预算年度表")
@TableName("cf_fund_budget_year")
public class FundBudgetYear extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "医疗单位ID")
    @TableField("hosp_code")
    private String hospCode;

    @ApiModelProperty(value = "预算年度")
    @TableField("year")
    private String year;

    @ApiModelProperty(value = "备注")
    @TableField("note")
    private String note;

    @ApiModelProperty(value = "是否下达")
    @TableField("is_valid")
    private Integer isValid;


}
