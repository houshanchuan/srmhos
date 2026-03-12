package com.mediway.hos.srm.business.center.model.entity.projectapply;

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
 * 项目申报批次
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="ProjectApplyInfo对象", description="项目申报批次")
@TableName("srm_project_apply_info")
public class SrmProjectApplyInfo extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "申报项目编号")
    @TableField("code")
    private String code;

    @ApiModelProperty(value = "申报项目名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "学科类别编号")
    @TableField("discipline")
    private String discipline;

    @ApiModelProperty(value = "项目性质编号")
    @TableField("project_class")
    private String projectClass;

    @ApiModelProperty(value = "项目分类代码")
    @TableField("proj_type")
    private String projType;

    @ApiModelProperty(value = "项目来源单位")
    @TableField("source_unit_name")
    private String sourceUnitName;

    @ApiModelProperty(value = "开始日期")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="start_date")
    private LocalDateTime startDate;

    @ApiModelProperty(value = "结束日期")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="end_date")
    private LocalDateTime endDate;

    @ApiModelProperty(value = "申报状态编号－对应代码表　")
    @TableField("state")
    private String state;

    @ApiModelProperty(value = "备注")
    @TableField("note")
    private String note;

    @ApiModelProperty(value = "记录创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "记录创建人编号")
    @TableField("creator_code")
    private String creatorCode;

    @ApiModelProperty(value = "是否评审")
    @TableField("is_review_needed")
    private Integer isReviewNeeded;

    @ApiModelProperty(value = "附件文件串")
    @TableField("file_ids")
    private String fileIds;


}
