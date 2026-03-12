package com.mediway.hos.srm.business.center.model.entity.award;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import com.mediway.hos.srm.business.base.model.entity.BasePO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 获奖申报计划
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmAwardApplyInfo对象", description="获奖申报计划")
@TableName("srm_award_apply_info")
public class SrmAwardApplyInfo extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ROWID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "计划名称")
    @TableField("apply_name")
    private String applyName;

    @ApiModelProperty(value = "获奖名称")
    @TableField("award_name")
    private String awardName;

    @ApiModelProperty(value = "获奖级别 ")
    @TableField("award_level")
    private String awardLevel;

    @ApiModelProperty(value = "起始日期")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="start_date")
    private LocalDateTime startDate;

    @ApiModelProperty(value = "截止日期")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="end_date")
    private LocalDateTime endDate;

    @ApiModelProperty(value = "申报计划状态")
    @TableField("state")
    private String state;

    @ApiModelProperty(value = "创建人编号 ")
    @TableField("creator_code")
    private String creatorCode;

    @ApiModelProperty(value = "创建人姓名")
    @TableField("creator_name")
    private String creatorName;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "操作时间")
    @TableField("operate_time")
    private LocalDateTime operateTime;

    @ApiModelProperty(value = "备注")
    @TableField("note")
    private String note;


}
