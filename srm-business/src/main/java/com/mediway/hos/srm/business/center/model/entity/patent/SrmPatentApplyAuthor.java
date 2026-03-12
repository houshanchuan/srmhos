package com.mediway.hos.srm.business.center.model.entity.patent;

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
 * 专利申报作者表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmPatentApplyAuthor对象", description="专利申报作者表")
@TableName("srm_patent_apply_author")
public class SrmPatentApplyAuthor extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ROWID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "专利申报ID")
    @TableField("apply_patent_id")
    private Long applyPatentId;

    @ApiModelProperty(value = "作者ID")
    @TableField("author_id")
    private String authorId;

    @ApiModelProperty(value = "作者代码")
    @TableField("author_code")
    private String authorCode;

    @ApiModelProperty(value = "作者姓名")
    @TableField("author_name")
    private String authorName;

    @ApiModelProperty(value = "作者类型")
    @TableField("author_type")
    private String authorType;

    @ApiModelProperty(value = "作者单位名称")
    @TableField("author_dept_name")
    private String authorDeptName;

    @ApiModelProperty(value = "作者单位ID")
    @TableField("author_dept_code")
    private String authorDeptCode;

    @ApiModelProperty(value = "作者教研室ID")
    @TableField("author_division_code")
    private String authorDivisionCode;

    @ApiModelProperty(value = "学位")
    @TableField("degree")
    private String degree;

    @ApiModelProperty(value = "学历")
    @TableField("edu_level")
    private String eduLevel;

    @ApiModelProperty(value = "职称")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "性别")
    @TableField("sex")
    private String sex;

    @ApiModelProperty(value = "排序")
    @TableField("ranking")
    private String ranking;

    @ApiModelProperty(value = "贡献率")
    @TableField("work_ratio")
    private BigDecimal workRatio;

    @ApiModelProperty(value = "备注")
    @TableField("note")
    private String note;

    @ApiModelProperty(value = "是否本院")
    @TableField("is_our_hosp")
    private Integer isOurHosp;


}
