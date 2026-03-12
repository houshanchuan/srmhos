package com.mediway.hos.srm.business.center.model.dto.common;

import lombok.Data;

@Data
public class GridColSetRowDto {
    private Long rowId;
    private String header;
    private String name;
    private Integer width;
    private String align;
    private String enterSort;
    private Integer hidden;
    private Integer necessary;
    private Integer frozen;
}
