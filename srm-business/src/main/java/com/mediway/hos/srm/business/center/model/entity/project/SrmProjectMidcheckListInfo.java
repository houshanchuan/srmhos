package com.mediway.hos.srm.business.center.model.entity.project;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;
import com.mediway.hos.srm.business.base.model.entity.BasePO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 中检批次信息表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmProjectMidcheckListInfo对象", description="中检批次信息表")
@TableName("srm_project_midcheck_list_info")
public class SrmProjectMidcheckListInfo extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "项目分类")
    @TableField("proj_type_code")
    private String projTypeCode;

    @ApiModelProperty(value = "中检批次名称")
    @TableField("midcheck_info")
    private String midcheckInfo;

    @ApiModelProperty(value = "开始日期")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="begin_date")
    private LocalDateTime beginDate;

    @ApiModelProperty(value = "结束日期")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="end_date")
    private LocalDateTime endDate;

    @ApiModelProperty(value = "中检状态编号")
    @TableField("midcheck_state")
    private String midcheckState;

    @ApiModelProperty(value = "备注")
    @TableField("note")
    private String note;

    @ApiModelProperty(value = "附件编号")
    @TableField("file_id")
    private String fileId;

    @ApiModelProperty(value = "预警计划编号")
    @TableField("notify_plan")
    private String notifyPlan;


}
