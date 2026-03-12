package com.mediway.hos.srm.business.center.service.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.fund.FundSourceTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmFundSourceType;
import com.mediway.hos.srm.business.center.model.vo.fund.FundSourceTypeVo;


/**
 * <p>
 * 费用来源类型 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmFundSourceTypeService extends BaseService<SrmFundSourceType> {
    @Transactional
    Long saveOrUpdateFundSourceType(BaseDataLearningDto baseDataLearningDto);

    FundSourceTypeVo getDetailFundSourceType(Long RowId);
    IPage<FundSourceTypeVo> listFundSourceType(FundSourceTypeDto fundSourceTypeDto);

    void deleteFundSourceType(BaseDto baseDto);

    Long getIdByName(String name);
}
