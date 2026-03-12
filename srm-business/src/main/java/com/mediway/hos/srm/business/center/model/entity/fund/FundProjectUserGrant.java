package com.mediway.hos.srm.business.center.model.entity.fund;

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
 * 项目授权分析
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="FundProjectUserGrant对象", description="项目授权分析")
@TableName("cf_fund_project_user_grant")
public class FundProjectUserGrant extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "授权类型")
    @TableField("exp_type")
    private String expType;

    @ApiModelProperty(value = "项目性质")
    @TableField("project_type")
    private String projectType;

    @ApiModelProperty(value = "项目")
    @TableField("project_id")
    private String projectId;

    @ApiModelProperty(value = "授权用户")
    @TableField("user_id")
    private String userId;

    @ApiModelProperty(value = "授权可用")
    @TableField("is_granted")
    private Integer isGranted;


}
