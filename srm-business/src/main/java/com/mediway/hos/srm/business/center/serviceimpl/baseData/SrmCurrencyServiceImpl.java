package com.mediway.hos.srm.business.center.serviceimpl.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.CurrencyDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.CurrencyVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmCurrency;
import com.mediway.hos.srm.business.center.service.baseData.SrmCurrencyService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmCurrencyMapper;
/**
 * <p>
 * 币种 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmCurrencyServiceImpl extends BaseServiceImpl<SrmCurrencyMapper, SrmCurrency> implements SrmCurrencyService {

    @Autowired
    private SrmCurrencyService  srmCurrencyService;
    @Autowired
    private SrmCurrencyMapper srmCurrencyMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateCurrency(BaseDataProjDto baseDataProjDto) {
        List<CurrencyDto> currencyDtos =baseDataProjDto.getCurrencys();

        List<SrmCurrency> currencyList=new ArrayList<>();
        for (CurrencyDto currencyDto :currencyDtos) {
            SrmCurrency srmCurrency = new SrmCurrency();
            srmCurrency.setId(currencyDto.getRowId());
            srmCurrency.setCode(currencyDto.getCode());
            srmCurrency.setName(currencyDto.getName());
            srmCurrency.setIsValid(Integer.valueOf(currencyDto.getIsValid()));

            currencyList.add(srmCurrency);
            Long RowId = srmCurrency.getId();
        }
        super.saveOrUpdateBatch(currencyList);
        return RowId;
    }
    @Override
    public CurrencyVo getDetailCurrency(Long RowId) {
        return null;
    }

    @Override
    public IPage<CurrencyVo> listCurrency(CurrencyDto currencyDto) {
        Page<CurrencyVo> page = new Page<>(currencyDto.getPage(), currencyDto.getRows());
        IPage<CurrencyVo> res= srmCurrencyMapper.listCurrency(page, currencyDto);
        //List<CurrencyVo> records=res.getRecords();
        //List<CurrencyVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteCurrency(BaseDto baseDto) {
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

    @Override
    public List<CombVo> getCurrency(CurrencyDto currencyDto) {
        return srmCurrencyMapper.getCurrency(currencyDto);
    }
}
