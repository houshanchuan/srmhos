package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.PaperSourceDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPaperSource;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.baseData.PaperSourceVo;

/**
 * <p>
 * 论文来源途径 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPaperSourceService extends BaseService<SrmPaperSource> {

    @Transactional
    Long saveOrUpdatePaperSource(BaseDataLearningDto baseDataLearningDto);

    PaperSourceVo getDetailPaperSource(Long RowId);
    IPage<PaperSourceVo> listPaperSource(PaperSourceDto paperSourceDto);


    void deletePaperSource(BaseDto baseDto);

    Long getIdByName(String name);

}
