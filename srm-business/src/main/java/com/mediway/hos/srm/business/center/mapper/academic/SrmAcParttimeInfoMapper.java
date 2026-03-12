package com.mediway.hos.srm.business.center.mapper.academic;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.dto.academic.AcParttimeInfoDto;
import com.mediway.hos.srm.business.center.model.entity.academic.SrmAcParttimeInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.academic.AcParttimeInfoVo;

/**
 * <p>
 * 兼职信息表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmAcParttimeInfoMapper extends BaseMapper<SrmAcParttimeInfo> {
    AcParttimeInfoVo getDetail(@Param("rowId") Long rowId);
    IPage<AcParttimeInfoVo> listAcParttimeInfo(@Param("page") Page<AcParttimeInfoVo> page, @Param("acParttimeInfoDto") AcParttimeInfoDto acParttimeInfoDto);
    void updateStatus(@Param("rowId") Long rowId,@Param("status") Integer status,@Param("checkStatus") String checkStatus);
    IPage<AcParttimeInfoVo> listAuditAcParttimeInfo(@Param("page") Page<AcParttimeInfoVo> page, @Param("acParttimeInfoDto") AcParttimeInfoDto acParttimeInfoDto);

}
