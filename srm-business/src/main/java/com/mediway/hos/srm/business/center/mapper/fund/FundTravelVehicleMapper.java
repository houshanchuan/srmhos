package com.mediway.hos.srm.business.center.mapper.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.fund.FundTravelVehicleDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundTravelVehicleVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundTravelVehicle;

/**
 * <p>
 * 交通工具 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundTravelVehicleMapper extends BaseMapper<FundTravelVehicle> {

    IPage<FundTravelVehicleVo> listFundTravelVehicle(@Param("page") Page<FundTravelVehicleVo> page, @Param("fundTravelVehicleDto") FundTravelVehicleDto fundTravelVehicleDto);

    List<CombVo> getVehicle();
}
