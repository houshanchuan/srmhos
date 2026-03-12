package com.mediway.hos.srm.business.center.controller.award;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import com.mediway.hos.srm.business.center.model.dto.award.AwardApplyDto;
import com.mediway.hos.srm.business.center.model.dto.award.AwardApplyMainDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperSubmissionExpertAuditDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.award.AwardApplyVo;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperSubmissionExpertAuditVo;
import com.mediway.hos.srm.business.center.service.award.SrmAwardApplyService;

/**
 * <p>
 * 获奖申报
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/srmAwardApply")
@Api(tags = "获奖申报")
public class SrmAwardApplyController {
    @Autowired
    private SrmAwardApplyService srmAwardApplyService;
    @PostMapping({"/saveAwardApply"})
    public BaseResponse saveAwardApply(@RequestBody AwardApplyMainDto awardApplyMainDto) {
        System.out.println(awardApplyMainDto);
        Long RowId= srmAwardApplyService.saveAwardApply(awardApplyMainDto);
        return BaseResponse.success(RowId);
    }
    @PostMapping({"/getDetail"})
    public BaseResponse getDetail(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        AwardApplyVo awardApplyVo = srmAwardApplyService.getDetail(String.valueOf(RowId));
        return BaseResponse.success(awardApplyVo);
    }

    @PostMapping({"/listAwardApply"})
    public BaseResponse listAwardApply(@RequestBody AwardApplyDto awardApplyDto) {
        IPage<AwardApplyVo> list = srmAwardApplyService.listAwardApply(awardApplyDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteAwardApply"})
    public BaseResponse deleteAwardApply(@RequestBody BaseDto baseDto) {
        srmAwardApplyService.deleteAwardApply(baseDto);
        return BaseResponse.success("删除成功!");

    }
    @PostMapping({"/subMit"})
    public BaseResponse subMit(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto.toString());
        srmAwardApplyService.subMit(baseDto);
        return BaseResponse.success("提交成功!");

    }
    @PostMapping({"/listAuditAwardApply"})
    public BaseResponse listAuditAwardApply(@RequestBody AwardApplyDto awardApplyDto) {
        IPage<AwardApplyVo> list = srmAwardApplyService.listAuditAwardApply(awardApplyDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/audit"})
    public BaseResponse audit(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto.toString());
        srmAwardApplyService.audit(baseDto);
        return BaseResponse.success("审批成功!");

    }
    @PostMapping({"/listExpertAuditAwardApply"})
    public BaseResponse listExpertAuditAwardApply(@RequestBody PaperSubmissionExpertAuditDto paperSubmissionExpertAuditDto) {
        IPage<PaperSubmissionExpertAuditVo> list = srmAwardApplyService.listExpertAuditAwardApply(paperSubmissionExpertAuditDto);
        return BaseResponse.success(list);

    }
}
