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

import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetBalanceTypeDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetBalanceTypeVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundBudgetBalanceType;
import com.mediway.hos.srm.business.center.service.fund.FundBudgetBalanceTypeService;
import com.mediway.hos.srm.business.center.mapper.fund.FundBudgetBalanceTypeMapper;

/**
 * <p>
 * 预算结余计算方式  服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@Service
public class FundBudgetBalanceTypeServiceImpl extends BaseServiceImpl<FundBudgetBalanceTypeMapper, FundBudgetBalanceType> implements FundBudgetBalanceTypeService {

    @Autowired
    private FundBudgetBalanceTypeMapper fundBudgetBalanceTypeMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateFundBudgetBalanceType(BaseDataFundDto baseDataFundDto) {
        List<FundBudgetBalanceTypeDto> fundBudgetBalanceTypeDtos =baseDataFundDto.getFundBudgetBalanceTypes();

        List<FundBudgetBalanceType> fundBudgetBalanceTypeList=new ArrayList<>();
        for (FundBudgetBalanceTypeDto fundBudgetBalanceTypeDto :fundBudgetBalanceTypeDtos) {
            FundBudgetBalanceType fundBudgetBalanceType = new FundBudgetBalanceType();
            fundBudgetBalanceType.setId(fundBudgetBalanceTypeDto.getRowId());
            fundBudgetBalanceType.setCode(fundBudgetBalanceTypeDto.getCode());
            fundBudgetBalanceType.setName(fundBudgetBalanceTypeDto.getName());
            fundBudgetBalanceType.setIsValid(fundBudgetBalanceTypeDto.getIsValid());

            fundBudgetBalanceTypeList.add(fundBudgetBalanceType);
            Long RowId = fundBudgetBalanceType.getId();
        }
        super.saveOrUpdateBatch(fundBudgetBalanceTypeList);
        return RowId;
    }
    @Override
    public FundBudgetBalanceTypeVo getDetailFundBudgetBalanceType(Long RowId) {
        return null;
    }

    @Override
    public IPage<FundBudgetBalanceTypeVo> listFundBudgetBalanceType(FundBudgetBalanceTypeDto fundBudgetBalanceTypeDto) {
        Page<FundBudgetBalanceTypeVo> page = new Page<>(fundBudgetBalanceTypeDto.getPage(),fundBudgetBalanceTypeDto.getRows());
        IPage<FundBudgetBalanceTypeVo> res= fundBudgetBalanceTypeMapper.listFundBudgetBalanceType(page,fundBudgetBalanceTypeDto);
        //List<FundBudgetBalanceTypeVo> records=res.getRecords();
        //List<FundBudgetBalanceTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteFundBudgetBalanceType(BaseDto baseDto) {
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
