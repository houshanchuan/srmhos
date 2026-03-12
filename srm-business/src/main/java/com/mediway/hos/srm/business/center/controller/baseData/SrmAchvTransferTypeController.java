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
import com.mediway.hos.srm.business.center.service.baseData.SrmAchvTransferTypeService;
import com.mediway.hos.srm.business.center.model.dto.baseData.AchvTransferTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.AchvTransferTypeVo;
/**
 * <p>
 * 成果转化类型
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/achvTransferType")
@Api(tags = "成果转化类型")
public class SrmAchvTransferTypeController {
    @Autowired
    private SrmAchvTransferTypeService srmAchvTransferTypeService;

    @PostMapping({"/saveOrUpdateAchvTransferType"})
    public BaseResponse saveOrUpdateAchvTransferType(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmAchvTransferTypeService.saveOrUpdateAchvTransferType(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailAchvTransferType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        AchvTransferTypeVo achvTransferTypeVo = srmAchvTransferTypeService.getDetailAchvTransferType(RowId);
        return BaseResponse.success(achvTransferTypeVo);
    }

    @PostMapping({"/listAchvTransferType"})
    public BaseResponse listAchvTransferType(@RequestBody AchvTransferTypeDto achvTransferTypeDto) {
        IPage<AchvTransferTypeVo> list = srmAchvTransferTypeService.listAchvTransferType(achvTransferTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteAchvTransferType"})
    public BaseResponse deleteAchvTransferType(@RequestBody BaseDto baseDto) {
        srmAchvTransferTypeService.deleteAchvTransferType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
