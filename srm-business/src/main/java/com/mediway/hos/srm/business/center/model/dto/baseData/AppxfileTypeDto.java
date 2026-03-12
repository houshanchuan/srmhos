package com.mediway.hos.srm.business.center.model.dto.baseData;


import lombok.Data;
import com.mediway.hos.srm.business.base.model.entity.BasePO;
import java.util.List;

@Data
public class AppxfileTypeDto extends BasePO {
    private AppxfileTypeDetailDto appxfileTypeDetailDto;
    private List<AppxfileTypeDetailDto> appxfileTypeDetails;
}
