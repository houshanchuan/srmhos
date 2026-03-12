package com.mediway.hos.srm.business.center.model.entity.systemConfig;

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
 * 系统模块表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-08-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SystemModule对象", description="系统模块表")
@TableName("ct_srm_system_module")
public class SrmSystemModule extends BasePO {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "代码")
    @TableField("code")
    private String code;

    @ApiModelProperty(value = "名称")
    @TableField("name")
    private String name;

    @TableField("en_name")
    private String enName;

    @TableField("is_valid")
    private Integer isValid;


}
