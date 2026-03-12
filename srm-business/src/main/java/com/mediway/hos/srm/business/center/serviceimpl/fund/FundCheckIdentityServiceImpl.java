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

import com.mediway.hos.srm.business.center.model.dto.fund.FundCheckIdentityDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundCheckIdentityVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundCheckIdentity;
import com.mediway.hos.srm.business.center.service.fund.FundCheckIdentityService;
import com.mediway.hos.srm.business.center.mapper.fund.FundCheckIdentityMapper;
/**
 * <p>
 * 审批流角色身份标识名称表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@Service
public class FundCheckIdentityServiceImpl extends BaseServiceImpl<FundCheckIdentityMapper, FundCheckIdentity> implements FundCheckIdentityService {

    @Autowired
    private FundCheckIdentityMapper fundCheckIdentityMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateFundCheckIdentity(BaseDataFundDto baseDataFundDto) {
        List<FundCheckIdentityDto> fundCheckIdentityDtos =baseDataFundDto.getFundCheckIdentitys();

        List<FundCheckIdentity> fundCheckIdentityList=new ArrayList<>();
        for (FundCheckIdentityDto fundCheckIdentityDto :fundCheckIdentityDtos) {
            FundCheckIdentity fundCheckIdentity = new FundCheckIdentity();
            fundCheckIdentity.setId(fundCheckIdentityDto.getRowId());
            fundCheckIdentity.setCode(fundCheckIdentityDto.getCode());
            fundCheckIdentity.setName(fundCheckIdentityDto.getName());
            fundCheckIdentity.setIsValid(fundCheckIdentityDto.getIsValid());

            fundCheckIdentityList.add(fundCheckIdentity);
            Long RowId = fundCheckIdentity.getId();
        }
        super.saveOrUpdateBatch(fundCheckIdentityList);
        return RowId;
    }
    @Override
    public FundCheckIdentityVo getDetailFundCheckIdentity(Long RowId) {
        return null;
    }

    @Override
    public IPage<FundCheckIdentityVo> listFundCheckIdentity(FundCheckIdentityDto fundCheckIdentityDto) {
        Page<FundCheckIdentityVo> page = new Page<>(fundCheckIdentityDto.getPage(),fundCheckIdentityDto.getRows());
        IPage<FundCheckIdentityVo> res= fundCheckIdentityMapper.listFundCheckIdentity(page,fundCheckIdentityDto);
        //List<FundCheckIdentityVo> records=res.getRecords();
        //List<FundCheckIdentityVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteFundCheckIdentity(BaseDto baseDto) {
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
