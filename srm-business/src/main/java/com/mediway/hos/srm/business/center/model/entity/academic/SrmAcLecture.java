package com.mediway.hos.srm.business.center.model.entity.academic;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import com.mediway.hos.srm.business.base.model.entity.BasePO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 学术讲座
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmAcLecture对象", description="学术讲座")
@TableName("srm_ac_lecture")
public class SrmAcLecture extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ROWID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "讲座名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "所属科室")
    @TableField("dept_id")
    private String deptId;

    @ApiModelProperty(value = "教研室编号")
    @TableField("division")
    private String division;

    @ApiModelProperty(value = "讲座日期")
    @TableField(updateStrategy = FieldStrategy.NOT_NULL,value="start_date")
    private LocalDateTime startDate;

    @ApiModelProperty(value = "讲座日期")
    @TableField(updateStrategy = FieldStrategy.NOT_NULL,value="end_date")
    private LocalDateTime endDate;

    @ApiModelProperty(value = "讲座类型")
    @TableField("lec_type")
    private String lecType;

    @ApiModelProperty(value = "讲座级别")
    @TableField("lec_level")
    private String lecLevel;

    @ApiModelProperty(value = "相关学科")
    @TableField("related_subject")
    private String relatedSubject;

    @ApiModelProperty(value = "主讲人")
    @TableField("lecturer")
    private String lecturer;

    @ApiModelProperty(value = "主讲人姓名")
    @TableField("lecturer_name")
    private String lecturerName;

    @ApiModelProperty(value = "主讲人单位")
    @TableField("lecturer_unit")
    private String lecturerUnit;

    @ApiModelProperty(value = "主讲人职务")
    @TableField("lecturer_duty")
    private String lecturerDuty;

    @ApiModelProperty(value = "主讲人职称")
    @TableField("lecturer_title")
    private String lecturerTitle;

    @ApiModelProperty(value = "主讲人信息")
    @TableField("lecturer_info")
    private String lecturerInfo;

    @ApiModelProperty(value = "讲座地点Property")
    @TableField("lec_address")
    private String lecAddress;

    @ApiModelProperty(value = "讲座对象Property")
    @TableField("lecturer_listener")
    private String lecturerListener;

    @ApiModelProperty(value = "参加人数")
    @TableField("listeners_num")
    private Integer listenersNum;

    @ApiModelProperty(value = "主持人")
    @TableField("compere")
    private String compere;

    @ApiModelProperty(value = "嘉宾")
    @TableField("commend")
    private String commend;

    @ApiModelProperty(value = "审核状态")
    @TableField("check_status")
    private String checkStatus;

    @ApiModelProperty(value = "简介")
    @TableField("intro")
    private String intro;

    @ApiModelProperty(value = "操作时间")
    @TableField("operate_time")
    private LocalDateTime operateTime;

    @ApiModelProperty(value = "记录创建人编号")
    @TableField("creator_id")
    private String creatorId;

    @ApiModelProperty(value = "记录创建人名称")
    @TableField("creator_name")
    private String creatorName;

    @ApiModelProperty(value = "记录创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "提交状态0")
    @TableField("sub_flag")
    private String subFlag;

    @ApiModelProperty(value = "提交人")
    @TableField("sub_user_id")
    private String subUserId;

    @ApiModelProperty(value = "提交日期")
    @TableField("sub_date")
    private LocalDateTime subDate;

    @ApiModelProperty(value = "提交时间")
    @TableField("sub_time")
    private LocalDateTime subTime;


}
