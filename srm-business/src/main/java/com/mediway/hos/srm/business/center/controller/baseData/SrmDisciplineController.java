package com.mediway.hos.srm.business.center.controller.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.DisciplineDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import io.swagger.annotations.Api;
import com.mediway.hos.srm.business.center.model.vo.baseData.DisciplineVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmDisciplineService;

/**
 * <p>
 * 学科表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-19
 */
@RestController
@RequestMapping("srm/discipline")
@Api(tags = "学科表")
public class SrmDisciplineController {
    @Autowired
    private SrmDisciplineService srmDisciplineService;

    @PostMapping({"/saveOrUpdateDiscipLine"})
    public BaseResponse saveOrUpdateDiscipLine(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmDisciplineService.saveOrUpdateDiscipLine(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailDiscipLine(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        DisciplineVo discipLineVo = srmDisciplineService.getDetailDiscipLine(RowId);
        return BaseResponse.success(discipLineVo);
    }

    @PostMapping({"/listDiscipLine"})
    public BaseResponse listDiscipLine(@RequestBody DisciplineDto disciplineDto) {
        IPage<DisciplineVo> list = srmDisciplineService.listDiscipLine(disciplineDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteDiscipLine"})
    public BaseResponse deleteDiscipLine(@RequestBody BaseDto baseDto) {
        srmDisciplineService.deleteDiscipLine(baseDto);
        return BaseResponse.success("删除成功!");

    }
    @PostMapping({"/getDiscipline"})
    public List<CombVo> getDiscipline(@RequestParam String upCode, @RequestParam String classcode) {
        return srmDisciplineService.getDiscipline(upCode, classcode);
    }

}
