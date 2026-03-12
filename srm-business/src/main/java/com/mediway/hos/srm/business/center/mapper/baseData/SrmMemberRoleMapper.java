package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.MemberRoleDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.MemberRoleVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmMemberRole;

/**
 * <p>
 * 成员角色代码 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmMemberRoleMapper extends BaseMapper<SrmMemberRole> {
    IPage<MemberRoleVo> listMemberRole(@Param("page") Page<MemberRoleVo> page, @Param("memberRoleDto") MemberRoleDto memberRoleDto);

}
