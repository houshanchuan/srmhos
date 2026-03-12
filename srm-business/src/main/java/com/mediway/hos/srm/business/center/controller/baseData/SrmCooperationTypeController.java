package com.mediway.hos.srm.business.center.controller.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.model.dto.baseData.CooperationTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.CooperationTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmCooperationTypeService;

/**
 * <p>
 * 合作类型
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/cooperationType")
@Api(tags = "合作类型")
public class SrmCooperationTypeController {

    @Autowired
    private SrmCooperationTypeService srmCooperationTypeService;

    @PostMapping({"/saveOrUpdateCooperationType"})
    public BaseResponse saveOrUpdateCooperationType(@RequestBody BaseDataProjDto baseDataProjDto) {
        Long RowId = srmCooperationTypeService.saveOrUpdateCooperationType(baseDataProjDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailCooperationType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        CooperationTypeVo cooperationTypeVo = srmCooperationTypeService.getDetailCooperationType(RowId);
        return BaseResponse.success(cooperationTypeVo);
    }

    @PostMapping({"/listCooperationType"})
    public BaseResponse listCooperationType(@RequestBody CooperationTypeDto cooperationTypeDto) {
        IPage<CooperationTypeVo> list = srmCooperationTypeService.listCooperationType(cooperationTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteCooperationType"})
    public BaseResponse deleteCooperationType(@RequestBody BaseDto baseDto) {
        srmCooperationTypeService.deleteCooperationType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
