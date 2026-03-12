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

import com.mediway.hos.srm.business.center.service.baseData.SrmAwardGradeService;
import com.mediway.hos.srm.business.center.model.dto.baseData.AwardGradeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.AwardGradeVo;
/**
 * <p>
 * 获奖等次
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/awardGrade")
@Api(tags = "获奖等次")
public class SrmAwardGradeController {
    @Autowired
    private SrmAwardGradeService srmAwardGradeService;

    @PostMapping({"/saveOrUpdateAwardGrade"})
    public BaseResponse saveOrUpdateAwardGrade(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmAwardGradeService.saveOrUpdateAwardGrade(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailAwardGrade(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        AwardGradeVo awardGradeVo = srmAwardGradeService.getDetailAwardGrade(RowId);
        return BaseResponse.success(awardGradeVo);
    }

    @PostMapping({"/listAwardGrade"})
    public BaseResponse listAwardGrade(@RequestBody AwardGradeDto awardGradeDto) {
        IPage<AwardGradeVo> list = srmAwardGradeService.listAwardGrade(awardGradeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteAwardGrade"})
    public BaseResponse deleteAwardGrade(@RequestBody BaseDto baseDto) {
        srmAwardGradeService.deleteAwardGrade(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
