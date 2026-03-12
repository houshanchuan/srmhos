package com.mediway.hos.srm.business.center.controller.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.service.baseData.SrmMeetingAttendanceStatusService;
import com.mediway.hos.srm.business.center.model.dto.baseData.MeetingAtdStatusDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.MeetingAtdStatusVo;



/**
 * <p>
 * 参会身份
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/meetingAtdStatus")
@Api(tags = "参会身份")
public class SrmMeetingAttendanceStatusController {
    @Autowired
    private SrmMeetingAttendanceStatusService srmMeetingAttendanceStatusService;

    @PostMapping({"/saveOrUpdateMeetingAtdStatus"})
    public BaseResponse saveOrUpdateMeetingAtdStatus(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmMeetingAttendanceStatusService.saveOrUpdateMeetingAtdStatus(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailMeetingAtdStatus(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        MeetingAtdStatusVo meetingAtdStatusVo = srmMeetingAttendanceStatusService.getDetailMeetingAtdStatus(RowId);
        return BaseResponse.success(meetingAtdStatusVo);
    }

    @PostMapping({"/listMeetingAtdStatus"})
    public BaseResponse listMeetingAtdStatus(@RequestBody MeetingAtdStatusDto meetingAtdStatusDto) {
        IPage<MeetingAtdStatusVo> list = srmMeetingAttendanceStatusService.listMeetingAtdStatus(meetingAtdStatusDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteMeetingAtdStatus"})
    public BaseResponse deleteMeetingAtdStatus(@RequestBody BaseDto baseDto) {
        srmMeetingAttendanceStatusService.deleteMeetingAtdStatus(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
