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
 * 项目分类表（父）
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmProjType对象", description="项目分类表（父）")
@TableName("ct_srm_proj_type")
public class SrmProjType extends BasePO {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "名称")
    @TableField("name")
    private String name;

    @TableField("is_valid")
    private Integer isValid;

    @ApiModelProperty(value = "代码")
    @TableField("code")
    private String code;

    @TableField("proj_class")
    private String projClass;

    @TableField("proj_level")
    private Long projLevel;

    @TableField("social_source")
    private String socialSource;

    @TableField("tech_source")
    private String techSource;

    @TableField("alias")
    private String alias;


}
