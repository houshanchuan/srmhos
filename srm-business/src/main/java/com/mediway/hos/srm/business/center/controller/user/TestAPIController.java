package com.mediway.hos.srm.business.center.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.mediway.hos.base.model.BaseResponse;
import com.mediway.hos.log.annotation.OperLog;
import com.mediway.hos.openapi.aop.OpenApi;
import com.mediway.hos.security.annotation.InterfaceRebrush;
import com.mediway.hos.srm.business.center.model.dto.user.UserExpertDto;
import com.mediway.hos.srm.business.center.model.entity.user.SrmUser;
import com.mediway.hos.srm.business.center.service.user.SrmUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"${sys.restfulPath}/test"})
@Api(
        tags = {"API测试"}
)
public class TestAPIController {
    @Autowired
    private SrmUserService srmUserService;

    @ApiOperation("测试")
    @PostMapping(
            value = {"/hello"},
            produces = {"application/json;charset=utf-8"}
    )
    @OpenApi(
            code = "listUser"
    )
    @OperLog(
            title = "api测试",
            content = "用户列表"
    )
    @InterfaceRebrush
    public BaseResponse<String> listUser(@RequestBody UserExpertDto data) {
        List <SrmUser> allData = this.srmUserService.list();
        String r=JSONObject.toJSONString(allData);
        return new BaseResponse("100" + "", "api测试成功", r);
    }
}
