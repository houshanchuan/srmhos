package com.mediway.hos.srm.business.center.model.entity.award;

import com.baomidou.mybatisplus.annotation.TableName;
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
 * 成果获奖登记
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmAchievement对象", description="成果获奖登记")
@TableName("srm_achievement")
public class SrmAchievement extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "年度")
    @TableField("year")
    private String year;

    @ApiModelProperty(value = "名称（题目）")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "获奖类型")
    @TableField("reward_type")
    private String rewardType;

    @ApiModelProperty(value = "获奖名称")
    @TableField("reward_name")
    private String rewardName;

    @ApiModelProperty(value = "获奖级别")
    @TableField("reward_level")
    private String rewardLevel;
    @ApiModelProperty(value = "获奖等次")
    @TableField("reward_grade")
    private String rewardGrade;
    @ApiModelProperty(value = "批准单位")
    @TableField("reward_unit")
    private String rewardUnit;

    @ApiModelProperty(value = "获奖时间")
    @TableField("reward_date")
    private String rewardDate;

    @ApiModelProperty(value = "我院单位位次")
    @TableField("our_unit_ranking")
    private String ourUnitRanking;

    @ApiModelProperty(value = "申请人")
    @TableField("sub_user_id")
    private String subUserId;

    @ApiModelProperty(value = "申请时间")
    @TableField("sub_date")
    private LocalDateTime subDate;

    @ApiModelProperty(value = "数据状态")
    @TableField("data_status")
    private Integer dataStatus;

    @ApiModelProperty(value = "系统号")
    @TableField("sys_no")
    private String sysNo;

    @ApiModelProperty(value = "类型")
    @TableField("biz_type")
    private String bizType;

    @ApiModelProperty(value = "科室")
    @TableField("dept_id")
    private String deptId;

    @ApiModelProperty(value = "来源(颁奖机构)")
    @TableField("source")
    private String source;

    @ApiModelProperty(value = "证书No")
    @TableField("certificate_no")
    private String certificateNo;

    @ApiModelProperty(value = "主要完成人")
    @TableField("main_completer")
    private String mainCompleter;

    @ApiModelProperty(value = "分类")
    @TableField("achv_cat")
    private String achvCat;

    @ApiModelProperty(value = "权利人")
    @TableField("achv_owner")
    private String achvOwner;

    @ApiModelProperty(value = "获奖名称")
    @TableField("award_name")
    private String awardName;

    @ApiModelProperty(value = "教研窒")
    @TableField("division_id")
    private String divisionId;

    @ApiModelProperty(value = "学科门类代码")
    @TableField("class_code")
    private String classCode;

    @ApiModelProperty(value = "学科分类")
    @TableField("discipline")
    private String discipline;

    @ApiModelProperty(value = "二级学科")
    @TableField("discipline_two")
    private String disciplineTwo;

    @ApiModelProperty(value = "三级级学科")
    @TableField("discipline_three")
    private String disciplineThree;

    @ApiModelProperty(value = "作者人数")
    @TableField("author_sum")
    private Integer authorSum;

    @ApiModelProperty(value = "项目来源")
    @TableField("project_source")
    private String projectSource;

    @ApiModelProperty(value = "审核状态")
    @TableField("check_status")
    private String checkStatus;

    @ApiModelProperty(value = "备注")
    @TableField("note")
    private String note;

    @ApiModelProperty(value = "署名我院")
    @TableField("school_sign")
    private String schoolSign;

    @ApiModelProperty(value = "总参加单位数")
    @TableField("unitsum")
    private String unitsum;

    @ApiModelProperty(value = "第一作者类型（本院，外院）")
    @TableField("fauthor_type")
    private String fauthorType;

    @ApiModelProperty(value = "第一作者姓名")
    @TableField("fauthor_name")
    private String fauthorName;

    @ApiModelProperty(value = "第一作者职称")
    @TableField("fauthor_title")
    private String fauthorTitle;

    @ApiModelProperty(value = "第一作者性别")
    @TableField("fauthor_sex")
    private String fauthorSex;

    @ApiModelProperty(value = "院内第一作者编号")
    @TableField("in_fauthor_code")
    private String inFauthorCode;

    @ApiModelProperty(value = "院内第一作者ID")
    @TableField("in_fauthor_id")
    private String inFauthorId;

    @ApiModelProperty(value = "院内第一作者最后学历")
    @TableField("in_fauthor_edu_level")
    private String inFauthorEduLevel;

    @ApiModelProperty(value = "院内第一作者最后学位")
    @TableField("in_fauthor_edu_degree")
    private String inFauthorEduDegree;

    @ApiModelProperty(value = "操作时间")
    @TableField("operate_time")
    private LocalDateTime operateTime;

    @ApiModelProperty(value = "获奖级别")
    @TableField("award_level")
    private String awardLevel;

    @ApiModelProperty(value = "创建人Id")
    @TableField("creator_id")
    private String creatorId;

    @ApiModelProperty(value = "创建人名称")
    @TableField("creator_name")
    private String creatorName;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "获奖申报id")
    @TableField("award_apply_id")
    private String awardApplyId;


}
