package com.mediway.hos.srm.business.center.model.entity.fund;

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
 * 项目资金来源类型表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="FundType对象", description="项目资金来源类型表")
@TableName("ct_fund_type")
public class FundType extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "代码")
    @TableField("code")
    private String code;

    @ApiModelProperty(value = "描述")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "是否有效")
    @TableField("is_valid")
    private Integer isValid;

    @ApiModelProperty(value = "医疗机构ID")
    @TableField("hosp_code")
    private String hospCode;


}
