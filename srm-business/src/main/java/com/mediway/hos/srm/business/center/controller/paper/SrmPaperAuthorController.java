package com.mediway.hos.srm.business.center.controller.paper;


import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperAuthorVo;
import com.mediway.hos.srm.business.center.service.paper.SrmPaperAuthorService;

import java.util.List;

/**
 * <p>
 * 论文作者表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/srmPaperAuthor")
@Api(tags = "论文作者表")
public class SrmPaperAuthorController {
    @Autowired
    private SrmPaperAuthorService srmPaperAuthorService;
    @PostMapping({"/listPaperAuthor"})
    public BaseResponse listPaperAuthor(@RequestBody BaseDto baseDto) {
        List<PaperAuthorVo> list = srmPaperAuthorService.listPaperAuthor(baseDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteAuthorByIds"})
    public BaseResponse deleteAuthorByIds(@RequestBody BaseDto baseDto) {
        srmPaperAuthorService.deleteAuthorById(baseDto);
        return BaseResponse.success("删除成功");

    }

}
