package com.mediway.hos.srm.business.center.model.entity.academic;

import com.baomidou.mybatisplus.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.mediway.hos.srm.business.base.model.entity.BasePO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 科研培训表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmAcResearchTrain对象", description="科研培训表")
@TableName("srm_ac_research_train")
public class SrmAcResearchTrain extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "培训主题")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "科研培训名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "审核状态")
    @TableField("check_status")
    private String checkStatus;

    @ApiModelProperty(value = "主办单位")
    @TableField("sponsor_unit")
    private String sponsorUnit;

    @ApiModelProperty(value = "培训地点")
    @TableField("address")
    private String address;

    @ApiModelProperty(value = "培训开始时间")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="start_date")
    private LocalDateTime startDate;

    @ApiModelProperty(value = "培训结束时间")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="end_date")
    private LocalDateTime endDate;

    @ApiModelProperty(value = "预计差旅开始时间")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="expected_start_date")
    private LocalDateTime expectedStartDate;

    @ApiModelProperty(value = "预计差旅结束时间")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="expected_end_date")
    private LocalDateTime expectedEndDate;

    @ApiModelProperty(value = "培训次数")
    @TableField("train_number")
    private BigDecimal trainNumber;

    @ApiModelProperty(value = "会务费")
    @TableField("meeting_fee_amt")
    private BigDecimal meetingFeeAmt;

    @ApiModelProperty(value = "资料费")
    @TableField("material_fee_amt")
    private BigDecimal materialFeeAmt;

    @ApiModelProperty(value = "住宿费")
    @TableField("hotel_fee_amt")
    private BigDecimal hotelFeeAmt;

    @ApiModelProperty(value = "交通费")
    @TableField("traffic_fee_amt")
    private BigDecimal trafficFeeAmt;

    @ApiModelProperty(value = "其他")
    @TableField("other_fee_amt")
    private BigDecimal otherFeeAmt;

    @ApiModelProperty(value = "资助经费账号")
    @TableField("funds_account")
    private String fundsAccount;

    @ApiModelProperty(value = "培训编号(年度)")
    @TableField("train_code")
    private String trainCode;

    @ApiModelProperty(value = "参会人ID")
    @TableField("parter_id")
    private String parterId;

    @ApiModelProperty(value = "参会人姓名")
    @TableField("parter_name")
    private String parterName;

    @ApiModelProperty(value = "职务")
    @TableField("parter_duty")
    private String parterDuty;

    @ApiModelProperty(value = "职称")
    @TableField("parter_title")
    private String parterTitle;

    @ApiModelProperty(value = "所属科室")
    @TableField("parter_dept_id")
    private String parterDeptId;

    @ApiModelProperty(value = "工号")
    @TableField("parter_account")
    private String parterAccount;

    @ApiModelProperty(value = "创建人")
    @TableField("creator")
    private String creator;

    @ApiModelProperty(value = "创建人姓名")
    @TableField("creator_name")
    private String creatorName;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "附件信息")
    @TableField("file_ids")
    private String fileIds;

    @ApiModelProperty(value = "备注")
    @TableField("note")
    private String note;

    @ApiModelProperty(value = "提交状态")
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
