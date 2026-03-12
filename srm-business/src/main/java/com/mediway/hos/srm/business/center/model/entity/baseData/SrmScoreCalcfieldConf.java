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
 * 各模块参与绩点计算的字段
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmScoreCalcfieldConf对象", description="各模块参与绩点计算的字段")
@TableName("srm_score_calcfield_conf")
public class SrmScoreCalcfieldConf extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "年度")
    @TableField("year")
    private String year;

    @ApiModelProperty(value = "系统模块号")
    @TableField("sys_no")
    private String sysNo;

    @ApiModelProperty(value = "字段代码")
    @TableField("field_code")
    private String fieldCode;

    @ApiModelProperty(value = "字段名称")
    @TableField("field_name")
    private String fieldName;

    @ApiModelProperty(value = "字段系数获取方法")
    @TableField("calc_method")
    private String calcMethod;

    @ApiModelProperty(value = "该字段系数是否由其他字段构成")
    @TableField("is_comprehensive")
    private Integer isComprehensive;

    @ApiModelProperty(value = "改字段指向的表结构名称？？")
    @TableField("table_index")
    private String tableIndex;


}
