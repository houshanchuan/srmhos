package com.mediway.hos.srm.business.center.service.user;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;

import com.mediway.hos.srm.business.center.model.dto.user.UserExpertQueryDto;

import com.mediway.hos.srm.business.center.model.dto.user.UserExpertDto;
import com.mediway.hos.srm.business.center.model.vo.user.UserExpertGroupVo;
import com.mediway.hos.srm.business.center.model.vo.user.UserVo;


public interface SrmUserExpertService {
    @Transactional
    String saveOrUpdateUserExpert(UserExpertDto userExpertDto);

    UserVo getDetailUserExpert(Long RowId);

    IPage<UserVo> listUserExpert(UserExpertQueryDto userExpertQueryDto);

    void deleteUserExpert(BaseDto baseDto);

    Long setAuthExpertGrp(BaseDto baseDto);

    Long cancelAuthExpertGrp(BaseDto baseDto);

    IPage<UserExpertGroupVo> listUserInExpertGroup(BaseDto baseDto);

    IPage<UserExpertGroupVo> listUserNotInExpertGroup(BaseDto baseDto);

    IPage<UserVo> selectUserForExpert(UserExpertQueryDto userExpertQueryDto);

    String submitExpert(UserExpertDto userExpertDto);
}
