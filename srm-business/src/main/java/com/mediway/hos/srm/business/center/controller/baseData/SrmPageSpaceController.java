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

import com.mediway.hos.srm.business.center.service.baseData.SrmPageSpaceService;
import com.mediway.hos.srm.business.center.model.dto.baseData.PageSpaceDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.PageSpaceVo;

/**
 * <p>
 * 版面
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/pageSpace")
@Api(tags = "版面")
public class SrmPageSpaceController {
    @Autowired
    private SrmPageSpaceService srmPageSpaceService;

    @PostMapping({"/saveOrUpdatePageSpace"})
    public BaseResponse saveOrUpdatePageSpace(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmPageSpaceService.saveOrUpdatePageSpace(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailPageSpace(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        PageSpaceVo pageSpaceVo = srmPageSpaceService.getDetailPageSpace(RowId);
        return BaseResponse.success(pageSpaceVo);
    }

    @PostMapping({"/listPageSpace"})
    public BaseResponse listPageSpace(@RequestBody PageSpaceDto pageSpaceDto) {
        IPage<PageSpaceVo> list = srmPageSpaceService.listPageSpace(pageSpaceDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deletePageSpace"})
    public BaseResponse deletePageSpace(@RequestBody BaseDto baseDto) {
        srmPageSpaceService.deletePageSpace(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
