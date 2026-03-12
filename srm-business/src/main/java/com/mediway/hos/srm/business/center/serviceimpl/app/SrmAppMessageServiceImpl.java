package com.mediway.hos.srm.business.center.serviceimpl.app;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mediway.hos.srm.business.center.model.dto.app.AppMessageDto;
import com.mediway.hos.srm.business.center.model.entity.app.SrmAppMessage;
import com.mediway.hos.srm.business.center.mapper.app.SrmAppMessageMapper;
import com.mediway.hos.srm.business.center.model.vo.app.AppMessageVo;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperVo;
import com.mediway.hos.srm.business.center.service.app.SrmAppMessageService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import com.mediway.hos.srm.business.center.service.user.SrmUserService;
import com.mediway.hos.srm.business.center.utils.DateTransform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * APP待办消息 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2025-05-14
 */
@Service
public class SrmAppMessageServiceImpl extends BaseServiceImpl<SrmAppMessageMapper, SrmAppMessage> implements SrmAppMessageService {
    @Autowired
    private SrmAppMessageMapper srmAppMessageMapper;
    @Autowired
    private SrmUserService srmUserService;
    @Override
    public Long saveAppMessage(AppMessageDto appMessageDto){
        Long rowId=null;
        SrmAppMessage srmAppMessage=new SrmAppMessage();
        srmAppMessage.setId(appMessageDto.getRowId());
        srmAppMessage.setContent(appMessageDto.getContent());
        srmAppMessage.setTitle(appMessageDto.getTitle());
        srmAppMessage.setSysNo(appMessageDto.getSysNo());
        srmAppMessage.setRecId(appMessageDto.getRecId());
        srmAppMessage.setNote(appMessageDto.getNote());
        srmAppMessage.setStepNo(appMessageDto.getStepNo());
        srmAppMessage.setType(appMessageDto.getType());
        srmAppMessage.setAuditDate(DateTransform.getLocalDateTime(appMessageDto.getAuditDate()));
        srmAppMessage.setAuditAdvice(appMessageDto.getAuditAdvice());
        srmAppMessage.setAuditUserId(appMessageDto.getAuditUserId());
        srmAppMessage.setCheckStatus(appMessageDto.getCheckStatus());
        srmAppMessage.setDataStatus(appMessageDto.getDataStatus());
        if(appMessageDto.getRowId()==null){
            srmAppMessage.setCreateDate(LocalDateTime.now());
        }
        this.saveOrUpdate(srmAppMessage);
        return srmAppMessage.getId();

    }

    @Override
    public IPage<AppMessageVo> listAppMessage(AppMessageDto appMessageDto) {

        appMessageDto.setRows(appMessageDto.getLimit());

        Page<AppMessageVo> page = new Page<>(appMessageDto.getPage(), appMessageDto.getRows());
        String userCode=appMessageDto.getAccount();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        appMessageDto.setUserId(srmUserRowId);

        IPage<AppMessageVo> res= srmAppMessageMapper.listAppMessage(page, appMessageDto);
        return res;
    }

    @Override
    public void updateMessage(String sysNo,String recId){
        srmAppMessageMapper.updateMessage(sysNo,recId);
    }

}
