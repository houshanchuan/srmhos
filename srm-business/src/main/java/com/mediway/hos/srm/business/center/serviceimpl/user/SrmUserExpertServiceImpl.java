package com.mediway.hos.srm.business.center.serviceimpl.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import com.mediway.hos.app.core.util.SecurityUtils;
import com.mediway.hos.security.core.userdetails.HosUser;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.ExpertGroupDto;
import com.mediway.hos.srm.business.center.model.dto.user.UserDto;
import com.mediway.hos.srm.business.center.model.dto.user.UserExpertDto;
import com.mediway.hos.srm.business.center.model.dto.user.UserExpertQueryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;


import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import com.mediway.hos.srm.business.center.model.vo.user.UserExpertGroupVo;
import com.mediway.hos.srm.business.center.model.vo.user.UserVo;
import com.mediway.hos.srm.business.center.model.entity.user.SrmUser;
import com.mediway.hos.srm.business.center.service.user.SrmUserExpertService;
import com.mediway.hos.srm.business.center.mapper.user.SrmUserMapper;

@Service
public class SrmUserExpertServiceImpl extends BaseServiceImpl<SrmUserMapper, SrmUser> implements SrmUserExpertService {

    @Autowired
    private SrmUserMapper srmUserMapper;
    private String RowId;
    @Override
    @Transactional
    public String saveOrUpdateUserExpert(UserExpertDto userExpertDto) {
        List<UserDto> userExperts = userExpertDto.getUserExperts();

        List<SrmUser> userExpertList = new ArrayList<>();
        for (UserDto userDto : userExperts) {
            SrmUser srmUserExpert = new SrmUser();
            srmUserExpert.setIsExpert(userDto.getIsExpert());
            userExpertList.add(srmUserExpert);
            RowId = srmUserExpert.getId().toString();
        }
        super.saveOrUpdateBatch(userExpertList);
        return RowId;
    }

    @Override
    public UserVo getDetailUserExpert(Long RowId) {
        return null;
    }

    @Override
    public IPage<UserVo> listUserExpert(UserExpertQueryDto userExpertQueryDto) {
        Page<UserVo> page = new Page<>(userExpertQueryDto.getPage(), userExpertQueryDto.getRows());
        IPage<UserVo> res= srmUserMapper.listUserExpert(page, userExpertQueryDto);
        return res;
    }

    @Override
    public void deleteUserExpert(BaseDto baseDto) {
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
    public Long setAuthExpertGrp(BaseDto baseDto){
        String userId=baseDto.getUserId();
        Long expertGrpId=baseDto.getId();
        Long exists=srmUserMapper.ifUserInExpertGroup(userId,expertGrpId);
        Long res=null;

        if (exists!=null) {
            try {
                res = srmUserMapper.setAuthExpertGrp(userId, expertGrpId);
            }catch (Exception exception){
                throw  new ErrorException("-200",exception.getMessage());
            }
        }
        return res;
    }

    @Override
    public Long cancelAuthExpertGrp(BaseDto baseDto){
        String userId=baseDto.getUserId();
        Long expertGrpId=baseDto.getId();
        Long RowId=srmUserMapper.ifUserInExpertGroup(userId,expertGrpId);
        Long res=null;

        if (RowId!=null) {
            try {
                res = srmUserMapper.cancelAuthExpertGrp(RowId);
            }catch (Exception exception){
                throw  new ErrorException("-200",exception.getMessage());
            }
        }
        return res;
    }

    @Override
    public IPage<UserExpertGroupVo> listUserInExpertGroup(BaseDto baseDto){
        HosUser hosUser = SecurityUtils.getLoginUser();
        String userCode = hosUser.getAccountCode();
        //System.out.println(userCode);
        Page<UserExpertGroupVo> page = new Page<>(baseDto.getPage(), baseDto.getRows());

        IPage<UserExpertGroupVo> res= srmUserMapper.listUserInExpertGroup(page,userCode);
        return res;
    };

    @Override
    public IPage<UserExpertGroupVo> listUserNotInExpertGroup(BaseDto baseDto){
        HosUser hosUser = SecurityUtils.getLoginUser();
        String userCode = hosUser.getAccountCode();
        Page<UserExpertGroupVo> page = new Page<>(baseDto.getPage(), baseDto.getRows());
        IPage<UserExpertGroupVo> res= srmUserMapper.listUserNotInExpertGroup(page,userCode);
        return res;
    };

    @Override
    public IPage<UserVo> selectUserForExpert(UserExpertQueryDto userExpertQueryDto){
        Page<UserVo> page = new Page<>(userExpertQueryDto.getPage(), userExpertQueryDto.getRows());
        IPage<UserVo> res= srmUserMapper.selectUserForExpert(page,userExpertQueryDto);
        return res;
    };

    @Override
    public String submitExpert(UserExpertDto userExpertDto){
        List<UserDto> usersForExperts=userExpertDto.getUsersForExperts();
        List<ExpertGroupDto> expertGroups=userExpertDto.getExpertGroups();

//        Long RowId=null;
        try {
            for (UserDto userDto : usersForExperts) {
                String userCode = userDto.getCode() ;  // user
                for (ExpertGroupDto expertGroupDto : expertGroups) {
                    String expertGroup = expertGroupDto.getCode();  // group
//                    System.out.println(userCode);
//                    System.out.println(expertGroup);
                    Long RowId=srmUserMapper.ifExistUserExpert(userCode, expertGroup);
                    if (RowId==null)   {
                        srmUserMapper.submitExpert(userCode, expertGroup);
                    }
                }
            }
        }catch (Exception exception){
            throw  new ErrorException("-200",exception.getMessage());
        }
        return RowId;
    };

}
