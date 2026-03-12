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
import com.mediway.hos.srm.business.center.service.baseData.SrmPaperAuthorOrderService;
import com.mediway.hos.srm.business.center.model.dto.baseData.PaperAuthorOrderDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.PaperAuthorOrderVo;


/**
 * <p>
 * 论文作者排序
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-24
 */
@RestController
@RequestMapping("srm/paperAuthorOrder")
@Api(tags = "论文作者排序")
public class SrmPaperAuthorOrderController {
    @Autowired
    private SrmPaperAuthorOrderService srmPaperAuthorOrderService;
    @PostMapping({"/getPaperAuthorOrder"})
    public List<CombVo> getPaperAuthorOrder() {
        List<CombVo> list = srmPaperAuthorOrderService.getPaperAuthorOrder();
        return list;
    }
    @PostMapping({"/saveOrUpdatePaperAuthorOrder"})
    public BaseResponse saveOrUpdatePaperAuthorOrder(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmPaperAuthorOrderService.saveOrUpdatePaperAuthorOrder(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailPaperAuthorOrder(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        PaperAuthorOrderVo yyyyVo = srmPaperAuthorOrderService.getDetailPaperAuthorOrder(RowId);
        return BaseResponse.success(yyyyVo);
    }

    @PostMapping({"/listPaperAuthorOrder"})
    public BaseResponse listPaperAuthorOrder(@RequestBody PaperAuthorOrderDto yyyyDto) {
        IPage<PaperAuthorOrderVo> list = srmPaperAuthorOrderService.listPaperAuthorOrder(yyyyDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deletePaperAuthorOrder"})
    public BaseResponse deletePaperAuthorOrder(@RequestBody BaseDto baseDto) {
        srmPaperAuthorOrderService.deletePaperAuthorOrder(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
