package com.mediway.hos.srm.business.center.mapper.app;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mediway.hos.srm.business.center.model.dto.app.AppMessageDto;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperDto;
import com.mediway.hos.srm.business.center.model.entity.app.SrmAppMessage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.app.AppMessageVo;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * APP待办消息 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2025-05-14
 */
public interface SrmAppMessageMapper extends BaseMapper<SrmAppMessage> {
    void updateMessage(@Param("sysNo") String sysNo,@Param("recId") String recId);
    IPage<AppMessageVo> listAppMessage(@Param("page") Page<AppMessageVo> page, @Param("appMessageDto") AppMessageDto appMessageDto);
}
