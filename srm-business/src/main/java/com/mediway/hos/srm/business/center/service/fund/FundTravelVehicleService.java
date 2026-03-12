package com.mediway.hos.srm.business.center.service.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataFundDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.fund.FundTravelVehicleDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundTravelVehicleVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundTravelVehicle;
/**
 * <p>
 * 交通工具 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundTravelVehicleService extends BaseService<FundTravelVehicle> {

    @Transactional
    Long saveOrUpdateFundTravelVehicle(BaseDataFundDto baseDataFundDto);

    FundTravelVehicleVo getDetailFundTravelVehicle(Long RowId);
    IPage<FundTravelVehicleVo> listFundTravelVehicle(FundTravelVehicleDto fundTravelVehicleDto);

    void deleteFundTravelVehicle(BaseDto baseDto);

    Long getIdByName(String name);

    List<CombVo> getVehicle();
}
