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

import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetEstablishTypeDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetEstablishTypeVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundBudgetEstablishType;
import com.mediway.hos.srm.business.center.service.fund.FundBudgetEstablishTypeService;
import com.mediway.hos.srm.business.center.mapper.fund.FundBudgetEstablishTypeMapper;

/**
 * <p>
 * 预算编制类型 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@Service
public class FundBudgetEstablishTypeServiceImpl extends BaseServiceImpl<FundBudgetEstablishTypeMapper, FundBudgetEstablishType> implements FundBudgetEstablishTypeService {

    @Autowired
    private FundBudgetEstablishTypeMapper fundBudgetEstablishTypeMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateFundBudgetEstablishType(BaseDataFundDto baseDataFundDto) {
        List<FundBudgetEstablishTypeDto> fundBudgetEstablishTypeDtos =baseDataFundDto.getFundBudgetEstablishTypes();

        List<FundBudgetEstablishType> fundBudgetEstablishTypeList=new ArrayList<>();
        for (FundBudgetEstablishTypeDto fundBudgetEstablishTypeDto :fundBudgetEstablishTypeDtos) {
            FundBudgetEstablishType fundBudgetEstablishType = new FundBudgetEstablishType();
            fundBudgetEstablishType.setId(fundBudgetEstablishTypeDto.getRowId());
            fundBudgetEstablishType.setCode(fundBudgetEstablishTypeDto.getCode());
            fundBudgetEstablishType.setName(fundBudgetEstablishTypeDto.getName());
            fundBudgetEstablishType.setIsValid(fundBudgetEstablishTypeDto.getIsValid());

            fundBudgetEstablishTypeList.add(fundBudgetEstablishType);
            Long RowId = fundBudgetEstablishType.getId();
        }
        super.saveOrUpdateBatch(fundBudgetEstablishTypeList);
        return RowId;
    }
    @Override
    public FundBudgetEstablishTypeVo getDetailFundBudgetEstablishType(Long RowId) {
        return null;
    }

    @Override
    public IPage<FundBudgetEstablishTypeVo> listFundBudgetEstablishType(FundBudgetEstablishTypeDto fundBudgetEstablishTypeDto) {
        Page<FundBudgetEstablishTypeVo> page = new Page<>(fundBudgetEstablishTypeDto.getPage(),fundBudgetEstablishTypeDto.getRows());
        IPage<FundBudgetEstablishTypeVo> res= fundBudgetEstablishTypeMapper.listFundBudgetEstablishType(page,fundBudgetEstablishTypeDto);
        //List<FundBudgetEstablishTypeVo> records=res.getRecords();
        //List<FundBudgetEstablishTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteFundBudgetEstablishType(BaseDto baseDto) {
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
