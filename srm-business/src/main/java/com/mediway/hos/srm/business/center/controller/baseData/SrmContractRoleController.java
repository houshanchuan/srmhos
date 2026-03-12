package com.mediway.hos.srm.business.center.controller.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.model.dto.baseData.ContractRoleDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ContractRoleVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmContractRoleService;

/**
 * <p>
 * 合同角色
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/contractRole")
@Api(tags = "合同角色")
public class SrmContractRoleController {

    @Autowired
    private SrmContractRoleService srmContractRoleService;

    @PostMapping({"/saveOrUpdateContractRole"})
    public BaseResponse saveOrUpdateContractRole(@RequestBody BaseDataProjDto baseDataProjDto) {
        Long RowId = srmContractRoleService.saveOrUpdateContractRole(baseDataProjDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailContractRole(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ContractRoleVo contractRoleVo = srmContractRoleService.getDetailContractRole(RowId);
        return BaseResponse.success(contractRoleVo);
    }

    @PostMapping({"/listContractRole"})
    public BaseResponse listContractRole(@RequestBody ContractRoleDto contractRoleDto) {
        IPage<ContractRoleVo> list = srmContractRoleService.listContractRole(contractRoleDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteContractRole"})
    public BaseResponse deleteContractRole(@RequestBody BaseDto baseDto) {
        srmContractRoleService.deleteContractRole(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
