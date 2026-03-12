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
 * 预算项目(科目)表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="FundBudgetItem对象", description="预算项目(科目)表")
@TableName("ct_fund_budget_item")
public class FundBudgetItem extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "编码")
    @TableField("code")
    private String code;

    @ApiModelProperty(value = "上级编码")
    @TableField("up_code")
    private String upCode;

    @ApiModelProperty(value = "名称（简称）")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "名称（全称）")
    @TableField("name_all")
    private String nameAll;

    @ApiModelProperty(value = "层级")
    @TableField("level")
    private String level;

    @ApiModelProperty(value = "类别编码")
    @TableField("item_type")
    private String itemType;

    @ApiModelProperty(value = "拼音码")
    @TableField("spell")
    private String spell;

    @ApiModelProperty(value = "借贷方向")
    @TableField("direction")
    private Integer direction;

    @ApiModelProperty(value = "是否末级")
    @TableField("is_last")
    private Integer isLast;

    @ApiModelProperty(value = "专项标记")
    @TableField("is_special")
    private Integer isSpecial;

    @ApiModelProperty(value = "现金标志")
    @TableField("is_cash")
    private Integer isCash;

    @ApiModelProperty(value = "是否最终预算项")
    @TableField("is_result")
    private Integer isResult;

    @ApiModelProperty(value = "计量单位ID")
    @TableField("cal_unit_code")
    private String calUnitCode;

    @ApiModelProperty(value = "责任科室ID")
    @TableField("dept_duty")
    private String deptDuty;

    @ApiModelProperty(value = "归口科室一ID")
    @TableField("au_dept_first")
    private String auDeptFirst;

    @ApiModelProperty(value = "归口科室二ID")
    @TableField("au_dept_second")
    private String auDeptSecond;

    @ApiModelProperty(value = "是否政府采购")
    @TableField("is_gov_buy")
    private Integer isGovBuy;

    @ApiModelProperty(value = "备注")
    @TableField("note")
    private String note;

    @ApiModelProperty(value = "顺序")
    @TableField("item_order")
    private Integer itemOrder;


}
