package com.mediway.hos.srm.business.center.service.contract;

import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.entity.contract.SrmContractInfoMember;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.contract.ContractInfoMemberVo;

import java.util.List;

/**
 * <p>
 * 合同参与人 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2025-02-25
 */
public interface SrmContractInfoMemberService extends BaseService<SrmContractInfoMember> {
    public List<ContractInfoMemberVo> listContractInfoAuthor(BaseDto baseDto);
    void deleteAuthorByParent(Long parentId);
    void deleteAuthorById(BaseDto baseDto);
}
