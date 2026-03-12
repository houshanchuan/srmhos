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

import com.mediway.hos.srm.business.center.model.dto.baseData.JobTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.JobTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmJobTypeService;
/**
 * <p>
 * 科研人员岗位性质
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/jobType")
@Api(tags = "科研人员岗位性质")
public class SrmJobTypeController {
    @Autowired
    private SrmJobTypeService srmJobTypeService;

    @PostMapping({"/saveOrUpdateJobType"})
    public BaseResponse saveOrUpdateJobType(@RequestBody BaseDataUserDto baseDataUserDto) {
        Long RowId = srmJobTypeService.saveOrUpdateJobType(baseDataUserDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailJobType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        JobTypeVo jobTypeVo = srmJobTypeService.getDetailJobType(RowId);
        return BaseResponse.success(jobTypeVo);
    }

    @PostMapping({"/listJobType"})
    public BaseResponse listJobType(@RequestBody JobTypeDto jobTypeDto) {
        IPage<JobTypeVo> list = srmJobTypeService.listJobType(jobTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteJobType"})
    public BaseResponse deleteJobType(@RequestBody BaseDto baseDto) {
        srmJobTypeService.deleteJobType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
