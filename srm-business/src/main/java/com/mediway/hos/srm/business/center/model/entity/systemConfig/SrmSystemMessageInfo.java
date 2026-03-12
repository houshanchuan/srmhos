package com.mediway.hos.srm.business.center.model.entity.systemConfig;

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
 * 系统消息表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmSystemMessageInfo对象", description="系统消息表")
@TableName("srm_system_message_info")
public class SrmSystemMessageInfo extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "年度")
    @TableField("year")
    private String year;

    @ApiModelProperty(value = "模块号ID")
    @TableField("sys_no")
    private String sysNo;

    @ApiModelProperty(value = "消息Title")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "消息内容")
    @TableField("message")
    private String message;

    @ApiModelProperty(value = "消息发布者")
    @TableField("sub_user_id")
    private String subUserId;

    @ApiModelProperty(value = "发布时间")
    @TableField("sub_date")
    private LocalDateTime subDate;

    @ApiModelProperty(value = "是否已阅")
    @TableField("is_read")
    private Integer isRead;

    @ApiModelProperty(value = "是否有附件")
    @TableField("is_attachment")
    private Integer isAttachment;


}
