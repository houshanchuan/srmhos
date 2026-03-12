package com.mediway.hos.srm.business.center.controller.project;


import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectsInfoChangeMemberVo;
import com.mediway.hos.srm.business.center.service.project.SrmProjectsInfoChangeMemberService;

import java.util.List;

/**
 * <p>
 * 项目变更人员信息表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/srmProjectsInfoChangeMember")
@Api(tags = "项目变更人员信息表")
public class SrmProjectsInfoChangeMemberController {
    @Autowired
    private SrmProjectsInfoChangeMemberService srmProjectsInfoChangeMemberService;
    @PostMapping({"/listProjectInfoAuthor"})
    public BaseResponse listProjectInfoAuthor(@RequestBody BaseDto baseDto) {
        List<ProjectsInfoChangeMemberVo> list = srmProjectsInfoChangeMemberService.listProjectsInfoChangeAuthor(baseDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteAuthorByIds"})
    public BaseResponse deleteAuthorByIds(@RequestBody BaseDto baseDto) {
        srmProjectsInfoChangeMemberService.deleteAuthorById(baseDto);
        return BaseResponse.success("删除成功");

    }
}
