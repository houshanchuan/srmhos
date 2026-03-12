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
 * 获奖申报
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmAwardApply对象", description="获奖申报")
@TableName("srm_award_apply")
public class SrmAwardApply extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ROWID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "申报计划 ")
    @TableField("apply_info_id")
    private Long applyInfoId;

    @ApiModelProperty(value = "获奖名称 ")
    @TableField("award_name")
    private String awardName;

    @ApiModelProperty(value = "第一作者类型 ")
    @TableField("first_author_type")
    private String firstAuthorType;

    @ApiModelProperty(value = "第一作者编号 ")
    @TableField("first_author_code")
    private String firstAuthorCode;

    @ApiModelProperty(value = "第一作者姓名")
    @TableField("first_author_name")
    private String firstAuthorName;

    @ApiModelProperty(value = "成果名称")
    @TableField("product_name")
    private String productName;

    @ApiModelProperty(value = "所属科室 ")
    @TableField("dept_id")
    private String deptId;

    @ApiModelProperty(value = "申请日期")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="apply_date")
    private LocalDateTime applyDate;

    @ApiModelProperty(value = "获奖级别 ")
    @TableField("award_level")
    private String awardLevel;

    @ApiModelProperty(value = "学科门类 ")
    @TableField("classCode")
    private String classCode;

    @ApiModelProperty(value = "学科 ")
    @TableField("discipline")
    private String discipline;

    @ApiModelProperty(value = "项目来源 ")
    @TableField("productproj_ectsource")
    private String productprojEctsource;

    @ApiModelProperty(value = "成果形式 ")
    @TableField("product_mode")
    private String productMode;

    @ApiModelProperty(value = "是否注册登记")
    @TableField("is_registered")
    private Integer isRegistered;

    @ApiModelProperty(value = "本单位排名")
    @TableField("our_unit_ranking")
    private String ourUnitRanking;

    @ApiModelProperty(value = "获奖成果登记ID ")
    @TableField("award")
    private String award;

    @ApiModelProperty(value = "附件文件名称")
    @TableField("file_ids")
    private String fileIds;

    @ApiModelProperty(value = "备注")
    @TableField("note")
    private String note;

    @ApiModelProperty(value = "审核状态 ")
    @TableField("check_status")
    private String checkStatus;
    @ApiModelProperty(value = "创建人")
    @TableField("creator_id")
    private String creatorId;
    @ApiModelProperty(value = "创建人 ")
    @TableField("creator_code")
    private String creatorCode;

    @ApiModelProperty(value = "创建人名称")
    @TableField("creator_name")
    private String creatorName;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "操作时间")
    @TableField("operate_time")
    private LocalDateTime operateTime;

    @ApiModelProperty(value = "年度")
    @TableField("year")
    private String year;

    @ApiModelProperty(value = "奖项类型 ")
    @TableField("reward_type")
    private String rewardType;

    @ApiModelProperty(value = "主要完成人 (第一完成人)")
    @TableField("main_completer_id")
    private String mainCompleterId;
    @ApiModelProperty(value = "提交状态")
    @TableField("data_status")
    private Integer dataStatus;

    @ApiModelProperty(value = "提交人")
    @TableField("sub_user_id")
    private String subUserId;

    @ApiModelProperty(value = "提交日期")
    @TableField("sub_date")
    private LocalDateTime subDate;

}
