package com.mediway.hos.srm.business.center.controller.paper;


import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperSubmissionGradeDto;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperSubmissionGradeVo;

import com.mediway.hos.srm.business.center.service.paper.SrmPaperSubmissionGradeService;


/**
 * <p>
 * 论文投稿同行评审表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/srmPaperSubmissionGrade")
@Api(tags = "成果同行评审表")
public class SrmPaperSubmissionGradeController {
    @Autowired
    private SrmPaperSubmissionGradeService srmPaperSubmissionGradeService;
    @PostMapping({"/saveDetail"})
    public BaseResponse saveDetail(@RequestBody PaperSubmissionGradeDto paperSubmissionGradeDto) {
        Long RowId= srmPaperSubmissionGradeService.saveDetail(paperSubmissionGradeDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/subMit"})
    public BaseResponse subMit(@RequestBody PaperSubmissionGradeDto paperSubmissionGradeDto) {
        //System.out.println(baseDto.toString());
        srmPaperSubmissionGradeService.subMit(paperSubmissionGradeDto);
        return BaseResponse.success("提交成功!");

    }
    @PostMapping({"/getDetail"})
    public BaseResponse getDetail(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        PaperSubmissionGradeVo paperSubmissionGradeVo = srmPaperSubmissionGradeService.getDetail(String.valueOf(RowId));
        return BaseResponse.success(paperSubmissionGradeVo);
    }
}
