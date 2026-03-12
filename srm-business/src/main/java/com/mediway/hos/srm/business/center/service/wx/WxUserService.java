package com.mediway.hos.srm.business.center.service.wx;

import com.alibaba.fastjson.JSONObject;

public interface WxUserService {

    public String getAccessToken();

    public String getUserIdByCode(String code);

    public JSONObject getUserDetail(String userId);
}
