package com.mediway.hos.srm.business.center.model.dto.paper;

import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.PaperEmbodyTypeDto;
import lombok.Data;

import java.util.List;

@Data
public class PaperMainDto extends BaseDto {
    private PaperDto paperDto;
    private List<PaperAuthorDto> paperAuthorDtos;
    private List<PaperEmbodyDto> paperEmbodyDtos;
    private List<PaperReshipDto> paperReshipDtos;
}
