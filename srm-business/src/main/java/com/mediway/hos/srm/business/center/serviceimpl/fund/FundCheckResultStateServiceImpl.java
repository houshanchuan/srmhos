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

import com.mediway.hos.srm.business.center.model.dto.fund.FundCheckResultStateDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundCheckResultStateVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundCheckResultState;
import com.mediway.hos.srm.business.center.service.fund.FundCheckResultStateService;
import com.mediway.hos.srm.business.center.mapper.fund.FundCheckResultStateMapper;

/**
 * <p>
 * 审批结果状态代码表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@Service
public class FundCheckResultStateServiceImpl extends BaseServiceImpl<FundCheckResultStateMapper, FundCheckResultState> implements FundCheckResultStateService {

    @Autowired
    private FundCheckResultStateMapper fundCheckResultStateMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateFundCheckResultState(BaseDataFundDto baseDataFundDto) {
        List<FundCheckResultStateDto> fundCheckResultStateDtos =baseDataFundDto.getFundCheckResultStates();

        List<FundCheckResultState> fundCheckResultStateList=new ArrayList<>();
        for (FundCheckResultStateDto fundCheckResultStateDto :fundCheckResultStateDtos) {
            FundCheckResultState fundCheckResultState = new FundCheckResultState();
            fundCheckResultState.setId(fundCheckResultStateDto.getRowId());
            fundCheckResultState.setCode(fundCheckResultStateDto.getCode());
            fundCheckResultState.setName(fundCheckResultStateDto.getName());
            fundCheckResultState.setIsValid(fundCheckResultStateDto.getIsValid());

            fundCheckResultStateList.add(fundCheckResultState);
            Long RowId = fundCheckResultState.getId();
        }
        super.saveOrUpdateBatch(fundCheckResultStateList);
        return RowId;
    }
    @Override
    public FundCheckResultStateVo getDetailFundCheckResultState(Long RowId) {
        return null;
    }

    @Override
    public IPage<FundCheckResultStateVo> listFundCheckResultState(FundCheckResultStateDto fundCheckResultStateDto) {
        Page<FundCheckResultStateVo> page = new Page<>(fundCheckResultStateDto.getPage(),fundCheckResultStateDto.getRows());
        IPage<FundCheckResultStateVo> res= fundCheckResultStateMapper.listFundCheckResultState(page,fundCheckResultStateDto);
        //List<FundCheckResultStateVo> records=res.getRecords();
        //List<FundCheckResultStateVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteFundCheckResultState(BaseDto baseDto) {
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
