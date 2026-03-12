package com.mediway.hos.srm.business.center.model.vo.academic;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import lombok.Data;

import java.util.Date;

@Data
public class AcLectureVo {
    private Long rowId;
    private String name;
    private CombVo deptId;
    private String deptName;
    private CombVo division;
    private String divisionName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private CombVo lecType;
    private String lecTypeName;
    private CombVo lecLevel;
    private String lecLevelName;
    private CombVo relatedSubject;
    private String relatedSubjectName;
    private CombVo lecturer;
    private String lecturerName;
    private CombVo lecturerUnit;
    private String lecturerUnitName;
    private String lecturerDuty;

    private CombVo lecturerTitle;
    private String lecturerTitleName;
    private String lecturerInfo;
    private String lecAddress;
    private String lecturerListener;
    private Integer listenersNum;
    private String compere;
    private String commend;
    private String checkStatus;
    private String intro;
    private String operateTime;
    private String creatorId;
    private String creatorName;
    private String createTime;
    private String subFlag;
    private String subUserId;
    private String subUserName;
    private String subDate;
    private String subTime;
    private String chkResultlist;
}
