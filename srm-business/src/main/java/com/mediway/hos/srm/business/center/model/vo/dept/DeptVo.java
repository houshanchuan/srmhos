package com.mediway.hos.srm.business.center.model.vo.dept;

import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import lombok.Data;

@Data
public class DeptVo {
    private String rowId;
    private String code;
    private String name;
    private CombVo deptType;
    private String deptTypeName;
    private Integer isValid;
    private CombVo deptLevel;
    private String deptLevelName;
    private CombVo superDeptId;
    private String superDeptName;
    private Integer isAccounting;
    private CombVo hospital;
    private String hospitalName;
    private CombVo disciplineCode;
    private String disciplineName;
    private Integer isResearch;
    private String creatorNo;
    private String creatorName;
    private String createDate;
    private String operateTime;
    private String alias;
    private String hrId;
    private CombVo director;
    private Integer isBudg;
    private Integer isItem;
    private Integer isLast;
    private String administrator;
}

