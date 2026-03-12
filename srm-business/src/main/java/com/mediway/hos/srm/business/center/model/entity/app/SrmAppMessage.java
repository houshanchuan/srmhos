package com.mediway.hos.srm.business.center.model.entity.app;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.mediway.hos.srm.business.base.model.entity.BasePO;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * APP待办消息
 * </p>
 *
 * @author 代码生成器
 * @since 2025-05-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmAppMessage对象", description="APP待办消息")
@TableName("srm_app_message")
public class SrmAppMessage extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ROWID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "模块号")
    @TableField("sys_no")
    private String sysNo;

    @ApiModelProperty(value = "类型")
    @TableField("type")
    private String type;

    @ApiModelProperty(value = "业务ID")
    @TableField("rec_id")
    private String recId;

    @ApiModelProperty(value = "标题 ")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "内容")
    @TableField("content")
    private String content;

    @ApiModelProperty(value = "备注")
    @TableField("note")
    private String note;

    @ApiModelProperty(value = "生成日期")
    @TableField("create_date")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "审核人字符串")
    @TableField("user_list")
    private String userList;
    @ApiModelProperty(value = "提交人")
    @TableField("submit_user_id")
    private String submitUserId;

    @ApiModelProperty(value = "提交状态")
    @TableField("data_status")
    private Integer dataStatus;

    @ApiModelProperty(value = "实际审核人")
    @TableField("audit_user_id")
    private String auditUserId;

    @ApiModelProperty(value = "审核日期")
    @TableField("audit_date")
    private LocalDateTime auditDate;

    @ApiModelProperty(value = "审核状态")
    @TableField("check_status")
    private Integer checkStatus;

    @ApiModelProperty(value = "删除标志")
    @TableField("is_delete")
    private Integer isDelete;

    @ApiModelProperty(value = "审核意见")
    @TableField("audit_advice")
    private String auditAdvice;

    @ApiModelProperty(value = "当前步骤号")
    @TableField("step_no")
    private String stepNo;

    @ApiModelProperty(value = "院区ID")
    @TableField("hospital_id")
    private String hospitalId;


}
