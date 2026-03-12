package com.mediway.hos.srm.business.center.model.dto.monograph;

import lombok.Data;
import com.mediway.hos.srm.business.base.model.entity.BasePO;

import java.math.BigDecimal;

@Data
public class MonographDetailDto extends BasePO {
    //@JsonProperty(value = "RowId")
    private Long rowId;
    private String subUser;
    private String yearField;
    private String nameField;
    private String deptLocField;
    private String unittypeField;
    private String pubTime;
    private String isbn;
    private String subjectCatField;
    private String pubPlaceField;
    private String cip;
    private String firstSubjectField;
    private String pressField;
    private String prjNameField;
    private String secSubjectField;

    private String pressLevel;
    private String languageField;
    private String thirdSubjectField;
    private String pressAdd;
    private Integer completeUnit;
    private String projectSource;
    private String publishFreqField;
    private String hospsignature;

    private BigDecimal totalNum;
    private Integer printNum;
    private Integer transferFlag;

    private String remarkField;
    private String editor;
    private Long userId;
    private String userCode;
    private String startDate;
    private String endDate;
    private String auditState;
}
