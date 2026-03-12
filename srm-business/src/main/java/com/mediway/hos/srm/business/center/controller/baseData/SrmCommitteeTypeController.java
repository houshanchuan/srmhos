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

import com.mediway.hos.srm.business.center.model.dto.baseData.CommitteeTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.CommitteeTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmCommitteeTypeService;

/**
 * <p>
 * 学会类型
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srmCommitteeType")
@Api(tags = "学会类型")
public class SrmCommitteeTypeController {

    @Autowired
    private SrmCommitteeTypeService srmCommitteeTypeService;

    @PostMapping({"/saveOrUpdateCommitteeType"})
    public BaseResponse saveOrUpdateCommitteeType(@RequestBody BaseDataUserDto baseDataUserDto) {
        Long RowId = srmCommitteeTypeService.saveOrUpdateCommitteeType(baseDataUserDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailCommitteeType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        CommitteeTypeVo committeeTypeVo = srmCommitteeTypeService.getDetailCommitteeType(RowId);
        return BaseResponse.success(committeeTypeVo);
    }

    @PostMapping({"/listCommitteeType"})
    public BaseResponse listCommitteeType(@RequestBody CommitteeTypeDto committeeTypeDto) {
        IPage<CommitteeTypeVo> list = srmCommitteeTypeService.listCommitteeType(committeeTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteCommitteeType"})
    public BaseResponse deleteCommitteeType(@RequestBody BaseDto baseDto) {
        srmCommitteeTypeService.deleteCommitteeType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
