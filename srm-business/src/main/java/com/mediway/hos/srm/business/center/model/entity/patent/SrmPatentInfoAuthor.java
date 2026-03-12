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
 * 专利作者表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmPatentInfoAuthor对象", description="专利作者表")
@TableName("srm_patent_info_author")
public class SrmPatentInfoAuthor extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "专利DR")
    @TableField("patent_id")
    private Long patentId;

    @ApiModelProperty(value = "专利编号（ID）")
    @TableField("patent_no")
    private String patentNo;

    @ApiModelProperty(value = "作者DR ")
    @TableField("author")
    private String author;

    @ApiModelProperty(value = "作者代码")
    @TableField("author_code")
    private String authorCode;

    @ApiModelProperty(value = "作者姓名")
    @TableField("author_name")
    private String authorName;

    @ApiModelProperty(value = "作者单位")
    @TableField("author_unit")
    private String authorUnit;

    @ApiModelProperty(value = "作者排名 (Order)")
    @TableField("author_ranking")
    private String authorRanking;

    @ApiModelProperty(value = "作者类型  ")
    @TableField("author_type")
    private String authorType;

    @ApiModelProperty(value = "作者部门")
    @TableField("author_dept_id")
    private String authorDeptId;

    @ApiModelProperty(value = "作者教研室")
    @TableField("author_division")
    private String authorDivision;

    @ApiModelProperty(value = "是否第一作者")
    @TableField("is_first")
    private Integer isFirst;

    @ApiModelProperty(value = "贡献率")
    @TableField("work_ratio")
    private BigDecimal workRatio;

    @ApiModelProperty(value = "备注")
    @TableField("note")
    private String note;

    @ApiModelProperty(value = "学位  ")
    @TableField("edu_degree")
    private String eduDegree;

    @ApiModelProperty(value = "学历  ")
    @TableField("edu_level")
    private String eduLevel;

    @ApiModelProperty(value = "职称 ")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "性别")
    @TableField("sex")
    private String sex;


}
