package com.mediway.hos.srm.business.center.controller.paper;


import com.mediway.hos.base.model.BaseResponse;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;

import com.mediway.hos.srm.business.center.model.vo.paper.PaperReshipVo;
import com.mediway.hos.srm.business.center.service.paper.SrmPaperReshipService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 论文转载表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/srmPaperReship")
@Api(tags = "论文转载表")
public class SrmPaperReshipController {
    @Autowired
    private SrmPaperReshipService srmPaperReshipService;
    @PostMapping({"/listPaperReship"})
    public BaseResponse listPaperReship(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto);
        List<PaperReshipVo> list = srmPaperReshipService.listPaperReship(baseDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deletePaperReshipByIds"})
    public BaseResponse deletePaperReshipByIds(@RequestBody BaseDto baseDto) {
        srmPaperReshipService.deletePaperReshipByIds(baseDto);
        return BaseResponse.success("删除成功");

    }
}
