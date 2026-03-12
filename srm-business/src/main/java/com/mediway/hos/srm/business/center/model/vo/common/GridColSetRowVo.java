package com.mediway.hos.srm.business.center.model.vo.common;

import lombok.Data;

@Data
public class GridColSetRowVo {
    private Long rowId;
    private String header;
    private String name;
    private Integer width;
    private String align;
    private Integer enterSort;
    private Integer hidden;
    private Integer necessary;
    private Integer frozen;
}
