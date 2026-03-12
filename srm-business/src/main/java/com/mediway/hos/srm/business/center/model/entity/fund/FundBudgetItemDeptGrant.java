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
 * 科目归口科室设置
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="FundBudgetItemOwnDept对象", description="科目归口科室设置")
@TableName("cf_fund_budget_item_dept_grant")
public class FundBudgetItemDeptGrant extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "项目编码")
    @TableField("item_code")
    private String itemCode;

    @ApiModelProperty(value = "科室ID")
    @TableField("dept_code")
    private String deptCode;

    @ApiModelProperty(value = "医疗单位ID")
    @TableField("hosp_code")
    private String hospCode;


}
