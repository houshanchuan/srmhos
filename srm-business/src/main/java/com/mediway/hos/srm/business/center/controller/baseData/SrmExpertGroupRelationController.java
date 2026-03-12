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

import com.mediway.hos.srm.business.center.model.dto.baseData.ExpertGroupRelationDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ExpertGroupRelationVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmExpertGroupRelationService;

/**
 * <p>
 * 组织关系定义
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/expertGroupRelation")
@Api(tags = "组织关系定义")
public class SrmExpertGroupRelationController {

    @Autowired
    private SrmExpertGroupRelationService srmExpertGroupRelationService;

    @PostMapping({"/saveOrUpdateSrmExpertGroupRelation"})
    public BaseResponse saveOrUpdateSrmExpertGroupRelation(@RequestBody BaseDataUserDto baseDataUserDto) {
        Long RowId = srmExpertGroupRelationService.saveOrUpdateSrmExpertGroupRelation(baseDataUserDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailSrmExpertGroupRelation(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ExpertGroupRelationVo expertGroupRelationVo = srmExpertGroupRelationService.getDetailSrmExpertGroupRelation(RowId);
        return BaseResponse.success(expertGroupRelationVo);
    }

    @PostMapping({"/listSrmExpertGroupRelation"})
    public BaseResponse listSrmExpertGroupRelation(@RequestBody ExpertGroupRelationDto expertGroupRelationDto) {
        IPage<ExpertGroupRelationVo> list = srmExpertGroupRelationService.listSrmExpertGroupRelation(expertGroupRelationDto);
        System.out.println(":::" +expertGroupRelationDto.getGroupId());
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteSrmExpertGroupRelation"})
    public BaseResponse deleteSrmExpertGroupRelation(@RequestBody BaseDto baseDto) {
        srmExpertGroupRelationService.deleteSrmExpertGroupRelation(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
