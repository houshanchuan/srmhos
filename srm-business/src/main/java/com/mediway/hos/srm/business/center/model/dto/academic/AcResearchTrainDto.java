package com.mediway.hos.srm.business.center.model.dto.academic;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AcResearchTrainDto {
    private Long rowId;
    private String title;
    private String name;
    private String checkStatus;
    private String sponsorUnit;
    private String address;
    private String startDate;
    private String endDate;
    private String expectedStartDate;
    private String expectedEndDate;
    private BigDecimal trainNumber;
    private BigDecimal meetingFeeAmt;
    private BigDecimal materialFeeAmt;
    private BigDecimal hotelFeeAmt;
    private BigDecimal trafficFeeAmt;
    private BigDecimal otherFeeAmt;
    private String fundsAccount;
    private String trainCode;
    private String parterId;
    private String parterName;
    private String parterDuty;
    private String parterTitle;
    private String parterDeptId;
    private String parterAccount;
    private String creator;
    private String creatorName;
    private String createTime;
    private String fileIds;
    private String note;
    private String subFlag;
    private String subUserId;
    private String subDate;
    private String subTime;
    // 下面是查询条件
    private int page;
    private int rows;
    private Long userId;
    private String userCode;
    private String auditState;
}
