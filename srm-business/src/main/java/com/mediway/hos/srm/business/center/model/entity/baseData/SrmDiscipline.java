package com.mediway.hos.srm.business.center.model.entity.baseData;

import com.baomidou.mybatisplus.annotation.TableName;
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
 * 学科表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Discipline对象", description="学科表")
@TableName("ct_srm_discipline")
public class SrmDiscipline extends BasePO {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "代码")
    @TableField("code")
    private String code;

    @ApiModelProperty(value = "名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "有效")
    @TableField("is_valid")
    private Integer isValid;

    @ApiModelProperty(value = "学科门类")
    @TableField("class_code")
    private String classCode;

    @ApiModelProperty(value = "上级代码")
    @TableField("up_code")
    private String upCode;

    @ApiModelProperty(value = "学科分类名称")
    @TableField("category_name")
    private String categoryName;

    @ApiModelProperty(value = "备注")
    @TableField("note")
    private String note;

    @ApiModelProperty(value = "层级")
    @TableField("level")
    private Integer level;

    @ApiModelProperty(value = "助记别名")
    @TableField("alias")
    private String alias;


}
