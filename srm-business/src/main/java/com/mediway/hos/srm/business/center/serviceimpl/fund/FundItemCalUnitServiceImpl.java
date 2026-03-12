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

import com.mediway.hos.srm.business.center.model.dto.fund.FundItemCalUnitDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundItemCalUnitVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundItemCalUnit;
import com.mediway.hos.srm.business.center.service.fund.FundItemCalUnitService;
import com.mediway.hos.srm.business.center.mapper.fund.FundItemCalUnitMapper;

/**
 * <p>
 * 预算项计量单位 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@Service
public class FundItemCalUnitServiceImpl extends BaseServiceImpl<FundItemCalUnitMapper, FundItemCalUnit> implements FundItemCalUnitService {

    @Autowired
    private FundItemCalUnitMapper fundItemCalUnitMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateFundItemCalUnit(BaseDataFundDto baseDataFundDto) {
        List<FundItemCalUnitDto> fundItemCalUnitDtos =baseDataFundDto.getFundItemCalUnits();

        List<FundItemCalUnit> fundItemCalUnitList=new ArrayList<>();
        for (FundItemCalUnitDto fundItemCalUnitDto :fundItemCalUnitDtos) {
            FundItemCalUnit fundItemCalUnit = new FundItemCalUnit();
            fundItemCalUnit.setId(fundItemCalUnitDto.getRowId());
            fundItemCalUnit.setCode(fundItemCalUnitDto.getCode());
            fundItemCalUnit.setName(fundItemCalUnitDto.getName());
            fundItemCalUnit.setIsValid(fundItemCalUnitDto.getIsValid());

            fundItemCalUnitList.add(fundItemCalUnit);
            Long RowId = fundItemCalUnit.getId();
        }
        super.saveOrUpdateBatch(fundItemCalUnitList);
        return RowId;
    }
    @Override
    public FundItemCalUnitVo getDetailFundItemCalUnit(Long RowId) {
        return null;
    }

    @Override
    public IPage<FundItemCalUnitVo> listFundItemCalUnit(FundItemCalUnitDto fundItemCalUnitDto) {
        Page<FundItemCalUnitVo> page = new Page<>(fundItemCalUnitDto.getPage(),fundItemCalUnitDto.getRows());
        IPage<FundItemCalUnitVo> res= fundItemCalUnitMapper.listFundItemCalUnit(page,fundItemCalUnitDto);
        //List<FundItemCalUnitVo> records=res.getRecords();
        //List<FundItemCalUnitVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteFundItemCalUnit(BaseDto baseDto) {
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
