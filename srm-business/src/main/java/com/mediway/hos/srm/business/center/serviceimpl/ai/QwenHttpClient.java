package com.mediway.hos.srm.business.center.serviceimpl.ai;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class QwenHttpClient {
    @Value("${qwen.api.url}")
    private  String apiUrl;

    @Value("${qwen.api.key}")
    private  String apiKey;



    public  String askQwen(String model, List<Map<String,String>> messages, String sessionId)throws Exception {
        // 构建请求体
        JSONObject requestObj = new JSONObject();
        requestObj.put("model", model);
        JSONObject inputObj = new JSONObject();
        inputObj.put("messages", messages);
        requestObj.put("input", inputObj);

        // 添加 session_id（服务端优化）
        JSONObject params = new JSONObject();
        params.put("session_id", sessionId);
        requestObj.put("parameters", params);

        String jsonBody = requestObj.toJSONString();
// 创建一个带超时设置的 OkHttpClient
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)   // 连接超时
                .readTimeout(60, TimeUnit.SECONDS)     // 读取超时（最关键！模型响应慢）
                .writeTimeout(30, TimeUnit.SECONDS)    // 写入超时
                .build();
        // 创建请求
        RequestBody body = RequestBody.create(jsonBody, MediaType.get("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url(apiUrl)
                .post(body)
                .addHeader("Authorization", "Bearer " + apiKey)
                .addHeader("Content-Type", "application/json")
                .build();

        // 发送请求
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("HTTP error! status: " + response.code() + ", body: " + response.body().string());
            }

            String responseBody = response.body().string();
            JSONObject result = JSON.parseObject(responseBody);
            // 检查是否成功
            if (result.containsKey("output")) {
                String reply = result.getJSONObject("output").getString("text");
                return reply;
            } else {
                throw new RuntimeException("Qwen API error: " + responseBody);
            }
        }

    }
    public  String askTYQwen(String prompt) {
        String model="qwen-max";
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)   // 连接超时
                .readTimeout(60, TimeUnit.SECONDS)     // 读取超时（最关键！模型响应慢）
                .writeTimeout(30, TimeUnit.SECONDS)    // 写入超时
                .build();
        try {
            JsonArray messages = new JsonArray();
            JsonObject userMessage = new JsonObject();
            userMessage.addProperty("role", "user");
            userMessage.addProperty("content", prompt);
            messages.add(userMessage);

            JsonObject input = new JsonObject();
            input.add("messages", messages);

            JsonObject parameters = new JsonObject();
            parameters.addProperty("result_format", "message");

            JsonObject requestBody = new JsonObject();
            requestBody.addProperty("model", model);
            requestBody.add("input", input);
            requestBody.add("parameters", parameters);

            Request request = new Request.Builder()
                    .url(apiUrl)
                    .addHeader("Authorization", "Bearer " + apiKey)
                    .addHeader("Content-Type", "application/json")
                    .post(RequestBody.create(requestBody.toString(), MediaType.get("application/json")))
                    .build();

            try (okhttp3.Response response = client.newCall(request).execute()) {
                if (!response.isSuccessful() || response.body() == null) {
                    return "HTTP " + response.code() + ": " + (response.message() != null ? response.message() : "");
                }
                String responseBody = response.body().string();
                JsonObject json = JsonParser.parseString(responseBody).getAsJsonObject();

                // ✅ 关键：正确提取 content
                if (json.has("output") &&
                        json.getAsJsonObject("output").has("choices") &&
                        json.getAsJsonObject("output").getAsJsonArray("choices").size() > 0) {

                    JsonObject choice = json.getAsJsonObject("output").getAsJsonArray("choices").get(0).getAsJsonObject();
                    if (choice.has("message") &&
                            choice.getAsJsonObject("message").has("content")) {
                        return choice.getAsJsonObject("message").get("content").getAsString();
                    }
                }

                return "❌ 无法提取 AI 内容，响应：" + responseBody;

            }
        } catch (Exception e) {
            return "请求异常：" + e.getMessage();
        }
    }

}