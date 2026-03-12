package com.mediway.hos.srm.business.center.controller.wx;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.mediway.hos.app.core.model.sys.entity.HosUserAccount;
import com.mediway.hos.app.core.service.sys.HosUserAccountService;
import com.mediway.hos.base.exception.SysExceptionEnum;
import com.mediway.hos.base.model.BaseResponse;
import com.mediway.hos.common.util.HttpUtil;
import com.mediway.hos.common.util.context.SpringContextUtils;
import com.mediway.hos.security.core.util.StringUtil;
import com.mediway.hos.security.properties.InterfaceEncryptionProperties;
import com.mediway.hos.security.utils.DecryptParamUtil;
import com.mediway.hos.srm.business.center.model.dto.user.UserDto;
import com.mediway.hos.srm.business.center.model.vo.user.UserVo;
import com.mediway.hos.srm.business.center.service.pubmed.SrmPubmedPaperService;
import com.mediway.hos.srm.business.center.service.wx.WxUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/srm/wx")
public class WxUserController {

    @Autowired
    private WxUserService wxUserService;
    @Autowired
    private SrmPubmedPaperService srmPubmedPaperService;
    @Autowired
    private HosUserAccountService hosUserAccountService;

    @PostMapping({"/getUserInfo"})
    public BaseResponse getUserDetail(String code) {
       // String userId=userDto.getRowId();
       // UserVo userVo = srmUserService.getUserDetail(userId,null);
        String accss_token=wxUserService.getAccessToken();
        System.out.println("token="+accss_token);
        String userId=wxUserService.getUserIdByCode(code);
        wxUserService.getUserDetail(userId);
        return BaseResponse.success(accss_token);
    }
    @PostMapping({"/getPaper"})
    public void getPaper() {
        srmPubmedPaperService.syncRecentArticles();
    }
    @PostMapping({"/login"})
    public BaseResponse login(String account) {
        log.info("mobileAuthLogin");
        //根据账号获取用户信息
        HosUserAccount hosUserAccount = hosUserAccountService.selectByCode(account);
        if (ObjectUtil.isEmpty(hosUserAccount)) {
            return BaseResponse.error("401", "未获取到用户信息");
        }
        InterfaceEncryptionProperties properties = SpringContextUtils.getBean(InterfaceEncryptionProperties.class);
        String pwd = null;
        try {
            pwd = DecryptParamUtil.decryptStrByType(properties.getDecryptType(), "187b5b7a08255aad6a1b6d0ce635bf21", properties.getSecret(), properties.getPublicKey(), properties.getPrivateKey());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        String authUrl="http://localhost:8367/security/token";


        Map<String, String> queryMap1 = new HashMap<>();
        queryMap1.put("grantType", "password");
        queryMap1.put("loginName", account);
        queryMap1.put("password", pwd);
        queryMap1.put("tenantId", "");
        queryMap1.put("isRecordLogin", "true");
        queryMap1.put("captchaCode", "");
        queryMap1.put("captchaUUID", "");
        queryMap1.put("selectRoleId", "");
        String result = HttpUtil.postForm(authUrl, queryMap1);
        if (StringUtil.isNotBlank(result)) {
            log.info("get authorize code info：" + result);
            JSONObject bodyJson = JSONObject.parseObject(result);
            if (!bodyJson.getString("code").equals("200")) {
                return BaseResponse.error("402", "用户名密码错误");
            } else {
                return BaseResponse.success(bodyJson);
            }
        } else {
            return BaseResponse.error("402", "用户名密码错误");
        }

    }
}
