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

import com.mediway.hos.srm.business.center.model.dto.fund.FundExpTypeDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundExpTypeVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundExpType;
import com.mediway.hos.srm.business.center.service.fund.FundExpTypeService;
import com.mediway.hos.srm.business.center.mapper.fund.FundExpTypeMapper;


/**
 * <p>
 * 支出业务类型 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@Service
public class FundExpTypeServiceImpl extends BaseServiceImpl<FundExpTypeMapper, FundExpType> implements FundExpTypeService {

    @Autowired
    private FundExpTypeMapper fundExpTypeMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateFundExpType(BaseDataFundDto baseDataFundDto) {
        List<FundExpTypeDto> fundExpTypeDtos =baseDataFundDto.getFundExpTypes();

        List<FundExpType> fundExpTypeList=new ArrayList<>();
        for (FundExpTypeDto fundExpTypeDto :fundExpTypeDtos) {
            FundExpType fundExpType = new FundExpType();
            fundExpType.setId(fundExpTypeDto.getRowId());
            fundExpType.setCode(fundExpTypeDto.getCode());
            fundExpType.setName(fundExpTypeDto.getName());
            fundExpType.setIsValid(fundExpTypeDto.getIsValid());

            fundExpTypeList.add(fundExpType);
            Long RowId = fundExpType.getId();
        }
        super.saveOrUpdateBatch(fundExpTypeList);
        return RowId;
    }
    @Override
    public FundExpTypeVo getDetailFundExpType(Long RowId) {
        return null;
    }

    @Override
    public IPage<FundExpTypeVo> listFundExpType(FundExpTypeDto fundExpTypeDto) {
        Page<FundExpTypeVo> page = new Page<>(fundExpTypeDto.getPage(),fundExpTypeDto.getRows());
        IPage<FundExpTypeVo> res= fundExpTypeMapper.listFundExpType(page,fundExpTypeDto);
        //List<FundExpTypeVo> records=res.getRecords();
        //List<FundExpTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteFundExpType(BaseDto baseDto) {
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
