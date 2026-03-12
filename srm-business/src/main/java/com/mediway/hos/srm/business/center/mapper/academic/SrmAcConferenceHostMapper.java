package com.mediway.hos.srm.business.center.mapper.academic;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.dto.academic.AcConferenceHostDto;

import com.mediway.hos.srm.business.center.model.entity.academic.SrmAcConferenceHost;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.academic.AcConferenceHostVo;

/**
 * <p>
 * 学术会议表(主办) Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmAcConferenceHostMapper extends BaseMapper<SrmAcConferenceHost> {
    AcConferenceHostVo getDetail(@Param("rowId") Long rowId);
    IPage<AcConferenceHostVo> listAcConferenceHost(@Param("page") Page<AcConferenceHostVo> page, @Param("acConferenceHostDto") AcConferenceHostDto acConferenceHostDto);
    void updateStatus(@Param("rowId") Long rowId,@Param("status") Integer status,@Param("checkStatus") String checkStatus);
    IPage<AcConferenceHostVo> listAuditAcConferenceHost(@Param("page") Page<AcConferenceHostVo> page, @Param("acConferenceHostDto") AcConferenceHostDto acConferenceHostDto);

}
