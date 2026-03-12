package com.mediway.hos.srm.business.center.mapper.monograph;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.dto.monograph.MonographDetailDto;
import com.mediway.hos.srm.business.center.model.entity.monograph.SrmMonographInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.monograph.MonographVo;

import java.time.LocalDate;

/**
 * <p>
// * 著作信息表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-25
 */
public interface SrmMonographInfoMapper extends BaseMapper<SrmMonographInfo> {
    MonographVo getDetail(@Param("RowId") Long RowId);
    IPage<MonographVo> listMonographInfo(@Param("page") Page<MonographVo> page, @Param("monographDetailDto") MonographDetailDto monographDetailDto);

    Long getIdByName(@Param("name") String name);
    void updateStatus(@Param("rowId") Long rowId, @Param("status") Integer status, @Param("checkStatus") String checkStatus, @Param("serialNo") String serialNo, @Param("subDate") LocalDate subDate, @Param("subUserId") Long subUserId);

    IPage<MonographVo> listAuditMonographInfo(@Param("page") Page<MonographVo> page, @Param("monographDetailDto") MonographDetailDto monographDetailDto);

}
