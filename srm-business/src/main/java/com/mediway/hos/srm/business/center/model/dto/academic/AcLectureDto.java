package com.mediway.hos.srm.business.center.model.dto.academic;
import lombok.Data;

@Data
public class AcLectureDto {
    private Long rowId;
    private String name;
    private String deptId;
    private String division;
    private String startDate;
    private String endDate;
    private String lecType;
    private String lecLevel;
    private String relatedSubject;
    private String lecturer;
    private String lecturerName;
    private String lecturerUnit;
    private String lecturerDuty;
    private String lecturerTitle;
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
    private String subDate;
    private String subTime;
    // 下面是查询条件
    private int page;
    private int rows;
    private Long userId;
    private String userCode;
    private String auditState;
}
