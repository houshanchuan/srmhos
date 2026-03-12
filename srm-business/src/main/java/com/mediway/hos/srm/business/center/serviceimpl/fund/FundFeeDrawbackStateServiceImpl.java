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

import com.mediway.hos.srm.business.center.model.dto.fund.FundFeeDrawbackStateDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundFeeDrawbackStateVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundFeeDrawbackState;
import com.mediway.hos.srm.business.center.service.fund.FundFeeDrawbackStateService;
import com.mediway.hos.srm.business.center.mapper.fund.FundFeeDrawbackStateMapper;

/**
 * <p>
 * 费用退税状态 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@Service
public class FundFeeDrawbackStateServiceImpl extends BaseServiceImpl<FundFeeDrawbackStateMapper, FundFeeDrawbackState> implements FundFeeDrawbackStateService {

    @Autowired
    private FundFeeDrawbackStateMapper fundFeeDrawbackStateMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateFundFeeDrawbackState(BaseDataFundDto baseDataFundDto) {
        List<FundFeeDrawbackStateDto> fundFeeDrawbackStateDtos =baseDataFundDto.getFundFeeDrawbackStates();

        List<FundFeeDrawbackState> fundFeeDrawbackStateList=new ArrayList<>();
        for (FundFeeDrawbackStateDto fundFeeDrawbackStateDto :fundFeeDrawbackStateDtos) {
            FundFeeDrawbackState fundFeeDrawbackState = new FundFeeDrawbackState();
            fundFeeDrawbackState.setId(fundFeeDrawbackStateDto.getRowId());
            fundFeeDrawbackState.setCode(fundFeeDrawbackStateDto.getCode());
            fundFeeDrawbackState.setName(fundFeeDrawbackStateDto.getName());
            fundFeeDrawbackState.setIsValid(fundFeeDrawbackStateDto.getIsValid());

            fundFeeDrawbackStateList.add(fundFeeDrawbackState);
            Long RowId = fundFeeDrawbackState.getId();
        }
        super.saveOrUpdateBatch(fundFeeDrawbackStateList);
        return RowId;
    }
    @Override
    public FundFeeDrawbackStateVo getDetailFundFeeDrawbackState(Long RowId) {
        return null;
    }

    @Override
    public IPage<FundFeeDrawbackStateVo> listFundFeeDrawbackState(FundFeeDrawbackStateDto fundFeeDrawbackStateDto) {
        Page<FundFeeDrawbackStateVo> page = new Page<>(fundFeeDrawbackStateDto.getPage(),fundFeeDrawbackStateDto.getRows());
        IPage<FundFeeDrawbackStateVo> res= fundFeeDrawbackStateMapper.listFundFeeDrawbackState(page,fundFeeDrawbackStateDto);
        //List<FundFeeDrawbackStateVo> records=res.getRecords();
        //List<FundFeeDrawbackStateVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteFundFeeDrawbackState(BaseDto baseDto) {
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
