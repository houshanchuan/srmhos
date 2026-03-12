package com.mediway.hos.srm.business.center.controller.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.model.dto.baseData.PersonTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.PersonTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmPersonTypeService;


/**
 * <p>
 * 人员类型
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-24
 */
@RestController
@RequestMapping("srm/personType")
@Api(tags = "人员类型")
public class SrmPersonTypeController {
    @Autowired
    private SrmPersonTypeService srmPersonTypeService;
    @PostMapping({"/getPersonType"})
    public List<CombVo> getPersonType() {
        List<CombVo> list = srmPersonTypeService.getPersonType();
        return list;
    }
    @PostMapping({"/saveOrUpdatePersonType"})
    public BaseResponse saveOrUpdatePersonType(@RequestBody BaseDataUserDto baseDataUserDto) {
        Long RowId = srmPersonTypeService.saveOrUpdatePersonType(baseDataUserDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailPersonType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        PersonTypeVo personTypeVo = srmPersonTypeService.getDetailPersonType(RowId);
        return BaseResponse.success(personTypeVo);
    }

    @PostMapping({"/listPersonType"})
    public BaseResponse listPersonType(@RequestBody PersonTypeDto personTypeDto) {
        IPage<PersonTypeVo> list = srmPersonTypeService.listPersonType(personTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deletePersonType"})
    public BaseResponse deletePersonType(@RequestBody BaseDto baseDto) {
        srmPersonTypeService.deletePersonType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
