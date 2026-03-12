package com.mediway.hos.srm.business.center.service.contract;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.contract.ContractInfoDto;
import com.mediway.hos.srm.business.center.model.dto.contract.ContractInfoMainDto;

import com.mediway.hos.srm.business.center.model.entity.contract.SrmContractInfo;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.contract.ContractInfoVo;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectSolicitGradeVo;

/**
 * <p>
 * 合同(项目) 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2025-02-25
 */
public interface SrmContractInfoService extends BaseService<SrmContractInfo> {
    // 合同项目
    Long saveContractInfo(ContractInfoMainDto contractInfoMainDto);
    ContractInfoVo getContractInfoDetail(Long rowId);
    IPage<ContractInfoVo> listContractInfo(ContractInfoDto contractInfoDto);

    void deleteContractInfo(BaseDto baseDto);
    void subMitContractInfo(BaseDto baseDto);

    void auditContractInfo(BaseDto baseDto);
    IPage<ContractInfoVo> listAuditContractInfo(ContractInfoDto contractInfoDto);
    IPage<ProjectSolicitGradeVo> listExpertAudit(ContractInfoDto contractInfoDto);
}
