package com.mediway.hos.srm.business.center.service.ai;

import org.springframework.web.multipart.MultipartFile;

public interface ResearchAssistantService {

    public String answerQuestion(String userQuestion,String sessionId);

}
