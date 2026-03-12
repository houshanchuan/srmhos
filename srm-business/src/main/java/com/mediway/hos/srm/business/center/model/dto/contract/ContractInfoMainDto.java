package com.mediway.hos.srm.business.center.model.dto.contract;

import lombok.Data;

import java.util.List;
@Data
public class ContractInfoMainDto {
    private ContractInfoDto contractInfoDto;
    private List<ContractInfoMemberDto> contractInfoMemberDtos;
}
