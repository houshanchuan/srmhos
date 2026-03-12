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
 * 奖励信息表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmRewardInfo对象", description="奖励信息表")
@TableName("srm_reward_info")
public class SrmRewardInfo extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "审核状态")
    @TableField("audit_status")
    private String auditStatus;

    @ApiModelProperty(value = "审核人")
    @TableField("auditor")
    private String auditor;

    @ApiModelProperty(value = "审核日期")
    @TableField("audit_date")
    private String auditDate;

    @ApiModelProperty(value = "RowID")
    @TableField("reward_rec_id")
    private String rewardRecId;

    @ApiModelProperty(value = "被奖励模块模块号")
    @TableField("reward_rec_sys_no")
    private String rewardRecSysNo;

    @ApiModelProperty(value = "奖项及其等级信息")
    @TableField("reward_level")
    private Integer rewardLevel;

    @ApiModelProperty(value = "第几完成单位")
    @TableField("unit_order")
    private String unitOrder;

    @ApiModelProperty(value = "成果登记号")
    @TableField("register_no")
    private String registerNo;

    @ApiModelProperty(value = "科研奖励模块号")
    @TableField("reward_sys_no")
    private String rewardSysNo;

    @ApiModelProperty(value = "是否已经奖励")
    @TableField("is_rewarded")
    private Integer isRewarded;

    @ApiModelProperty(value = "奖励时间")
    @TableField("reward_date")
    private LocalDateTime rewardDate;

    @ApiModelProperty(value = "奖励金额")
    @TableField("reward_amount")
    private BigDecimal rewardAmount;

    @ApiModelProperty(value = "奖金币种类型")
    @TableField("currency")
    private String currency;


}
