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
import com.mediway.hos.srm.business.center.model.dto.baseData.DegreeTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.DegreeTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmDegreeTypeService;
/**
 * <p>
 * 学位点类型
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/degreeType")
@Api(tags = "学位点类型")
public class SrmDegreeTypeController {

    @Autowired
    private SrmDegreeTypeService srmDegreeTypeService;

    @PostMapping({"/saveOrUpdateDegreeType"})
    public BaseResponse saveOrUpdateDegreeType(@RequestBody BaseDataUserDto baseDataUserDto) {
        Long RowId = srmDegreeTypeService.saveOrUpdateDegreeType(baseDataUserDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailDegreeType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        DegreeTypeVo degreeTypeVo = srmDegreeTypeService.getDetailDegreeType(RowId);
        return BaseResponse.success(degreeTypeVo);
    }

    @PostMapping({"/listDegreeType"})
    public BaseResponse listDegreeType(@RequestBody DegreeTypeDto degreeTypeDto) {
        IPage<DegreeTypeVo> list = srmDegreeTypeService.listDegreeType(degreeTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteDegreeType"})
    public BaseResponse deleteDegreeType(@RequestBody BaseDto baseDto) {
        srmDegreeTypeService.deleteDegreeType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
