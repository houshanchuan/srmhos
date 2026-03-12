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
 * 获奖依托成果
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmAwardProduct对象", description="获奖依托成果")
@TableName("srm_award_product")
public class SrmAwardProduct extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "获奖成果DR")
    @TableField("proj_achv_id")
    private String projAchvId;

    @ApiModelProperty(value = "获奖依托成果DR")
    @TableField("product_pointer")
    private String productPointer;

    @ApiModelProperty(value = "成果类型")
    @TableField("product_type")
    private String productType;

    @ApiModelProperty(value = "获奖成果ID*")
    @TableField("honor_id")
    private String honorId;

    @ApiModelProperty(value = "获奖依托成果ID*")
    @TableField("product_id")
    private String productId;


}
