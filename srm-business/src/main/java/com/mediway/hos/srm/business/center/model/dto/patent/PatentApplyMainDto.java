package com.mediway.hos.srm.business.center.model.dto.patent;

import com.mediway.hos.srm.business.center.model.dto.baseData.UnitPeronDto;
import lombok.Data;

import java.util.List;

@Data
public class PatentApplyMainDto {
    private PatentApplyDto patentApplyDto;
    private List<PatentApplyAuthorDto> patentApplyAuthorDtoList;
    private List<UnitPeronDto> unitPeronDtoList;
}
