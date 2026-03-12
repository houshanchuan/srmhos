package com.mediway.hos.srm.business.center.service.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.YearDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.YearVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmYear;

/**
 * <p>
 * 年度 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-19
 */
public interface SrmYearService extends BaseService<SrmYear> {
     List<CombVo> getYear(YearDto yearDto);

     Long saveYear(SrmYear year);
     void test();
     void test2();
     @Transactional
     Long saveOrUpdateYear(BaseDataProjDto baseDataProjDto);

     YearVo getDetailYear(Long RowId);
     IPage<YearVo> listYear(YearDto yearDto);

     void deleteYear(BaseDto baseDto);

     Long getIdByName(String name);


}
