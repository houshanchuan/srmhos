package com.mediway.hos.srm.business.center.service.monograph;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.monograph.MonographDetailDto;
import com.mediway.hos.srm.business.center.model.dto.monograph.MonographDto;
import com.mediway.hos.srm.business.center.model.entity.monograph.SrmMonographInfo;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.monograph.MonographVo;

/**
 * <p>
 * 著作信息表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-25
 */
public interface SrmMonographInfoService extends BaseService<SrmMonographInfo> {
    Long saveOrUpdateMon(MonographDto monographDto);
    MonographVo getDetail(Long RowId);
    IPage<MonographVo> listMonograph(MonographDetailDto monographDetailDto);

    void deleteMonograph(BaseDto baseDto);

    Long getIdByName(String name);

    void subMit(BaseDto baseDto);

    void audit(BaseDto baseDto);
    void noaudit(BaseDto baseDto);
    IPage<MonographVo> listAuditMonographInfo(MonographDetailDto monographDetailDto);

}
