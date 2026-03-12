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
 * 
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmFtpInfoConfig对象", description="")
@TableName("cf_srm_ftp_info_config")
public class SrmFtpInfoConfig extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ROWID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @TableField("ftp_user")
    private String ftpUser;

    @TableField("ftp_password")
    private String ftpPassword;

    @TableField("ftp_ip")
    private String ftpIp;

    @TableField("ftp_desc")
    private String ftpDesc;

    @TableField("ftp_type")
    private Integer ftpType;

    @TableField("ftp_src")
    private String ftpSrc;

    @TableField("ftp_ssl")
    private String ftpSsl;

    @TableField("kk_file_view_flag")
    private String kkFileViewFlag;


}
