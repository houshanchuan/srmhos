package com.mediway.hos.srm.business.center.model.dto.award;

import lombok.Data;

import java.util.List;

@Data
public class AchievementMainDto {
    private AchievementDto achievementDto;
    private List<AchievementAuthorDto> achievementAuthorDtos;
}
