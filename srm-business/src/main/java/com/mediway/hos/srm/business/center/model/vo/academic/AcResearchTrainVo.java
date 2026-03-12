package com.mediway.hos.srm.business.center.model.vo.academic;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AcResearchTrainVo {
    private Long rowId;
    private String title;
    private String name;
    private String checkStatus;
    private CombVo sponsorUnit;
    private String sponsorUnitName;
    private String address;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
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
    private CombVo parterId;
    private String parterName;
    private String parterDuty;
    private CombVo parterTitle;
    private String parterTitleName;
    private CombVo parterDeptId;
    private String parterDeptName;
    private String parterAccount;
    private String creator;
    private String creatorName;
    private String createTime;
    private String fileIds;
    private String note;
    private String subFlag;
    private String subUserId;
    private String subUserName;
    private String subDate;
    private String subTime;
    private String chkResultlist;
}
