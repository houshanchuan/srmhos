package com.mediway.hos.srm.business.center.controller.projectapply;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectApplyInfoDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectApplyInfoVo;
import com.mediway.hos.srm.business.center.service.projectapply.SrmProjectApplyInfoService;

/**
 * <p>
 * 项目申报批次
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-23
 */
@RestController
@RequestMapping("srm/projectApplyInfo")
@Api(tags = "项目申报批次")
public class SrmProjectApplyInfoController {
    @Autowired
    private SrmProjectApplyInfoService srmProjectApplyInfoService;
    @PostMapping({"/listProjectApplyInfo"})
    public BaseResponse listProjectApplyPlan(@RequestBody ProjectApplyInfoDto projectApplyInfoDto) {
        IPage<ProjectApplyInfoVo> list = srmProjectApplyInfoService.listProjectApplyPlan(projectApplyInfoDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteProjectApplyInfo"})
    public BaseResponse deleteProjectApplyPlan(@RequestBody BaseDto baseDto) {
        srmProjectApplyInfoService.deleteProjectApplyPlan(baseDto);
        return BaseResponse.success("删除成功!");

    }
    @PostMapping({"/saveProjectApplyInfo"})
    public BaseResponse saveProjectApplyPlan(@RequestBody ProjectApplyInfoDto projectApplyInfoDto) {
        Long RowId= srmProjectApplyInfoService.saveProjectApplyPlan(projectApplyInfoDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetail(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ProjectApplyInfoVo projectApplyInfoVo = srmProjectApplyInfoService.getDetail(RowId);
        return BaseResponse.success(projectApplyInfoVo);
    }
}
