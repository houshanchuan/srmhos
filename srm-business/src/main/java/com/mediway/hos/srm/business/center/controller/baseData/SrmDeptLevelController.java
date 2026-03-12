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

import com.mediway.hos.srm.business.center.model.dto.baseData.DeptLevelDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.DeptLevelVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmDeptLevelService;

/**
 * <p>
 * 部门级别
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/deptLevel")
@Api(tags = "部门级别")
public class SrmDeptLevelController {

    @Autowired
    private SrmDeptLevelService srmDeptLevelService;

    @PostMapping({"/saveOrUpdateDeptLevel"})
    public BaseResponse saveOrUpdateDeptLevel(@RequestBody BaseDataUserDto baseDataProjDto) {
        Long RowId = srmDeptLevelService.saveOrUpdateDeptLevel(baseDataProjDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailDeptLevel(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        DeptLevelVo deptLevelVo = srmDeptLevelService.getDetailDeptLevel(RowId);
        return BaseResponse.success(deptLevelVo);
    }

    @PostMapping({"/listDeptLevel"})
    public BaseResponse listDeptLevel(@RequestBody DeptLevelDto deptLevelDto) {
        IPage<DeptLevelVo> list = srmDeptLevelService.listDeptLevel(deptLevelDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteDeptLevel"})
    public BaseResponse deleteDeptLevel(@RequestBody BaseDto baseDto) {
        srmDeptLevelService.deleteDeptLevel(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
