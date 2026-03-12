package com.mediway.hos.srm.business.center.model.dto.baseData;

import com.mediway.hos.srm.business.center.model.dto.academic.AcMeetingManageDto;
import lombok.Data;

import java.util.List;

@Data
public class AcBaseDto {
   private List<AcMeetingManageDto> acMeetingManages;

}
