package com.mediway.hos.srm.business.center.service.academic;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.srm.business.center.model.dto.academic.AcConferenceHostDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.entity.academic.SrmAcConferenceHost;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.academic.AcConferenceHostVo;

/**
 * <p>
 * 学术会议表(主办) 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmAcConferenceHostService extends BaseService<SrmAcConferenceHost> {
    Long saveAcConferenceHost(AcConferenceHostDto acConferenceHostDto);
    AcConferenceHostVo getDetail(Long rowId);
    IPage<AcConferenceHostVo> listAcConferenceHost(AcConferenceHostDto acConferenceHostDto);

    void deleteAcConferenceHost(BaseDto baseDto);
    void subMit(BaseDto baseDto);

    void audit(BaseDto baseDto);
    IPage<AcConferenceHostVo> listAuditAcConferenceHost(AcConferenceHostDto acConferenceHostDto);


}
