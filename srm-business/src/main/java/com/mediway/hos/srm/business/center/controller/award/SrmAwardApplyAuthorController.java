package com.mediway.hos.srm.business.center.controller.award;


import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.award.AwardApplyAuthorVo;
import com.mediway.hos.srm.business.center.service.award.SrmAwardApplyAuthorService;

import java.util.List;

/**
 * <p>
 * 成果获奖申报作者
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/srmAwardApplyAuthor")
@Api(tags = "成果获奖申报作者")
public class SrmAwardApplyAuthorController {
    @Autowired
    private SrmAwardApplyAuthorService srmAwardApplyAuthorService;
    @PostMapping({"/listAwardApplyAuthor"})
    public BaseResponse listAwardApplyAuthor(@RequestBody BaseDto baseDto) {
        List<AwardApplyAuthorVo> list = srmAwardApplyAuthorService.listAwardApplyAuthor(baseDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteAuthorByIds"})
    public BaseResponse deleteAuthorByIds(@RequestBody BaseDto baseDto) {
        srmAwardApplyAuthorService.deleteAuthorById(baseDto);
        return BaseResponse.success("删除成功");

    }
}
