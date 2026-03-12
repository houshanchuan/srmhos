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
import com.mediway.hos.srm.business.center.service.baseData.SrmPressInfoService;
import com.mediway.hos.srm.business.center.model.dto.baseData.PressInfoDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.PressInfoVo;

/**
 * <p>
 * 出版社信息
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-24
 */
@RestController
@RequestMapping("srm/pressInfo")
@Api(tags = "出版社信息")
public class SrmPressInfoController {
    @Autowired
    private SrmPressInfoService srmPressInfoService;

    @PostMapping({"/saveOrUpdatePressInfo"})
    public BaseResponse saveOrUpdatePressInfo(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmPressInfoService.saveOrUpdatePressInfo(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailPressInfo(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        PressInfoVo pressInfoVo = srmPressInfoService.getDetailPressInfo(RowId);
        return BaseResponse.success(pressInfoVo);
    }

    @PostMapping({"/listPressInfo"})
    public BaseResponse listPressInfo(@RequestBody PressInfoDto pressInfoDto) {
        IPage<PressInfoVo> list = srmPressInfoService.listPressInfo(pressInfoDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deletePressInfo"})
    public BaseResponse deletePressInfo(@RequestBody BaseDto baseDto) {
        srmPressInfoService.deletePressInfo(baseDto);
        return BaseResponse.success("删除成功!");

    }
    @PostMapping({"/getPressInfo"})
    public List<CombVo> getPressInfo() {
        List<CombVo> list = srmPressInfoService.getPressInfo();
        return list;
    }
}
