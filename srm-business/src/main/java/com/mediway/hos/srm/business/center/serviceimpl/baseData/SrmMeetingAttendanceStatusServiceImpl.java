package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.MeetingAtdStatusDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmMeetingAttendanceStatus;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmMeetingAttendanceStatusMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.MeetingAtdStatusVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmMeetingAttendanceStatusService;
/**
 * <p>
 * 参会身份 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmMeetingAttendanceStatusServiceImpl extends BaseServiceImpl<SrmMeetingAttendanceStatusMapper, SrmMeetingAttendanceStatus> implements SrmMeetingAttendanceStatusService {
    @Autowired
    private SrmMeetingAttendanceStatusService  srmMeetingAtdStatusService;
    @Autowired
    private SrmMeetingAttendanceStatusMapper srmMeetingAttendanceStatusMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateMeetingAtdStatus(BaseDataLearningDto baseDataLearningDto) {
        List<MeetingAtdStatusDto> meetingAtdStatusDtos =baseDataLearningDto.getMeetingAtdStatuss();

        List<SrmMeetingAttendanceStatus> meetingAtdStatusList=new ArrayList<>();
        for (MeetingAtdStatusDto meetingAtdStatusDto :meetingAtdStatusDtos) {
            SrmMeetingAttendanceStatus srmMeetingAtdStatus = new SrmMeetingAttendanceStatus();
            srmMeetingAtdStatus.setId(meetingAtdStatusDto.getRowId());
            srmMeetingAtdStatus.setCode(meetingAtdStatusDto.getCode());
            srmMeetingAtdStatus.setName(meetingAtdStatusDto.getName());
            srmMeetingAtdStatus.setIsValid(Integer.valueOf(meetingAtdStatusDto.getIsValid()));

            meetingAtdStatusList.add(srmMeetingAtdStatus);
            Long RowId = srmMeetingAtdStatus.getId();
        }
        super.saveOrUpdateBatch(meetingAtdStatusList);
        return RowId;
    }
    @Override
    public MeetingAtdStatusVo getDetailMeetingAtdStatus(Long RowId) {
        return null;
    }

    @Override
    public IPage<MeetingAtdStatusVo> listMeetingAtdStatus(MeetingAtdStatusDto meetingAtdStatusDto) {
        Page<MeetingAtdStatusVo> page = new Page<>(meetingAtdStatusDto.getPage(), meetingAtdStatusDto.getRows());
        IPage<MeetingAtdStatusVo> res= srmMeetingAttendanceStatusMapper.listMeetingAtdStatus(page, meetingAtdStatusDto);
        //List<MeetingAtdStatusVo> records=res.getRecords();
        //List<MeetingAtdStatusVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteMeetingAtdStatus(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                //System.out.println(RowId);
                if(StringUtils.isEmpty(idStr)){
                    idStr=String.valueOf(RowId);
                }else{
                    idStr=idStr+","+String.valueOf(RowId);
                }
            }
            super.deleteByIds(idStr);
        }catch (Exception exception){
            throw  new ErrorException("-200",exception.getMessage());
        }
    }

    @Override
    public Long getIdByName(String name) {
        return null;
    }

    @Override
    public List<CombVo> getAttendanceStatus(){
        return srmMeetingAttendanceStatusMapper.getAttendanceStatus();
    }
}
