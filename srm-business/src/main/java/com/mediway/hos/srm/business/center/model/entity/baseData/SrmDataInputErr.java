package com.mediway.hos.srm.business.center.model.entity.baseData;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.mediway.hos.srm.business.base.model.entity.BasePO;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 数据导入错误日志
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmDataInputErr对象", description="数据导入错误日志")
@TableName("srm_data_input_err")
public class SrmDataInputErr extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "日期")
    @TableField("input_date")
    private LocalDateTime inputDate;

    @ApiModelProperty(value = "时间")
    @TableField("input_time")
    private LocalDateTime inputTime;

    @ApiModelProperty(value = "错误号")
    @TableField("err_no")
    private String errNo;

    @ApiModelProperty(value = "错误描述")
    @TableField("err_desc")
    private String errDesc;


}
