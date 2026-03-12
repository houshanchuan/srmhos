package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.dto.baseData.ReimbursementWayDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmReimbursementWay;
import com.mediway.hos.srm.business.center.model.vo.baseData.ReimbursementWayVo;

/**
 * <p>
 * 报销途径 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmReimbursementWayService extends BaseService<SrmReimbursementWay> {
    List<CombVo> getReimbursementWay();
    @Transactional
    Long saveOrUpdateReimbursementWay(BaseDataLearningDto baseDataLearningDto);

    ReimbursementWayVo getDetailReimbursementWay(Long RowId);
    IPage<ReimbursementWayVo> listReimbursementWay(ReimbursementWayDto reimbursementWayDto);

    void deleteReimbursementWay(BaseDto baseDto);

    Long getIdByName(String name);
}
