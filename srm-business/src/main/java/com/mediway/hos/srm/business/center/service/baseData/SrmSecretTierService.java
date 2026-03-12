package com.mediway.hos.srm.business.center.service.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataCommonDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.SecretTierDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.SecretTierVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmSecretTier;


/**
 * <p>
 * 涉密级别 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmSecretTierService extends BaseService<SrmSecretTier> {
    @Transactional
    Long saveOrUpdateSecretTier(BaseDataCommonDto baseDataProjDto);

    SecretTierVo getDetailSecretTier(Long RowId);
    IPage<SecretTierVo> listSecretTier(SecretTierDto secretTierDto);

    void deleteSecretTier(BaseDto baseDto);

    Long getIdByName(String name);
}
