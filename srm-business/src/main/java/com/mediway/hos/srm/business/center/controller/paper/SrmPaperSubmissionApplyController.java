package com.mediway.hos.srm.business.center.controller.paper;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperSubmissionApplyDto;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperSubmissionExpertAuditDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperSubmissionApplyVo;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperSubmissionExpertAuditVo;
import com.mediway.hos.srm.business.center.service.paper.SrmPaperSubmissionApplyService;

/**
 * <p>
 * 论文投稿
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/srmPaperSubmissionApply")
@Api(tags = "论文投稿")
public class SrmPaperSubmissionApplyController {
    @Autowired
    private SrmPaperSubmissionApplyService srmPaperSubmissionApplyService;

    @PostMapping({"/savePaperSubmissionApply"})
    public BaseResponse savePaperSubmissionApply(@RequestBody PaperSubmissionApplyDto paperSubmissionApplyDto) {
        System.out.println(paperSubmissionApplyDto);
        Long RowId= srmPaperSubmissionApplyService.savePaperSubmissionApply(paperSubmissionApplyDto);
        return BaseResponse.success(RowId);
    }
    @PostMapping({"/listPaperSubmissionApply"})
    public BaseResponse listPaperSubmissionApply(@RequestBody PaperSubmissionApplyDto paperSubmissionApplyDto) {
        IPage<PaperSubmissionApplyVo> list = srmPaperSubmissionApplyService.listPaperSubmissionApply(paperSubmissionApplyDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/getDetail"})
    public BaseResponse getDetail(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        PaperSubmissionApplyVo paperSubmissionApplyVo = srmPaperSubmissionApplyService.getDetail(RowId);
        return BaseResponse.success(paperSubmissionApplyVo);
    }

    @PostMapping({"/subMit"})
    public BaseResponse subMit(@RequestBody BaseDto baseDto) {
        //System.out.println(baseDto.toString());
        srmPaperSubmissionApplyService.subMit(baseDto);
        return BaseResponse.success("提交成功!");

    }
    @PostMapping({"/delete"})
    public BaseResponse delete(@RequestBody BaseDto baseDto) {
        srmPaperSubmissionApplyService.delete(baseDto);
        return BaseResponse.success("删除成功!");

    }

    @PostMapping({"/listAuditPaperSubmissionApply"})
    public BaseResponse listAuditPaperSubmissionApply(@RequestBody PaperSubmissionApplyDto paperSubmissionApplyDto) {
        IPage<PaperSubmissionApplyVo> list = srmPaperSubmissionApplyService.listAuditPaperSubmissionApply(paperSubmissionApplyDto);
        return BaseResponse.success(list);

    }

    @PostMapping({"/audit"})
    public BaseResponse audit(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto.toString());
        srmPaperSubmissionApplyService.audit(baseDto);
        return BaseResponse.success("确认成功!");

    }

    @PostMapping({"/listExpertAuditPaperSubmission"})
    public BaseResponse listExpertAuditPaperSubmission(@RequestBody PaperSubmissionExpertAuditDto paperSubmissionExpertAuditDto) {
        IPage<PaperSubmissionExpertAuditVo> list = srmPaperSubmissionApplyService.listExpertAuditPaperSubmission(paperSubmissionExpertAuditDto);
        return BaseResponse.success(list);

    }
}
