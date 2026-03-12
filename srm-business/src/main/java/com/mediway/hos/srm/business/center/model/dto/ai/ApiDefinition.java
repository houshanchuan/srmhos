package com.mediway.hos.srm.business.center.model.dto.ai;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// ApiDefinition.java
public class ApiDefinition {
    private String name;
    private String description;
    public Map<String, String> params;
    public Map<String, Map<String, String>> dictParams;


    // 构造器
    public ApiDefinition(String name, String description) {
        this.name = name;
        this.description = description;
        this.params = new LinkedHashMap<>();
        this.dictParams = new HashMap<>();
    }

    public ApiDefinition param(String name, String desc) {
        this.params.put(name, desc);
        return this;
    }

    // 参数的字典映射，如 gender → {男:1, 女:2}
    public ApiDefinition dictParam(String paramName, Map<String,String> dict) {
        this.dictParams.put(paramName, dict);
        return this;
    }

    // 生成该 API 的说明文本
    public String toPromptString() {
        StringBuilder sb = new StringBuilder();
        sb.append("- ").append(name).append(" - ").append(description).append("\n");
        sb.append("  参数：");
        for (String paramName : params.keySet()) {
            sb.append(paramName);
            if (dictParams.containsKey(paramName)) {
                sb.append("(ID)");
            }
            sb.append(", ");
        }
        if (!params.isEmpty()) {
            sb.setLength(sb.length() - 2); // 去掉最后的 ", "
        }
        sb.append(",其他不支持的参数也要输出\n");

        // 添加字典说明
        for (Map.Entry<String, Map<String, String>> entry : dictParams.entrySet()) {
            sb.append("  ").append(entry.getKey()).append(" 可选值：")
                    .append(formatDict(entry.getValue())).append("\n");
        }
        return sb.toString();
    }

    private String formatDict(Map<String, String> dict) {
        return dict.entrySet().stream()
                .map(e -> e.getKey() + "→" + e.getValue())
                .collect(Collectors.joining("， "));
    }

    // getter
    public String getName() { return name; }
    public Map<String, String> getDict(String paramName) {
        return dictParams.get(paramName);
    }
    public Map<String, String> getParams() { return params; }
}