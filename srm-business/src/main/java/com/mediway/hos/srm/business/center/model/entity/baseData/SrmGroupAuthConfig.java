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
@ApiModel(value="SrmGroupAuthConfig对象", description="")
@TableName("cf_srm_group_auth_config")
public class SrmGroupAuthConfig extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ROWID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "安全组")
    @TableField("group_id")
    private String groupId;

    @ApiModelProperty(value = "维护用户")
    @TableField("maint_all_user")
    private String maintAllUser;

    @ApiModelProperty(value = "数据更新")
    @TableField("data_modify")
    private String dataModify;

    @ApiModelProperty(value = "工作台权限")
    @TableField("workbench_permissions")
    private String workbenchPermissions;

    @ApiModelProperty(value = "页面必填项设置")
    @TableField("req_fields_setup")
    private String reqFieldsSetup;


}
