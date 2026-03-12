package com.mediway.hos.srm.business.center.model.entity.baseData;

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
 * 字段输入属性设置
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="FieldInputSetup对象", description="字段输入属性设置")
@TableName("cf_srm_field_input_setup")
public class SrmFieldInputSetup extends BasePO {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @TableField("sys_no")
    private String sysNo;

    @TableField("field_id")
    private String fieldId;

    @TableField("field_label")
    private String fieldLabel;

    @TableField("is_required")
    private Integer isRequired;

    @TableField("udf_field_label")
    private String udfFieldLabel;

    @TableField("field_name")
    private String fieldName;

    @TableField("wanYuanFlag")
    private Integer wanYuanFlag;

    @TableField("appFieldName")
    private String appFieldName;


}
