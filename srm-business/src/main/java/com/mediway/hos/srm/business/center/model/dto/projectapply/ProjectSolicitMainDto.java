package com.mediway.hos.srm.business.center.model.dto.projectapply;

import lombok.Data;

import java.util.List;

@Data
public class ProjectSolicitMainDto {
    private ProjectSolicitDto projectSolicitDto;
    private List<ProjectSolicitMemberDto> projectSolicitMemberDtoList;
}
