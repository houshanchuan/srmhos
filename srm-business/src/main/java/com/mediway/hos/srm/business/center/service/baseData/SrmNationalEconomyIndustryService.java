package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.dto.baseData.NationalEconomyIndustryDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.NationalEconomyIndustryVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmNationalEconomyIndustry;

/**
 * <p>
 * 国民经济行业 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmNationalEconomyIndustryService extends BaseService<SrmNationalEconomyIndustry> {

    @Transactional
    Long saveOrUpdateNationalEconomyIndustry(BaseDataProjDto baseDataProjDto);

    NationalEconomyIndustryVo getDetailNationalEconomyIndustry(Long RowId);
    IPage<NationalEconomyIndustryVo> listNationalEconomyIndustry(NationalEconomyIndustryDto nationalEconomyIndustryDto);

    void deleteNationalEconomyIndustry(BaseDto baseDto);

    Long getIdByName(String name);
    List<CombVo> getNationalEconomyIndustry(String upCode);
    List<CombVo> getNationalEconomyIndustryNew(NationalEconomyIndustryDto nationalEconomyIndustryDto);
}
