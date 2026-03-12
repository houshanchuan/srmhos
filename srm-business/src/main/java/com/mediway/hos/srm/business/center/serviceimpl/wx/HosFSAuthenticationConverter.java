package com.mediway.hos.srm.business.center.serviceimpl.wx;

import com.mediway.hos.security.core.HosLoginParameterNames;
import com.mediway.hos.security.core.util.JsonUtils;
import com.mediway.hos.security.core.util.SecurityUtil;
import com.mediway.hos.security.login.authorization.convert.AbstractHosAuthenticationConverter;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
public class HosFSAuthenticationConverter  extends AbstractHosAuthenticationConverter {

    @Override
    public Authentication convert(HttpServletRequest request) {
        String grantType = request.getParameter(HosLoginParameterNames.GRANT_TYPE);
        //替换FSToken为自定义的登录方式标识
        if (!"FSToken".equals(grantType)) {
            return null;
        }
        try {
            //替换HosFSLoginParam为自定义登录参数类
            HosFSLoginParam smsLoginParam = JsonUtils.getInstance().readValue(request.getInputStream(), HosFSLoginParam.class);
            smsLoginParam.setHosGrantType(grantType);
            //替换HosFSAuthenticationToken为自定义登录方式类
            HosFSAuthenticationToken fsAuthenticationToken = new HosFSAuthenticationToken(smsLoginParam);
            return fsAuthenticationToken;
        } catch (IOException e) {
            logger.error("统一开放服务集成平台系统登录参数解析错误", e);
            //自定义错误编码、错误描述
            SecurityUtil.throwError("101-002-004-012", "统一开放服务集成平台系统登录参数解析错误");
        }
        return null;
    }
}
