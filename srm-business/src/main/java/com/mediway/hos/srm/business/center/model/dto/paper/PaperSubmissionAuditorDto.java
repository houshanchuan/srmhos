package com.mediway.hos.srm.business.center.model.dto.paper;
import lombok.Data;

@Data
public class PaperSubmissionAuditorDto {
    private Long rowId;
    private String sysNo;
    private String appRowId;
    private String expertList;
    private String ethicExpertList;
    private String expert;
    private String journalType;
}
