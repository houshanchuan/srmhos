package com.mediway.hos.srm.business.center.model.dto.baseData;


import lombok.Data;
import com.mediway.hos.srm.business.base.model.entity.BasePO;

@Data
public class JournalSourceDto extends BasePO {
    private Long rowId;
    private String journalType;
    private String code;
    private String name;
    private String startYear;
    private String endYear;
    private String note;
    private Integer isValid;

}
