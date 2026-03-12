package com.mediway.hos.srm.business.center.model.dto.project;

import lombok.Data;

import java.util.List;
@Data
public class ProjectsInfoChangeMainDto {
    private ProjectsInfoChangeDto projectsInfoChangeDto;
    private List<ProjectsInfoChangeMemberDto> projectsInfoChangeMemberDtos;
}
