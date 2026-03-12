package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.PaperSciPartitionDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPaperSciPartition;
import com.mediway.hos.srm.business.center.model.vo.baseData.PaperSciPartitionVo;


/**
 * <p>
 * SCI论文分区 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPaperSciPartitionService extends BaseService<SrmPaperSciPartition> {
    @Transactional
    Long saveOrUpdatePaperSciPartition(BaseDataLearningDto baseDataLearningDto);

    PaperSciPartitionVo getDetailPaperSciPartition(Long RowId);
    IPage<PaperSciPartitionVo> listPaperSciPartition(PaperSciPartitionDto yyyyDto);

    void deletePaperSciPartition(BaseDto baseDto);

    Long getIdByName(String name);
}
