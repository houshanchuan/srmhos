package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.PartnerTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.PartnerTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPartnerType;
/**
 * <p>
 * 对方类型表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPartnerTypeService extends BaseService<SrmPartnerType> {

    @Transactional
    Long saveOrUpdatePartnerType(BaseDataProjDto baseDataProjDto);

    PartnerTypeVo getDetailPartnerType(Long RowId);
    IPage<PartnerTypeVo> listPartnerType(PartnerTypeDto partnerTypeDto);

    void deletePartnerType(BaseDto baseDto);

    Long getIdByName(String name);
    List<CombVo> getPartnerType();
}
