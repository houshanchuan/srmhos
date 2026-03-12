package com.mediway.hos.srm.business.center.model.vo.monograph;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import lombok.Data;

import com.mediway.hos.srm.business.base.model.entity.BasePO;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class MonographVo extends BasePO {
    private Long rowId;
    private String subUser;
    private CombVo yearField;
    private String yearId;
    private String yearName;
    private String nameField;
    private CombVo deptLocField;
    private String deptLocId;
    private String deptLocName;
    private String subUserId;
    private String subUserName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date subDate;
    private CombVo unittypeField;
    private String unitTypeId;
    private String unitTypeName;
    private String pubTime;
    private String isbn;
    private CombVo subjectCatField;
    private String subjectCatId;
    private String subjectCatName;
    private CombVo pubPlaceField;
    private String pubPlaceId;
    private String pubPlaceName;
    private String cip;
    private CombVo firstSubjectField;
    private String firstSubjectId;
    private String firstSubjectName;
    private CombVo pressField;
    private String pressId;
    private String pressName;
    private CombVo prjNameField;
    private String projectId;
    private String projectName;
    private CombVo secSubjectField;
    private String secSubjectId;
    private String secSubjectName;
    private CombVo pressLevel;
    private String pressLevelId;
    private String pressLevelName;
    private CombVo languageField;
    private String languageId;
    private String languageName;
    private CombVo thirdSubjectField;
    private String thirdSubjectId;
    private String thirdSubjectName;
    private String pressAdd;
    private Integer completeUnit;
    private CombVo projectSource;
    private String projectSourceId;
    private String projectSourceName;
    private String publishFreqField;
    private String hospsignature;
    private BigDecimal totalNum;
    private Integer printNum;
    private Integer transferFlag;
    private String remarkField;
    ///出版地名称
    private String pubAddressTypeName;
    private Integer dataStatus;
    private String checkList;
    private String authorNameList;
    private int page;
    private int rows;



}
