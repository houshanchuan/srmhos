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
import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectApplyInfoStateDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectApplyInfoStateVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjectApplyInfoStateService;

/**
 * <p>
 * 项目申报批次状态
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/projectApplyInfoState")
@Api(tags = "项目申报批次状态")
public class SrmProjectApplyInfoStateController {

    @Autowired
    private SrmProjectApplyInfoStateService srmProjectApplyInfoStateService;

    @PostMapping({"/saveOrUpdateProjectApplyInfoState"})
    public BaseResponse saveOrUpdateProjectApplyInfoState(@RequestBody BaseDataCommonDto baseDataCommonDto) {
        Long RowId = srmProjectApplyInfoStateService.saveOrUpdateProjectApplyInfoState(baseDataCommonDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailProjectApplyInfoState(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ProjectApplyInfoStateVo projectApplyInfoStateVo = srmProjectApplyInfoStateService.getDetailProjectApplyInfoState(RowId);
        return BaseResponse.success(projectApplyInfoStateVo);
    }

    @PostMapping({"/listProjectApplyInfoState"})
    public BaseResponse listProjectApplyInfoState(@RequestBody ProjectApplyInfoStateDto projectApplyInfoStateDto) {
        IPage<ProjectApplyInfoStateVo> list = srmProjectApplyInfoStateService.listProjectApplyInfoState(projectApplyInfoStateDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteProjectApplyInfoState"})
    public BaseResponse deleteProjectApplyInfoState(@RequestBody BaseDto baseDto) {
        srmProjectApplyInfoStateService.deleteProjectApplyInfoState(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
