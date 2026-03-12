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

import com.mediway.hos.srm.business.center.model.dto.fund.FundBillCheckStateDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBillCheckStateVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundBillCheckState;
import com.mediway.hos.srm.business.center.service.fund.FundBillCheckStateService;
import com.mediway.hos.srm.business.center.mapper.fund.FundBillCheckStateMapper;

/**
 * <p>
 * 单据审核状态 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@Service
public class FundBillCheckStateServiceImpl extends BaseServiceImpl<FundBillCheckStateMapper, FundBillCheckState> implements FundBillCheckStateService {

    @Autowired
    private FundBillCheckStateMapper fundBillCheckStateMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateFundBillCheckState(BaseDataFundDto baseDataFundDto) {
        List<FundBillCheckStateDto> fundBillCheckStateDtos =baseDataFundDto.getFundBillCheckStates();

        List<FundBillCheckState> fundBillCheckStateList=new ArrayList<>();
        for (FundBillCheckStateDto fundBillCheckStateDto :fundBillCheckStateDtos) {
            FundBillCheckState fundBillCheckState = new FundBillCheckState();
            fundBillCheckState.setId(fundBillCheckStateDto.getRowId());
            fundBillCheckState.setCode(fundBillCheckStateDto.getCode());
            fundBillCheckState.setName(fundBillCheckStateDto.getName());
            fundBillCheckState.setIsValid(fundBillCheckStateDto.getIsValid());

            fundBillCheckStateList.add(fundBillCheckState);
            Long RowId = fundBillCheckState.getId();
        }
        super.saveOrUpdateBatch(fundBillCheckStateList);
        return RowId;
    }
    @Override
    public FundBillCheckStateVo getDetailFundBillCheckState(Long RowId) {
        return null;
    }

    @Override
    public IPage<FundBillCheckStateVo> listFundBillCheckState(FundBillCheckStateDto fundBillCheckStateDto) {
        Page<FundBillCheckStateVo> page = new Page<>(fundBillCheckStateDto.getPage(),fundBillCheckStateDto.getRows());
        IPage<FundBillCheckStateVo> res= fundBillCheckStateMapper.listFundBillCheckState(page,fundBillCheckStateDto);
        //List<FundBillCheckStateVo> records=res.getRecords();
        //List<FundBillCheckStateVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteFundBillCheckState(BaseDto baseDto) {
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
