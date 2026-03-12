package com.mediway.hos.srm.business.center.mapper.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;
import com.mediway.hos.srm.business.center.model.dto.baseData.MeetingAtdStatusDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmMeetingAttendanceStatus;
import com.mediway.hos.srm.business.center.model.vo.baseData.MeetingAtdStatusVo;

/**
 * <p>
 * 参会身份 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmMeetingAttendanceStatusMapper extends BaseMapper<SrmMeetingAttendanceStatus> {
    IPage<MeetingAtdStatusVo> listMeetingAtdStatus(@Param("page") Page<MeetingAtdStatusVo> page, @Param("meetingAtdStatusDto") MeetingAtdStatusDto meetingAtdStatusDto);

    List<CombVo> getAttendanceStatus();

}
