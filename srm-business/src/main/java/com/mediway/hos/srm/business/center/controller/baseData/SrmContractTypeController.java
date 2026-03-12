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
import com.mediway.hos.srm.business.center.model.dto.baseData.ContractTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ContractTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmContractTypeService;
/**
 * <p>
 * 合同类型
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/contractType")
@Api(tags = "合同类型")
public class SrmContractTypeController {

    @Autowired
    private SrmContractTypeService srmContractTypeService;

    @PostMapping({"/saveOrUpdateContractType"})
    public BaseResponse saveOrUpdateContractType(@RequestBody BaseDataProjDto baseDataProjDto) {
        Long RowId = srmContractTypeService.saveOrUpdateContractType(baseDataProjDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailContractType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ContractTypeVo contractTypeVo = srmContractTypeService.getDetailContractType(RowId);
        return BaseResponse.success(contractTypeVo);
    }

    @PostMapping({"/listContractType"})
    public BaseResponse listContractType(@RequestBody ContractTypeDto contractTypeDto) {
        IPage<ContractTypeVo> list = srmContractTypeService.listContractType(contractTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteContractType"})
    public BaseResponse deleteContractType(@RequestBody BaseDto baseDto) {
        srmContractTypeService.deleteContractType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
