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
 * 参加会议信息表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmAcMeetingManage对象", description="参加会议信息表")
@TableName("srm_ac_meeting_manage")
public class SrmAcMeetingManage extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "会议编号")
    @TableField("meeting_code")
    private String meetingCode;

    @ApiModelProperty(value = "会议名称")
    @TableField("meeting_name")
    private String meetingName;

    @ApiModelProperty(value = "会议时间")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="meeting_date")
    private LocalDateTime meetingDate;

    @ApiModelProperty(value = "会议地点")
    @TableField("meeting_place")
    private String meetingPlace;

    @ApiModelProperty(value = "参与人员")
    @TableField("participants")
    private String participants;

    @ApiModelProperty(value = "是否大会发言")
    @TableField("is_speech")
    private Integer isSpeech;

    @ApiModelProperty(value = "联系电话")
    @TableField("meeting_phone")
    private String meetingPhone;

    @ApiModelProperty(value = "联系邮箱")
    @TableField("meeting_email")
    private String meetingEmail;

    @ApiModelProperty(value = "科室")
    @TableField("dept_id")
    private String deptId;

    @ApiModelProperty(value = "备注")
    @TableField("note")
    private String note;

    @ApiModelProperty(value = "依托项目")
    @TableField("proj_id")
    private String projId;

    @ApiModelProperty(value = "提交人")
    @TableField("sub_user_id")
    private String subUserId;

    @ApiModelProperty(value = "登记日期")
    @TableField("sub_date")
    private LocalDateTime subDate;

    @ApiModelProperty(value = "提交结果")
    @TableField("data_status")
    private Integer dataStatus;

    @ApiModelProperty(value = "审核结果")
    @TableField("chk_result")
    private String chkResult;

    @ApiModelProperty(value = "审核人")
    @TableField("chk_user_id")
    private String chkUserId;

    @ApiModelProperty(value = "审核日期")
    @TableField("chk_date")
    private LocalDateTime chkDate;

    @ApiModelProperty(value = "审核时间")
    @TableField("chk_time")
    private LocalDateTime chkTime;

    @ApiModelProperty(value = "审核意见")
    @TableField("chk_view")
    private String chkView;

    @ApiModelProperty(value = "发言题目")
    @TableField("speech_topic")
    private String speechTopic;

    @ApiModelProperty(value = "未发言原因")
    @TableField("reason_for_no_speech")
    private String reasonForNoSpeech;

    @ApiModelProperty(value = "院办中层备案")
    @TableField("office_rec_leave")
    private String officeRecLeave;

    @ApiModelProperty(value = "人事审批")
    @TableField("hr_audit_leave")
    private String hrAuditLeave;

    @ApiModelProperty(value = "是否购买公务机票")
    @TableField("is_offic_ticket")
    private Integer isOfficTicket;

    @ApiModelProperty(value = "系统号")
    @TableField("sys_no")
    private String sysNo;

    @ApiModelProperty(value = "会议结束日期")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="meeting_end_date")
    private LocalDateTime meetingEndDate;

    @ApiModelProperty(value = "主办单位")
    @TableField("rely_unit")
    private String relyUnit;

    @ApiModelProperty(value = "会议类型")
    @TableField("meeting_type")
    private String meetingType;

    @ApiModelProperty(value = "创建人")
    @TableField("create_user_id")
    private String createUserId;

    @ApiModelProperty(value = "创建日期")
    @TableField("create_date")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "教研室编号")
    @TableField("division_code")
    private String divisionCode;

    @ApiModelProperty(value = "学科门类")
    @TableField("classCode")
    private String classCode;

    @ApiModelProperty(value = "论文题目")
    @TableField("paper_name")
    private String paperName;

    @ApiModelProperty(value = "报告题目")
    @TableField("report_name")
    private String reportName;

    @ApiModelProperty(value = "备注")
    @TableField("intro")
    private String intro;

    @ApiModelProperty(value = "操作时间")
    @TableField("operate_time")
    private LocalDateTime operateTime;

    @ApiModelProperty(value = "附件ID")
    @TableField("file_ids")
    private String fileIds;

    @ApiModelProperty(value = "会议次数")
    @TableField("times_this_year")
    private Integer timesThisYear;

    @ApiModelProperty(value = "工号")
    @TableField("account_code")
    private String accountCode;

    @ApiModelProperty(value = "职称")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "职务名称")
    @TableField("duty_desc")
    private String dutyDesc;

    @ApiModelProperty(value = "兼职职务名称")
    @TableField("parttime_desc")
    private String parttimeDesc;

    @ApiModelProperty(value = "参会身份")
    @TableField("attendance_status")
    private String attendanceStatus;

    @ApiModelProperty(value = "预计起始日期")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="expected_begin_date")
    private LocalDateTime expectedBeginDate;

    @ApiModelProperty(value = "预计结束日期")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="expected_end_date")
    private LocalDateTime expectedEndDate;

    @ApiModelProperty(value = "差旅起始日期")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="trvl_begin_date")
    private LocalDateTime trvlBeginDate;

    @ApiModelProperty(value = "差旅结束日期")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="trvl_end_date")
    private LocalDateTime trvlEndDate;
    @ApiModelProperty(value = "参会身份")
    @TableField("meeting_position")
    private String meetingPosition;
    @ApiModelProperty(value = "其他参会身份")
    @TableField("other_position_desc")
    private String otherPositionDesc;

    @ApiModelProperty(value = "会务费")
    @TableField("meeting_fee_amt")
    private BigDecimal meetingFeeAmt;

    @ApiModelProperty(value = "资料费")
    @TableField("materials_fee_amt")
    private BigDecimal materialsFeeAmt;

    @ApiModelProperty(value = "住宿费")
    @TableField("hotel_fee_amt")
    private BigDecimal hotelFeeAmt;

    @ApiModelProperty(value = "交通费")
    @TableField("traffic_fee_amt")
    private BigDecimal trafficFeeAmt;

    @ApiModelProperty(value = "其他费用")
    @TableField("other_fee_amt")
    private BigDecimal otherFeeAmt;

    @ApiModelProperty(value = "资助经费账号")
    @TableField("fund_account")
    private String fundAccount;

    @ApiModelProperty(value = "创建人姓名")
    @TableField("creator_name")
    private String creatorName;

    @ApiModelProperty(value = "审核状态")
    @TableField("check_status")
    private String checkStatus;

    @ApiModelProperty(value = "主办单位名称")
    @TableField("rely_unit_name")
    private String relyUnitName;



}
