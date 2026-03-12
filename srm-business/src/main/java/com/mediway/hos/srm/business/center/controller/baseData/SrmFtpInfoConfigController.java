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

import com.mediway.hos.srm.business.center.model.dto.baseData.FtpInfoConfigDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.FtpInfoConfigVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmFtpInfoConfigService;
/**
 * <p>
 * 
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/ftpInfoConfig")
@Api(tags = "")
public class SrmFtpInfoConfigController {

    @Autowired
    private SrmFtpInfoConfigService srmFtpInfoConfigService;

    @PostMapping({"/saveOrUpdateFtpInfoConfig"})
    public BaseResponse saveOrUpdateFtpInfoConfig(@RequestBody BaseDataCommonDto baseDataCommonDto) {
        Long RowId = srmFtpInfoConfigService.saveOrUpdateFtpInfoConfig(baseDataCommonDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailFtpInfoConfig(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        FtpInfoConfigVo ftpInfoConfigVo = srmFtpInfoConfigService.getDetailFtpInfoConfig(RowId);
        return BaseResponse.success(ftpInfoConfigVo);
    }

    @PostMapping({"/listFtpInfoConfig"})
    public BaseResponse listFtpInfoConfig(@RequestBody FtpInfoConfigDto ftpInfoConfigDto) {
        IPage<FtpInfoConfigVo> list = srmFtpInfoConfigService.listFtpInfoConfig(ftpInfoConfigDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteFtpInfoConfig"})
    public BaseResponse deleteFtpInfoConfig(@RequestBody BaseDto baseDto) {
        srmFtpInfoConfigService.deleteFtpInfoConfig(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
