package com.mediway.hos.srm.business.center.model.entity.project;

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
 * 中检信息表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmProjectMidcheck对象", description="中检信息表")
@TableName("srm_project_midcheck")
public class SrmProjectMidcheck extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "课题项目id")
    @TableField("proj_id")
    private Long projId;
    @ApiModelProperty(value = "系统号")
    @TableField("sys_no")
    private String sysNo;
    @ApiModelProperty(value = "中检信息")
    @TableField("detail")
    private String detail;

    @ApiModelProperty(value = "申请人")
    @TableField("apply")
    private String apply;

    @ApiModelProperty(value = "申请日期")
    @TableField("mid_date")
    private LocalDateTime midDate;

    @ApiModelProperty(value = "审批状态")
    @TableField("midcheck_flag")
    private String midcheckFlag;

    @ApiModelProperty(value = "数据状态")
    @TableField("midcheck_state")
    private String midcheckState;

    @ApiModelProperty(value = "检查意见")
    @TableField("midcheck_opinion")
    private String midcheckOpinion;

    @ApiModelProperty(value = "检查人")
    @TableField("checker")
    private String checker;

    @ApiModelProperty(value = "检查日期")
    @TableField("check_date")
    private LocalDateTime checkDate;

    @ApiModelProperty(value = "检查号")
    @TableField("check_no")
    private String checkNo;

    @ApiModelProperty(value = "中检批次")
    @TableField("midcheck_info_id")
    private Long midcheckInfoId;

    @ApiModelProperty(value = "检查意见2")
    @TableField("midcheck_opinion2")
    private String midcheckOpinion2;
    @ApiModelProperty(value = "检查意见3")
    @TableField("midcheck_opinion3")
    private String midcheckOpinion3;
    @ApiModelProperty(value = "检查意见4")
    @TableField("midcheck_opinion4")
    private String midcheckOpinion4;

}
