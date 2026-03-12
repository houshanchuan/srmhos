package com.mediway.hos.srm.business.center.service.academic;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.srm.business.center.model.dto.academic.AcResearchTrainDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.entity.academic.SrmAcResearchTrain;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.academic.AcResearchTrainVo;

/**
 * <p>
 * 科研培训表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmAcResearchTrainService extends BaseService<SrmAcResearchTrain> {
    Long saveAcResearchTrain(AcResearchTrainDto acResearchTrainDto);
    AcResearchTrainVo getDetail(Long rowId);
    IPage<AcResearchTrainVo> listAcResearchTrain(AcResearchTrainDto acResearchTrainDto);

    void deleteAcResearchTrain(BaseDto baseDto);
    void subMit(BaseDto baseDto);

    void audit(BaseDto baseDto);
    IPage<AcResearchTrainVo> listAuditAcResearchTrain(AcResearchTrainDto acResearchTrainDto);
}
