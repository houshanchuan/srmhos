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
 * 审核记录表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmCheckRec对象", description="审核记录表")
@TableName("srm_check_rec")
public class SrmCheckRec extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ROWID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "系统号")
    @TableField("sys_no")
    private String sysNo;

    @ApiModelProperty(value = "业务RowId")
    @TableField("rec_id")
    private String recId;

    @ApiModelProperty(value = "审核人代码")
    @TableField("user_code")
    private String userCode;

    @ApiModelProperty(value = "审核人名称")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty(value = "审核日期")
    @TableField("check_date")
    private LocalDateTime checkDate;

    @ApiModelProperty(value = "审核时间")
    @TableField("check_time")
    private LocalDateTime checkTime;

    @ApiModelProperty(value = "审核结果状态")
    @TableField("check_status")
    private String checkStatus;

    @ApiModelProperty(value = "审核描述")
    @TableField("check_info")
    private String checkInfo;


}
