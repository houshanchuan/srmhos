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

import com.mediway.hos.srm.business.center.model.dto.baseData.ProductProjectSourceDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProductProjectSourceVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProductProjectsource;
import com.mediway.hos.srm.business.center.service.baseData.SrmProductProjectsourceService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmProductProjectsourceMapper;


/**
 * <p>
 * 成果的项目来源表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-24
 */
@Service
public class SrmProductProjectsourceServiceImpl extends BaseServiceImpl<SrmProductProjectsourceMapper, SrmProductProjectsource> implements SrmProductProjectsourceService {
    @Autowired
    private SrmProductProjectsourceMapper srmProductProjectsourceMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    @Override
    public List<CombVo> getProjectsource() {
        return srmProductProjectsourceMapper.getProjectsource();
    }

    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateProductProjectSource(BaseDataProjDto baseDataProjDto) {
        List<ProductProjectSourceDto> productProjectSourceDtos =baseDataProjDto.getProductProjectSources();

        List<SrmProductProjectsource> productProjectSourceList=new ArrayList<>();
        for (ProductProjectSourceDto productProjectSourceDto :productProjectSourceDtos) {
            SrmProductProjectsource srmProductProjectSource = new SrmProductProjectsource();
            srmProductProjectSource.setId(productProjectSourceDto.getRowId());
            if(ObjectUtil.isEmpty(productProjectSourceDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.RESULT_PRJ_RESUORCE, 1, "");
                srmProductProjectSource.setCode(code);
            }else{
                srmProductProjectSource.setCode(productProjectSourceDto.getCode());
            }
            srmProductProjectSource.setName(productProjectSourceDto.getName());
            srmProductProjectSource.setIsValid(Integer.valueOf(productProjectSourceDto.getIsValid()));

            productProjectSourceList.add(srmProductProjectSource);
            Long RowId = srmProductProjectSource.getId();
        }
        super.saveOrUpdateBatch(productProjectSourceList);
        return RowId;
    }
    @Override
    public ProductProjectSourceVo getDetailProductProjectSource(Long RowId) {
        return null;
    }

    @Override
    public IPage<ProductProjectSourceVo> listProductProjectSource(ProductProjectSourceDto productProjectSourceDto) {
        Page<ProductProjectSourceVo> page = new Page<>(productProjectSourceDto.getPage(), productProjectSourceDto.getRows());
        IPage<ProductProjectSourceVo> res= srmProductProjectsourceMapper.listProductProjectSource(page, productProjectSourceDto);
        //List<ProductProjectSourceVo> records=res.getRecords();
        //List<ProductProjectSourceVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteProductProjectSource(BaseDto baseDto) {
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
