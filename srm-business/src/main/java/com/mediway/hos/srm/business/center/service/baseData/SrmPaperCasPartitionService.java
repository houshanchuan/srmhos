package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.PaperCASPartitionDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPaperCasPartition;
import com.mediway.hos.srm.business.center.model.vo.baseData.PaperCASPartitionVo;
/**
 * <p>
 * 中科院论文分区 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPaperCasPartitionService extends BaseService<SrmPaperCasPartition> {
    @Transactional
    Long saveOrUpdatePaperCasPartition(BaseDataLearningDto baseDataLearningDto);

    PaperCASPartitionVo getDetailPaperCasPartition(Long RowId);
    IPage<PaperCASPartitionVo> listPaperCasPartition(PaperCASPartitionDto paperCasPartitionDto);

    void deletePaperCasPartition(BaseDto baseDto);

    Long getIdByName(String name);
}
