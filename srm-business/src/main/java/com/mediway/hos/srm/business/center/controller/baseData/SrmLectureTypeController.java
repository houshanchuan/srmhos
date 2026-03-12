package com.mediway.hos.srm.business.center.controller.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.model.dto.baseData.LectureTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.LectureTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmLectureTypeService;


/**
 * <p>
 * 讲座类型
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/lectureType")
@Api(tags = "讲座类型")
public class SrmLectureTypeController {

    @Autowired
    private SrmLectureTypeService srmLectureTypeService;

    @PostMapping({"/saveOrUpdateLectureType"})
    public BaseResponse saveOrUpdateLectureType(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmLectureTypeService.saveOrUpdateLectureType(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailLectureType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        LectureTypeVo lectureTypeVo = srmLectureTypeService.getDetailLectureType(RowId);
        return BaseResponse.success(lectureTypeVo);
    }

    @PostMapping({"/listLectureType"})
    public BaseResponse listLectureType(@RequestBody LectureTypeDto lectureTypeDto) {
        IPage<LectureTypeVo> list = srmLectureTypeService.listLectureType(lectureTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteLectureType"})
    public BaseResponse deleteLectureType(@RequestBody BaseDto baseDto) {
        srmLectureTypeService.deleteLectureType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
