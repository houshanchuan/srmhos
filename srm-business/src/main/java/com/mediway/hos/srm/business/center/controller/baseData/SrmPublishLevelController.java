package com.mediway.hos.srm.business.center.controller.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.service.baseData.SrmPublishLevelService;
import com.mediway.hos.srm.business.center.model.dto.baseData.PublishLevelDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.PublishLevelVo;


/**
 * <p>
 * 出版级别
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/publishLevel")
@Api(tags = "出版级别")
public class SrmPublishLevelController {
    @Autowired
    private SrmPublishLevelService srmPublishLevelService;

    @PostMapping({"/saveOrUpdatePublishLevel"})
    public BaseResponse saveOrUpdatePublishLevel(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmPublishLevelService.saveOrUpdatePublishLevel(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailPublishLevel(@RequestBody BaseDto baseDto) {
        Long RowId = baseDto.getId();
        PublishLevelVo publishLevelVo = srmPublishLevelService.getDetailPublishLevel(RowId);
        return BaseResponse.success(publishLevelVo);
    }

    @PostMapping({"/listPublishLevel"})
    public BaseResponse listPublishLevel(@RequestBody PublishLevelDto publishLevelDto) {
        IPage<PublishLevelVo> list = srmPublishLevelService.listPublishLevel(publishLevelDto);
        return BaseResponse.success(list);

    }

    @PostMapping({"/deletePublishLevel"})
    public BaseResponse deletePublishLevel(@RequestBody BaseDto baseDto) {
        srmPublishLevelService.deletePublishLevel(baseDto);
        return BaseResponse.success("删除成功!");

    }

    @PostMapping({"/getPublishLevel"})
    public List<CombVo> getPublishLevel() {
        return srmPublishLevelService.getPublishLevel();
    }
}