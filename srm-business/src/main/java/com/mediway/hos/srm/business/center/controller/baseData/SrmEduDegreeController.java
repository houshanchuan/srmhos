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

import com.mediway.hos.srm.business.center.model.dto.baseData.EduDegreeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.EduDegreeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmEduDegreeService;

/**
 * <p>
 * 学位表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/eduDegree")
@Api(tags = "学位表")
public class SrmEduDegreeController {

    @Autowired
    private SrmEduDegreeService srmEduDegreeService;

    @PostMapping({"/saveOrUpdateEduDegree"})
    public BaseResponse saveOrUpdateEduDegree(@RequestBody BaseDataUserDto baseDataUserDto) {
        Long RowId = srmEduDegreeService.saveOrUpdateEduDegree(baseDataUserDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailEduDegree(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        EduDegreeVo eduDegreeVo = srmEduDegreeService.getDetailEduDegree(RowId);
        return BaseResponse.success(eduDegreeVo);
    }

    @PostMapping({"/listEduDegree"})
    public BaseResponse listEduDegree(@RequestBody EduDegreeDto eduDegreeDto) {
        IPage<EduDegreeVo> list = srmEduDegreeService.listEduDegree(eduDegreeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteEduDegree"})
    public BaseResponse deleteEduDegree(@RequestBody BaseDto baseDto) {
        srmEduDegreeService.deleteEduDegree(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
