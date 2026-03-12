package com.mediway.hos.srm.business.center.mapper.contract;

import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.entity.contract.SrmContractInfoMember;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.contract.ContractInfoMemberVo;

import java.util.List;

/**
 * <p>
 * 合同参与人 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2025-02-25
 */
public interface SrmContractInfoMemberMapper extends BaseMapper<SrmContractInfoMember> {
    List<ContractInfoMemberVo> listContractInfoAuthor(@Param("parentId") Long parentId);
    void deleteAuthorByParent(@Param("parentId") Long parentId);
}
