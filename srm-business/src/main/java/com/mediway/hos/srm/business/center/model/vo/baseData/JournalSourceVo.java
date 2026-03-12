package com.mediway.hos.srm.business.center.model.vo.baseData;

import lombok.Data;

@Data
public class JournalSourceVo {
    private Long rowId;
    private String code;
    private String name;
    private Integer isValid;
    private String journalType;
    private String startYear;
    private String endYear;
    private String note;
    private String journalTypeName;

}
