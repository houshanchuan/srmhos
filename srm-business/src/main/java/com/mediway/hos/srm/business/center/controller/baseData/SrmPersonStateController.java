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
import com.mediway.hos.srm.business.center.model.dto.baseData.PersonStateDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.PersonStateVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmPersonStateService;

/**
 * <p>
 * 人员状态表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/personState")
@Api(tags = "人员状态表")
public class SrmPersonStateController {
    @Autowired
    private SrmPersonStateService srmPersonStateService;

    @PostMapping({"/saveOrUpdatePersonState"})
    public BaseResponse saveOrUpdatePersonState(@RequestBody BaseDataUserDto baseDataUserDto) {
        Long RowId = srmPersonStateService.saveOrUpdatePersonState(baseDataUserDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailPersonState(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        PersonStateVo personStateVo = srmPersonStateService.getDetailPersonState(RowId);
        return BaseResponse.success(personStateVo);
    }

    @PostMapping({"/listPersonState"})
    public BaseResponse listPersonState(@RequestBody PersonStateDto personStateDto) {
        IPage<PersonStateVo> list = srmPersonStateService.listPersonState(personStateDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deletePersonState"})
    public BaseResponse deletePersonState(@RequestBody BaseDto baseDto) {
        srmPersonStateService.deletePersonState(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
