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

import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetYearDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetYearVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundBudgetYear;
import com.mediway.hos.srm.business.center.service.fund.FundBudgetYearService;
import com.mediway.hos.srm.business.center.mapper.fund.FundBudgetYearMapper;

/**
 * <p>
 * 预算年度表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@Service
public class FundBudgetYearServiceImpl extends BaseServiceImpl<FundBudgetYearMapper, FundBudgetYear> implements FundBudgetYearService {

    @Autowired
    private FundBudgetYearMapper fundBudgetYearMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateFundBudgetYear(BaseDataFundDto baseDataFundDto) {
        List<FundBudgetYearDto> fundBudgetYearDtos =baseDataFundDto.getFundBudgetYears();

        List<FundBudgetYear> fundBudgetYearList=new ArrayList<>();
        for (FundBudgetYearDto fundBudgetYearDto :fundBudgetYearDtos) {
            FundBudgetYear fundBudgetYear = new FundBudgetYear();
            fundBudgetYear.setId(fundBudgetYearDto.getRowId());
            fundBudgetYear.setYear(fundBudgetYearDto.getYear());
            fundBudgetYear.setNote(fundBudgetYearDto.getNote());
            fundBudgetYear.setIsValid(fundBudgetYearDto.getIsValid());
            fundBudgetYear.setHospCode(fundBudgetYearDto.getHospCode());

            fundBudgetYearList.add(fundBudgetYear);
            Long RowId = fundBudgetYear.getId();
        }
        super.saveOrUpdateBatch(fundBudgetYearList);
        return RowId;
    }
    @Override
    public FundBudgetYearVo getDetailFundBudgetYear(Long RowId) {
        return null;
    }

    @Override
    public IPage<FundBudgetYearVo> listFundBudgetYear(FundBudgetYearDto fundBudgetYearDto) {
        Page<FundBudgetYearVo> page = new Page<>(fundBudgetYearDto.getPage(),fundBudgetYearDto.getRows());
        IPage<FundBudgetYearVo> res= fundBudgetYearMapper.listFundBudgetYear(page,fundBudgetYearDto);
        //List<FundBudgetYearVo> records=res.getRecords();
        //List<FundBudgetYearVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteFundBudgetYear(BaseDto baseDto) {
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
