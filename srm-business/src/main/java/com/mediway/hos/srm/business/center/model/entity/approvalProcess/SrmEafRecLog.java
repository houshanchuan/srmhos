package com.mediway.hos.srm.business.center.model.entity.approvalProcess;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.mediway.hos.srm.business.base.model.entity.BasePO;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 审批记录日志
 * </p>
 *
 * @author 代码生成器
 * @since 2024-08-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="EafRecLog对象", description="审批记录日志")
@TableName("cf_srm_eaf_rec_log")
public class SrmEafRecLog extends BasePO {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @TableField("eaf_rec_id")
    private String eafRecId;

    @TableField("sys_module_id")
    private String sysModuleId;

    @TableField("check_rec_id")
    private Long checkRecId;

    @TableField("check_proc_desc")
    private String checkProcDesc;

    @TableField("check_user")
    private String checkUser;

    @TableField("dept")
    private String dept;

    @TableField("check_time")
    private LocalDateTime checkTime;

    @TableField("check_desc")
    private String checkDesc;

    @TableField("check_result")
    private String checkResult;


}
