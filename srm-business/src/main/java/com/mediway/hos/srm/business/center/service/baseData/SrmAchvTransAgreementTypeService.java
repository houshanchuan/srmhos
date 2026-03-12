package com.mediway.hos.srm.business.center.service.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.AchvTransAgreementTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmAchvTransAgreementType;
import com.mediway.hos.srm.business.center.model.vo.baseData.AchvTransAgreementTypeVo;

/**
 * <p>
 * 转化协议类型表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-01
 */
public interface SrmAchvTransAgreementTypeService extends BaseService<SrmAchvTransAgreementType> {

    @Transactional
    Long saveOrUpdateAchvTransAgreementType(BaseDataLearningDto baseDataLearningDto);

    AchvTransAgreementTypeVo getDetailAchvTransAgreementType(Long RowId);
    IPage<AchvTransAgreementTypeVo> listAchvTransAgreementType(AchvTransAgreementTypeDto achvTransAgreementTypeDto);

    void deleteAchvTransAgreementType(BaseDto baseDto);

    Long getIdByName(String name);
    List<CombVo> getAchvTransAgreementType();
}
