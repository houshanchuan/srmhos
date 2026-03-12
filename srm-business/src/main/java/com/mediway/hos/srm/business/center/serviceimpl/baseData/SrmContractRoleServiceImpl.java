package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import com.mediway.hos.srm.business.center.constants.BusinessConstants;
import com.mediway.hos.srm.business.center.service.baseData.SrmBusinessnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.ContractRoleDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ContractRoleVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmContractRole;
import com.mediway.hos.srm.business.center.service.baseData.SrmContractRoleService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmContractRoleMapper;

/**
 * <p>
 * 合同角色 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmContractRoleServiceImpl extends BaseServiceImpl<SrmContractRoleMapper, SrmContractRole> implements SrmContractRoleService {

    @Autowired
    private SrmContractRoleService  srmContractRoleService;
    @Autowired
    private SrmContractRoleMapper srmContractRoleMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateContractRole(BaseDataProjDto baseDataProjDto) {
        List<ContractRoleDto> contractRoleDtos =baseDataProjDto.getContractRoles();

        List<SrmContractRole> contractRoleList=new ArrayList<>();
        for (ContractRoleDto contractRoleDto :contractRoleDtos) {
            SrmContractRole srmContractRole = new SrmContractRole();
            srmContractRole.setId(contractRoleDto.getRowId());
            if(ObjectUtil.isEmpty(contractRoleDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PRJ_ROLE, 1, "");
                srmContractRole.setCode(code);
            }else{
                srmContractRole.setCode(contractRoleDto.getCode());
            }
            srmContractRole.setName(contractRoleDto.getName());
            srmContractRole.setIsValid(Integer.valueOf(contractRoleDto.getIsValid()));

            contractRoleList.add(srmContractRole);
            Long RowId = srmContractRole.getId();
        }
        super.saveOrUpdateBatch(contractRoleList);
        return RowId;
    }
    @Override
    public ContractRoleVo getDetailContractRole(Long RowId) {
        return null;
    }

    @Override
    public IPage<ContractRoleVo> listContractRole(ContractRoleDto contractRoleDto) {
        Page<ContractRoleVo> page = new Page<>(contractRoleDto.getPage(), contractRoleDto.getRows());
        IPage<ContractRoleVo> res= srmContractRoleMapper.listContractRole(page, contractRoleDto);
        //List<ContractRoleVo> records=res.getRecords();
        //List<ContractRoleVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteContractRole(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                //System.out.println(RowId);
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

    @Override
    public Long getIdByName(String name) {
        return null;
    }

    @Override
    public List<CombVo> getContractRole() {
        return srmContractRoleMapper.getContractRole();
    }
}
