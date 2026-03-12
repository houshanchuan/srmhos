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

import com.mediway.hos.srm.business.center.model.dto.fund.FundSourceTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmFundSourceType;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmFundSourceTypeMapper;
import com.mediway.hos.srm.business.center.model.vo.fund.FundSourceTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmFundSourceTypeService;

/**
 * <p>
 * 费用来源类型 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmFundSourceTypeServiceImpl extends BaseServiceImpl<SrmFundSourceTypeMapper, SrmFundSourceType> implements SrmFundSourceTypeService {
    @Autowired
    private SrmFundSourceTypeService  srmFundSourceTypeService;
    @Autowired
    private SrmFundSourceTypeMapper srmFundSourceTypeMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateFundSourceType(BaseDataLearningDto baseDataLearningDto) {
        List<FundSourceTypeDto> fundSourceTypeDtos =baseDataLearningDto.getFundSourceTypes();

        List<SrmFundSourceType> fundSourceTypeList=new ArrayList<>();
        for (FundSourceTypeDto fundSourceTypeDto :fundSourceTypeDtos) {
            SrmFundSourceType srmFundSourceType = new SrmFundSourceType();
            srmFundSourceType.setId(fundSourceTypeDto.getRowId());
            srmFundSourceType.setCode(fundSourceTypeDto.getCode());
            srmFundSourceType.setName(fundSourceTypeDto.getName());
            srmFundSourceType.setIsValid(Integer.valueOf(fundSourceTypeDto.getIsValid()));

            fundSourceTypeList.add(srmFundSourceType);
            Long RowId = srmFundSourceType.getId();
        }
        super.saveOrUpdateBatch(fundSourceTypeList);
        return RowId;
    }
    @Override
    public FundSourceTypeVo getDetailFundSourceType(Long RowId) {
        return null;
    }

    @Override
    public IPage<FundSourceTypeVo> listFundSourceType(FundSourceTypeDto fundSourceTypeDto) {
        Page<FundSourceTypeVo> page = new Page<>(fundSourceTypeDto.getPage(), fundSourceTypeDto.getRows());
        IPage<FundSourceTypeVo> res= srmFundSourceTypeMapper.listFundSourceType(page, fundSourceTypeDto);
        //List<FundSourceTypeVo> records=res.getRecords();
        //List<FundSourceTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteFundSourceType(BaseDto baseDto) {
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
