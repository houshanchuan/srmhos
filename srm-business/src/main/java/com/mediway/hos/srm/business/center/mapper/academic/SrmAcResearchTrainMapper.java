package com.mediway.hos.srm.business.center.mapper.academic;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.dto.academic.AcResearchTrainDto;
import com.mediway.hos.srm.business.center.model.entity.academic.SrmAcResearchTrain;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.academic.AcResearchTrainVo;

/**
 * <p>
 * 科研培训表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmAcResearchTrainMapper extends BaseMapper<SrmAcResearchTrain> {
    AcResearchTrainVo getDetail(@Param("rowId") Long rowId);
    IPage<AcResearchTrainVo> listAcResearchTrain(@Param("page") Page<AcResearchTrainVo> page, @Param("acResearchTrainDto") AcResearchTrainDto acResearchTrainDto);
    void updateStatus(@Param("rowId") Long rowId,@Param("status") Integer status);
    IPage<AcResearchTrainVo> listAuditAcResearchTrain(@Param("page") Page<AcResearchTrainVo> page, @Param("acResearchTrainDto") AcResearchTrainDto acResearchTrainDto);

}
