package com.mediway.hos.srm.business.center.controller.ai;

import com.mediway.hos.app.core.util.SecurityUtils;
import com.mediway.hos.security.core.userdetails.HosUser;
import com.mediway.hos.srm.business.center.model.dto.ai.QuestionDto;
import com.mediway.hos.srm.business.center.service.ai.ResearchAssistantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("srm/ai")

public class ResearchAssistantController {

    @Autowired
    private ResearchAssistantService researchAssistantService;
    @PostMapping("/ask")
    public ResponseEntity<Map<String, String>> ask(@RequestParam String question) {
        try {
            if (question == null || question.trim().isEmpty()) {
                return badRequest("问题不能为空");
            }
            HosUser user = SecurityUtils.getLoginUser();
            String answer = researchAssistantService.answerQuestion(question,user.getAccountCode());
            Map<String, String> result = new HashMap<>();
            result.put("answer", answer);
            return ResponseEntity.ok(result);

        } catch (Exception e) {
            return badRequest("处理失败：" + e.getMessage());
        }
    }

    private ResponseEntity<Map<String, String>> badRequest(String msg) {
        Map<String, String> error = new HashMap<>();
        error.put("error", msg);
        return ResponseEntity.badRequest().body(error);
    }
}