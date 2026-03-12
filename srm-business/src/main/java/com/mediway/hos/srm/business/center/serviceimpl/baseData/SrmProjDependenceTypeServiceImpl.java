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

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjDependenceTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjDependenceTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjDependenceType;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjDependenceTypeService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmProjDependenceTypeMapper;
/**
 * <p>
 * 项目依赖类型代码表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmProjDependenceTypeServiceImpl extends BaseServiceImpl<SrmProjDependenceTypeMapper, SrmProjDependenceType> implements SrmProjDependenceTypeService {

    @Autowired
    private SrmProjDependenceTypeService  srmProjDependenceTypeService;
    @Autowired
    private SrmProjDependenceTypeMapper srmProjDependenceTypeMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateProjDependenceType(BaseDataProjDto baseDataProjDto) {
        List<ProjDependenceTypeDto> projDependenceTypeDtos =baseDataProjDto.getProjDependenceTypes();

        List<SrmProjDependenceType> projDependenceTypeList=new ArrayList<>();
        for (ProjDependenceTypeDto projDependenceTypeDto :projDependenceTypeDtos) {
            SrmProjDependenceType srmProjDependenceType = new SrmProjDependenceType();
            srmProjDependenceType.setId(projDependenceTypeDto.getRowId());
            if(ObjectUtil.isEmpty(projDependenceTypeDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PRJ_DEPENDENCE_TYPE, 1, "");
                srmProjDependenceType.setCode(code);
            }else{
                srmProjDependenceType.setCode(projDependenceTypeDto.getCode());
            }
            srmProjDependenceType.setName(projDependenceTypeDto.getName());
            srmProjDependenceType.setIsValid(Integer.valueOf(projDependenceTypeDto.getIsValid()));

            projDependenceTypeList.add(srmProjDependenceType);
            Long RowId = srmProjDependenceType.getId();
        }
        super.saveOrUpdateBatch(projDependenceTypeList);
        return RowId;
    }
    @Override
    public ProjDependenceTypeVo getDetailProjDependenceType(Long RowId) {
        return null;
    }

    @Override
    public IPage<ProjDependenceTypeVo> listProjDependenceType(ProjDependenceTypeDto projDependenceTypeDto) {
        Page<ProjDependenceTypeVo> page = new Page<>(projDependenceTypeDto.getPage(), projDependenceTypeDto.getRows());
        IPage<ProjDependenceTypeVo> res= srmProjDependenceTypeMapper.listProjDependenceType(page, projDependenceTypeDto);
        //List<ProjDependenceTypeVo> records=res.getRecords();
        //List<ProjDependenceTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteProjDependenceType(BaseDto baseDto) {
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
