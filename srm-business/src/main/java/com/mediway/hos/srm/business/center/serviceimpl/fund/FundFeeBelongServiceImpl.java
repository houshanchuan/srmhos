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

import com.mediway.hos.srm.business.center.model.dto.fund.FundFeeBelongDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundFeeBelongVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundFeeBelong;
import com.mediway.hos.srm.business.center.service.fund.FundFeeBelongService;
import com.mediway.hos.srm.business.center.mapper.fund.FundFeeBelongMapper;

/**
 * <p>
 * 经费归属 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@Service
public class FundFeeBelongServiceImpl extends BaseServiceImpl<FundFeeBelongMapper, FundFeeBelong> implements FundFeeBelongService {

    @Autowired
    private FundFeeBelongMapper fundFeeBelongMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateFundFeeBelong(BaseDataFundDto baseDataFundDto) {
        List<FundFeeBelongDto> fundFeeBelongDtos =baseDataFundDto.getFundFeeBelongs();

        List<FundFeeBelong> fundFeeBelongList=new ArrayList<>();
        for (FundFeeBelongDto fundFeeBelongDto :fundFeeBelongDtos) {
            FundFeeBelong fundFeeBelong = new FundFeeBelong();
            fundFeeBelong.setId(fundFeeBelongDto.getRowId());
            fundFeeBelong.setCode(fundFeeBelongDto.getCode());
            fundFeeBelong.setName(fundFeeBelongDto.getName());
            fundFeeBelong.setIsValid(fundFeeBelongDto.getIsValid());

            fundFeeBelongList.add(fundFeeBelong);
            Long RowId = fundFeeBelong.getId();
        }
        super.saveOrUpdateBatch(fundFeeBelongList);
        return RowId;
    }
    @Override
    public FundFeeBelongVo getDetailFundFeeBelong(Long RowId) {
        return null;
    }

    @Override
    public IPage<FundFeeBelongVo> listFundFeeBelong(FundFeeBelongDto fundFeeBelongDto) {
        Page<FundFeeBelongVo> page = new Page<>(fundFeeBelongDto.getPage(),fundFeeBelongDto.getRows());
        IPage<FundFeeBelongVo> res= fundFeeBelongMapper.listFundFeeBelong(page,fundFeeBelongDto);
        //List<FundFeeBelongVo> records=res.getRecords();
        //List<FundFeeBelongVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteFundFeeBelong(BaseDto baseDto) {
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
