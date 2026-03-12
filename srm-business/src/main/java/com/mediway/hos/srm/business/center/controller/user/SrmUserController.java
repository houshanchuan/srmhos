package com.mediway.hos.srm.business.center.controller.user;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseSrmDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.user.UserDto;
import io.swagger.annotations.Api;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.vo.user.UserVo;
import com.mediway.hos.srm.business.center.service.user.SrmUserService;

import java.util.List;

/**
 * <p>
 * 科研人员库
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-24
 */
@Slf4j
@RestController
@RequestMapping("srm/user")
@Api(tags = "科研人员库")
public class SrmUserController {
    @Autowired
    private SrmUserService srmUserService;
    @PostMapping({"/getUser"})
    public List<CombVo> getUser(UserDto userDto) {
        return srmUserService.getUser(userDto);
    }
    @PostMapping({"/getUserDetail"})
    public BaseResponse getUserDetail(@RequestBody UserDto userDto) {
        String userId=userDto.getRowId();
        UserVo userVo = srmUserService.getUserDetail(userId,null);
        return BaseResponse.success(userVo);
    }
    @PostMapping({"/saveUser"})
    public BaseResponse saveUser(@RequestBody UserDto userDto) {
        String RowId=null;
        try {
            RowId = srmUserService.saveUser(userDto);
            return BaseResponse.success(RowId);
        }catch (Exception e){
            log.error("新增用户错误",e);
            return BaseResponse.error("新增用户错误:"+e.getMessage());
        }

    }
    @PostMapping({"/getDetail"})
    public BaseResponse getDetail(@RequestBody BaseSrmDTO userDto) {
        String RowId=userDto.getId();

        UserVo userVo = null;
        try{
            userVo=srmUserService.getDetail(RowId);
            return BaseResponse.success(userVo);
        }catch (Exception e){
            log.error("获取用户信息错误,id="+RowId,e);
            return BaseResponse.success("获取用户信息错误,id="+RowId);
        }

    }

    @PostMapping({"/listUser"})
    public BaseResponse listUser(@RequestBody UserDto userDto) {
        IPage<UserVo> list = null;
        try {
            list = srmUserService.listUser(userDto);
            return BaseResponse.success(list);
        }catch (Exception e){
            log.error("用户查询错误",e);
            return BaseResponse.error(e.getMessage());
        }


    }
    @PostMapping({"/listAuditUser"})
    public BaseResponse listAuditUser(@RequestBody UserDto userDto) {
        IPage<UserVo> list = srmUserService.listAuditUser(userDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/auditUserYes"})
    public BaseResponse auditUserYes(@RequestBody UserDto userDto) {
        Long res = srmUserService.auditUserYes(userDto);
        return BaseResponse.success("成功审核"+res);
    }
    @PostMapping({"/auditUserNo"})
    public BaseResponse auditUserNo(@RequestBody UserDto userDto) {
        Long res = srmUserService.auditUserNo(userDto);
        return BaseResponse.success("成功审核"+res);
    }
}
