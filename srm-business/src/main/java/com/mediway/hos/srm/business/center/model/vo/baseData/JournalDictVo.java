package com.mediway.hos.srm.business.center.model.vo.baseData;

import lombok.Data;

@Data
public class JournalDictVo {
    private Long rowId;
    private String code;
    private String name;
    private Integer isValid;
    private String issnCode;
    private String cnCode;
    private String source;
    private String publishCycle;
    private String mailingCode;
    private String responsibleUnitName;
    private String factor;
    private String eissnCode;
    private String jcr;
    private String alias;

}
