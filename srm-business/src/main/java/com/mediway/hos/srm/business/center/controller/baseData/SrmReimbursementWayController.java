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
import com.mediway.hos.srm.business.center.service.baseData.SrmReimbursementWayService;
import com.mediway.hos.srm.business.center.model.dto.baseData.ReimbursementWayDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ReimbursementWayVo;

/**
 * <p>
 * 报销途径
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/reimbursementWay")
@Api(tags = "报销途径")
public class SrmReimbursementWayController {

    @Autowired
    private SrmReimbursementWayService srmReimbursementWayService;

    @PostMapping({"/saveOrUpdateReimbursementWay"})
    public BaseResponse saveOrUpdateReimbursementWay(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmReimbursementWayService.saveOrUpdateReimbursementWay(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailReimbursementWay(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ReimbursementWayVo reimbursementWayVo = srmReimbursementWayService.getDetailReimbursementWay(RowId);
        return BaseResponse.success(reimbursementWayVo);
    }

    @PostMapping({"/listReimbursementWay"})
    public BaseResponse listReimbursementWay(@RequestBody ReimbursementWayDto reimbursementWayDto) {
        IPage<ReimbursementWayVo> list = srmReimbursementWayService.listReimbursementWay(reimbursementWayDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteReimbursementWay"})
    public BaseResponse deleteReimbursementWay(@RequestBody BaseDto baseDto) {
        srmReimbursementWayService.deleteReimbursementWay(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
