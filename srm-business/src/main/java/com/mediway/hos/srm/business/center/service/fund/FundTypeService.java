package com.mediway.hos.srm.business.center.service.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataFundDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.fund.FundTypeDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundTypeVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundType;
/**
 * <p>
 * 项目资金来源类型表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundTypeService extends BaseService<FundType> {

    @Transactional
    Long saveOrUpdateFundType(BaseDataFundDto baseDataFundDto);

    FundTypeVo getDetailFundType(Long RowId);
    IPage<FundTypeVo> listFundType(FundTypeDto fundTypeDto);

    void deleteFundType(BaseDto baseDto);

    Long getIdByName(String name);
}
