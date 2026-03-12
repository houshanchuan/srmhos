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
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.fund.FundTravelVehicleDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundTravelVehicleVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundTravelVehicle;
import com.mediway.hos.srm.business.center.service.fund.FundTravelVehicleService;
import com.mediway.hos.srm.business.center.mapper.fund.FundTravelVehicleMapper;


/**
 * <p>
 * 交通工具 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@Service
public class FundTravelVehicleServiceImpl extends BaseServiceImpl<FundTravelVehicleMapper, FundTravelVehicle> implements FundTravelVehicleService {

    @Autowired
    private FundTravelVehicleMapper fundTravelVehicleMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateFundTravelVehicle(BaseDataFundDto baseDataFundDto) {
        List<FundTravelVehicleDto> fundTravelVehicleDtos =baseDataFundDto.getFundTravelVehicles();

        List<FundTravelVehicle> fundTravelVehicleList=new ArrayList<>();
        for (FundTravelVehicleDto fundTravelVehicleDto :fundTravelVehicleDtos) {
            FundTravelVehicle fundTravelVehicle = new FundTravelVehicle();
            fundTravelVehicle.setId(fundTravelVehicleDto.getRowId());
            fundTravelVehicle.setCode(fundTravelVehicleDto.getCode());
            fundTravelVehicle.setName(fundTravelVehicleDto.getName());
            fundTravelVehicle.setIsValid(fundTravelVehicleDto.getIsValid());

            fundTravelVehicleList.add(fundTravelVehicle);
            Long RowId = fundTravelVehicle.getId();
        }
        super.saveOrUpdateBatch(fundTravelVehicleList);
        return RowId;
    }
    @Override
    public FundTravelVehicleVo getDetailFundTravelVehicle(Long RowId) {
        return null;
    }

    @Override
    public IPage<FundTravelVehicleVo> listFundTravelVehicle(FundTravelVehicleDto fundTravelVehicleDto) {
        Page<FundTravelVehicleVo> page = new Page<>(fundTravelVehicleDto.getPage(),fundTravelVehicleDto.getRows());
        IPage<FundTravelVehicleVo> res= fundTravelVehicleMapper.listFundTravelVehicle(page,fundTravelVehicleDto);
        //List<FundTravelVehicleVo> records=res.getRecords();
        //List<FundTravelVehicleVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteFundTravelVehicle(BaseDto baseDto) {
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

    @Override
    public List<CombVo> getVehicle(){
        return fundTravelVehicleMapper.getVehicle() ;
    }
}
