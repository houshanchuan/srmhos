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
import com.mediway.hos.srm.business.center.service.baseData.SrmContentRealService;
import com.mediway.hos.srm.business.center.model.dto.baseData.ContentRealDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ContentRealVo;

/**
 * <p>
 * 内容真实性代码
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/contentReal")
@Api(tags = "内容真实性代码")
public class SrmContentRealController {
    @Autowired
    private SrmContentRealService srmContentRealService;

    @PostMapping({"/saveOrUpdateContentReal"})
    public BaseResponse saveOrUpdateContentReal(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmContentRealService.saveOrUpdateContentReal(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailContentReal(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ContentRealVo contentRealVo = srmContentRealService.getDetailContentReal(RowId);
        return BaseResponse.success(contentRealVo);
    }

    @PostMapping({"/listContentReal"})
    public BaseResponse listContentReal(@RequestBody ContentRealDto contentRealDto) {
        IPage<ContentRealVo> list = srmContentRealService.listContentReal(contentRealDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteContentReal"})
    public BaseResponse deleteContentReal(@RequestBody BaseDto baseDto) {
        srmContentRealService.deleteContentReal(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
