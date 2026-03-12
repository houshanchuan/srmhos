package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.EditorTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmEditorType;
import com.mediway.hos.srm.business.center.model.vo.baseData.EditorTypeVo;


/**
 * <p>
 * 编者类型 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-24
 */
public interface SrmEditorTypeService extends BaseService<SrmEditorType> {
    @Transactional
    Long saveOrUpdateEditorType(BaseDataLearningDto baseDataLearningDto);

    EditorTypeVo getDetailEditorType(Long RowId);
    IPage<EditorTypeVo> listEditorType(EditorTypeDto editorTypeDto);

    void deleteEditorType(BaseDto baseDto);

    Long getIdByName(String name);
    List<CombVo> getEditorType();
}
