package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.dto.baseData.PaperSourceDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPaperSource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.PaperSourceVo;

/**
 * <p>
 * 论文来源途径 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPaperSourceMapper extends BaseMapper<SrmPaperSource> {
    IPage<PaperSourceVo> listPaperSource(@Param("page") Page<PaperSourceVo> page, @Param("paperSourceDto") PaperSourceDto paperSourceDto);

}
