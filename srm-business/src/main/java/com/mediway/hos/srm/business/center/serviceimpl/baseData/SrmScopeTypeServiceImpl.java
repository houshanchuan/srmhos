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
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.ScopeTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmScopeType;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmScopeTypeMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.ScopeTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmScopeTypeService;

import javax.annotation.Resource;

/**
 * <p>
 * 范围类型 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmScopeTypeServiceImpl extends BaseServiceImpl<SrmScopeTypeMapper, SrmScopeType> implements SrmScopeTypeService {
    @Autowired
    private SrmScopeTypeService  srmScopeTypeService;
    @Autowired
    private SrmScopeTypeMapper srmScopeTypeMapper;
    @Resource
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateScopeType(BaseDataLearningDto baseDataLearningDto) {
        List<ScopeTypeDto> scopeTypeDtos =baseDataLearningDto.getScopeTypes();

        List<SrmScopeType> scopeTypeList=new ArrayList<>();
        for (ScopeTypeDto scopeTypeDto :scopeTypeDtos) {
            SrmScopeType srmScopeType = new SrmScopeType();
            srmScopeType.setId(scopeTypeDto.getRowId());
            if(ObjectUtil.isEmpty(scopeTypeDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PT_SCOPE_TYPE, 1, "");
                srmScopeType.setCode(code);
            }else{
                srmScopeType.setCode(scopeTypeDto.getCode());
            }
            srmScopeType.setName(scopeTypeDto.getName());
            srmScopeType.setIsValid(Integer.valueOf(scopeTypeDto.getIsValid()));

            scopeTypeList.add(srmScopeType);
            Long RowId = srmScopeType.getId();
        }
        super.saveOrUpdateBatch(scopeTypeList);
        return RowId;
    }
    @Override
    public ScopeTypeVo getDetailScopeType(Long RowId) {
        return null;
    }

    @Override
    public IPage<ScopeTypeVo> listScopeType(ScopeTypeDto scopeTypeDto) {
        Page<ScopeTypeVo> page = new Page<>(scopeTypeDto.getPage(), scopeTypeDto.getRows());
        IPage<ScopeTypeVo> res= srmScopeTypeMapper.listScopeType(page, scopeTypeDto);
        //List<ScopeTypeVo> records=res.getRecords();
        //List<ScopeTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteScopeType(BaseDto baseDto) {
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
}
