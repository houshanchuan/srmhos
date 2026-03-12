package com.mediway.hos.srm.business.center.model.entity.dept;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.mediway.hos.srm.business.base.model.entity.BasePO;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 组织关系定义
 * </p>
 *
 * @author 代码生成器
 * @since 2024-08-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="DeptUser对象", description="组织关系定义")
@TableName("ct_srm_dept_user")
public class SrmDeptUser extends BasePO {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @TableField("dept")
    private String dept;

    @TableField("user")
    private String user;

    @TableField("is_director")
    private Integer isDirector;

    @TableField("superiors")
    private Long superiors;

    @TableField("is_valid")
    private Integer isValid;

    @TableField("is_secretary")
    private Integer isSecretary;


}
