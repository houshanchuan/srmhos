package com.mediway.hos.srm.business.center.model.dto.ai;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 表示一次对话中的消息
 */
public class Message {
    private String role;      // "user" 或 "assistant"
    private String content;

    public Message() {}

    public Message(String role, String content) {
        this.role = role;
        this.content = content;
    }

    // Getters and Setters
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}
