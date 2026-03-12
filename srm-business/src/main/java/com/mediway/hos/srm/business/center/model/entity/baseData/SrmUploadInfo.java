package com.mediway.hos.srm.business.center.model.entity.baseData;

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
 * 上传信息表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UploadInfo对象", description="上传信息表")
@TableName("srm_upload_info")
public class SrmUploadInfo extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "业务数据表RowId")
    @TableField("rec_id")
    private String recId;

    @ApiModelProperty(value = "系统编号")
    @TableField("sys_no")
    private String sysNo;

    @ApiModelProperty(value = "文件名称")
    @TableField("file_name")
    private String fileName;

    @ApiModelProperty(value = "上传人")
    @TableField("sub_user_id")
    private String subUserId;

    @ApiModelProperty(value = "上传日期")
    @TableField("sub_date")
    private String subDate;

    @ApiModelProperty(value = "文件链接URL")
    @TableField("file_url")
    private String fileUrl;

    @ApiModelProperty(value = "附件类型描述RowId")
    @TableField("appx_file_type")
    private String appxFileType;

    @ApiModelProperty(value = "Size")
    @TableField("file_size")
    private String fileSize;

    @ApiModelProperty(value = "文件类型（doc,xls,pdf...)")
    @TableField("file_type")
    private String fileType;

    @ApiModelProperty(value = "ID")
    @TableField("serial_id")
    private String serialId;

    @ApiModelProperty(value = "备注")
    @TableField("note")
    private String note;

    @ApiModelProperty(value = "系统文件id")
    @TableField("sys_file_id")
    private String sysFileId;


}
