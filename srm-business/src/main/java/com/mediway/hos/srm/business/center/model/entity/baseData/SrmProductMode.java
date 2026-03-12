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
 * 成果(产品)模式
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmProductMode对象", description="成果(产品)模式")
@TableName("ct_srm_product_mode")
public class SrmProductMode extends BasePO {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "代码")
    @TableField("code")
    private String code;

    @ApiModelProperty(value = "名称")
    @TableField("name")
    private String name;

    @TableField("is_valid")
    private Integer isValid;

    @TableField("class_code")
    private String classCode;


}
