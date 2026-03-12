package com.mediway.hos.srm.business.center.model.dto.academic;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AcMeetingManageDto extends BaseDto {
    private Long rowId; //RowId
    private String meetingCode;//会议编号
    private String meetingName; //会议名称
    private String meetingDate;   //会议时间
    private String meetingPlace;   //会议地点
    private String participants;   //参与人员
    private Integer isSpeech;  //是否大会发言
    private String meetingPhone;  //联系电话
    private String meetingEmail;   // 联系邮箱
    private String deptId; //科室
    private String meetingPosition;
    private String note; //备注
     private String projId;   //依托项目;
    private String subUserId;  //提交人
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String subDate;   //登记日期
    private Integer dataStatus;  //提交结果
    private String chkResult;   //审核结果;
    private String chkUserId;  // 审核人
    private String chkDate; //审核日期
    private String chkTime; //审核时间
    private String chkView; //审核意见
    private String speechTopic;  //发言题目
    private String reasonForNoSpeech;  //未发言原因
    private String officeRecLeave;   //院办中层备案
    private String hrAuditLeave; //人事审批
    private Integer isOfficTicket;   //是否购买公务机票
    private String sysNo;  //系统号
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String meetingEndDate;  //会议结束日期
    private String relyUnit; //主办单位
    private String meetingType; //会议类型
    private String meetingTypeName;
    private String createUserId;//创建人
    private String createDate; //创建日期
    private String divisionCode; //教研室编号
    private String classCode; //学科门类编码
    private String className; //学科门类名称
    private String paperName;  //论文题目
    private String reportName;//报告题目
    private String intro;   //介绍
    private String  operateTime;  //操作时间
    private String fileIds; //附件ID
    private Integer timesThisYear;  // 会议次数
    private String accountCode;  // 工号
    private String title; //职称
    private String dutyDesc; //职务名称
    private String parttimeDesc;// 兼职职务名称
    private String attendanceStatus;   // 参会身份
    private String expectedBeginDate;  //预计起始日期
    private String  expectedEndDate;// 预计结束日期
    private String trvlBeginDate;  // 差旅起始日期
    private String trvlEndDate; // 差旅结束日期
    private String otherPositionDesc; // 其他参会身份
    private BigDecimal  meetingFeeAmt; // 会务费
    private BigDecimal materialsFeeAmt;  // 资料费
    private BigDecimal hotelFeeAmt;//  住宿费
    private BigDecimal trafficFeeAmt;  //交通费
    private BigDecimal otherFeeAmt;  //其他费用
    private String fundAccount;// 资助经费账号
    private String creatorName;//创建人姓名
    private String checkStatus;   //审核状态
    private String relyUnitName; //主办单位名称
}
