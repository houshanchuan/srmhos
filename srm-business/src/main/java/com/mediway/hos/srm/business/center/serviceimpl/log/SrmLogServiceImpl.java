package com.mediway.hos.srm.business.center.serviceimpl.log;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import com.mediway.hos.srm.business.center.mapper.log.SrmLogMapper;
import com.mediway.hos.srm.business.center.model.dto.log.SrmLogDto;
import com.mediway.hos.srm.business.center.model.entity.log.SrmLog;
import com.mediway.hos.srm.business.center.model.vo.academic.AcConferenceHostVo;
import com.mediway.hos.srm.business.center.model.vo.dept.DeptVo;
import com.mediway.hos.srm.business.center.model.vo.log.SrmLogVo;
import com.mediway.hos.srm.business.center.service.log.SrmLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SrmLogServiceImpl extends BaseServiceImpl<SrmLogMapper, SrmLog>  implements SrmLogService {

    @Autowired
    private SrmLogMapper srmLogMapper;
    @Override
    public IPage<SrmLogVo> listLog(SrmLogDto srmLogDto) {

        Page<SrmLogVo> page = new Page<>(srmLogDto.getPage(), srmLogDto.getRows());
        IPage<SrmLogVo> res= srmLogMapper.listLog(page, srmLogDto);
        List<SrmLogVo> records=res.getRecords();
//        List<SrmLogVo> newRecords=new ArrayList<>();
//        for(SrmLogVo srmLogVo : records){
//            SrmLogVo newRecord=new SrmLogVo();
//            newRecord=srmLogVo;
//            Long rowId=srmLogVo.getRowId();
//            String checkListName= srmEafRecService.getCurCheckDesc("P032",rowId,null);
//            newRecord.setChkResultlist(checkListName);
//            newRecords.add(newRecord);
//        }
        res.setRecords(records);
        return res;
    }

    @Override
    public SrmLogVo getDetail(Long rowId) {
        return srmLogMapper.getDetail(rowId);
    }

    @Override
    public int saveLog(SrmLog srmLog) {
        int k=super.insert(srmLog);
        return k;
    }
}
