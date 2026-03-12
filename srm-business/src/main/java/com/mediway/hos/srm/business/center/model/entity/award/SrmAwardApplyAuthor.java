package com.mediway.hos.srm.business.center.model.entity.award;

import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
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
 * 成果获奖申报作者
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmAwardApplyAuthor对象", description="成果获奖申报作者")
@TableName("srm_award_apply_author")
public class SrmAwardApplyAuthor extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "获奖申报表 ")
    @TableField("award_apply_id")
    private Long awardApplyId;
    @ApiModelProperty(value = "作者ID ")
    @TableField("author_id")
    private String authorId;
    @ApiModelProperty(value = "作者编号 ")
    @TableField("author_code")
    private String authorCode;

    @ApiModelProperty(value = "作者姓名")
    @TableField("author_name")
    private String authorName;

    @ApiModelProperty(value = "作者类型 ")
    @TableField("author_type")
    private String authorType;

    @ApiModelProperty(value = "作者单位 ")
    @TableField("author_unit")
    private String authorUnit;

    @ApiModelProperty(value = "作者科研单位 ")
    @TableField("author_division")
    private String authorDivision;

    @ApiModelProperty(value = "学位 ")
    @TableField("edu_degree")
    private String eduDegree;

    @ApiModelProperty(value = "学历 ")
    @TableField("edu_level")
    private String eduLevel;

    @ApiModelProperty(value = "职称 ")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "性别")
    @TableField("sex")
    private String sex;

    @ApiModelProperty(value = "排序")
    @TableField("author_ranking")
    private String authorRanking;

    @ApiModelProperty(value = "贡献率")
    @TableField("work_ratio")
    private BigDecimal workRatio;

    @ApiModelProperty(value = "备注")
    @TableField("note")
    private String note;


}
