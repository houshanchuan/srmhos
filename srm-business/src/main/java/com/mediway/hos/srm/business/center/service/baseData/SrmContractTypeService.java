package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.ContractTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ContractTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmContractType;

/**
 * <p>
 * 合同类型 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmContractTypeService extends BaseService<SrmContractType> {

    @Transactional
    Long saveOrUpdateContractType(BaseDataProjDto baseDataProjDto);

    ContractTypeVo getDetailContractType(Long RowId);
    IPage<ContractTypeVo> listContractType(ContractTypeDto contractTypeDto);

    void deleteContractType(BaseDto baseDto);

    Long getIdByName(String name);
    List<CombVo> getContractType();
}
