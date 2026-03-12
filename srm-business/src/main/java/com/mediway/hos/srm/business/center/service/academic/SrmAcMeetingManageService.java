package com.mediway.hos.srm.business.center.service.academic;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.AcBaseDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.academic.AcMeetingManageDto;
import com.mediway.hos.srm.business.center.model.vo.academic.AcMeetingManageVo;
import com.mediway.hos.srm.business.center.model.entity.academic.SrmAcMeetingManage;

/**
 * <p>
 * 参加会议信息表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmAcMeetingManageService extends BaseService<SrmAcMeetingManage> {

    @Transactional
    Long saveOrUpdateAcMeetingManage(AcMeetingManageDto acMeetingManageDto);

    AcMeetingManageVo getDetailAcMeetingManage(Long RowId);
    IPage<AcMeetingManageVo> listAcMeetingManage(AcMeetingManageDto acMeetingManageDto);

    void deleteAcMeetingManage(BaseDto baseDto);

    void submitAcMeetingManage(BaseDto baseDto);

    // 审核
    void audit(BaseDto baseDto);

    IPage<AcMeetingManageVo> listAcMeetingManageForAudit(AcMeetingManageDto acMeetingManageDto);

}
