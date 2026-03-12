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

import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetItemDeptGrantDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetItemDeptGrantVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundBudgetItemDeptGrant;
import com.mediway.hos.srm.business.center.service.fund.FundBudgetItemDeptGrantService;
import com.mediway.hos.srm.business.center.mapper.fund.FundBudgetItemDeptGrantMapper;

/**
 * <p>
 * 科目归口科室设置 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@Service
public class FundBudgetItemDeptGrantServiceImpl extends BaseServiceImpl<FundBudgetItemDeptGrantMapper, FundBudgetItemDeptGrant> implements FundBudgetItemDeptGrantService {

    @Autowired
    private FundBudgetItemDeptGrantMapper fundBudgetItemDeptGrantMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateFundBudgetItemDeptGrant(BaseDataFundDto baseDataFundDto) {
        List<FundBudgetItemDeptGrantDto> fundBudgetItemDeptGrantDtos =baseDataFundDto.getFundBudgetItemDeptGrants();

        List<FundBudgetItemDeptGrant> fundBudgetItemDeptGrantList=new ArrayList<>();
        for (FundBudgetItemDeptGrantDto fundBudgetItemDeptGrantDto :fundBudgetItemDeptGrantDtos) {
            FundBudgetItemDeptGrant fundBudgetItemDeptGrant = new FundBudgetItemDeptGrant();
            fundBudgetItemDeptGrant.setId(fundBudgetItemDeptGrantDto.getRowId());
            fundBudgetItemDeptGrant.setHospCode(fundBudgetItemDeptGrantDto.getHospCode());
            fundBudgetItemDeptGrant.setItemCode(fundBudgetItemDeptGrantDto.getItemCode());
            fundBudgetItemDeptGrant.setDeptCode(fundBudgetItemDeptGrantDto.getDeptCode());

            fundBudgetItemDeptGrantList.add(fundBudgetItemDeptGrant);
            Long RowId = fundBudgetItemDeptGrant.getId();
        }
        super.saveOrUpdateBatch(fundBudgetItemDeptGrantList);
        return RowId;
    }
    @Override
    public FundBudgetItemDeptGrantVo getDetailFundBudgetItemDeptGrant(Long RowId) {
        return null;
    }

    @Override
    public IPage<FundBudgetItemDeptGrantVo> listFundBudgetItemDeptGrant(FundBudgetItemDeptGrantDto fundBudgetItemDeptGrantDto) {
        Page<FundBudgetItemDeptGrantVo> page = new Page<>(fundBudgetItemDeptGrantDto.getPage(),fundBudgetItemDeptGrantDto.getRows());
        IPage<FundBudgetItemDeptGrantVo> res= fundBudgetItemDeptGrantMapper.listFundBudgetItemDeptGrant(page,fundBudgetItemDeptGrantDto);
        //List<FundBudgetItemDeptGrantVo> records=res.getRecords();
        //List<FundBudgetItemDeptGrantVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteFundBudgetItemDeptGrant(BaseDto baseDto) {
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
