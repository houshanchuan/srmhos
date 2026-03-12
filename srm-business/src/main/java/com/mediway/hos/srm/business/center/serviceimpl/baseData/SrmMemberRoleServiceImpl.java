package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import com.mediway.hos.srm.business.center.constants.BusinessConstants;
import com.mediway.hos.srm.business.center.service.baseData.SrmBusinessnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.MemberRoleDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.MemberRoleVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmMemberRole;
import com.mediway.hos.srm.business.center.service.baseData.SrmMemberRoleService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmMemberRoleMapper;

/**
 * <p>
 * 成员角色代码 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmMemberRoleServiceImpl extends BaseServiceImpl<SrmMemberRoleMapper, SrmMemberRole> implements SrmMemberRoleService {

    @Autowired
    private SrmMemberRoleService  srmMemberRoleService;
    @Autowired
    private SrmMemberRoleMapper srmMemberRoleMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateMemberRole(BaseDataProjDto baseDataProjDto) {
        List<MemberRoleDto> memberRoleDtos =baseDataProjDto.getMemberRoles();

        List<SrmMemberRole> memberRoleList=new ArrayList<>();
        for (MemberRoleDto memberRoleDto :memberRoleDtos) {
            SrmMemberRole srmMemberRole = new SrmMemberRole();
            srmMemberRole.setId(memberRoleDto.getRowId());
            if(ObjectUtil.isEmpty(memberRoleDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.MEMBER_ROLE, 1, "");
                srmMemberRole.setCode(code);
            }else{
                srmMemberRole.setCode(memberRoleDto.getCode());
            }
            srmMemberRole.setName(memberRoleDto.getName());
            srmMemberRole.setIsValid(Integer.valueOf(memberRoleDto.getIsValid()));

            memberRoleList.add(srmMemberRole);
            Long RowId = srmMemberRole.getId();
        }
        super.saveOrUpdateBatch(memberRoleList);
        return RowId;
    }
    @Override
    public MemberRoleVo getDetailMemberRole(Long RowId) {
        return null;
    }

    @Override
    public IPage<MemberRoleVo> listMemberRole(MemberRoleDto memberRoleDto) {
        Page<MemberRoleVo> page = new Page<>(memberRoleDto.getPage(), memberRoleDto.getRows());
        IPage<MemberRoleVo> res= srmMemberRoleMapper.listMemberRole(page, memberRoleDto);
        //List<MemberRoleVo> records=res.getRecords();
        //List<MemberRoleVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteMemberRole(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                //System.out.println(RowId);
                if(StringUtils.isEmpty(idStr)){
                    idStr=String.valueOf(RowId);
                }else{
                    idStr=idStr+","+String.valueOf(RowId);
                }
            }
            super.deleteByIds(idStr);
        }catch (Exception exception){
            throw  new ErrorException("-200",exception.getMessage());
        }
    }

    @Override
    public Long getIdByName(String name) {
        return null;
    }
}
