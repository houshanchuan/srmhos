package com.mediway.hos.srm.business.center.model.vo.dept;

import lombok.Data;

@Data
public class DeptUserVo {
    private Long id;
    private Long rowId;
    private String dept;
    private String userId;
    private Integer isDirector;
    private Long superiors;
    private Integer isValid;
    private Integer isSecretary;
}
