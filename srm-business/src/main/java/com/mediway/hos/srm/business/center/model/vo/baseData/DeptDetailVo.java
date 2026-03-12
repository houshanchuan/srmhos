package com.mediway.hos.srm.business.center.model.vo.baseData;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class DeptDetailVo {
    private Long id;
    private String deptCode;
    private String deptName;
    private String deptType;
    private String deptTypename;
    private Integer isValid;
    private String isValidName;
    private String deptClass;
    private String deptClassName;
    private  Integer isAuDeptFlag;
    private String isAuDeptFlagName;
    private String comp;
    private String compName;
    private String discipline;
    private String disciplineName;
    private Integer isResearch;
    private String isResearchName;
    private  String creator;
    private  String creatorName;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date StartDatetime;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date EndDatetime;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDatetime;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date operateDatetime;
}
