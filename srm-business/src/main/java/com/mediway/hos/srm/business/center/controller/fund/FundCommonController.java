package com.mediway.hos.srm.business.center.controller.fund;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.service.fund.FundCommonService;


import java.util.List;

@RestController
@RequestMapping("srm/fundCommon")
@Api(tags = "经费公共combos")
public class FundCommonController {
    @Autowired
    private FundCommonService fundCommonService;
    // 项目
    @PostMapping({"/getProject"})
    public List<CombVo> getProject() {
        return fundCommonService.getProject() ;
    }
    @PostMapping({"/getUser"})
    public List<CombVo> getUser() {
        return fundCommonService.getUser() ;
    }
    @PostMapping({"/getItemCode"})
    public List<CombVo> getItemCode() {
        return fundCommonService.getItemCode() ;
    }
    @PostMapping({"/getVehicle"})
    public List<CombVo> getVehicle() {
        return fundCommonService.getVehicle() ;
    }
}
