package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.ConferenceTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmConferenceType;
import com.mediway.hos.srm.business.center.model.vo.baseData.ConferenceTypeVo;


/**
 * <p>
 * 会议类型 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmConferenceTypeMapper extends BaseMapper<SrmConferenceType> {
    IPage<ConferenceTypeVo> listConferenceType(@Param("page") Page<ConferenceTypeVo> page, @Param("conferenceTypeDto") ConferenceTypeDto conferenceTypeDto);

    List<CombVo> getConferenceType();
}
