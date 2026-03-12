package com.mediway.hos.srm.business.center.model.entity.fund;

import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;

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
 * 交通工具费用报销标准配置表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="FundRmbsConfigVehicle对象", description="交通工具费用报销标准配置表")
@TableName("cf_fund_rmbs_config_vehicle")
public class FundRmbsConfigVehicle extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "出发地点")
    @TableField("addr_start")
    private String addrStart;

    @ApiModelProperty(value = "到达地点")
    @TableField("addr_end")
    private String addrEnd;

    @ApiModelProperty(value = "交通工具")
    @TableField("travel_vehicle")
    private String travelVehicle;

    @ApiModelProperty(value = "费用标准")
    @TableField("travel_fee")
    private BigDecimal travelFee;

    @ApiModelProperty(value = "员工分类")
    @TableField("category")
    private String category;

    @ApiModelProperty(value = "医院ID")
    @TableField("hosp_code")
    private String hospCode;

    @ApiModelProperty(value = "是否有效")
    @TableField("is_valid")
    private Integer isValid;


}
