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

import com.mediway.hos.srm.business.center.model.dto.fund.FundRmbsConfigVehicleDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundRmbsConfigVehicleVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundRmbsConfigVehicle;
import com.mediway.hos.srm.business.center.service.fund.FundRmbsConfigVehicleService;
import com.mediway.hos.srm.business.center.mapper.fund.FundRmbsConfigVehicleMapper;

/**
 * <p>
 * 交通工具费用报销标准配置表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@Service
public class FundRmbsConfigVehicleServiceImpl extends BaseServiceImpl<FundRmbsConfigVehicleMapper, FundRmbsConfigVehicle> implements FundRmbsConfigVehicleService {

    @Autowired
    private FundRmbsConfigVehicleMapper fundRmbsConfigVehicleMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateFundRmbsConfigVehicle(BaseDataFundDto baseDataFundDto) {
        List<FundRmbsConfigVehicleDto> fundRmbsConfigVehicleDtos =baseDataFundDto.getFundRmbsConfigVehicles();

        List<FundRmbsConfigVehicle> fundRmbsConfigVehicleList=new ArrayList<>();
        for (FundRmbsConfigVehicleDto fundRmbsConfigVehicleDto :fundRmbsConfigVehicleDtos) {
            FundRmbsConfigVehicle fundRmbsConfigVehicle = new FundRmbsConfigVehicle();
            fundRmbsConfigVehicle.setId(fundRmbsConfigVehicleDto.getRowId());
            fundRmbsConfigVehicle.setTravelVehicle(fundRmbsConfigVehicleDto.getTravelVehicle());
            fundRmbsConfigVehicle.setIsValid(fundRmbsConfigVehicleDto.getIsValid());
            fundRmbsConfigVehicle.setCategory(fundRmbsConfigVehicleDto.getCategory());
            fundRmbsConfigVehicle.setHospCode(fundRmbsConfigVehicleDto.getHospCode());
            fundRmbsConfigVehicle.setAddrEnd(fundRmbsConfigVehicleDto.getAddrEnd());
            fundRmbsConfigVehicle.setAddrStart(fundRmbsConfigVehicleDto.getAddrStart());
            fundRmbsConfigVehicle.setTravelFee(fundRmbsConfigVehicleDto.getTravelFee());

            fundRmbsConfigVehicleList.add(fundRmbsConfigVehicle);
            Long RowId = fundRmbsConfigVehicle.getId();
        }
        super.saveOrUpdateBatch(fundRmbsConfigVehicleList);
        return RowId;
    }
    @Override
    public FundRmbsConfigVehicleVo getDetailFundRmbsConfigVehicle(Long RowId) {
        return null;
    }

    @Override
    public IPage<FundRmbsConfigVehicleVo> listFundRmbsConfigVehicle(FundRmbsConfigVehicleDto fundRmbsConfigVehicleDto) {
        Page<FundRmbsConfigVehicleVo> page = new Page<>(fundRmbsConfigVehicleDto.getPage(),fundRmbsConfigVehicleDto.getRows());
        IPage<FundRmbsConfigVehicleVo> res= fundRmbsConfigVehicleMapper.listFundRmbsConfigVehicle(page,fundRmbsConfigVehicleDto);
        //List<FundRmbsConfigVehicleVo> records=res.getRecords();
        //List<FundRmbsConfigVehicleVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteFundRmbsConfigVehicle(BaseDto baseDto) {
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
