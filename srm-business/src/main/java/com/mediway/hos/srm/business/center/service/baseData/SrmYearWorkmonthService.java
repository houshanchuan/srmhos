package com.mediway.hos.srm.business.center.service.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataCommonDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.YearWorkMonthDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.YearWorkMonthVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmYearWorkmonth;

/**
 * <p>
 * 年工作量 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmYearWorkmonthService extends BaseService<SrmYearWorkmonth> {

    @Transactional
    Long saveOrUpdateYearWorkMonth(BaseDataCommonDto baseDataProjDto);

    YearWorkMonthVo getDetailYearWorkMonth(Long RowId);
    IPage<YearWorkMonthVo> listYearWorkMonth(YearWorkMonthDto yearWorkMonthDto);

    void deleteYearWorkMonth(BaseDto baseDto);

    Long getIdByName(String name);
}
