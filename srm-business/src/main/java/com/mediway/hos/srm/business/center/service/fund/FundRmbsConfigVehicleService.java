package com.mediway.hos.srm.business.center.service.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataFundDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.dto.fund.FundRmbsConfigVehicleDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundRmbsConfigVehicleVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundRmbsConfigVehicle;

/**
 * <p>
 * 交通工具费用报销标准配置表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundRmbsConfigVehicleService extends BaseService<FundRmbsConfigVehicle> {

    @Transactional
    Long saveOrUpdateFundRmbsConfigVehicle(BaseDataFundDto baseDataFundDto);

    FundRmbsConfigVehicleVo getDetailFundRmbsConfigVehicle(Long RowId);

    IPage<FundRmbsConfigVehicleVo> listFundRmbsConfigVehicle(FundRmbsConfigVehicleDto fundRmbsConfigVehicleDto);

    void deleteFundRmbsConfigVehicle(BaseDto baseDto);

    Long getIdByName(String name);
}
