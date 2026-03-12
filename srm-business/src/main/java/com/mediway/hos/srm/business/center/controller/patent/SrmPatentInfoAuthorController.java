package com.mediway.hos.srm.business.center.controller.patent;


import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.patent.PatentInfoAuthorVo;
import com.mediway.hos.srm.business.center.service.patent.SrmPatentInfoAuthorService;

import java.util.List;

/**
 * <p>
 * 专利作者表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/srmPatentInfoAuthor")
@Api(tags = "专利作者表")
public class SrmPatentInfoAuthorController {
    @Autowired
    private SrmPatentInfoAuthorService srmPatentInfoAuthorService;
    @PostMapping({"/listPatentInfoAuthor"})
    public BaseResponse listPatentInfoAuthor(@RequestBody BaseDto baseDto) {
        List<PatentInfoAuthorVo> list = srmPatentInfoAuthorService.listPatentInfoAuthor(baseDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteAuthorByIds"})
    public BaseResponse deleteAuthorByIds(@RequestBody BaseDto baseDto) {
        srmPatentInfoAuthorService.deleteAuthorById(baseDto);
        return BaseResponse.success("删除成功");

    }
}
