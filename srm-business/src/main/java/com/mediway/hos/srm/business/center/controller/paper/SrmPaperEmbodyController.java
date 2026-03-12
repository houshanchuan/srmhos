package com.mediway.hos.srm.business.center.controller.paper;


import com.mediway.hos.base.model.BaseResponse;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperAuthorVo;

import com.mediway.hos.srm.business.center.model.vo.paper.PaperEmbodyVo;
import com.mediway.hos.srm.business.center.service.paper.SrmPaperEmbodyService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 论文收录表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/srmPaperEmbody")
@Api(tags = "论文收录表")
public class SrmPaperEmbodyController {
    @Autowired
    private SrmPaperEmbodyService srmPaperEmbodyService;
    @PostMapping({"/listPaperEmbody"})
    public BaseResponse listPaperEmbody(@RequestBody BaseDto baseDto) {
        List<PaperEmbodyVo> list = srmPaperEmbodyService.listPaperEmbody(baseDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deletePaperEmbodyByIds"})
    public BaseResponse deletePaperEmbodyByIds(@RequestBody BaseDto baseDto) {
        srmPaperEmbodyService.deletePaperEmbodyByIds(baseDto);
        return BaseResponse.success("删除成功");

    }
}
