package com.mediway.hos.srm.business.center.controller.monograph;


import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.monograph.MonographAuthorVo;
import com.mediway.hos.srm.business.center.service.monograph.SrmMonographInfoAuthorService;

import java.util.List;

/**
 * <p>
 * 著作作者表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-25
 */
@RestController
@RequestMapping("srm/monographInfoAuthor")
@Api(tags = "著作作者表")
public class SrmMonographInfoAuthorController {
    @Autowired
    private SrmMonographInfoAuthorService srmMonographInfoAuthorService;

    @PostMapping({"/ListMonographAuthor"})
    public List<MonographAuthorVo> ListMonographAuthor(@RequestBody BaseDto baseDto) {
        Long RowID=baseDto.getId();
        List<MonographAuthorVo> list = srmMonographInfoAuthorService.ListMonographAuthor(RowID);
        return list;
    }
    @PostMapping({"/deleteMonographAuthor"})
    public BaseResponse deleteMonographAuthor(@RequestBody BaseDto baseDto) {
        srmMonographInfoAuthorService.deleteMonographAuthor(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
