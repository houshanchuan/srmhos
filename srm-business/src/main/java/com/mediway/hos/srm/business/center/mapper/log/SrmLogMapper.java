package com.mediway.hos.srm.business.center.mapper.log;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mediway.hos.srm.business.center.model.dto.academic.AcConferenceHostDto;
import com.mediway.hos.srm.business.center.model.dto.log.SrmLogDto;
import com.mediway.hos.srm.business.center.model.entity.log.SrmLog;
import com.mediway.hos.srm.business.center.model.vo.academic.AcConferenceHostVo;
import com.mediway.hos.srm.business.center.model.vo.log.SrmLogVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SrmLogMapper extends BaseMapper<SrmLog> {

    public IPage<SrmLogVo> listLog(@Param("page") Page<SrmLogVo> page, @Param("srmLogDto") SrmLogDto srmLogDto);

    public SrmLogVo getDetail(@Param("id") Long id);
}
