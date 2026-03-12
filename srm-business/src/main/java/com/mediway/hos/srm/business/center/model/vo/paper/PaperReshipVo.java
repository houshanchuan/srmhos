package com.mediway.hos.srm.business.center.model.vo.paper;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class PaperReshipVo {
    private Long rowId;
    private Long paperId;
    private String reshipId;
    private String reshipName;
    private String reshipType;
    private String reshipTypeName;
    private String reshipDate;
    private LocalDateTime createTime;
    private String creatorCode;
    private String creatorId;
    private String note;
}
