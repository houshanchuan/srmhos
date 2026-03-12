package com.mediway.hos.srm.business.center.controller.projectapply;


import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectSolicitMemberVo;
import com.mediway.hos.srm.business.center.service.projectapply.SrmProjectSolicitMemberService;

import java.util.List;

/**
 * <p>
 * 项目申报参与人
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/srmProjectSolicitMember")
@Api(tags = "项目申报参与人")
public class SrmProjectSolicitMemberController {
    @Autowired
    private SrmProjectSolicitMemberService srmProjectSolicitMemberService;
    @PostMapping({"/listProjectSolicitMember"})
    public BaseResponse listProjectSolicitMember(@RequestBody BaseDto baseDto) {
        List<ProjectSolicitMemberVo> list = srmProjectSolicitMemberService.listProjectSolicitMember(baseDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteAuthorByIds"})
    public BaseResponse deleteAuthorByIds(@RequestBody BaseDto baseDto) {
        srmProjectSolicitMemberService.deleteAuthorById(baseDto);
        return BaseResponse.success("删除成功");

    }
}
