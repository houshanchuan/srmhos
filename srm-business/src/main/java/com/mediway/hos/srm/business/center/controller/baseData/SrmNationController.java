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

import com.mediway.hos.srm.business.center.model.dto.baseData.NationDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.NationVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmNationService;


/**
 * <p>
 * 民族代码表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/nation")
@Api(tags = "民族代码表")
public class SrmNationController {
    @Autowired
    private SrmNationService srmNationService;

    @PostMapping({"/saveOrUpdateNation"})
    public BaseResponse saveOrUpdateNation(@RequestBody BaseDataUserDto baseDataUserDto) {
        Long RowId = srmNationService.saveOrUpdateNation(baseDataUserDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailNation(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        NationVo nationVo = srmNationService.getDetailNation(RowId);
        return BaseResponse.success(nationVo);
    }

    @PostMapping({"/listNation"})
    public BaseResponse listNation(@RequestBody NationDto nationDto) {
        IPage<NationVo> list = srmNationService.listNation(nationDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteNation"})
    public BaseResponse deleteNation(@RequestBody BaseDto baseDto) {
        srmNationService.deleteNation(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
