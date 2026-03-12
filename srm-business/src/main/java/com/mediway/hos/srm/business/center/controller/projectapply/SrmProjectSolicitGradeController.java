package com.mediway.hos.srm.business.center.controller.projectapply;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitDto;
import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitGradeDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectSolicitGradeVo;
import com.mediway.hos.srm.business.center.service.projectapply.SrmProjectSolicitGradeService;

/**
 * <p>
 * 项目征集专业评分表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/srmProjectSolicitGrade")
@Api(tags = "项目征集专业评分表")
public class SrmProjectSolicitGradeController {
    @Autowired
    private SrmProjectSolicitGradeService srmProjectSolicitGradeService;
    @PostMapping({"/saveDetail"})
    public BaseResponse saveDetail(@RequestBody ProjectSolicitGradeDto projectSolicitGradeDto) {
        Long RowId= srmProjectSolicitGradeService.saveDetail(projectSolicitGradeDto);
        return BaseResponse.success(RowId);
    }
    @PostMapping({"/listAuditProjectSolicit"})
    public BaseResponse listAuditProjectSolicit(@RequestBody ProjectSolicitDto projectSolicitDto) {
        IPage<ProjectSolicitGradeVo> list = srmProjectSolicitGradeService.listAuditProjectSolicit(projectSolicitDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/subMit"})
    public BaseResponse subMit(@RequestBody ProjectSolicitGradeDto projectSolicitGradeDto) {
        //System.out.println(baseDto.toString());
        srmProjectSolicitGradeService.subMit(projectSolicitGradeDto);
        return BaseResponse.success("提交成功!");

    }
    @PostMapping({"/getDetail"})
    public BaseResponse getDetail(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ProjectSolicitGradeVo projectSolicitGradeVo = srmProjectSolicitGradeService.getDetail(String.valueOf(RowId));
        return BaseResponse.success(projectSolicitGradeVo);
    }
}
