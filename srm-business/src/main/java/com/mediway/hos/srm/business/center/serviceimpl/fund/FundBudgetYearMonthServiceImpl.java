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

import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetYearMonthDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetYearMonthVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundBudgetYearMonth;
import com.mediway.hos.srm.business.center.service.fund.FundBudgetYearMonthService;
import com.mediway.hos.srm.business.center.mapper.fund.FundBudgetYearMonthMapper;


/**
 * <p>
 * 预算年月定义表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@Service
public class FundBudgetYearMonthServiceImpl extends BaseServiceImpl<FundBudgetYearMonthMapper, FundBudgetYearMonth> implements FundBudgetYearMonthService {

    @Autowired
    private FundBudgetYearMonthMapper fundBudgetYearMonthMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateFundBudgetYearMonth(BaseDataFundDto baseDataFundDto) {
        List<FundBudgetYearMonthDto> fundBudgetYearMonthDtos =baseDataFundDto.getFundBudgetYearMonths();

        List<FundBudgetYearMonth> fundBudgetYearMonthList=new ArrayList<>();
        for (FundBudgetYearMonthDto fundBudgetYearMonthDto :fundBudgetYearMonthDtos) {
            FundBudgetYearMonth fundBudgetYearMonth = new FundBudgetYearMonth();
            fundBudgetYearMonth.setId(fundBudgetYearMonthDto.getRowId());
            fundBudgetYearMonth.setYearMon(fundBudgetYearMonthDto.getYearMon());
            fundBudgetYearMonth.setEndDate(fundBudgetYearMonthDto.getEndDate());
            fundBudgetYearMonth.setStartDate(fundBudgetYearMonthDto.getStartDate());

            fundBudgetYearMonthList.add(fundBudgetYearMonth);
            Long RowId = fundBudgetYearMonth.getId();
        }
        super.saveOrUpdateBatch(fundBudgetYearMonthList);
        return RowId;
    }
    @Override
    public FundBudgetYearMonthVo getDetailFundBudgetYearMonth(Long RowId) {
        return null;
    }

    @Override
    public IPage<FundBudgetYearMonthVo> listFundBudgetYearMonth(FundBudgetYearMonthDto fundBudgetYearMonthDto) {
        Page<FundBudgetYearMonthVo> page = new Page<>(fundBudgetYearMonthDto.getPage(),fundBudgetYearMonthDto.getRows());
        IPage<FundBudgetYearMonthVo> res= fundBudgetYearMonthMapper.listFundBudgetYearMonth(page,fundBudgetYearMonthDto);
        //List<FundBudgetYearMonthVo> records=res.getRecords();
        //List<FundBudgetYearMonthVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteFundBudgetYearMonth(BaseDto baseDto) {
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
