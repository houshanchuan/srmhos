package com.mediway.hos.srm.business.center.controller.monograph;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.monograph.MonographDetailDto;
import com.mediway.hos.srm.business.center.model.dto.monograph.MonographDto;
import io.swagger.annotations.Api;
import com.mediway.hos.srm.business.center.model.vo.monograph.MonographVo;
import com.mediway.hos.srm.business.center.service.monograph.SrmMonographInfoService;

/**
 * <p>
 * 著作信息表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-25
 */
@RestController
@RequestMapping("srm/monographInfo")
@Api(tags = "著作信息表")
public class SrmMonographInfoController {
    @Autowired
    private SrmMonographInfoService srmMonographInfoService;

    @PostMapping({"/saveMonograph"})
    public BaseResponse saveMonograph(@RequestBody MonographDto monographDto) {
        Long RowId = srmMonographInfoService.saveOrUpdateMon(monographDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetail(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        MonographVo monographVo = srmMonographInfoService.getDetail(RowId);
        return BaseResponse.success(monographVo);
    }

    @PostMapping({"/listMonograph"})

    public BaseResponse listMonograph(@RequestBody MonographDetailDto monographDetailDto) {
        System.out.println(monographDetailDto);
        IPage<MonographVo> list = srmMonographInfoService.listMonograph(monographDetailDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteMonographInfo"})
    public BaseResponse deleteMonographInfo(@RequestBody BaseDto baseDto) {
        srmMonographInfoService.deleteMonograph(baseDto);
        return BaseResponse.success("删除成功!");

    }
    @PostMapping({"/subMit"})
    public BaseResponse subMit(@RequestBody BaseDto baseDto) {
        //System.out.println(baseDto.toString());
        srmMonographInfoService.subMit(baseDto);
        return BaseResponse.success("提交成功!");

    }
    @PostMapping({"/listAuditMonographInfo"})
    public BaseResponse listAuditMonographInfo(@RequestBody MonographDetailDto monographDetailDto) {
        IPage<MonographVo> list = srmMonographInfoService.listAuditMonographInfo(monographDetailDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/audit"})
    public BaseResponse audit(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto.toString());
        srmMonographInfoService.audit(baseDto);
        return BaseResponse.success("审批成功!");

    }
    @PostMapping({"/noaudit"})
    public BaseResponse noaudit(@RequestBody BaseDto baseDto) {
        //System.out.println(baseDto.toString());
        srmMonographInfoService.noaudit(baseDto);
        return BaseResponse.success("审批成功!");

    }
}
