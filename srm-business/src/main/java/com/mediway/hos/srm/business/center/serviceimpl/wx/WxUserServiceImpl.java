package com.mediway.hos.srm.business.center.serviceimpl.wx;

import com.alibaba.fastjson.JSONObject;
import com.mediway.hos.srm.business.center.service.wx.WxUserService;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class WxUserServiceImpl implements WxUserService {

    @Value("${qywechat.corpid}")
    private String corpid;

    @Value("${qywechat.corpsecret}")
    private String corpsecret;

    @Value("${qywechat.access-token-url}")
    private String accessTokenUrl;

    @Value("${qywechat.user-info-url}")
    private String userInfoUrl;

    @Value("${qywechat.user-detail-url}")
    private String userDetailUrl;

  //  @Resource
  //  private StringRedisTemplate redisTemplate;

    // Redis中access_token的缓存key
    private static final String ACCESS_TOKEN_KEY = "qywechat:access_token";

    public static Map<String, LocalDateTime> tokenMap=new HashMap<>();
    public String getMapToken() {
        String token=null;
        int size=tokenMap.keySet().size();
        if(size!=1)return null;
        token=tokenMap.keySet().iterator().next();
        LocalDateTime time=tokenMap.get(token);
        if(LocalDateTime.now().compareTo(time)<7000){
            token=null;
        }
        return token;
    }

    /**
     * 获取企业access_token（Redis缓存，7200秒过期，提前200秒刷新）
     */
    @Override
    public String getAccessToken() {
        // 1. 先从Redis获取
        String accessToken = getMapToken();
        if (accessToken != null) {
            return accessToken;
        }
        //String code="1LEC7q_srX0AvAN7xSbs_PVz1Ef2Iuhwq8HDjiX23AQ";
        // 2. 缓存未命中，调用企业微信接口获取
        String url = String.format("%s?corpid=%s&corpsecret=%s", accessTokenUrl, corpid, corpsecret);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        String response = null;
        try {
            response = EntityUtils.toString(httpClient.execute(httpGet).getEntity());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JSONObject json = JSONObject.parseObject(response);
        System.out.println("token="+json.toJSONString());
        try {
            // 3. 校验返回结果
            if (json.getIntValue("errcode") != 0) {
                throw new Exception("获取access_token失败：" + json.getString("errmsg"));
            }

            // 4. 存入Redis（有效期：7200-200=7000秒）
            accessToken = json.getString("access_token");
           // redisTemplate.opsForValue().set(ACCESS_TOKEN_KEY, accessToken, 7000, TimeUnit.SECONDS);
            tokenMap.put(accessToken,LocalDateTime.now());
            httpClient.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return accessToken;
    }

    /**
     * 用code换取用户userid
     */
    @Override
    public String getUserIdByCode(String code) {
        String accessToken =getAccessToken();
        String url = String.format("%s?access_token=%s&code=%s", userInfoUrl, accessToken, code);

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        String response =null;
        JSONObject json=null;
        try {
            response = EntityUtils.toString(httpClient.execute(httpGet).getEntity());
            json = JSONObject.parseObject(response);
            System.out.println("user="+json.toJSONString());
        if (json.getIntValue("errcode") != 0) {

                httpClient.close();
                throw new Exception("获取userid失败：" + json.getString("errmsg") + "，code：" + code);

        }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return json.getString("userid");
    }

    /**
     * 用userid换取用户详细信息（姓名、头像、手机号等）
     */
    @Override
    public JSONObject getUserDetail(String userId) {
        String accessToken = getAccessToken();
        String url = String.format("%s?access_token=%s&userid=%s", userDetailUrl, accessToken, userId);
        JSONObject json=null;
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            String response = EntityUtils.toString(httpClient.execute(httpGet).getEntity());
            json = JSONObject.parseObject(response);
            System.out.println("userDetail=" + json.toJSONString());
            if (json.getIntValue("errcode") != 0) {
                throw new Exception("获取用户详情失败：" + json.getString("errmsg"));
            }

            httpClient.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return json;
    }
}