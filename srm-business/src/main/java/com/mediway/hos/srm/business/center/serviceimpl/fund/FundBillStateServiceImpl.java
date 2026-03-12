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

import com.mediway.hos.srm.business.center.model.dto.fund.FundBillStateDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBillStateVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundBillState;
import com.mediway.hos.srm.business.center.service.fund.FundBillStateService;
import com.mediway.hos.srm.business.center.mapper.fund.FundBillStateMapper;


/**
 * <p>
 * 经费单据状态 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@Service
public class FundBillStateServiceImpl extends BaseServiceImpl<FundBillStateMapper, FundBillState> implements FundBillStateService {

    @Autowired
    private FundBillStateMapper fundBillStateMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateFundBillState(BaseDataFundDto baseDataFundDto) {
        List<FundBillStateDto> fundBillStateDtos =baseDataFundDto.getFundBillStates();

        List<FundBillState> fundBillStateList=new ArrayList<>();
        for (FundBillStateDto fundBillStateDto :fundBillStateDtos) {
            FundBillState fundBillState = new FundBillState();
            fundBillState.setId(fundBillStateDto.getRowId());
            fundBillState.setCode(fundBillStateDto.getCode());
            fundBillState.setName(fundBillStateDto.getName());
            fundBillState.setIsValid(fundBillStateDto.getIsValid());

            fundBillStateList.add(fundBillState);
            Long RowId = fundBillState.getId();
        }
        super.saveOrUpdateBatch(fundBillStateList);
        return RowId;
    }
    @Override
    public FundBillStateVo getDetailFundBillState(Long RowId) {
        return null;
    }

    @Override
    public IPage<FundBillStateVo> listFundBillState(FundBillStateDto fundBillStateDto) {
        Page<FundBillStateVo> page = new Page<>(fundBillStateDto.getPage(),fundBillStateDto.getRows());
        IPage<FundBillStateVo> res= fundBillStateMapper.listFundBillState(page,fundBillStateDto);
        //List<FundBillStateVo> records=res.getRecords();
        //List<FundBillStateVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteFundBillState(BaseDto baseDto) {
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
