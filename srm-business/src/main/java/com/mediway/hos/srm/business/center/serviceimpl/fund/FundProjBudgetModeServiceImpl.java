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

import com.mediway.hos.srm.business.center.model.dto.fund.FundProjBudgetModeDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundProjBudgetModeVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundProjBudgetMode;
import com.mediway.hos.srm.business.center.service.fund.FundProjBudgetModeService;
import com.mediway.hos.srm.business.center.mapper.fund.FundProjBudgetModeMapper;

/**
 * <p>
 * 项目预算编制模式 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@Service
public class FundProjBudgetModeServiceImpl extends BaseServiceImpl<FundProjBudgetModeMapper, FundProjBudgetMode> implements FundProjBudgetModeService {

    @Autowired
    private FundProjBudgetModeMapper fundProjBudgetModeMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateFundProjBudgetMode(BaseDataFundDto baseDataFundDto) {
        List<FundProjBudgetModeDto> fundProjBudgetModeDtos =baseDataFundDto.getFundProjBudgetModes();

        List<FundProjBudgetMode> fundProjBudgetModeList=new ArrayList<>();
        for (FundProjBudgetModeDto fundProjBudgetModeDto :fundProjBudgetModeDtos) {
            FundProjBudgetMode fundProjBudgetMode = new FundProjBudgetMode();
            fundProjBudgetMode.setId(fundProjBudgetModeDto.getRowId());
            fundProjBudgetMode.setCode(fundProjBudgetModeDto.getCode());
            fundProjBudgetMode.setName(fundProjBudgetModeDto.getName());
            fundProjBudgetMode.setIsValid(fundProjBudgetModeDto.getIsValid());

            fundProjBudgetModeList.add(fundProjBudgetMode);
            Long RowId = fundProjBudgetMode.getId();
        }
        super.saveOrUpdateBatch(fundProjBudgetModeList);
        return RowId;
    }
    @Override
    public FundProjBudgetModeVo getDetailFundProjBudgetMode(Long RowId) {
        return null;
    }

    @Override
    public IPage<FundProjBudgetModeVo> listFundProjBudgetMode(FundProjBudgetModeDto fundProjBudgetModeDto) {
        Page<FundProjBudgetModeVo> page = new Page<>(fundProjBudgetModeDto.getPage(),fundProjBudgetModeDto.getRows());
        IPage<FundProjBudgetModeVo> res= fundProjBudgetModeMapper.listFundProjBudgetMode(page,fundProjBudgetModeDto);
        //List<FundProjBudgetModeVo> records=res.getRecords();
        //List<FundProjBudgetModeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteFundProjBudgetMode(BaseDto baseDto) {
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
