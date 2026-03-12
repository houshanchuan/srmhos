package com.mediway.hos.srm.business.center.model.dto.baseData;

import lombok.Data;

import java.util.List;
@Data
public class BaseSrmDTO {
    private List<String> idList;
    private String userId;
    private String id;
    private String rowStr;
    private String userCode;
    private String auditStatus;
    private String view;
    private String sysNo;
    //
    private int page;
    private int rows;
}
