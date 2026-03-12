package com.mediway.hos.srm.business.center.controller.academic;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.academic.AcParttimeInfoDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.academic.AcParttimeInfoVo;
import com.mediway.hos.srm.business.center.service.academic.SrmAcParttimeInfoService;

/**
 * <p>
 * 兼职信息表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/srmAcParttimeInfo")
@Api(tags = "兼职信息表")
public class SrmAcParttimeInfoController {
    @Autowired
    private SrmAcParttimeInfoService srmAcParttimeInfoService;
    @PostMapping({"/saveAcParttimeInfo"})
    public BaseResponse saveAcParttimeInfo(@RequestBody AcParttimeInfoDto acParttimeInfoDto) {
        System.out.println(acParttimeInfoDto);
        Long RowId= srmAcParttimeInfoService.saveAcParttimeInfo(acParttimeInfoDto);
        return BaseResponse.success(RowId);
    }
    @PostMapping({"/getDetail"})
    public BaseResponse getDetail(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        AcParttimeInfoVo acParttimeInfoVo = srmAcParttimeInfoService.getDetail(RowId);
        return BaseResponse.success(acParttimeInfoVo);
    }

    @PostMapping({"/listAcParttimeInfo"})
    public BaseResponse listAcParttimeInfo(@RequestBody AcParttimeInfoDto acParttimeInfoDto) {
        IPage<AcParttimeInfoVo> list = srmAcParttimeInfoService.listAcParttimeInfo(acParttimeInfoDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteAcParttimeInfo"})
    public BaseResponse deleteAcParttimeInfo(@RequestBody BaseDto baseDto) {
        srmAcParttimeInfoService.deleteAcParttimeInfo(baseDto);
        return BaseResponse.success("删除成功!");

    }
    @PostMapping({"/subMit"})
    public BaseResponse subMit(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto.toString());
        srmAcParttimeInfoService.subMit(baseDto);
        return BaseResponse.success("提交成功!");

    }
    @PostMapping({"/listAuditAcParttimeInfo"})
    public BaseResponse listAuditAcParttimeInfo(@RequestBody AcParttimeInfoDto acParttimeInfoDto) {
        IPage<AcParttimeInfoVo> list = srmAcParttimeInfoService.listAuditAcParttimeInfo(acParttimeInfoDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/audit"})
    public BaseResponse audit(@RequestBody BaseDto baseDto) {
        srmAcParttimeInfoService.audit(baseDto);
        return BaseResponse.success("审批成功!");

    }
}
