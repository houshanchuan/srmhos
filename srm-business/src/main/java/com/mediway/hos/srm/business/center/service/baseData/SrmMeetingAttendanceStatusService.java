package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.MeetingAtdStatusDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmMeetingAttendanceStatus;
import com.mediway.hos.srm.business.center.model.vo.baseData.MeetingAtdStatusVo;


/**
 * <p>
 * 参会身份 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmMeetingAttendanceStatusService extends BaseService<SrmMeetingAttendanceStatus> {
    @Transactional
    Long saveOrUpdateMeetingAtdStatus(BaseDataLearningDto baseDataLearningDto);

    MeetingAtdStatusVo getDetailMeetingAtdStatus(Long RowId);
    IPage<MeetingAtdStatusVo> listMeetingAtdStatus(MeetingAtdStatusDto meetingAtdStatusDto);

    void deleteMeetingAtdStatus(BaseDto baseDto);

    Long getIdByName(String name);

    List<CombVo> getAttendanceStatus();

}
