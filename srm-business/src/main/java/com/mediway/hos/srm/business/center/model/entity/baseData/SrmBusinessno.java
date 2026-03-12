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
 * 单号生成
 * </p>
 *
 * @author 代码生成器
 * @since 2025-02-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmBusinessno对象", description="单号生成")
@TableName("cf_srm_businessno")
public class SrmBusinessno extends BasePO {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "模块类型")
    @TableField("type")
    private String type;

    @ApiModelProperty(value = "当前值")
    @TableField("currentno")
    private Integer currentno;


}
