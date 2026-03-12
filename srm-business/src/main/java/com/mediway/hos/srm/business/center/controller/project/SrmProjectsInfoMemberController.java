package com.mediway.hos.srm.business.center.controller.project;


import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectsInfoMemberVo;
import com.mediway.hos.srm.business.center.service.project.SrmProjectsInfoMemberService;

import java.util.List;

/**
 * <p>
 * 项目参与人
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/srmProjectsInfoMember")
@Api(tags = "项目参与人")
public class SrmProjectsInfoMemberController {
    @Autowired
    private SrmProjectsInfoMemberService srmProjectsInfoMemberService;
    @PostMapping({"/listProjectInfoAuthor"})
    public BaseResponse listProjectInfoAuthor(@RequestBody BaseDto baseDto) {
        List<ProjectsInfoMemberVo> list = srmProjectsInfoMemberService.listProjectInfoAuthor(baseDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteAuthorByIds"})
    public BaseResponse deleteAuthorByIds(@RequestBody BaseDto baseDto) {
        srmProjectsInfoMemberService.deleteAuthorById(baseDto);
        return BaseResponse.success("删除成功");

    }
}
