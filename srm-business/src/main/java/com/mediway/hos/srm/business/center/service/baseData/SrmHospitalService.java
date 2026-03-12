package com.mediway.hos.srm.business.center.service.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataCommonDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.HospitalDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.vo.baseData.HospitalVo;

import com.mediway.hos.srm.business.center.model.entity.baseData.SrmHospital;

/**
 * <p>
 * 医疗机构(医院)表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-25
 */
public interface SrmHospitalService extends BaseService<SrmHospital> {

    @Transactional
    Long saveOrUpdateSrmHospital(BaseDataCommonDto baseDataCommonDto);

    HospitalVo getDetailSrmHospital(Long RowId);

    IPage<HospitalVo> listSrmHospital(HospitalDto srmHospitalDto);

    void deleteSrmHospital(BaseDto baseDto);

    Long getIdByName(String name);

    List<CombVo> getHospital();
}
