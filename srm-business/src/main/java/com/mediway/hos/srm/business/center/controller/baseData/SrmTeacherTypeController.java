package com.mediway.hos.srm.business.center.controller.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.model.dto.baseData.TeacherTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.TeacherTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmTeacherTypeService;

/**
 * <p>
 * 教师类型代码
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/teacherType")
@Api(tags = "教师类型代码")
public class SrmTeacherTypeController {

    @Autowired
    private SrmTeacherTypeService srmTeacherTypeService;

    @PostMapping({"/saveOrUpdateTeacherType"})
    public BaseResponse saveOrUpdateTeacherType(@RequestBody BaseDataUserDto baseDataUserDto) {
        Long RowId = srmTeacherTypeService.saveOrUpdateTeacherType(baseDataUserDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailSrmTeacherType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        TeacherTypeVo teacherTypeVo = srmTeacherTypeService.getDetailTeacherType(RowId);
        return BaseResponse.success(teacherTypeVo);
    }

    @PostMapping({"/listTeacherType"})
    public BaseResponse listTeacherType(@RequestBody TeacherTypeDto teacherTypeDto) {
        IPage<TeacherTypeVo> list = srmTeacherTypeService.listTeacherType(teacherTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteTeacherType"})
    public BaseResponse deleteTeacherType(@RequestBody BaseDto baseDto) {
        srmTeacherTypeService.deleteTeacherType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
