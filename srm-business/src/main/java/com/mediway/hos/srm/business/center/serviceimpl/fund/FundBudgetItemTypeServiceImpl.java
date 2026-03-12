package com.mediway.hos.srm.business.center.serviceimpl.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataFundDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetItemTypeDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetItemTypeVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundBudgetItemType;
import com.mediway.hos.srm.business.center.service.fund.FundBudgetItemTypeService;
import com.mediway.hos.srm.business.center.mapper.fund.FundBudgetItemTypeMapper;

/**
 * <p>
 * 预算项（科目）类别 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@Service
public class FundBudgetItemTypeServiceImpl extends BaseServiceImpl<FundBudgetItemTypeMapper, FundBudgetItemType> implements FundBudgetItemTypeService {

    @Autowired
    private FundBudgetItemTypeMapper fundBudgetItemTypeMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateFundBudgetItemType(BaseDataFundDto baseDataFundDto) {
        List<FundBudgetItemTypeDto> fundBudgetItemTypeDtos =baseDataFundDto.getFundBudgetItemTypes();

        List<FundBudgetItemType> fundBudgetItemTypeList=new ArrayList<>();
        for (FundBudgetItemTypeDto fundBudgetItemTypeDto :fundBudgetItemTypeDtos) {
            FundBudgetItemType fundBudgetItemType = new FundBudgetItemType();
            fundBudgetItemType.setId(fundBudgetItemTypeDto.getRowId());
            fundBudgetItemType.setCode(fundBudgetItemTypeDto.getCode());
            fundBudgetItemType.setName(fundBudgetItemTypeDto.getName());
            fundBudgetItemType.setIsValid(fundBudgetItemTypeDto.getIsValid());

            fundBudgetItemTypeList.add(fundBudgetItemType);
            Long RowId = fundBudgetItemType.getId();
        }
        super.saveOrUpdateBatch(fundBudgetItemTypeList);
        return RowId;
    }
    @Override
    public FundBudgetItemTypeVo getDetailFundBudgetItemType(Long RowId) {
        return null;
    }

    @Override
    public IPage<FundBudgetItemTypeVo> listFundBudgetItemType(FundBudgetItemTypeDto fundBudgetItemTypeDto) {
        Page<FundBudgetItemTypeVo> page = new Page<>(fundBudgetItemTypeDto.getPage(),fundBudgetItemTypeDto.getRows());
        IPage<FundBudgetItemTypeVo> res= fundBudgetItemTypeMapper.listFundBudgetItemType(page,fundBudgetItemTypeDto);
        //List<FundBudgetItemTypeVo> records=res.getRecords();
        //List<FundBudgetItemTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteFundBudgetItemType(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                //System.out.println(RowId);
                if(StringUtils.isEmpty(idStr)){
                    idStr=String.valueOf(RowId);
                }else{
                    idStr=idStr+""+String.valueOf(RowId);
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
