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
import com.mediway.hos.srm.business.center.service.baseData.SrmPaperSciPartitionService;
import com.mediway.hos.srm.business.center.model.dto.baseData.PaperSciPartitionDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.PaperSciPartitionVo;
/**
 * <p>
 * SCI论文分区
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/paperSciPartition")
@Api(tags = "SCI论文分区")
public class SrmPaperSciPartitionController {

    @Autowired
    private SrmPaperSciPartitionService srmPaperSciPartitionService;

    @PostMapping({"/saveOrUpdatePaperSciPartition"})
    public BaseResponse saveOrUpdatePaperSciPartition(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmPaperSciPartitionService.saveOrUpdatePaperSciPartition(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailPaperSciPartition(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        PaperSciPartitionVo paperSciPartitionVo = srmPaperSciPartitionService.getDetailPaperSciPartition(RowId);
        return BaseResponse.success(paperSciPartitionVo);
    }

    @PostMapping({"/listPaperSciPartition"})
    public BaseResponse listPaperSciPartition(@RequestBody PaperSciPartitionDto paperSciPartitionDto) {
        IPage<PaperSciPartitionVo> list = srmPaperSciPartitionService.listPaperSciPartition(paperSciPartitionDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deletePaperSciPartition"})
    public BaseResponse deletePaperSciPartition(@RequestBody BaseDto baseDto) {
        srmPaperSciPartitionService.deletePaperSciPartition(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
