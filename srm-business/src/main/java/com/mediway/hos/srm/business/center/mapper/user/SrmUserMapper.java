package com.mediway.hos.srm.business.center.mapper.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.dto.user.UserDto;
import com.mediway.hos.srm.business.center.model.dto.user.UserExpertQueryDto;
import com.mediway.hos.srm.business.center.model.entity.user.SrmUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.vo.user.UserExpertGroupVo;
import com.mediway.hos.srm.business.center.model.vo.user.UserVo;

import java.util.List;

/**
 * <p>
 * 科研人员库 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-24
 */
public interface SrmUserMapper extends BaseMapper<SrmUser> {
    List<CombVo> getUser(@Param("userDto") UserDto userDto);

    List<String> getUserNamesByIds(@Param("ids") List<String> ids);

    Long getUserIdByAccount(@Param("account") String account);

    UserVo getUserDetail(@Param("id") String id,@Param("code") String code);

    UserVo getDetail(@Param("RowId") String RowId);

    IPage<UserVo> listUser(@Param("page") Page<UserVo> page, @Param("userDto") UserDto userDto);

    IPage<UserVo> listAuditUser(@Param("page") Page<UserVo> page, @Param("userDto") UserDto userDto);

    IPage<UserVo> listUserExpert(@Param("page") Page<UserVo> page, @Param("userExpertQueryDto") UserExpertQueryDto userExpertQueryDto);

    Long ifUserInExpertGroup(@Param("userId") String userId,@Param("expertGrpId") Long expertGrpId);

    Long setAuthExpertGrp(@Param("userId") String userId,@Param("expertGrpId") Long expertGrpId);

    Long cancelAuthExpertGrp(@Param("RowId") Long RowId);

    IPage<UserExpertGroupVo> listUserInExpertGroup(@Param("page") Page<UserExpertGroupVo> page,@Param("userCode") String userCode);

    IPage<UserExpertGroupVo> listUserNotInExpertGroup(@Param("page") Page<UserExpertGroupVo> page,@Param("userCode") String userCode);

    IPage<UserVo> selectUserForExpert(@Param("page") Page<UserVo> page, @Param("userExpertQueryDto") UserExpertQueryDto userExpertQueryDto);

    Long ifExistUserExpert(@Param("userCode") String userCode,@Param("expertGroup")  String expertGroup) ;

    Long  submitExpert(@Param("userCode") String userCode,@Param("expertGroup")  String expertGroup);


    Long auditUserChkStatus(@Param("rowId") String rowId, @Param("status") String status);

    List<CombVo> getTutor();
}
