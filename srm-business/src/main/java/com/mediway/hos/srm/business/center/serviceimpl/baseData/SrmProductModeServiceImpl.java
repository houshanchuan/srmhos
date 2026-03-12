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
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProductModeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProductMode;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmProductModeMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProductModeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmProductModeService;


/**
 * <p>
 * 成果(产品)模式 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmProductModeServiceImpl extends BaseServiceImpl<SrmProductModeMapper, SrmProductMode> implements SrmProductModeService {
    @Autowired
    private SrmProductModeService  srmProductModeService;
    @Autowired
    private SrmProductModeMapper srmProductModeMapper;
    private Long RowId;
    @Override
	public List<CombVo> getProductMode() {
        return srmProductModeMapper.getProductMode();
	}
    @Override
    @Transactional
    public Long saveOrUpdateProductMode(BaseDataLearningDto baseDataLearningDto) {
        List<ProductModeDto> productModeDtos =baseDataLearningDto.getProductModes();

        List<SrmProductMode> productModeList=new ArrayList<>();
        for (ProductModeDto productModeDto :productModeDtos) {
            SrmProductMode srmProductMode = new SrmProductMode();
            srmProductMode.setId(productModeDto.getRowId());
            srmProductMode.setCode(productModeDto.getCode());
            srmProductMode.setName(productModeDto.getName());
            srmProductMode.setIsValid(Integer.valueOf(productModeDto.getIsValid()));

            productModeList.add(srmProductMode);
            Long RowId = srmProductMode.getId();
        }
        super.saveOrUpdateBatch(productModeList);
        return RowId;
    }
    @Override
    public ProductModeVo getDetailProductMode(Long RowId) {
        return null;
    }

    @Override
    public IPage<ProductModeVo> listProductMode(ProductModeDto productModeDto) {
        Page<ProductModeVo> page = new Page<>(productModeDto.getPage(), productModeDto.getRows());
        IPage<ProductModeVo> res= srmProductModeMapper.listProductMode(page, productModeDto);
        //List<ProductModeVo> records=res.getRecords();
        //List<ProductModeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteProductMode(BaseDto baseDto) {
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
