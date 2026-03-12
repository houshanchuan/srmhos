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

import com.mediway.hos.srm.business.center.model.dto.fund.FundProjectUserGrantDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundProjectUserGrantVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundProjectUserGrant;
import com.mediway.hos.srm.business.center.service.fund.FundProjectUserGrantService;
import com.mediway.hos.srm.business.center.mapper.fund.FundProjectUserGrantMapper;

/**
 * <p>
 * 项目授权分析 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@Service
public class FundProjectUserGrantServiceImpl extends BaseServiceImpl<FundProjectUserGrantMapper, FundProjectUserGrant> implements FundProjectUserGrantService {

    @Autowired
    private FundProjectUserGrantMapper fundProjectUserGrantMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateFundProjectUserGrant(BaseDataFundDto baseDataFundDto) {
        List<FundProjectUserGrantDto> fundProjectUserGrantDtos =baseDataFundDto.getFundProjectUserGrants();

        List<FundProjectUserGrant> fundProjectUserGrantList=new ArrayList<>();
        for (FundProjectUserGrantDto fundProjectUserGrantDto :fundProjectUserGrantDtos) {
            FundProjectUserGrant fundProjectUserGrant = new FundProjectUserGrant();
            fundProjectUserGrant.setId(fundProjectUserGrantDto.getRowId());
            fundProjectUserGrant.setIsGranted(fundProjectUserGrantDto.getIsGranted());
            fundProjectUserGrant.setProjectType(fundProjectUserGrantDto.getProjectType());
            fundProjectUserGrant.setProjectId(fundProjectUserGrantDto.getProjectId());
            fundProjectUserGrant.setUserId(fundProjectUserGrantDto.getUserId());
            fundProjectUserGrant.setExpType(fundProjectUserGrantDto.getExpType());

            fundProjectUserGrantList.add(fundProjectUserGrant);
            Long RowId = fundProjectUserGrant.getId();
        }
        super.saveOrUpdateBatch(fundProjectUserGrantList);
        return RowId;
    }
    @Override
    public FundProjectUserGrantVo getDetailFundProjectUserGrant(Long RowId) {
        return null;
    }

    @Override
    public IPage<FundProjectUserGrantVo> listFundProjectUserGrant(FundProjectUserGrantDto fundProjectUserGrantDto) {
        Page<FundProjectUserGrantVo> page = new Page<>(fundProjectUserGrantDto.getPage(),fundProjectUserGrantDto.getRows());
        IPage<FundProjectUserGrantVo> res= fundProjectUserGrantMapper.listFundProjectUserGrant(page,fundProjectUserGrantDto);
        //List<FundProjectUserGrantVo> records=res.getRecords();
        //List<FundProjectUserGrantVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteFundProjectUserGrant(BaseDto baseDto) {
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
