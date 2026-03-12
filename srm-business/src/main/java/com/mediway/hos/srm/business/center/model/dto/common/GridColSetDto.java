package com.mediway.hos.srm.business.center.model.dto.common;

import lombok.Data;

import java.util.List;

@Data
public class GridColSetDto {
    private GridColSetMainDto gridColSetMainDto;
    private List<GridColSetRowDto> gridColSetRowDtoList;
}
