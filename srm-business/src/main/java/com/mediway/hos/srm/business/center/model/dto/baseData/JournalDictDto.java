package com.mediway.hos.srm.business.center.model.dto.baseData;


import lombok.Data;
import com.mediway.hos.srm.business.base.model.entity.BasePO;

@Data
public class JournalDictDto extends BasePO {
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
