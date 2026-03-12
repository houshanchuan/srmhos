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
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.UnitTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmUnitType;
import com.mediway.hos.srm.business.center.model.vo.baseData.UnitTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmUnitTypeService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmUnitTypeMapper;

/**
 * <p>
 * 单位类型代码表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmUnitTypeServiceImpl extends BaseServiceImpl<SrmUnitTypeMapper, SrmUnitType> implements SrmUnitTypeService {
    @Autowired
    private SrmUnitTypeService  srmUnitTypeService;
    @Autowired
    private SrmUnitTypeMapper srmUnitTypeMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateUnitType(BaseDataUserDto baseDataUserDto) {
        List<UnitTypeDto> unitTypeDtos =baseDataUserDto.getUnitTypes();

        List<SrmUnitType> unitTypeList=new ArrayList<>();
        for (UnitTypeDto unitTypeDto :unitTypeDtos) {
            SrmUnitType srmUnitType = new SrmUnitType();
            srmUnitType.setId(unitTypeDto.getRowId());
            if(ObjectUtil.isEmpty(unitTypeDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.USER_UNIT_GRADE, 2, "");
                srmUnitType.setCode(code);
            }else{
                srmUnitType.setCode(unitTypeDto.getCode());
            }

            srmUnitType.setName(unitTypeDto.getName());
            srmUnitType.setIsValid(Integer.valueOf(unitTypeDto.getIsValid()));

            unitTypeList.add(srmUnitType);
            Long RowId = srmUnitType.getId();
        }
        super.saveOrUpdateBatch(unitTypeList);
        return RowId;
    }
    @Override
    public UnitTypeVo getDetailUnitType(Long RowId) {
        return null;
    }

    @Override
    public IPage<UnitTypeVo> listUnitType(UnitTypeDto unitTypeDto) {
        Page<UnitTypeVo> page = new Page<>(unitTypeDto.getPage(), unitTypeDto.getRows());
        IPage<UnitTypeVo> res= srmUnitTypeMapper.listUnitType(page, unitTypeDto);
        //List<UnitTypeVo> records=res.getRecords();
        //List<UnitTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteUnitType(BaseDto baseDto) {
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
    public List<CombVo> getUnitType(){
        return srmUnitTypeMapper.getUnitType();
    }

}
