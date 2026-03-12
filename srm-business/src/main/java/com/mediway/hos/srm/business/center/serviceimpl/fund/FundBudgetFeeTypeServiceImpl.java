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

import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetFeeTypeDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetFeeTypeVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundBudgetFeeType;
import com.mediway.hos.srm.business.center.service.fund.FundBudgetFeeTypeService;
import com.mediway.hos.srm.business.center.mapper.fund.FundBudgetFeeTypeMapper;

/**
 * <p>
 * 预算资金类型 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@Service
public class FundBudgetFeeTypeServiceImpl extends BaseServiceImpl<FundBudgetFeeTypeMapper, FundBudgetFeeType> implements FundBudgetFeeTypeService {

    @Autowired
    private FundBudgetFeeTypeMapper fundBudgetFeeTypeMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateFundBudgetFeeType(BaseDataFundDto baseDataFundDto) {
        List<FundBudgetFeeTypeDto> fundBudgetFeeTypeDtos =baseDataFundDto.getFundBudgetFeeTypes();

        List<FundBudgetFeeType> fundBudgetFeeTypeList=new ArrayList<>();
        for (FundBudgetFeeTypeDto fundBudgetFeeTypeDto :fundBudgetFeeTypeDtos) {
            FundBudgetFeeType fundBudgetFeeType = new FundBudgetFeeType();
            fundBudgetFeeType.setId(fundBudgetFeeTypeDto.getRowId());
            fundBudgetFeeType.setCode(fundBudgetFeeTypeDto.getCode());
            fundBudgetFeeType.setName(fundBudgetFeeTypeDto.getName());
            fundBudgetFeeType.setIsValid(fundBudgetFeeTypeDto.getIsValid());

            fundBudgetFeeTypeList.add(fundBudgetFeeType);
            Long RowId = fundBudgetFeeType.getId();
        }
        super.saveOrUpdateBatch(fundBudgetFeeTypeList);
        return RowId;
    }
    @Override
    public FundBudgetFeeTypeVo getDetailFundBudgetFeeType(Long RowId) {
        return null;
    }

    @Override
    public IPage<FundBudgetFeeTypeVo> listFundBudgetFeeType(FundBudgetFeeTypeDto fundBudgetFeeTypeDto) {
        Page<FundBudgetFeeTypeVo> page = new Page<>(fundBudgetFeeTypeDto.getPage(),fundBudgetFeeTypeDto.getRows());
        IPage<FundBudgetFeeTypeVo> res= fundBudgetFeeTypeMapper.listFundBudgetFeeType(page,fundBudgetFeeTypeDto);
        //List<FundBudgetFeeTypeVo> records=res.getRecords();
        //List<FundBudgetFeeTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteFundBudgetFeeType(BaseDto baseDto) {
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
