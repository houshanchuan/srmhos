package com.mediway.hos.srm.business.center.controller.award;


import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.award.AchievementAuthorVo;
import com.mediway.hos.srm.business.center.service.award.SrmAchievementAuthorService;

import java.util.List;

/**
 * <p>
 * 获奖成果作者表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/srmAchievementAuthor")
@Api(tags = "获奖成果作者表")
public class SrmAchievementAuthorController {
    @Autowired
    private SrmAchievementAuthorService srmAchievementAuthorService;
    @PostMapping({"/listAchievementAuthor"})
    public BaseResponse listAchievementAuthor(@RequestBody BaseDto baseDto) {
        List<AchievementAuthorVo> list = srmAchievementAuthorService.listAchievementAuthor(baseDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteAuthorById"})
    public BaseResponse deleteAuthorByIds(@RequestBody BaseDto baseDto) {
        srmAchievementAuthorService.deleteAuthorById(baseDto);
        return BaseResponse.success("删除成功");

    }
}
