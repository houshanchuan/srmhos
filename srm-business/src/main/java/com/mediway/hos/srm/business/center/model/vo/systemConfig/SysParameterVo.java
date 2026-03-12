package com.mediway.hos.srm.business.center.model.vo.systemConfig;

import lombok.Data;

@Data
public class SysParameterVo {
    private Long rowId ;
    private String code ;
    private String name ;
    private String paraValue;
    private String paraType;
    private String paraDesc ;
    private String paraExplain;

}
