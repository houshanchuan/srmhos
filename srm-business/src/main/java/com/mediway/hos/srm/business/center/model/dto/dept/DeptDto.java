package com.mediway.hos.srm.business.center.model.dto.dept;

import lombok.Data;
import com.mediway.hos.srm.business.base.model.entity.BasePO;

@Data
public class DeptDto extends BasePO {
    private String rowId;
    private String code;
    private String name;
    private String deptType;
    private Integer isValid;
    private Integer deptLevel;
    private String superDeptId;
    private Integer isAccounting;
    private String hospital;
    private String disciplineCode;
    private Integer isResearch;
    private String creatorNo;
    private String createDate;
    private String operateTime;
    private String alias;
    private String hrId;
    private String director;
    private Integer isBudg;
    private Integer isItem;
    private Integer isLast;
    private String administrator;
    private String userCode;

}
