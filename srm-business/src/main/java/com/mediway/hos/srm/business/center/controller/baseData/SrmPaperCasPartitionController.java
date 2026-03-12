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

import com.mediway.hos.srm.business.center.service.baseData.SrmPaperCasPartitionService;
import com.mediway.hos.srm.business.center.model.dto.baseData.PaperCASPartitionDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.PaperCASPartitionVo;

/**
 * <p>
 * 中科院论文分区
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/paperCasPartition")
@Api(tags = "中科院论文分区")
public class SrmPaperCasPartitionController {
    @Autowired
    private SrmPaperCasPartitionService srmPaperCasPartitionService;

    @PostMapping({"/saveOrUpdatePaperCasPartition"})
    public BaseResponse saveOrUpdatePaperCasPartition(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmPaperCasPartitionService.saveOrUpdatePaperCasPartition(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailPaperCasPartition(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        PaperCASPartitionVo yyyyVo = srmPaperCasPartitionService.getDetailPaperCasPartition(RowId);
        return BaseResponse.success(yyyyVo);
    }

    @PostMapping({"/listPaperCasPartition"})
    public BaseResponse listPaperCasPartition(@RequestBody PaperCASPartitionDto yyyyDto) {
        IPage<PaperCASPartitionVo> list = srmPaperCasPartitionService.listPaperCasPartition(yyyyDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deletePaperCasPartition"})
    public BaseResponse deletePaperCasPartition(@RequestBody BaseDto baseDto) {
        srmPaperCasPartitionService.deletePaperCasPartition(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
