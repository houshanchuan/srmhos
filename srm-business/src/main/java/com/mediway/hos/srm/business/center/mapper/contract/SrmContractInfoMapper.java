package com.mediway.hos.srm.business.center.mapper.contract;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.dto.contract.ContractInfoDto;
import com.mediway.hos.srm.business.center.model.entity.contract.SrmContractInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.contract.ContractInfoVo;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectSolicitGradeVo;

/**
 * <p>
 * 合同(项目) Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2025-02-25
 */
public interface SrmContractInfoMapper extends BaseMapper<SrmContractInfo> {
    ContractInfoVo getDetail(@Param("rowId") Long rowId);
    void updateStatus(@Param("rowId") Long rowId,@Param("status") Integer status,@Param("resStatus") String resStatus);
    IPage<ContractInfoVo> listContractInfo(@Param("page") Page<ContractInfoVo> page, @Param("contractInfoDto") ContractInfoDto contractInfoDto);
    IPage<ContractInfoVo> listAuditContractInfo(@Param("page") Page<ContractInfoVo> page, @Param("contractInfoDto") ContractInfoDto contractInfoDto);
    IPage<ProjectSolicitGradeVo> listExpertAudit(@Param("page") Page<ProjectSolicitGradeVo> page, @Param("contractInfoDto") ContractInfoDto contractInfoDto);

}
