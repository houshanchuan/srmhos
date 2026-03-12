package com.mediway.hos.srm.business.center.controller.paper;


import com.mediway.hos.base.model.BaseResponse;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperSubmissionAuditorDto;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperSubmissionGradeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperSubmissionAuditorVo;
import com.mediway.hos.srm.business.center.service.paper.SrmPaperSubmissionAuditorService;

import java.util.List;

/**
 * <p>
 * 成果评审专家表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/srmPaperSubmissionAuditor")
@Api(tags = "成果评审专家表")
public class SrmPaperSubmissionAuditorController {
    @Autowired
    private SrmPaperSubmissionAuditorService srmPaperSubmissionAuditorService;
    @PostMapping({"/getNoAllotExpert"})
    public BaseResponse getNoAllotExpert(@RequestBody PaperSubmissionAuditorDto paperSubmissionAuditorDto) {
        List<PaperSubmissionAuditorVo> list = srmPaperSubmissionAuditorService.getNoAllotExpert(paperSubmissionAuditorDto);
        return BaseResponse.success(list);

    }

    @PostMapping({"/getAllotExpert"})
    public BaseResponse getAllotExpert(@RequestBody PaperSubmissionAuditorDto paperSubmissionAuditorDto) {
        List<PaperSubmissionAuditorVo> list = srmPaperSubmissionAuditorService.getAllotExpert(paperSubmissionAuditorDto);
        return BaseResponse.success(list);

    }

    @PostMapping({"/deleteExpert"})
    public BaseResponse deleteExpert(@RequestBody PaperSubmissionGradeDto paperSubmissionGradeDto) {
        srmPaperSubmissionAuditorService.deleteExpert(paperSubmissionGradeDto);
        return BaseResponse.success("删除成功!");

    }

    @PostMapping({"/allotExpert"})
    public BaseResponse allotExpert(@RequestBody PaperSubmissionAuditorDto paperSubmissionAuditorDto) {

        srmPaperSubmissionAuditorService.allotExpert(paperSubmissionAuditorDto);
        return BaseResponse.success("分配成功!");

    }

}
