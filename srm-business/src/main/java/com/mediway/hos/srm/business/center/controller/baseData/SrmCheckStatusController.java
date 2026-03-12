package com.mediway.hos.srm.business.center.controller.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataCommonDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.model.dto.baseData.CheckStatusDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.CheckStatusVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmCheckStatusService;

/**
 * <p>
 * 审核状态代码表(通用)
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-19
 */
@RestController
@RequestMapping("srm/checkStatus")
@Api(tags = "审核状态代码表(通用)")
public class SrmCheckStatusController {

    @Autowired
    private SrmCheckStatusService srmCheckStatusService;

    @PostMapping({"/saveOrUpdateCheckStatus"})
    public BaseResponse saveOrUpdateCheckStatus(@RequestBody BaseDataCommonDto baseDataProjDto) {
        Long RowId = srmCheckStatusService.saveOrUpdateCheckStatus(baseDataProjDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailCheckStatus(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        CheckStatusVo checkStatusVo = srmCheckStatusService.getDetailCheckStatus(RowId);
        return BaseResponse.success(checkStatusVo);
    }

    @PostMapping({"/listCheckStatus"})
    public BaseResponse listCheckStatus(@RequestBody CheckStatusDto checkStatusDto) {
        IPage<CheckStatusVo> list = srmCheckStatusService.listCheckStatus(checkStatusDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteCheckStatus"})
    public BaseResponse deleteCheckStatus(@RequestBody BaseDto baseDto) {
        srmCheckStatusService.deleteCheckStatus(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
