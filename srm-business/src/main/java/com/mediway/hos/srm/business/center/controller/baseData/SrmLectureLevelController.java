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

import com.mediway.hos.srm.business.center.model.dto.baseData.LectureLevelDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.LectureLevelVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmLectureLevelService;


/**
 * <p>
 * 讲座级别
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/lectureLevel")
@Api(tags = "讲座级别")
public class SrmLectureLevelController {

    @Autowired
    private SrmLectureLevelService srmLectureLevelService;

    @PostMapping({"/saveOrUpdateLectureLevel"})
    public BaseResponse saveOrUpdateLectureLevel(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmLectureLevelService.saveOrUpdateLectureLevel(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailLectureLevel(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        LectureLevelVo lectureLevelVo = srmLectureLevelService.getDetailLectureLevel(RowId);
        return BaseResponse.success(lectureLevelVo);
    }

    @PostMapping({"/listLectureLevel"})
    public BaseResponse listLectureLevel(@RequestBody LectureLevelDto lectureLevelDto) {
        IPage<LectureLevelVo> list = srmLectureLevelService.listLectureLevel(lectureLevelDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteLectureLevel"})
    public BaseResponse deleteLectureLevel(@RequestBody BaseDto baseDto) {
        srmLectureLevelService.deleteLectureLevel(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
