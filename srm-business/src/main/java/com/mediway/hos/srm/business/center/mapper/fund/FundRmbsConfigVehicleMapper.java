package com.mediway.hos.srm.business.center.mapper.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.fund.FundRmbsConfigVehicleDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundRmbsConfigVehicleVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundRmbsConfigVehicle;

/**
 * <p>
 * 交通工具费用报销标准配置表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundRmbsConfigVehicleMapper extends BaseMapper<FundRmbsConfigVehicle> {

    IPage<FundRmbsConfigVehicleVo> listFundRmbsConfigVehicle(@Param("page") Page<FundRmbsConfigVehicleVo> page, @Param("fundRmbsConfigVehicleDto") FundRmbsConfigVehicleDto fundRmbsConfigVehicleDto);

}
