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
 * 文件上传配置
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Fileconfig对象", description="文件上传配置")
@TableName("cf_srm_fileconfig")
public class SrmFileconfig extends BasePO {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "ftp用户名")
    @TableField("ftpusername")
    private String ftpusername;

    @ApiModelProperty(value = "ftp密码")
    @TableField("ftppassword")
    private String ftppassword;
    @ApiModelProperty(value = "ftp端口号")
    @TableField("ftpport")
    private String ftpport;
    @ApiModelProperty(value = "ftpip地址")
    @TableField("ftpip")
    private String ftpip;

    @ApiModelProperty(value = "应用系统")
    @TableField("ftptype")
    private String ftptype;

    @ApiModelProperty(value = "文件存放地址")
    @TableField("ftpsrc")
    private String ftpsrc;

    @ApiModelProperty(value = "ftp类型")
    @TableField("ftpssl")
    private String ftpssl;

    @ApiModelProperty(value = "ftpkkfileview")
    @TableField("ftpkkfile")
    private String ftpkkfile;


}
