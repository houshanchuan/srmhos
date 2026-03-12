package com.mediway.hos.srm.business.center.controller.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.model.dto.baseData.HonorTitleDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.HonorTitleVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmHonorTitleService;


/**
 * <p>
 * 荣誉称号表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/honorTitle")
@Api(tags = "荣誉称号表")
public class SrmHonorTitleController {

    @Autowired
    private SrmHonorTitleService srmHonorTitleService;

    @PostMapping({"/saveOrUpdateHonorTitle"})
    public BaseResponse saveOrUpdateHonorTitle(@RequestBody BaseDataUserDto baseDataUserDto) {
        Long RowId = srmHonorTitleService.saveOrUpdateHonorTitle(baseDataUserDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailHonorTitle(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        HonorTitleVo honorTitleVo = srmHonorTitleService.getDetailHonorTitle(RowId);
        return BaseResponse.success(honorTitleVo);
    }

    @PostMapping({"/listHonorTitle"})
    public BaseResponse listHonorTitle(@RequestBody HonorTitleDto honorTitleDto) {
        IPage<HonorTitleVo> list = srmHonorTitleService.listHonorTitle(honorTitleDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteHonorTitle"})
    public BaseResponse deleteHonorTitle(@RequestBody BaseDto baseDto) {
        srmHonorTitleService.deleteHonorTitle(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
