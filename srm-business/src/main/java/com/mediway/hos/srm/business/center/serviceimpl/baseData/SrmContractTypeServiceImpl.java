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

import com.mediway.hos.srm.business.center.model.dto.baseData.ContractTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ContractTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmContractType;
import com.mediway.hos.srm.business.center.service.baseData.SrmContractTypeService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmContractTypeMapper;


/**
 * <p>
 * 合同类型 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmContractTypeServiceImpl extends BaseServiceImpl<SrmContractTypeMapper, SrmContractType> implements SrmContractTypeService {

    @Autowired
    private SrmContractTypeService  srmContractTypeService;
    @Autowired
    private SrmContractTypeMapper srmContractTypeMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateContractType(BaseDataProjDto baseDataProjDto) {
        List<ContractTypeDto> contractTypeDtos =baseDataProjDto.getContractTypes();

        List<SrmContractType> contractTypeList=new ArrayList<>();
        for (ContractTypeDto contractTypeDto :contractTypeDtos) {
            SrmContractType srmContractType = new SrmContractType();
            srmContractType.setId(contractTypeDto.getRowId());

            if(ObjectUtil.isEmpty(contractTypeDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PRJ_CONTRACT_TYPE, 2, "");
                srmContractType.setCode(code);
            }else{
                srmContractType.setCode(contractTypeDto.getCode());
            }
            srmContractType.setName(contractTypeDto.getName());
            srmContractType.setIsValid(Integer.valueOf(contractTypeDto.getIsValid()));

            contractTypeList.add(srmContractType);
            Long RowId = srmContractType.getId();
        }
        super.saveOrUpdateBatch(contractTypeList);
        return RowId;
    }
    @Override
    public ContractTypeVo getDetailContractType(Long RowId) {
        return null;
    }

    @Override
    public IPage<ContractTypeVo> listContractType(ContractTypeDto contractTypeDto) {
        Page<ContractTypeVo> page = new Page<>(contractTypeDto.getPage(), contractTypeDto.getRows());
        IPage<ContractTypeVo> res= srmContractTypeMapper.listContractType(page, contractTypeDto);
        //List<ContractTypeVo> records=res.getRecords();
        //List<ContractTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteContractType(BaseDto baseDto) {
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
    public List<CombVo> getContractType() {
        return srmContractTypeMapper.getContractType();
    }
}
