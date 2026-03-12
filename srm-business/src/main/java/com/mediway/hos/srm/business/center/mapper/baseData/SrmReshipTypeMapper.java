package com.mediway.hos.srm.business.center.mapper.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.dto.baseData.PaperReshipTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmReshipType;
import com.mediway.hos.srm.business.center.model.vo.baseData.PaperReshipTypeVo;

import java.util.List;


/**
 * <p>
 * 转载类型 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmReshipTypeMapper extends BaseMapper<SrmReshipType> {
    IPage<PaperReshipTypeVo> listPaperReshipType(@Param("page") Page<PaperReshipTypeVo> page, @Param("paperReshipTypeDto") PaperReshipTypeDto paperReshipTypeDto);
    List<CombVo> getPaperReshipType(@Param("paperReshipTypeDto") PaperReshipTypeDto paperReshipTypeDto);
}
