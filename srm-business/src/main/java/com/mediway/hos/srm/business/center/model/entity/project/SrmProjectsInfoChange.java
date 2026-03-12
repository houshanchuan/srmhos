package com.mediway.hos.srm.business.center.model.entity.project;

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
 * 项目变更
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmProjectsInfoChange对象", description="项目变更")
@TableName("srm_projects_info_change")
public class SrmProjectsInfoChange extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "项目DR ")
    @TableField("proj_id")
    private Long projId;

    @ApiModelProperty(value = "初始项目名称")
    @TableField("init_proj_name")
    private String initProjName;

    @ApiModelProperty(value = "初始项目负责人")
    @TableField("init_head_name")
    private String initHeadName;

    @ApiModelProperty(value = "初始项目状态")
    @TableField("init_proj_status")
    private String initProjStatus;

    @ApiModelProperty(value = "变更内容代码 ")
    @TableField("changeitem")
    private String changeitem;

    @ApiModelProperty(value = "变更前")
    @TableField("old_value")
    private String oldValue;

    @ApiModelProperty(value = "变更后")
    @TableField("new_value")
    private String newValue;

    @ApiModelProperty(value = "变更原因代码 ")
    @TableField("reason")
    private String reason;

    @ApiModelProperty(value = "变更说明")
    @TableField("intro")
    private String intro;

    @ApiModelProperty(value = "提交状态")
    @TableField("data_status")
    private Integer dataStatus;

    @ApiModelProperty(value = "提交人")
    @TableField("sub_user_id")
    private String subUserId;

    @ApiModelProperty(value = "提交日期")
    @TableField("sub_date")
    private LocalDateTime subDate;

    @ApiModelProperty(value = "审核状态")
    @TableField("check_status")
    private String checkStatus;

    @ApiModelProperty(value = "最后审核人")
    @TableField("check_user_id")
    private String checkUserId;

    @ApiModelProperty(value = "最后审核日期")
    @TableField("check_date")
    private String checkDate;

    @ApiModelProperty(value = "项目变更号")
    @TableField("serial_no")
    private String serialNo;

    @ApiModelProperty(value = "创建人")
    @TableField("creator")
    private String creator;

    @ApiModelProperty(value = "创建人姓名")
    @TableField("creator_name")
    private String creatorName;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "操作时间")
    @TableField("operate_time")
    private LocalDateTime operateTime;

    @ApiModelProperty(value = "系统ID")
    @TableField("sys_no")
    private String sysNo;

    @ApiModelProperty(value = "备注")
    @TableField("note")
    private String note;

    @ApiModelProperty(value = "变更前描述")
    @TableField("old_value_desc")
    private String oldValueDesc;

    @ApiModelProperty(value = "变更后描述")
    @TableField("new_value_desc")
    private String newValueDesc;


}
