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

import com.mediway.hos.srm.business.center.model.dto.fund.FundProjBudgetCheckStateDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundProjBudgetCheckStateVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundProjBudgetCheckState;
import com.mediway.hos.srm.business.center.service.fund.FundProjBudgetCheckStateService;
import com.mediway.hos.srm.business.center.mapper.fund.FundProjBudgetCheckStateMapper;

/**
 * <p>
 * 项目预算审核状态 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@Service
public class FundProjBudgetCheckStateServiceImpl extends BaseServiceImpl<FundProjBudgetCheckStateMapper, FundProjBudgetCheckState> implements FundProjBudgetCheckStateService {

    @Autowired
    private FundProjBudgetCheckStateMapper fundProjBudgetCheckStateMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateFundProjBudgetCheckState(BaseDataFundDto baseDataFundDto) {
        List<FundProjBudgetCheckStateDto> fundProjBudgetCheckStateDtos =baseDataFundDto.getFundProjBudgetCheckStates();

        List<FundProjBudgetCheckState> fundProjBudgetCheckStateList=new ArrayList<>();
        for (FundProjBudgetCheckStateDto fundProjBudgetCheckStateDto :fundProjBudgetCheckStateDtos) {
            FundProjBudgetCheckState fundProjBudgetCheckState = new FundProjBudgetCheckState();
            fundProjBudgetCheckState.setId(fundProjBudgetCheckStateDto.getRowId());
            fundProjBudgetCheckState.setCode(fundProjBudgetCheckStateDto.getCode());
            fundProjBudgetCheckState.setName(fundProjBudgetCheckStateDto.getName());
            fundProjBudgetCheckState.setIsValid(fundProjBudgetCheckStateDto.getIsValid());

            fundProjBudgetCheckStateList.add(fundProjBudgetCheckState);
            Long RowId = fundProjBudgetCheckState.getId();
        }
        super.saveOrUpdateBatch(fundProjBudgetCheckStateList);
        return RowId;
    }
    @Override
    public FundProjBudgetCheckStateVo getDetailFundProjBudgetCheckState(Long RowId) {
        return null;
    }

    @Override
    public IPage<FundProjBudgetCheckStateVo> listFundProjBudgetCheckState(FundProjBudgetCheckStateDto fundProjBudgetCheckStateDto) {
        Page<FundProjBudgetCheckStateVo> page = new Page<>(fundProjBudgetCheckStateDto.getPage(),fundProjBudgetCheckStateDto.getRows());
        IPage<FundProjBudgetCheckStateVo> res= fundProjBudgetCheckStateMapper.listFundProjBudgetCheckState(page,fundProjBudgetCheckStateDto);
        //List<FundProjBudgetCheckStateVo> records=res.getRecords();
        //List<FundProjBudgetCheckStateVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteFundProjBudgetCheckState(BaseDto baseDto) {
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
