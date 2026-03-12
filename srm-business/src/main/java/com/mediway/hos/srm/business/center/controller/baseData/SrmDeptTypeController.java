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
import com.mediway.hos.srm.business.center.model.dto.baseData.DeptTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.DeptTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmDeptTypeService;
/**
 * <p>
 * 部门类型
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/deptType")
@Api(tags = "部门类型")
public class SrmDeptTypeController {

    @Autowired
    private SrmDeptTypeService srmDeptTypeService;

    @PostMapping({"/saveOrUpdateDeptType"})
    public BaseResponse saveOrUpdateDeptType(@RequestBody BaseDataUserDto baseDataUserDto) {
        Long RowId = srmDeptTypeService.saveOrUpdateDeptType(baseDataUserDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailDeptType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        DeptTypeVo deptTypeVo = srmDeptTypeService.getDetailDeptType(RowId);
        return BaseResponse.success(deptTypeVo);
    }

    @PostMapping({"/listDeptType"})
    public BaseResponse listDeptType(@RequestBody DeptTypeDto deptTypeDto) {
        IPage<DeptTypeVo> list = srmDeptTypeService.listDeptType(deptTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteDeptType"})
    public BaseResponse deleteDeptType(@RequestBody BaseDto baseDto) {
        srmDeptTypeService.deleteDeptType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
