package com.mediway.hos.srm.business.center.model.entity.approvalProcess;

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
 * 各业务审批流定义
 * </p>
 *
 * @author 代码生成器
 * @since 2024-08-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="EafFlow对象", description="各业务审批流定义")
@TableName("cf_srm_eaf_flow")
public class SrmEafFlow extends BasePO {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @TableField("sys_type")
    private Integer sysType;

    @TableField("sys_module_id")
    private String sysModuleId;

    @TableField("eaf_main_id")
    private String eafMainId;

    @TableField("serial_no")
    private String serialNo;


}
