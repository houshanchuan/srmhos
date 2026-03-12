package com.mediway.hos.srm.business.center.controller.academic;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.academic.AcResearchTrainDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.academic.AcResearchTrainVo;
import com.mediway.hos.srm.business.center.service.academic.SrmAcResearchTrainService;

/**
 * <p>
 * 科研培训表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/srmAcResearchTrain")
@Api(tags = "科研培训表")
public class SrmAcResearchTrainController {
    @Autowired
    private SrmAcResearchTrainService srmAcResearchTrainService;
    @PostMapping({"/saveAcResearchTrain"})
    public BaseResponse saveAcResearchTrain(@RequestBody AcResearchTrainDto acResearchTrainDto) {
        System.out.println(acResearchTrainDto);
        Long RowId= srmAcResearchTrainService.saveAcResearchTrain(acResearchTrainDto);
        return BaseResponse.success(RowId);
    }
    @PostMapping({"/getDetail"})
    public BaseResponse getDetail(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        AcResearchTrainVo acResearchTrainVo = srmAcResearchTrainService.getDetail(RowId);
        return BaseResponse.success(acResearchTrainVo);
    }

    @PostMapping({"/listAcResearchTrain"})
    public BaseResponse listAcResearchTrain(@RequestBody AcResearchTrainDto acResearchTrainDto) {
        IPage<AcResearchTrainVo> list = srmAcResearchTrainService.listAcResearchTrain(acResearchTrainDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteAcResearchTrain"})
    public BaseResponse deleteAcResearchTrain(@RequestBody BaseDto baseDto) {
        srmAcResearchTrainService.deleteAcResearchTrain(baseDto);
        return BaseResponse.success("删除成功!");

    }
    @PostMapping({"/subMit"})
    public BaseResponse subMit(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto.toString());
        srmAcResearchTrainService.subMit(baseDto);
        return BaseResponse.success("提交成功!");

    }
    @PostMapping({"/listAuditAcResearchTrain"})
    public BaseResponse listAuditAcResearchTrain(@RequestBody AcResearchTrainDto acResearchTrainDto) {
        IPage<AcResearchTrainVo> list = srmAcResearchTrainService.listAuditAcResearchTrain(acResearchTrainDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/audit"})
    public BaseResponse audit(@RequestBody BaseDto baseDto) {
        srmAcResearchTrainService.audit(baseDto);
        return BaseResponse.success("审批成功!");

    }
}
