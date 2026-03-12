package com.mediway.hos.srm.business.center.model.vo.academic;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AcConferenceHostVo {
    private Long rowId;
    private String no;
    private CombVo conferenceType;
    private String conferenceTypeName;
    private String name;
    private CombVo year;
    private String yearName;
    private String direction;

    private String subject;
    private Integer numberOfPeople;
    private BigDecimal budgetFundsAmt;
    private String conferenceForm;
    private String onlineUrl;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date openDate;
    private String openTime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date closeDate;
    private String closeTime;
    private CombVo city;
    private String cityName;
    private String address;
    private Integer hostType;
    private Integer isCharge;
    private String chargeManner;
    private String chargeBank;
    private String chargeAccount;
    private String chargeRemark;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date registerStartDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date registerEndDate;
    private String registerManner;
    private String registerUrl;
    private BigDecimal registerFeeAmt;
    private String regFeeRemark;
    private String fapiaoSupplied;
    private String contactPerson;
    private String contactAddress;
    private String contactTel;
    private String contactEmail;
    private String contactWechat;
    private String trafficGuide;
    private String accomGuide;
    private String applicant;
    private Integer dataStatus;
    private CombVo subUserId;
    private String subUserName;
    private String subDate;
    private String subTime;
    private String auditUserId;
    private String auditDate;
    private String auditTime;
    private String auditDesc;
    private String remark;
    private CombVo deptCode;
    private String deptName;
    private CombVo divisionCode;
    private String divisionName;
    private CombVo disciplineClass;
    private String disciplineClassName;
    private CombVo disciplineCode;
    private String disciplineName;
    private Integer paperNum;
    private CombVo fundSource;
    private String fundSourceName;
    private String intro;
    private String operateTime;
    private CombVo hostUnit;
    private String hostUnitName;
    private CombVo assistUnit;
    private String assistUnitName;
    private CombVo conferenceHead;
    private String conferenceHeadName;
    private BigDecimal boardFeeAmt;
    private BigDecimal trafficFeeAmt;
    private BigDecimal siteFeeAmt;
    private BigDecimal bookFeeAmt;
    private BigDecimal otherFeeAmt;
    private BigDecimal accomFeeAmt;
    private String conferencePhone;
    private Integer outnumOfPeople;
    private String travelFlag;
    private String chkResultlist;
    private String creatorId;
    private String creatorName;
    private String createTime;

}
