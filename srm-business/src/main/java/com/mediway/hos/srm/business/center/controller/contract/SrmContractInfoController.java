package com.mediway.hos.srm.business.center.controller.contract;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.contract.ContractInfoDto;
import com.mediway.hos.srm.business.center.model.dto.contract.ContractInfoMainDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.contract.ContractInfoVo;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectSolicitGradeVo;
import com.mediway.hos.srm.business.center.service.contract.SrmContractInfoService;

/**
 * <p>
 * 合同(项目)
 * </p>
 *
 * @author 代码生成器
 * @since 2025-02-25
 */
@RestController
@RequestMapping("srm/srmContractInfo")
@Api(tags = "合同(项目)")
public class SrmContractInfoController {
    @Autowired
    private SrmContractInfoService srmContractInfoService;
    // 下面是合同项目
    @PostMapping({"/saveContractInfo"})
    public BaseResponse saveContractInfo(@RequestBody ContractInfoMainDto contractInfoMainDto) {
        Long RowId= srmContractInfoService.saveContractInfo(contractInfoMainDto);
        return BaseResponse.success(RowId);
    }
    @PostMapping({"/getContractInfoDetail"})
    public BaseResponse getContractInfoDetail(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ContractInfoVo projectsInfoVo = srmContractInfoService.getContractInfoDetail(RowId);
        return BaseResponse.success(projectsInfoVo);
    }

    @PostMapping({"/listContractInfo"})
    public BaseResponse listContractInfo(@RequestBody ContractInfoDto contractInfoDto) {
        System.out.println(contractInfoDto);
        IPage<ContractInfoVo> list = srmContractInfoService.listContractInfo(contractInfoDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteContractInfo"})
    public BaseResponse deleteContractInfo(@RequestBody BaseDto baseDto) {
        srmContractInfoService.deleteContractInfo(baseDto);
        return BaseResponse.success("删除成功!");

    }
    @PostMapping({"/subMitContractInfo"})
    public BaseResponse subMitContractInfo(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto.toString());
        srmContractInfoService.subMitContractInfo(baseDto);
        return BaseResponse.success("提交成功!");

    }
    @PostMapping({"/listAuditContractInfo"})
    public BaseResponse listAuditContractInfo(@RequestBody ContractInfoDto contractInfoDto) {

        IPage<ContractInfoVo> list = srmContractInfoService.listAuditContractInfo(contractInfoDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/auditContractInfo"})
    public BaseResponse auditContractInfo(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto.toString());
        srmContractInfoService.auditContractInfo(baseDto);
        return BaseResponse.success("审批成功!");

    }
    @PostMapping({"/listExpertAudit"})
    public BaseResponse listExpertAudit(@RequestBody ContractInfoDto contractInfoDto) {
        IPage<ProjectSolicitGradeVo> list = srmContractInfoService.listExpertAudit(contractInfoDto);
        return BaseResponse.success(list);

    }
}
