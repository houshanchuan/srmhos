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

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectApplyStateDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectApplyStateVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjectApplyStateService;

/**
 * <p>
 * 项目申报状态
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/projectApplyState")
@Api(tags = "项目申报状态")
public class SrmProjectApplyStateController {

    @Autowired
    private SrmProjectApplyStateService srmProjectApplyStateService;

    @PostMapping({"/saveOrUpdateProjectApplyState"})
    public BaseResponse saveOrUpdateProjectApplyState(@RequestBody BaseDataCommonDto baseDataCommonDto) {
        Long RowId = srmProjectApplyStateService.saveOrUpdateProjectApplyState(baseDataCommonDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailProjectApplyState(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ProjectApplyStateVo projectApplyStateVo = srmProjectApplyStateService.getDetailProjectApplyState(RowId);
        return BaseResponse.success(projectApplyStateVo);
    }

    @PostMapping({"/listProjectApplyState"})
    public BaseResponse listProjectApplyState(@RequestBody ProjectApplyStateDto projectApplyStateDto) {
        IPage<ProjectApplyStateVo> list = srmProjectApplyStateService.listProjectApplyState(projectApplyStateDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteProjectApplyState"})
    public BaseResponse deleteProjectApplyState(@RequestBody BaseDto baseDto) {
        srmProjectApplyStateService.deleteProjectApplyState(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
