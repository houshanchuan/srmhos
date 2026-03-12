package com.mediway.hos.srm.business.center.serviceimpl.contract;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.entity.contract.SrmContractInfoMember;
import com.mediway.hos.srm.business.center.mapper.contract.SrmContractInfoMemberMapper;
import com.mediway.hos.srm.business.center.model.vo.contract.ContractInfoMemberVo;
import com.mediway.hos.srm.business.center.service.contract.SrmContractInfoMemberService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 合同参与人 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2025-02-25
 */
@Service
public class SrmContractInfoMemberServiceImpl extends BaseServiceImpl<SrmContractInfoMemberMapper, SrmContractInfoMember> implements SrmContractInfoMemberService {
    @Autowired
    private SrmContractInfoMemberMapper srmContractInfoMemberMapper;
    @Override
    public List<ContractInfoMemberVo> listContractInfoAuthor(BaseDto baseDto) {
        Long parentId=baseDto.getId();
        return srmContractInfoMemberMapper.listContractInfoAuthor(parentId);
    }

    @Override
    public void deleteAuthorByParent(Long parentId) {
        srmContractInfoMemberMapper.deleteAuthorByParent(parentId);
    }


    @Override
    @Transactional
    public void deleteAuthorById(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                if(StringUtils.isEmpty(idStr)){
                    idStr=String.valueOf(RowId);
                }else{
                    idStr=idStr+","+String.valueOf(RowId);
                }
            }
            super.deleteByIds(idStr);
        }catch (Exception exception){
            throw  new ErrorException("-200",exception.getMessage());
        }
    }
}
