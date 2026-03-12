package com.mediway.hos.srm.business.center.controller.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.service.baseData.SrmAchievementCatService;
import com.mediway.hos.srm.business.center.model.dto.baseData.AchvCatDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.AchvCatVo;

/**
 * <p>
 * 成果分类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/achvCat")
@Api(tags = "成果分类")
public class SrmAchievementCatController {

    @Autowired
    private SrmAchievementCatService srmAchievementCatService;

    @PostMapping({"/saveOrUpdateAchvCat"})
    public BaseResponse saveOrUpdateAchvCat(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmAchievementCatService.saveOrUpdateAchvCat(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailAchvCat(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        AchvCatVo achvCatVo = srmAchievementCatService.getDetailAchvCat(RowId);
        return BaseResponse.success(achvCatVo);
    }

    @PostMapping({"/listAchvCat"})
    public BaseResponse listAchvCat(@RequestBody AchvCatDto achvCatDto) {
        IPage<AchvCatVo> list = srmAchievementCatService.listAchvCat(achvCatDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteAchvCat"})
    public BaseResponse deleteAchvCat(@RequestBody BaseDto baseDto) {
        srmAchievementCatService.deleteAchvCat(baseDto);
        return BaseResponse.success("删除成功!");

    }

}
