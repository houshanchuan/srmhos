package com.mediway.hos.srm.business.center.model.entity.monograph;

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
 * 著作作者表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="MonographInfoAuthor对象", description="著作作者表")
@TableName("srm_monograph_info_author")
public class SrmMonographInfoAuthor extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ROWID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "著作DR")
    @TableField("monograph_id")
    private Long monographId;

    @ApiModelProperty(value = "作者DR")
    @TableField("author_id")
    private String authorId;

    @ApiModelProperty(value = "作者姓名")
    @TableField("author_name")
    private String authorName;

    @ApiModelProperty(value = "作者类型")
    @TableField("editor_type")
    private String editorType;

    @ApiModelProperty(value = "作者排名")
    @TableField("ranking")
    private String ranking;

    @ApiModelProperty(value = "身份")
    @TableField("identity")
    private String identity;

    @ApiModelProperty(value = "科室")
    @TableField("dept_id")
    private String deptId;

    @ApiModelProperty(value = "科室名称")
    @TableField("dept_name")
    private String deptName;

    @ApiModelProperty(value = "作者单位")
    @TableField("unit_id")
    private String unitId;

    @ApiModelProperty(value = "院内院外标志")
    @TableField("in_out")
    private String inOut;

    @ApiModelProperty(value = "教研室")
    @TableField("division_code")
    private String divisionCode;

    @ApiModelProperty(value = "作者编号")
    @TableField("author_code")
    private String authorCode;

    @ApiModelProperty(value = "作者类型")
    @TableField("author_type")
    private String authorType;

    @ApiModelProperty(value = "性别")
    @TableField("sex")
    private String sex;

    @ApiModelProperty(value = "贡献率")
    @TableField("work_ratio")
    private BigDecimal workRatio;

    @ApiModelProperty(value = "字数")
    @TableField("words_num")
    private BigDecimal wordsNum;

    @ApiModelProperty(value = "备注")
    @TableField("note")
    private String note;

    @ApiModelProperty(value = "学位")
    @TableField("edu_degree")
    private String eduDegree;

    @ApiModelProperty(value = "最后学历")
    @TableField("edu_level")
    private String eduLevel;

    @ApiModelProperty(value = "职称")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "第一作者")
    @TableField("is_first")
    private Integer isFirst;

    @ApiModelProperty(value = "署名我院")
    @TableField("is_hosp_member")
    private Integer isHospMember;


}
