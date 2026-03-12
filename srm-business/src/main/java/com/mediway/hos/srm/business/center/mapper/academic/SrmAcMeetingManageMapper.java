package com.mediway.hos.srm.business.center.mapper.academic;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.academic.AcMeetingManageDto;
import com.mediway.hos.srm.business.center.model.vo.academic.AcMeetingManageVo;
import com.mediway.hos.srm.business.center.model.entity.academic.SrmAcMeetingManage;


/**
 * <p>
 * 参加会议信息表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmAcMeetingManageMapper extends BaseMapper<SrmAcMeetingManage> {

    IPage<AcMeetingManageVo> listAcMeetingManage(@Param("page") Page<AcMeetingManageVo> page, @Param("acMeetingManageDto") AcMeetingManageDto acMeetingManageDto);

    String submit(@Param("RowId") Long RowId ,@Param("UserId") String UserId);

    AcMeetingManageVo getDetailAcMeetingManage(@Param("RowId") Long RowId );

    void updateStatus(@Param("rowId") Long rowId,@Param("status") Integer status,@Param("checkStatus") String checkStatus);
    IPage<AcMeetingManageVo> listAcMeetingManageForAudit(@Param("page") Page<AcMeetingManageVo> page, @Param("acMeetingManageDto") AcMeetingManageDto acMeetingManageDto);

}
