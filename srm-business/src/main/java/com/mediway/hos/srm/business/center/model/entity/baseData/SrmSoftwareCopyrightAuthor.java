package com.mediway.hos.srm.business.center.model.entity.baseData;

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
 * 软著作者信息表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmSoftwareCopyrightAuthor对象", description="软著作者信息表")
@TableName("srm_software_copyright_author")
public class SrmSoftwareCopyrightAuthor extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "著作权编号")
    @TableField("software_cprt")
    private Long softwareCprt;

    @ApiModelProperty(value = "成员编号")
    @TableField("author_id")
    private String authorId;

    @ApiModelProperty(value = "作者编号")
    @TableField("author_code")
    private String authorCode;

    @ApiModelProperty(value = "完成人名称")
    @TableField("author_name")
    private String authorName;

    @ApiModelProperty(value = "成员类型")
    @TableField("author_type")
    private String authorType;

    @ApiModelProperty(value = "成员单位编号")
    @TableField("unit")
    private String unit;

    @ApiModelProperty(value = "成员单位名称")
    @TableField("unit_name")
    private String unitName;

    @ApiModelProperty(value = "作者科研单位")
    @TableField("division_code")
    private String divisionCode;

    @ApiModelProperty(value = "署名顺序")
    @TableField("ranking")
    private String ranking;

    @ApiModelProperty(value = "贡献率")
    @TableField("work_ratio")
    private BigDecimal workRatio;

    @ApiModelProperty(value = "备注")
    @TableField("note")
    private String note;

    @ApiModelProperty(value = "最后学位")
    @TableField("edu_degree")
    private String eduDegree;

    @ApiModelProperty(value = "性别")
    @TableField("sex")
    private String sex;

    @ApiModelProperty(value = "最后学历")
    @TableField("edu_level")
    private String eduLevel;

    @ApiModelProperty(value = "职称")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "作者科室(院内)")
    @TableField("dept_id")
    private String deptId;


}
