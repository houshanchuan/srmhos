package com.mediway.hos.srm.business.center.controller.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.model.dto.baseData.IdentifyResultDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.IdentifyResultVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmIdentifyResultService;
/**
 * <p>
 * 鉴定结果（结论）
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/identifyResult")
@Api(tags = "鉴定结果（结论）")
public class SrmIdentifyResultController {

    @Autowired
    private SrmIdentifyResultService srmIdentifyResultService;

    @PostMapping({"/saveOrUpdateIdentifyResult"})
    public BaseResponse saveOrUpdateIdentifyResult(@RequestBody BaseDataProjDto baseDataProjDto) {
        Long RowId = srmIdentifyResultService.saveOrUpdateIdentifyResult(baseDataProjDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailIdentifyResult(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        IdentifyResultVo identifyResultVo = srmIdentifyResultService.getDetailIdentifyResult(RowId);
        return BaseResponse.success(identifyResultVo);
    }

    @PostMapping({"/listIdentifyResult"})
    public BaseResponse listIdentifyResult(@RequestBody IdentifyResultDto identifyResultDto) {
        IPage<IdentifyResultVo> list = srmIdentifyResultService.listIdentifyResult(identifyResultDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteIdentifyResult"})
    public BaseResponse deleteIdentifyResult(@RequestBody BaseDto baseDto) {
        srmIdentifyResultService.deleteIdentifyResult(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
