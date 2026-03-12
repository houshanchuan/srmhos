package com.mediway.hos.srm.business.center.service.academic;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.srm.business.center.model.dto.academic.AcParttimeInfoDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.entity.academic.SrmAcParttimeInfo;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.academic.AcParttimeInfoVo;

/**
 * <p>
 * 兼职信息表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmAcParttimeInfoService extends BaseService<SrmAcParttimeInfo> {
    Long saveAcParttimeInfo(AcParttimeInfoDto acParttimeInfoDto);
    AcParttimeInfoVo getDetail(Long rowId);
    IPage<AcParttimeInfoVo> listAcParttimeInfo(AcParttimeInfoDto acParttimeInfoDto);

    void deleteAcParttimeInfo(BaseDto baseDto);
    void subMit(BaseDto baseDto);

    void audit(BaseDto baseDto);
    IPage<AcParttimeInfoVo> listAuditAcParttimeInfo(AcParttimeInfoDto acParttimeInfoDto);
}
