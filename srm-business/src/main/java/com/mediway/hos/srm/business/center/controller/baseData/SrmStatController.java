package com.mediway.hos.srm.business.center.controller.baseData;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("srm/statController")
@Api(tags = "润乾报表统计")
public class SrmStatController {
    //@Autowired
    //private SrmStatService srmStatService;
    //@ApiOperation("包装工作量统计")
   // @PostMapping({"/getPackWorkLoad"})
    /*
    @EnableExcelExport(voClass = PaperVo.class, note = "")
    public BaseResponse<HisDataAndColumnsDefinedPage<PaperVo>> getPackWorkLoad(@RequestBody PaperDto paperDto) {
        return HisBaseResponse.successRunqian(srmStatService.queryPaper(paperDto), PaperVo.class);
    }
    */

}
