package com.mediway.hos.srm.business.center.model.dto.award;

import lombok.Data;

import java.util.List;

@Data
public class AwardApplyMainDto {
    private AwardApplyDto awardApplyDto;
    private List<AwardApplyAuthorDto> awardApplyAuthorDtoList;
}
