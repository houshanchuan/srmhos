package com.mediway.hos.srm.business.center.model.entity.fund;

import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
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
 * 项目字典表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="FundProjectInfo对象", description="项目字典表")
@TableName("srm_fund_project_info")
public class FundProjectInfo extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ROWID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "年度")
    @TableField("year")
    private String year;

    @ApiModelProperty(value = "医疗单位ID")
    @TableField("hosp_code")
    private String hospCode;

    @ApiModelProperty(value = "编码")
    @TableField("code")
    private String code;

    @ApiModelProperty(value = "名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "别名")
    @TableField("alias")
    private String alias;

    @ApiModelProperty(value = "项目责任人")
    @TableField("head_code")
    private String headCode;

    @ApiModelProperty(value = "单据创建时间")
    @TableField("issued_date")
    private LocalDate issuedDate;

    @ApiModelProperty(value = "责任科室")
    @TableField("dept_code")
    private String deptCode;

    @ApiModelProperty(value = "项目状态")
    @TableField("state")
    private String state;

    @ApiModelProperty(value = "项目分类")
    @TableField("category")
    private String category;

    @ApiModelProperty(value = "是否政府性采购")
    @TableField("is_gov_buy")
    private Integer isGovBuy;

    @ApiModelProperty(value = "政府资金")
    @TableField("fund_gov")
    private BigDecimal fundGov;

    @ApiModelProperty(value = "自筹资金")
    @TableField("fund_own")
    private BigDecimal fundOwn;

    @ApiModelProperty(value = "总预算")
    @TableField("fund_total")
    private BigDecimal fundTotal;

    @ApiModelProperty(value = "预算科室")
    @TableField("budget_dept")
    private String budgetDept;

    @ApiModelProperty(value = "编制方式  ")
    @TableField("budget_mode")
    private String budgetMode;

    @ApiModelProperty(value = "审批流主表ID")
    @TableField("chk_flow_id")
    private String chkFlowId;

    @ApiModelProperty(value = "结余计算方式  ")
    @TableField("blance_type")
    private String blanceType;

    @ApiModelProperty(value = "总到位经费")
    @TableField("account_total")
    private BigDecimal accountTotal;

    @ApiModelProperty(value = "项目id")
    @TableField("project_id")
    private String projectId;


}
