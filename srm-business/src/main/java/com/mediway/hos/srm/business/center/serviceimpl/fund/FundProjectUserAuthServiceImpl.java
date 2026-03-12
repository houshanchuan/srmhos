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

import com.mediway.hos.srm.business.center.model.dto.fund.FundProjectUserAuthDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundProjectUserAuthVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundProjectUserAuth;
import com.mediway.hos.srm.business.center.service.fund.FundProjectUserAuthService;
import com.mediway.hos.srm.business.center.mapper.fund.FundProjectUserAuthMapper;
/**
 * <p>
 * 预算项目授权 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@Service
public class FundProjectUserAuthServiceImpl extends BaseServiceImpl<FundProjectUserAuthMapper, FundProjectUserAuth> implements FundProjectUserAuthService {

    @Autowired
    private FundProjectUserAuthMapper fundProjectUserAuthMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateFundProjectUserAuth(BaseDataFundDto baseDataFundDto) {
        List<FundProjectUserAuthDto> fundProjectUserAuthDtos =baseDataFundDto.getFundProjectUserAuths();

        List<FundProjectUserAuth> fundProjectUserAuthList=new ArrayList<>();
        for (FundProjectUserAuthDto fundProjectUserAuthDto :fundProjectUserAuthDtos) {
            FundProjectUserAuth fundProjectUserAuth = new FundProjectUserAuth();
            fundProjectUserAuth.setId(fundProjectUserAuthDto.getRowId());
            fundProjectUserAuth.setProjectId(fundProjectUserAuthDto.getProjectId());
            fundProjectUserAuth.setIsAudit(fundProjectUserAuthDto.getIsAudit());
            fundProjectUserAuth.setIsSubmit(fundProjectUserAuthDto.getIsSubmit());
            fundProjectUserAuth.setUserId(fundProjectUserAuthDto.getUserId());

            fundProjectUserAuthList.add(fundProjectUserAuth);
            Long RowId = fundProjectUserAuth.getId();
        }
        super.saveOrUpdateBatch(fundProjectUserAuthList);
        return RowId;
    }
    @Override
    public FundProjectUserAuthVo getDetailFundProjectUserAuth(Long RowId) {
        return null;
    }

    @Override
    public IPage<FundProjectUserAuthVo> listFundProjectUserAuth(FundProjectUserAuthDto fundProjectUserAuthDto) {
        Page<FundProjectUserAuthVo> page = new Page<>(fundProjectUserAuthDto.getPage(),fundProjectUserAuthDto.getRows());
        IPage<FundProjectUserAuthVo> res= fundProjectUserAuthMapper.listFundProjectUserAuth(page,fundProjectUserAuthDto);
        //List<FundProjectUserAuthVo> records=res.getRecords();
        //List<FundProjectUserAuthVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteFundProjectUserAuth(BaseDto baseDto) {
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
