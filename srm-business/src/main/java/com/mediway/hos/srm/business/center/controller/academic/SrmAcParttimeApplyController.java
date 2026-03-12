package com.mediway.hos.srm.business.center.controller.academic;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.academic.AcParttimeApplyDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.academic.AcParttimeApplyVo;
import com.mediway.hos.srm.business.center.service.academic.SrmAcParttimeApplyService;

/**
 * <p>
 * 兼职申请表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/srmAcParttimeApply")
@Api(tags = "兼职申请表")
public class SrmAcParttimeApplyController {
    @Autowired
    private SrmAcParttimeApplyService srmAcParttimeApplyService;
    @PostMapping({"/saveAcParttimeApply"})
    public BaseResponse saveAcParttimeApply(@RequestBody AcParttimeApplyDto acParttimeApplyDto) {
        System.out.println(acParttimeApplyDto);
        Long RowId= srmAcParttimeApplyService.saveAcParttimeApply(acParttimeApplyDto);
        return BaseResponse.success(RowId);
    }
    @PostMapping({"/getDetail"})
    public BaseResponse getDetail(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        AcParttimeApplyVo acParttimeApplyVo = srmAcParttimeApplyService.getDetail(RowId);
        return BaseResponse.success(acParttimeApplyVo);
    }

    @PostMapping({"/listAcParttimeApply"})
    public BaseResponse listAcParttimeApply(@RequestBody AcParttimeApplyDto acParttimeApplyDto) {
        IPage<AcParttimeApplyVo> list = srmAcParttimeApplyService.listAcParttimeApply(acParttimeApplyDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteAcParttimeApply"})
    public BaseResponse deleteAcParttimeApply(@RequestBody BaseDto baseDto) {
        srmAcParttimeApplyService.deleteAcParttimeApply(baseDto);
        return BaseResponse.success("删除成功!");

    }
    @PostMapping({"/subMit"})
    public BaseResponse subMit(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto.toString());
        srmAcParttimeApplyService.subMit(baseDto);
        return BaseResponse.success("提交成功!");

    }
    @PostMapping({"/listAuditAcParttimeApply"})
    public BaseResponse listAuditAcParttimeApply(@RequestBody AcParttimeApplyDto acParttimeApplyDto) {
        IPage<AcParttimeApplyVo> list = srmAcParttimeApplyService.listAuditAcParttimeApply(acParttimeApplyDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/audit"})
    public BaseResponse audit(@RequestBody BaseDto baseDto) {
        srmAcParttimeApplyService.audit(baseDto);
        return BaseResponse.success("审批成功!");

    }
}
