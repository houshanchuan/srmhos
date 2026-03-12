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


import com.mediway.hos.srm.business.center.model.dto.baseData.EduLevelDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.EduLevelVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmEduLevelService;
/**
 * <p>
 * 学历表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/eduLevel")
@Api(tags = "学历表")
public class SrmEduLevelController {

    @Autowired
    private SrmEduLevelService srmEduLevelService;

    @PostMapping({"/saveOrUpdateEduLevel"})
    public BaseResponse saveOrUpdateEduLevel(@RequestBody BaseDataUserDto baseDataUserDto) {
        Long RowId = srmEduLevelService.saveOrUpdateEduLevel(baseDataUserDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailEduLevel(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        EduLevelVo eduLevelVo = srmEduLevelService.getDetailEduLevel(RowId);
        return BaseResponse.success(eduLevelVo);
    }

    @PostMapping({"/listEduLevel"})
    public BaseResponse listEduLevel(@RequestBody EduLevelDto eduLevelDto) {
        IPage<EduLevelVo> list = srmEduLevelService.listEduLevel(eduLevelDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteEduLevel"})
    public BaseResponse deleteEduLevel(@RequestBody BaseDto baseDto) {
        srmEduLevelService.deleteEduLevel(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
