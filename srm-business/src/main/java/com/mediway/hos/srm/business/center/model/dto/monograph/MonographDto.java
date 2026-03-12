package com.mediway.hos.srm.business.center.model.dto.monograph;

import lombok.Data;

import java.util.List;

@Data
public class MonographDto {
    private MonographDetailDto monographDetailDto;
    private List<MonographAuthorDto> monographAuthors;
}
