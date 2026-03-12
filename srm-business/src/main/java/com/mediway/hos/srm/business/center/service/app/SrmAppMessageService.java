package com.mediway.hos.srm.business.center.service.app;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.srm.business.center.model.dto.app.AppMessageDto;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperDto;
import com.mediway.hos.srm.business.center.model.entity.app.SrmAppMessage;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.app.AppMessageVo;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * APP待办消息 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2025-05-14
 */
public interface SrmAppMessageService extends BaseService<SrmAppMessage> {
    Long saveAppMessage(AppMessageDto appMessageDto);
    //List<SrmAppMessage> listAppMessage(AppMessageDto appMessageDto);
    void updateMessage(String sysNo,String recId);
    IPage<AppMessageVo> listAppMessage(AppMessageDto appMessageDto);
}
