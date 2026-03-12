package com.mediway.hos.srm.business.center.controller.approvalProcess;


import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.service.approvalProcess.SrmEafRecService;

/**
 * <p>
 * 审批记录
 * </p>
 *
 * @author 代码生成器
 * @since 2024-08-21
 */
@RestController
@RequestMapping("srm/eafRec")
@Api(tags = "审批记录")
public class SrmEafRecController {
    @Autowired
    private SrmEafRecService srmEafRecService;
    @PostMapping({"/getCurStatus"})
    public Boolean getCurStatus(@RequestBody BaseDto baseDto) {
        //System.out.println(baseDto.toString());
        return srmEafRecService.getCurStatus(baseDto);

    }
    @PostMapping({"/getFinalResult"})
    public BaseResponse getFinalResult(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto.toString());
        String result=srmEafRecService.getFinalResult(baseDto);
        return BaseResponse.success(result);

    }
}
