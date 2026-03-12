package com.mediway.hos.srm.business.center.controller.patent;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.patent.PatentInfoDto;
import com.mediway.hos.srm.business.center.model.dto.patent.PatentInfoMainDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.vo.patent.PatentInfoVo;
import com.mediway.hos.srm.business.center.model.vo.baseData.UnitPeronVo;
import com.mediway.hos.srm.business.center.service.patent.SrmPatentInfoService;

import java.util.List;

/**
 * <p>
 * 专利信息表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/srmPatentInfo")
@Api(tags = "专利信息表")
public class SrmPatentInfoController {
    @Autowired
    private SrmPatentInfoService srmPatentInfoService;
    @PostMapping({"/savePatentInfo"})
    public BaseResponse savePatentInfo(@RequestBody PatentInfoMainDto patentInfoMainDto) {
        Long RowId= srmPatentInfoService.savePatentInfo(patentInfoMainDto);
        return BaseResponse.success(RowId);
    }
    @PostMapping({"/getDetail"})
    public BaseResponse getDetail(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        PatentInfoVo patentInfoVo = srmPatentInfoService.getDetail(RowId);
        return BaseResponse.success(patentInfoVo);
    }

    @PostMapping({"/listPatentInfo"})
    public BaseResponse listPatentInfo(@RequestBody PatentInfoDto patentInfoDto) {
        IPage<PatentInfoVo> list = srmPatentInfoService.listPatentInfo(patentInfoDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deletePatentInfo"})
    public BaseResponse deletePatentInfo(@RequestBody BaseDto baseDto) {
        srmPatentInfoService.deletePatentInfo(baseDto);
        return BaseResponse.success("删除成功!");

    }
    @PostMapping({"/subMit"})
    public BaseResponse subMit(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto.toString());
        srmPatentInfoService.subMit(baseDto);
        return BaseResponse.success("提交成功!");

    }

    @PostMapping({"/listAuditPatentInfo"})
    public BaseResponse listAuditPatentInfo(@RequestBody PatentInfoDto patentInfoDto) {
        System.out.println(patentInfoDto);
        IPage<PatentInfoVo> list = srmPatentInfoService.listAuditPatentInfo(patentInfoDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/audit"})
    public BaseResponse audit(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto.toString());
        srmPatentInfoService.audit(baseDto);
        return BaseResponse.success("审批成功!");

    }
    @PostMapping({"/getPatentApply"})
    public List<CombVo> getPatentApply(@RequestParam String userCode) {

        return srmPatentInfoService.getPatentApply(userCode);
    }
    @PostMapping({"/listPatentee"})
    public BaseResponse listPatentee(@RequestBody BaseDto baseDto) {
        Long rowId=baseDto.getId();
        List<UnitPeronVo> list = srmPatentInfoService.listPatentee(rowId);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deletePatentee"})
    public BaseResponse deletePatentee(@RequestBody BaseDto baseDto) {
        srmPatentInfoService.deletePatentee(baseDto.getRowStr());
        return BaseResponse.success("删除成功!");

    }
    @PostMapping({"/getPatentInfo"})
    public List<CombVo> getPatentInfo(@RequestParam String userCode) {
        return srmPatentInfoService.getPatentInfo(userCode);
    }


}
