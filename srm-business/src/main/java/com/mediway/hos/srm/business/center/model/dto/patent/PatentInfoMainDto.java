package com.mediway.hos.srm.business.center.model.dto.patent;

import com.mediway.hos.srm.business.center.model.dto.baseData.UnitPeronDto;
import lombok.Data;

import java.util.List;
@Data
public class PatentInfoMainDto {
    private PatentInfoDto patentInfoDto;
    private List<PatentInfoAuthorDto> patentInfoAuthorDtoList;
    private List<UnitPeronDto> unitPeronDtoList;
}
