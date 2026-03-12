package com.mediway.hos.srm.business.center.model.entity.baseData;

import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
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
 * 成果费用报销记录表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmAchvExpenseReimbursement对象", description="成果费用报销记录表")
@TableName("srm_achv_expense_reimbursement")
public class SrmAchvExpenseReimbursement extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "论文登记ID")
    @TableField("regpaper_id")
    private String regpaperId;

    @ApiModelProperty(value = "报销金额")
    @TableField("reim_amount")
    private BigDecimal reimAmount;

    @ApiModelProperty(value = "发票代码")
    @TableField("inv_code")
    private String invCode;

    @ApiModelProperty(value = "发票号")
    @TableField("inv_no")
    private String invNo;

    @ApiModelProperty(value = "发票金额")
    @TableField("inv_amount")
    private BigDecimal invAmount;

    @ApiModelProperty(value = "结束标志")
    @TableField("is_finished")
    private Integer isFinished;

    @ApiModelProperty(value = "作者")
    @TableField("author")
    private String author;

    @ApiModelProperty(value = "提交日期")
    @TableField("sub_date")
    private LocalDateTime subDate;

    @ApiModelProperty(value = "提交状态")
    @TableField("data_status")
    private Integer dataStatus;

    @ApiModelProperty(value = "系统号")
    @TableField("sys_no")
    private String sysNo;

    @ApiModelProperty(value = "版费单位")
    @TableField("unit_money")
    private String unitMoney;

    @ApiModelProperty(value = "报销比例")
    @TableField("reim_ratio")
    private BigDecimal reimRatio;

    @ApiModelProperty(value = "报销版费")
    @TableField("re_amount")
    private BigDecimal reAmount;

    @TableField("cost_rec_id")
    private String costRecId;


}
