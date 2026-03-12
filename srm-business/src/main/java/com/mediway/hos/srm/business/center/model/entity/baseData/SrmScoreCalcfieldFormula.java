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
 * 每个模块绩点计算的公式
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmScoreCalcfieldFormula对象", description="每个模块绩点计算的公式")
@TableName("srm_score_calcfield_formula")
public class SrmScoreCalcfieldFormula extends BasePO {

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

    @ApiModelProperty(value = "公式描述")
    @TableField("calc_formula")
    private String calcFormula;

    @ApiModelProperty(value = "计算描述")
    @TableField("formula_desc")
    private String formulaDesc;


}
