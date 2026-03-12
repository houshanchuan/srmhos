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
 * 预算项目授权
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="FundProjectUserAuth对象", description="预算项目授权")
@TableName("cf_fund_project_user_auth")
public class FundProjectUserAuth extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "rowid")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "项目id")
    @TableField("project_id")
    private String projectId;

    @ApiModelProperty(value = "用户id")
    @TableField("user_id")
    private String userId;

    @ApiModelProperty(value = "提交标志")
    @TableField("is_submit")
    private Integer isSubmit;

    @ApiModelProperty(value = "审核标志")
    @TableField("is_audit")
    private Integer isAudit;


}
