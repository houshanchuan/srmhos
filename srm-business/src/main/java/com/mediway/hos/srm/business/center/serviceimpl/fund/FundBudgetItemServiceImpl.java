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
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetItemDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetItemVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundBudgetItem;
import com.mediway.hos.srm.business.center.service.fund.FundBudgetItemService;
import com.mediway.hos.srm.business.center.mapper.fund.FundBudgetItemMapper;

/**
 * <p>
 * 预算项目(科目)表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@Service
public class FundBudgetItemServiceImpl extends BaseServiceImpl<FundBudgetItemMapper, FundBudgetItem> implements FundBudgetItemService {

    @Autowired
    private FundBudgetItemMapper fundBudgetItemMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateFundBudgetItem(BaseDataFundDto baseDataFundDto) {
        List<FundBudgetItemDto> fundBudgetItemDtos =baseDataFundDto.getFundBudgetItems();

        List<FundBudgetItem> fundBudgetItemList=new ArrayList<>();
        for (FundBudgetItemDto fundBudgetItemDto :fundBudgetItemDtos) {
            FundBudgetItem fundBudgetItem = new FundBudgetItem();
            fundBudgetItem.setId(fundBudgetItemDto.getRowId());
            fundBudgetItem.setCode(fundBudgetItemDto.getCode());
            fundBudgetItem.setName(fundBudgetItemDto.getName());
            fundBudgetItem.setItemOrder(fundBudgetItemDto.getItemOrder());
            fundBudgetItem.setItemType(fundBudgetItemDto.getItemType());
            fundBudgetItem.setAuDeptFirst(fundBudgetItemDto.getAuDeptFirst());
            fundBudgetItem.setAuDeptSecond(fundBudgetItemDto.getAuDeptSecond());
            fundBudgetItem.setCalUnitCode(fundBudgetItemDto.getCalUnitCode());
            fundBudgetItem.setDeptDuty(fundBudgetItemDto.getDeptDuty());
            fundBudgetItem.setDirection(fundBudgetItemDto.getDirection());
            fundBudgetItem.setIsCash(fundBudgetItemDto.getIsCash());
            fundBudgetItem.setIsGovBuy(fundBudgetItemDto.getIsGovBuy());
            fundBudgetItem.setIsLast(fundBudgetItemDto.getIsLast());
            fundBudgetItem.setIsResult(fundBudgetItemDto.getIsResult());
            fundBudgetItem.setIsSpecial(fundBudgetItemDto.getIsSpecial());
            fundBudgetItem.setLevel(fundBudgetItemDto.getLevel());
            fundBudgetItem.setNameAll(fundBudgetItemDto.getNameAll());
            fundBudgetItem.setNote(fundBudgetItemDto.getNote());
            fundBudgetItem.setSpell(fundBudgetItemDto.getSpell());
            fundBudgetItem.setUpCode(fundBudgetItemDto.getUpCode());
            fundBudgetItemList.add(fundBudgetItem);
            Long RowId = fundBudgetItem.getId();
        }
        super.saveOrUpdateBatch(fundBudgetItemList);
        return RowId;
    }
    @Override
    public FundBudgetItemVo getDetailFundBudgetItem(Long RowId) {
        return null;
    }

    @Override
    public IPage<FundBudgetItemVo> listFundBudgetItem(FundBudgetItemDto fundBudgetItemDto) {
        Page<FundBudgetItemVo> page = new Page<>(fundBudgetItemDto.getPage(),fundBudgetItemDto.getRows());
        IPage<FundBudgetItemVo> res= fundBudgetItemMapper.listFundBudgetItem(page,fundBudgetItemDto);
        //List<FundBudgetItemVo> records=res.getRecords();
        //List<FundBudgetItemVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteFundBudgetItem(BaseDto baseDto) {
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

    @Override
    public List<CombVo> getItemCode() {
        return fundBudgetItemMapper.getItemCode();
    }

}
