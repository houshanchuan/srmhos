package com.mediway.hos.srm.business.center.mapper.fund;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.fund.FundCheckResultStateDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundCheckResultStateVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundCheckResultState;


/**
 * <p>
 * 审批结果状态代码表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundCheckResultStateMapper extends BaseMapper<FundCheckResultState> {

    IPage<FundCheckResultStateVo> listFundCheckResultState(@Param("page") Page<FundCheckResultStateVo> page, @Param("fundCheckResultStateDto") FundCheckResultStateDto fundCheckResultStateDto);

}
