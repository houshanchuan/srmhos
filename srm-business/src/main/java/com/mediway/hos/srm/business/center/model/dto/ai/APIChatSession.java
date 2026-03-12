package com.mediway.hos.srm.business.center.model.dto.ai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class APIChatSession {

    private String sessionId;
    private final List<Map<String, String>> messages;
    private static final int MAX_HISTORY = 5; // 最多保留 10 轮对话（user + assistant）

    public String prompt=null;
    // 支持传入自定义 system prompt
    public APIChatSession(String sessionId, String systemPrompt) {
        this.prompt=systemPrompt;
        this.sessionId = sessionId;
        this.messages = new ArrayList<>();
        if (systemPrompt != null && !systemPrompt.trim().isEmpty()) {
            addMessage("system", systemPrompt.trim());
        }
    }
    public APIChatSession(String sessionId) {
        this.sessionId = sessionId;
        this.messages = new ArrayList<>();
        // 设置 AI 人设
        addMessage("system", "你是一个专业、友好的AI助手，回答要简洁准确。");
    }

    public void addUserMessage(String content) {
        addMessage("user", content);
    }
    public void removeLastMessage(){
        messages.remove(messages.size()-1);
    }
    public void addAssistantMessage(String content) {
        addMessage("assistant", content);
    }

    private void addMessage(String role, String content) {
        Map<String, String> msg = new HashMap<>();
        msg.put("role", role);
        msg.put("content", content);
        messages.add(msg);
        trimHistory();
    }

    private void trimHistory() {
        // 保留 system + 最近 MAX_HISTORY 条 user/assistant 消息
        int systemCount = 0;
        List<Map<String, String>> newList = new ArrayList<>();

        for (Map<String, String> msg : messages) {
            if ("system".equals(msg.get("role"))) {
                if (systemCount == 0) {
                    newList.add(msg);
                    systemCount++;
                }
            } else {
                newList.add(msg);
            }
        }

        // 只保留最后 MAX_HISTORY 条非 system 消息
        int size = newList.size();
        int startIndex = Math.max(1, size - MAX_HISTORY); // 保留 system
        List<Map<String, String>> trimmed = new ArrayList<>(newList.subList(0, 1));
        trimmed.addAll(newList.subList(startIndex, size));

        messages.clear();
        messages.addAll(trimmed);
    }

    public List<Map<String, String>> getMessages() {
        return new ArrayList<>(messages);
    }

    public String getSessionId() {
        return sessionId;
    }

    public void clear() {
        messages.clear();
        addMessage("system", prompt);
    }
}
