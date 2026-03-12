package com.mediway.hos.srm.business.center.controller.award;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import com.mediway.hos.srm.business.center.model.dto.award.AchievementDto;
import com.mediway.hos.srm.business.center.model.dto.award.AchievementMainDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.award.AchievementVo;
import com.mediway.hos.srm.business.center.service.award.SrmAchievementService;

/**
 * <p>
 * 成果获奖登记
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/srmAchievement")
@Api(tags = "成果获奖登记")
public class SrmAchievementController {
    @Autowired
    private SrmAchievementService srmAchievementService;
    @PostMapping({"/saveAchievement"})
    public BaseResponse saveAchievement(@RequestBody AchievementMainDto achievementMainDto) {
        System.out.println(achievementMainDto);
        Long RowId= srmAchievementService.saveAchievement(achievementMainDto);
        return BaseResponse.success(RowId);
    }
    @PostMapping({"/getDetail"})
    public BaseResponse getDetail(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        AchievementVo achievementVo = srmAchievementService.getDetail(String.valueOf(RowId));
        return BaseResponse.success(achievementVo);
    }

    @PostMapping({"/listAchievement"})
    public BaseResponse listAchievement(@RequestBody AchievementDto achievementDto) {
        IPage<AchievementVo> list = srmAchievementService.listAchievement(achievementDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteAchievement"})
    public BaseResponse deleteAchievement(@RequestBody BaseDto baseDto) {
        srmAchievementService.deleteAchievement(baseDto);
        return BaseResponse.success("删除成功!");

    }
    @PostMapping({"/subMit"})
    public BaseResponse subMit(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto.toString());
        srmAchievementService.subMit(baseDto);
        return BaseResponse.success("提交成功!");

    }
    @PostMapping({"/listAuditAchievement"})
    public BaseResponse listAuditAchievement(@RequestBody AchievementDto achievementDto) {
        IPage<AchievementVo> list = srmAchievementService.listAuditAchievement(achievementDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/audit"})
    public BaseResponse audit(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto.toString());
        srmAchievementService.audit(baseDto);
        return BaseResponse.success("审批成功!");

    }

}
