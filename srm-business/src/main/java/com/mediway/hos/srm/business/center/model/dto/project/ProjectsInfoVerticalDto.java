package com.mediway.hos.srm.business.center.model.dto.project;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectCooperativesDto;
import lombok.Data;

import java.util.List;

@Data
public class ProjectsInfoVerticalDto {
    private ProjectsInfoDto projectsInfoDto;
    private List<ProjectsInfoMemberDto> projectsInfoMemberDtoList;
    private List<ProjectCooperativesDto> projectCooperativesDtoList;
}
