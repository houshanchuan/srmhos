package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataCommonDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.CheckStatusDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.CheckStatusVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmCheckStatus;

/**
 * <p>
 * 审核状态代码表(通用) 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-19
 */
public interface SrmCheckStatusService extends BaseService<SrmCheckStatus> {
    String getCheckStatusDesc(String code);

    List<SrmCheckStatus> ListCheckStatus();

    @Transactional
    Long saveOrUpdateCheckStatus(BaseDataCommonDto baseDataProjDto);

    CheckStatusVo getDetailCheckStatus(Long RowId);
    IPage<CheckStatusVo> listCheckStatus(CheckStatusDto checkStatusDto);

    void deleteCheckStatus(BaseDto baseDto);

    Long getIdByName(String name);
}
