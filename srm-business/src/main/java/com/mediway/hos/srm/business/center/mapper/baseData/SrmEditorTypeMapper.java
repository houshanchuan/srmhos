package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.EditorTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmEditorType;
import com.mediway.hos.srm.business.center.model.vo.baseData.EditorTypeVo;
/**
 * <p>
 * 编者类型 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-24
 */
public interface SrmEditorTypeMapper extends BaseMapper<SrmEditorType> {
    IPage<EditorTypeVo> listEditorType(@Param("page") Page<EditorTypeVo> page, @Param("editorTypeDto") EditorTypeDto editorTypeDto);
    List<CombVo> getEditorType();
}
