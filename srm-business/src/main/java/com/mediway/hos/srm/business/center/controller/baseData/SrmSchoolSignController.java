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

import com.mediway.hos.srm.business.center.model.dto.baseData.SchoolSignDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.SchoolSignVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmSchoolSignService;

/**
 * <p>
 * 单位签名排序
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/schoolSign")
@Api(tags = "单位签名排序")
public class SrmSchoolSignController {

    @Autowired
    private SrmSchoolSignService srmSchoolSignService;

    @PostMapping({"/saveOrUpdateSchoolSign"})
    public BaseResponse saveOrUpdateSchoolSign(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmSchoolSignService.saveOrUpdateSchoolSign(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailSchoolSign(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        SchoolSignVo schoolSignVo = srmSchoolSignService.getDetailSchoolSign(RowId);
        return BaseResponse.success(schoolSignVo);
    }

    @PostMapping({"/listSchoolSign"})
    public BaseResponse listSchoolSign(@RequestBody SchoolSignDto schoolSignDto) {
        IPage<SchoolSignVo> list = srmSchoolSignService.listSchoolSign(schoolSignDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteSchoolSign"})
    public BaseResponse deleteSchoolSign(@RequestBody BaseDto baseDto) {
        srmSchoolSignService.deleteSchoolSign(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
