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
 * 预算科室访问权限
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="FundBudgetDeptGrant对象", description="预算科室访问权限")
@TableName("cf_fund_budget_dept_grant")
public class FundBudgetDeptGrant extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "科室ID")
    @TableField("dept_code")
    private String deptCode;

    @ApiModelProperty(value = "用户ID")
    @TableField("user_code")
    private String userCode;

    @ApiModelProperty(value = "医疗单位ID")
    @TableField("hosp_code")
    private String hospCode;


}
