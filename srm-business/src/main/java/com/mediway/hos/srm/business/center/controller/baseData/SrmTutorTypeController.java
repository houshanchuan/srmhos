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

import com.mediway.hos.srm.business.center.model.dto.baseData.TutorTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.TutorTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmTutorTypeService;

/**
 * <p>
 * 指导老师类型
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/tutorType")
@Api(tags = "指导老师类型")
public class SrmTutorTypeController {

    @Autowired
    private SrmTutorTypeService srmTutorTypeService;

    @PostMapping({"/saveOrUpdateTutorType"})
    public BaseResponse saveOrUpdateTutorType(@RequestBody BaseDataUserDto baseDataUserDto) {
        Long RowId = srmTutorTypeService.saveOrUpdateTutorType(baseDataUserDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailTutorType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        TutorTypeVo tutorTypeVo = srmTutorTypeService.getDetailTutorType(RowId);
        return BaseResponse.success(tutorTypeVo);
    }

    @PostMapping({"/listTutorType"})
    public BaseResponse listTutorType(@RequestBody TutorTypeDto tutorTypeDto) {
        IPage<TutorTypeVo> list = srmTutorTypeService.listTutorType(tutorTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteTutorType"})
    public BaseResponse deleteTutorType(@RequestBody BaseDto baseDto) {
        srmTutorTypeService.deleteTutorType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
