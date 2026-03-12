package com.mediway.hos.srm.business.center.model.entity.patent;

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
 * 专利申报批次
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmPatentApplyInfo对象", description="专利申报批次")
@TableName("srm_patent_apply_info")
public class SrmPatentApplyInfo extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "编号")
    @TableField("apply_info_no")
    private String applyInfoNo;

    @ApiModelProperty(value = "名称")
    @TableField("apply_info_name")
    private String applyInfoName;

    @ApiModelProperty(value = "类型")
    @TableField("patent_type")
    private String patentType;

    @ApiModelProperty(value = "起始日期")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="start_date")
    private LocalDateTime startDate;

    @ApiModelProperty(value = "结束日期")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="end_date")
    private LocalDateTime endDate;

    @ApiModelProperty(value = "申请状态")
    @TableField("apply_info_state")
    private String applyInfoState;

    @ApiModelProperty(value = "备注")
    @TableField("note")
    private String note;

    @ApiModelProperty(value = "创建人ID")
    @TableField("creator_id")
    private String creatorId;

    @ApiModelProperty(value = "创建人姓名")
    @TableField("creator_name")
    private String creatorName;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "操作时间")
    @TableField("operate_time")
    private LocalDateTime operateTime;

    @ApiModelProperty(value = "专利状态")
    @TableField("patent_state")
    private String patentState;

    @ApiModelProperty(value = "？状态")
    @TableField("to_review_state")
    private String toReviewState;

    @ApiModelProperty(value = "？状态")
    @TableField("review_state")
    private String reviewState;


}
