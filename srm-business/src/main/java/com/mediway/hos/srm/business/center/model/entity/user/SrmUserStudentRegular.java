package com.mediway.hos.srm.business.center.model.entity.user;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.mediway.hos.srm.business.base.model.entity.BasePO;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 学生转正表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmUserStudentRegular对象", description="学生转正表")
@TableName("srm_user_student_regular")
public class SrmUserStudentRegular extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ROWID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "编号")
    @TableField("no")
    private String no;

    @ApiModelProperty(value = "变更人代码")
    @TableField("person_code")
    private String personCode;

    @ApiModelProperty(value = "变更从..")
    @TableField("person_type_from")
    private String personTypeFrom;

    @ApiModelProperty(value = "变更到..")
    @TableField("person_type_to")
    private String personTypeTo;

    @ApiModelProperty(value = "工作科室")
    @TableField("dept_work")
    private String deptWork;

    @ApiModelProperty(value = "工作岗位")
    @TableField("job_type")
    private String jobType;

    @ApiModelProperty(value = "工号")
    @TableField("account")
    private String account;

    @ApiModelProperty(value = "数据状态")
    @TableField("data_status")
    private Integer dataStatus;

    @ApiModelProperty(value = "审核状态")
    @TableField("check_status")
    private String checkStatus;

    @ApiModelProperty(value = "操作人")
    @TableField("operator_code")
    private String operatorCode;

    @ApiModelProperty(value = "操作日期")
    @TableField("operate_date")
    private LocalDateTime operateDate;

    @ApiModelProperty(value = "操作时间")
    @TableField("operate_time")
    private LocalDateTime operateTime;

    @ApiModelProperty(value = "备注")
    @TableField("note")
    private String note;


}
