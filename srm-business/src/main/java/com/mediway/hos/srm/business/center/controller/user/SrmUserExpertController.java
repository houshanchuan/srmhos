package com.mediway.hos.srm.business.center.controller.user;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;

import com.mediway.hos.srm.business.center.model.dto.user.UserExpertDto;
import com.mediway.hos.srm.business.center.model.dto.user.UserExpertQueryDto;
import com.mediway.hos.srm.business.center.model.vo.user.UserExpertGroupVo;
import com.mediway.hos.srm.business.center.model.vo.user.UserVo;
import com.mediway.hos.srm.business.center.service.user.SrmUserExpertService;

@RestController
@RequestMapping("srm/userExpert")
@Api(tags = "专家")
public class SrmUserExpertController {

    @Autowired
    private SrmUserExpertService srmUserExpertService;

    @PostMapping({"/saveOrUpdateUserExpert"})
    public BaseResponse saveOrUpdateUserExpert(@RequestBody UserExpertDto userExpertDto) {
        String RowId = srmUserExpertService.saveOrUpdateUserExpert(userExpertDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailUserExpert(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        UserVo userExpertVo = srmUserExpertService.getDetailUserExpert(RowId);
        return BaseResponse.success(userExpertVo);
    }

    @PostMapping({"/listUserExpert"})
    public BaseResponse listUserExpert(@RequestBody UserExpertQueryDto userExpertQueryDto) {
        //System.out.println(userExpertQueryDto);
        IPage<UserVo> list = srmUserExpertService.listUserExpert(userExpertQueryDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteUserExpert"})
    public BaseResponse deleteUserExpert(@RequestBody BaseDto baseDto) {
        srmUserExpertService.deleteUserExpert(baseDto);
        return BaseResponse.success("删除成功!");

    }

    @PostMapping({"/setAuthExpertGrp"})
    public BaseResponse setAuthExpertGrp(@RequestBody BaseDto baseDto){
        srmUserExpertService.setAuthExpertGrp(baseDto);
        return BaseResponse.success("设置专家组成功!");

    }

    @PostMapping({"/cancelAuthExpertGrp"})
    public BaseResponse cancelAuthExpertGrp(@RequestBody BaseDto baseDto){
        srmUserExpertService.cancelAuthExpertGrp(baseDto);
        return BaseResponse.success("设置专家组成功!");
    }

    @PostMapping({"/listUserInExpertGroup"})
    public BaseResponse listUserInExpertGroup(@RequestBody BaseDto baseDto) {
        IPage<UserExpertGroupVo> list =srmUserExpertService.listUserInExpertGroup(baseDto);
        return BaseResponse.success(list);
    }

    @PostMapping({"/listUserNotInExpertGroup"})
    public BaseResponse listUserNotInExpertGroup(@RequestBody BaseDto baseDto) {
        IPage<UserExpertGroupVo> list =srmUserExpertService.listUserNotInExpertGroup(baseDto);
        return BaseResponse.success(list);
    }

    // 遴选专家
    @PostMapping({"/selectUserForExpert"})
    public BaseResponse selectUserForExpert(@RequestBody UserExpertQueryDto userExpertQueryDto) {
        //System.out.println(userExpertQueryDto.getPUserType());
        IPage<UserVo> list = srmUserExpertService.selectUserForExpert(userExpertQueryDto);
        return BaseResponse.success(list);

    }

    //提交专家
    @PostMapping({"/submitExpert"})
    public BaseResponse submitExpert(@RequestBody UserExpertDto userExpertDto){
        String RowId=srmUserExpertService.submitExpert(userExpertDto);
        return BaseResponse.success("专家提交成功!");
    }


}
