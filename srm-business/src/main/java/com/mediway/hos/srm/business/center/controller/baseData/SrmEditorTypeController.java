package com.mediway.hos.srm.business.center.controller.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.service.baseData.SrmEditorTypeService;
import com.mediway.hos.srm.business.center.model.dto.baseData.EditorTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.EditorTypeVo;

/**
 * <p>
 * 编者类型
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-24
 */
@RestController
@RequestMapping("srm/editorType")
@Api(tags = "编者类型")
public class SrmEditorTypeController {
    @Autowired
    private SrmEditorTypeService srmEditorTypeService;

    @PostMapping({"/saveOrUpdateEditorType"})
    public BaseResponse saveOrUpdateEditorType(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmEditorTypeService.saveOrUpdateEditorType(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailEditorType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        EditorTypeVo editorTypeVo = srmEditorTypeService.getDetailEditorType(RowId);
        return BaseResponse.success(editorTypeVo);
    }

    @PostMapping({"/listEditorType"})
    public BaseResponse listEditorType(@RequestBody EditorTypeDto editorTypeDto) {
        IPage<EditorTypeVo> list = srmEditorTypeService.listEditorType(editorTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteEditorType"})
    public BaseResponse deleteEditorType(@RequestBody BaseDto baseDto) {
        srmEditorTypeService.deleteEditorType(baseDto);
        return BaseResponse.success("删除成功!");

    }


    @PostMapping({"/getEditorType"})
    public List<CombVo> getEditorType() {
        List<CombVo> editorTypeList = srmEditorTypeService.getEditorType();
        return editorTypeList;
    }
}
