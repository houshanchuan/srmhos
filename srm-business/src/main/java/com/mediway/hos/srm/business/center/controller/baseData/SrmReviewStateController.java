package com.mediway.hos.srm.business.center.controller.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataCommonDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.model.dto.baseData.ReviewStateDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ReviewStateVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmReviewStateService;

/**
 * <p>
 * 评审状态
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/reviewState")
@Api(tags = "评审状态")
public class SrmReviewStateController {

    @Autowired
    private SrmReviewStateService srmReviewStateService;

    @PostMapping({"/saveOrUpdateReviewState"})
    public BaseResponse saveOrUpdateReviewState(@RequestBody BaseDataCommonDto baseDataCommonDto) {
        Long RowId = srmReviewStateService.saveOrUpdateReviewState(baseDataCommonDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailReviewState(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ReviewStateVo reviewStateVo = srmReviewStateService.getDetailReviewState(RowId);
        return BaseResponse.success(reviewStateVo);
    }

    @PostMapping({"/listReviewState"})
    public BaseResponse listReviewState(@RequestBody ReviewStateDto reviewStateDto) {
        IPage<ReviewStateVo> list = srmReviewStateService.listReviewState(reviewStateDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteReviewState"})
    public BaseResponse deleteReviewState(@RequestBody BaseDto baseDto) {
        srmReviewStateService.deleteReviewState(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
