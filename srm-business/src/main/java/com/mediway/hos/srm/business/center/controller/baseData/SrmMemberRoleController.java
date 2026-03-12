package com.mediway.hos.srm.business.center.controller.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.model.dto.baseData.MemberRoleDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.MemberRoleVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmMemberRoleService;

/**
 * <p>
 * 成员角色代码
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/memberRole")
@Api(tags = "成员角色代码")
public class SrmMemberRoleController {

    @Autowired
    private SrmMemberRoleService srmMemberRoleService;

    @PostMapping({"/saveOrUpdateMemberRole"})
    public BaseResponse saveOrUpdateMemberRole(@RequestBody BaseDataProjDto baseDataProjDto) {
        Long RowId = srmMemberRoleService.saveOrUpdateMemberRole(baseDataProjDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailMemberRole(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        MemberRoleVo memberRoleVo = srmMemberRoleService.getDetailMemberRole(RowId);
        return BaseResponse.success(memberRoleVo);
    }

    @PostMapping({"/listMemberRole"})
    public BaseResponse listMemberRole(@RequestBody MemberRoleDto memberRoleDto) {
        IPage<MemberRoleVo> list = srmMemberRoleService.listMemberRole(memberRoleDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteMemberRole"})
    public BaseResponse deleteMemberRole(@RequestBody BaseDto baseDto) {
        srmMemberRoleService.deleteMemberRole(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
