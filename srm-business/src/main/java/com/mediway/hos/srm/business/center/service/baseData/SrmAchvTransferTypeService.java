package com.mediway.hos.srm.business.center.service.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;


import com.mediway.hos.srm.business.center.model.dto.baseData.AchvTransferTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmAchvTransferType;
import com.mediway.hos.srm.business.center.model.vo.baseData.AchvTransferTypeVo;


/**
 * <p>
 * 成果转化类型 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmAchvTransferTypeService extends BaseService<SrmAchvTransferType> {
    @Transactional
    Long saveOrUpdateAchvTransferType(BaseDataLearningDto baseDataLearningDto);

    AchvTransferTypeVo getDetailAchvTransferType(Long RowId);
    IPage<AchvTransferTypeVo> listAchvTransferType(AchvTransferTypeDto achvTransferTypeDto);

    void deleteAchvTransferType(BaseDto baseDto);

    Long getIdByName(String name);
    List<CombVo> getAchvTransferType();
}
