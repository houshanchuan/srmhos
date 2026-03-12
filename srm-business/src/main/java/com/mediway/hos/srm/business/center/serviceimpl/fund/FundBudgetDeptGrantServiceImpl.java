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

import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetDeptGrantDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetDeptGrantVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundBudgetDeptGrant;
import com.mediway.hos.srm.business.center.service.fund.FundBudgetDeptGrantService;
import com.mediway.hos.srm.business.center.mapper.fund.FundBudgetDeptGrantMapper;

/**
 * <p>
 * 预算科室访问权限 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@Service
public class FundBudgetDeptGrantServiceImpl extends BaseServiceImpl<FundBudgetDeptGrantMapper, FundBudgetDeptGrant> implements FundBudgetDeptGrantService {

    @Autowired
    private FundBudgetDeptGrantMapper fundBudgetDeptGrantMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateFundBudgetDeptGrant(BaseDataFundDto baseDataFundDto) {
        List<FundBudgetDeptGrantDto> fundBudgetDeptGrantDtos =baseDataFundDto.getFundBudgetDeptGrants();

        List<FundBudgetDeptGrant> fundBudgetDeptGrantList=new ArrayList<>();
        for (FundBudgetDeptGrantDto fundBudgetDeptGrantDto :fundBudgetDeptGrantDtos) {
            FundBudgetDeptGrant fundBudgetDeptGrant = new FundBudgetDeptGrant();
            fundBudgetDeptGrant.setId(fundBudgetDeptGrantDto.getRowId());
            fundBudgetDeptGrant.setDeptCode(fundBudgetDeptGrantDto.getDeptCode());
            fundBudgetDeptGrant.setHospCode(fundBudgetDeptGrantDto.getHospCode());
            fundBudgetDeptGrant.setUserCode(fundBudgetDeptGrantDto.getUserCode());
            fundBudgetDeptGrantList.add(fundBudgetDeptGrant);
            Long RowId = fundBudgetDeptGrant.getId();
        }
        super.saveOrUpdateBatch(fundBudgetDeptGrantList);
        return RowId;
    }
    @Override
    public FundBudgetDeptGrantVo getDetailFundBudgetDeptGrant(Long RowId) {
        return null;
    }

    @Override
    public IPage<FundBudgetDeptGrantVo> listFundBudgetDeptGrant(FundBudgetDeptGrantDto fundBudgetDeptGrantDto) {
        Page<FundBudgetDeptGrantVo> page = new Page<>(fundBudgetDeptGrantDto.getPage(),fundBudgetDeptGrantDto.getRows());
        IPage<FundBudgetDeptGrantVo> res= fundBudgetDeptGrantMapper.listFundBudgetDeptGrant(page,fundBudgetDeptGrantDto);
        //List<FundBudgetDeptGrantVo> records=res.getRecords();
        //List<FundBudgetDeptGrantVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteFundBudgetDeptGrant(BaseDto baseDto) {
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
