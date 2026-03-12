package com.mediway.hos.srm.business.center.model.vo.paper;

import lombok.Data;

@Data
public class PaperSubmissionAuditorVo {
    private Long rowId;
    private String expert;
    private String expertList;
    private String account;
    private String name;
    private String expertGroupName;
}
