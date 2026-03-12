package com.mediway.hos.srm.business.center.mapper.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.dto.baseData.ProjMidCheckListInfoStateDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjMidCheckListInfoStateVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjMidcheckListInfoState;
/**
 * <p>
 * 项目中检批次状态表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjMidcheckListInfoStateMapper extends BaseMapper<SrmProjMidcheckListInfoState> {
    IPage<ProjMidCheckListInfoStateVo> listProjMidCheckListInfoState(@Param("page") Page<ProjMidCheckListInfoStateVo> page, @Param("projMidCheckListInfoStateDto") ProjMidCheckListInfoStateDto projMidCheckListInfoStateDto);

}
