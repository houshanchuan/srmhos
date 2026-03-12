package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.SocEconomicObjDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.SocEconomicObjVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmSocEconomicObj;

/**
 * <p>
 * 社会经济目标 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmSocEconomicObjService extends BaseService<SrmSocEconomicObj> {

    @Transactional
    Long saveOrUpdateSocEconomicObj(BaseDataProjDto baseDataProjDto);

    SocEconomicObjVo getDetailSocEconomicObj(Long RowId);
    IPage<SocEconomicObjVo> listSocEconomicObj(SocEconomicObjDto socEconomicObjDto);

    void deleteSocEconomicObj(BaseDto baseDto);

    Long getIdByName(String name);
    List<CombVo> getSocEconomicObj(SocEconomicObjDto socEconomicObjDto);
}
