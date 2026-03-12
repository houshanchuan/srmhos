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
 * 系统参数明细
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmSysParameter对象", description="系统参数明细")
@TableName("cf_srm_sys_parameter")
public class SrmSysParameter extends BasePO {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "参数代码")
    @TableField("code")
    private String code;

    @ApiModelProperty(value = "参数名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "参数值")
    @TableField("para_value")
    private String paraValue;

    @ApiModelProperty(value = "模块")
    @TableField("para_type")
    private String paraType;

    @ApiModelProperty(value = "描述")
    @TableField("para_desc")
    private String paraDesc;

    @ApiModelProperty(value = "说明")
    @TableField("para_explain")
    private String paraExplain;


}
