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

import com.mediway.hos.srm.business.center.model.dto.baseData.ExpertGroupDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ExpertGroupVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmExpertGroupService;


/**
 * <p>
 * 专家组
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/expertGroup")
@Api(tags = "专家组")
public class SrmExpertGroupController {

    @Autowired
    private SrmExpertGroupService srmExpertGroupService;

    @PostMapping({"/saveOrUpdateSrmExpertGroup"})
    public BaseResponse saveOrUpdateSrmExpertGroup(@RequestBody BaseDataUserDto baseDataUserDto) {
        Long RowId = srmExpertGroupService.saveOrUpdateSrmExpertGroup(baseDataUserDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailSrmExpertGroup(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ExpertGroupVo expertGroupVo = srmExpertGroupService.getDetailSrmExpertGroup(RowId);
        return BaseResponse.success(expertGroupVo);
    }

    @PostMapping({"/listSrmExpertGroup"})
    public BaseResponse listSrmExpertGroup(@RequestBody ExpertGroupDto expertGroupDto) {
        IPage<ExpertGroupVo> list = srmExpertGroupService.listSrmExpertGroup(expertGroupDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteSrmExpertGroup"})
    public BaseResponse deleteSrmExpertGroup(@RequestBody BaseDto baseDto) {
        srmExpertGroupService.deleteSrmExpertGroup(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
