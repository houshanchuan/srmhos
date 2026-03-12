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

import com.mediway.hos.srm.business.center.service.baseData.SrmWorkTypeService;
import com.mediway.hos.srm.business.center.model.dto.baseData.WorkTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.WorkTypeVo;
/**
 * <p>
 * 著作类别
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-19
 */
@RestController
@RequestMapping("srm/workType")
@Api(tags = "著作类别")
public class SrmWorkTypeController {
    @Autowired
    private SrmWorkTypeService srmWorkTypeService;

    @PostMapping({"/saveOrUpdateWorkType"})
    public BaseResponse saveOrUpdateWorkType(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmWorkTypeService.saveOrUpdateWorkType(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailWorkType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        WorkTypeVo workTypeVo = srmWorkTypeService.getDetailWorkType(RowId);
        return BaseResponse.success(workTypeVo);
    }

    @PostMapping({"/listWorkType"})
    public BaseResponse listWorkType(@RequestBody WorkTypeDto workTypeDto) {
        IPage<WorkTypeVo> list = srmWorkTypeService.listWorkType(workTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteWorkType"})
    public BaseResponse deleteWorkType(@RequestBody BaseDto baseDto) {
        srmWorkTypeService.deleteWorkType(baseDto);
        return BaseResponse.success("删除成功!");

    }
    @PostMapping({"/getWorkType"})
    public List<CombVo> getWorkType(@RequestBody(required = false) WorkTypeDto workTypeDto) {
        List<CombVo> workTypeList = srmWorkTypeService.getWorkType(workTypeDto);
        return workTypeList;
    }
}
