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

import com.mediway.hos.srm.business.center.model.dto.fund.FundTypeDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundTypeVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundType;
import com.mediway.hos.srm.business.center.service.fund.FundTypeService;
import com.mediway.hos.srm.business.center.mapper.fund.FundTypeMapper;
/**
 * <p>
 * 项目资金来源类型表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@Service
public class FundTypeServiceImpl extends BaseServiceImpl<FundTypeMapper, FundType> implements FundTypeService {

    @Autowired
    private FundTypeMapper fundTypeMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateFundType(BaseDataFundDto baseDataFundDto) {
        List<FundTypeDto> fundTypeDtos =baseDataFundDto.getFundTypes();

        List<FundType> fundTypeList=new ArrayList<>();
        for (FundTypeDto fundTypeDto :fundTypeDtos) {
            FundType fundType = new FundType();
            fundType.setId(fundTypeDto.getRowId());
            fundType.setCode(fundTypeDto.getCode());
            fundType.setName(fundTypeDto.getName());
            fundType.setIsValid(fundTypeDto.getIsValid());

            fundTypeList.add(fundType);
            Long RowId = fundType.getId();
        }
        super.saveOrUpdateBatch(fundTypeList);
        return RowId;
    }
    @Override
    public FundTypeVo getDetailFundType(Long RowId) {
        return null;
    }

    @Override
    public IPage<FundTypeVo> listFundType(FundTypeDto fundTypeDto) {
        Page<FundTypeVo> page = new Page<>(fundTypeDto.getPage(),fundTypeDto.getRows());
        IPage<FundTypeVo> res= fundTypeMapper.listFundType(page,fundTypeDto);
        //List<FundTypeVo> records=res.getRecords();
        //List<FundTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteFundType(BaseDto baseDto) {
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
