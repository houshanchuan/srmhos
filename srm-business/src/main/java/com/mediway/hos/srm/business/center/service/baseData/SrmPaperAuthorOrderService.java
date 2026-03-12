package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.PaperAuthorOrderDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPaperAuthorOrder;
import com.mediway.hos.srm.business.center.model.vo.baseData.PaperAuthorOrderVo;

/**
 * <p>
 * 论文作者排序 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-24
 */
public interface SrmPaperAuthorOrderService extends BaseService<SrmPaperAuthorOrder> {
    List<CombVo> getPaperAuthorOrder();
    @Transactional
    Long saveOrUpdatePaperAuthorOrder(BaseDataLearningDto baseDataLearningDto);

    PaperAuthorOrderVo getDetailPaperAuthorOrder(Long RowId);
    IPage<PaperAuthorOrderVo> listPaperAuthorOrder(PaperAuthorOrderDto paperAuthorOrderDto);

    void deletePaperAuthorOrder(BaseDto baseDto);

    Long getIdByName(String name);
}
