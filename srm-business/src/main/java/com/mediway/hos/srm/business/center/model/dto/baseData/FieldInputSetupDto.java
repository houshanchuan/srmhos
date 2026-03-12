package com.mediway.hos.srm.business.center.model.dto.baseData;

import lombok.Data;

@Data
public class FieldInputSetupDto {
    private Long rowId;
    private String sysNo;
    private String fieldId;
    private String fieldLabel;
    private Integer isRequired;
    private String udfFieldLabel;
    private String fieldName;
    private Integer wanYuanFlag;
    private String appFieldName;
}
