package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.MemberRoleDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.MemberRoleVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmMemberRole;

/**
 * <p>
 * 成员角色代码 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmMemberRoleService extends BaseService<SrmMemberRole> {

    @Transactional
    Long saveOrUpdateMemberRole(BaseDataProjDto baseDataProjDto);

    MemberRoleVo getDetailMemberRole(Long RowId);
    IPage<MemberRoleVo> listMemberRole(MemberRoleDto memberRoleDto);

    void deleteMemberRole(BaseDto baseDto);

    Long getIdByName(String name);
}
