package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProductTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProductType;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmProductTypeMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProductTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmProductTypeService;
/**
 * <p>
 * 成果类型 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmProductTypeServiceImpl extends BaseServiceImpl<SrmProductTypeMapper, SrmProductType> implements SrmProductTypeService {
    @Autowired
    private SrmProductTypeService  srmProductTypeService;
    @Autowired
    private SrmProductTypeMapper srmProductTypeMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateProductType(BaseDataLearningDto baseDataLearningDto) {
        List<ProductTypeDto> productTypeDtos =baseDataLearningDto.getProductTypes();

        List<SrmProductType> productTypeList=new ArrayList<>();
        for (ProductTypeDto productTypeDto :productTypeDtos) {
            SrmProductType srmProductType = new SrmProductType();
            srmProductType.setId(productTypeDto.getRowId());
            srmProductType.setCode(productTypeDto.getCode());
            srmProductType.setName(productTypeDto.getName());
            srmProductType.setIsValid(Integer.valueOf(productTypeDto.getIsValid()));

            productTypeList.add(srmProductType);
            Long RowId = srmProductType.getId();
        }
        super.saveOrUpdateBatch(productTypeList);
        return RowId;
    }
    @Override
    public ProductTypeVo getDetailProductType(Long RowId) {
        return null;
    }

    @Override
    public IPage<ProductTypeVo> listProductType(ProductTypeDto productTypeDto) {
        Page<ProductTypeVo> page = new Page<>(productTypeDto.getPage(), productTypeDto.getRows());
        IPage<ProductTypeVo> res= srmProductTypeMapper.listProductType(page, productTypeDto);
        //List<ProductTypeVo> records=res.getRecords();
        //List<ProductTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteProductType(BaseDto baseDto) {
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
