package com.mediway.hos.srm.business.center.controller.paper;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperDto;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperMainDto;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperSubmissionExpertAuditDto;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperSubmissionExpertAuditVo;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperVo;
import com.mediway.hos.srm.business.center.service.paper.SrmPaperService;

import java.util.List;

/**
 * <p>
 * 论文登记信息表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-08-23
 */
@RestController
@RequestMapping("srm/paper")
@Api(tags = "论文登记信息表")
public class SrmPaperController {
    @Autowired
    private SrmPaperService srmPaperService;

    @PostMapping({"/savePaper"})
    public BaseResponse savePaper(@RequestBody PaperMainDto paperMainDto) {
        Long RowId= srmPaperService.savePaper(paperMainDto);
        return BaseResponse.success(RowId);
    }
    @PostMapping({"/getDetail"})
    public BaseResponse getDetail(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        PaperVo paperVo = srmPaperService.getDetail(String.valueOf(RowId));
        return BaseResponse.success(paperVo);
    }

    @PostMapping({"/listPaper"})
    public BaseResponse listPaper(@RequestBody PaperDto paperDto) {
        IPage<PaperVo> list = srmPaperService.listPaper(paperDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deletePaper"})
    public BaseResponse deletePaper(@RequestBody BaseDto baseDto) {
        srmPaperService.deletePaper(baseDto);
        return BaseResponse.success("删除成功!");

    }
    @PostMapping({"/subMit"})
    public BaseResponse subMit(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto.toString());
        srmPaperService.subMit(baseDto);
        return BaseResponse.success("提交成功!");

    }
    @PostMapping({"/listAuditPaper"})
    public BaseResponse listAuditPaper(@RequestBody PaperDto paperDto) {
        System.out.println(paperDto);
        IPage<PaperVo> list = srmPaperService.listAuditPaper(paperDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/audit"})
    public BaseResponse audit(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto.toString());
        srmPaperService.audit(baseDto);
        return BaseResponse.success("审批成功!");

    }
    @PostMapping({"/getPaperApply"})
    public List<CombVo> getPaperApply(@RequestParam String userCode) {
        return srmPaperService.getPaperApply(userCode);
    }
    @PostMapping({"/listExpertAuditPaper"})
    public BaseResponse listExpertAuditPaper(@RequestBody PaperSubmissionExpertAuditDto paperSubmissionExpertAuditDto) {
        IPage<PaperSubmissionExpertAuditVo> list = srmPaperService.listExpertAuditPaper(paperSubmissionExpertAuditDto);
        return BaseResponse.success(list);

    }
}
