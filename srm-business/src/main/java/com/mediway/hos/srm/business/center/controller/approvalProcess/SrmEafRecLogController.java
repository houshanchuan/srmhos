package com.mediway.hos.srm.business.center.controller.approvalProcess;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.dto.approvalProcess.EafRecDto;
import com.mediway.hos.srm.business.center.model.vo.approvalProcess.EafRecLogVo;
import com.mediway.hos.srm.business.center.model.vo.approvalProcess.EafRecVstepNo;
import com.mediway.hos.srm.business.center.service.approvalProcess.SrmEafRecLogService;

import java.util.List;

/**
 * <p>
 * 审批记录日志
 * </p>
 *
 * @author 代码生成器
 * @since 2024-08-23
 */
@RestController
@RequestMapping("srm/eafRecLog")
@Api(tags = "审批记录日志")
public class SrmEafRecLogController {
    @Autowired
    private SrmEafRecLogService srmEafRecLogService;
    @PostMapping({"/listCheckLog"})
    public List<EafRecLogVo> listCheckLog(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto);
        return srmEafRecLogService.listCheckLog(baseDto);
    }
    @PostMapping({"/listVStep"})
    public List<EafRecVstepNo> listCheckLog(@RequestBody EafRecDto eafRecDto) {
        //System.out.println(baseDto);
        return srmEafRecLogService.listVStep(eafRecDto);
    }
    @PostMapping({"/getCurStep"})
    public int getCurStep(@RequestBody EafRecDto eafRecDto) {
        //System.out.println(baseDto);
        return srmEafRecLogService.getCurStep(eafRecDto);
    }
}
