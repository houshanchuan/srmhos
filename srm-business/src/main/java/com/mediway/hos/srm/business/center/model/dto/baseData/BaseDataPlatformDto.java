package com.mediway.hos.srm.business.center.model.dto.baseData;

import lombok.Data;

import java.util.List;

@Data
public class BaseDataPlatformDto {
    private List<ResearchUnitTypeDto> researchUnitTypes;
    private List<ResearchUnitStateDto> researchUnitStates;
    private List<SocResearchUnitTypeDto> socResearchUnitTypes;
    private List<ResearchUnitLevelDto>  researchUnitLevels;
    private List<ResearchUnitKindDto> researchUnitKinds;
    private List<ComponentTypeDto> componentTypes;
    private List<SciUnitFormDto> sciUnitForms;
    private List<EquipStatusDto> equipStatuss;
    private List<EquipChargeModeDto> equipChargeModes;
    private List<EquipArrangeStateDto>equipArrangeStates;
    private List<EquipBookexeStateDto>equipBookexeStates;

}
