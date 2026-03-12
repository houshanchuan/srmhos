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

import com.mediway.hos.srm.business.center.model.dto.fund.FundProjBudgetStandardDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundProjBudgetStandardVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundProjBudgetStandard;
import com.mediway.hos.srm.business.center.service.fund.FundProjBudgetStandardService;
import com.mediway.hos.srm.business.center.mapper.fund.FundProjBudgetStandardMapper;


/**
 * <p>
 * 项目分类预算标准 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@Service
public class FundProjBudgetStandardServiceImpl extends BaseServiceImpl<FundProjBudgetStandardMapper, FundProjBudgetStandard> implements FundProjBudgetStandardService {

    @Autowired
    private FundProjBudgetStandardMapper fundProjBudgetStandardMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateFundProjBudgetStandard(BaseDataFundDto baseDataFundDto) {
        List<FundProjBudgetStandardDto> fundProjBudgetStandardDtos =baseDataFundDto.getFundProjBudgetStandards();

        List<FundProjBudgetStandard> fundProjBudgetStandardList=new ArrayList<>();
        for (FundProjBudgetStandardDto fundProjBudgetStandardDto :fundProjBudgetStandardDtos) {
            FundProjBudgetStandard fundProjBudgetStandard = new FundProjBudgetStandard();
            fundProjBudgetStandard.setId(fundProjBudgetStandardDto.getRowId());
            fundProjBudgetStandard.setCode(fundProjBudgetStandardDto.getCode());
            fundProjBudgetStandard.setName(fundProjBudgetStandardDto.getName());
            fundProjBudgetStandard.setIsValid(fundProjBudgetStandardDto.getIsValid());
            fundProjBudgetStandard.setProjType(fundProjBudgetStandardDto.getProjType());
            fundProjBudgetStandard.setStartYear(fundProjBudgetStandardDto.getStartYear());
            fundProjBudgetStandard.setEndYear(fundProjBudgetStandardDto.getEndYear());
            fundProjBudgetStandardList.add(fundProjBudgetStandard);
            Long RowId = fundProjBudgetStandard.getId();
        }
        super.saveOrUpdateBatch(fundProjBudgetStandardList);
        return RowId;
    }
    @Override
    public FundProjBudgetStandardVo getDetailFundProjBudgetStandard(Long RowId) {
        return null;
    }

    @Override
    public IPage<FundProjBudgetStandardVo> listFundProjBudgetStandard(FundProjBudgetStandardDto fundProjBudgetStandardDto) {
        Page<FundProjBudgetStandardVo> page = new Page<>(fundProjBudgetStandardDto.getPage(),fundProjBudgetStandardDto.getRows());
        IPage<FundProjBudgetStandardVo> res= fundProjBudgetStandardMapper.listFundProjBudgetStandard(page,fundProjBudgetStandardDto);
        //List<FundProjBudgetStandardVo> records=res.getRecords();
        //List<FundProjBudgetStandardVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteFundProjBudgetStandard(BaseDto baseDto) {
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
