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
 * 成果依托项目表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmProductProject对象", description="成果依托项目表")
@TableName("srm_product_project")
public class SrmProductProject extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "系统号")
    @TableField("rec_sys_no")
    private String recSysNo;

    @ApiModelProperty(value = "业务rowid")
    @TableField("rec_id")
    private String recId;

    @ApiModelProperty(value = "项目rowid")
    @TableField("proj_id")
    private String projId;

    @ApiModelProperty(value = "外部项目名称")
    @TableField("outproj_name")
    private String outprojName;

    @ApiModelProperty(value = "成果说明")
    @TableField("product_desc")
    private String productDesc;

    @ApiModelProperty(value = "成果类型")
    @TableField("product_type")
    private String productType;


}
