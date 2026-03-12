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

import com.mediway.hos.srm.business.center.model.dto.fund.FundRmbsTravelItemDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundRmbsTravelItemVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundRmbsTravelItem;
import com.mediway.hos.srm.business.center.service.fund.FundRmbsTravelItemService;
import com.mediway.hos.srm.business.center.mapper.fund.FundRmbsTravelItemMapper;


/**
 * <p>
 * 差旅报销项目 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@Service
public class FundRmbsTravelItemServiceImpl extends BaseServiceImpl<FundRmbsTravelItemMapper, FundRmbsTravelItem> implements FundRmbsTravelItemService {

    @Autowired
    private FundRmbsTravelItemMapper fundRmbsTravelItemMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateFundRmbsTravelItem(BaseDataFundDto baseDataFundDto) {
        List<FundRmbsTravelItemDto> fundRmbsTravelItemDtos =baseDataFundDto.getFundRmbsTravelItems();

        List<FundRmbsTravelItem> fundRmbsTravelItemList=new ArrayList<>();
        for (FundRmbsTravelItemDto fundRmbsTravelItemDto :fundRmbsTravelItemDtos) {
            FundRmbsTravelItem fundRmbsTravelItem = new FundRmbsTravelItem();
            fundRmbsTravelItem.setId(fundRmbsTravelItemDto.getRowId());
            fundRmbsTravelItem.setCode(fundRmbsTravelItemDto.getCode());
            fundRmbsTravelItem.setName(fundRmbsTravelItemDto.getName());
            fundRmbsTravelItem.setIsValid(fundRmbsTravelItemDto.getIsValid());

            fundRmbsTravelItemList.add(fundRmbsTravelItem);
            Long RowId = fundRmbsTravelItem.getId();
        }
        super.saveOrUpdateBatch(fundRmbsTravelItemList);
        return RowId;
    }
    @Override
    public FundRmbsTravelItemVo getDetailFundRmbsTravelItem(Long RowId) {
        return null;
    }

    @Override
    public IPage<FundRmbsTravelItemVo> listFundRmbsTravelItem(FundRmbsTravelItemDto fundRmbsTravelItemDto) {
        Page<FundRmbsTravelItemVo> page = new Page<>(fundRmbsTravelItemDto.getPage(),fundRmbsTravelItemDto.getRows());
        IPage<FundRmbsTravelItemVo> res= fundRmbsTravelItemMapper.listFundRmbsTravelItem(page,fundRmbsTravelItemDto);
        //List<FundRmbsTravelItemVo> records=res.getRecords();
        //List<FundRmbsTravelItemVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteFundRmbsTravelItem(BaseDto baseDto) {
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
