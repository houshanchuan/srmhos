package com.mediway.hos.srm.business.center.service.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.srm.business.center.model.dto.user.UserDto;
import com.mediway.hos.srm.business.center.model.entity.user.SrmUser;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.vo.user.UserVo;

import java.util.List;

/**
 * <p>
 * 科研人员库 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-24
 */
public interface SrmUserService extends BaseService<SrmUser> {
    List<CombVo> getUser(UserDto userDto);
    List<String> getUserNamesByIds(List<String> ids);

    Long getUserIdByAccount(String account);
    UserVo getUserDetail(String id,String code);
    String saveUser(UserDto userDto);
    UserVo getDetail(String RowId);

    IPage<UserVo> listUser(UserDto userDto);
    IPage<UserVo> listAuditUser(UserDto userDto);

    Long auditUserYes(UserDto userDto);
    Long auditUserNo(UserDto userDto);

    List<CombVo> getTutor();
}
