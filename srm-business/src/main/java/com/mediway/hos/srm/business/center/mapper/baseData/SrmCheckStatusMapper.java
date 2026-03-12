package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.CheckStatusDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.CheckStatusVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmCheckStatus;
/**
 * <p>
 * 审核状态代码表(通用) Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-19
 */
public interface SrmCheckStatusMapper extends BaseMapper<SrmCheckStatus> {
    String getCheckStatusDesc(@Param("code") String code);
    List<SrmCheckStatus> ListCheckStatus();

    IPage<CheckStatusVo> listCheckStatus(@Param("page") Page<CheckStatusVo> page, @Param("checkStatusDto") CheckStatusDto checkStatusDto);

}
