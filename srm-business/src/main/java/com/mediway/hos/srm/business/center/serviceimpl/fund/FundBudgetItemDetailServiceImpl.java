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

import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetItemDetailDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetItemDetailVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundBudgetItemDetail;
import com.mediway.hos.srm.business.center.service.fund.FundBudgetItemDetailService;
import com.mediway.hos.srm.business.center.mapper.fund.FundBudgetItemDetailMapper;


/**
 * <p>
 * 预算科目明细项 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@Service
public class FundBudgetItemDetailServiceImpl extends BaseServiceImpl<FundBudgetItemDetailMapper, FundBudgetItemDetail> implements FundBudgetItemDetailService {

    @Autowired
    private FundBudgetItemDetailMapper fundBudgetItemDetailMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateFundBudgetItemDetail(BaseDataFundDto baseDataFundDto) {
        List<FundBudgetItemDetailDto> fundBudgetItemDetailDtos =baseDataFundDto.getFundBudgetItemDetails();

        List<FundBudgetItemDetail> fundBudgetItemDetailList=new ArrayList<>();
        for (FundBudgetItemDetailDto fundBudgetItemDetailDto :fundBudgetItemDetailDtos) {
            FundBudgetItemDetail fundBudgetItemDetail = new FundBudgetItemDetail();
            fundBudgetItemDetail.setId(fundBudgetItemDetailDto.getRowId());
            fundBudgetItemDetail.setCode(fundBudgetItemDetailDto.getCode());
            fundBudgetItemDetail.setName(fundBudgetItemDetailDto.getName());
            fundBudgetItemDetail.setIsValid(fundBudgetItemDetailDto.getIsValid());

            fundBudgetItemDetailList.add(fundBudgetItemDetail);
            Long RowId = fundBudgetItemDetail.getId();
        }
        super.saveOrUpdateBatch(fundBudgetItemDetailList);
        return RowId;
    }
    @Override
    public FundBudgetItemDetailVo getDetailFundBudgetItemDetail(Long RowId) {
        return null;
    }

    @Override
    public IPage<FundBudgetItemDetailVo> listFundBudgetItemDetail(FundBudgetItemDetailDto fundBudgetItemDetailDto) {
        Page<FundBudgetItemDetailVo> page = new Page<>(fundBudgetItemDetailDto.getPage(),fundBudgetItemDetailDto.getRows());
        IPage<FundBudgetItemDetailVo> res= fundBudgetItemDetailMapper.listFundBudgetItemDetail(page,fundBudgetItemDetailDto);
        //List<FundBudgetItemDetailVo> records=res.getRecords();
        //List<FundBudgetItemDetailVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteFundBudgetItemDetail(BaseDto baseDto) {
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
