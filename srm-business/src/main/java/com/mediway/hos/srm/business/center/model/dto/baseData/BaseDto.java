package com.mediway.hos.srm.business.center.model.dto.baseData;

import com.mediway.hos.app.core.util.SecurityUtils;
import com.mediway.hos.security.core.userdetails.HosUser;
import lombok.Data;
import java.util.List;

@Data
public class BaseDto {
    private List<Long> idList;
    private Long id;
    private String userId;
    private String rowStr;
    private String auditStatus;
    private String view;
    private String sysNo;
    private String name;
    private String queryName;
    private String upCode;
    //
    private int page;
    private int rows;
    private int limit;
}
