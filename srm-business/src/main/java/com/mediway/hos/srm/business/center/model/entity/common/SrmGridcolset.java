package com.mediway.hos.srm.business.center.model.entity.common;

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
 * 列设置
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Gridcolset对象", description="列设置")
@TableName("cf_srm_gridcolset")
public class SrmGridcolset extends BasePO {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "类型人员安全组网站")
    @TableField("type")
    private String type;
    @ApiModelProperty(value = "类型人员安全组网站值")
    @TableField("reference")
    private String reference;

    @ApiModelProperty(value = "页面地址")
    @TableField("gridurl")
    private String gridurl;

    @ApiModelProperty(value = "gridId")
    @TableField("gridId")
    private String gridId;

    @ApiModelProperty(value = "列Id")
    @TableField("colId")
    private String colId;

    @ApiModelProperty(value = "列名称")
    @TableField("colName")
    private String colName;

    @ApiModelProperty(value = "列Header")
    @TableField("colHeader")
    private String colHeader;

    @ApiModelProperty(value = "列对齐")
    @TableField("colAlign")
    private String colAlign;

    @ApiModelProperty(value = "列位置")
    @TableField("colOrder")
    private Integer colOrder;

    @ApiModelProperty(value = "列宽度")
    @TableField("colWidth")
    private Integer colWidth;

    @ApiModelProperty(value = "列回车跳转顺序")
    @TableField("colEnterOrder")
    private String colEnterOrder;

    @ApiModelProperty(value = "列隐藏")
    @TableField("is_hidden")
    private Integer isHidden;

    @ApiModelProperty(value = "列必须")
    @TableField("is_necessary")
    private Integer isNecessary;

    @ApiModelProperty(value = "列导出")
    @TableField("is_export")
    private Integer isExport;

    @ApiModelProperty(value = "列排序")
    @TableField("is_sortable")
    private Integer isSortable;

    @ApiModelProperty(value = "列打印")
    @TableField("is_print")
    private Integer isPrint;

    @ApiModelProperty(value = "列复制")
    @TableField("is_copy")
    private Integer isCopy;

    @ApiModelProperty(value = "列冻结")
    @TableField("is_frozen")
    private Integer isFrozen;


}
