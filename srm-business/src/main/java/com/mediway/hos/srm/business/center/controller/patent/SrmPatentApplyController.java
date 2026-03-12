package com.mediway.hos.srm.business.center.controller.patent;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperSubmissionExpertAuditDto;
import com.mediway.hos.srm.business.center.model.dto.patent.PatentApplyDto;
import com.mediway.hos.srm.business.center.model.dto.patent.PatentApplyMainDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperSubmissionExpertAuditVo;
import com.mediway.hos.srm.business.center.model.vo.patent.PatentApplyVo;
import com.mediway.hos.srm.business.center.model.vo.baseData.UnitPeronVo;
import com.mediway.hos.srm.business.center.service.patent.SrmPatentApplyService;

import java.util.List;

/**
 * <p>
 * 专利申报
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/srmPatentApply")
@Api(tags = "专利申报")
public class SrmPatentApplyController {
    @Autowired
    private SrmPatentApplyService srmPatentApplyService;
    @PostMapping({"/savePatentApply"})
    public BaseResponse savePatentApply(@RequestBody PatentApplyMainDto patentApplyMainDto) {
        System.out.println(patentApplyMainDto);
        Long RowId= srmPatentApplyService.savePatentApply(patentApplyMainDto);
        return BaseResponse.success(RowId);
    }
    @PostMapping({"/getDetail"})
    public BaseResponse getDetail(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        PatentApplyVo patentApplyVo = srmPatentApplyService.getDetail(String.valueOf(RowId));
        return BaseResponse.success(patentApplyVo);
    }

    @PostMapping({"/listPatentApply"})
    public BaseResponse listPatentApply(@RequestBody PatentApplyDto patentApplyDto) {
        IPage<PatentApplyVo> list = srmPatentApplyService.listPatentApply(patentApplyDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deletePatentApply"})
    public BaseResponse deletePatentApply(@RequestBody BaseDto baseDto) {
        srmPatentApplyService.deletePatentApply(baseDto);
        return BaseResponse.success("删除成功!");

    }
    @PostMapping({"/subMit"})
    public BaseResponse subMit(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto.toString());
        srmPatentApplyService.subMit(baseDto);
        return BaseResponse.success("提交成功!");

    }
    @PostMapping({"/listAuditPatentApply"})
    public BaseResponse listAuditPatentApply(@RequestBody PatentApplyDto patentApplyDto) {
        IPage<PatentApplyVo> list = srmPatentApplyService.listAuditPatentApply(patentApplyDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/audit"})
    public BaseResponse audit(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto.toString());
        srmPatentApplyService.audit(baseDto);
        return BaseResponse.success("审批成功!");

    }
    @PostMapping({"/listPatentee"})
    public BaseResponse listPatentee(@RequestBody BaseDto baseDto) {
        Long rowId=baseDto.getId();
        List<UnitPeronVo> list = srmPatentApplyService.listPatentee(rowId);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deletePatentee"})
    public BaseResponse deletePatentee(@RequestBody BaseDto baseDto) {
        srmPatentApplyService.deletePatentee(baseDto.getRowStr());
        return BaseResponse.success("删除成功!");

    }
    @PostMapping({"/listExpertAuditPatentApply"})
    public BaseResponse listExpertAuditPatentApply(@RequestBody PaperSubmissionExpertAuditDto paperSubmissionExpertAuditDto) {
        IPage<PaperSubmissionExpertAuditVo> list = srmPatentApplyService.listExpertAuditPatentApply(paperSubmissionExpertAuditDto);
        return BaseResponse.success(list);

    }
}
