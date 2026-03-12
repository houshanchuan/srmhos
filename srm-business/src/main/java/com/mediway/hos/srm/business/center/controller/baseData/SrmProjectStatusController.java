package com.mediway.hos.srm.business.center.controller.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataCommonDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectStatusDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectStatusVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjectStatusService;
/**
 * <p>
 * 项目状态代码
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/projectStatus")
@Api(tags = "项目状态代码")
public class SrmProjectStatusController {

    @Autowired
    private SrmProjectStatusService srmProjectStatusService;

    @PostMapping({"/saveOrUpdateProjectStatus"})
    public BaseResponse saveOrUpdateProjectStatus(@RequestBody BaseDataCommonDto bseDataCommonDto) {
        Long RowId = srmProjectStatusService.saveOrUpdateProjectStatus(bseDataCommonDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailProjectStatus(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ProjectStatusVo projectStatusVo = srmProjectStatusService.getDetailProjectStatus(RowId);
        return BaseResponse.success(projectStatusVo);
    }

    @PostMapping({"/listProjectStatus"})
    public BaseResponse listProjectStatus(@RequestBody ProjectStatusDto projectStatusDto) {
        IPage<ProjectStatusVo> list = srmProjectStatusService.listProjectStatus(projectStatusDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteProjectStatus"})
    public BaseResponse deleteProjectStatus(@RequestBody BaseDto baseDto) {
        srmProjectStatusService.deleteProjectStatus(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
